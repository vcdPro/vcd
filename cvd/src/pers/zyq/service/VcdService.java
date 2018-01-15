package pers.zyq.service;

import java.util.List;

import pers.zyq.domain.Record;
import pers.zyq.domain.Vcd;
import pers.zyq.domain.VcdType;

public interface VcdService {
	public int addType(VcdType type);

	public List<VcdType> query(String condition);

	public int updateType(VcdType type);

	public int delType(int typeid);

	public int addVcd(Vcd vcd);

	public int findVcd(Vcd vcd);

	public List<Vcd> queryVcd(String con);

	public VcdType getType(int typeid);

	public int updateVcd(Vcd vcd);

	public int delVcd(int vcdid);

	public int addRecord(Record record);

	public List queryRecord(int id);

	public void updateRecord(int id, String name);

}
