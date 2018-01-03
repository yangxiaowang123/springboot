package com.forezp.entity;

/**
 * Created by jh on 2017/7/7.
 */
public class Param {

    private String carrierPostData;
    private  Secondary_Device_Active secondary_device_active;

  //  private secondary_device_active
    public String getCarrierPostData() {
        return carrierPostData;
    }

    public Secondary_Device_Active getSecondary_device_active() {
        return secondary_device_active;
    }

    public void setSecondary_device_active(Secondary_Device_Active secondary_device_active) {
        this.secondary_device_active = secondary_device_active;
    }

    public void setCarrierPostData(String carrierPostData) {
        this.carrierPostData = carrierPostData;
    }
    /*    {
			“carrierPostData”: <ES返回的POSTDATA String>  ,
			“secondary-device-active” : {
				“eid” : <String>,
				“iccids” : <Array of String>,
				“display-name” : <String>,
				“device-imei”: <String>,
				“device-meid”: <String>,
				“device-type”: <String>,
				“primary-device-iccid” : <String>
    }*/
}
