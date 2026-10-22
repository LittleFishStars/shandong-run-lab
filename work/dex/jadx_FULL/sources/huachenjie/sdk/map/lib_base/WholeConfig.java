package huachenjie.sdk.map.lib_base;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WholeConfig {
    private static String gaodeStyleDataPath = null;
    private static String gaodeStyleExtraDataPath = null;
    private static String gaodeStyleId = null;
    private static String gaodeStyleTexturePath = null;
    private static String mBaiduStylePath = null;
    private static String mGoogleStylePath = null;
    private static int mIconHeight = 40;
    private static int mIconWidth = 40;
    private static int mLocationMarkerResId;
    private static boolean mMockEnable;

    public static String getBaiduStylePath() {
        return mBaiduStylePath;
    }

    public static String getGaodeStyleDataPath() {
        return gaodeStyleDataPath;
    }

    public static String getGaodeStyleExtraDataPath() {
        return gaodeStyleExtraDataPath;
    }

    public static String getGaodeStyleId() {
        return gaodeStyleId;
    }

    public static String getGaodeStyleTexturePath() {
        return gaodeStyleTexturePath;
    }

    public static int getIconHeight() {
        return mIconHeight;
    }

    public static int getIconWidth() {
        return mIconWidth;
    }

    public static int getLocationMarkerResId() {
        return mLocationMarkerResId;
    }

    public static String getmGoogleStylePath() {
        return mGoogleStylePath;
    }

    public static boolean isMockEnable() {
        return mMockEnable;
    }

    public static void setGaodeMapStyle(String str, String str2, String str3, String str4) {
        gaodeStyleDataPath = str;
        gaodeStyleExtraDataPath = str2;
        gaodeStyleTexturePath = str3;
        gaodeStyleId = str4;
    }

    public static void setLocationMockEnable(boolean z) {
        mMockEnable = z;
    }

    public static void setMapStylePath(String str, String str2) {
        mBaiduStylePath = str;
        mGoogleStylePath = str2;
    }

    public static void setMyLocationMarkerRes(int i) {
        mLocationMarkerResId = i;
    }

    public static void setOnlineIconHeight(int i) {
        mIconHeight = i;
    }

    public static void setOnlineIconWidth(int i) {
        mIconWidth = i;
    }
}
