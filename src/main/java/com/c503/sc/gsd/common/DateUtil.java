/**
 * 文件名：DatFileUtil.java
 * 版权： 航天恒星科技有限公司
 * 描述：〈描述〉
 * 修改时间：2017年1月17日
 * 修改内容：〈修改内容〉
 */
package com.c503.sc.gsd.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.c503.sc.utils.basetools.C503DateUtils;

/**
 * 
 * 〈一句话功能简述〉时间工具类函数
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class DateUtil {
    
    /**
     * 
     *〈一句话功能简述〉根据开始时间，时间间隔算出结束时间
     * 〈功能详细描述〉
     * @param startTime 开始时间
     * @param timeSpace 时间间隔
     * @return 结束时间
     * @throws Exception 系统异常
     * @see  [类、类#方法、类#成员]
     */
    public static Date getEndTime(Date startTime, String timeSpace)
        throws Exception {
        Date endTime = startTime;
        // 转换成秒
        int space = Integer.parseInt(timeSpace);
        System.out.println(space);
        // 计算得到结束事件
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(startTime);
        // 以分钟为单位得到结束时间
        rightNow.add(Calendar.MINUTE, space);
        endTime = rightNow.getTime();
        System.out.println(endTime);
        return endTime;
    }
    
    /**
     * 
     *〈一句话功能简述〉将时间转换成秒整数
     * 〈功能详细描述〉
     * @param time 时间
     * @return 秒整数
     * @throws Exception 系统异常
     * @see  [类、类#方法、类#成员]
     */
    public static long changeTimeToSecond(Date time)
        throws Exception {
        long ltime = 0;
        if (time != null) {
            // 先转入时间得到以秒进行格式化的结果
            SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dTime = C503DateUtils.strToDate(format.format(time),
                "yyyy-MM-dd HH:mm:ss");
            // 得到秒整数
            ltime = dTime.getTime() / NumberContant.THOUSAND;
        }
        return ltime;
    }
    
}
