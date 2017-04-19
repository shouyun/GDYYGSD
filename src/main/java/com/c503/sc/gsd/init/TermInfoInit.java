/**
 * 文件名：VesselInfoThread.java
 * 版权： 航天恒星科技有限公司
 * 描述：〈描述〉
 * 修改时间：2017年2月14日 
 * 修改内容：〈修改内容〉
 */
package com.c503.sc.gsd.init;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.c503.sc.gsd.common.DateUtil;
import com.c503.sc.gsd.common.StringUtil;
import com.c503.sc.gsd.staticdata.model.TermInfo;
import com.c503.sc.gsd.staticdata.service.ITermInfoService;

/**
 * 
 * 〈一句话功能简述〉终端初始化函数
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
@Component("termInfo")
public class TermInfoInit {
	
	/** 日志器 */
    private static Logger LOGGER = LogManager.getLogger(TermInfoInit.class);
    
    /**
     * 注入service
     */
    @Autowired
    private ITermInfoService termInfoService;
    
    /** 
     * 生成时间段
     */
    @Value("#{configProperties['time_space_term']}")
    private String time_space;
    
    /**
     * 时间
     */
    private Date startTime;
    
    /**
     * 生成文件路径
     */
    @Value("#{configProperties['file_path_term']}")
    private String path;
    
    
    /**
     * 生成文件路径
     */
    @Value("#{configProperties['file_path_vessel_term']}")
    private String path_vs;
    
    /**
     * 数据集合
     */
    private List<TermInfo> termInfo;
    
    /**
     * 查询时间间隔
     */
    private Map<String, Object> map;
    
    /**
     * 时间生成
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
    
    /**
     * 
     *〈一句话功能简述〉开始生成静态文件
     * 〈功能详细描述〉
     * @see  [类、类#方法、类#成员]
     */
    public void startTermInfo() {
    	termInfo = new ArrayList<TermInfo>();
        map = new HashMap<String, Object>();
        StringUtil.judgeFileDir(path);
        try {
            //先查询最小时间
            startTime = termInfoService.findMinTime();
            Date now = new Date();
            //查询出来的时间小于当前时间是继续查
            while (startTime.getTime() <= now.getTime()) {
                map.put("startTime", startTime);
                //获取开始时间
                Date endTime = DateUtil.getEndTime(startTime, time_space);
                map.put("endTime", endTime);
                termInfo =
                		termInfoService.findByTime(map);
                if (termInfo.size() > 0) {
                    String fileName =
                        "GDTIU"
                            + sdf.format(startTime);
                    String fileString = path + "\\" + fileName + ".xml";
                    File testFile = new File(fileString);
                    //文件不存在才进行
                    if (!testFile.exists()) {
                    	termInfoService.newFlie(fileString, termInfo);
					}
                    //生成关系表
                    String fileNameVs =
                        "GDVTR"
                            + sdf.format(startTime);
                    String fileStringVs = path_vs + "\\" + fileNameVs + ".xml";
                    File testFileVs = new File(fileString);
                    //文件不存在才进行
                    if (!testFileVs.exists()) {
                        termInfoService.newVsFlie(fileStringVs, termInfo);
                    }
                }
                startTime = endTime;
                termInfo = new ArrayList<TermInfo>();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e);
        }
    }
    
}
