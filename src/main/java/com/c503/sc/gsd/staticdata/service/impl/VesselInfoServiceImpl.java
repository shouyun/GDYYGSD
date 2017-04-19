/**
 * 文件名：VesselInfoServiceImpl.java
 * 版权： 航天恒星科技有限公司
 * 描述：〈描述〉
 * 修改时间：2017年2月14日 
 * 修改内容：〈修改内容〉
 */
package com.c503.sc.gsd.staticdata.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Service;

import com.c503.sc.base.dao.IBaseDao;
import com.c503.sc.base.service.impl.BaseServiceImpl;
import com.c503.sc.gsd.common.CommonConstant;
import com.c503.sc.gsd.common.DateUtil;
import com.c503.sc.gsd.common.DictConstant;
import com.c503.sc.gsd.common.StaticCache;
import com.c503.sc.gsd.common.StringUtil;
import com.c503.sc.gsd.staticdata.dao.IVesselInfoDao;
import com.c503.sc.gsd.staticdata.model.VesselInfo;
import com.c503.sc.gsd.staticdata.service.IVesselInfoService;
import com.c503.sc.log.LoggingManager;
import com.c503.sc.utils.basetools.C503DateUtils;
import com.c503.sc.utils.common.SystemContants;

/**
 * 
 * 〈一句话功能简述〉实现类              
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月14日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
@Service
public class VesselInfoServiceImpl extends BaseServiceImpl<VesselInfo> implements IVesselInfoService{
    
    /** 日志记录器 */
    private static Logger LOGGER = LogManager.getLogger(VesselInfoServiceImpl.class);
    
    @Resource(name = "vesselInfoDao")
    private IVesselInfoDao vesselInfoDao;

    @Override
    public List<VesselInfo> findByTime(Map<String, Object> map)
        throws Exception {
        // 记录程序进入方法调试日志
        LOGGER.debug(SystemContants.DEBUG_START);
        List<VesselInfo> list = null;
        try{
            //查询该时间间隔的内容
            list = this.vesselInfoDao.findByTime(map);
            LOGGER.info(CommonConstant.FIND_SUC_OPTION);
        }catch(Exception e){
            transactionException(CommonConstant.SYS_EXCEPTION, e, map);
            LOGGER.error(e);
        }
        return list;
    }

    @Override
    public Date findMinTime()
        throws Exception {
        // 记录程序进入方法调试日志
        LOGGER.debug(SystemContants.DEBUG_START);
        Date minTime = null;
        try{
            minTime = this.vesselInfoDao.findMinTime();
            //将时间转为分钟的格式
            SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            minTime = C503DateUtils.strToDate(sDateFormat.format(minTime), "yyyy-MM-dd HH:mm");
            System.out.println(minTime);
        }catch(Exception e){
            transactionException(CommonConstant.SYS_EXCEPTION, e);
            LOGGER.error(e);
        }
        return minTime;
    }
    
    /**
     * 生成文件
     * 
     * @param path 路径
     * @param name 文件名
     * @param tracelist 轨迹
     * @throws IOException 异常
     */
    public void newFlie(String file, List<VesselInfo> list)
        throws IOException {
    	if (list.size() > 0) {
            try {
            	ConcurrentHashMap<String, String> map = StaticCache.getMap();
                //创建文档及设置根元素节点
                Element root = DocumentHelper.createElement("VesselInfo");
                Document document = DocumentHelper.createDocument(root);
                //给根节点添加孩子节点
                for (VesselInfo t : list) {
                    try {
                        Element item = root.addElement("item");
                        //操作时间  秒整数
                        item.addAttribute("oper_time",  String.valueOf(DateUtil.changeTimeToSecond(t.getOperTime())));
                        //操作代码
                        item.addAttribute("oper_code", String.valueOf(DictConstant.ADD_OPTION));
                        //数据来源
                        item.addAttribute("info_source", String.valueOf(DictConstant.GUANGDONG));
                        //入库时间 秒整数
                        item.addAttribute("load_time", String.valueOf(DateUtil.changeTimeToSecond(t.getLoadTime())));
                        //直接所属单位
                        item.addAttribute("direct_org", StringUtil.findOrgName(t.getDeptId(), map));
                        //属地 area_name
                        item.addAttribute("vessel_region", t.getVesselRegion());
                        //船主
                        item.addAttribute("vessel_owner", t.getVesselOwner());
                        //船长联系电话 
                        item.addAttribute("captain_tel", t.getCaptainTel());
                        // 船长姓名 
                        item.addAttribute("captain_name", t.getCaptainName());
                        //最大航速 
                        item.addAttribute("max_speed", StringUtil.numToString(t.getMaxSpeed()));
                        //渔船材料 
                        item.addAttribute("material", StringUtil.getDictMaterial(t.getMaterial()));
                        //总功率
                        item.addAttribute("power", StringUtil.numToString(t.getPower()));
                        //总吨位
                        item.addAttribute("ton", StringUtil.numToString(t.getTon()));
                        //渔船名称
                        item.addAttribute("vessel_name", t.getVesselName());
                        // 渔船类型
                        //FIXME
                        item.addAttribute("vessel_type", StringUtil.getDictShipType(t.getVesselType()));
                        //渔船编号 ,对应渔船的id
                        t.setVesselId(t.getId().hashCode());
                        item.addAttribute("vessel_id", String.valueOf(t.getVesselId()));
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //生成的文件放在对应的路径， true代表是否换行， 第三个为编码格式
                OutputFormat format = new OutputFormat("  ", true, "UTF-8");
                XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"), format);
                writer.write(document);
                writer.flush();
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
                LOGGER.error(e);
            }
        }
    }

    @Override
    public IBaseDao<VesselInfo> getBaseDao() {
        return vesselInfoDao;
    }

	@Override
	protected LoggingManager logger() {
		return null;
	}
    
}
