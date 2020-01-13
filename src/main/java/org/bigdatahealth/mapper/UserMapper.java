package org.bigdatahealth.mapper;

import java.util.List;
import org.bigdatahealth.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    User selectByPrimaryKey(Long userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}