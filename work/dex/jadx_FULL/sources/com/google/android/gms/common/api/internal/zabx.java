package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zabx extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Context f31263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zabw f5614a;

    public zabx(zabw zabwVar) {
        this.f5614a = zabwVar;
    }

    public final void a(Context context) {
        this.f31263a = context;
    }

    public final synchronized void b() {
        Context context = this.f31263a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f31263a = null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f5614a.a();
            b();
        }
    }
}
