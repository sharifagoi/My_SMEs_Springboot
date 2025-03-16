// filepath: /home/sharif-agoi/Downloads/smesbackend/src/main/java/com/application/smesbackend/repository/RecycleBinRepository.java
package com.application.smesbackend.repository;

import com.application.smesbackend.entity.RecycleBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecycleBinRepository extends JpaRepository<RecycleBin, Long> {
}