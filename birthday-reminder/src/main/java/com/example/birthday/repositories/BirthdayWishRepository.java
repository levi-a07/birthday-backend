package com.example.birthday.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.birthday.dto.BirthdayWish;

@Repository
public interface BirthdayWishRepository extends JpaRepository<BirthdayWish , Integer> {

    @Query(
            name = "BirthdayWish.findByRecieverId",
            value = "SELECT E FROM BirthdayWish E WHERE E.reciever.emp_id  = ?1"
    )
    List<BirthdayWish> findByRecieverId(Integer id);


}
