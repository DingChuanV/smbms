package com.uin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author wanglufei
 * @since 2022-03-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    //主键ID
    private Long id;
    //联系人姓名
    private String contact;
    //收货地址明细
    private String addressDesc;
    //邮编
    private String postCode;
    //联系人电话
    private String tel;
    //创建者
    private Long createdBy;
    //创建时间
    private LocalDateTime creationDate;
    //修改者
    private Long modifyBy;
    //修改时间
    private LocalDateTime modifyDate;
    //用户ID
    private Long userId;


}
