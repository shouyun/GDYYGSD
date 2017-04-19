/**
2 * 文件名：VesselInfoServiceImpl.java
 * 版权： 航天恒星科技有限公司
 * 描述：〈描述〉
 * 修改时间：2017年2月14日 
 * 修改内容：〈修改内容〉
 */
package com.c503.sc.gsd.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.c503.sc.base.dao.IBaseDao;
import com.c503.sc.base.service.impl.BaseServiceImpl;
import com.c503.sc.gsd.auth.dao.IAuthOrgDao;
import com.c503.sc.gsd.auth.model.AuthOrg;
import com.c503.sc.gsd.auth.service.IAuthOrgService;
import com.c503.sc.gsd.common.CommonConstant;
import com.c503.sc.log.LoggingManager;
import com.c503.sc.utils.common.SystemContants;

/**
 * 
 * 〈一句话功能简述〉机构查询实现类
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
@Service
public class AuthOrgServiceImpl extends BaseServiceImpl<AuthOrg> implements IAuthOrgService{
    
    /** 日志记录器 */
    private static Logger LOGGER = LogManager.getLogger(AuthOrgServiceImpl.class);
    
    /**
     * 注入dao接口
     */
    @Resource(name = "authOrgDao")
    private IAuthOrgDao authOrgDao;
    
    @Override
    public List<AuthOrg> findAll()
        throws Exception {
        // 记录程序进入方法调试日志
        LOGGER.debug(SystemContants.DEBUG_START);
        List<AuthOrg> list = null;
        try{
            //查询该时间间隔的内容
            list = this.authOrgDao.findAll();
            LOGGER.info(CommonConstant.FIND_SUC_OPTION);
        }catch(Exception e){
            transactionException(CommonConstant.SYS_EXCEPTION, e);
            LOGGER.error(e);
        }
        return list;
    }
    
    @Override
    public IBaseDao<AuthOrg> getBaseDao() {
        return authOrgDao;
    }

	@Override
	protected LoggingManager logger() {
		return null;
	}
    
}
