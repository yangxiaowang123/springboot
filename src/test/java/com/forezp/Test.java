package com.forezp;

import com.forezp.entity.BBOSSHttpReqLog;
import com.forezp.dao.BBOSSHttpReqLogRepository;
import com.forezp.entity.RspMsg;
import com.forezp.entity.xml.InterBOSS;
import com.forezp.entity.xml.VerPriMSISDN;
import com.forezp.httpClient.HttpUtil;
import com.forezp.entity.xml.AccMegReq;
import com.forezp.syncinfo.InterHeadBossScv;
import com.forezp.util.DateUtil;
import com.forezp.util.XmlTool;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by jh on 2017/7/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private HttpUtil httpUtil;

    @Autowired
    private BBOSSHttpReqLogRepository bbossHttpReqLogRepository;

    public HttpUtil getHttpUtil() {
        return httpUtil;
    }

    public void setHttpUtil(HttpUtil httpUtil) {
        this.httpUtil = httpUtil;
    }

    public BBOSSHttpReqLogRepository getBbossHttpReqLogRepository() {
        return bbossHttpReqLogRepository;
    }

    public void setBbossHttpReqLogRepository(BBOSSHttpReqLogRepository bbossHttpReqLogRepository) {
        this.bbossHttpReqLogRepository = bbossHttpReqLogRepository;
    }

    @org.junit.Test
    public void xmlToBeanTest() throws Exception {
        AccMegReq customerReq = new AccMegReq();

        customerReq.setAction("123");
        customerReq.setCustMegName("123");
        String str = XmlTool.convertToXml(customerReq);
        System.out.println(str);
        System.out.println("=====================================");
        String result = XmlTool.createInterBoss(str);
        System.out.println(result);
        System.out.println("=====================================");
        //==========
        AccMegReq newAcc = new AccMegReq();
        String svcCont = XmlTool.getSvcCont(result);
        System.out.println("svcCont="+svcCont);
        System.out.println("=====================================");
        newAcc = XmlTool.convertToJavaBean(svcCont,AccMegReq.class);
        System.out.print(newAcc.getAction());


        System.out.println("==============interbosshead=======================");
        InterHeadBossScv interHeadBossScv =new InterHeadBossScv("11","22","33","44","55");
        String headstr = interHeadBossScv.genInterHeadBOSS();
        System.out.println(headstr);


        System.out.println(XmlTool.getTnsRespXml("0","0000","成功","",XmlTool.getDocument(headstr)));



    }

    /**
     * 模拟网状网发送报文
     */
    @org.junit.Test
    public void postTsn() {
       /* String addrs = "http://localhost:8080/springboot/testeee";
        InterHeadBossScv interHeadBossScv =new InterHeadBossScv("11","22","33","44","55");
        String xmlhead = null;
        try {
            xmlhead = interHeadBossScv.genInterHeadBOSS();
        } catch (Exception e) {
            e.printStackTrace();
        }
        VerPriMSISDN verPriMSISDN = new VerPriMSISDN();
        VerPriMSISDN.VerLIst verLIst = new VerPriMSISDN.VerLIst();
        verLIst.setPriMSISDN("13801035974");
        verLIst.setRspTime(DateUtil.format2String("YYYYMMDDHHMMSS",new Date()));
        verPriMSISDN.getVerLIst().add(verLIst);
        String xmlbean = XmlTool.convertToXml(verPriMSISDN);
        //System.out.println(xmlbean);
        String xmlbody = null;
        try {
            xmlbody = XmlTool.createInterBoss(xmlbean);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        String addrs = "http://localhost:8080/ReceiveBossWS";
        String xmlhead = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<InterBOSS>\n" +
                "    <Version>0100</Version>\n" +
                "    <TestFlag>1</TestFlag>\n" +
                "    <BIPType>\n" +
                "        <BIPCode>BIP3B529</BIPCode>\n" +
                "        <ActivityCode>T3000522</ActivityCode>\n" +
                "        <ActionCode>0</ActionCode>\n" +
                "    </BIPType>\n" +
                "    <RoutingInfo>\n" +
                "        <OrigDomain>MDRP</OrigDomain>\n" +
                "        <RouteType>01</RouteType>\n" +
                "        <Routing>\n" +
                "            <HomeDomain>BOSS</HomeDomain>\n" +
                "            <RouteValue>13888888888</RouteValue>\n" +
                "        </Routing>\n" +
                "    </RoutingInfo>\n" +
                "    <TransInfo>\n" +
                "        <SessionID>MDRP1501749350528</SessionID>\n" +
                "        <TransIDO>0956728A1B33AB30A1AD0CB3E9F38E</TransIDO>\n" +
                "        <TransIDOTime>20170803163550</TransIDOTime>\n" +
                "    </TransInfo>\n" +
                "</InterBOSS>";
        String xmlbody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<InterBOSS><SvcCont><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<VerPriMSISDN>\n" +
                "    <VerLIst>\n" +
                "        <PriMSISDN>13888888888</PriMSISDN>\n" +
                "        <RspTime>20170803163553</RspTime>\n" +
                "    </VerLIst>\n" +
                "</VerPriMSISDN>\n" +
                "]]></SvcCont></InterBOSS>\n";
        System.out.println("==============xml head=======================");
        System.out.println(xmlhead);
        System.out.println("==============xml body=======================");
        System.out.println(xmlbody);
        RspMsg rspMsg = null;
        try {
            rspMsg = httpUtil.post2Tsn(addrs,xmlhead,xmlbody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("==============rsp all xml=======================");
        System.out.println(rspMsg.getErrDesc());
        InterBOSS interBOSS = new InterBOSS();
        interBOSS = XmlTool.convertToJavaBean(rspMsg.getErrDesc(),interBOSS.getClass());
        System.out.println("==============interBOSS.getSvcCont().getValue() xml=======================");
        System.out.println(interBOSS.getSvcCont().getValue());

    }
    @org.junit.Test
    public void httpSave(){
        String xmlHead = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<InterBOSS>\n" +
                "<Version>0100</Version>\n" +
                "<TestFlag>0</TestFlag>\n" +
                "<BIPType>\n" +
                "<BIPCode>BIP4B255</BIPCode>\n" +
                "<ActivityCode>T4011004</ActivityCode>\n" +
                "<ActionCode>0</ActionCode>\n" +
                "</BIPType>\n" +
                "<RoutingInfo>\n" +
                "<OrigDomain>BBSS</OrigDomain>\n" +
                "<RouteType>00</RouteType>\n" +
                "<Routing>\n" +
                "<HomeDomain>BOSS</HomeDomain>\n" +
                "<RouteValue>210</RouteValue>\n" +
                "</Routing>\n" +
                "</RoutingInfo>\n" +
                "<TransInfo>\n" +
                "<SessionID>BBSS1499915394095</SessionID>\n" +
                "<TransIDO>BBSST40110042017071301553039</TransIDO>\n" +
                "<TransIDOTime>20170713110954</TransIDOTime>\n" +
                "</TransInfo>\n" +
                "</InterBOSS>\n" +
                "\n";

        String xmlBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<InterBOSS>\n" +
                "<Version>0100</Version>\n" +
                "<TestFlag>0</TestFlag>\n" +
                "<BIPType>\n" +
                "<BIPCode>BIP4B255</BIPCode>\n" +
                "<ActivityCode>T4011004</ActivityCode>\n" +
                "<ActionCode>0</ActionCode>\n" +
                "</BIPType>\n" +
                "<RoutingInfo>\n" +
                "<OrigDomain>BBSS</OrigDomain>\n" +
                "<RouteType>00</RouteType>\n" +
                "<Routing>\n" +
                "<HomeDomain>BOSS</HomeDomain>\n" +
                "<RouteValue>210</RouteValue>\n" +
                "</Routing>\n" +
                "</RoutingInfo>\n" +
                "<TransInfo>\n" +
                "<SessionID>BBSS1499915394095</SessionID>\n" +
                "<TransIDO>BBSST40110042017071301553039</TransIDO>\n" +
                "<TransIDOTime>20170713110954</TransIDOTime>\n" +
                "</TransInfo>\n" +
                "</InterBOSS>\n" +
                "\n";





        BBOSSHttpReqLog bbossHttpReqLog = new BBOSSHttpReqLog();
        bbossHttpReqLog.setActivityCode("T4011004");
        bbossHttpReqLog.setBipCode("BIP4B255");
        bbossHttpReqLog.setTransationId("BBSST40110042017071301553039");
        bbossHttpReqLog.setOrderStatus("00");
        bbossHttpReqLog.setXmlHead(xmlHead.getBytes());
        bbossHttpReqLog.setXmlBody(xmlBody.getBytes());

        bbossHttpReqLogRepository.save(bbossHttpReqLog);
        /*List<BBOSSHttpReqLog> blist = bbossHttpReqLogRepository.findAll();
        for (BBOSSHttpReqLog httlog:blist){
            String body = new String(httlog.getXmlBody());
            System.out.println(body);
        }*/

    }
}
