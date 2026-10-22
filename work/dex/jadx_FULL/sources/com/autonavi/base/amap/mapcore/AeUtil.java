package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.os.Looper;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.amap.api.col.p0003l.it;
import com.autonavi.amap.mapcore.MsgProcessor;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.config.a;
import com.zj.adlib.a7b;
import com.zj.adlib.axa;
import com.zj.adlib.bxa;
import com.zj.adlib.c7b;
import com.zj.adlib.pwa;
import com.zj.adlib.r4b;
import com.zj.adlib.xwa;
import com.zj.adlib.ywa;
import com.zj.adlib.zwa;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AeUtil {
    private static final String AMAP_ASSETS_DB_CK_PATH = "ae/res.ck";
    private static final String AMAP_GLOBAL_DB_NAME = "global.db";
    private static final String AMAP_GLOBAL_SP_ITEM_MD5 = "amap_res_global_db_md5";
    private static final String AMAP_GLOBAL_SP_NAME = "amap_res_global_db";
    private static final String AMAP_INTERSECTION_ASSETS_DIR = "VM3DRes";
    public static final String AMAP_RESZIP_TARGET_DIR_NAME = "res920";
    public static final String CONFIGNAME = "GNaviConfig.xml";
    public static final boolean IS_AE = true;
    public static final String RESZIPNAME = "res.zip";
    public static final String ROOTPATH = "/amap/";
    public static final String ROOT_DATA_PATH_NAME = "data_v6";
    public static final String ROOT_DATA_PATH_OLD_NAME = "data";
    private static String global_db_path;

    private static boolean checkEngineRes(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2 != null && file2.getName().contains(AMAP_GLOBAL_DB_NAME)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String formatFileSeparator(String str) {
        return str != null ? str.replace("//", WVNativeCallbackUtil.SEPERATER) : str;
    }

    private static String getAssetsGlobalDbMd5(Context context) {
        return new String(FileUtil.readFileContentsFromAssets(context, AMAP_ASSETS_DB_CK_PATH));
    }

    public static String getGlobalDbPath() {
        return global_db_path;
    }

    public static void initCrashHandle(Context context) {
        r4b r4bVarT;
        try {
            if (!c7b.a(zwa.t()).c(context) || (r4bVarT = zwa.t()) == null) {
                return;
            }
            MsgProcessor.nativeInitInfo(context, c7b.a(r4bVarT).d(context), r4bVarT.a(), r4bVarT.e(), r4bVarT.f(), r4bVarT.i());
        } catch (Throwable th) {
            zwa.D(th);
        }
    }

    public static void initIntersectionRes(final Context context, final GLMapEngine.InitParam initParam) {
        String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String str = mapBaseStorage + "/VM3DRes/";
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        initParam.mIntersectionResPath = str;
        initParam.mIntersectionResPath = formatFileSeparator(str);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            loadAndSaveIntersectionRes("map_assets/VM3DRes", initParam.mIntersectionResPath, context);
            return;
        }
        try {
            ywa.a().b(new it() { // from class: com.autonavi.base.amap.mapcore.AeUtil.2
                @Override // com.amap.api.col.p0003l.it
                public final void runTask() {
                    AeUtil.loadAndSaveIntersectionRes("map_assets/VM3DRes", initParam.mIntersectionResPath, context);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GLMapEngine.InitParam initResource(final Context context) throws Throwable {
        final String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String str = mapBaseStorage + "/data_v6/";
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                ywa.a().b(new it() { // from class: com.autonavi.base.amap.mapcore.AeUtil.1
                    @Override // com.amap.api.col.p0003l.it
                    public final void runTask() {
                        AeUtil.loadEngineRes(mapBaseStorage, context);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            loadEngineRes(mapBaseStorage, context);
        }
        GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
        byte[] fileContentsFromAssets = FileUtil.readFileContentsFromAssets(context, "ae/GNaviConfig.xml");
        initParam.mRootPath = mapBaseStorage;
        if (fileContentsFromAssets != null) {
            try {
                String str2 = new String(fileContentsFromAssets, "utf-8");
                initParam.mConfigContent = str2;
                if (!str2.contains(ROOT_DATA_PATH_NAME)) {
                    throw new Exception("GNaviConfig.xml 和数据目录data_v6不匹配");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                xwa.o(context, "initConfig error:" + th.getMessage());
            }
        }
        String str3 = str + "/map/";
        initParam.mOfflineDataPath = str3;
        initParam.mP3dCrossPath = str;
        initParam.mOfflineDataPath = formatFileSeparator(str3);
        initParam.mRootPath = formatFileSeparator(initParam.mRootPath);
        initParam.mP3dCrossPath = formatFileSeparator(initParam.mP3dCrossPath);
        return initParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadAndSaveIntersectionRes(String str, String str2, Context context) {
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            String[] list = context.getAssets().list(str);
            if (list == null) {
                return;
            }
            for (String str3 : list) {
                readAssetsFileAndSave(str + WVNativeCallbackUtil.SEPERATER + str3, new File(str2, str3).getAbsolutePath(), context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[PHI: r10
      0x0043: PHI (r10v5 java.lang.String) = (r10v4 java.lang.String), (r10v8 java.lang.String) binds: [B:11:0x002a, B:15:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    public static void loadEngineRes(String str, Context context) {
        String assetsGlobalDbMd5;
        boolean z;
        File file = new File(str, AMAP_RESZIP_TARGET_DIR_NAME);
        boolean z2 = true;
        InputStream inputStreamOpen = null;
        if (!(file.exists() && file.isDirectory()) && file.mkdirs()) {
            assetsGlobalDbMd5 = getAssetsGlobalDbMd5(context);
            z = true;
        } else {
            assetsGlobalDbMd5 = null;
            z = false;
        }
        if (z) {
            z2 = z;
        } else {
            assetsGlobalDbMd5 = getAssetsGlobalDbMd5(context);
            String strB = pwa.b(context, AMAP_GLOBAL_SP_NAME, AMAP_GLOBAL_SP_ITEM_MD5, "");
            if (!TextUtils.isEmpty(strB) && strB.equals(assetsGlobalDbMd5)) {
                z2 = z;
            }
        }
        try {
            if (z2 ? false : checkEngineRes(file)) {
                global_db_path = file + "/global.db";
            } else {
                try {
                    try {
                        try {
                            inputStreamOpen = context.getAssets().open("ae/res.zip");
                            FileUtil.decompress(inputStreamOpen, file.getAbsolutePath());
                            global_db_path = file + "/global.db";
                            if (inputStreamOpen != null) {
                                inputStreamOpen.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            zwa.D(e);
                            xwa.o(context, "loadEngineRes error:" + e.getMessage());
                            if (inputStreamOpen != null) {
                                inputStreamOpen.close();
                            }
                            if (z2) {
                                pwa.c(context, AMAP_GLOBAL_SP_NAME, AMAP_GLOBAL_SP_ITEM_MD5, assetsGlobalDbMd5);
                            }
                        }
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                        zwa.D(e2);
                        xwa.o(context, "loadEngineRes error:" + e2.getMessage());
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        if (z2) {
                            pwa.c(context, AMAP_GLOBAL_SP_NAME, AMAP_GLOBAL_SP_ITEM_MD5, assetsGlobalDbMd5);
                        }
                    }
                } catch (Throwable th) {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        if (z2) {
            pwa.c(context, AMAP_GLOBAL_SP_NAME, AMAP_GLOBAL_SP_ITEM_MD5, assetsGlobalDbMd5);
        }
    }

    public static boolean loadLib(Context context) {
        try {
            if (!a.b) {
                System.loadLibrary(a.f26208a);
                a.b = true;
            }
            return true;
        } catch (Throwable th) {
            a7b.m(th, "AeUtil", "loadLib");
            zwa.D(th);
            bxa.l(axa.f40634a, "load so failed " + th.getMessage());
            return false;
        }
    }

    public static void readAssetsFileAndSave(String str, String str2, Context context) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStreamOpen.read(bArr, 0, 1024);
                        if (i > 0) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    inputStreamOpen.close();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    inputStream = inputStreamOpen;
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStreamOpen;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }
}
