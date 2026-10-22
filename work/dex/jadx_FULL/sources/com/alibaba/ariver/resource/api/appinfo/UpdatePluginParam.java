package com.alibaba.ariver.resource.api.appinfo;

import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UpdatePluginParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24422a;
    private String b;

    @Nullable
    private String c;

    @Nullable
    private ApiContext d;

    @Nullable
    private App e;

    public UpdatePluginParam(String str, String str2) {
        this.f24422a = str;
        this.b = str2;
    }

    @Nullable
    public ApiContext getApiContext() {
        return this.d;
    }

    @Nullable
    public App getApp() {
        return this.e;
    }

    public String getHostAppId() {
        return this.f24422a;
    }

    public String getPluginId() {
        return this.b;
    }

    @Nullable
    public String getRequiredVersion() {
        return this.c;
    }

    public void setApiContext(@Nullable ApiContext apiContext) {
        this.d = apiContext;
    }

    public void setApp(@Nullable App app) {
        this.e = app;
    }

    public void setHostAppId(String str) {
        this.f24422a = str;
    }

    public void setPluginId(String str) {
        this.b = str;
    }

    public void setRequiredVersion(@Nullable String str) {
        this.c = str;
    }
}
