package com.thyleaf.seven.resporister;

import com.thyleaf.seven.domain.User;

import java.util.List;

public interface UserResposity {
    /**
     * 创建或者修改用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(long id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(long id);

    /**
     * 获取用户列表
     * @return
     */
    List<User> getUsers();


}
