package com.alibaba.alibcprotocol;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.igexin.sdk.PushConsts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NetworkChangeReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f23602a = new Handler(Looper.getMainLooper());
    private Runnable b = new Runnable() { // from class: com.alibaba.alibcprotocol.NetworkChangeReceiver.1
        @Override // java.lang.Runnable
        public final void run() {
            if (AlibcCommonConstant.BASE_CONFIG_REQUEST_SUCCESS && AlibcCommonConstant.SUITE_CONFIG_REQUEST_SUCCESS) {
                AlibcConfigService.getInstance().unregisterReceiver(AlibcBaseTradeCommon.context);
            } else {
                AlibcConfigService.getInstance().requestConfig(AlibcBaseTradeCommon.context);
            }
        }
    };

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction()) || "android.net.wifi.STATE_CHANGE".equals(intent.getAction()) || "android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
            this.f23602a.removeCallbacks(this.b);
            this.f23602a.postDelayed(this.b, 2000L);
        }
    }
}
