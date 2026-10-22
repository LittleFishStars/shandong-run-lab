package cj.mobile.wm.common.Iinterface;

import android.content.Context;
import cj.mobile.wm.common.Ibase.IBaseInterface;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface InterstitialInterface extends IBaseInterface<InterstitialInterface> {
    void close();

    void destroy();

    Map getAdInfo();

    @Override // cj.mobile.wm.common.Ibase.IBaseInterface
    boolean isReady();

    void load();

    void show(Context context);
}
