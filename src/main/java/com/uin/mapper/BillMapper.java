package com.uin.mapper;

import com.uin.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/24/3:36 PM
 */
public interface BillMapper {
    /**
     * 查询全部订单
     *
     * @return java.util.List<com.uin.pojo.Bill>
     * @author wanglufei
     * @date 2022/3/29 8:55 AM
     */
    List<Bill> queryAllBill();

    /**
     * add
     *
     * @param bill
     * @return int
     * @author wanglufei
     * @date 2022/4/12 11:09 AM
     */
    int addBill(Bill bill);

    /**
     * update
     *
     * @param bill
     * @return int
     * @author wanglufei
     * @date 2022/4/12 11:21 AM
     */
    int updateBill(Bill bill);

    /**
     * delete
     *
     * @param id
     * @return int
     * @author wanglufei
     * @date 2022/4/12 11:28 AM
     */
    int deleteById(@Param("id") int id);




}
