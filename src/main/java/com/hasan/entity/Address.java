package com.hasan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
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


    @ManyToMany(cascade = CascadeType.ALL,targetEntity = User.class, mappedBy = "address")
    @JsonIgnoreProperties("address")
    List<User> userList;


}
