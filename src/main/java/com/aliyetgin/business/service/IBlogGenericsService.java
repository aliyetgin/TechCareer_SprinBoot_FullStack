package com.aliyetgin.business.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//Generics
// D = Dtp
// E = Entity
public interface IBlogGenericsService <D, E>  extends IProfileApp {

    // #### Model Mapper ####
    public D EntityToDto(E e);
    public E DtoToEntity(D d);

    // #### CRUD ####

    // CREATE
    public D blogServiceCreate(D d);

    // LIST
    public List<D> blogServiceList();

    // FIND
    public D blogServiceFindById(Long id);

    // DELETE
    public D blogServiceDeleteById(Long id);

    // UPDATE
    public D blogServiceUpdateById(Long id, D d);

    // #### Pageable ####

    // List: pageable
    public List<D> blogServiceAllList();

    // List: Page, page size
    public Page<E> blogServicePagination(int currentPage, int pageSize);

    // List: page, pageable
    public Page<E> blogServicePagination(Pageable pageable, D d);



}
