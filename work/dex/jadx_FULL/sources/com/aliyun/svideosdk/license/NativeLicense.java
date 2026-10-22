package com.aliyun.svideosdk.license;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class NativeLicense {

    public enum SERVICE_TYPE {
        MV(1),
        STICKER(2),
        PHOTO_ALBUM(3),
        CROP_COMPOSE(4),
        CAPTION(5),
        VIDEO_STITCH(6),
        VIDEO_TEMPLATE(7);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f25777a;

        SERVICE_TYPE(int i) {
            this.f25777a = i;
        }

        public int getValue() {
            return this.f25777a;
        }
    }

    public enum VERSION_TYPE {
        BASIC(1),
        CUSTOM(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f25778a;

        VERSION_TYPE(int i) {
            this.f25778a = i;
        }

        public int getValue() {
            return this.f25778a;
        }
    }

    public static boolean checkServiceLicense(SERVICE_TYPE service_type) {
        return nativeCheckServiceLicense(service_type.getValue());
    }

    public static boolean checkVersionLimit(VERSION_TYPE version_type) {
        return nativeCheckVersionLimit(version_type.getValue());
    }

    public static String getServiceContext(SERVICE_TYPE service_type) {
        return nativeGetServiceContext(service_type.getValue());
    }

    private static native boolean nativeCheckServiceLicense(int i);

    private static native boolean nativeCheckVersionLimit(int i);

    private static native String nativeGetServiceContext(int i);
}
