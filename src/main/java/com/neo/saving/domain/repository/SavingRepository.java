package com.neo.saving.domain.repository;

import com.neo.saving.domain.entity.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingRepository extends JpaRepository<Saving,String>, CommonRepository<Saving> {
}
