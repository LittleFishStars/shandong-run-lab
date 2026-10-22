package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class Ticker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Ticker f31592a = new a();

    public class a extends Ticker {
        @Override // com.google.common.base.Ticker
        public long a() {
            return h.l();
        }
    }

    public static Ticker b() {
        return f31592a;
    }

    public abstract long a();
}
