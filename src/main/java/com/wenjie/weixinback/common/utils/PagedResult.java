package com.wenjie.weixinback.common.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenwenjie
 * @Description: 封装分页后的数据格式
 * 命名跟jqGrid的表格参数对应
 */
@Data
public class PagedResult implements Serializable {

	/**
	 * 当前页
	 */
	private int page;

	/**
	 * 总页数
	 */
	private int total;

	/**
	 * 总记录数
	 */
	private long records;

	/**
	 * 每行显示的内容
	 */
	private List<?> rows;

}
