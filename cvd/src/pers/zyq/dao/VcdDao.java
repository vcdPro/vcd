package pers.zyq.dao;

import java.lang.reflect.Type;

public interface VcdDao {

	Type findType(String typename);

	int addType(String typename, String desc);

}
