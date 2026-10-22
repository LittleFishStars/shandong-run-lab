package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c extends TransportContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Priority f30428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f1936a;

    public static final class b extends TransportContext.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Priority f30429a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1937a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f1938a;

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext a() {
            String str = "";
            if (this.f1937a == null) {
                str = " backendName";
            }
            if (this.f30429a == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new c(this.f1937a, this.f1938a, this.f30429a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f1937a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder c(@Nullable byte[] bArr) {
            this.f1938a = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder d(Priority priority) {
            if (priority == null) {
                throw new NullPointerException("Null priority");
            }
            this.f30429a = priority;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public String b() {
        return this.f1935a;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    @Nullable
    public byte[] c() {
        return this.f1936a;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Priority d() {
        return this.f30428a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.f1935a.equals(transportContext.b())) {
            if (Arrays.equals(this.f1936a, transportContext instanceof c ? ((c) transportContext).f1936a : transportContext.c()) && this.f30428a.equals(transportContext.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f1935a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1936a)) * 1000003) ^ this.f30428a.hashCode();
    }

    public c(String str, @Nullable byte[] bArr, Priority priority) {
        this.f1935a = str;
        this.f1936a = bArr;
        this.f30428a = priority;
    }
}
