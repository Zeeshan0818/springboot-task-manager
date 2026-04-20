package com.zeeshan.taskmanager.Repository;

import com.zeeshan.taskmanager.Entity.Userentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Userrepository extends JpaRepository<Userentity,Long> {

    Optional<Userentity> findByUsername(String username);
}
