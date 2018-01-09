package pers.zyq.service;

import java.util.List;

import pers.zyq.domain.Vcd;
import pers.zyq.domain.VcdType;

public interface VcdService {
	public int addType(VcdType type);

	public List<VcdType> query(String condition);

	public int updateType(VcdType type);

	public int delType(int typeid);

	public int addVcd(Vcd vcd);

	public int findVcd(Vcd vcd);

}
