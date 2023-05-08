package com.example.hk.hkdolphinscheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hk.hkdolphinscheduler.model.FileSweeper;

@Repository
public interface FileRepository extends JpaRepository<FileSweeper, Long> {

    List<FileSweeper> findAll();
    List<FileSweeper> findById(long id);
    List<FileSweeper> findByName(String name);
    List<FileSweeper> findByStatus(String status);

}
