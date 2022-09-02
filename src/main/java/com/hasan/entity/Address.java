package com.hasan.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long id;

//    @Column
//    private String street;

    @Column
    private String city;


    @ManyToMany(cascade = CascadeType.ALL,targetEntity = User.class, mappedBy = "addressList")
    @JsonIgnoreProperties("addressList")
    List<User> userList;


}
