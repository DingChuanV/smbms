package com.uin.mapper;

import com.uin.pojo.Provider;

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
}
