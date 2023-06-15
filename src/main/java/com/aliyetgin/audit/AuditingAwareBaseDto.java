package com.aliyetgin.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter

// Auditing - Which user added or updated what and when in the database
abstract public class AuditingAwareBaseDto implements Serializable {

    // Serialization
    public static final Long serialVersionUID = 1L;

    private Long id; // ID
    @Builder.Default
    private Date systemDate = new Date(System.currentTimeMillis()); // DATE

    // AUDITING
    @JsonIgnore // Hides the data in the backend, doesn't show up in frontend
    protected String createdUser;

    @JsonIgnore // Hides the data in the backend, doesn't show up in frontend
    protected Date createdDate;

    @JsonIgnore // Hides the data in the backend, doesn't show up in frontend
    protected String updatedUser;

    @JsonIgnore // Hides the data in the backend, doesn't show up in frontend
    protected Date updatedDate;
}
