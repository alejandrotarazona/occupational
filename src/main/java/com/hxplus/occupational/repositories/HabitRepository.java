package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Habit;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {

}
