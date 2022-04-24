package com.uin.mapper;

import com.uin.pojo.Bill;
import com.uin.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/24/3:38 PM
 */
public interface ProviderMapper {
    /**
     * 查询全部提供商
     *
     * @return java.util.List<com.uin.pojo.Provider>
     * @author wanglufei
     * @date 2022/3/29 8:55 AM
     */
    List<Provider> queryAllProvider();

    /**
     * add
     *
     * @param provider
     * @return int
     * @author wanglufei
     * @date 2022/4/12 11:31 AM
     */
    int addProvider(Provider provider);

    /**
     * update
     *
     * @param provider
     * @return int
     * @author wanglufei
     * @date 2022/4/12 11:31 AM
     */
    int updateProvider(Provider provider);

    /**
     * delete
     * @author wanglufei
     * @date 2022/4/12 11:31 AM
     * @param id
     * @return int
     */
    int deleteById(@Param("id") int id);

    /**
     *
     * @author wanglufei
     * @date 2022/4/16 6:55 PM
     * @return java.util.List<com.uin.pojo.Provider>
     */
    List<Provider> queryProviderWithBills(@Param("id") int id);


    //List<Provider> query
}
