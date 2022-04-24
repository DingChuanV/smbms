package com.uin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wanglufei
 * @description: Vo对象
 * @date 2022/3/29/9:14 AM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchVo {
    /**
     * 名字
     */
    private String userName;
    /**
     * 角色的id
     */
    private int roleId;
}
