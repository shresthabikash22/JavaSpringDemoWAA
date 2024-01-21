package edu.miu.springdemo.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoggerRequestDTO {
    private String  transactionId;
    Date datetime;
    String principle;
    String operation;
}
