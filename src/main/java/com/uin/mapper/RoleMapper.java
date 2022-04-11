package com.uin.mapper;

import com.uin.pojo.Role;

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
}
