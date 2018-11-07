package edu.ncu.model;


import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * @author forward
 * 告警数据的实体类
 */
public class Warning {
    /**
     * id
     * deviceId 告警设备的id
     * oid 告警指标的oid
     * degree 告警级别
     * status 告警状态
     * warning 告警发生时间
     */
    private String id;
    private String deviceId;
    private String oid;
    private String degree;
    private String status;
    private Date warningTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getWarningTime() {
        return warningTime;
    }

    public void setWarningTime(Date warningTime) {
        this.warningTime = warningTime;
    }

    public boolean equals(Warning other){
        //暂时不把处理状态作为判断相等的条件
        if (StringUtils.isNotEmpty(this.deviceId) && StringUtils.isNotEmpty(other.deviceId) && this.deviceId.equals(other.deviceId) &&
        StringUtils.isNotEmpty(this.oid) && StringUtils.isNotEmpty(other.oid) && this.oid.equals(other.oid) &&
        StringUtils.isNotEmpty(this.degree) && StringUtils.isNotEmpty(other.degree) && this.degree.equals(other.degree)
            /*&& StringUtils.isNotEmpty(this.status) && StringUtils.isNotEmpty(other.status) && this.status.equals(other.status)*/
        ){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "device: "+deviceId+", oid: "+oid+", degree: "+degree+" ";
    }
}
