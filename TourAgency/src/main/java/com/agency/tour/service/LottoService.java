package com.agency.tour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LottoService {

	
	public List<List<Integer>> makeLottoNum(){
		List<List<Integer>> groupList = new ArrayList<>();
		for(int i = 0 ; i<5;i++) {
			List<Integer> list = new ArrayList<>();
			while(true) {
				if(list.size()==6) {
					break;
				}
				int num = (int)(Math.random()*45)+1;
				if(!list.contains(num)) {
					list.add(num);
				}
			}	
			groupList.add(list);
		}
		return groupList;
	}
	}
