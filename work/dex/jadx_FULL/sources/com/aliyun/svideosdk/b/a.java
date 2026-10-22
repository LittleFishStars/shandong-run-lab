package com.aliyun.svideosdk.b;

import android.content.Context;
import android.util.Log;
import com.aliyun.svideosdk.AlivcSdkCore;
import com.aliyun.svideosdk.conan.AlivcConan;
import com.aliyun.svideosdk.conan.event.AlivcEventReporter;
import com.aliyun.svideosdk.conan.event.b;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AlivcEventReporter f25615a;

    public a(Context context) {
        if (AlivcSdkCore.AlivcLogLevel.AlivcLogClose == AlivcSdkCore.getLogLevel()) {
            return;
        }
        AlivcConan.a(context);
        b bVar = new b();
        bVar.a(context.getApplicationInfo().labelRes == 0 ? "unknown" : context.getString(context.getApplicationInfo().labelRes));
        bVar.a(com.aliyun.svideosdk.conan.a.AlivcConanBusinessSvideo);
        bVar.a(false);
        AlivcEventReporter alivcEventReporter = new AlivcEventReporter(bVar);
        this.f25615a = alivcEventReporter;
        alivcEventReporter.b("6.7.0");
        this.f25615a.a(" + 0 +  + 0");
        this.f25615a.d("sdk");
    }

    private int a(int i, HashMap<String, String> map) {
        AlivcEventReporter alivcEventReporter = this.f25615a;
        if (alivcEventReporter == null) {
            return -4;
        }
        int iA = alivcEventReporter.a(i, map);
        Log.d("AlivcSDKReporter", "sendEvent " + i + " result is " + iA);
        return iA;
    }

    public int a(boolean z) {
        HashMap<String, String> map = new HashMap<>();
        map.put("result", z ? "1" : "0");
        return a(11001, map);
    }

    public long a() {
        AlivcEventReporter alivcEventReporter = this.f25615a;
        if (alivcEventReporter != null) {
            return alivcEventReporter.a();
        }
        return -1L;
    }

    public void b() {
        AlivcEventReporter alivcEventReporter = this.f25615a;
        if (alivcEventReporter != null) {
            alivcEventReporter.destory();
            this.f25615a = null;
        }
    }
}
