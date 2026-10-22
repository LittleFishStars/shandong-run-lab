package com.baidu.mshield.rp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mshield.utility.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Receiver extends BroadcastReceiver {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f26711a;

        public a(Receiver receiver, Context context) {
            this.f26711a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(this.f26711a);
            com.baidu.mshield.utility.a.a(this.f26711a, aVarA.J() * 3600000);
            aVarA.b(System.currentTimeMillis());
        }
    }

    public void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            new Thread(new a(this, context)).start();
            b.a(context).d();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && action.equals("com.b.r.p")) {
                a(context, intent);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }
}
