package com.vti.ki4m.service;

import com.vti.ki4m.dto.TargetDTO;
import com.vti.ki4m.entity.Target;
import com.vti.ki4m.form.TargetIn;
import com.vti.ki4m.form.TargetUpdateIn;

import java.util.List;

public interface ITargetService {

    List<TargetDTO> findAllTargets();

    TargetDTO findTarget(Integer id);

    Target create (TargetIn targetIn);

    Target update (Integer id, TargetUpdateIn targetUpdateIn);

    void delete (Integer id);
}
