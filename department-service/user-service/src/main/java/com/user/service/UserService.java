package com.iitcw.user.service;

import com.iitcw.user.entity.User;
import com.iitcw.user.model.Department;
import com.iitcw.user.model.UserResponce;
import com.iitcw.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser UserService");
        return userRepository.save(user);
    }

    public UserResponce getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment UserService");
        UserResponce userResponce = new UserResponce();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://localhost:9001/departments/"
                + user.getDepartmentId(), Department.class);

        userResponce.setUser(user);
        userResponce.setDepartment(department);

        return userResponce;

    }
}
