package com.google.android.datatransport.runtime.backends;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends BackendResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BackendResponse.Status f1934a;

    public b(BackendResponse.Status status, long j) {
        if (status == null) {
            throw new NullPointerException("Null status");
        }
        this.f1934a = status;
        this.f30427a = j;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long b() {
        return this.f30427a;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status c() {
        return this.f1934a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        return this.f1934a.equals(backendResponse.c()) && this.f30427a == backendResponse.b();
    }

    public int hashCode() {
        int iHashCode = (this.f1934a.hashCode() ^ 1000003) * 1000003;
        long j = this.f30427a;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f1934a + ", nextRequestWaitMillis=" + this.f30427a + "}";
    }
}
