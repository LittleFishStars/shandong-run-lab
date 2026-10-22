package com.zj.adlib;

import android.widget.TextView;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class io9 {
    public static void a(@Nullable TextView textView, long time) {
        b(textView, time, "");
    }

    public static void b(@Nullable TextView textView, long time, String splitStr) {
        if (textView == null) {
            return;
        }
        long j = time / 1000;
        long j2 = (int) (j / 60);
        long j3 = j % 60;
        textView.setText(String.format("%s%s:%s", splitStr, j2 > 9 ? String.valueOf(j2) : String.format("0%d", Long.valueOf(j2)), j3 > 9 ? String.valueOf(j3) : String.format("0%d", Long.valueOf(j3))));
    }
}
