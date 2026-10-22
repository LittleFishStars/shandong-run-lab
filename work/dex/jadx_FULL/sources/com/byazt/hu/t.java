package com.byazt.hu;

import android.text.TextUtils;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 66})
public class t {

    @com.byazt.zqa.c(c = {0, 1, 1381, 125})
    public static class c {
        public static t c = new t();
    }

    public static t c() {
        return c.c;
    }

    public void tt(String str, String str2, String str3) {
        m.uj("[TTDownloaderLogger]", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : String.format("sdk:%s.%s:", str, str2)) + str3);
    }

    private t() {
    }

    public void c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String.format("sdk:%s.%s:", str, str2);
    }
}
