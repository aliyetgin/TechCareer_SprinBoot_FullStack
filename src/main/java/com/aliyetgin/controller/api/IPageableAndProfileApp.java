package com.aliyetgin.controller.api;

import com.aliyetgin.business.dto.BlogDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IPageableAndProfileApp {

    // Add all the data
    public ResponseEntity<List<BlogDto> > speedDataService();

    // Delete all the data
    public ResponseEntity<String>  allDeleteService();

    // App Information
    public ResponseEntity<String>  appInformationService(HttpServletRequest request, HttpServletResponse response);

    // ### PAGEABLE ###############################
    // Lıst: pageable
    public ResponseEntity<List<BlogDto>> blogServiceAllList();

    // Lıst: Page page,size
    public ResponseEntity<Page<BlogDto>>  blogServicePagination(int currentPage, int pageSize);

    // Lıst: page, pageable
    public ResponseEntity<Page<BlogDto>>  blogServicePagination(Pageable pageable,BlogDto blogDto);
}