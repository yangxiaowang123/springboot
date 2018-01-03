package com.forezp.syncinfo;

import com.forezp.entity.xml.InterBOSS;
import com.forezp.util.XmlTool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jh on 2017/7/12.
 * 生成网状网报文头
 */
public class InterHeadBossScv {

    private String homeDomain = "";

    private String bipCode = "";

    private String activityCode = "";

    private String routeValue = "99";

    private String transIDO;

    private String origDomain;

    private String commonTransIDO;//报文头中的流水号

    public InterHeadBossScv() {
    }

    /**
     * 构造方法；
     *
     * @param origDomain
     * @param bipCode
     * @param activityCode
     * @param routeValue
     * @param origDomain
     */
    public InterHeadBossScv(String homeDomain, String bipCode, String activityCode, String routeValue,String origDomain) {
        this.homeDomain = homeDomain;
        this.bipCode = bipCode;
        this.activityCode = activityCode;
        this.routeValue = routeValue;
        this.origDomain = origDomain;
    }
    /**
     * 生成给网状网的报文头
     * @return
     * @throws Exception
     */
    public String genInterHeadBOSS() throws Exception {
        try {
            if (bipCode.length() == 0 || activityCode.length() == 0) {
                throw new Exception("bipCode, activityCode  is null.");
            }

            InterBOSS interBOSS = new InterBOSS();

            // Version 业务流程版本号
            interBOSS.setVersion("0100");
            //版本号
            interBOSS.setTestFlag("??");

            //交易类型信息
            InterBOSS.BIPType bipType  = new InterBOSS.BIPType();

            //业务功能代码
            bipType.setBIPCode(this.bipCode);
            //交易代码
            bipType.setActivityCode(this.activityCode);
            // ActionCode 交易动作代码
            bipType.setActionCode("??");

            interBOSS.setBIPType(bipType); //set interBOSS

            //交易路由信息
            InterBOSS.RoutingInfo rountingInfo = new InterBOSS.RoutingInfo();
            // OrigDomain 发起方应用域代码
            rountingInfo.setOrigDomain(this.origDomain);
            // RouteType 路由类型
            rountingInfo.setRouteType("00");

            interBOSS.setRoutingInfo(rountingInfo); //set interBOSS

            //路由类型
            InterBOSS.RoutingInfo.Routing rounting = new InterBOSS.RoutingInfo.Routing(); //set interBOSS
            //归属方应用域代码
            rounting.setHomeDomain(this.homeDomain);
            rounting.setRouteValue("99");
            //交易流水信息
            InterBOSS.TransInfo transInfo = new InterBOSS.TransInfo();
            Date today = new Date();
            //业务流水号 可变长,三十位
            transInfo.setSessionID("BBSS" + today.getTime());
            //发起方交易流水号
            this.genTransIDO(this.activityCode);
            transInfo.setTransIDO(this.transIDO);
            this.commonTransIDO = this.transIDO;
            //处理时间
            transInfo.setTransIDOTime(this.formateDate(today, "yyyyMMddHHmmss"));

            interBOSS.setTransInfo(transInfo); //set interBOSS

            String xmlResult = XmlTool.convertToXml(interBOSS);

            return xmlResult;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
    /**
     * 生成TRADSIDO；
     *
     * @param activityCode
     * @return
     */
    public String genTransIDO(String activityCode) {
        String trans = "BBSS" + activityCode;
        /*try {
            ODSCommonUtilEJB _remote = new ODSCommonUtilEJB();
            String prefix = "20"; // 年份的前缀；
            String seq = _remote.getSequenceID("TransIDO", prefix);
            trans += prefix + seq;
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        this.transIDO = trans;
        return trans;
    }
    /**
     * 格式化日期；
     *
     * @param date
     * @param pattern
     * @return
     */
    private String formateDate(Date date, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
}
