package com.quran.quran_hizb_revision_app.dao;

import com.quran.quran_hizb_revision_app.Entities.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDAORevision extends JpaRepository <Revision, Integer> {
    //@Query("select r from Revision r WHERE r.id=1")
   public List<Revision> findAllByOrderByQuarterNumberAsc();
}
