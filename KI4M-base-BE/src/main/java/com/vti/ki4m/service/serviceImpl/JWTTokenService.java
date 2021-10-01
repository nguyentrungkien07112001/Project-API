package com.vti.ki4m.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vti.ki4m.dto.LoginInforAccount;
import com.vti.ki4m.entity.Account;
import com.vti.ki4m.entity.AccountStatus;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

public class JWTTokenService {
    private static final long EXPIRATION_TIME = 864000000; // 10 days
    private static final String SECRET = "123456";
    private static final String PREFIX_TOKEN = "Bearer";
    private static final String AUTHORIZATION = "Authorization";

    public static void addJWTTokenAndAccountInforToBody(HttpServletResponse response, Account account) throws IOException {
        String JWT = Jwts.builder()
                .setSubject(account.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        response.addHeader(AUTHORIZATION, PREFIX_TOKEN + " " + JWT);

        // Convert account entity to acount dto
        LoginInforAccount accountDTO = new LoginInforAccount(
                account.getStatus().equals(AccountStatus.ACTIVE) ? JWT : null,
                account.getUsername(),
                account.getEmail(),
                account.getFullName(),
                account.getRole(),
                account.getStatus().toString()
        );

        // Convert object to json
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(accountDTO);

        // return json
        response.setContentType(("application/json;charset=UTF-8"));
        response.getWriter().write(json);

    }

    public static Authentication parseTokenToUserInformation(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION);

        if (token == null) {
            return null;
        }

        // parse the token
        String username = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(PREFIX_TOKEN, ""))
                .getBody()
                .getSubject();

        return username != null ?
                new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList()) :
                null;
    }

}
