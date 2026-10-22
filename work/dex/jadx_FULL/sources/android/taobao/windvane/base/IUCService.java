package android.taobao.windvane.base;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface IUCService<T> {
    public static final int DOWNLOAD = 1;
    public static final int INNER = 0;
    public static final int U420 = 2;
    public static final int U430 = 3;
    public static final String WIFI = "wifi";
    public static final String _2G = "2g";
    public static final String _3G = "3g";
    public static final String _4G = "4g";

    int getCorePolicy();

    int gpuMultiType();

    void initSW();

    void initUCCore();

    boolean isUCSupport();

    boolean open4GDownload();

    int renderMultiType();

    void setCoreType(boolean z);

    @Deprecated
    String unZipCore();

    void updateConfig(T t);

    void updateCore(Context context, String str);

    boolean useSystemCore(Context context);
}
