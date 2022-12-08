package com.example.demo.controller.handle;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * @author panjch@mochasoft.com.cn
 * @create: 2022/9/2 17:28
 */

public abstract class AbstractBookmarkStrategy implements BookmarkStrategy{
    @Autowired
    private BookmarkStrategyManager manager;

    private final String bookmark;

    protected AbstractBookmarkStrategy(final String bookmark) {
        this.bookmark = bookmark;
    }

    @PostConstruct
    public void register(BookmarkStrategy bookmarkStrategy) {
        manager.register(this);
    }

    @Override
    public Optional<String> handle() {
        return Optional.empty();
    }

}
