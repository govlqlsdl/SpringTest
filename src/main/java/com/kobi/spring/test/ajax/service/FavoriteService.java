package com.kobi.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobi.spring.test.ajax.domain.Favorite;
import com.kobi.spring.test.ajax.repository.FavoriteRepository;


@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public List<Favorite> getFavoriteList() {
		
		List<Favorite> favoriteList = favoriteRepository.selectFavoriteList();
		
		return favoriteList;
		
	}
	
	public int addFavorite(String name, String url) {
		int count = favoriteRepository.insertFavorite(name, url);
		
		return count;
	}
	
	public boolean isDuplicateUrl(String url) {
		int count = favoriteRepository.selectCountByUrl(url);
		
//		if(count == 0) {
//			return false;
//		} else {
//			return true;
//		}
		
		return count != 0;
		
	}
	
	public int deleteFavorite(int id) {
		int count = favoriteRepository.deleteFavorite(id);
		
		return count;
	}
	
	
	

}