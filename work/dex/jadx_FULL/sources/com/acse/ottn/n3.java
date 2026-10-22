package com.acse.ottn;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.acse.ottn.util.HelpShopAppUtil;
import com.tencent.mmkv.MMKV;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n3 {
    public static n3 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MMKV f23102a;

    public n3(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(HelpShopAppUtil.getContext().getPackageName() + "_info", 0);
        if (this.f23102a == null) {
            this.f23102a = MMKV.mmkvWithID("ID", 2);
        }
        if (sharedPreferences.getAll().isEmpty()) {
            return;
        }
        this.f23102a.importFromSharedPreferences(sharedPreferences);
        sharedPreferences.edit().clear().apply();
    }

    public static synchronized n3 a() {
        if (HelpShopAppUtil.getContext() == null) {
            return null;
        }
        if (b == null) {
            b = new n3(HelpShopAppUtil.getContext());
        }
        return b;
    }

    public void b(String str, String str2) {
        this.f23102a.encode(str, str2);
    }

    public int c(String str) {
        return this.f23102a.decodeInt(str, 0);
    }

    public long d(String str) {
        return this.f23102a.decodeLong(str, 0L);
    }

    public String e(String str) {
        return this.f23102a.decodeString(str, "");
    }

    public String[] f(String str) {
        String strDecodeString = this.f23102a.decodeString(str, "");
        if (TextUtils.isEmpty(strDecodeString)) {
            return null;
        }
        return strDecodeString.substring(1, strDecodeString.length() - 1).split(",");
    }

    public float b(String str) {
        return this.f23102a.decodeFloat(str, 0.0f);
    }

    public String a(String str, String str2) {
        return this.f23102a.decodeString(str, str2);
    }

    public void a(String str, int i) {
        this.f23102a.encode(str, i);
    }

    public void a(String str, long j) {
        this.f23102a.encode(str, j);
    }

    public long a(String str, Long l) {
        return this.f23102a.decodeLong(str, l.longValue());
    }

    public void a(String str, Boolean bool) {
        this.f23102a.encode(str, bool.booleanValue());
    }

    public boolean a(String str) {
        return this.f23102a.decodeBool(str, false);
    }

    public void a(String str, Float f) {
        this.f23102a.encode(str, f.floatValue());
    }

    public void a(String str, String[] strArr) {
        this.f23102a.encode(str, Arrays.toString(strArr));
    }
}
