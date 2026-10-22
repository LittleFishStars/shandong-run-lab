package cj.mobile.wm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.igexin.sdk.PushConsts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o7 implements m7 {
    public final Context dexa;
    public final m7.dexa dexb;
    public boolean dexc;
    public boolean dexd;
    public final BroadcastReceiver dexe = new dexa();

    public class dexa extends BroadcastReceiver {
        public dexa() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = o7.this.dexc;
            o7 o7Var = o7.this;
            o7Var.dexc = o7Var.dexa(context);
            if (z != o7.this.dexc) {
                o7.this.dexb.a(o7.this.dexc);
            }
        }
    }

    public o7(Context context, m7.dexa dexaVar) {
        this.dexa = context.getApplicationContext();
        this.dexb = dexaVar;
    }

    private void dexa() {
        if (this.dexd) {
            return;
        }
        this.dexc = dexa(this.dexa);
        this.dexa.registerReceiver(this.dexe, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
        this.dexd = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dexa(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void dexb() {
        if (this.dexd) {
            this.dexa.unregisterReceiver(this.dexe);
            this.dexd = false;
        }
    }

    @Override // cj.mobile.wm.r7
    public void a() {
        dexa();
    }

    @Override // cj.mobile.wm.r7
    public void b() {
        dexb();
    }

    @Override // cj.mobile.wm.r7
    public void d() {
    }
}
