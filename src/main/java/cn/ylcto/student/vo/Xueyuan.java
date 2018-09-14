package cn.ylcto.student.vo;

import java.io.Serializable;
import java.util.List;

public class Xueyuan implements Serializable{
  private  String  xID;
  private  String  xname;
  private List<Zhuanye> zhuanyes;
public List<Zhuanye> getZhuanyes() {
	return zhuanyes;
}
public void setZhuanyes(List<Zhuanye> zhuanyes) {
	this.zhuanyes = zhuanyes;
}
public String getXID() {
	return xID;
}
public void setxID(String xID) {
	this.xID = xID;
}
public String getXname() {
	return xname;
}
public void setXname(String xname) {
	this.xname = xname;
}
  
}
