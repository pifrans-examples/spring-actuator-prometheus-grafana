package com.pifrans.springactuatorprometheusgrafana.business;


import com.pifrans.springactuatorprometheusgrafana.domains.dtos.UserDTO;
import com.pifrans.springactuatorprometheusgrafana.domains.entities.User;
import com.pifrans.springactuatorprometheusgrafana.repositories.UserRepository;
import com.pifrans.springactuatorprometheusgrafana.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO.All findById(Long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("Não encontrado!"));
        return modelMapper.map(user, UserDTO.All.class);
    }

    @Override
    public List<UserDTO.All> findAll() {
        final List<User> list = userRepository.findAll();
        return list.stream().map(user -> modelMapper.map(user, UserDTO.All.class)).toList();
    }

    @Override
    public UserDTO.All save(UserDTO.Save object) {
        final User map = modelMapper.map(object, User.class);
        final User userSaved = userRepository.save(map);
        return modelMapper.map(userSaved, UserDTO.All.class);
    }

    @Override
    public List<UserDTO.All> saveAll(List<UserDTO.Save> list) {
        final List<User> users = list.stream().map(dto -> modelMapper.map(dto, User.class)).toList();
        final List<User> usersSaved = userRepository.saveAll(users);
        return usersSaved.stream().map(user -> modelMapper.map(user, UserDTO.All.class)).toList();
    }
}
