package com.zj.adlib;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Immutable
public class jw0 implements CacheKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final CacheKey f17510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final sf7 f17511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final x64 f17512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f17513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f17514a;

    @Nullable
    public final String b;

    public jw0(String str, @Nullable sf7 sf7Var, boolean z, x64 x64Var, @Nullable CacheKey cacheKey, @Nullable String str2) {
        this.f17513a = (String) ax6.i(str);
        this.f17511a = sf7Var;
        this.f17514a = z;
        this.f17512a = x64Var;
        this.f17510a = cacheKey;
        this.b = str2;
        this.f42686a = yy3.l(Integer.valueOf(str.hashCode()), Integer.valueOf(sf7Var != null ? sf7Var.hashCode() : 0), Integer.valueOf((z ? Boolean.TRUE : Boolean.FALSE).hashCode()), x64Var, cacheKey, str2);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean a(Uri uri) {
        return c().contains(uri.toString());
    }

    @Nullable
    public String b() {
        return this.b;
    }

    public String c() {
        return this.f17513a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (!(obj instanceof jw0)) {
            return false;
        }
        jw0 jw0Var = (jw0) obj;
        return this.f42686a == jw0Var.f42686a && this.f17513a.equals(jw0Var.f17513a) && h76.a(this.f17511a, jw0Var.f17511a) && this.f17514a == jw0Var.f17514a && h76.a(this.f17512a, jw0Var.f17512a) && h76.a(this.f17510a, jw0Var.f17510a) && h76.a(this.b, jw0Var.b);
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.f42686a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.f17513a, this.f17511a, Boolean.toString(this.f17514a), this.f17512a, this.f17510a, this.b, Integer.valueOf(this.f42686a));
    }
}
