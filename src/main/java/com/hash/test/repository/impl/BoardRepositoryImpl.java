package com.hash.test.repository.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hash.test.repository.BoardRepository;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

	@Autowired
	SqlSession ss;
	
	@Override
	public int insertBoard(Map<String, Object> param) {
		return ss.insert("com.hash.test.repository.HashBoardRepository.insertHashBoard",param);
	}

	@Override
	public int insertBoardTableMaps(List<Map<String, Object>> list) {
		int cnt = 0;
		for(Map<String,Object> param:list) {
			cnt += ss.insert("com.hash.test.repository.HashBoardRepository.insertBoardTableMap",param);
		}
		return cnt;
	}

	@Override
	public Map<String, Object> selectHashBoard(Map<String, Object> param) {
		
		return ss.selectOne("com.hash.test.repository.HashBoardRepository.selectHashBoard",param);
	}

	@Override
	public List<Map<String, String>> selectHashList(Map<String, Object> param) {
		return ss.selectList("com.hash.test.repository.HashBoardRepository.selectHashList", param);
	}

	@Override
	public List<Map<String, String>> selectHashBoardListByHashTag(Map<String, Object> param) {
		return ss.selectList("com.hash.test.repository.HashBoardRepository.selectHashBoardListByHashTag", param);
	}

}
