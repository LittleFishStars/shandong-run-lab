package com.alibaba.ariver.engine.api.bridge.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoadParams {
    public boolean forceLoad;
    public boolean isFirstLoad;
    public boolean isReload;
    public String url;

    public LoadParams() {
    }

    public String toString() {
        return "LoadParams{url=" + this.url + '}';
    }

    public LoadParams(LoadParams loadParams) {
        this.url = loadParams.url;
        this.isFirstLoad = loadParams.isFirstLoad;
        this.isReload = loadParams.isReload;
        this.forceLoad = loadParams.forceLoad;
    }
}
