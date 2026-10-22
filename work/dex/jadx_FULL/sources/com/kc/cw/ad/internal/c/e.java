package com.kc.cw.ad.internal.c;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f38945a;
    private String b;
    private Map<String, List<String>> c;
    private i d;
    private int e;

    public void a(int i) {
        this.e = i;
    }

    public void a(i iVar) {
        this.d = iVar;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(Map<String, List<String>> map) {
        this.c = map;
    }

    public void a(boolean z) {
        this.f38945a = z;
    }

    public boolean a() {
        return this.f38945a;
    }

    public int b() {
        return this.e;
    }

    public i c() {
        return this.d;
    }

    public String d() {
        return this.b;
    }
}
