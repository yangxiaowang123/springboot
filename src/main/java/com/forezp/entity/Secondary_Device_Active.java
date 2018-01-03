package com.forezp.entity;

/**
 * Created by jh on 2017/7/7.
 */
public class Secondary_Device_Active {
    private String eid;
    private String[] iccids;
    private String display_name;
    private String device_imei;
    private String device_type;
    private String primary_device_iccid;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String[] getIccids() {
        return iccids;
    }

    public void setIccids(String[] iccids) {
        this.iccids = iccids;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getDevice_imei() {
        return device_imei;
    }

    public void setDevice_imei(String device_imei) {
        this.device_imei = device_imei;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getPrimary_device_iccid() {
        return primary_device_iccid;
    }

    public void setPrimary_device_iccid(String primary_device_iccid) {
        this.primary_device_iccid = primary_device_iccid;
    }
    /*    {

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
