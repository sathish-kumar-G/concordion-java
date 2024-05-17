package net.breezeware.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "user", schema = "dynamo")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq_gen")
    @SequenceGenerator(name = "user_id_seq_gen", sequenceName = "user_id_seq", schema = "dynamo",
            allocationSize = 1)
    private long id;


    @Column(name = "first_name", length = 255)
    private String firstName;


    @Column(name = "last_name", length = 255)
    private String lastName;


    @Column(name = "email", length = 255)
    private String email;


    @Column(name = "phone_number", length = 255)
    private String phoneNumber;


    @Column(name = "status", length = 255)
    private String status;


    @Column(name = "created_on")
    private Instant createdOn;


    @Column(name = "modified_on")
    private Instant modifiedOn;
}
