package cn.hzjizhun.admin.base.ad;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class NativeHelper {
    static {
        try {
            System.loadLibrary("cn_hzjizhun_admin_base");
        } catch (Throwable unused) {
        }
    }

    public static native String getSysBootMark();

    public static native String getSysUpdateMark();
}
