package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
public abstract class BackendResponse {

    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static BackendResponse a() {
        return new b(Status.FATAL_ERROR, -1L);
    }

    public static BackendResponse d(long j) {
        return new b(Status.OK, j);
    }

    public static BackendResponse e() {
        return new b(Status.TRANSIENT_ERROR, -1L);
    }

    public abstract long b();

    public abstract Status c();
}
