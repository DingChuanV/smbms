package com.uin.mapper;

import com.uin.pojo.Bill;

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


}
