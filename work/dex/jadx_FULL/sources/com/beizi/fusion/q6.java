package com.beizi.fusion;

import android.os.Build;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class q6 {
    public String a() {
        try {
            int i = Build.VERSION.SDK_INT;
            StructStat structStatStat = Os.stat("/data/data");
            if (structStatStat == null) {
                return "";
            }
            if (i < 27) {
                return structStatStat.st_atime + ".0";
            }
            StructTimespec structTimespec = structStatStat.st_atim;
            return structTimespec.tv_sec + Consts.DOT + structTimespec.tv_nsec;
        } catch (Throwable unused) {
            return "";
        }
    }
}
