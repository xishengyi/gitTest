package cn.ylcto.student.vo;

import java.io.Serializable;

public class Yanshou implements Serializable  {
  private String ysid;
  private String bzcj;
  private String cnbh;
  private String bznr;
  private String sjid;
  private String zwcd;
  private Biye biye;
public String getYsid() {
	return ysid;
}
public void setYsid(String ysid) {
	this.ysid = ysid;
}
public String getBzcj() {
	return bzcj;
}
public void setBzcj(String bzcj) {
	this.bzcj = bzcj;
}
public String getCnbh() {
	return cnbh;
}
public void setCnbh(String cnbh) {
	this.cnbh = cnbh;
}
public String getBznr() {
	return bznr;
}
public void setBznr(String bznr) {
	this.bznr = bznr;
}
public String getSjid() {
	return sjid;
}
public void setSjid(String sjid) {
	this.sjid = sjid;
}
public String getZwcd() {
	return zwcd;
}
public void setZwcd(String zwcd) {
	this.zwcd = zwcd;
}
public Biye getBiye() {
	return biye;
}
public void setBiye(Biye biye) {
	this.biye = biye;
}
}
