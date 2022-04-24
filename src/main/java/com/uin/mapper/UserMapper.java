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
    List<User> getUserByUsername(@Param("username") String username);

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
    //List<User> queryUserByUser(Map<String, Object> map);

    /**
     * 多参数值传值2
     *
     * @param map
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/3/29 10:30 AM
     */
    List<User> queryUserByUser2(Map<Object, Object> map);

    /**
     * 根据roleid 查询所有用户的角色
     * 实现resultMap的高级映射：一对一
     *
     * @param roleId
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/4/12 9:00 AM
     */
    List<User> getUserListByRoleId(@Param("id") int roleId);

    /**
     * 根据用户的id查询多个地址
     *
     * @param user_id
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/4/12 9:43 AM
     */
    List<User> getAddressListByUserId(@Param("id") int user_id);

    /**
     * @param roleIds array
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/4/19 4:27 PM
     */
    List<User> getUserByRoleIdsArray(@Param("ids") Integer[] roleIds);//array、list、map

    /**
     * list
     *
     * @param roleIds
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/4/19 4:45 PM
     */
    List<User> getUserByRoleIdsList(@Param("ids") List<Integer> roleIds);//list、map

    /**
     * map
     *
     * @param map
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/4/19 4:44 PM
     */
    List<User> getUserByRoleIdsMap(Map<String, Object> map);//list、map roleIds

    /**
     * 查询用户列表并实现分页
     * limit 0,5
     * 查询出来的行
     * 0，1，2，3，4
     * @param userName
     * @param roleId
     * @param from
     * @param size
     * @return java.util.List<com.uin.pojo.User>
     * @author wanglufei
     * @date 2022/4/19 5:15 PM
     */
    List<User> getUserListByPage(@Param("userName") String userName,
                                 @Param("roleId") Integer roleId,
                                 @Param("from") Integer from,
                                 @Param("size") Integer size);
}
