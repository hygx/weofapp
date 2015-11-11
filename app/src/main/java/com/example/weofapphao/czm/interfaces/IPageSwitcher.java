package com.example.weofapphao.czm.interfaces;

/**
 * Created by caozhimin on 2015/11/10.
 */
public interface IPageSwitcher {
    /**
     * 去czm首页
     */
    void toCzmHomePage();

    /**
     * 根据class去往Activity
     * @param clazz 传入的class
     */
    void toActivityByClass(Class clazz);
}
