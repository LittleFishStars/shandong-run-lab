package cn.hzjizhun.admin.channel;

import android.content.Context;
import cn.hzjizhun.admin.ad.adapter.ThirdSdkInit;
import cn.hzjizhun.admin.ad.adapter.ThirdSdkInitCallback;
import cn.hzjizhun.admin.ad.bean.AdPlatforms;
import cn.hzjizhun.admin.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ChannelThirdSdkInit implements ThirdSdkInit {
    private String TAG = getClass().getSimpleName();

    @Override // cn.hzjizhun.admin.ad.adapter.ThirdSdkInit
    public String getPlatformType() {
        return AdPlatforms.channel.name();
    }

    @Override // cn.hzjizhun.admin.ad.adapter.ThirdSdkInit
    public void init(Context context, String str) {
    }

    @Override // cn.hzjizhun.admin.ad.adapter.ThirdSdkInit
    public void setThirdSdkInitCallback(ThirdSdkInitCallback thirdSdkInitCallback) {
        ALog.i(this.TAG, "init");
        thirdSdkInitCallback.onSucceed("channel sdk init");
    }
}
