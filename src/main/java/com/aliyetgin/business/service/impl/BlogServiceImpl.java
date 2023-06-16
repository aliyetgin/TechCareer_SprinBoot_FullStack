package com.aliyetgin.business.service.impl;

import com.aliyetgin.bean.ModelMapperBean;
import com.aliyetgin.business.dto.BlogDto;
import  com.aliyetgin.business.service.IBlogGenericsService;
import com.aliyetgin.data.entity.BlogEntity;
import com.aliyetgin.data.repository.IBlogRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor // Injection
@Log4j2

@Service
public class BlogServiceImpl implements IBlogGenericsService<BlogDto, BlogEntity> {
    // #### Injection ####
    private final ModelMapperBean modelMapperBean;
    private final IBlogRepo iBlogRepo;

    // #### Model Mapper ####
    @Override
    public BlogDto EntityToDto(BlogEntity blogEntity) {
        return null;
    }

    @Override
    public BlogEntity DtoToEntity(BlogDto blogDto) {
        return null;
    }

    // #### CRUD ####

    // CREATE
    @Transactional // Create, Delete, Update
    @Override
    public BlogDto blogServiceCreate(BlogDto blogDto) {
        return null;
    }

    // LIST
    @Override
    public List<BlogDto> blogServiceList() {
        return null;
    }

    // FIND
    @Override
    public BlogDto blogServiceFindById(Long id) {
        return null;
    }

    // DELETE
    @Transactional // Create, Delete, Update
    @Override
    public BlogDto blogServiceDeleteById(Long id) {
        return null;
    }

    // UPDATE
    @Transactional // Create, Delete, Update
    @Override
    public BlogDto blogServiceUpdateById(Long id, BlogDto blogDto) {
        return null;
    }

    // #### Pageable ####

    // List: pageable
    @Override
    public List<BlogDto> blogServiceAllList() {
        return null;
    }

    // List: Page, page size
    @Override
    public Page<BlogEntity> blogServicePagination(int currentPage, int pageSize) {
        return null;
    }

    // List: page, pageable
    @Override
    public Page<BlogEntity> blogServicePagination(Pageable pageable, BlogDto blogDto) {
        return null;
    }

    // #### Profile ####

    // Add multiple data
    @Override
    public List<BlogDto> speedDataService() {
        return null;
    }

    // Delete multiple data
    @Override
    public String allDeleteService() {
        return null;
    }

    // App info
    @Override
    public String appInformationService(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
