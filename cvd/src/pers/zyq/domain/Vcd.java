package pers.zyq.domain;

public class Vcd {
	private int id;
	private String name;
	private int typeid;
	private int nownum;
	private String star;
	private float price;
	private String url;
	private String imageurl;
	public Vcd() {
		super();
	}
	
	public Vcd(String name, int typeid, int nownum, String star, float price,
			String url, String imageurl) {
		super();
		this.name = name;
		this.typeid = typeid;
		this.nownum = nownum;
		this.star = star;
		this.price = price;
		this.url = url;
		this.imageurl = imageurl;
	}

	public Vcd(int id, String name, int typeid, int nownum, String star,
			float price, String url, String imageurl) {
		super();
		this.id = id;
		this.name = name;
		this.typeid = typeid;
		this.nownum = nownum;
		this.star = star;
		this.price = price;
		this.url = url;
		this.imageurl = imageurl;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getNownum() {
		return nownum;
	}
	public void setNownum(int nownum) {
		this.nownum = nownum;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
	
}
