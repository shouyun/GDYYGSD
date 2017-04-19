package com.c503.sc.gsd.init;

import java.io.InputStream;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.c503.sc.gsd.auth.dao.IAuthOrgDao;
import com.c503.sc.gsd.auth.model.AuthOrg;
import com.c503.sc.gsd.common.StaticCache;
import com.c503.sc.gsd.staticdata.service.impl.TermInfoServiceImpl;
import com.c503.sc.utils.basetools.C503StringUtils;

/**
 * 
 * 〈一句话功能简述〉机构刷新
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
@Component("orgFresh")
public class OrgFresh {
    
    /** 日志记录器 */
    private static Logger LOGGER =
        LogManager.getLogger(TermInfoServiceImpl.class);
	
	 
    @Autowired
    private IAuthOrgDao authOrgService;
    
    /**
     * 默认刷新时间
     */
    private long time_space = 36000000;

    /**
     * 
     *〈一句话功能简述〉机构初始化构造函数
     * 〈功能详细描述〉
     * @see  [类、类#方法、类#成员]
     */
	public OrgFresh() {
		try {
			//由于构造函数比读配置执行时间更早， 所以需要自己读
			this.getPropertiesConfig();
		} catch (Exception e1) {
			LOGGER.error(e1);
		}
		//定时更新机构缓存
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					findOrg();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		//第一个数值意思：项目启动后多久再执行，第二个数值意思：定时执行的时间
		}, 36000000, time_space);
	}
	
	 /**
     * 
     *〈一句话功能简述〉获取配置的key值对
     * 〈功能详细描述〉
     * @return 配置的key值对
     * @throws Exception 系统异常
     * @see  [类、类#方法、类#成员]
     */
    private void getPropertiesConfig()
        throws Exception {
        InputStream in = getClass().getResourceAsStream(
            "/gsd.properties");
        Properties properties = new Properties();
        properties.load(in);
        Set<Entry<Object, Object>> keys = properties.entrySet();
        for (Entry<Object, Object> entry : keys) {
            String destField = ((String) entry.getKey()).trim();
            if (C503StringUtils.equals(destField, "org_time_fresh")) {
            	time_space = Long.valueOf(((String) entry.getValue()).trim());	
            	break;
			}
        }
    }

    /**
     * 
     *〈一句话功能简述〉查询机构
     * 〈功能详细描述〉
     * @return map缓存
     * @throws Exception 系统异常
     * @see  [类、类#方法、类#成员]
     */
    public ConcurrentHashMap<String, String> findOrg() throws Exception {
    	ConcurrentHashMap<String, String> map = StaticCache.getMap();
    	List<AuthOrg> list =  authOrgService.findAll();
    	for (AuthOrg authOrg : list) {
    		map.put(authOrg.getId(), authOrg.getName());
		}
    	return map;
	}

}
