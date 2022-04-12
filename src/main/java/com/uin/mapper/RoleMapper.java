package com.uin.mapper;

import com.uin.pojo.Provider;
import com.uin.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/24/3:39 PM
 */
public interface RoleMapper {
    /**
     * 查询全部角色
     *
     * @return java.util.List<com.uin.pojo.Role>
     * @author wanglufei
     * @date 2022/3/29 8:54 AM
     */
    List<Role> queryAllRole();


    /**
     * add
     *
     * @param role
     * @return int
     * @author wanglufei
     * @date 2022/4/12 11:31 AM
     */
    int addRole(Role role);

    /**
     * update
     *
     * @param role
     * @return int
     * @author wanglufei
     * @date 2022/4/12 11:31 AM
     */
    int updateRole(Role role);

    /**
     * delete
     * @author wanglufei
     * @date 2022/4/12 11:31 AM
     * @param id
     * @return int
     */
    int deleteById(@Param("id") int id);
}
