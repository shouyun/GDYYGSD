/**
 * 文件名：VesselTermRelation.java
 * 版权： 航天恒星科技有限公司
 * 描述：〈描述〉
 * 修改时间：2017年2月14日 
 * 修改内容：〈修改内容〉
 */
package com.c503.sc.gsd.staticdata.model;

import java.util.Date;

import com.c503.sc.base.entity.BaseEntity;

/**
 * 
 * 〈一句话功能简述〉渔船与终端关系操作记录表实体
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月14日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class VesselTermRelation  extends BaseEntity{

    /** 序列号 */
    private static final long serialVersionUID = -1611986712953168461L;
    
    /** 操作前渔船编号  修改和删除时填写，增加时此值无意义（新增字段） */
    private String oriVesselId;
    
    /**  操作前终端类型 修改和删除时填写，增加时此值无意义（新增字段） */
    private String oriTermType;
    
    /** 操作前终端卡号   修改和删除时填写，增加时此值无意义（新增字段） */
    private String oriTermNo;
    
    /** 操作后渔船编号     增加、修改、删除时均填写 */
    private String modVesselId;
    
    /** 操作后终端类型  增加、修改、删除时均填写 */
    private String modTermType;
    
    /** 操作后的渔船id */
    private String modShipId;
    
    /** 操作后的终端 */
    private String modTerminalType;
    
    /** 操作后终端卡号  增加、修改、删除时均填写 */
    private String modTermNo;
    
    /** 数据来源  */
    private int infoSource;
    
    /** 操作代码  1：增加、2：编辑、3：删除 */
    private long operCode;
    
    /** 操作时间 以1970年1月1日零时（UTC时间）起算的秒整数 */
    private Date operTime;
    
    
    
    /**
     * 〈一句话功能简述〉获取操作前渔船编号
     *  @return oriVesselId 操作前渔船编号 
     */
    public String getOriVesselId() {
        return oriVesselId;
    }





    /**
     * 〈一句话功能简述〉 设置操作前渔船编号 
     *  @param  oriVesselId 操作前渔船编号 
     */
    public void setOriVesselId(String oriVesselId) {
        this.oriVesselId = oriVesselId;
    }





    /**
     * 〈一句话功能简述〉获取操作前终端类型
     *  @return oriTermType 操作前终端类型 
     */
    public String getOriTermType() {
        return oriTermType;
    }





    /**
     * 〈一句话功能简述〉 设置操作前终端类型 
     *  @param  oriTermType 操作前终端类型 
     */
    public void setOriTermType(String oriTermType) {
        this.oriTermType = oriTermType;
    }





    /**
     * 〈一句话功能简述〉获取操作前终端卡号
     *  @return oriTermNo 操作前终端卡号 
     */
    public String getOriTermNo() {
        return oriTermNo;
    }





    /**
     * 〈一句话功能简述〉 设置操作前终端卡号 
     *  @param  oriTermNo 操作前终端卡号 
     */
    public void setOriTermNo(String oriTermNo) {
        this.oriTermNo = oriTermNo;
    }





    /**
     * 〈一句话功能简述〉获取操作后的渔船id
     *  @return modVesselId 操作后的渔船id 
     */
    public String getModVesselId() {
        return modVesselId;
    }





    /**
     * 〈一句话功能简述〉 设置操作后的渔船id 
     *  @param  modVesselId 操作后的渔船id 
     */
    public void setModVesselId(String modVesselId) {
        this.modVesselId = modVesselId;
    }





    /**
     * 〈一句话功能简述〉获取操作后终端类型
     *  @return modTermType 操作后终端类型 
     */
    public String getModTermType() {
        return modTermType;
    }





    /**
     * 〈一句话功能简述〉 设置操作后终端类型 
     *  @param  modTermType 操作后终端类型 
     */
    public void setModTermType(String modTermType) {
        this.modTermType = modTermType;
    }





    /**
     * 〈一句话功能简述〉获取操作后的渔船id
     *  @return modShipId 操作后的渔船id 
     */
    public String getModShipId() {
        return modShipId;
    }





    /**
     * 〈一句话功能简述〉 设置操作后的渔船id 
     *  @param  modShipId 操作后的渔船id 
     */
    public void setModShipId(String modShipId) {
        this.modShipId = modShipId;
    }





    /**
     * 〈一句话功能简述〉获取操作后的终端
     *  @return modTerminalType 操作后的终端 
     */
    public String getModTerminalType() {
        return modTerminalType;
    }





    /**
     * 〈一句话功能简述〉 设置操作后的终端 
     *  @param  modTerminalType 操作后的终端 
     */
    public void setModTerminalType(String modTerminalType) {
        this.modTerminalType = modTerminalType;
    }





    /**
     * 〈一句话功能简述〉获取操作后终端卡号 
     *  @return modTermNo 操作后终端卡号  
     */
    public String getModTermNo() {
        return modTermNo;
    }





    /**
     * 〈一句话功能简述〉 设置操作后终端卡号  
     *  @param  modTermNo 操作后终端卡号  
     */
    public void setModTermNo(String modTermNo) {
        this.modTermNo = modTermNo;
    }





    /**
     * 〈一句话功能简述〉获取数据来源
     *  @return infoSource 数据来源 
     */
    public int getInfoSource() {
        return infoSource;
    }



    /**
     * 〈一句话功能简述〉 设置数据来源 
     *  @param  infoSource 数据来源 
     */
    public void setInfoSource(int infoSource) {
        this.infoSource = infoSource;
    }



    /**
     * 〈一句话功能简述〉获取操作代码  1：增加、2：编辑、3：删除
     *  @return operCode 操作代码  1：增加、2：编辑、3：删除 
     */
    public long getOperCode() {
        return operCode;
    }



    /**
     * 〈一句话功能简述〉 设置操作代码  1：增加、2：编辑、3：删除 
     *  @param  operCode 操作代码  1：增加、2：编辑、3：删除 
     */
    public void setOperCode(long operCode) {
        this.operCode = operCode;
    }



    /**
     * 〈一句话功能简述〉获取操作时间
     *  @return operTime 操作时间 
     */
    public Date getOperTime() {
        return operTime;
    }



    /**
     * 〈一句话功能简述〉 设置操作时间 
     *  @param  operTime 操作时间 
     */
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }


    @Override
    protected Object getBaseEntity() {
        return  this;
    }
    
}
