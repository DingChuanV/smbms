package com.uin.mapper;

import com.uin.pojo.Address;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/24/3:34 PM
 */
public interface AddressMapper {
    /**
     * 查询全部地址
     *
     * @return java.util.List<com.uin.pojo.Address>
     * @author wanglufei
     * @date 2022/3/29 8:55 AM
     */
    List<Address> queryAllAddress();
}
