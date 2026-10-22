package com.facebook.cache.common;

import android.net.Uri;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface CacheKey {
    boolean a(Uri uri);

    boolean equals(Object obj);

    int hashCode();

    String toString();
}
