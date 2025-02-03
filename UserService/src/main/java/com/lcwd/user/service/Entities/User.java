package com.lcwd.user.service.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String userId;
    private String name;
    private String email;
    private String about;

    @Transient // This field wouldn't be stored in database
    private List<Rating> ratings = new ArrayList<>();
}
