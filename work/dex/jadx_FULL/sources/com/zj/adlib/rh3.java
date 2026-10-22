package com.zj.adlib;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\t\u001a\u00020\bH\u0002¨\u0006\f"}, d2 = {"Lcom/zj/adlib/rh3;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "b", "", "a", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFixFragmentHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FixFragmentHelper.kt\ncom/huachenjie/common/util/FixFragmentHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,26:1\n1855#2,2:27\n*S KotlinDebug\n*F\n+ 1 FixFragmentHelper.kt\ncom/huachenjie/common/util/FixFragmentHelper\n*L\n16#1:27,2\n*E\n"})
public final class rh3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final rh3 f44454a = new rh3();

    @JvmStatic
    public static final void b(@Nullable Context context, @Nullable Bundle bundle) {
        Set<String> setKeySet;
        if (bundle == null || context == null || !f44454a.a()) {
            return;
        }
        bundle.setClassLoader(context.getClass().getClassLoader());
        Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (bundle2 == null || (setKeySet = bundle2.keySet()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet()");
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            Object obj = bundle2.get((String) it.next());
            Bundle bundle3 = obj instanceof Bundle ? (Bundle) obj : null;
            if (bundle3 != null) {
                bundle3.setClassLoader(context.getClass().getClassLoader());
            }
        }
    }

    public final boolean a() {
        int i = Build.VERSION.SDK_INT;
        return i == 29 || i == 28;
    }
}
