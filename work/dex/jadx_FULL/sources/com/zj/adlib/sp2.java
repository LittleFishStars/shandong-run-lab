package com.zj.adlib;

import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class sp2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f44741a;
    public final boolean b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f44742a = false;
        public boolean b = false;

        @NonNull
        public sp2 a() {
            return new sp2(this.f44742a, this.b, null);
        }

        @NonNull
        @RequiresApi(24)
        @TargetApi(24)
        public a b() {
            this.f44742a = true;
            return this;
        }

        @NonNull
        public a c() {
            this.b = true;
            return this;
        }
    }

    public /* synthetic */ sp2(boolean z, boolean z2, abc abcVar) {
        this.f44741a = z;
        this.b = z2;
    }

    public boolean a() {
        return this.f44741a;
    }

    public boolean b() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sp2)) {
            return false;
        }
        sp2 sp2Var = (sp2) obj;
        return this.f44741a == sp2Var.f44741a && this.b == sp2Var.b;
    }

    public int hashCode() {
        return i76.c(Boolean.valueOf(this.f44741a), Boolean.valueOf(this.b));
    }
}
