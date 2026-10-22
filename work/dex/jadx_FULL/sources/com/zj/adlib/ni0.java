package com.zj.adlib;

import com.google.android.datatransport.cct.internal.LogResponse;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ni0 extends LogResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f43528a;

    public ni0(long j) {
        this.f43528a = j;
    }

    @Override // com.google.android.datatransport.cct.internal.LogResponse
    public long c() {
        return this.f43528a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof LogResponse) && this.f43528a == ((LogResponse) obj).c();
    }

    public int hashCode() {
        long j = this.f43528a;
        return ((int) (j ^ (j >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f43528a + "}";
    }
}
