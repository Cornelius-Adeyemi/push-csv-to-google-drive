package com.adebisi.save_to_google_drive.read_file_implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SchedulerImpl {


    @Value("${merchant.id:}")
   private String merchantIds;

    //@Value("${time.schedule:}")
    private final Long time = 240000l;


    private final AsynFunctions asynFunctions;

    @Scheduled(fixedRate = 4000)//4 * 60 * 60 * 1000
    public void sendCsvTofile(){


        String[] arrayOfMerchantId = merchantIds.split(",");

        for(String merchantId: arrayOfMerchantId ){


            asynFunctions.generateCsvFunction(merchantId);
        }



    }
}
