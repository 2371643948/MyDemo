package com.example.demo.controller.handle;

import java.util.Optional;

// 根据情况，可以做其他的接口实现
// 比如孔庆源提到的 isSupport 实现
// 通过不同的接口实现，可以在Manager里做不同的算法
interface BookmarkStrategy {
    /**
     * 其实bookmark应该定义成一个对象，这样有更多的信息可以记录。
     */
    String getBookmark();
 
    Optional<String> handle();
}