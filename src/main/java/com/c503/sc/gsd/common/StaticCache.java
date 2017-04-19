package com.c503.sc.gsd.common;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * 〈一句话功能简述〉 缓存区，缓存机构
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class StaticCache {
    
    /** 常量，存放机构 */
    private static ConcurrentHashMap<String, String> map = null;
    
    /** 私有构造器 */
    private StaticCache() {
        
    }
    
    /**
     * 〈一句话功能简述〉方法同步
     * 〈功能详细描述〉
     * 
     * @return ConcurrentHashMap
     * @see [类、类#方法、类#成员]
     */
    public static synchronized ConcurrentHashMap<String, String> getMap() {
        if (null == map) {
            map = new ConcurrentHashMap<String, String>();
        }
        return map;
    }
    
}
