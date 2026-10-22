package com.huachenjie.common.cache_webview.loader;

import com.zj.adlib.mg3;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/cache_webview/loader/DynamicCacheLoader;", "", "Ljava/io/File;", "file", "", "url", "b", "<init>", "()V", "a", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDynamicCacheLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DynamicCacheLoader.kt\ncom/huachenjie/common/cache_webview/loader/DynamicCacheLoader\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,44:1\n13579#2,2:45\n*S KotlinDebug\n*F\n+ 1 DynamicCacheLoader.kt\ncom/huachenjie/common/cache_webview/loader/DynamicCacheLoader\n*L\n23#1:45,2\n*E\n"})
public final class DynamicCacheLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final Lazy<DynamicCacheLoader> f8531a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<DynamicCacheLoader>() { // from class: com.huachenjie.common.cache_webview.loader.DynamicCacheLoader$Companion$instance$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DynamicCacheLoader m345invoke() {
            return new DynamicCacheLoader();
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.common.cache_webview.loader.DynamicCacheLoader$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/cache_webview/loader/DynamicCacheLoader$a;", "", "Lcom/huachenjie/common/cache_webview/loader/DynamicCacheLoader;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/huachenjie/common/cache_webview/loader/DynamicCacheLoader;", "instance", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DynamicCacheLoader a() {
            return (DynamicCacheLoader) DynamicCacheLoader.f8531a.getValue();
        }
    }

    @Nullable
    public final File b(@NotNull File file, @Nullable String url) {
        Intrinsics.checkNotNullParameter(file, "file");
        String strB = mg3.f43296a.b(url);
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        Intrinsics.checkNotNullExpressionValue(file2, "child");
                        File fileB = b(file2, url);
                        if (fileB != null) {
                            return fileB;
                        }
                    } else {
                        String name = file2.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "fileName");
                        if (StringsKt.endsWith$default(strB, name, false, 2, (Object) null)) {
                            return file2;
                        }
                    }
                }
            }
        } else {
            String name2 = file.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "fileName");
            if (StringsKt.endsWith$default(strB, name2, false, 2, (Object) null)) {
                return file;
            }
        }
        return null;
    }
}
