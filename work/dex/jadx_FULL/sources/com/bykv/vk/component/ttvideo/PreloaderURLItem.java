package com.bykv.vk.component.ttvideo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class PreloaderURLItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29279a;
    private String b;
    private final String c;
    private final long d;
    private String[] e;
    private IPreLoaderItemCallBackListener f;

    public PreloaderURLItem(String str, String str2, long j, String[] strArr) {
        this.b = null;
        this.f = null;
        this.f29279a = str;
        this.c = str2;
        this.d = j;
        this.e = strArr;
    }

    public PreloaderURLItem(String str, String str2, long j, String[] strArr, String str3) {
        this.f = null;
        this.f29279a = str;
        this.b = str3;
        this.c = str2;
        this.d = j;
        this.e = strArr;
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.f;
    }

    public String getFilePath() {
        return this.b;
    }

    public String getKey() {
        return this.f29279a;
    }

    public long getPreloadSize() {
        return this.d;
    }

    public String[] getUrls() {
        return this.e;
    }

    public String getVideoId() {
        return this.c;
    }

    public void setCallBackListener(IPreLoaderItemCallBackListener iPreLoaderItemCallBackListener) {
        this.f = iPreLoaderItemCallBackListener;
    }

    public void setKey(String str) {
        this.f29279a = str;
    }
}
