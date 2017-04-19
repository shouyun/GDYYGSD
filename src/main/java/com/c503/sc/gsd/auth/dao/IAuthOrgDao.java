package com.c503.sc.gsd.auth.dao;

import org.springframework.stereotype.Repository;

import com.c503.sc.base.dao.IBaseDao;
import com.c503.sc.gsd.auth.model.AuthOrg;

/**
 * 
 * 〈一句话功能简述〉机构查询接口
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
@Repository(value = "authOrgDao")
public interface IAuthOrgDao extends IBaseDao<AuthOrg>{

}
