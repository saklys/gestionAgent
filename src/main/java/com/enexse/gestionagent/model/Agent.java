package com.enexse.gestionagent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String os;
    private String lastKeepAlive;
    private String dateAdd;
    private String ip;
    private String name;
    private String version;
    private String status;

}
