package com.saifiahmada.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Konfigurasi;
import com.saifiahmada.spring.repository.KonfigurasiRepository;

@Service
public class KonfigurasiService {
	
	@Autowired
	private KonfigurasiRepository konfigurasiRepository;
	
	public void save(Konfigurasi konfig){
		konfigurasiRepository.save(konfig);
	}
	
	public List<Konfigurasi> findAll(){
		return konfigurasiRepository.findAll();
	}

}
