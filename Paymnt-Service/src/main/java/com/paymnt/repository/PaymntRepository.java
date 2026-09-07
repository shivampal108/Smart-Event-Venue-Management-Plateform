package com.paymnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymnt.entity.Paymnt;

public interface PaymntRepository  extends JpaRepository<Paymnt, Long>{

}
