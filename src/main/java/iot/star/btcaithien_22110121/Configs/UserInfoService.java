package iot.star.btcaithien_22110121.Configs;

import iot.star.btcaithien_22110121.Entity.UserInfo;
import iot.star.btcaithien_22110121.Repository.UserInforRepository;
import iot.star.btcaithien_22110121.Services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    UserInforRepository userInforRepository;

    public UserInfoService(UserInforRepository userInforRepository) {
        this.userInforRepository = userInforRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInforRepository.findByName(username);
        return userInfo.map(UserInfoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found: "+username));
    }
}
