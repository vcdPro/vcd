package pers.zyq.domain;

import java.util.Date;

public class Record {

	private int id;
	private int userid;
	private int vcdid;
	private Date rentdate;
	private Date returndate;
	private  float rentprice;
	private float depositprice;
	private int state;
	public Record() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Record(int userid, int vcdid, Date rentdate, Date returndate,
			float rentprice, float depositprice) {
		super();
		this.userid = userid;
		this.vcdid = vcdid;
		this.rentdate = rentdate;
		this.returndate = returndate;
		this.rentprice = rentprice;
		this.depositprice = depositprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getVcdid() {
		return vcdid;
	}
	public void setVcdid(int vcdid) {
		this.vcdid = vcdid;
	}
	public Date getRentdate() {
		return rentdate;
	}
	public void setRentdate(Date rentdate) {
		this.rentdate = rentdate;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	public float getRentprice() {
		return rentprice;
	}
	public void setRentprice(float rentprice) {
		this.rentprice = rentprice;
	}
	public float getDepositprice() {
		return depositprice;
	}
	public void setDepositprice(float depositprice) {
		this.depositprice = depositprice;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
}
