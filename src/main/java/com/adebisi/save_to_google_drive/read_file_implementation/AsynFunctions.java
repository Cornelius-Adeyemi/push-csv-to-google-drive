package com.adebisi.save_to_google_drive.read_file_implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class AsynFunctions {




    @Async
    public void generateCsvFunction(String  merchantId){
        LocalDateTime startTime = LocalDateTime.now();

        LocalDateTime endDate = startTime.plusHours(4l);

    log.info(  "-----------merchantId: {}",merchantId);
        log.info(  "-----------time: {}", LocalDateTime.now());
    }
}
