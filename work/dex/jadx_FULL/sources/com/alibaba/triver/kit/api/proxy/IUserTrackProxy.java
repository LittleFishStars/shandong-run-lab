package com.alibaba.triver.kit.api.proxy;

import android.content.Context;
import android.view.View;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IUserTrackProxy extends Proxiable {
    void controlHit(String str, Map<String, String> map);

    String getUtdid(Context context);

    void setExposureTag(View view, String str, String str2, Map<String, String> map);
}
