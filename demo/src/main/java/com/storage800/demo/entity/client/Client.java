package com.storage800.demo.entity.client;

import com.storage800.demo.util.constants.Constants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @Column(name = Constants.clientId)
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", allocationSize = 1)
    private long id;

    @Column(name="createdAt")
    private Date CreatedAt;

    @Column(name="name")
    private String name;

    @Column(name="lastName")
    private String lastName;

    @Column(name="mobile")
    private String mobile;
}
