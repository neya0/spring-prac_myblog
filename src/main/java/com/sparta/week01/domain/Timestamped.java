package com.sparta.week01.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 상속했을 때 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)// 생성,수정시간을 자동으로 반하도록 설정
public abstract class Timestamped { // 수정시간, 생성시간을 자동으로 만들어줌

    @CreatedDate
    private LocalDateTime createdAt; //생성일자

    @LastModifiedDate
    private LocalDateTime modifiedAt; // 마지막 수정일자

}
