package com.forezp.entity;

import java.io.Serializable;

public class RspMsg implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ErrCode;

	private String ErrDesc;
	
	private String CnErrDesc;
	
	public RspMsg() {
	}

	public String getErrCode() {
		return ErrCode;
	}

	public void setErrCode(String errCode) {
		ErrCode = errCode;
	}

	public String getErrDesc() {
		return ErrDesc;
	}

	public void setErrDesc(String errDesc) {
		ErrDesc = errDesc;
	}

	public String getCnErrDesc() {
		if(this.CnErrDesc == null || this.CnErrDesc.equals(""))
			return this.ErrDesc;
		else
			return CnErrDesc;
	}

	public void setCnErrDesc(String cnErrDesc) {
		CnErrDesc = cnErrDesc;
	}

}
