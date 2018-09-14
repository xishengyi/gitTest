package cn.ylcto.student.vo;

import java.io.Serializable;

public class Zhuanye implements Serializable{
	private String zid;
	private String zname;
	private Xueyuan xueyuan;
	public String getZid() {
		return zid;
	}
	public void setZid(String zid) {
		this.zid = zid;
	}
	public String getZname() {
		return zname;
	}
	public void setZname(String zname) {
		this.zname = zname;
	}
	public Xueyuan getXueyuan() {
		return xueyuan;
	}
	public void setXueyuan(Xueyuan xueyuan) {
		this.xueyuan = xueyuan;
	}
}
