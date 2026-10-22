package com.zj.adlib;

import android.webkit.MimeTypeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/zj/adlib/zo5;", "", "", "url", "a", "b", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class zo5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final zo5 f46308a = new zo5();

    @NotNull
    public final String a(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(url);
        Intrinsics.checkNotNullExpressionValue(fileExtensionFromUrl, "getFileExtensionFromUrl(url)");
        return fileExtensionFromUrl;
    }

    @Nullable
    public final String b(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(a(url));
    }
}
