package com.alibaba.ariver.kernel.common.log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppLogContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PageSource f24249a = new PageSource();
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private String h;

    public String getPageLogToken() {
        return this.h;
    }

    public PageSource getPageSource() {
        return this.f24249a;
    }

    public boolean hasJSAPIError() {
        return this.c;
    }

    public boolean hasJSError() {
        return this.d;
    }

    public boolean hasResourceError() {
        return this.b;
    }

    public boolean hasScreenShot() {
        return this.f;
    }

    public boolean hasWhiteScreen() {
        return this.e;
    }

    public boolean isAlreadyRecordTagLog() {
        return this.g;
    }

    public void setAlreadyRecordTagLog(boolean z) {
        this.g = z;
    }

    public void setHasJSAPIError(boolean z) {
        this.c = z;
    }

    public void setHasJSError(boolean z) {
        this.d = z;
    }

    public void setHasResourceError(boolean z) {
        this.b = z;
    }

    public void setHasScreenShot(boolean z) {
        this.f = z;
    }

    public void setHasWhiteScreen(boolean z) {
        this.e = z;
    }

    public void setPageLogToken(String str) {
        this.h = str;
    }
}
