package com.uin.mapper;

import com.uin.pojo.*;
import com.uin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/15/5:40 PM
 */
public class UserMapperTest {

    @Test
    public void TestQueryUser() {
        ////第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.queryAllUser();

        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 查询全部地址--测试类
     *
     * @author wanglufei
     * @date 2022/3/29 8:57 AM
     */
    @Test
    public void queryAllAddressTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        List<Address> addresses = mapper.queryAllAddress();
        System.out.println(addresses);
        sqlSession.close();
    }

    /**
     * 查询全部的订单--测试
     *
     * @author wanglufei
     * @date 2022/3/29 8:57 AM
     */
    @Test
    public void queryAllBillTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> bills = mapper.queryAllBill();
        System.out.println(bills);
        sqlSession.close();
    }

    /**
     * 查询全部提供方--测试类
     *
     * @author wanglufei
     * @date 2022/3/29 8:58 AM
     */
    @Test
    public void queryAllProviderTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        List<Provider> providers = mapper.queryAllProvider();
        System.out.println(providers);
        sqlSession.close();
    }

    /**
     * 查询全部的角色--测试类
     *
     * @author wanglufei
     * @date 2022/3/29 8:58 AM
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
     * 模糊查询--测试类
     *
     * @author wanglufei
     * @date 2022/3/29 8:58 AM
     */
    @Test
    public void getUserByUsername() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> username = mapper.getUserByUsername("邓");
        System.out.println(username);
        sqlSession.close();
    }

    /**
     * 根据id查询用户--测试类
     *
     * @author wanglufei
     * @date 2022/3/29 8:59 AM
     */
    @Test
    public void queryUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1L);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 查询用户的角色--测试类
     *
     * @author wanglufei
     * @date 2022/4/2 11:26 AM
     */
//    @Test
//    public void queryUserByUser() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("username", "邓超");
//        map.put("roleId", 2);
//        mapper.queryUserByUser(map);
//        sqlSession.close();
//    }

    /**
     * 查询用户的角色--测试类
     *
     * @author wanglufei
     * @date 2022/4/2 11:26 AM
     */
    @Test
    public void queryUserByUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("username", "邓超");
        map.put("roleId", 3);
        mapper.queryUserByUser2(map);
        sqlSession.close();
    }


//    @Test
//    public void queryUserVO() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        UserSearchVo vo = new UserSearchVo();
//        vo.setUserName("邓超");
//        vo.setRoleId(3);
//        List<User> users = mapper.queryUserVO(vo);
//        System.out.println(users);
//        sqlSession.close();
//    }

    /**
     * 模糊查询全部用户并显示用户角色--测试类
     *
     * @author wanglufei
     * @date 2022/4/2 10:50 AM
     */
    @Test
    public void queryAllUserShowRoleTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("赵");
        user.setUserRole(3L);
        List<User> users = mapper.queryAllUserShowRole(user);
        System.out.println(users);
        sqlSession.close();
    }

    /**
     * 增加用户--测试类
     *
     * @author wanglufei
     * @date 2022/4/2 11:25 AM
     */
    @Test
    public void addUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserCode("test001");
        user.setUserName("测试用户001");
        user.setUserPassword("1234567");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.format(date);
        user.setBirthday(date);
        user.setAddress("测试地址1");
        user.setGender(1);
        user.setPhone("13688789089");
        user.setUserRole(1L);
        user.setCreatedBy(1L);
        user.setCreationDate(new Date());
        int i = mapper.addUser(user);
        if (i > 0) {
            System.out.println(user + "插入成功！");
        }
        //模拟异常，进行回滚
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 修改用户信息--测试类
     *
     * @author wanglufei
     * @date 2022/4/2 11:58 AM
     */
    @Test
    public void updateUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(18L);
        user.setUserCode("test_modify");
        user.setUserName("测试用户修改");
        user.setUserPassword("00000000");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.format(date);
        user.setBirthday(date);
        user.setAddress("地址测试修改");
        user.setGender(1);
        user.setPhone("12356789087");
        user.setUserRole(2L);
        user.setModifyBy(1L);
        user.setModifyDate(new Date());
        mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 修改用户的密码--测试类
     *
     * @author wanglufei
     * @date 2022/4/2 12:01 PM
     */
    @Test
    public void updatePwdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updatePwd(17L, "8888888");
        if (i > 0) {
            sqlSession.commit();
            System.out.println("密码修改成功！");
            sqlSession.close();
        } else {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    /**
     * 删除用户--测试类
     *
     * @author wanglufei
     * @date 2022/4/2 12:10 PM
     */
    @Test
    public void deleteUserByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUserById(17L);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("删除用户成功！");
            sqlSession.close();
        } else {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    /**
     * 根据roleId 查询用户的角色实现resultMap的高级映射：一对一的关系
     *
     * @author wanglufei
     * @date 2022/4/12 9:20 AM
     */
    @Test
    public void getUserListByRoleId_test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userListByRoleId = mapper.getUserListByRoleId(1);
        System.out.println(userListByRoleId);
        sqlSession.close();
    }


    //queryUserByUser
//    @Test
//    public void queryUserByUserTest() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        Map<String, Object> map = new HashMap<>();
//        map.put("username","邓");
//        List<User> users = mapper.queryUserByUser(map);
//        System.out.println(users);
//        sqlSession.close();
//    }

    /**
     * 查询一个用户对应的多个地址 实现一对多的查询
     *
     * @author wanglufei
     * @date 2022/4/12 9:53 AM
     */
    @Test
    public void getAddressListByUserId_test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> addressListByUserId = mapper.getAddressListByUserId(1);
        System.out.println(addressListByUserId);
        sqlSession.close();
    }

    @Test
    public void getUserByRoleIdsArray() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userByRoleIdsArray = mapper.getUserByRoleIdsArray(new Integer[]{2, 3});
        System.out.println(userByRoleIdsArray);
        sqlSession.close();
    }

    //getUserByRoleIdsList

    @Test
    public void getUserByRoleIdsList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<User> userList = mapper.getUserByRoleIdsList(list);
        System.out.println(userList);
        sqlSession.close();
    }

    //getUserByRoleIdsMap

    @Test
    public void getUserByRoleIdsMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        map.put("gender",1);
        // <foreach collection="ids" item="id" open="(" close=")" separator=",">
        map.put("ids",list);
        List<User> byRoleIdsMap = mapper.getUserByRoleIdsMap(map);
        System.out.println(byRoleIdsMap);
        sqlSession.close();
    }

    //getUserListByPage
    @Test
    public void getUserListByPage() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userListByPage = mapper.getUserListByPage("", null, 1, 10);
        System.out.println(userListByPage);
        sqlSession.close();
    }

}
