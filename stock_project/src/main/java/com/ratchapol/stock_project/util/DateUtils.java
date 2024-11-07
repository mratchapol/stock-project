package com.ratchapol.stock_project.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DateUtils {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyu");

    @Bean
    public String todayString(){
        return simpleDateFormat.format(new Date());
    }
}