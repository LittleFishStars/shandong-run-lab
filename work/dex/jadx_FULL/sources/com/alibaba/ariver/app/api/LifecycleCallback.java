package com.alibaba.ariver.app.api;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface LifecycleCallback {
    void onAppFinish(App app);

    void onAppStart(App app);

    void onPageEnter(Page page);

    void onPageExit(Page page);

    void onPageHide(Page page);

    void onPageShow(Page page);

    void onVisit(Visit visit);
}
