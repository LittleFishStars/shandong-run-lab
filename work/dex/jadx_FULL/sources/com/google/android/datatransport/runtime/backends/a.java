package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends BackendRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<EventInternal> f30425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f1932a;

    public static final class b extends BackendRequest.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterable<EventInternal> f30426a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f1933a;

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest a() {
            String str = "";
            if (this.f30426a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f30426a, this.f1933a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest.Builder b(Iterable<EventInternal> iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f30426a = iterable;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest.Builder c(@Nullable byte[] bArr) {
            this.f1933a = bArr;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    public Iterable<EventInternal> c() {
        return this.f30425a;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    @Nullable
    public byte[] d() {
        return this.f1932a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.f30425a.equals(backendRequest.c())) {
            if (Arrays.equals(this.f1932a, backendRequest instanceof a ? ((a) backendRequest).f1932a : backendRequest.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f30425a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1932a);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f30425a + ", extras=" + Arrays.toString(this.f1932a) + "}";
    }

    public a(Iterable<EventInternal> iterable, @Nullable byte[] bArr) {
        this.f30425a = iterable;
        this.f1932a = bArr;
    }
}
