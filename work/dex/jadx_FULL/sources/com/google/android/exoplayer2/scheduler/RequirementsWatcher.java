package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.igexin.sdk.PushConsts;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class RequirementsWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f3621a = gj9.A();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Requirements f3622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DeviceStatusChangeReceiver f3623a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Listener f3624a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public b f3625a;

    public class DeviceStatusChangeReceiver extends BroadcastReceiver {
        public DeviceStatusChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            RequirementsWatcher.this.e();
        }
    }

    public interface Listener {
        void a(RequirementsWatcher requirementsWatcher, int i);
    }

    @RequiresApi(24)
    public final class b extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3626a;
        public boolean b;

        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (RequirementsWatcher.this.f3625a != null) {
                RequirementsWatcher.this.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            if (RequirementsWatcher.this.f3625a != null) {
                RequirementsWatcher.this.g();
            }
        }

        public final void e() {
            RequirementsWatcher.this.f3621a.post(new Runnable() { // from class: com.zj.adlib.pf7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43971a.c();
                }
            });
        }

        public final void f() {
            RequirementsWatcher.this.f3621a.post(new Runnable() { // from class: com.zj.adlib.of7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43738a.d();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            e();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z) {
            if (z) {
                return;
            }
            f();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean zHasCapability = networkCapabilities.hasCapability(16);
            if (this.f3626a && this.b == zHasCapability) {
                if (zHasCapability) {
                    f();
                }
            } else {
                this.f3626a = true;
                this.b = zHasCapability;
                e();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            e();
        }
    }

    public RequirementsWatcher(Context context, Listener listener, Requirements requirements) {
        this.f3620a = context.getApplicationContext();
        this.f3624a = listener;
        this.f3622a = requirements;
    }

    public final void e() {
        int notMetRequirements = this.f3622a.getNotMetRequirements(this.f3620a);
        if (this.f30807a != notMetRequirements) {
            this.f30807a = notMetRequirements;
            this.f3624a.a(this, notMetRequirements);
        }
    }

    public Requirements f() {
        return this.f3622a;
    }

    public final void g() {
        if ((this.f30807a & 3) == 0) {
            return;
        }
        e();
    }

    @RequiresApi(24)
    public final void h() {
        ConnectivityManager connectivityManager = (ConnectivityManager) sb0.g((ConnectivityManager) this.f3620a.getSystemService("connectivity"));
        b bVar = new b();
        this.f3625a = bVar;
        connectivityManager.registerDefaultNetworkCallback(bVar);
    }

    public int i() {
        this.f30807a = this.f3622a.getNotMetRequirements(this.f3620a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.f3622a.isNetworkRequired()) {
            if (gj9.f41922a >= 24) {
                h();
            } else {
                intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            }
        }
        if (this.f3622a.isChargingRequired()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.f3622a.isIdleRequired()) {
            if (gj9.f41922a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.f3622a.isStorageNotLowRequired()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        DeviceStatusChangeReceiver deviceStatusChangeReceiver = new DeviceStatusChangeReceiver();
        this.f3623a = deviceStatusChangeReceiver;
        this.f3620a.registerReceiver(deviceStatusChangeReceiver, intentFilter, null, this.f3621a);
        return this.f30807a;
    }

    public void j() {
        this.f3620a.unregisterReceiver((BroadcastReceiver) sb0.g(this.f3623a));
        this.f3623a = null;
        if (gj9.f41922a < 24 || this.f3625a == null) {
            return;
        }
        k();
    }

    @RequiresApi(24)
    public final void k() {
        ((ConnectivityManager) sb0.g((ConnectivityManager) this.f3620a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) sb0.g(this.f3625a));
        this.f3625a = null;
    }
}
