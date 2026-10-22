package com.alibaba.ariver.app.api.ui;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.ariver.app.api.Page;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PageContainer {
    void addRenderView(View view);

    void attachPage(Page page);

    ViewGroup getView();
}
