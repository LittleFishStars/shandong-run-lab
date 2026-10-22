package com.alibaba.ariver.resource.api.content;

import com.alibaba.ariver.kernel.common.utils.UrlUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourceQuery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24427a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    public String originUrl;
    public String pureUrl;

    public ResourceQuery(String str) {
        this.originUrl = str;
        this.pureUrl = UrlUtils.purifyUrl(str);
    }

    public static ResourceQuery asUrl(String str) {
        return new ResourceQuery(str);
    }

    public boolean isAppxNgRoute() {
        return this.e;
    }

    public boolean isCanUseFallback() {
        return this.b;
    }

    public boolean isDisableResourcePackage() {
        return this.d;
    }

    public boolean isLanguageAware() {
        return this.f;
    }

    public boolean isMainDoc() {
        return this.c;
    }

    public boolean isNeedAutoCompleteHost() {
        return this.f24427a;
    }

    public void setAppxNgRoute(boolean z) {
        this.e = z;
    }

    public ResourceQuery setCanUseFallback(boolean z) {
        this.b = z;
        return this;
    }

    public void setDisableResourcePackage() {
        this.d = true;
    }

    public ResourceQuery setLanguageAware(boolean z) {
        this.f = z;
        return this;
    }

    public void setMainDoc(boolean z) {
        this.c = z;
    }

    public ResourceQuery setNeedAutoCompleteHost() {
        this.f24427a = true;
        return this;
    }
}
