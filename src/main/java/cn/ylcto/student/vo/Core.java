package cn.ylcto.student.vo;

import java.io.Serializable;

public class Core implements Serializable{
	private String qid;//大题序号
	private String qname;//题型名称
	private String snum;//小题数
	private String score;//每小题分值
	private String percent;//参与比
	private String acore;//实际得分=每小题分值×参与比
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String getAcore() {
		return acore;
	}
	public void setAcore(String acore) {
		this.acore = acore;
	}
	
}
