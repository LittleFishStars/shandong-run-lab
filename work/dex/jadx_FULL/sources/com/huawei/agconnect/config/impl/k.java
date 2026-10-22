package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.AesDecrypt;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AesDecrypt f37374a;

    public k(Context context, String str) {
        this.f37374a = !TextUtils.isEmpty(a(context, str)) ? new h(context, str) : new g(context, str);
    }

    private String a(Context context, String str) {
        String strA = l.a(context, str, "agc_plugin_", "crypto");
        if (strA == null) {
            return null;
        }
        try {
            return new String(Hex.decodeHexString(strA), "utf-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e) {
            Log.e("ReaderStrategy", "UnsupportedEncodingException" + e.getMessage());
            return null;
        }
    }

    public String a(String str, String str2) {
        return this.f37374a.decrypt(str, str2);
    }
}
