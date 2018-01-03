//
// ????????? JavaTM Architecture for XML Binding (JAXB) ??????? v2.2.8-b130911.1802 ?????
// ????? <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// ?????±???????, ???????????????????????
// ???????: 2017.07.12 ??? 03:53:34 PM CST 
//


package com.forezp.entity.xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>anonymous complex type?? Java ??
 * 
 * <p>??????????????????????е?????????
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Version">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TestFlag">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BIPType">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BIPCode">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="8"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ActivityCode">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="8"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ActionCode">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RoutingInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OrigDomain">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RouteType">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Routing" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="HomeDomain">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;length value="4"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="RouteValue">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="20"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TransInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SessionID">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="30"/>
 *                         &lt;minLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TransIDO">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="30"/>
 *                         &lt;minLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TransIDOTime">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="(\d{4})((0[1-9])|(1[0-2]))((0[1-9])|([1-2]\d)|(3[0-1]))(([0-1]\d)|(2[0-3]))([0-5]\d)([0-5]\d)"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TransIDH" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="30"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TransIDHTime" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="(\d{4})((0[1-9])|(1[0-2]))((0[1-9])|([1-2]\d)|(3[0-1]))(([0-1]\d)|(2[0-3]))([0-5]\d)([0-5]\d)"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SNReserve" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TransIDC">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ConvID">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CutOffDay">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="8"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OSNTime">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OSNDUNS">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="HSNDUNS">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="MsgSender">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="MsgReceiver">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Priority" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ServiceLevel" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Response" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RspType">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RspCode">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RspDesc">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="128"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SvcCont" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "version",
    "testFlag",
    "bipType",
    "routingInfo",
    "transInfo",
    "snReserve",
    "response",
    "svcCont"
})
@XmlRootElement(name = "InterBOSS")
public class InterBOSS {

    @XmlElement(name = "Version", required = true)
    protected String version;
    @XmlElement(name = "TestFlag", required = true)
    protected String testFlag;
    @XmlElement(name = "BIPType", required = true)
    protected BIPType bipType;
    @XmlElement(name = "RoutingInfo", required = true)
    protected RoutingInfo routingInfo;
    @XmlElement(name = "TransInfo", required = true)
    protected TransInfo transInfo;
    @XmlElement(name = "SNReserve")
    protected SNReserve snReserve;
    @XmlElement(name = "Response")
    protected Response response;
    @XmlElement(name = "SvcCont")
    protected SvcCont svcCont;

    /**
     * ???version????????
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * ????version????????
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * ???testFlag????????
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestFlag() {
        return testFlag;
    }

    /**
     * ????testFlag????????
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestFlag(String value) {
        this.testFlag = value;
    }

    /**
     * ???bipType????????
     * 
     * @return
     *     possible object is
     *     {@link BIPType }
     *     
     */
    public BIPType getBIPType() {
        return bipType;
    }

    /**
     * ????bipType????????
     * 
     * @param value
     *     allowed object is
     *     {@link BIPType }
     *     
     */
    public void setBIPType(BIPType value) {
        this.bipType = value;
    }

    /**
     * ???routingInfo????????
     * 
     * @return
     *     possible object is
     *     {@link RoutingInfo }
     *     
     */
    public RoutingInfo getRoutingInfo() {
        return routingInfo;
    }

    /**
     * ????routingInfo????????
     * 
     * @param value
     *     allowed object is
     *     {@link RoutingInfo }
     *     
     */
    public void setRoutingInfo(RoutingInfo value) {
        this.routingInfo = value;
    }

    /**
     * ???transInfo????????
     * 
     * @return
     *     possible object is
     *     {@link TransInfo }
     *     
     */
    public TransInfo getTransInfo() {
        return transInfo;
    }

    /**
     * ????transInfo????????
     * 
     * @param value
     *     allowed object is
     *     {@link TransInfo }
     *     
     */
    public void setTransInfo(TransInfo value) {
        this.transInfo = value;
    }

    /**
     * ???snReserve????????
     * 
     * @return
     *     possible object is
     *     {@link SNReserve }
     *     
     */
    public SNReserve getSNReserve() {
        return snReserve;
    }

    /**
     * ????snReserve????????
     * 
     * @param value
     *     allowed object is
     *     {@link SNReserve }
     *     
     */
    public void setSNReserve(SNReserve value) {
        this.snReserve = value;
    }

    /**
     * ???response????????
     * 
     * @return
     *     possible object is
     *     {@link Response }
     *     
     */
    public Response getResponse() {
        return response;
    }

    /**
     * ????response????????
     * 
     * @param value
     *     allowed object is
     *     {@link Response }
     *     
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * ???svcCont????????
     * 
     * @return
     *     possible object is
     *     {@link SvcCont }
     *     
     */
    public SvcCont getSvcCont() {
        return svcCont;
    }

    /**
     * ????svcCont????????
     * 
     * @param value
     *     allowed object is
     *     {@link SvcCont }
     *     
     */
    public void setSvcCont(SvcCont value) {
        this.svcCont = value;
    }


    /**
     * <p>anonymous complex type?? Java ??
     * 
     * <p>??????????????????????е?????????
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BIPCode">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="8"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ActivityCode">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="8"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ActionCode">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bipCode",
        "activityCode",
        "actionCode"
    })
    public static class BIPType {

        @XmlElement(name = "BIPCode", required = true)
        protected String bipCode;
        @XmlElement(name = "ActivityCode", required = true)
        protected String activityCode;
        @XmlElement(name = "ActionCode", required = true)
        protected String actionCode;

        /**
         * ???bipCode????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBIPCode() {
            return bipCode;
        }

        /**
         * ????bipCode????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBIPCode(String value) {
            this.bipCode = value;
        }

        /**
         * ???activityCode????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActivityCode() {
            return activityCode;
        }

        /**
         * ????activityCode????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActivityCode(String value) {
            this.activityCode = value;
        }

        /**
         * ???actionCode????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActionCode() {
            return actionCode;
        }

        /**
         * ????actionCode????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActionCode(String value) {
            this.actionCode = value;
        }

    }


    /**
     * <p>anonymous complex type?? Java ??
     * 
     * <p>??????????????????????е?????????
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="RspType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RspCode">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RspDesc">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="128"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rspType",
        "rspCode",
        "rspDesc"
    })
    public static class Response {

        @XmlElement(name = "RspType", required = true)
        protected String rspType;
        @XmlElement(name = "RspCode", required = true)
        protected String rspCode;
        @XmlElement(name = "RspDesc", required = true)
        protected String rspDesc;

        /**
         * ???rspType????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRspType() {
            return rspType;
        }

        /**
         * ????rspType????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRspType(String value) {
            this.rspType = value;
        }

        /**
         * ???rspCode????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRspCode() {
            return rspCode;
        }

        /**
         * ????rspCode????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRspCode(String value) {
            this.rspCode = value;
        }

        /**
         * ???rspDesc????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRspDesc() {
            return rspDesc;
        }

        /**
         * ????rspDesc????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRspDesc(String value) {
            this.rspDesc = value;
        }

    }


    /**
     * <p>anonymous complex type?? Java ??
     * 
     * <p>??????????????????????е?????????
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="OrigDomain">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RouteType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Routing" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="HomeDomain">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;length value="4"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="RouteValue">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="20"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "origDomain",
        "routeType",
        "routing"
    })
    public static class RoutingInfo {

        @XmlElement(name = "OrigDomain", required = true)
        protected String origDomain;
        @XmlElement(name = "RouteType", required = true)
        protected String routeType;
        @XmlElement(name = "Routing", required = true)
        protected List<Routing> routing;

        /**
         * ???origDomain????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrigDomain() {
            return origDomain;
        }

        /**
         * ????origDomain????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrigDomain(String value) {
            this.origDomain = value;
        }

        /**
         * ???routeType????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRouteType() {
            return routeType;
        }

        /**
         * ????routeType????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRouteType(String value) {
            this.routeType = value;
        }

        /**
         * Gets the value of the routing property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the routing property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRouting().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Routing }
         * 
         * 
         */
        public List<Routing> getRouting() {
            if (routing == null) {
                routing = new ArrayList<Routing>();
            }
            return this.routing;
        }


        /**
         * <p>anonymous complex type?? Java ??
         * 
         * <p>??????????????????????е?????????
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="HomeDomain">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;length value="4"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="RouteValue">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="20"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "homeDomain",
            "routeValue"
        })
        public static class Routing {

            @XmlElement(name = "HomeDomain", required = true)
            protected String homeDomain;
            @XmlElement(name = "RouteValue", required = true)
            protected String routeValue;

            /**
             * ???homeDomain????????
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHomeDomain() {
                return homeDomain;
            }

            /**
             * ????homeDomain????????
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHomeDomain(String value) {
                this.homeDomain = value;
            }

            /**
             * ???routeValue????????
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRouteValue() {
                return routeValue;
            }

            /**
             * ????routeValue????????
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRouteValue(String value) {
                this.routeValue = value;
            }

        }

    }


    /**
     * <p>anonymous complex type?? Java ??
     * 
     * <p>??????????????????????е?????????
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="TransIDC">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="60"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ConvID">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="60"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CutOffDay">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="8"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OSNTime">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OSNDUNS">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="HSNDUNS">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="MsgSender">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="MsgReceiver">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Priority" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ServiceLevel" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "transIDC",
        "convID",
        "cutOffDay",
        "osnTime",
        "osnduns",
        "hsnduns",
        "msgSender",
        "msgReceiver",
        "priority",
        "serviceLevel"
    })
    public static class SNReserve {

        @XmlElement(name = "TransIDC", required = true)
        protected String transIDC;
        @XmlElement(name = "ConvID", required = true)
        protected String convID;
        @XmlElement(name = "CutOffDay", required = true)
        protected String cutOffDay;
        @XmlElement(name = "OSNTime", required = true)
        protected String osnTime;
        @XmlElement(name = "OSNDUNS", required = true)
        protected String osnduns;
        @XmlElement(name = "HSNDUNS", required = true)
        protected String hsnduns;
        @XmlElement(name = "MsgSender", required = true)
        protected String msgSender;
        @XmlElement(name = "MsgReceiver", required = true)
        protected String msgReceiver;
        @XmlElement(name = "Priority")
        protected String priority;
        @XmlElement(name = "ServiceLevel")
        protected String serviceLevel;

        /**
         * ???transIDC????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransIDC() {
            return transIDC;
        }

        /**
         * ????transIDC????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransIDC(String value) {
            this.transIDC = value;
        }

        /**
         * ???convID????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConvID() {
            return convID;
        }

        /**
         * ????convID????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConvID(String value) {
            this.convID = value;
        }

        /**
         * ???cutOffDay????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCutOffDay() {
            return cutOffDay;
        }

        /**
         * ????cutOffDay????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCutOffDay(String value) {
            this.cutOffDay = value;
        }

        /**
         * ???osnTime????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOSNTime() {
            return osnTime;
        }

        /**
         * ????osnTime????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOSNTime(String value) {
            this.osnTime = value;
        }

        /**
         * ???osnduns????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOSNDUNS() {
            return osnduns;
        }

        /**
         * ????osnduns????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOSNDUNS(String value) {
            this.osnduns = value;
        }

        /**
         * ???hsnduns????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHSNDUNS() {
            return hsnduns;
        }

        /**
         * ????hsnduns????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHSNDUNS(String value) {
            this.hsnduns = value;
        }

        /**
         * ???msgSender????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMsgSender() {
            return msgSender;
        }

        /**
         * ????msgSender????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMsgSender(String value) {
            this.msgSender = value;
        }

        /**
         * ???msgReceiver????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMsgReceiver() {
            return msgReceiver;
        }

        /**
         * ????msgReceiver????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMsgReceiver(String value) {
            this.msgReceiver = value;
        }

        /**
         * ???priority????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPriority() {
            return priority;
        }

        /**
         * ????priority????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPriority(String value) {
            this.priority = value;
        }

        /**
         * ???serviceLevel????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceLevel() {
            return serviceLevel;
        }

        /**
         * ????serviceLevel????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceLevel(String value) {
            this.serviceLevel = value;
        }

    }


    /**
     * <p>anonymous complex type?? Java ??
     * 
     * <p>??????????????????????е?????????
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class SvcCont {

        @XmlValue
        protected String value;

        /**
         * ???value????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * ????value????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

    }


    /**
     * <p>anonymous complex type?? Java ??
     * 
     * <p>??????????????????????е?????????
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="SessionID">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="30"/>
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TransIDO">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="30"/>
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TransIDOTime">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="(\d{4})((0[1-9])|(1[0-2]))((0[1-9])|([1-2]\d)|(3[0-1]))(([0-1]\d)|(2[0-3]))([0-5]\d)([0-5]\d)"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TransIDH" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="30"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TransIDHTime" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="(\d{4})((0[1-9])|(1[0-2]))((0[1-9])|([1-2]\d)|(3[0-1]))(([0-1]\d)|(2[0-3]))([0-5]\d)([0-5]\d)"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sessionID",
        "transIDO",
        "transIDOTime",
        "transIDH",
        "transIDHTime"
    })
    public static class TransInfo {

        @XmlElement(name = "SessionID", required = true)
        protected String sessionID;
        @XmlElement(name = "TransIDO", required = true)
        protected String transIDO;
        @XmlElement(name = "TransIDOTime", required = true)
        protected String transIDOTime;
        @XmlElement(name = "TransIDH")
        protected String transIDH;
        @XmlElement(name = "TransIDHTime")
        protected String transIDHTime;

        /**
         * ???sessionID????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSessionID() {
            return sessionID;
        }

        /**
         * ????sessionID????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSessionID(String value) {
            this.sessionID = value;
        }

        /**
         * ???transIDO????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransIDO() {
            return transIDO;
        }

        /**
         * ????transIDO????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransIDO(String value) {
            this.transIDO = value;
        }

        /**
         * ???transIDOTime????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransIDOTime() {
            return transIDOTime;
        }

        /**
         * ????transIDOTime????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransIDOTime(String value) {
            this.transIDOTime = value;
        }

        /**
         * ???transIDH????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransIDH() {
            return transIDH;
        }

        /**
         * ????transIDH????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransIDH(String value) {
            this.transIDH = value;
        }

        /**
         * ???transIDHTime????????
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransIDHTime() {
            return transIDHTime;
        }

        /**
         * ????transIDHTime????????
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransIDHTime(String value) {
            this.transIDHTime = value;
        }

    }

}
