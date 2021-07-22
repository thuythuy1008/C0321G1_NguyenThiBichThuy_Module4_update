package com.codegym.model.repository;

import com.codegym.model.bean.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
