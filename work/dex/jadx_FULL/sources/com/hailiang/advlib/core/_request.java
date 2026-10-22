package com.hailiang.advlib.core;

import android.os.Bundle;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface _request {
    void InvokeADV(String str, int i, int i2, int i3);

    void InvokeADV(String str, int i, int i2, int i3, Bundle bundle);

    void InvokeADV(List<String> list);

    void InvokeADV(String... strArr);

    void bindAdContentListener(ICliUtils.a aVar);

    void onClickedReport();

    void onShowedReport();

    void removeAdContentListener();

    void unbindAdContentListener(ICliUtils.a aVar);
}
