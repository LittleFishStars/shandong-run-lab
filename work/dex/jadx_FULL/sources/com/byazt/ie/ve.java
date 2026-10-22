package com.byazt.ie;

import android.content.Context;
import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zz.Downloader;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1041, 54})
public class ve {
    public static void c() throws Throwable {
        List<DownloadInfo> listC = com.byazt.z.uj.sl().c(t.getContext());
        if (listC == null || listC.size() <= 0) {
            return;
        }
        for (int i = 0; i < listC.size(); i++) {
            DownloadInfo downloadInfo = listC.get(i);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long jLastModified = file.lastModified();
            long jC = ((long) com.byazt.k.c.c(downloadInfo.getId()).c("download_file_expire_hours", 0)) * 3600000;
            if (jC <= 0) {
                jC = 604800000;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - jLastModified >= jC) {
                c(file);
                Downloader.getInstance(t.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void tt() throws Throwable {
        List successedDownloadInfosWithMimeType = Downloader.getInstance(t.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i = 0; i < successedDownloadInfosWithMimeType.size(); i++) {
            DownloadInfo downloadInfo = (DownloadInfo) successedDownloadInfosWithMimeType.get(i);
            if (downloadInfo != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long jC = ((long) com.byazt.k.c.c(downloadInfo.getId()).c("download_complete_file_expire_hours", 0)) * 3600000;
                    if (jC <= 0) {
                        jC = 604800000;
                    }
                    boolean z = true;
                    if (jCurrentTimeMillis < jC && !u.a(t.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        c(file);
                    }
                }
            }
        }
    }

    public static void c(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            c(externalCacheDir.getPath());
        } catch (Exception e) {
            m.c(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void c(File file) throws Throwable {
        FileOutputStream fileOutputStream;
        Exception e;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write("1".getBytes());
                    fileOutputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    m.c(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            m.c(e3);
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                        m.c(e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            e = e5;
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
        file.delete();
    }

    private static void c(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str2 : list) {
                if (str2 != null) {
                    String str3 = File.separator;
                    String str4 = str.endsWith(str3) ? str + str2 : str + str3 + str2;
                    File file2 = new File(str4);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        c(str4);
                    }
                }
            }
            file.delete();
        }
    }
}
