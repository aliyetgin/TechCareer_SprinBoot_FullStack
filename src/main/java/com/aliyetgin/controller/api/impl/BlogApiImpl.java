package com.aliyetgin.controller.api.impl;

import com.aliyetgin.business.dto.BlogDto;
import com.aliyetgin.business.service.IBlogGenericsService;
import com.aliyetgin.controller.api.IBlogGenericsApi;
import com.aliyetgin.error.ApiResult;
import com.aliyetgin.util.FrontEndURL;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor //Injection
@Log4j2

// API
@RestController
@CrossOrigin(origins = FrontEndURL.FRONTEND_URL) // CORS
@RequestMapping("/blog/api/v1")
public class BlogApiImpl implements IBlogGenericsApi<BlogDto> {

    // INJECTION
    private final IBlogGenericsService iBlogGenericsService;

    //ERROR
    private ApiResult apiResult;

    // ### ROOT ###############################
    // localhost:3333
    // localhost:3333/index
    @Override
    @GetMapping({"/", "/index"})
    public ResponseEntity<String> getRoot() {
        return ResponseEntity.ok("index");
    }

    // SPEED
    // localhost:3333/blog/api/v1/speed/data
    @GetMapping("/speed/data")
    @Override
    public ResponseEntity<List<BlogDto>> speedDataService() {
        return ResponseEntity.ok(iBlogGenericsService.speedDataService());
    }

    // localhost:3333/blog/api/v1/all/delete
    @GetMapping("/all/delete")
    @Override
    public ResponseEntity<String> allDeleteService() {
        return ResponseEntity.ok(iBlogGenericsService.allDeleteService());
    }

    // localhost:3333/blog/api/v1/app/information
    @GetMapping("/app/information")
    @Override
    public ResponseEntity<String> appInformationService(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(iBlogGenericsService.appInformationService(request,response));
    }

    // ### CRUD ###############################
    // CREATE
    // localhost:3333/blog/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> blogServiceCreate(@Valid @RequestBody BlogDto blogDto) {
        //return ResponseEntity.status(200).body(iBlogGenericsService.blogServiceCreate(blogDto));
        //return ResponseEntity.status(HttpStatus.OK).body(iBlogGenericsService.blogServiceCreate(blogDto));
        return ResponseEntity.ok(iBlogGenericsService.blogServiceCreate(blogDto));
    }

    // LIST
    // localhost:3333/blog/api/v1/list
    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<BlogDto>> blogServiceList() {
        return ResponseEntity.ok(iBlogGenericsService.blogServiceAllList());
    }

    // FIND
    // localhost:3333/blog/api/v1/find
    // localhost:3333/blog/api/v1/find/0
    // localhost:3333/blog/api/v1/find/1
    @Override
    @GetMapping({"/find", "/find/{id}"})
    public ResponseEntity<?> blogServiceFindById(@PathVariable(name = "id", required = false) Long id) {
        if (id == null) {
            log.error("Blog Api Null Pointer Exception Geldi");
            throw new NullPointerException(id + " Blog Api Null Veri Geldi");
        }
        if (id == 0) {
            log.error("Blog Api 0 badrequest Geldi");
            //(int status, String error, String message, String path)
            apiResult = new ApiResult(400, "bad Request", " Kötü İstek", "/blog/api/v1/find/0");
            return ResponseEntity.ok(apiResult);
        }
        return ResponseEntity.ok(iBlogGenericsService.blogServiceFindById(id));
    }

    // DELETE
    // localhost:3333/blog/api/v1/delete/1
    @Override
    @DeleteMapping({"/delete", "/delete/{id}"})
    public ResponseEntity<?> blogServiceDeleteById(@PathVariable(name = "id", required = false) Long id) {
        return ResponseEntity.ok(iBlogGenericsService.blogServiceDeleteById(id));
    }

    // UPDATE
    // localhost:3333/blog/api/v1/update/1
    @Override
    @PutMapping({"/update", "/update/{id}"})
    public ResponseEntity<?> blogServiceUpdateById(
            @PathVariable(name = "id", required = false) Long id,
            @Valid @RequestBody BlogDto blogDto) {
        blogDto.setId(id);
        return ResponseEntity.ok(iBlogGenericsService.blogServiceUpdateById(id,blogDto));
    }

    /////////////////
    // PAGE, PAGEABLE
    @Override
    public ResponseEntity<List<BlogDto>> blogServiceAllList() {
        return null;
    }

    @Override
    public ResponseEntity<Page<BlogDto>> blogServicePagination(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public ResponseEntity<Page<BlogDto>> blogServicePagination(Pageable pageable, BlogDto blogDto) {
        return null;
    }

    @Override
    public ResponseEntity<Page<BlogDto>> blogServicePagination(Pageable pageable, Object d) {
        return null;
    }
}
