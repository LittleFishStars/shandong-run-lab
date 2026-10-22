package com.fl.saas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class G extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f30055a;
    private C1415j b;

    public void a(String str) {
        try {
            C1415j c1415j = this.b;
            if (c1415j != null && c1415j.A0.equals(str)) {
                C1435t.a().a(this.b, 7);
            }
            a();
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null || intent.getAction() == null || !intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            return;
        }
        try {
            Uri data = intent.getData();
            String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
            if (schemeSpecificPart != null) {
                if (schemeSpecificPart.contains(u15.f19942b)) {
                    schemeSpecificPart = schemeSpecificPart.subSequence(schemeSpecificPart.indexOf(u15.f19942b) + 1, schemeSpecificPart.length()).toString();
                }
                a(schemeSpecificPart);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Context context) {
        try {
            this.f30055a = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(Integer.MAX_VALUE);
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(this, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(C1415j c1415j) {
        this.b = c1415j;
    }

    public void a() {
        Context context = this.f30055a;
        if (context != null) {
            try {
                context.unregisterReceiver(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
