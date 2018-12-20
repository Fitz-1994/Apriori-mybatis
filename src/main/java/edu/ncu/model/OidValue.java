package edu.ncu.model;

import java.util.Date;

public class OidValue {
    private String id;
    private String oidId;
    private String deviceIp;
    private String oid;
    private Double oidValue;
    private Date produceTime;
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOidId() {
        return oidId;
    }

    public void setOidId(String oidId) {
        this.oidId = oidId;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Double getOidValue() {
        return oidValue;
    }

    public void setOidValue(Double oidValue) {
        this.oidValue = oidValue;
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
