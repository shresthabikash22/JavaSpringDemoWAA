package edu.miu.springdemo.service.impl;

import edu.miu.springdemo.entity.Logger;
import edu.miu.springdemo.entity.dto.request.LoggerRequestDTO;
import edu.miu.springdemo.entity.dto.response.LoggerResponseDTO;
import edu.miu.springdemo.helper.ListMapper;
import edu.miu.springdemo.repo.LoggerRepo;
import edu.miu.springdemo.service.LoggerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    LoggerRepo loggerRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;
    @Override
    public void saveLog(LoggerRequestDTO loggerRequestDTO) {
        loggerRepo.save(modelMapper.map(loggerRequestDTO, Logger.class));
    }

    @Override
    public List<LoggerResponseDTO> findAllLogs() {
        return listMapper.mapList(loggerRepo.findAll(),new LoggerResponseDTO());
    }
}
