package com.forezp.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jh on 2017/7/25.
 */

@Entity
@Table(name = "bboss_http_rsp_log")
public class BBOSSHttpRspLog {

    @Id
    @GeneratedValue
    private Integer id;
    private String transationId;
    @Temporal(TemporalType.DATE)
    private Date responseTime;
    private String bipCode;
    private String activityCode;
    private String orderStatus;
    @Lob
    private byte[] xmlHead;
    @Lob
    private byte[] xmlBody;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransationId() {
        return transationId;
    }

    public void setTransationId(String transationId) {
        this.transationId = transationId;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public String getBipCode() {
        return bipCode;
    }

    public void setBipCode(String bipCode) {
        this.bipCode = bipCode;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public byte[] getXmlHead() {
        return xmlHead;
    }

    public void setXmlHead(byte[] xmlHead) {
        this.xmlHead = xmlHead;
    }

    public byte[] getXmlBody() {
        return xmlBody;
    }

    public void setXmlBody(byte[] xmlBody) {
        this.xmlBody = xmlBody;
    }
}
