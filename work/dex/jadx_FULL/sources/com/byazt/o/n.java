package com.byazt.o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME, 46})
public class n {
    public static PackageInfo c(@NonNull File file) {
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        ZipEntry nextEntry;
        int iTt;
        long j;
        c cVar = null;
        String strC = null;
        cVar = null;
        cVar = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(fileInputStream);
                while (true) {
                    nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream = null;
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                            zipInputStream = zipInputStream2;
                            break;
                        }
                        zipInputStream2.closeEntry();
                    } else {
                        try {
                            zipInputStream2.closeEntry();
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (nextEntry != null) {
                    try {
                        if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                            c cVar2 = new c();
                            try {
                                cVar2.c(zipInputStream);
                                do {
                                    iTt = cVar2.tt();
                                    if (iTt == 1) {
                                        throw new ve("已达到END_DOCUMENT");
                                    }
                                } while (iTt != 2);
                                int iN = cVar2.n();
                                String strC2 = null;
                                String strC3 = null;
                                for (int i = 0; i != iN; i++) {
                                    if ("versionName".equals(cVar2.c(i))) {
                                        strC3 = c(cVar2, i);
                                    } else if ("versionCode".equals(cVar2.c(i))) {
                                        strC = c(cVar2, i);
                                    } else if ("package".equals(cVar2.c(i))) {
                                        strC2 = c(cVar2, i);
                                    }
                                }
                                try {
                                    j = Long.parseLong(strC);
                                } catch (ve unused2) {
                                    j = -1;
                                }
                                if (j == -1) {
                                    throw new ve("versionCode获取失败: ".concat(String.valueOf(strC)));
                                }
                                PackageInfo packageInfo = new PackageInfo();
                                packageInfo.versionName = strC3;
                                packageInfo.versionCode = (int) j;
                                packageInfo.packageName = strC2;
                                try {
                                    zipInputStream2.closeEntry();
                                } catch (Throwable unused3) {
                                }
                                try {
                                    cVar2.c();
                                } catch (Throwable unused4) {
                                }
                                if (zipInputStream != null) {
                                    try {
                                        zipInputStream.close();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused6) {
                                }
                                return packageInfo;
                            } catch (Throwable th) {
                                th = th;
                                cVar = cVar2;
                                try {
                                    throw new ve("throwable: " + th.getMessage() + th.toString());
                                } catch (Throwable th2) {
                                    if (cVar != null) {
                                        try {
                                            cVar.c();
                                        } catch (Throwable unused7) {
                                        }
                                    }
                                    if (zipInputStream != null) {
                                        try {
                                            zipInputStream.close();
                                        } catch (Throwable unused8) {
                                        }
                                    }
                                    if (fileInputStream == null) {
                                        throw th2;
                                    }
                                    try {
                                        fileInputStream.close();
                                        throw th2;
                                    } catch (Throwable unused9) {
                                        throw th2;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                throw new ve("没有找到AndroidManifest.xml entry");
            } catch (Throwable th4) {
                th = th4;
                zipInputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            zipInputStream = null;
        }
    }

    private static String c(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    private static PackageInfo tt(@NonNull Context context, @NonNull File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            c("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            c("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    public static PackageInfo c(@NonNull Context context, @NonNull File file, int i) {
        com.byazt.w.c.c(268435456);
        return tt(context, file, i);
    }

    private static void c(@NonNull String str, @NonNull String str2) {
        if (com.byazt.zz.ve.sp() == null) {
            return;
        }
        try {
            new JSONObject().put("message", str2);
        } catch (JSONException unused) {
        }
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

    public static String c(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            c("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }
}
