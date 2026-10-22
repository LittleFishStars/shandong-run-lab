package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.p0003l.fh;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.fo;
import com.amap.api.col.p0003l.hl;
import com.zj.adlib.gia;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    public static String TERRAIN_LOCAL_DEM_SOURCE_PATH = null;
    private static boolean closeTileOverlay = false;
    private static ExceptionLogger exceptionLogger = null;
    private static boolean isLoadWorldGridMap = false;
    private static boolean isNeedDownloadCoordinateConvertLibrary = true;
    private static boolean isNetWorkEnable = true;
    private static boolean isPolyline2Enable = true;
    private static boolean isSupportRecycleView = true;
    private static boolean isTerrainEnable = false;
    private static boolean isTextureDestroyedRender = false;
    private static boolean isTextureSizeChangedInvoked = false;
    private static boolean isTextureViewDestorySync = true;
    private static boolean isloadWorldVectorMap = true;
    private static int mProtocol = 1;
    private static String mWorldVectorOfflineMapStyleAssetsPath = "";
    private static String mWorldVectorOfflineMapStyleFilePath = "";
    public static String sdcardDir = "";

    public static void disableCachedMapDataUpdate(boolean z) {
    }

    public static String getDeviceId(Context context) {
        return fj.f0(context);
    }

    public static ExceptionLogger getExceptionLogger() {
        return exceptionLogger;
    }

    public static boolean getNetWorkEnable() {
        return isNetWorkEnable;
    }

    public static boolean getPolyline2Enable() {
        return true;
    }

    public static int getProtocol() {
        return mProtocol;
    }

    public static boolean getTextureDestroyRender() {
        return isTextureDestroyedRender;
    }

    public static boolean getTextureSizeChangedInvoked() {
        return isTextureSizeChangedInvoked;
    }

    public static boolean getTextureViewDestorySync() {
        return isTextureViewDestorySync;
    }

    public static String getVersion() {
        return "9.5.0";
    }

    public static String getWorldVectorOfflineMapStyleAssetsPath() {
        return mWorldVectorOfflineMapStyleAssetsPath;
    }

    public static String getWorldVectorOfflineMapStyleFilePath() {
        return mWorldVectorOfflineMapStyleFilePath;
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            gia.f41914a = context.getApplicationContext();
        } else {
            Log.w("MapsInitializer", "the context is null");
        }
    }

    public static boolean isDisableCachedMapDataUpdate() {
        return false;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return isNeedDownloadCoordinateConvertLibrary;
    }

    public static boolean isLoadWorldGridMap() {
        return isLoadWorldGridMap;
    }

    public static boolean isLoadWorldVectorMap() {
        return isloadWorldVectorMap;
    }

    public static boolean isSupportRecycleView() {
        return isSupportRecycleView;
    }

    public static boolean isTerrainEnable() {
        return isTerrainEnable;
    }

    public static void loadWorldVectorMap(boolean z) {
        isloadWorldVectorMap = z;
    }

    public static void setApiKey(String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        fh.l(gia.f41914a, str);
    }

    public static void setBuildingHeight(int i) {
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z) {
        isNeedDownloadCoordinateConvertLibrary = z;
    }

    public static void setExceptionLogger(ExceptionLogger exceptionLogger2) {
        exceptionLogger = exceptionLogger2;
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            hl.f25967a = -1;
            hl.f924a = "";
        } else {
            hl.f25967a = 1;
            hl.f924a = str;
        }
    }

    public static void setNetWorkEnable(boolean z) {
        isNetWorkEnable = z;
    }

    public static void setPolyline2Enable(boolean z) {
    }

    public static void setProtocol(int i) {
        mProtocol = i;
    }

    public static void setSupportRecycleView(boolean z) {
        isSupportRecycleView = z;
    }

    public static void setTerrainEnable(boolean z) {
        isTerrainEnable = z;
    }

    public static void setTextureDestroyedRender(boolean z) {
        isTextureDestroyedRender = z;
    }

    public static void setTextureSizeChangedInvoked(boolean z) {
        isTextureSizeChangedInvoked = z;
    }

    public static void setTextureViewDestorySync(boolean z) {
        isTextureViewDestorySync = z;
    }

    public static void setWorldVectorOfflineMapStyleAssetsPath(String str) {
        mWorldVectorOfflineMapStyleAssetsPath = str;
    }

    public static void setWorldVectorOfflineMapStyleFilePath(String str) {
        mWorldVectorOfflineMapStyleFilePath = str;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z) {
        fo.i(context, z, zwa.t());
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z, boolean z2) {
        fo.j(context, z, z2, zwa.t());
    }
}
