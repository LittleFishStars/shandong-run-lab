package com.hihonor.push.sdk;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32679a;
    public final int b;

    public w(String str) {
        this.f32679a = str;
        this.b = a(str);
    }

    public static w a(String str) {
        return new w(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w.class != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f32679a, ((w) obj).f32679a);
    }

    public final int hashCode() {
        return this.b;
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
