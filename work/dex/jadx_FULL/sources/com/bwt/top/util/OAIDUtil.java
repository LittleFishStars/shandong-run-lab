package com.bwt.top.util;

import android.content.Context;
import android.text.TextUtils;
import com.bwt.top.cn_oaid.ddksa;
import com.zj.adlib.ahb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class OAIDUtil {
    private static String TAG = "OAIDUtil";
    private static String oaid = "";

    public class a implements ddksa {
        @Override // com.bwt.top.cn_oaid.ddksa
        public void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                String unused = OAIDUtil.oaid = str;
            }
            ALog.d(OAIDUtil.TAG, "onOAIDGetComplete " + str);
        }

        @Override // com.bwt.top.cn_oaid.ddksa
        public void b(Exception exc) {
            ALog.d(OAIDUtil.TAG, "onOAIDGetError " + exc.getMessage());
        }
    }

    public static String getOaid(Context context) {
        if (TextUtils.isEmpty(oaid)) {
            startGet(context);
        }
        return oaid;
    }

    private static void startGet(Context context) {
        ahb.c(context, new a());
    }
}
