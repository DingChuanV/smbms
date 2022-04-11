package com.uin.mapper;

import com.uin.pojo.User;
import com.uin.vo.UserSearchVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/15/5:13 PM
 */
public interface UserMapper {
    /**
     * 删除用户
     *
     * @param id
     * @return int
     * @author wanglufei
     * @date 2022/4/2 12:05 PM
     */
    int deleteUserById(@Param("id") Long id);

    /**
     * 修改用户密码
     *
     * @return int
     * @author wanglufei
     * @date 2022/4/2 11:59 AM
     */
    int updatePwd(@Param("id") Long id, @Param("userPassword") String pwd);

    /**
     * 修改用户
     *
     * @param user
     * @return int
     * @author wanglufei
     * @date 2022/4/2 11:27 AM
     */
    int updateUser(User user);

    /**
     * 增加用户
     *
     * @param user
     * @return int
     * @author wanglufei
     * @date 2022/4/2 12:04 PM
     */
    int addUser(User user);

    /**
     * 查询全部的用户
     *
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/3/29 8:53 AM
     */
    List<User> queryAllUser();

    /**
     * 查询全部用户并显示用户的角色
     *
     * @param user
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/4/2 10:23 AM
     */
    List<User> queryAllUserShowRole(User user);

    /**
     * 模糊查询 根据username查询用户
     *
     * @param username
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/3/29 8:53 AM
     */
    List<User> getUserByUsername(@Param("userName") String username);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return com.uin.pojo.User
     * @author wanglufei
     * @date 2022/3/29 8:53 AM
     */
    User queryUserById(@Param("id") Long id);

    /**
     * vo对象
     *
     * @param userSearchVo
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/3/29 10:29 AM
     */
    List<User> queryUserVO(@Param("userVo") UserSearchVo userSearchVo);

    /**
     * 根据用户的username 查询用户的角色
     *
     * @return com.uin.pojo.User
     * @author wanglufei
     * @date 2022/3/29 10:42 AM
     */
    User queryRoleByUserName(UserSearchVo userSearchVo);


    /**
     * 多参数传值1
     *
     * @param map
     * @return com.uin.pojo.User
     * @author wanglufei
     * @date 2022/3/29 9:09 AM
     */
    List<User> queryUserByUser(Map<Object, Object> map);

    /**
     * 多参数值传值2
     *
     * @param map
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/3/29 10:30 AM
     */
    List<User> queryUserByUser2(Map<Object, Object> map);
}
