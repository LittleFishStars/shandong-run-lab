package com.zj.adlib;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002¨\u0006\f"}, d2 = {"Lcom/zj/adlib/mg3;", "", "", "path", "", "isDeleteDir", "", "a", "url", "b", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUtils.kt\ncom/huachenjie/common/cache_webview/utils/FileUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,55:1\n13579#2,2:56\n*S KotlinDebug\n*F\n+ 1 FileUtils.kt\ncom/huachenjie/common/cache_webview/utils/FileUtils\n*L\n25#1:56,2\n*E\n"})
public final class mg3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final mg3 f43296a = new mg3();

    public final void a(@NotNull String path, boolean isDeleteDir) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (TextUtils.isEmpty(path)) {
            return;
        }
        File file = new File(path);
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        mg3 mg3Var = f43296a;
                        String absolutePath = file2.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                        mg3Var.a(absolutePath, isDeleteDir);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (isDeleteDir) {
                file.delete();
            }
        }
    }

    @NotNull
    public final String b(@Nullable String url) {
        String str = "";
        if (url == null || url.length() == 0) {
            return "";
        }
        try {
            String path = new URL(url).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "u.path");
            try {
                if (!StringsKt.startsWith$default(path, WVNativeCallbackUtil.SEPERATER, false, 2, (Object) null) || path.length() == 1) {
                    return path;
                }
                String strSubstring = path.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                return strSubstring;
            } catch (MalformedURLException unused) {
                str = path;
                return str;
            }
        } catch (MalformedURLException unused2) {
        }
    }
}
