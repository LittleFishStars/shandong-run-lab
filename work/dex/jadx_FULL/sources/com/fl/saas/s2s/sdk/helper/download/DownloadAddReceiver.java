package com.fl.saas.s2s.sdk.helper.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CommClickHelper;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DownloadAddReceiver extends BroadcastReceiver {
    private AdInfoPoJo adInfoPoJo;
    private Context mContext;

    public void actionDownloadService(Context context, String str) {
        try {
            AdInfoPoJo adInfoPoJo = this.adInfoPoJo;
            if (adInfoPoJo != null && adInfoPoJo.app_package.equals(str)) {
                CommClickHelper.getInstance().report(context, this.adInfoPoJo, 7);
            }
            unRegisterX();
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null || intent.getAction() == null || !intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            return;
        }
        try {
            Uri data = intent.getData();
            String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
            if (schemeSpecificPart != null) {
                if (schemeSpecificPart.contains(u15.f19942b)) {
                    schemeSpecificPart = schemeSpecificPart.subSequence(schemeSpecificPart.indexOf(u15.f19942b) + 1, schemeSpecificPart.length()).toString();
                }
                actionDownloadService(context, schemeSpecificPart);
            }
        } catch (Throwable unused) {
        }
    }

    public void registerX(Context context) {
        try {
            this.mContext = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(Integer.MAX_VALUE);
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(this, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPoJo(AdInfoPoJo adInfoPoJo) {
        this.adInfoPoJo = adInfoPoJo;
    }

    public void unRegisterX() {
        Context context = this.mContext;
        if (context != null) {
            try {
                context.unregisterReceiver(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
