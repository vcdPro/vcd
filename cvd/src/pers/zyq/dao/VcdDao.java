package pers.zyq.dao;

import java.util.List;

import pers.zyq.domain.Vcd;
import pers.zyq.domain.VcdType;

public interface VcdDao {

	VcdType findType(VcdType type);


	List<VcdType> query(String condition);

	int updateType(VcdType type);

	List<Vcd> findVcdById(int typeid);

	int delType(int typeid);

	int addType(VcdType type);


	Vcd findVcd(Vcd vcd);


	int updateVcd(Vcd vcd);


	int addVcd(Vcd vcd);

}
