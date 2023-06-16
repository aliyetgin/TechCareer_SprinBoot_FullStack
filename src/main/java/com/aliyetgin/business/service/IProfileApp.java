package com.aliyetgin.business.service;

import com.aliyetgin.business.dto.BlogDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface IProfileApp {

    // Bütün veri eklesin
    public List<BlogDto> speedDataService();

    // Bütün veriyi silsin
    public String allDeleteService();

    // App Information
    public String appInformationService(HttpServletRequest request, HttpServletResponse response);
}
