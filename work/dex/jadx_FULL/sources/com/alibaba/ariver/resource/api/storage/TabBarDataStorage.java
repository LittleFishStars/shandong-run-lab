package com.alibaba.ariver.resource.api.storage;

import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TabBarDataStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TabBarModel f24437a;
    private Listener b = null;

    public interface Listener {
        void onGetData(TabBarModel tabBarModel);
    }

    public synchronized boolean hasData() {
        return this.f24437a != null;
    }

    public synchronized void onGetData(TabBarModel tabBarModel) {
        this.f24437a = tabBarModel;
        Listener listener = this.b;
        if (listener != null) {
            listener.onGetData(tabBarModel);
            this.b = null;
        }
    }

    public synchronized void retrieveData(Listener listener) {
        TabBarModel tabBarModel = this.f24437a;
        if (tabBarModel != null) {
            listener.onGetData(tabBarModel);
        } else {
            this.b = listener;
        }
    }
}
