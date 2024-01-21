package edu.miu.springdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  transactionId;


    @Temporal(TemporalType.TIMESTAMP)
    private  Date datetime;

    private String principle;
    private String operation;

}
