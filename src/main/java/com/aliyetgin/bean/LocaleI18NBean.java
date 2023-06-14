package com.aliyetgin.bean;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
public class LocaleI18NBean extends AcceptHeaderLocaleResolver {
    // Default Accept-Language: tr
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptorBean() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("tr");
        return interceptor;
    }
    List<Locale> localeList = Arrays.asList(Locale.forLanguageTag("tr"), Locale.forLanguageTag("en"), Locale.forLanguageTag("ge"));


    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        List<Locale.LanguageRange> list = Locale.LanguageRange.parse(request.getHeader("Accept-Language"));
        //org.springframework.util.StringUtils;
        if (ObjectUtils.isEmpty(request.getHeader("Accept-Language"))) {
            return Locale.getDefault();
        }
        Locale locale = Locale.lookup(list, localeList);
        return locale;
    }
}