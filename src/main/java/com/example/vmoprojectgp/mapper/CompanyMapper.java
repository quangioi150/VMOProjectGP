package com.example.vmoprojectgp.mapper;

import com.example.vmoprojectgp.dto.CompanyDTO;
import com.example.vmoprojectgp.entity.Company;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper extends EntitiesMapper<CompanyDTO, Company>{
}
