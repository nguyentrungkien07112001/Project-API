package com.vti.ki4m.mapper;

import com.vti.ki4m.dto.TargetDTO;
import com.vti.ki4m.entity.Account;
import com.vti.ki4m.entity.Target;
import com.vti.ki4m.form.TargetIn;
import com.vti.ki4m.form.TargetUpdateIn;
import org.springframework.stereotype.Component;

@Component
public class TargetMapper {
    public TargetDTO map(Target target) {
        TargetDTO targetDTO = new TargetDTO();
        targetDTO.setId(target.getId());
        targetDTO.setName(target.getName());
        targetDTO.setCompletionRate(target.getCompletionRate());
        targetDTO.setImage(target.getImage());
//        targetDTO.setAccount(target.getAccount());
//        targetDTO.setCategory(target.getCategory());
        targetDTO.setDateCompleted(target.getDateCompleted());
        return targetDTO;
    }

    public Target map(TargetIn targetIn) {
        Target target = new Target();
        target.setName(targetIn.getName());
        target.setCompletionRate(targetIn.getCompletionRate());
        target.setImage(targetIn.getImage());
//        target.setAccount(targetIn.getAccount());
//        target.setCategory(targetIn.getCategory());
        target.setDateCompleted(targetIn.getDateCompleted());
        return target;
    }

    public Target map(TargetUpdateIn targetUpdateIn, Target target) {
        target.setName(targetUpdateIn.getName());
        target.setCompletionRate(targetUpdateIn.getCompletionRate());
        target.setImage(targetUpdateIn.getImage());
//        target.setAccount(targetUpdateIn.getAccount());
//        target.setCategory(targetUpdateIn.getCategory());
        target.setDateCompleted(targetUpdateIn.getDateCompleted());
        return target;
    }
}
