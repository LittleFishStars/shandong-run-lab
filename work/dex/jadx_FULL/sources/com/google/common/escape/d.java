package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<char[]> f32025a = new a();

    public class a extends ThreadLocal<char[]> {
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[1024];
        }
    }

    public static char[] a() {
        return f32025a.get();
    }
}
