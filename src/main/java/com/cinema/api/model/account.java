package com.cinema.api.model;

import com.cinema.api.model.accountenum.AccountStatus;
import com.cinema.api.model.accountenum.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String accFullName;

    @Column(nullable = false, unique = true, length = 100)
    private String accEmail;

    @Column(nullable = false)
    private String accPassWord;

    @Column(unique = true, length = 10)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role accRole;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus accAccountStatus;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createAt;

    private LocalDateTime updateAt;
}
