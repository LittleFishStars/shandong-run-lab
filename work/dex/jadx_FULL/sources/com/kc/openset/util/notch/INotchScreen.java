package com.kc.openset.util.notch;

import android.app.Activity;
import android.graphics.Rect;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface INotchScreen {

    @Keep
    public interface HasNotchCallback {
        void onResult(boolean z);
    }

    @Keep
    public interface NotchScreenCallback {
        void onResult(a aVar);
    }

    @Keep
    public interface NotchSizeCallback {
        void onResult(List<Rect> list);
    }

    @Keep
    public static class a {
    }

    void getNotchRect(Activity activity, NotchSizeCallback notchSizeCallback);

    boolean hasNotch(Activity activity);

    void setDisplayInNotch(Activity activity);
}
