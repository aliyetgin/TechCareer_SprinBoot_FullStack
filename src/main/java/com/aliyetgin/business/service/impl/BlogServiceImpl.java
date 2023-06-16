package com.aliyetgin.business.service.impl;

import com.aliyetgin.bean.ModelMapperBean;
import com.aliyetgin.business.dto.BlogDto;
import  com.aliyetgin.business.service.IBlogGenericsService;
import com.aliyetgin.data.entity.BlogEntity;
import com.aliyetgin.data.repository.IBlogRepo;
import com.aliyetgin.exception.BadRequestException;
import com.aliyetgin.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        return modelMapperBean.modelMapperMethod().map(blogEntity, BlogDto.class);
    }

    @Override
    public BlogEntity DtoToEntity(BlogDto blogDto) {
        return modelMapperBean.modelMapperMethod().map(blogDto, BlogEntity.class);
    }

    // #### CRUD ####

    // CREATE
    @Transactional // Create, Delete, Update
    @Override
    public BlogDto blogServiceCreate(BlogDto blogDto) {
        if (blogDto != null) {
            BlogEntity blogEntityModel = DtoToEntity(blogDto);
            BlogEntity blogEntity = iBlogRepo.save(blogEntityModel);
            blogDto.setId(blogEntity.getId());
            blogDto.setSystemDate(blogDto.getSystemDate());
        } else throw new BadRequestException("BlogDto not found");
        return blogDto;
    }


    // LIST
    @Override
    public List<BlogDto> blogServiceList() {
        Iterable<BlogEntity> blogEntityIterable = iBlogRepo.findAll();
        List<BlogDto> list = new ArrayList<>();
        for (BlogEntity entity : blogEntityIterable) {
            BlogDto blogDto = EntityToDto(entity);
            list.add(blogDto);
        }
        return list;
    }

    // FIND
    @Override
    public BlogDto blogServiceFindById(Long id) {
        BlogEntity blogEntity = null;
        if (id != null) {
            blogEntity = iBlogRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id + " this ID not found."));
        } else throw new BadRequestException(id + "Blog Dto is null"); // 400
        return EntityToDto(blogEntity);
    }

    // DELETE
    @Transactional // Create, Delete, Update
    @Override
    public BlogDto blogServiceDeleteById(Long id) {
        BlogDto blogDtoDeleteFind = blogServiceFindById(id);
        BlogEntity blogEntity = DtoToEntity(blogDtoDeleteFind);
        iBlogRepo.delete(blogEntity);
        return blogDtoDeleteFind;
    }

    // UPDATE
    @Transactional // Create, Delete, Update
    @Override
    public BlogDto blogServiceUpdateById(Long id, BlogDto blogDto) {
        BlogEntity blogEntity = DtoToEntity(blogServiceFindById(id));
        if (blogEntity != null) {
            blogEntity.setId(id);
            blogEntity.setHeader(blogDto.getHeader());
            blogEntity.setContent(blogDto.getContent());
            iBlogRepo.save(blogEntity);
            blogDto.setId(blogEntity.getId());
            blogDto.setSystemDate(blogDto.getSystemDate());
        }
        return EntityToDto(blogEntity);
    }

    // #### Pageable ####

    // List: pageable
    @Override
    public List<BlogDto> blogServiceAllList() {
        Iterable<BlogEntity> blogEntityPage = iBlogRepo.findAll();
        List<BlogDto> list = new ArrayList<>();
        for (BlogEntity entity : blogEntityPage) {
            BlogDto blogDto = EntityToDto(entity);
            list.add(blogDto);
        }
        return list;
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
        List<BlogDto> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BlogDto blogDto = BlogDto.builder()
                    .header("header " + i)
                    .content("content " + i)
                    .build();
            blogServiceCreate(blogDto);
            list.add(blogDto);
        }
        return list;
    }

    // Delete multiple data
    @Override
    public String allDeleteService() {
        iBlogRepo.deleteAll();
        log.info("Silindi");
        return "Silindi ";
    }

    // App info
    @Override
    public String appInformationService(HttpServletRequest request, HttpServletResponse response) {
        // URL URI
        // relative Path, absolute Path
        String URI = request.getRequestURI();
        String LOCALHOST = request.getLocalAddr();
        String SESSION = request.getSession().toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(URI).append(" ").append(LOCALHOST).append(" ").append(SESSION);
        return stringBuilder.toString();
    }
}
