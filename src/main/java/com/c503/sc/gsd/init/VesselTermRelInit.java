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
import com.c503.sc.gsd.staticdata.model.VesselTermRelation;
import com.c503.sc.gsd.staticdata.service.IVesselTermRelService;

/**
 * 
 * 〈一句话功能简述〉生成关系表
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
@Component("vesselTermRel")
public class VesselTermRelInit {
	
	/** 日志器 */
    private static Logger LOGGER = LogManager.getLogger(VesselTermRelInit.class);
    
    /**
     * 注入service
     */
    @Autowired
    private IVesselTermRelService vesselTermRelService;
    
    /**
     * 生成文件时间段
     */
    @Value("#{configProperties['time_space_vessel_term']}")
    private String time_space;
    
    /**
     * 时间
     */
    private Date startTime;
    
    /**
     * 生成文件路径
     */
    @Value("#{configProperties['file_path_vessel_term']}")
    private String path;
    
    /**
     * 数据集合
     */
    private List<VesselTermRelation> vesselTermRel;
    
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
     *〈一句话功能简述〉开始生成文件
     * 〈功能详细描述〉
     * @see  [类、类#方法、类#成员]
     */
    public void startRel() {
    	vesselTermRel = new ArrayList<VesselTermRelation>();
        map = new HashMap<String, Object>();
        StringUtil.judgeFileDir(path);
        try {
            //先查询最小时间
            startTime = vesselTermRelService.findMinTime();
            Date now = new Date();
            //查询出来的时间小于当前时间是继续查
            while (startTime.getTime() <= now.getTime()) {
                map.put("startTime", startTime);
                //获取开始时间
                Date endTime = DateUtil.getEndTime(startTime, time_space);
                map.put("endTime", endTime);
                vesselTermRel =
                		vesselTermRelService.findByTime(map);
                if (vesselTermRel.size() > 0) {
                    String fileName =
                        "GDVTR"
                            + sdf.format(startTime);
                    String fileString = path + "\\" + fileName + ".xml";
                    File testFile = new File(fileString);
                    //文件不存在才进行
                    if (!testFile.exists()) {
                    	vesselTermRelService.newFlie(fileString, vesselTermRel);
					}
                }
                startTime = endTime;
                vesselTermRel = new ArrayList<VesselTermRelation>();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e);
        }
    }
    
}
