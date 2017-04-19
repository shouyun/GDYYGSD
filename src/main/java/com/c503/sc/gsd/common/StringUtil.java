package com.c503.sc.gsd.common;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

import com.c503.sc.utils.basetools.C503StringUtils;

/**
 * 
 * 〈一句话功能简述〉 string类工具转换
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class StringUtil {
    
    /**
     * 
     *〈一句话功能简述〉数值转字符
     * 〈功能详细描述〉 
     * @param num 数值
     * @return 字符
     * @see  [类、类#方法、类#成员]
     */
    public static String numToString(Double num) {
        return (num == null) ? "" : String.valueOf(num);
    }
    
    /**
     * 
     *〈一句话功能简述〉判断文件路径是否已经存在
     * 〈功能详细描述〉
     * @param path 文件路径
     * @see  [类、类#方法、类#成员]
     */
    public static void judgeFileDir(String path) {
        File file = new File(path);
        // 如果文件夹不存在则创建
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("目录不存在！");
            file.mkdirs();
        }
        else {
            System.out.println("目录已经存在！");
        }
    }
    
    /**
     * 
     *〈一句话功能简述〉 船体材质转换
     * 〈功能详细描述〉
     * @param code 船体材质字典码
     * @return 船体材质
     * @see  [类、类#方法、类#成员]
     */
    public static String getDictMaterial(String code) {
        String name = "";
        if (C503StringUtils.isNoneEmpty(code)) {
            switch (code) {
                case DictConstant.SHIP_MATERIAL_STEEL:
                    name = "钢质";
                    break;
                case DictConstant.SHIP_MATERIAL_WOOD:
                    name = "木质";
                    break;
                case DictConstant.SHIP_MATERIAL_GRP:
                    name = "玻璃钢";
                    break;
                case DictConstant.SHIP_MATERIAL_CEMENT:
                    name = "水泥";
                    break;
                case DictConstant.SHIP_MATERIAL_ALUFER:
                    name = "铝合金";
                    break;
                default:
                    name = "其他";
                    break;
            }
        }
        return name;
    }
    
    /**
     * 
     *〈一句话功能简述〉渔船类型
     * 〈功能详细描述〉
     * @param code 渔船类型字典码
     * @return 渔船类型
     * @see  [类、类#方法、类#成员]
     */
    public static String getDictShipType(String code) {
        String name = "";
        if (C503StringUtils.isNoneEmpty(code)) {
            switch (code) {
                case DictConstant.SHIP_CATCH:
                    name = "1";
                    break;
                case DictConstant.SHIP_ASSIST:
                    name = "2";
                    break;
                case DictConstant.SHIP_ENFORCE_LAW:
                    name = "3";
                    break;
                case DictConstant.SHIP_ENFORCE_LAW_SPEED:
                    name = "4";
                    break;
                case DictConstant.SHIP_SAND_EXCAVATION:
                    name = "5";
                    break;
                case DictConstant.SHIP_BUSINESS:
                    name = "6";
                    break;
                case DictConstant.SHIP_ANTI_LAW:
                    name = "7";
                    break;
                case DictConstant.SHIP_NANSHA_PRODUCT:
                    name = "8";
                    break;
                case DictConstant.SHIP_FLOW_NANSHA:
                    name = "9";
                    break;
                case DictConstant.SHIP_FLOW_GENERAL:
                    name = "10";
                    break;
                default:
                    name = "";
                    break;
            }
        }
        return name;
    }
    
    /**
     * 
     *〈一句话功能简述〉终端状态判断
     * 〈功能详细描述〉
     * @param code 状态码
     * @return 对应的码
     * @see  [类、类#方法、类#成员]
     */
    public static String judgeTermStatus(String code) {
        //默认为正常
        String status = String.valueOf(DictConstant.TERMINAL_STATUS_NORMAL);
        //
        if (C503StringUtils.isNoneEmpty(code)) {
            status = String.valueOf(DictConstant.TERMINAL_STATUS_FAULT);
        }
        return status;
    }
    
    /**
     * 
     *〈一句话功能简述〉机构id转名称
     * 〈功能详细描述〉
     * @param code 机构id
     * @param map 机构缓存
     * @return 机构名称
     * @see  [类、类#方法、类#成员]
     */
    public static String findOrgName(String code,
        ConcurrentHashMap<String, String> map) {
        String status = "";
        if (C503StringUtils.isNoneEmpty(code)) {
            status = map.get(code);
        }
        return status;
    }
    
    /**
     * 
     *〈一句话功能简述〉 终端类型转换
     * 〈功能详细描述〉
     * @param code 船体材质字典码
     * @return 船体材质
     * @see  [类、类#方法、类#成员]
     */
    public static String getDictTermType(String code) {
        String name = "";
        if (C503StringUtils.isNoneEmpty(code)) {
            switch (code) {
                case DictConstant.TERMINAL_BEIDOU:
                    name = String.valueOf(DictConstant.BEIDOU_TERMINAL_ONE);
                    break;
                case DictConstant.TERMINAL_HANDHOLD:
                    name = String.valueOf(DictConstant.GSM_TERMINAL);
                    break;
                case DictConstant.TERMINAL_230MHZ:
                    name = String.valueOf(DictConstant.TTZMHZ_TERMINAL);
                    break;
                case DictConstant.TERMINAL_90C:
                    name = String.valueOf(DictConstant.NZC_TERMINAL);
                    break;
                case DictConstant.TERMINAL_AIS:
                    name = String.valueOf(DictConstant.AIS_TERMINAL_CLASSA);
                    break;
                case DictConstant.TERMINAL_AIS_CLASS_A:
                    name = String.valueOf(DictConstant.AIS_TERMINAL_CLASSA);
                    break;
                case DictConstant.TERMINAL_AIS_CLASS_B:
                    name = String.valueOf(DictConstant.AIS_TERMINAL_CLASSB);
                    break;
                case DictConstant.LOCAL_SECTION_NOREGISTER:
                    name = String.valueOf(DictConstant.AIS_TERMINAL_CLASSA);
                    break;
                default:
                    name = "";
                    break;
            }
        }
        return name;
    }
    
}
