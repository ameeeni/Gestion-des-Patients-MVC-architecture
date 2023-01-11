package com.example.patientmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nom;
 @Temporal(TemporalType.DATE)
 private Date datedeNaissance;
 private Boolean malade;
 private int score;

}
