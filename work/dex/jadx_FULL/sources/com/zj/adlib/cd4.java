package com.zj.adlib;

import androidx.collection.ArrayMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u00020\b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003R$\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/zj/adlib/cd4;", "", "T", "Ljava/lang/Class;", "interClass", "a", "(Ljava/lang/Class;)Ljava/lang/Object;", "impl", "", "b", "(Ljava/lang/Class;Ljava/lang/Object;)V", "c", "Landroidx/collection/ArrayMap;", "Landroidx/collection/ArrayMap;", "mProxyMap", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class cd4 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final cd4 f15802a = new cd4();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final ArrayMap<Class<?>, Object> mProxyMap = new ArrayMap<>();

    @JvmStatic
    @Nullable
    public static final <T> T a(@NotNull Class<T> interClass) {
        Intrinsics.checkNotNullParameter(interClass, "interClass");
        ArrayMap<Class<?>, Object> arrayMap = mProxyMap;
        if (arrayMap.containsKey(interClass)) {
            return (T) arrayMap.get(interClass);
        }
        return null;
    }

    public final <T> void b(@NotNull Class<T> interClass, T impl) {
        Intrinsics.checkNotNullParameter(interClass, "interClass");
        mProxyMap.put(interClass, impl);
    }

    public final void c(@NotNull Class<?> interClass) {
        Intrinsics.checkNotNullParameter(interClass, "interClass");
        mProxyMap.remove(interClass);
    }
}
