package com.acse.ottn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.acse.ottn.util.HelpShopAppUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class w2 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23278a;
    public Handler b = new Handler();
    public Runnable c = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(w2.this.f23278a));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.addFlags(268435456);
                HelpShopAppUtil.getContext().startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f23278a = intent.getStringExtra("url");
        this.b.postDelayed(this.c, 1000L);
    }
}
