package com.saifiahmada.spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Konfigurasi {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String kode;
	
	private String nama;
	
	private String nilai;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNilai() {
		return nilai;
	}

	public void setNilai(String nilai) {
		this.nilai = nilai;
	}
	
}
