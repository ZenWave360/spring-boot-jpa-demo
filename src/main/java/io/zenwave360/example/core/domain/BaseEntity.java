package io.zenwave360.example.core.domain;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/** */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @CreatedBy
  @Column(name = "created_by")
  protected String createdBy;

  @CreatedDate
  @Column(name = "created_date", columnDefinition = "TIMESTAMP")
  protected LocalDateTime createdDate;

  @LastModifiedBy
  @Column(name = "last_modified_by")
  protected String lastModifiedBy;

  @LastModifiedDate
  @Column(name = "last_modified_date", columnDefinition = "TIMESTAMP")
  protected LocalDateTime lastModifiedDate;

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  public LocalDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }
}
