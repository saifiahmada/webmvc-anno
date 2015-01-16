package com.saifiahmada.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saifiahmada.spring.domain.Konfigurasi;

public interface KonfigurasiRepository extends JpaRepository<Konfigurasi, Long> {

}
