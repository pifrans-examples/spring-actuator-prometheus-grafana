package com.pifrans.springactuatorprometheusgrafana.services;


import com.pifrans.springactuatorprometheusgrafana.domains.dtos.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDTO.All findById(Long id);

    List<UserDTO.All> findAll();

    UserDTO.All save(UserDTO.Save object);

    List<UserDTO.All> saveAll(List<UserDTO.Save> list);
}
