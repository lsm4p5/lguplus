package maven.com.lguplus.domain.primary.Entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;


    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        createDate = now;
        lastModifiedDate = now;
        createdBy = UUID.randomUUID().toString();
        lastModifiedBy = createdBy;
    }
    @PreUpdate
    public void preUpdate(){
        lastModifiedDate = LocalDateTime.now();
        lastModifiedBy = UUID.randomUUID().toString();
    }
}