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
import com.c503.sc.gsd.common.StringUtil;
import com.c503.sc.gsd.staticdata.dao.ITermInfoDao;
import com.c503.sc.gsd.staticdata.model.TermInfo;
import com.c503.sc.gsd.staticdata.service.ITermInfoService;
import com.c503.sc.log.LoggingManager;
import com.c503.sc.utils.basetools.C503DateUtils;
import com.c503.sc.utils.common.SystemContants;

/**
 * 
 * 〈一句话功能简述〉终端基本信息实现类
 * 〈功能详细描述〉
 * 
 * @author shouy
 * @version [版本号, 2017年2月14日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class TermInfoServiceImpl extends BaseServiceImpl<TermInfo>
    implements ITermInfoService {
    
    /** 日志记录器 */
    private static Logger LOGGER =
        LogManager.getLogger(TermInfoServiceImpl.class);
    
    /** dao接口注入 */
    @Resource(name = "termInfoDao")
    private ITermInfoDao termInfoDao;
    
    @Override
    public List<TermInfo> findByTime(Map<String, Object> map)
        throws Exception {
        // 记录程序进入方法调试日志
        LOGGER.debug(SystemContants.DEBUG_START);
        List<TermInfo> list = null;
        try {
            // 查询该时间间隔的内容
            list = this.termInfoDao.findByTime(map);
            LOGGER.info(CommonConstant.FIND_SUC_OPTION);
        }
        catch (Exception e) {
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
        try {
            minTime = this.termInfoDao.findMinTime();
            // 将时间转为分钟的格式
            SimpleDateFormat sDateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm");
            minTime = C503DateUtils.strToDate(sDateFormat.format(minTime),
                "yyyy-MM-dd HH:mm");
            System.out.println(minTime);
        }
        catch (Exception e) {
            transactionException(CommonConstant.SYS_EXCEPTION, e);
            LOGGER.error(e);
        }
        return minTime;
    }
    
    @Override
    public void newFlie(String file, List<TermInfo> list)
        throws IOException {
        if (list.size() > 0) {
            try {
                // 创建文档及设置根元素节点
                Element root = DocumentHelper.createElement("TermInfo");
                Document document = DocumentHelper.createDocument(root);
                // 给根节点添加孩子节点
                for (TermInfo t : list) {
                    try {
                        Element item = root.addElement("item");
                        // 操作时间 秒整数
                        item.addAttribute("oper_time",
                            String.valueOf(
                                DateUtil.changeTimeToSecond(t.getOperTime())));
                        // 操作代码
                        item.addAttribute("oper_code",
                            String.valueOf(DictConstant.ADD_OPTION));
                        // 数据来源
                        item.addAttribute("info_source",
                            String.valueOf(DictConstant.GUANGDONG));
                        // 操作后终端状态 字符型 增加、修改、删除时均填写
                        item.addAttribute("mod_term_status",
                            t.getModTermStatus());
                        // 操作后终端类型 增加、修改、删除时均填写）
                        item.addAttribute("mod_term_type", StringUtil.getDictTermType(t.getModTermType()));
                        // 操作后终端卡号 增加、修改、删除时均填写
                        item.addAttribute("mod_term_no", t.getModTermNo());
                        // 操作前终端状态 修改和删除时填写，增加时此值无意义
                        item.addAttribute("ori_term_status", "");
                        // 操作前终端类型 修改和删除时填写，增加时此值无意义
                        item.addAttribute("ori_term_type", "");
                        // 操作前终端卡号 修改和删除时填写，增加时此值无意义
                        item.addAttribute("ori_term_no", "");
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // 生成的文件放在对应的路径， true代表是否换行， 第三个为编码格式
                OutputFormat format = new OutputFormat("  ", true, "UTF-8");
                XMLWriter writer = new XMLWriter(
                    new OutputStreamWriter(new FileOutputStream(file), "UTF-8"),
                    format);
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
    public void newVsFlie(String file, List<TermInfo> list)
        throws IOException {
        if (list.size() > 0) {
            try {
                //创建文档及设置根元素节点
                Element root = DocumentHelper.createElement("Vessel_Term_Relation");
                Document document = DocumentHelper.createDocument(root);
                //给根节点添加孩子节点
                for (TermInfo t : list) {
                    try {
                        Element item = root.addElement("item");
                        //操作时间  秒整数
                        item.addAttribute("oper_time",  String.valueOf(DateUtil.changeTimeToSecond(t.getOperTime())));
                        //操作代码
                        item.addAttribute("oper_code", String.valueOf(DictConstant.ADD_OPTION));
                        //数据来源
                        item.addAttribute("info_source", String.valueOf(DictConstant.GUANGDONG));
                        //操作后终端类型 增加、修改、删除时均填写）
                        item.addAttribute("mod_term_type",  StringUtil.getDictTermType(t.getModTermType()));
                        //操作后终端卡号 增加、修改、删除时均填写
                        item.addAttribute("mod_term_no", t.getModTermNo());
                        //操作后渔船编号
                        item.addAttribute("mod_vessel_id", String.valueOf(t.getShipId().hashCode()));
                        //操作前终端类型  修改和删除时填写，增加时此值无意义
                        item.addAttribute("ori_term_type", "");
                        //操作前终端卡号  修改和删除时填写，增加时此值无意义
                        item.addAttribute("ori_term_no", "");
                        //操作前渔船编号
                        item.addAttribute("ori_vessel_id", "");
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // 生成的文件放在对应的路径， true代表是否换行， 第三个为编码格式
                OutputFormat format = new OutputFormat("  ", true, "UTF-8");
                XMLWriter writer = new XMLWriter(
                    new OutputStreamWriter(new FileOutputStream(file), "UTF-8"),
                    format);
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
    public IBaseDao<TermInfo> getBaseDao() {
        return termInfoDao;
    }
    
    @Override
    protected LoggingManager logger() {
        return null;
    }
    
}
