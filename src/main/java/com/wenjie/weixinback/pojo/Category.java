package com.wenjie.weixinback.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Category {
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
     * 分类更新时间
     */
    @Column(name = "category_udtime")
    private Date categoryUdtime;

    /**
     * 获取商品分类id
     *
     * @return category_id - 商品分类id
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品分类id
     *
     * @param categoryId 商品分类id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取商品分类名称
     *
     * @return category_name - 商品分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置商品分类名称
     *
     * @param categoryName 商品分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 获取分类更新时间
     *
     * @return category_udtime - 分类更新时间
     */
    public Date getCategoryUdtime() {
        return categoryUdtime;
    }

    /**
     * 设置分类更新时间
     *
     * @param categoryUdtime 分类更新时间
     */
    public void setCategoryUdtime(Date categoryUdtime) {
        this.categoryUdtime = categoryUdtime;
    }
}