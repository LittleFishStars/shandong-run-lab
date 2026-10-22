package com.byazt.bzd;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 158})
public class sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f28340a = 1;
    public static String c;
    public static String n;
    public static volatile com.byazt.fk.c tt;
    public static String uj;
    public static volatile com.byazt.fk.c ve;

    public static String a() {
        if (n == null) {
            n = c("image");
        }
        return n;
    }

    public static com.byazt.fk.c c(int i) {
        return i == 1 ? x() : sp();
    }

    private static String i() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        int iFv = gt.tt().fv();
        f28340a = iFv;
        String strTt = tt(iFv);
        c = strTt;
        return strTt;
    }

    public static String n() {
        if (uj == null) {
            uj = c("splash_image");
        }
        return uj;
    }

    private static com.byazt.fk.c sp() {
        if (tt == null) {
            synchronized (sl.class) {
                if (tt == null) {
                    com.byazt.tq.c cVar = new com.byazt.tq.c();
                    tt = cVar;
                    cVar.setRootDir(i());
                    tt.clearCache();
                }
            }
        }
        return tt;
    }

    private static String tt(int i) {
        File fileC;
        Context context = gt.getContext();
        if (i == 1) {
            m.c("CacheDirConstants", "使用内部存储");
            fileC = com.byazt.nr.x.tt(context, com.byazt.ue.tt.c(), "tt_ad");
        } else {
            m.c("CacheDirConstants", "使用外部存储");
            fileC = com.byazt.nr.x.c(context, com.byazt.ue.tt.c(), "tt_ad");
        }
        if (fileC.isFile()) {
            fileC.delete();
        }
        if (!fileC.exists()) {
            fileC.mkdirs();
        }
        return fileC.getAbsolutePath();
    }

    public static int uj() {
        return f28340a;
    }

    public static long[] ve() {
        return new long[]{10485760, 20971520, 31457280, 20971520, 10485760, 20971520, 31457280, 20971520};
    }

    private static com.byazt.fk.c x() {
        if (ve == null) {
            synchronized (sl.class) {
                if (ve == null) {
                    com.byazt.fk.c cVarCreateVideoCacheDir = com.byazt.btt.tt.c().createVideoCacheDir();
                    ve = cVarCreateVideoCacheDir;
                    cVarCreateVideoCacheDir.setRootDir(i());
                    ve.clearCache();
                }
            }
        }
        return ve;
    }

    public static String c() {
        return i() + File.separator + "video_brand";
    }

    public static String c(String str) {
        return i() + File.separator + str;
    }

    public static String[] tt() {
        String strTt = tt(1);
        com.byazt.fk.c cVarCreateVideoCacheDir = com.byazt.btt.tt.c().createVideoCacheDir();
        cVarCreateVideoCacheDir.setRootDir(strTt);
        String strTt2 = tt(0);
        com.byazt.fk.c cVarCreateVideoCacheDir2 = com.byazt.btt.tt.c().createVideoCacheDir();
        cVarCreateVideoCacheDir2.setRootDir(strTt2);
        return new String[]{cVarCreateVideoCacheDir.getBrandCacheDir(), cVarCreateVideoCacheDir.getSplashCacheDir(), cVarCreateVideoCacheDir.getRewardFullCacheDir(), cVarCreateVideoCacheDir.getOtherCacheDir(), cVarCreateVideoCacheDir2.getBrandCacheDir(), cVarCreateVideoCacheDir2.getSplashCacheDir(), cVarCreateVideoCacheDir2.getRewardFullCacheDir(), cVarCreateVideoCacheDir2.getOtherCacheDir()};
    }
}
