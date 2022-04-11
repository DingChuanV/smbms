package com.uin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
public class User implements Serializable {
    //主键ID
    private Long id;
    //用户编码
    private String userCode;
    //用户名称
    private String userName;
    //用户密码
    private String userPassword;
    //性别（1:女、 2:男）
    private Integer gender;
    //出生日期
    private Date birthday;
    //手机
    private String phone;
    //地址
    private String address;
    //用户角色（取自角色表-角色id）
    private Long userRole;

    //创建者（userId）
    private Long createdBy;
    //创建时间
    private Date creationDate;
    //更新者（userId）
    private Long modifyBy;
    //更新时间
    private Date modifyDate;

    private String userRoleName;//关联查询 role才能获取到值
}
