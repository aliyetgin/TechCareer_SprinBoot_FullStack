package com.aliyetgin.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;

// LOMBOK
@Data

// SUPER CLASS
@MappedSuperclass
@JsonIgnoreProperties(value = {"created_date,updated_date"}, allowGetters = true) // We instruct JSON not to track these properties
abstract public class AuditingAwareBaseEntity {
    // Auditing: Which user added or updated what and when in the database

    // WHO CREATED
    @CreatedBy
    @Column(name = "created_user")
    protected String createdUser;

    // WHO CREATED WHEN
    @CreatedDate
    @Column(name = "created_date")
    protected Date createdDate;

    // WHO UPDATED
    @LastModifiedBy
    @Column(name = "updated_user")
    protected String updatedUser;

    // WHO UPDATED WHEN
    @LastModifiedDate
    @Column(name = "updated_date")
    protected Date updatedDate;
} //end class
