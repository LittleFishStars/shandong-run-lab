package com.hailiang.advlib.core;

import android.os.Bundle;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class ICliUtils {

    @Keep
    public interface BannerStateListener {
        void onADDeliveredResult(boolean z, String str);

        void onADEventTriggered(int i, Bundle bundle);

        void onADShown();
    }

    @Keep
    public interface a {
        void a(ICliBundle iCliBundle);
    }
}
