package com.example.demo.controller.threadLocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author panjch@mochasoft.com.cn
 * @create: 2022/7/27 10:14
 */

@Slf4j
public class SimpDateFormat {
//    final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final ThreadLocal<DateFormat> threadLocal = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    @Test
    public void test() {
        Runnable runnable = () -> {
            log.info(threadLocal.get().toString());
            String dateString = threadLocal.get().format(new Date());
            Date parseDate = null;
            try {
                parseDate = threadLocal.get().parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String dateString2 = threadLocal.get().format(parseDate);
            log.info(Thread.currentThread().getName() + " 线程是否安全: " + dateString.equals(dateString2));
        };

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
        threadLocal.remove();
        log.info(threadLocal.get().toString());
    }
}
