package com.hash.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hash.test.repository.BoardRepository;
import com.hash.test.service.BoardService;
import com.hash.test.service.TableService;

@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private BoardRepository bRepo;
	@Autowired
	private TableService tService;

	@Override
	public Map<String, String> insertBoard(Map<String, Object> param) {
		Map<String, String> map = new HashMap<>();
		map.put("result", "failed");
		if (bRepo.insertBoard(param) == 1) {
			String hash = param.get("ht_hash").toString();
			if (hash != null) {
				String[] hashs = hash.split(",");
				List<Map<String, Object>> htList = tService.insertTable(hashs);
				for(Map<String,Object> ht:htList) {
					ht.put("hb_no", param.get("hb_no"));
				}
				bRepo.insertBoardTableMaps(htList);
			}
			map.put("result", "succeed");
		}
		return map;
	}

	@Override
	public Map<String, Object> selectHashBoard(Map<String, Object> param) {
		Map<String, Object> hb = bRepo.selectHashBoard(param);
		hb.put("hashs", bRepo.selectHashList(param));
		return hb;
	}

}
