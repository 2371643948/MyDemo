package com.example.demo.controller.handle;

import java.util.Optional;

/**
 * 抄送.
 */
public class CopyToStrategy extends AbstractBookmarkStrategy {
 
    // 注意啊：  这里要注入任何自己需要的任何资源。 不要固定在某个范围。
 
 
    public CopyToStrategy() {
        super("抄送");
    }

    /**
     * 其实bookmark应该定义成一个对象，这样有更多的信息可以记录。
     */
    @Override
    public String getBookmark() {
        return null;
    }

    @Override
    public Optional<String> handle() {
        return Optional.of("");
    }
}