package cn.jy.ad.sdk.jyinter;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IJyAdSdk {
    ILoader createLoader(Context context);

    IEventProcessor getEventProcessor();

    void init(Context context, ValueSet valueSet);
}
