package com.post_user_service.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_key")
    private String key;

    @NonNull
    @Column(name = "user_name")
    private String name;

    @Column(name = "user_status")
    private Boolean status;

}

