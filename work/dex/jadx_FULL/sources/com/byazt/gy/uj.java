package com.byazt.gy;

import android.content.pm.PackageInfo;
import com.byazt.uq.sp;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2085, 15})
public class uj {
    public static n c(File file) {
        ZipFile zipFile;
        c cVar;
        PackageInfo packageArchiveInfo;
        int iTt;
        int i;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                sp.c((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    sp.c(zipFile2);
                    return null;
                }
                cVar = new c();
                try {
                    cVar.c(zipFile2.getInputStream(entry));
                    do {
                        iTt = cVar.tt();
                        if (iTt == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                cVar.c();
                            } catch (Throwable unused) {
                            }
                            sp.c(zipFile2);
                            return null;
                        }
                    } while (iTt != 2);
                    int iVe = cVar.ve();
                    String strC = null;
                    String strC2 = null;
                    for (int i2 = 0; i2 != iVe; i2++) {
                        if ("versionCode".equals(cVar.c(i2))) {
                            strC = c(cVar, i2);
                        } else if ("package".equals(cVar.c(i2))) {
                            strC2 = c(cVar, i2);
                        }
                    }
                    try {
                        i = Integer.parseInt(strC);
                    } catch (Throwable unused2) {
                        i = -1;
                    }
                    if (i == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(strC)));
                        try {
                            cVar.c();
                        } catch (Throwable unused3) {
                        }
                        sp.c(zipFile2);
                        return null;
                    }
                    n nVar = new n(strC2, i);
                    try {
                        cVar.c();
                    } catch (Throwable unused4) {
                    }
                    sp.c(zipFile2);
                    return nVar;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                    } catch (Throwable unused5) {
                        packageArchiveInfo = null;
                    }
                    try {
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            if (cVar != null) {
                                try {
                                    cVar.c();
                                } catch (Throwable unused6) {
                                }
                            }
                            sp.c(zipFile);
                            return null;
                        }
                        n nVar2 = new n(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (cVar != null) {
                            try {
                                cVar.c();
                            } catch (Throwable unused7) {
                            }
                        }
                        sp.c(zipFile);
                        return nVar2;
                    } catch (Throwable th3) {
                        if (cVar != null) {
                            try {
                                cVar.c();
                            } catch (Throwable unused8) {
                            }
                        }
                        sp.c(zipFile);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                cVar = null;
            }
        } catch (Throwable th5) {
            th = th5;
            zipFile = null;
            cVar = null;
        }
    }

    private static String c(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    private static String c(c cVar, int i) {
        int iTt = cVar.tt(i);
        int iVe = cVar.ve(i);
        if (iTt == 3) {
            return cVar.uj(i);
        }
        if (iTt == 2) {
            return String.format("?%s%08X", c(iVe), Integer.valueOf(iVe));
        }
        return (iTt < 16 || iTt > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(iVe), Integer.valueOf(iTt)) : String.valueOf(iVe);
    }
}
