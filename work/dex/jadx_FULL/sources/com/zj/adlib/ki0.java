package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ki0 extends BatchedLogRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<LogRequest> f42824a;

    public ki0(List<LogRequest> list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f42824a = list;
    }

    @Override // com.google.android.datatransport.cct.internal.BatchedLogRequest
    @NonNull
    @Encodable.Field(name = "logRequest")
    public List<LogRequest> c() {
        return this.f42824a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.f42824a.equals(((BatchedLogRequest) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f42824a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f42824a + "}";
    }
}
