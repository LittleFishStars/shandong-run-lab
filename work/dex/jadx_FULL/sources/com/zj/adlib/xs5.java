package com.zj.adlib;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class xs5 implements CacheKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<CacheKey> f45894a;

    public xs5(List<CacheKey> list) {
        this.f45894a = (List) ax6.i(list);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean a(Uri uri) {
        for (int i = 0; i < this.f45894a.size(); i++) {
            if (this.f45894a.get(i).a(uri)) {
                return true;
            }
        }
        return false;
    }

    public List<CacheKey> b() {
        return this.f45894a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof xs5) {
            return this.f45894a.equals(((xs5) obj).f45894a);
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.f45894a.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return "MultiCacheKey:" + this.f45894a.toString();
    }
}
