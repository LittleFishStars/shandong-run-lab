package com.alibaba.triver.preload.b.c;

import com.alibaba.triver.triver_render.render.WMLTRWebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WMLTRWebView f25127a;
    private long b;
    private int c;
    private String d;
    private String e;

    public d(WMLTRWebView wMLTRWebView, long j) {
        this.f25127a = wMLTRWebView;
        this.b = j;
    }

    public WMLTRWebView a() {
        return this.f25127a;
    }

    public long b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public void d() {
        try {
            WMLTRWebView wMLTRWebView = this.f25127a;
            if (wMLTRWebView != null) {
                wMLTRWebView.destroy();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f25127a = null;
    }

    public boolean e() {
        WMLTRWebView wMLTRWebView = this.f25127a;
        if (wMLTRWebView == null) {
            return false;
        }
        return wMLTRWebView.m();
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(String str) {
        this.e = str;
    }

    public void a(boolean z) {
        WMLTRWebView wMLTRWebView = this.f25127a;
        if (wMLTRWebView != null) {
            wMLTRWebView.setTemplateRender(z);
        }
    }

    public void a(String str) {
        this.d = str;
    }
}
