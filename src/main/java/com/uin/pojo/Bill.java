package com.uin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author wanglufei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill implements Serializable {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 账单编码
     */
    private String billCode;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品描述
     */
    private String productDesc;
    /**
     * 商品单位
     */
    private String productUnit;
    /**
     * 商品数量
     */
    private BigDecimal productCount;
    /**
     * 商品总额
     */
    private BigDecimal totalPrice;
    /**
     * 账单是否支付（1：未支付 2：已支付）编码
     */
    private Integer isPayment;
    /**
     * 创建者（userId）
     */
    private Long createdBy;
    /**
     * 创建时间
     */
    private LocalDateTime creationDate;
    /**
     * 更新者（userId）
     */
    private Long modifyBy;
    /**
     * 更新时间
     */
    private LocalDateTime modifyDate;
    /**
     * 供应商ID
     */
    private Long providerId;
    /**
     * 供应商provider
     */
    private Provider provider;

}
