package com.c503.sc.gsd.auth.model;

/***
 * 
 * 〈一句话功能简述〉机构实体
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月17日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class AuthOrg {
	
    /**
     * 机构id
     */
	private String id;
	
	/**
	 * 机构名称
	 */
	private String name;

	/**
	 * 
	 *〈一句话功能简述〉获取机构id
	 * 〈功能详细描述〉
	 * @return 机构id
	 * @see  [类、类#方法、类#成员]
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 *〈一句话功能简述〉设置机构id
	 * 〈功能详细描述〉
	 * @param id 机构id
	 * @see  [类、类#方法、类#成员]
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
     * 
     *〈一句话功能简述〉获取机构名称
     * 〈功能详细描述〉
     * @return 机构名称
     * @see  [类、类#方法、类#成员]
     */
	public String getName() {
		return name;
	}

	/**
	 * 
	 *〈一句话功能简述〉设置机构名称
	 * 〈功能详细描述〉
	 * @param name 机构名称
	 * @see  [类、类#方法、类#成员]
	 */
	public void setName(String name) {
		this.name = name;
	}

}
