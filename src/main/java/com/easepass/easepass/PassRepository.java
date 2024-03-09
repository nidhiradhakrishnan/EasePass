package com.easepass.easepass; //(check controller class to confirm its correct)

import java.util.List;
import java.util.Date;
import java.time.LocalDate;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassRepository extends JpaRepository<Pass, Long> {

    List<Pass> findByStudentAndOnwardtimeAfter(String student,Date onwardtime);
        List<Pass> findByStudentAndReturntimeAfter(String student,Date returntime);




}