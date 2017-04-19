/**
 * 文件名：InitListener.java
 * 版权： 航天恒星科技有限公司
 * 描述：〈描述〉
 * 修改时间：2015年11月30日
 * 修改内容：〈修改内容〉
 */
package com.c503.sc.gsd.listener;

import java.util.concurrent.Callable;

import javax.servlet.ServletContextEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.c503.sc.gsd.init.OrgFresh;
import com.c503.sc.gsd.init.TermInfoInit;
import com.c503.sc.gsd.init.VesselInfoInit;
import com.c503.sc.gsd.init.VesselTermRelInit;
import com.c503.sc.gsd.staticdata.service.impl.TermInfoServiceImpl;
import com.c503.sc.gsd.thread.ThreadPool;

/**
 * 
 * 〈一句话功能简述〉初始化上下文应用监听
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class InitListener extends ContextLoaderListener {
    
    /** 日志记录器 */
    private static Logger LOGGER =
        LogManager.getLogger(TermInfoServiceImpl.class);
    
    /** 上下文应用 */
    private ApplicationContext apct = null;
    
    /**
     * {@inheritDoc}
     *
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        if (null == apct) {
        	
            apct =
                WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
           //生成静态文件
            try {
            	OrgFresh orgFresh =  (OrgFresh) apct.getBean("orgFresh");
				orgFresh.findOrg();
				final VesselInfoInit vesselInfo =  (VesselInfoInit) apct.getBean("vesselInfo");
				final TermInfoInit termInfo =  (TermInfoInit) apct.getBean("termInfo");
				final VesselTermRelInit vesselTermRel =  (VesselTermRelInit) apct.getBean("vesselTermRel");
                ThreadPool.getThreadPool().submit(new Callable<Boolean>() {
                    @Override
                    public Boolean call(){
                    	vesselInfo.startVesselInfo();
                    	for (int i = 0; i < 100; i++) {
							System.out.println("1----------" + i);
						}
                    	return true;
                    }
                });
                //future
                ThreadPool.getThreadPool().submit(new Callable<Boolean>() {
                    @Override
                    public Boolean call(){
                    	termInfo.startTermInfo();
                    	for (int i = 101; i < 200; i++) {
							System.out.println("2+++++++++++++++" + i);
						}
                    	return true;
                    }
                });
                //future
                ThreadPool.getThreadPool().submit(new Callable<Boolean>() {
                    @Override
                    public Boolean call(){
                    	vesselTermRel.startRel();
                    	for (int i = 201; i < 300; i++) {
							System.out.println("3**********" + i);
						}
                    	return true;
                    }
                });
			} catch (Exception e) {
			    LOGGER.error(e);
			}
            
        }
    }
    
    /**
     * {@inheritDoc}
     *
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
