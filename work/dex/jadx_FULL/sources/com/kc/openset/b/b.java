package com.kc.openset.b;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bean.OSETLogUploadBean;
import com.kc.openset.constant.LogUploadType;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class b {

    @Keep
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f39698a;

        static {
            OSETSDKProtected.interface11(4288);
            int[] iArr = new int[LogUploadType.values().length];
            f39698a = iArr;
            try {
                iArr[LogUploadType.INIT_TRACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39698a[LogUploadType.REQUEST_RESULT_TRACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39698a[LogUploadType.IMP_TRACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39698a[LogUploadType.CLICK_TRACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f39698a[LogUploadType.CLOSE_TRACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f39698a[LogUploadType.USER_TRACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f39698a[LogUploadType.ERROR_TRACK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f39698a[LogUploadType.REQUEST_ALL_TRACK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f39698a[LogUploadType.SKIP_TRACK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f39698a[LogUploadType.REWARD_TRACK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f39698a[LogUploadType.REWARD_LIFECYCLE_TRACK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f39698a[LogUploadType.IMP_USER_TRACK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f39698a[LogUploadType.REQUEST_USER_TRACK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f39698a[LogUploadType.BID_RESULT_TRACK.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f39698a[LogUploadType.APPLICATION_LIST_TRACK.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f39698a[LogUploadType.TT_VIDEO_CONTENT_OPEN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f39698a[LogUploadType.KS_VIDEO_CONTENT_OPEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f39698a[LogUploadType.REWARD_CALLBACK_RESULT.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f39698a[LogUploadType.ADV_IMP_TRACK.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f39698a[LogUploadType.ADV_BIDDING_TRACK.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f39698a[LogUploadType.ADV_CLICK_TRACK.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f39698a[LogUploadType.ADV_TRACKING_TRACK.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f39698a[LogUploadType.ADV_OPERATION_TRACK.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f39698a[LogUploadType.DEEPLINK_REGEX_CHECK_PASS.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f39698a[LogUploadType.DEEPLINK_REPLACE_RESULT.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f39698a[LogUploadType.OAID_TRACK.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
        }
    }

    static {
        OSETSDKProtected.interface11(4289);
    }

    public static native void a(OSETLogUploadBean oSETLogUploadBean);

    private static native void b(OSETLogUploadBean oSETLogUploadBean);
}
