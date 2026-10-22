package com.alibaba.triver.inside.impl;

import android.content.Context;
import android.view.View;
import com.alibaba.triver.kit.api.proxy.IUserTrackProxy;
import com.alibaba.triver.monitor.d;
import com.ut.device.UTDevice;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UserTrackProxyImpl implements IUserTrackProxy {
    @Override // com.alibaba.triver.kit.api.proxy.IUserTrackProxy
    public void controlHit(String str, Map<String, String> map) {
        UTHitBuilders.UTControlHitBuilder uTControlHitBuilder = new UTHitBuilders.UTControlHitBuilder(d.b, str);
        uTControlHitBuilder.setProperties(map);
        UTAnalytics.getInstance().getDefaultTracker().send(uTControlHitBuilder.build());
    }

    @Override // com.alibaba.triver.kit.api.proxy.IUserTrackProxy
    public String getUtdid(Context context) {
        return UTDevice.getUtdid(context);
    }

    @Override // com.alibaba.triver.kit.api.proxy.IUserTrackProxy
    public void setExposureTag(View view, String str, String str2, Map<String, String> map) {
        UTAnalytics.getInstance().getDefaultTracker().setExposureTag(view, str, str2, map);
    }
}
