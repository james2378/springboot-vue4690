package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 采购用户：(PurchasingUsers)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PurchasingUsers")
public class PurchasingUsers implements Serializable {

    // PurchasingUsers编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchasing_users_id")
    private Integer purchasing_users_id;

    // 采购人员
    @Basic
    private String procurement_personnel;












    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;


    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
