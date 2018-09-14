package cn.ylcto.student.vo;

import java.io.Serializable;
import java.util.List;

public class Biye implements Serializable {
	private String byid;
	private String byname;
	private List<Yanshou> yanshous;
	public List<Yanshou> getYanshous() {
		return yanshous;
	}
	public void setYanshous(List<Yanshou> yanshous) {
		this.yanshous = yanshous;
	}
	public String getByid() {
		return byid;
	}
	public void setByid(String byid) {
		this.byid = byid;
	}
	public String getByname() {
		return byname;
	}
	public void setByname(String byname) {
		this.byname = byname;
	}
	
}
