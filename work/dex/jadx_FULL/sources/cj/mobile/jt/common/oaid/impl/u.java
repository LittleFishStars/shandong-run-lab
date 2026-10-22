package cj.mobile.jt.common.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import cj.mobile.jt.common.utils.w0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class u implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22331a;
    public final cj.mobile.jt.common.oaid.a b;
    public final t c;

    public u(Context context, w0 w0Var, t tVar) {
    }

    public static void a(Context context, Intent intent, w0 w0Var, t tVar) {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        componentName.getClassName();
    }
}
