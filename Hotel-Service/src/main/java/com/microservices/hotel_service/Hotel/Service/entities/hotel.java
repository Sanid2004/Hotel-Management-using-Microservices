package com.microservices.hotel_service.Hotel.Service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class hotel {
    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
