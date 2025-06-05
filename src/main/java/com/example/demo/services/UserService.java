package com.example.demo.services;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    UserDTO Create(UserDTO user);
    UserDTO findById(Long id);
    List<UserDTO> getAll();
    UserDTO update(Long id, UserDTO userDTO);
    void delete(Long id);
}
