package com.kc.openset.util;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class NetworkToolsUtils {

    @Keep
    public enum Network {
        BAI_DU,
        KUAI_SHOU,
        GUANG_DIAN_TONG,
        GROMORE;

        static {
            OSETSDKProtected.interface11(4941);
        }

        public static native Network valueOf(String str);

        public static native Network[] values();
    }

    @Keep
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f39945a;

        static {
            OSETSDKProtected.interface11(4942);
            int[] iArr = new int[Network.values().length];
            f39945a = iArr;
            try {
                iArr[Network.BAI_DU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39945a[Network.KUAI_SHOU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39945a[Network.GUANG_DIAN_TONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39945a[Network.GROMORE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        OSETSDKProtected.interface11(4943);
    }

    public static native void startTools(Network network, Activity activity);
}
