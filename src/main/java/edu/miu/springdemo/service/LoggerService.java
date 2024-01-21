package edu.miu.springdemo.service;

import edu.miu.springdemo.entity.Logger;
import edu.miu.springdemo.entity.dto.request.LoggerRequestDTO;
import edu.miu.springdemo.entity.dto.response.LoggerResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LoggerService {
    public void saveLog(LoggerRequestDTO loggerRequestDTO);
    public List<LoggerResponseDTO > findAllLogs();
}
