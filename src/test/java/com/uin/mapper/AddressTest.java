package com.uin.mapper;

import com.uin.pojo.Address;
import com.uin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/12/10:30 AM
 */
public class AddressTest {
    /**
     * 增加-测试类
     *
     * @author wanglufei
     * @date 2022/4/12 11:04 AM
     */
    @Test
    public void addAddressTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        Address address = new Address();
        address.setContact("uin");
        address.setAddressDesc("test地址");
        address.setPostCode("test");
        address.setTel("11111test1111");
        address.setCreatedBy(1L);
        address.setCreationDate(new Date());
        address.setModifyBy(1L);
        address.setModifyDate(new Date());
        address.setUserId(1L);
        int i = mapper.addAddress(address);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("add success!");
            sqlSession.close();
        } else {
            sqlSession.rollback();
        }
    }

    /**
     * 更新-测试类
     *
     * @author wanglufei
     * @date 2022/4/12 11:04 AM
     */
    @Test
    public void updateAddressTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        Address address = new Address();
        address.setId(7L);
        address.setContact("uin_test");
        address.setAddressDesc("test地址");
        address.setPostCode("test");
        address.setTel("2222test1111");
        address.setCreatedBy(1L);
        address.setCreationDate(new Date());
        address.setModifyBy(1L);
        address.setModifyDate(new Date());
        address.setUserId(1L);
        int i = mapper.updateAddress(address);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("update ok!");
            sqlSession.close();
        } else {
            sqlSession.rollback();
        }
    }

    /**
     * 删除-测试类
     *
     * @author wanglufei
     * @date 2022/4/12 11:07 AM
     */
    @Test
    public void deleteByAddressTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        int i = mapper.deleteByAddress(7);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("delete ok");
            sqlSession.close();
        } else {
            sqlSession.rollback();
        }

    }
}
