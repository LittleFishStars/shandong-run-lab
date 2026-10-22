package com.aliyun.common.c.b;

import android.util.Log;
import com.aliyun.svideosdk.conan.event.AlivcEventReporter;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AlivcEventReporter f25568a;
    protected int b;
    protected boolean c = false;
    protected boolean d = false;

    public int a(int i, HashMap<String, String> map) {
        AlivcEventReporter alivcEventReporter = this.f25568a;
        if (alivcEventReporter == null) {
            return -4;
        }
        int iA = alivcEventReporter.a(i, map);
        Log.d("AlivcReporter", "sendEvent " + i + " result is " + iA);
        return iA;
    }

    public int a(HashMap<String, String> map) {
        AlivcEventReporter alivcEventReporter = this.f25568a;
        if (alivcEventReporter == null) {
            return -4;
        }
        int iA = alivcEventReporter.a(this.b, map);
        Log.d("AlivcReporter", "sendEvent result is " + iA);
        return iA;
    }

    public long a() {
        AlivcEventReporter alivcEventReporter = this.f25568a;
        if (alivcEventReporter != null) {
            return alivcEventReporter.a();
        }
        return 0L;
    }

    public void b() {
        this.c = true;
        AlivcEventReporter alivcEventReporter = this.f25568a;
        if (alivcEventReporter == null || this.d) {
            return;
        }
        alivcEventReporter.destory();
        this.f25568a = null;
    }
}
