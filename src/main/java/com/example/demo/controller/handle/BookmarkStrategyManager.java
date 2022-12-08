package com.example.demo.controller.handle;

interface BookmarkStrategyManager {
    /**
     * 注册策略。
     * 策略的注册，跟执行是分开的。
     */
    void register(BookmarkStrategy bookmarkStrategy);
 
    /**
     * 策略的执行。
     * 结合注册，完成不同的实现。
     */
    String  getBookmarkValue(String bookmarkName);
}