package com.byazt.yxu;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1880, 20})
public class c {
    public static volatile c c;

    private c() {
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    private void tt(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent("com.bytedance.minigame.preload.action");
            uj ujVarC = tt.c().c(context);
            intent.putExtra("key_preload_info", ve.c(ujVarC.tt, ujVarC.c, str));
            intent.putExtra("key_preload_code", ujVarC.ve);
            context.sendBroadcast(intent);
            m.uj("onPreloadFinish", "tryPreload finish1");
        } catch (Exception unused) {
        }
    }

    public void c(Context context, String str) {
        if (!gt.tt().uj() || TextUtils.isEmpty(str)) {
            return;
        }
        c().tt(context, str);
    }
}
