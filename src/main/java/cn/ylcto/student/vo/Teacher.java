package cn.ylcto.student.vo;

import java.io.Serializable;

public class Teacher implements Serializable {
	private String tid;
	private String tname;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
}
