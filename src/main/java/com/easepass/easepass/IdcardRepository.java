package com.easepass.easepass; //(check controller class to confirm its correct)

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdcardRepository extends JpaRepository<Idcard, Long> {

  List<Idcard> findByUsername(String username);
    



                             
}