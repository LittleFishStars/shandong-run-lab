package com.huachenjie.common.bean;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ViewItem {
    private View pageView;
    private String title;

    public ViewItem(String title, View view) {
        this.title = title;
        this.pageView = view;
    }

    public View getPageView() {
        return this.pageView;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPageView(View pageView) {
        this.pageView = pageView;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
