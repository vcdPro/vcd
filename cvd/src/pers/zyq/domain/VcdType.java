package pers.zyq.domain;

public class VcdType {

	private int id;
	private String name;
	private String description;
	
	public VcdType() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public VcdType(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public VcdType(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
