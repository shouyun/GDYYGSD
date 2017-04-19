/**
 * 文件名：IVesselTermRelationDao.java
 * 版权： 航天恒星科技有限公司
 * 描述：〈描述〉
 * 修改时间：2017年2月14日 
 * 修改内容：〈修改内容〉
 */
package com.c503.sc.gsd.staticdata.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.c503.sc.base.dao.IBaseDao;
import com.c503.sc.gsd.staticdata.model.VesselTermRelation;

/**
 * 
 * 〈一句话功能简述〉渔船与终端关系
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月14日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
@Repository(value = "vesselTermRelDao")
public interface IVesselTermRelationDao extends IBaseDao<VesselTermRelation>{
    
    
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
     * @return Date 日期
     * @throws Exception 系统异常
     * @see  [类、类#方法、类#成员]
     */
    Date findMinTime()
        throws Exception;
    
}
