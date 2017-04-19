package com.c503.sc.gsd.staticdata.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.c503.sc.base.service.IBaseService;
import com.c503.sc.gsd.staticdata.model.VesselTermRelation;

/**
 * 
 * 〈一句话功能简述〉关系表接口
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public interface IVesselTermRelService
    extends IBaseService<VesselTermRelation> {
    
    /**
     * 
     *〈一句话功能简述〉根据时间段查询结果
     * 〈功能详细描述〉
     * @param map 查询时间段
     * @return list集合
     * @throws Exception 系统异常
     * @see  [类、类#方法、类#成员]
     */
    List<VesselTermRelation> findByTime(Map<String, Object> map)
        throws Exception;
    
    /**
     * 
     *〈一句话功能简述〉查询最小时间
     * 〈功能详细描述〉
     * @return Date  日期
     * @throws Exception 系统异常
     * @see  [类、类#方法、类#成员]
     */
    Date findMinTime()
        throws Exception;
    
    /**
     * 
     *〈一句话功能简述〉生成xml文件
     * 〈功能详细描述〉
     * @param file 文件路径
     * @param list 数据集
     * @throws IOException 异常
     * @see  [类、类#方法、类#成员]
     */
    void newFlie(String file, List<VesselTermRelation> list)
        throws IOException;
    
}
