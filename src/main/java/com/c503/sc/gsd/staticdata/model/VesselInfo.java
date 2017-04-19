/**
 * 文件名：VesselInfo.java
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
 * 〈一句话功能简述〉渔船基础信息操作记录文件实体
 * 〈功能详细描述〉
 * @author    shouy
 * @version   [版本号, 2017年2月14日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class VesselInfo  extends BaseEntity {

    /** 序列号 */
    private static final long serialVersionUID = 2818439860225928783L;
    
    /** 渔船编号 */
    private long vesselId;
    
    /** 渔船类型 */
    private String vesselType;
    
    /** 渔船名称 */
    private String vesselName;
    
    /** 总吨位 */
    private Double ton;
    
    /** 总功率 */
    private Double power;
    
    /** 渔船材料 */
    private String material;
    
    /** 最大航速  */
    private Double maxSpeed;
    
    /** 船长姓名 */
    private String captainName;
    
    /** 船长联系电话 */
    private String captainTel;
    
    /** 船主 */
    private String vesselOwner;
    
    /** 属地  */
    private String vesselRegion;
    
    /** 直接所属单位 */
    private String directOrg;
    
    /** 直接所属单位 */
    private String deptId;
    
    /** 入库时间 */
    private Date loadTime;
    
    /** 数据来源  */
    private int infoSource;
    
    /** 操作代码  1：增加、2：编辑、3：删除 */
    private long operCode;
    
    /** 操作时间 以1970年1月1日零时（UTC时间）起算的秒整数 */
    private Date operTime;
    

    /**
     * 〈一句话功能简述〉获取渔船编号
     *  @return vesselId 渔船编号 
     */
    public long getVesselId() {
        return vesselId;
    }




    /**
     * 〈一句话功能简述〉 设置渔船编号 
     *  @param  vesselId 渔船编号 
     */
    public void setVesselId(long vesselId) {
        this.vesselId = vesselId;
    }




    /**
     * 〈一句话功能简述〉获取渔船类型
     *  @return vesselType 渔船类型 
     */
    public String getVesselType() {
        return vesselType;
    }




    /**
     * 〈一句话功能简述〉 设置渔船类型 
     *  @param  vesselType 渔船类型 
     */
    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }




    /**
     * 〈一句话功能简述〉获取渔船名称
     *  @return vesselName 渔船名称 
     */
    public String getVesselName() {
        return vesselName;
    }




    /**
     * 〈一句话功能简述〉 设置vesselName 
     *  @param  vesselName vesselName 
     */
    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }




    /**
     * 〈一句话功能简述〉获取总吨位
     *  @return ton 总吨位 
     */
    public Double getTon() {
        return ton;
    }




    /**
     * 〈一句话功能简述〉 设置ton 
     *  @param  ton ton 
     */
    public void setTon(Double ton) {
        this.ton = ton;
    }




    /**
     * 〈一句话功能简述〉获取总功率
     *  @return power 总功率 
     */
    public Double getPower() {
        return power;
    }




    /**
     * 〈一句话功能简述〉 设置power 
     *  @param  power power 
     */
    public void setPower(Double power) {
        this.power = power;
    }




    /**
     * 〈一句话功能简述〉获取渔船材料
     *  @return material 渔船材料 
     */
    public String getMaterial() {
        return material;
    }




    /**
     * 〈一句话功能简述〉 设置material 
     *  @param  material material 
     */
    public void setMaterial(String material) {
        this.material = material;
    }




    /**
     * 〈一句话功能简述〉获取最大航速
     *  @return maxSpeed 最大航速 
     */
    public Double getMaxSpeed() {
        return maxSpeed;
    }




    /**
     * 〈一句话功能简述〉 设置最大航速 
     *  @param  maxSpeed 最大航速 
     */
    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }




    /**
     * 〈一句话功能简述〉获取船长姓名
     *  @return captainName 船长姓名 
     */
    public String getCaptainName() {
        return captainName;
    }




    /**
     * 〈一句话功能简述〉 设置船长姓名 
     *  @param  captainName 船长姓名 
     */
    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }




    /**
     * 〈一句话功能简述〉获取船长联系电话
     *  @return captainTel 船长联系电话 
     */
    public String getCaptainTel() {
        return captainTel;
    }




    /**
     * 〈一句话功能简述〉 设置船长联系电话 
     *  @param  captainTel 船长联系电话 
     */
    public void setCaptainTel(String captainTel) {
        this.captainTel = captainTel;
    }




    /**
     * 〈一句话功能简述〉获取船主
     *  @return vesselOwner 船主 
     */
    public String getVesselOwner() {
        return vesselOwner;
    }




    /**
     * 〈一句话功能简述〉 设置船主 
     *  @param  vesselOwner 船主 
     */
    public void setVesselOwner(String vesselOwner) {
        this.vesselOwner = vesselOwner;
    }




    /**
     * 〈一句话功能简述〉获取属地
     *  @return vesselRegion 属地 
     */
    public String getVesselRegion() {
        return vesselRegion;
    }




    /**
     * 〈一句话功能简述〉 设置属地 
     *  @param  vesselRegion 属地 
     */
    public void setVesselRegion(String vesselRegion) {
        this.vesselRegion = vesselRegion;
    }




    /**
     * 〈一句话功能简述〉获取直接所属单位 
     *  @return directOrg 直接所属单位  
     */
    public String getDirectOrg() {
        return directOrg;
    }




    /**
     * 〈一句话功能简述〉 设置直接所属单位  
     *  @param  directOrg 直接所属单位  
     */
    public void setDirectOrg(String directOrg) {
        this.directOrg = directOrg;
    }




    /**
     * 〈一句话功能简述〉获取直接所属单位
     *  @return deptId 直接所属单位 
     */
    public String getDeptId() {
        return deptId;
    }




    /**
     * 〈一句话功能简述〉 设置直接所属单位 
     *  @param  deptId 直接所属单位 
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }




    /**
     * 〈一句话功能简述〉获取入库时间 
     *  @return loadTime 入库时间  
     */
    public Date getLoadTime() {
        return loadTime;
    }




    /**
     * 〈一句话功能简述〉 设置入库时间  
     *  @param  loadTime 入库时间  
     */
    public void setLoadTime(Date loadTime) {
        this.loadTime = loadTime;
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
