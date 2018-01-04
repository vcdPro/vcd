package pers.zyq.service;

import java.util.List;

import pers.zyq.domain.VcdType;

public interface VcdService {
	public int addType(VcdType type);

	public List<VcdType> query(String condition);

	public int updateType(VcdType type);

	public int delType(int typeid);

}
