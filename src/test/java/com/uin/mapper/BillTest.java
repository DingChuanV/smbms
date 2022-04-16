package com.uin.mapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uin.pojo.Bill;
import com.uin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/12/11:14 AM
 */
public class BillTest {
    /**
     * query
     *
     * @author wanglufei
     * @date 2022/4/12 11:58 AM
     */
    @Test
    public void query() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> bills = mapper.queryAllBill();
        System.out.println(bills);
        sqlSession.close();
    }

    /**
     * add-test
     *
     * @author wanglufei
     * @date 2022/4/12 11:26 AM
     */
    @Test
    public void addBillTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Bill bill = new Bill();
        bill.setBillCode("test");
        bill.setProductName("test");
        bill.setProductDesc("test");
        bill.setProductUnit("test");
        bill.setProductCount(new BigDecimal("0"));
        bill.setTotalPrice(new BigDecimal("0"));
        bill.setIsPayment(0);
        bill.setCreatedBy(18L);
        bill.setCreationDate(LocalDateTime.now());
        bill.setModifyBy(18L);
        bill.setModifyDate(LocalDateTime.now());
        bill.setProviderId(18L);
        int i = mapper.addBill(bill);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("add ok");
            sqlSession.close();
        } else
            sqlSession.rollback();
    }

    @Test
    public void updateBillTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Bill bill = new Bill();
        bill.setId(19L);
        bill.setBillCode("test_uin");
        bill.setProductName("test_uin");
        bill.setProductDesc("test");
        bill.setProductUnit("test");
        bill.setProductCount(new BigDecimal("1"));
        bill.setTotalPrice(new BigDecimal("1"));
        bill.setIsPayment(0);
        bill.setCreatedBy(18L);
        bill.setCreationDate(LocalDateTime.now());
        bill.setModifyBy(18L);
        bill.setModifyDate(LocalDateTime.now());
        bill.setProviderId(18L);
        int i = mapper.updateBill(bill);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("update ok");
            sqlSession.close();
        } else
            sqlSession.rollback();
    }

    /**
     * delete -test
     *
     * @author wanglufei
     * @date 2022/4/12 11:30 AM
     */
    @Test
    public void deleteByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int i = mapper.deleteById(19);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("delete ok");
            sqlSession.close();
        } else {
            sqlSession.rollback();
        }
    }
    /**
     *
     * @author wanglufei
     * @date 2022/4/16 6:34 PM
     */
    @Test
    public void queryBillShowProvider(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> billList = mapper.queryBillShowProvider(1, "大", 2);
        System.out.println(billList);
        sqlSession.close();
    }
}
