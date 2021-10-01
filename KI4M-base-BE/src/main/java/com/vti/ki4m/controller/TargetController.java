package com.vti.ki4m.controller;

import com.vti.ki4m.dto.TargetDTO;
import com.vti.ki4m.form.TargetIn;
import com.vti.ki4m.form.TargetUpdateIn;
import com.vti.ki4m.service.ITargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/targets")
public class TargetController {

    @Autowired
    private ITargetService targetService;

    @GetMapping("/getAll")
    public ResponseEntity<?> findAllTargets() {
        List<TargetDTO> targetDTOS = targetService.findAllTargets();
        return new ResponseEntity<>(targetDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTarget(@PathVariable Integer id) {
        TargetDTO targetDTO = targetService.findTarget(id);
        return new ResponseEntity<>(targetDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TargetIn targetIn) {
        return new ResponseEntity<>(targetService.create(targetIn), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody TargetUpdateIn targetUpdateIn) {
        return new ResponseEntity<>(targetService.update(id, targetUpdateIn), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        targetService.delete(id);
        return new ResponseEntity<>("Delete success!!!", HttpStatus.OK);
    }
}
