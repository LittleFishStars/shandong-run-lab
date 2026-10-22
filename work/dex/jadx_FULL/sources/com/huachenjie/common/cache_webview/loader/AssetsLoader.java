package com.huachenjie.common.cache_webview.loader;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.zj.adlib.mg3;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/common/cache_webview/loader/AssetsLoader;", "", "Landroid/content/Context;", "context", "", "dir", "url", "Ljava/io/InputStream;", "c", "path", "b", "<init>", "()V", "a", "common_release"}, k = 1, mv = {1, 8, 0})
public final class AssetsLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final Lazy<AssetsLoader> f8530a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<AssetsLoader>() { // from class: com.huachenjie.common.cache_webview.loader.AssetsLoader$Companion$instance$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AssetsLoader m344invoke() {
            return new AssetsLoader();
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.common.cache_webview.loader.AssetsLoader$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/cache_webview/loader/AssetsLoader$a;", "", "Lcom/huachenjie/common/cache_webview/loader/AssetsLoader;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/huachenjie/common/cache_webview/loader/AssetsLoader;", "instance", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AssetsLoader a() {
            return (AssetsLoader) AssetsLoader.f8530a.getValue();
        }
    }

    public final InputStream b(Context context, String path) {
        try {
            AssetManager assets = context.getAssets();
            if (assets != null) {
                return assets.open(path);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    @Nullable
    public final InputStream c(@NotNull Context context, @NotNull String dir, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(url, "url");
        String strB = mg3.f43296a.b(url);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        if (TextUtils.isEmpty(dir)) {
            return b(context, strB);
        }
        return b(context, dir + File.separator + strB);
    }
}
