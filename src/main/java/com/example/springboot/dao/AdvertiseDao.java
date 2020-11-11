package com.example.springboot.dao;

import com.example.springboot.entity.Advertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertiseDao extends JpaRepository<Advertise,Integer> {
    @Query(" from Advertise where now() between beginTime and endTime")
    List<Advertise> index();
}
