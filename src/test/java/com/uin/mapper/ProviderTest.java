package com.uin.mapper;

import java.time.LocalDateTime;

import com.uin.pojo.Provider;
import com.uin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/12/11:35 AM
 */
public class ProviderTest {
    /**
     * add-test
     *
     * @author wanglufei
     * @date 2022/4/12 11:41 AM
     */
    @Test
    public void addProviderTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        Provider provider = new Provider();
        provider.setProCode("test");
        provider.setProName("test");
        provider.setProDesc("test");
        provider.setProContact("test");
        provider.setProPhone("test");
        provider.setProAddress("test");
        provider.setProFax("test");
        provider.setCreatedBy(18L);
        provider.setCreationDate(LocalDateTime.now());
        provider.setModifyDate(LocalDateTime.now());
        provider.setModifyBy(18L);
        int i = mapper.addProvider(provider);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("add ok");
            sqlSession.close();
        } else
            sqlSession.close();
    }

    /**
     * update-test
     *
     * @author wanglufei
     * @date 2022/4/12 11:43 AM
     */
    @Test
    public void updateProviderTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        Provider provider = new Provider();
        provider.setId(16L);
        provider.setProCode("test");
        provider.setProName("test");
        provider.setProDesc("test");
        provider.setProContact("test");
        provider.setProPhone("test");
        provider.setProAddress("test");
        provider.setProFax("test");
        provider.setCreatedBy(18L);
        provider.setCreationDate(LocalDateTime.now());
        provider.setModifyDate(LocalDateTime.now());
        provider.setModifyBy(18L);
        int i = mapper.updateProvider(provider);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("update ok");
            sqlSession.close();
        } else
            sqlSession.close();
    }

    @Test
    public void deleteByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        int i = mapper.deleteById(16);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("delete ok");
            sqlSession.close();
        } else
            sqlSession.close();
    }
}
