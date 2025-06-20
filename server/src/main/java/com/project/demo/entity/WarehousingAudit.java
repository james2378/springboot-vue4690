package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 入库审核：(WarehousingAudit)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "WarehousingAudit")
public class WarehousingAudit implements Serializable {

    // WarehousingAudit编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehousing_audit_id")
    private Integer warehousing_audit_id;

    // 商品图
    @Basic
    private String product_map;
    // 采购单号
    @Basic
    private String purchase_order_number;
    // 商品名称
    @Basic
    private String product_name;
    // 商品类型
    @Basic
    private String product_type;
    // 品牌
    @Basic
    private String brand;
    // 商品规格
    @Basic
    private String commodity_specifications;
    // 供应商编号
    @Basic
    private Integer supplier_number;
    // 供应商名称
    @Basic
    private String supplier_name;
    // 采购数量
    @Basic
    private String purchase_quantity;
    // 入库数量
    @Basic
    private Integer receipt_quantity;
    // 采购人员
    @Basic
    private Integer procurement_personnel;
    // 审核备注
    @Basic
    private String review_remarks;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
