package com.kc.bw.common.Iinterface;

import android.content.Context;
import com.kc.bw.common.Ibase.IBaseInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface InterstitialInterface extends IBaseInterface<InterstitialInterface> {
    void close();

    void destroy();

    Map getAdInfo();

    @Override // com.kc.bw.common.Ibase.IBaseInterface
    boolean isReady();

    void load();

    void show(Context context);
}
