package org.bigdatahealth.service.impl;

import org.bigdatahealth.domain.User;
import org.bigdatahealth.mapper.UserMapper;
import org.bigdatahealth.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HelloServiceImpl implements HelloService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUserList() {
        List<User> userList = userMapper.selectAll();
        return userList;
    }
}
