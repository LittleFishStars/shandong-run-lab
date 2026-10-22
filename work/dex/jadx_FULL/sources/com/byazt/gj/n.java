package com.byazt.gj;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface n {

    @com.byazt.zqa.c(c = {0, 1, 150, 151})
    public static final class c {

        @Nullable
        public final String c;
        public final boolean tt;
        public final long ve;

        public c(@Nullable String str, boolean z, long j) {
            this.c = str;
            this.tt = z;
            this.ve = j;
        }
    }

    @AnyThread
    void c(@NonNull c cVar);
}
