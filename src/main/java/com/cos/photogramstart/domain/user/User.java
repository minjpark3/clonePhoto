package com.cos.photogramstart.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //번호증가 전략이 데이터베이스를 따라간다.
    private int id;

    @Column(length = 30, unique = true)
    private String username;
    private String password;
    private String name; // 이름
    private String website; // 자기 홈페이지
    private String bio; // 자기소개
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl;
//    private String provider; // 제공자 Google, Facebook, Naver
//
    private String role; // USER, ADMIN
//
//    @OneToMany(mappedBy = "user")
//    private List<Image> images;

    private LocalDateTime createDate;
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }
}
