package com.wenjie.weixinback.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenwenjie
 */
public class DateUtil {
    /**
     * 返回当前的日期,格式2019-05-04
     * @return dataForm
     */
    public static String getDate(){
        Date date = new Date();
        String dataForm = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return dataForm;
    }
}
