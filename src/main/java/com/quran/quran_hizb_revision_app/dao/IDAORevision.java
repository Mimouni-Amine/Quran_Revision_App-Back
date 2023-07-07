package com.quran.quran_hizb_revision_app.dao;

import com.quran.quran_hizb_revision_app.Entities.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDAORevision extends JpaRepository <Revision, Integer> {

   public List<Revision> findAllByOrderByQuarterNumberAsc();

   public Revision findRevisionByQuarterNumber(Double f);

   public Revision findRevisionById(int a);
}
