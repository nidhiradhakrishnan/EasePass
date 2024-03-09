package com.easepass.easepass; //(check controller class to confirm its correct)

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
    List<Travel> findByFromAndTo(
        String from,String to);


                     
}