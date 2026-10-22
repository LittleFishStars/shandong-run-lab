package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f33 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41584a;

    public f33(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f41584a = str;
    }

    public static f33 b(@NonNull String str) {
        return new f33(str);
    }

    public String a() {
        return this.f41584a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f33) {
            return this.f41584a.equals(((f33) obj).f41584a);
        }
        return false;
    }

    public int hashCode() {
        return this.f41584a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.f41584a + "\"}";
    }
}
