package com.vti.ki4m.service.serviceImpl;

import com.vti.ki4m.dto.TargetDTO;
import com.vti.ki4m.entity.Target;
import com.vti.ki4m.form.TargetIn;
import com.vti.ki4m.form.TargetUpdateIn;
import com.vti.ki4m.mapper.TargetMapper;
import com.vti.ki4m.repository.ITargetRepository;
import com.vti.ki4m.service.ITargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TargetService implements ITargetService {

    @Autowired
    private ITargetRepository targetRepository;

    @Autowired
    private TargetMapper targetMapper;

    @Override
    public List<TargetDTO> findAllTargets() {
        List<Target> targets = targetRepository.findAll();
        List<TargetDTO> targetDTOS = targets.stream().map(it -> targetMapper.map(it)).collect(Collectors.toList());
        return targetDTOS;
    }

    @Override
    public TargetDTO findTarget(Integer id) {
        Target target = targetRepository.findTargetById(id);
        TargetDTO targetDTO = targetMapper.map(target);
        return targetDTO;
    }

    @Override
    public Target create(TargetIn targetIn) {
        Target target = targetMapper.map(targetIn);
        Target response = targetRepository.save(target);
        return response;
    }

    @Override
    public Target update(Integer id, TargetUpdateIn targetUpdateIn) {
        Target target = targetRepository.findTargetById(id);
        targetMapper.map(targetUpdateIn, target);
        Target response = targetRepository.save(target);
        return response;
    }

    @Override
    public void delete(Integer id) {
        Target target = targetRepository.findTargetById(id);
        targetRepository.delete(target);
    }
}
