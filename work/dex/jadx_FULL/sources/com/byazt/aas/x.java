package com.byazt.aas;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 71})
public class x {
    public static List<ResolveInfo> c(Intent intent, int i) {
        return com.byazt.omf.gt.getContext().getPackageManager().queryIntentActivities(intent, i);
    }
}
