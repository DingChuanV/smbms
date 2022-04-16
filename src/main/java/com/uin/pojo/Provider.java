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
@AllArgsConstructor
@NoArgsConstructor
public class Provider implements Serializable {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 供应商编码
     */
    private String proCode;
    /**
     * 供应商名称
     */
    private String proName;
    /**
     * 供应商详细描述
     */
    private String proDesc;
    /**
     * 供应商联系人
     */
    private String proContact;
    /**
     * 联系电话
     */
    private String proPhone;
    /**
     * 地址
     */
    private String proAddress;
    /**
     * 传真
     */
    private String proFax;
    /**
     * 创建者（userId）
     */
    private Long createdBy;
    /**
     * 创建时间
     */
    private LocalDateTime creationDate;
    /**
     * 更新时间
     */
    private LocalDateTime modifyDate;
    /**
     * 更新者（userId）
     */
    private Long modifyBy;


}
