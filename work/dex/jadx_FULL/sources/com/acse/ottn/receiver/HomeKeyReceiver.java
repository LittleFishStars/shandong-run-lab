package com.acse.ottn.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.acse.ottn.n3;
import com.acse.ottn.s0;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HomeKeyReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23178a = MediationConstant.KEY_REASON;
    public final String b = "recentapps";
    public final String c = "homekey";
    public boolean d = false;
    public Handler e = new Handler();
    public Runnable f = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeKeyReceiver.this.d = false;
        }
    }

    public final void a(Context context, String str, String str2) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (!"android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) || (stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON)) == null) {
            return;
        }
        if (stringExtra.equals("homekey")) {
            a(context);
        } else {
            if (stringExtra.equals("recentapps")) {
                return;
            }
            a(context);
        }
    }

    public final void a(Context context) {
        if ((n3.a() == null && n3.a().a("setting_day")) || this.d) {
            return;
        }
        this.d = true;
        this.e.postDelayed(this.f, 3000L);
        String strA = s0.d().a();
        String strE = n3.a().e("am_show_seed_dialog");
        String strE2 = n3.a().e("pm_show_seed_dialog");
        int iB = s0.d().b();
        if (iB >= 1400) {
            if (strA.equals(strE2) || iB < 1400 || iB >= 2100) {
                return;
            }
            a(context, "pm_show_seed_dialog", strA);
            return;
        }
        if (strA.equals(strE) || iB < 800 || iB >= 1400) {
            return;
        }
        a(context, "am_show_seed_dialog", strA);
    }
}
