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
public class Role implements Serializable {
    //主键ID
    private Long id;
    //角色编码
    private String roleCode;
    //角色名称
    private String roleName;
    //创建者
    private Long createdBy;
    //创建时间
    private LocalDateTime creationDate;
    //修改者
    private Long modifyBy;
    //修改时间
    private LocalDateTime modifyDate;

}
