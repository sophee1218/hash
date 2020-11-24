package com.hash.test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hash.test.repository.TableRepository;
import com.hash.test.service.TableService;

@Service
public class TableServiceImpl implements TableService {

	@Autowired
	private TableRepository tRepo;
	
	@Override
	public List<Map<String, Object>> insertTable(String[] hashs) {
		List<Map<String,Object>> htList = new ArrayList<>();
		for(String hash:hashs) {
			Map<String,Object> param = new HashMap<>();
			param.put("ht_hash",hash);
			param = tRepo.selectHashTableByHtHash(param);
			if(param==null) {
				param = new HashMap<>();
				param.put("ht_hash",hash);
				param.put("exists",false);
			}
			htList.add(param);
		}
		tRepo.insertTables(htList);
		return htList;
	}

}
