package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class f7b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f41617a = new HashMap<>();

    public static String a(Context context, r4b r4bVar, String str) {
        if (r4bVar == null || TextUtils.isEmpty(r4bVar.a())) {
            return null;
        }
        String str2 = f41617a.get(r4bVar.a() + str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = str + r4bVar.a();
        return (context == null || TextUtils.isEmpty(str3)) ? "" : s4b.g(i4b.e(s4b.z(context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).getString(str3, ""))));
    }

    public static void b(Context context, r4b r4bVar, String str, String str2) {
        if (r4bVar == null || TextUtils.isEmpty(r4bVar.a())) {
            return;
        }
        String str3 = str + r4bVar.a();
        f41617a.put(r4bVar.a() + str, str2);
        if (context == null || TextUtils.isEmpty(str3) || TextUtils.isEmpty("d7afbc6a38848a6801f6e449f3ec8e53") || TextUtils.isEmpty(str2)) {
            return;
        }
        String strF = s4b.F(i4b.c(s4b.p(str2)));
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).edit();
        editorEdit.putString(str3, strF);
        editorEdit.commit();
    }
}
