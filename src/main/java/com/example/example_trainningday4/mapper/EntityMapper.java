package com.example.example_trainningday4.mapper;

import java.util.*;

public interface EntityMapper<D, E> {
    E toEntity(D dto);

    D toDto(E Entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> EntityList);
}
