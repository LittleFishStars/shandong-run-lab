package com.zj.adlib;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class jg8 implements CacheKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42581a;

    public jg8(String str) {
        this.f42581a = (String) ax6.i(str);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean a(Uri uri) {
        return this.f42581a.contains(uri.toString());
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof jg8) {
            return this.f42581a.equals(((jg8) obj).f42581a);
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.f42581a.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return this.f42581a;
    }
}
