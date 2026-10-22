package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
@GwtCompatible
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Runnable f32438a = new a();

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static Runnable a() {
        return f32438a;
    }
}
