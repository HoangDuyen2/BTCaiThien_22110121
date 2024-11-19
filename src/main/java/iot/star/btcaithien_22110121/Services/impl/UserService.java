package iot.star.btcaithien_22110121.Services.impl;

import iot.star.btcaithien_22110121.Entity.UserInfo;
import iot.star.btcaithien_22110121.Repository.UserInforRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record UserService(UserInforRepository repository, PasswordEncoder passwordEncoder) {
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "Complete new user";
    }
}
