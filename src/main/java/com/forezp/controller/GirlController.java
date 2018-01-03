package com.forezp.controller;

import com.forezp.entity.Girl;
import com.forezp.dao.GirlRep;
import com.forezp.entity.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GirlController {

    @Autowired
    private GirlRep girlRep;

    /**
     * 查询所有女生列表
     * @return
     */
    @RequestMapping(value = "/girls",method = RequestMethod.GET)
    public List<Girl> getGirlList(){
        return girlRep.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @RequestMapping(value = "/girls",method = RequestMethod.POST)
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRep.save(girl);
    }

    /**
     * 根据Id查询女生
     * @param id
     * @return
     */
    @RequestMapping(value = "/girls/{id}",method = RequestMethod.POST)
    public Girl getGirl(@PathVariable("id") Integer id){
        return girlRep.findOne(id);
    }

    /**
     * 更新女生信息
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @RequestMapping(value = "/girls/{id}",method = RequestMethod.PUT)
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRep.save(girl);
    }

    /**
     * 删除ID
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void updateGirl(@PathVariable("id") Integer id){
        girlRep.delete(id);
    }

    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    @RequestMapping(value = "girls/age/{age}",method = RequestMethod.GET)
    public List<Girl> getGirls(@PathVariable("age") Integer age){

        return girlRep.findByAge(age);
    }

    /**
     * TEST
     * @param username
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/users/{username}",method = RequestMethod.GET,consumes="application/json")
    public String getUser(@PathVariable String username, @RequestParam String pwd){
        System.out.print(pwd);
        return "Welcome,"+username;
    }


    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String signup(@RequestParam("param") String param) {
        if (null != param) {
            //转json to object?
            System.out.print(param);
            return param;
        } else {
            return "error";
        }
    }



    @RequestMapping(value = "/deviceManage",method = RequestMethod.GET)
    public String deviceManage(@RequestParam("param") String param) {
        if (null != param) {
            //转json to object?
            System.out.print(param);
            return param;
        } else {
            return "error";
        }
    }


    //-------------------


    @RequestMapping(value = "/signup_", method = { RequestMethod.POST, RequestMethod.GET })
    public String signup_(@RequestBody Param param) {
        if (null != param) {
            String cpd = param.getCarrierPostData();
            String postdataid = cpd.substring((cpd.indexOf("&")+1),cpd.length());
           /* String [] newStr = cpd.split("&");
            for(String x:newStr){
                System.out.println(x);
                if(x){

                }
            }*/
            System.out.println("param.EID="+param.getSecondary_device_active().getEid()+"__postdataid="+postdataid);

            return "param.EID="+param.getSecondary_device_active().getEid()+"__postdataid="+postdataid;
        } else {
            return "error";
        }
    }
    @RequestMapping(value = "/verifyPrimaryMsisdn",method = RequestMethod.POST)
    public String verifyPrimaryMsisdn(@RequestParam("xmlhead") String xmlhead,
                                          @RequestParam("xmlbody") String xmlbody){
        System.out.println("req xmlhead=========================================");
        System.out.println(xmlhead);
        System.out.println("req xmlbody=========================================");
        System.out.println(xmlbody);
        System.out.println("rsp xml=============================================");
        String rsp = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<InterBOSS>\n" +
                "\t<Version>0100</Version>\n" +
                "\t<TestFlag>0</TestFlag>\n" +
                "\t<BIPType>\n" +
                "\t\t<BIPCode>BIP4B255</BIPCode>\n" +
                "\t\t<ActivityCode>T4011004</ActivityCode>\n" +
                "\t\t<ActionCode>1</ActionCode>\n" +
                "\t</BIPType>\n" +
                "\t<RoutingInfo>\n" +
                "\t\t<OrigDomain>BBSS</OrigDomain>\n" +
                "\t\t<RouteType>00</RouteType>\n" +
                "\t\t<Routing>\n" +
                "\t\t\t<HomeDomain>BOSS</HomeDomain>\n" +
                "\t\t\t<RouteValue>210</RouteValue>\n" +
                "\t\t</Routing>\n" +
                "\t</RoutingInfo>\n" +
                "\t<TransInfo>\n" +
                "\t\t<SessionID>BBSS1499915394095</SessionID>\n" +
                "\t\t<TransIDO>BBSST40110042017071301553039</TransIDO>\n" +
                "\t\t<TransIDOTime>20170713110954</TransIDOTime>\n" +
                "\t\t<TransIDH>623424225</TransIDH>\n" +
                "\t\t<TransIDHTime>20170713112803</TransIDHTime>\n" +
                "\t</TransInfo>\n" +
                "\t<SNReserve>\n" +
                "\t\t<TransIDC>9980662720170713113837861002556</TransIDC>\n" +
                "\t\t<ConvID>13d194d9-a0d1-45b4-aa5b-0b56308d1a65</ConvID>\n" +
                "\t\t<CutOffDay>20170713</CutOffDay>\n" +
                "\t\t<OSNTime>20170713113837</OSNTime>\n" +
                "\t\t<OSNDUNS>9980</OSNDUNS>\n" +
                "\t\t<HSNDUNS>2100</HSNDUNS>\n" +
                "\t\t<MsgSender>0019</MsgSender>\n" +
                "\t\t<MsgReceiver>2101</MsgReceiver>\n" +
                "\t\t<Priority>5</Priority>\n" +
                "\t\t<ServiceLevel>1</ServiceLevel>\n" +
                "\t</SNReserve>\n" +
                "\t<Response>\n" +
                "\t\t<RspType>0</RspType>\n" +
                "\t\t<RspCode>0000</RspCode>\n" +
                "\t\t<RspDesc>成功</RspDesc>\n" +
                "\t</Response>\n" +
                "\t<SvcCont><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<VerResult>\n" +
                "\t<VerRspList>\n" +
                "\t\t<PriMSISDN>13888888888</PriMSISDN>\n" +
                "\t\t<VerifyResult>1</VerifyResult>\n" +
                "\t\t<VerifyReason></VerifyReason>\n" +
                "\t\t<ResultComm></ResultComm>\n" +
                "\t\t<RspTime>20170717151515</RspTime>\n" +
                "\t</VerRspList>\n" +
                "</VerResult>]]></SvcCont>\n" +
                "</InterBOSS>\n";
        System.out.println(rsp);
        return rsp;
    }
}
