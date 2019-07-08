package com.example.demo.service;

import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private AddressRepository addressRepository;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Integer addUser(User user) {
        userRepository.save(user);
        userRepository.flush();
        List<Address> addrs = user.getUserAddr();
        for(int i = 0;i<addrs.size();i++) {
            addrs.get(i).setUser(user);
            addressRepository.save(addrs.get(i));
            addressRepository.flush();
        }
        return user.getId();
    }

    @Override
    public User getSingleUser(Integer id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()==false) throw new UserNotFoundException();
        else return user.get();
    }

}
