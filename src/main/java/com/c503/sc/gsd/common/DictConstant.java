/**
 * 文件名：DictConstant.java
 * 版权： 航天恒星科技有限公司
 * 描述：〈描述〉
 * 修改时间：2017年2月17日
 * 修改内容：〈修改内容〉
 */
package com.c503.sc.gsd.common;

/**
 * 
 * 〈一句话功能简述〉字典常量
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class DictConstant {
    
    // 终端类型
    /** 海事运营商1终端 */
    public static final int MARITIME_TERMINAL_ONE = 1001;
    
    /** 海事运营商2终端 */
    public static final int MARITIME_TERMINAL_TWO = 1002;
    
    /** 北斗运营商1终端 */
    public static final int BEIDOU_TERMINAL_ONE = 1101;
    
    /** 北斗运营商2终端 */
    public static final int BEIDOU_TERMINAL_TWO = 1102;
    
    /** AIS CLASSA */
    public static final int AIS_TERMINAL_CLASSA = 1201;
    
    /** AIS CLASSB */
    public static final int AIS_TERMINAL_CLASSB = 1201;
    
    /** GSM终端 */
    public static final int GSM_TERMINAL = 1301;
    
    /** CDMA终端 */
    public static final int CDMA_TERMINAL = 1302;
    
    /** GSM终端 */
    public static final int TTZMHZ_TERMINAL = 1401;
    
    /** CDMA终端 */
    public static final int NZC_TERMINAL = 1501;
    
    // 终端状态定义
    /** 正常 */
    public static final int TERMINAL_STATUS_NORMAL = 0;
    
    /** 终端故障 */
    public static final int TERMINAL_STATUS_FAULT = 1;
    
    // 信息来源定义
    /** 广东省 */
    public static final int GUANGDONG = 10;
    
    // 操作代码
    /** 新增 */
    public static final int ADD_OPTION = 1;
    
    /** 编辑 */
    public static final int EDIT_OPTION = 2;
    
    /** 删除 */
    public static final int DELETE_OPTION = 3;
    
    // 渔船类型
    /** 船舶类型：捕捞船 */
    public static final String SHIP_CATCH = "151001000";
    
    /** 船舶类型：辅助船 */
    public static final String SHIP_ASSIST = "151001001";
    
    /** 船舶类型：执法船 */
    public static final String SHIP_ENFORCE_LAW = "151001002";
    
    /** 船舶类型：执法快艇 */
    public static final String SHIP_ENFORCE_LAW_SPEED = "151001003";
    
    /** 船舶类型：采砂船 */
    public static final String SHIP_SAND_EXCAVATION = "151001004";
    
    /** 船舶类型：商船 */
    public static final String SHIP_BUSINESS = "151001005";
    
    /** 船舶类型：抗法船 */
    public static final String SHIP_ANTI_LAW = "151001006";
    
    /** 船舶类型：南沙生产船 */
    public static final String SHIP_NANSHA_PRODUCT = "151001007";
    
    /** 船舶类型：港澳流动船（南沙组） */
    public static final String SHIP_FLOW_NANSHA = "151001008";
    
    /** 船舶类型：港澳流动船（普通组） */
    public static final String SHIP_FLOW_GENERAL = "151001009";
    
    /** 渔船 */
    public static final int SHIP_TYPE_FISH = 0;
    
    /** 渔政船 */
    public static final int SHIP_TYPE_LAW = 1;
    
    /** 搜救船 */
    public static final int SHIP_TYPE_HELP = 2;
    
    /** 渔业养殖船 */
    public static final int SHIP_TYPE_BREED = 3;
    
    // 单位
    /** 航速单位：节 */
    public static final String SPEED_UNIT = "节";
    
    /** 总吨位单位：吨 */
    public static final String TON_UNIT = "吨";
    
    /** 总功率单位：千瓦 */
    public static final String POWER_UNIT = "千瓦";
    
    /** 船体材质-钢质 */
    public static final String SHIP_MATERIAL_STEEL = "134001001";
    
    /** 船体材质-木质 */
    public static final String SHIP_MATERIAL_WOOD = "134001002";
    
    /** 船体材质-玻璃钢 */
    public static final String SHIP_MATERIAL_GRP = "134001003";
    
    /** 船体材质-水泥 */
    public static final String SHIP_MATERIAL_CEMENT = "134001004";
    
    /** 船体材质-铝合金 */
    public static final String SHIP_MATERIAL_ALUFER = "134001005";
    
    //终端类型
    /** 终端类型：北斗终端 */
    public static final String TERMINAL_BEIDOU = "150001001";
    
    /** 终端类型：手持终端 */
    public static final String TERMINAL_HANDHOLD = "150001002";
    
    /** 终端类型：230MHz终端 */
    public static final String TERMINAL_230MHZ = "150001003";
    
    /** 终端类型： 90c终端 */
    public static final String TERMINAL_90C = "150001004";
    
    /** 终端类型： AIS终端 */
    public static final String TERMINAL_AIS = "150001005";
    
    /** 终端类型： AIS_A终端 */
    public static final String TERMINAL_AIS_CLASS_A = "150001006";
    
    /** 终端类型： AIS_B终端 */
    public static final String TERMINAL_AIS_CLASS_B = "150001007";
    
    /** 本省号段内未注册AIS终端 */
    public static final String LOCAL_SECTION_NOREGISTER = "150001008";
    
}
