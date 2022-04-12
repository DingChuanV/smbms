package com.uin.mapper;

import java.time.LocalDateTime;

import com.uin.pojo.Role;
import com.uin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/12/11:49 AM
 */
public class RoleMapperTest {
    /**
     * query
     *
     * @author wanglufei
     * @date 2022/4/12 11:56 AM
     */
    @Test
    public void queryAllRoleTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roles = mapper.queryAllRole();
        System.out.println(roles);
        sqlSession.close();
    }

    /**
     * add
     *
     * @author wanglufei
     * @date 2022/4/12 11:57 AM
     */
    @Test
    public void add() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = new Role();
        role.setRoleCode("test");
        role.setRoleName("test");
        role.setCreatedBy(1L);
        role.setCreationDate(LocalDateTime.now());
        role.setModifyBy(1L);
        role.setModifyDate(LocalDateTime.now());
        int i = mapper.addRole(role);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("add ok");
            sqlSession.close();
        } else
            sqlSession.close();

    }

    /**
     * update
     *
     * @author wanglufei
     * @date 2022/4/12 11:57 AM
     */
    @Test
    public void update() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = new Role();
        role.setId(4L);
        role.setRoleCode("test_uin");
        role.setRoleName("test_uin");
        role.setCreatedBy(1L);
        role.setCreationDate(LocalDateTime.now());
        role.setModifyBy(01L);
        role.setModifyDate(LocalDateTime.now());
        int i = mapper.updateRole(role);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("update ok");
            sqlSession.close();
        } else
            sqlSession.close();
    }

    /**
     * delete
     *
     * @author wanglufei
     * @date 2022/4/12 11:57 AM
     */
    @Test
    public void delete() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        int i = mapper.deleteById(4);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("delete ok");
            sqlSession.close();
        } else
            sqlSession.close();
    }
}
