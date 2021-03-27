package com.ljp.mapper;

import com.ljp.bean.UserSafe;
import com.ljp.bean.UserSafeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSafeMapper {
    long countByExample(UserSafeExample example);

    int deleteByExample(UserSafeExample example);

    int deleteByPrimaryKey(String userId);

    int insert(UserSafe record);

    int insertSelective(UserSafe record);

    List<UserSafe> selectByExample(UserSafeExample example);

    UserSafe selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserSafe record, @Param("example") UserSafeExample example);

    int updateByExample(@Param("record") UserSafe record, @Param("example") UserSafeExample example);

    int updateByPrimaryKeySelective(UserSafe record);

    int updateByPrimaryKey(UserSafe record);
}