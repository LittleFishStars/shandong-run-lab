package com.alibaba.ariver.resource.api.models;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppInfoQuery {
    public static final String QUERY_HIGHEST_VERSION = "*";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private String f24428a;
    private String b;
    private AppInfoScene c;
    private boolean d;

    public AppInfoQuery(@NonNull AppInfoQuery appInfoQuery) {
        this.b = "*";
        this.c = AppInfoScene.ONLINE;
        this.d = false;
        this.f24428a = appInfoQuery.f24428a;
        this.b = appInfoQuery.b;
        this.c = appInfoQuery.c;
    }

    public static AppInfoQuery make(String str) {
        return new AppInfoQuery(str);
    }

    public AppInfoQuery disableCache() {
        this.d = true;
        return this;
    }

    public boolean forHighestVersion() {
        return TextUtils.isEmpty(this.b) || "*".equals(this.b);
    }

    public boolean forSpecificVersion() {
        return (TextUtils.isEmpty(this.b) || this.b.contains("*")) ? false : true;
    }

    @NonNull
    public String getAppId() {
        return this.f24428a;
    }

    public AppInfoScene getScene() {
        return this.c;
    }

    public String getVersion() {
        return this.b;
    }

    public boolean isDisableCache() {
        return this.d;
    }

    public boolean isOnlineScene() {
        return AppInfoScene.ONLINE.equals(this.c);
    }

    public AppInfoQuery scene(AppInfoScene appInfoScene) {
        if (appInfoScene == null) {
            this.c = AppInfoScene.ONLINE;
        } else {
            this.c = appInfoScene;
        }
        return this;
    }

    public String toString() {
        return "AppInfoQuery{appId=" + this.f24428a + ", version=" + this.b + ", scene=" + this.c + ", disableCache=" + this.d + '}';
    }

    public AppInfoQuery version(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b = "*";
        } else {
            this.b = str;
        }
        return this;
    }

    public AppInfoQuery(@NonNull String str) {
        this.b = "*";
        this.c = AppInfoScene.ONLINE;
        this.d = false;
        this.f24428a = str;
    }
}
