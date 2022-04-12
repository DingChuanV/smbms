package com.uin.mapper;

import com.uin.pojo.Address;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 新增一个address
     *
     * @param address
     * @return int
     * @author wanglufei
     * @date 2022/4/12 10:33 AM
     */
    int addAddress(Address address);

    /**
     * 更新addres
     *
     * @return int
     * @author wanglufei
     * @date 2022/4/12 10:21 AM
     */
    int updateAddress(Address address);

    /**
     * 根据id删除
     *
     * @param id
     * @return int
     * @author wanglufei
     * @date 2022/4/12 11:05 AM
     */
    int deleteByAddress(@Param("id") int id);

}
