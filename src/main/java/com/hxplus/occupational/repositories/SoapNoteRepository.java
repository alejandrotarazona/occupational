package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.SoapNote;

@Repository
public interface SoapNoteRepository extends JpaRepository<SoapNote, Long> {

}
