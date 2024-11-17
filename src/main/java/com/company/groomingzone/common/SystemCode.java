package com.company.groomingzone.common;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "system_codes")
public class SystemCode extends BaseEntity{

    @Id
    @Column(length = 20)
    private String code;

    @Column(name = "code_group", nullable = false, length = 10)
    private String codeGroup;

    @Column(nullable = false, length = 50)
    private String name;
}
