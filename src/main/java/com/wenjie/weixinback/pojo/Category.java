package com.wenjie.weixinback.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chenwenjie
 */
@Data
public class Category implements Serializable {
    /**
     * 商品分类id
     */
    @Id
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 商品分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 分类状态(0禁用，1启用)
     */
    @Column(name = "category_status")
    private Integer categoryStatus;

    /**
     * 分类更新时间
     */
    @Column(name = "category_udtime")
    private String categoryUdtime;

}