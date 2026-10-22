package com.google.android.exoplayer2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.igexin.sdk.PushConsts;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class NetworkTypeObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static NetworkTypeObserver f31161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f5277a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CopyOnWriteArrayList<WeakReference<Listener>> f5279a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5278a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("networkTypeLock")
    public int f5276a = 0;

    public interface Listener {
        void onNetworkTypeChanged(int i);
    }

    public final class Receiver extends BroadcastReceiver {
        public Receiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int iG = NetworkTypeObserver.g(context);
            if (gj9.f41922a < 31 || iG != 5) {
                NetworkTypeObserver.this.l(iG);
            } else {
                b.a(context, NetworkTypeObserver.this);
            }
        }
    }

    @RequiresApi(31)
    public static final class b {

        public static final class a extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final NetworkTypeObserver f31163a;

            public a(NetworkTypeObserver networkTypeObserver) {
                this.f31163a = networkTypeObserver;
            }

            @Override // android.telephony.TelephonyCallback.DisplayInfoListener
            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.f31163a.l(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void a(Context context, NetworkTypeObserver networkTypeObserver) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) sb0.g((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE));
                a aVar = new a(networkTypeObserver);
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), aVar);
                telephonyManager.unregisterTelephonyCallback(aVar);
            } catch (RuntimeException unused) {
                networkTypeObserver.l(5);
            }
        }
    }

    public NetworkTypeObserver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        context.registerReceiver(new Receiver(), intentFilter);
    }

    public static synchronized NetworkTypeObserver d(Context context) {
        if (f31161a == null) {
            f31161a = new NetworkTypeObserver(context);
        }
        return f31161a;
    }

    public static int e(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return gj9.f41922a >= 29 ? 9 : 0;
        }
    }

    public static int g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return e(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Listener listener) {
        listener.onNetworkTypeChanged(f());
    }

    @VisibleForTesting
    public static synchronized void k() {
        f31161a = null;
    }

    public int f() {
        int i;
        synchronized (this.f5278a) {
            i = this.f5276a;
        }
        return i;
    }

    public void i(final Listener listener) {
        j();
        this.f5279a.add(new WeakReference<>(listener));
        this.f5277a.post(new Runnable() { // from class: com.zj.adlib.cy5
            @Override // java.lang.Runnable
            public final void run() {
                this.f15904a.h(listener);
            }
        });
    }

    public final void j() {
        for (WeakReference<Listener> weakReference : this.f5279a) {
            if (weakReference.get() == null) {
                this.f5279a.remove(weakReference);
            }
        }
    }

    public final void l(int i) {
        synchronized (this.f5278a) {
            if (this.f5276a == i) {
                return;
            }
            this.f5276a = i;
            for (WeakReference<Listener> weakReference : this.f5279a) {
                Listener listener = weakReference.get();
                if (listener != null) {
                    listener.onNetworkTypeChanged(i);
                } else {
                    this.f5279a.remove(weakReference);
                }
            }
        }
    }
}
