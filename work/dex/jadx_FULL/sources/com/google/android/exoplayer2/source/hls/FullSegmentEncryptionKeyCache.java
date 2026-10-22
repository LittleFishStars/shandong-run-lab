package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.zj.adlib.sb0;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class FullSegmentEncryptionKeyCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Uri, byte[]> f30910a;

    public FullSegmentEncryptionKeyCache(final int i) {
        this.f30910a = new LinkedHashMap<Uri, byte[]>(this, i + 1, 1.0f, false) { // from class: com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
                return size() > i;
            }
        };
    }

    public boolean a(Uri uri) {
        return this.f30910a.containsKey(sb0.g(uri));
    }

    @Nullable
    public byte[] b(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.f30910a.get(uri);
    }

    @Nullable
    public byte[] c(Uri uri, byte[] bArr) {
        return this.f30910a.put((Uri) sb0.g(uri), (byte[]) sb0.g(bArr));
    }

    @Nullable
    public byte[] d(Uri uri) {
        return this.f30910a.remove(sb0.g(uri));
    }
}
