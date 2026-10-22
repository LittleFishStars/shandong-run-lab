package com.alibaba.analytics.core.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.analytics.a.s;
import com.alibaba.analytics.a.u;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences.Editor f23770a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f635a;
    private String at;
    private Context mContext;

    public e(Context context, String str, String str2, boolean z, boolean z2) {
        this.f635a = null;
        this.at = str2;
        this.mContext = context;
        if (context != null) {
            this.f635a = context.getSharedPreferences(str2, 0);
        }
    }

    private void A() {
        SharedPreferences sharedPreferences;
        if (this.f23770a != null || (sharedPreferences = this.f635a) == null) {
            return;
        }
        this.f23770a = sharedPreferences.edit();
    }

    public boolean commit() {
        Context context;
        SharedPreferences.Editor editor = this.f23770a;
        if (editor != null) {
            s.apply(editor);
        }
        if (this.f635a == null || (context = this.mContext) == null) {
            return true;
        }
        this.f635a = context.getSharedPreferences(this.at, 0);
        return true;
    }

    public String getString(String str) {
        SharedPreferences sharedPreferences = this.f635a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!u.isEmpty(string)) {
                return string;
            }
        }
        return "";
    }

    public void putString(String str, String str2) {
        A();
        SharedPreferences.Editor editor = this.f23770a;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }
}
