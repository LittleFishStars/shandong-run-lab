package com.aliyun.aio_stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.igexin.sdk.PushConsts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25557a = "";
    private boolean b = false;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f25558a = new b();
    }

    public static b a() {
        return a.f25558a;
    }

    private synchronized void a(Context context) {
        if (!this.b) {
            context.registerReceiver(this, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
            this.b = true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0069  */
    private void c() {
        try {
            Context applicationContext = ContextHolder.getApplicationContext();
            if (applicationContext != null) {
                a(applicationContext);
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    this.f25557a = "NoActive";
                    return;
                }
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (activeNetworkInfo.getType() == 1) {
                    subtypeName = NetworkUtil.NETWORK_TYPE_WIFI;
                } else if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            subtypeName = NetworkUtil.NETWORK_TYPE_2G;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            subtypeName = NetworkUtil.NETWORK_TYPE_3G;
                            break;
                        case 13:
                            subtypeName = NetworkUtil.NETWORK_TYPE_4G;
                            break;
                        default:
                            if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                                subtypeName = NetworkUtil.NETWORK_TYPE_3G;
                            } else {
                                subtypeName = "Mobile:" + subtypeName;
                            }
                            break;
                    }
                }
                this.f25557a = subtypeName;
            }
        } catch (Exception unused) {
        }
    }

    public String b() {
        if (this.f25557a.isEmpty()) {
            c();
        }
        return this.f25557a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
            c();
        }
    }
}
