package com.quran.quran_hizb_revision_app.dao;

import com.quran.quran_hizb_revision_app.Entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDAOUser extends JpaRepository<User, Integer> {

  public Optional<User> findById(Integer userId);

  public List<User> findAllByOrderByUserName();
}
