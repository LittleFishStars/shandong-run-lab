package com.bwt.top.channel;

import android.content.Context;
import com.bwt.top.AdPlatforms;
import com.bwt.top.ad.adapter.ThirdSdkInit;
import com.bwt.top.ad.adapter.ThirdSdkInitCallback;
import com.bwt.top.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ChannelThirdSdkInit implements ThirdSdkInit {
    private String TAG = ChannelThirdSdkInit.class.getSimpleName();

    @Override // com.bwt.top.ad.adapter.ThirdSdkInit
    public String getPlatformType() {
        return AdPlatforms.channel.name();
    }

    @Override // com.bwt.top.ad.adapter.ThirdSdkInit
    public void init(Context context, String str) {
    }

    @Override // com.bwt.top.ad.adapter.ThirdSdkInit
    public void setThirdSdkInitCallback(ThirdSdkInitCallback thirdSdkInitCallback) {
        ALog.i(this.TAG, "init");
        thirdSdkInitCallback.onSucceed("channel sdk init");
    }
}
