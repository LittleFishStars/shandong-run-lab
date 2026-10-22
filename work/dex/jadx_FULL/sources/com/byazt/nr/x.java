package com.byazt.nr;

import android.content.Context;
import android.os.Environment;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 71})
public class x {

    /* JADX INFO: renamed from: com.byazt.nr.x$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 30})
    public static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file2.lastModified() - file.lastModified();
            if (jLastModified == 0) {
                return 0;
            }
            return jLastModified < 0 ? -1 : 1;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 62})
    public static final class c implements Comparator<File> {
        private c() {
        }

        private int c(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return c(file.lastModified(), file2.lastModified());
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static void a(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0043  */
    public static File c(Context context, boolean z, String str, String str2) {
        String strConcat;
        String str3;
        String strTt = tt(context);
        if (z) {
            strConcat = c(context) + c49.f40900a + str;
        } else {
            strConcat = WVNativeCallbackUtil.SEPERATER.concat(String.valueOf(str));
        }
        if (strTt != null) {
            String str4 = File.separator;
            if (strTt.endsWith(str4)) {
                str3 = "";
            } else {
                str3 = strTt + str4;
            }
        } else {
            str3 = "";
        }
        String str5 = str3 + strConcat;
        File file = new File(str5);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str5, str2);
    }

    private static void n(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long length = file.length();
        if (length == 0) {
            a(file);
            return;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            long j = length - 1;
            try {
                randomAccessFile.seek(j);
                byte b = randomAccessFile.readByte();
                randomAccessFile.seek(j);
                randomAccessFile.write(b);
                randomAccessFile.close();
            } catch (Throwable unused) {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
    }

    public static File tt(Context context, boolean z, String str, String str2) {
        String strVe = ve(context);
        if (z) {
            str = c(context) + c49.f40900a + str;
        }
        if (strVe != null) {
            String str3 = File.separator;
            if (!strVe.endsWith(str3)) {
                strVe = strVe + str3;
            }
        }
        String str4 = strVe + str;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str4, str2);
    }

    public static byte[] uj(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.isFile() && file.exists() && file.canRead() && file.length() > 0) {
            try {
                Long lValueOf = Long.valueOf(file.length());
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[lValueOf.intValue()];
                    if (fileInputStream.read(bArr) == lValueOf.longValue()) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return bArr;
                    }
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                    }
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused4) {
            }
        }
        return null;
    }

    private static String ve(Context context) {
        File fileTt;
        if (context == null || (fileTt = sp.tt(context, false, null)) == null) {
            return null;
        }
        return fileTt.getPath();
    }

    public static void ve(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            try {
                file.delete();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    ve(file2);
                } else {
                    try {
                        file2.delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        try {
            file.delete();
        } catch (Throwable unused3) {
        }
    }

    public static File tt(Context context, boolean z, String str) {
        String absolutePath = sp.tt(context, false, null).getAbsolutePath();
        if (z) {
            str = c(context) + c49.f40900a + str;
        }
        if (absolutePath != null) {
            String str2 = File.separator;
            if (!absolutePath.endsWith(str2)) {
                absolutePath = absolutePath + str2;
            }
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0038  */
    public static File c(Context context, boolean z, String str) {
        String str2;
        String strTt = tt(context);
        if (z) {
            str = c(context) + c49.f40900a + str;
        }
        if (strTt != null) {
            String str3 = File.separator;
            if (strTt.endsWith(str3)) {
                str2 = "";
            } else {
                str2 = strTt + str3;
            }
        } else {
            str2 = "";
        }
        File file = new File(str2 + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static String tt(Context context) {
        boolean z;
        File fileUj;
        if (context == null) {
            return null;
        }
        try {
            z = "mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            m.c(th);
        }
        if (z) {
            try {
                fileUj = sp.uj(context, false, null);
            } catch (Throwable unused) {
                fileUj = null;
            }
        } else {
            fileUj = null;
        }
        if (fileUj == null) {
            try {
                fileUj = sp.tt(context, false, null);
            } catch (Throwable unused2) {
            }
        }
        if (fileUj == null) {
            return null;
        }
        return fileUj.getPath();
    }

    public static List<File> c(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new c(null));
        return listAsList;
    }

    public static String c(Context context) {
        String strC = rl.c(context);
        return (TextUtils.isEmpty(strC) || !strC.contains(u15.f19942b)) ? strC : strC.replace(u15.f19942b, c49.f40900a);
    }

    public static void tt(File file) throws IOException {
        if (file.exists()) {
            m.uj("splashLoadAd", "update file modify time");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            n(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                m.tt(com.ipd.dsp.internal.w0.c.f38593a, "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }
}
