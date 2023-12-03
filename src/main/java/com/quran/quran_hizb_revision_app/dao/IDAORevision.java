package com.quran.quran_hizb_revision_app.dao;

import com.quran.quran_hizb_revision_app.Entities.Revision;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDAORevision extends JpaRepository<Revision, Integer> {

  public List<Revision> findAllByOrderByQuarterNumberAsc();

  public Revision findRevisionByQuarterNumber(Double f);

  public Revision findRevisionByQuarterNumberAndAndRefUserName(Double f, String refUserName);

  public Revision findRevisionById(int a);

  public List<Revision> findAllByRefUserNameOrderByQuarterNumberAsc(String refUser);
}
