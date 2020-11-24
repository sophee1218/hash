package com.hash.test.repository.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hash.test.repository.TableRepository;

@Repository
public class TableRepositoryImpl implements TableRepository {

	@Autowired
	SqlSession ss;
	@Override
	public int insertTables(List<Map<String, Object>> params) {
		//repository에서는 이런 로직이 들어가면 안됨
		int cnt = 0;
		for(Map<String,Object> param : params) {
			if(param.get("exists")!=null) {
			cnt += ss.insert("com.hash.test.repository.HashTableRepository.insertHashTable",param);
			}
		}
		return cnt;
	}
	@Override
	public Map<String, Object> selectHashTableByHtHash(Map<String, Object> param) {
		return ss.selectOne("com.hash.test.repository.HashTableRepository.selectHashTableByHtHash", param);
	}

}
