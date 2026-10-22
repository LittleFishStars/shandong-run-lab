package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class jz4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Uri f42707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f17531a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f17532a;

    @Nullable
    public final String b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f17533a = null;

        @Nullable
        public String b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Uri f42708a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f17534a = false;

        @NonNull
        public jz4 a() {
            String str = this.f17533a;
            boolean z = true;
            if ((str == null || this.b != null || this.f42708a != null) && ((str != null || this.b == null || this.f42708a != null) && (str != null || this.b != null || this.f42708a == null))) {
                z = false;
            }
            yw6.b(z, "Set one of filePath, assetFilePath and URI.");
            return new jz4(this.f17533a, this.b, this.f42708a, this.f17534a, null);
        }

        @NonNull
        public a b(@NonNull String str) {
            yw6.i(str, "Model Source file path can not be empty");
            boolean z = false;
            if (this.b == null && this.f42708a == null && !this.f17534a) {
                z = true;
            }
            yw6.b(z, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.f17533a = str;
            return this;
        }

        @NonNull
        public a c(@NonNull String str) {
            yw6.i(str, "Manifest file path can not be empty");
            boolean z = false;
            if (this.b == null && this.f42708a == null && (this.f17533a == null || this.f17534a)) {
                z = true;
            }
            yw6.b(z, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.f17533a = str;
            this.f17534a = true;
            return this;
        }

        @NonNull
        public a d(@NonNull String str) {
            yw6.i(str, "Model Source file path can not be empty");
            boolean z = false;
            if (this.f17533a == null && this.f42708a == null && !this.f17534a) {
                z = true;
            }
            yw6.b(z, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.b = str;
            return this;
        }

        @NonNull
        public a e(@NonNull String str) {
            yw6.i(str, "Manifest file path can not be empty");
            boolean z = false;
            if (this.f17533a == null && this.f42708a == null && (this.b == null || this.f17534a)) {
                z = true;
            }
            yw6.b(z, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.b = str;
            this.f17534a = true;
            return this;
        }

        @NonNull
        public a f(@NonNull Uri uri) {
            boolean z = false;
            if (this.f17533a == null && this.b == null) {
                z = true;
            }
            yw6.b(z, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.f42708a = uri;
            return this;
        }
    }

    public /* synthetic */ jz4(String str, String str2, Uri uri, boolean z, hec hecVar) {
        this.f17531a = str;
        this.b = str2;
        this.f42707a = uri;
        this.f17532a = z;
    }

    @Nullable
    @KeepForSdk
    public String a() {
        return this.f17531a;
    }

    @Nullable
    @KeepForSdk
    public String b() {
        return this.b;
    }

    @Nullable
    @KeepForSdk
    public Uri c() {
        return this.f42707a;
    }

    @KeepForSdk
    public boolean d() {
        return this.f17532a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof jz4)) {
            return false;
        }
        jz4 jz4Var = (jz4) obj;
        return i76.b(this.f17531a, jz4Var.f17531a) && i76.b(this.b, jz4Var.b) && i76.b(this.f42707a, jz4Var.f42707a) && this.f17532a == jz4Var.f17532a;
    }

    public int hashCode() {
        return i76.c(this.f17531a, this.b, this.f42707a, Boolean.valueOf(this.f17532a));
    }

    @NonNull
    public String toString() {
        dvd dvdVarA = l7c.a(this);
        dvdVarA.a("absoluteFilePath", this.f17531a);
        dvdVarA.a("assetFilePath", this.b);
        dvdVarA.a("uri", this.f42707a);
        dvdVarA.b("isManifestFile", this.f17532a);
        return dvdVarA.toString();
    }
}
