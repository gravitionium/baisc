package cn.cloudscope.basic.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wupanhua on 2018/7/11.
 */
public class DateUtil {

    private static SimpleDateFormat formatLongStatus = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String getFullStringDate(Date target) {
        return formatLongStatus.format(target);
    }
}
