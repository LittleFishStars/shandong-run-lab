package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ContentMetadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31140a = "custom_";
    public static final String b = "exo_redir";
    public static final String c = "exo_len";

    static long a(ContentMetadata contentMetadata) {
        return contentMetadata.get("exo_len", -1L);
    }

    @Nullable
    static Uri b(ContentMetadata contentMetadata) {
        String str = contentMetadata.get("exo_redir", (String) null);
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    boolean contains(String str);

    long get(String str, long j);

    @Nullable
    String get(String str, @Nullable String str2);

    @Nullable
    byte[] get(String str, @Nullable byte[] bArr);
}
