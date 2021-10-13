package com.neo.saving.domain.repository;

import com.neo.saving.domain.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CommonRepository<T extends BaseEntity> {
   Page<T> findByIdAndDeletedIsFalse(String id, Pageable pageable);

   Optional<T> findByIdAndDeletedIsFalse(String id);

   Page<T> findAllByDeletedIsFalse(Pageable pageable);

   Optional<List<T>> findByDeletedIsFalse();

   Optional<List<T>> findByDeletedIsFalse(Pageable pageable);
}
