package com.neo.saving.mapper;

import com.neo.saving.domain.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface CommonMapper<T extends BaseEntity, Z extends Serializable> {
   default void convertToEntity(T entity, Z message) {
   }

   default T convertToEntity(Z message) {
      return null;
   }

   default Z convertToDto(T entity) {
      return null;
   }

   default List<Z> convertToDtos(List<T> entity) {
      return null;
   }
}
