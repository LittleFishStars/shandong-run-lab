package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d extends LogEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NetworkConnectionInfo f1896a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f1897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1898a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f1899a;
    public final long b;
    public final long c;

    public static final class b extends LogEvent.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NetworkConnectionInfo f30415a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Integer f1900a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Long f1901a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1902a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f1903a;
        public Long b;
        public Long c;

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent a() {
            String str = "";
            if (this.f1901a == null) {
                str = " eventTimeMs";
            }
            if (this.b == null) {
                str = str + " eventUptimeMs";
            }
            if (this.c == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new d(this.f1901a.longValue(), this.f1900a, this.b.longValue(), this.f1903a, this.f1902a, this.c.longValue(), this.f30415a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder b(@Nullable Integer num) {
            this.f1900a = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder c(long j) {
            this.f1901a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder d(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder e(@Nullable NetworkConnectionInfo networkConnectionInfo) {
            this.f30415a = networkConnectionInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder f(@Nullable byte[] bArr) {
            this.f1903a = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder g(@Nullable String str) {
            this.f1902a = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder h(long j) {
            this.c = Long.valueOf(j);
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public Integer b() {
        return this.f1897a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long c() {
        return this.f30414a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long d() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public NetworkConnectionInfo e() {
        return this.f1896a;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        if (this.f30414a == logEvent.c() && ((num = this.f1897a) != null ? num.equals(logEvent.b()) : logEvent.b() == null) && this.b == logEvent.d()) {
            if (Arrays.equals(this.f1899a, logEvent instanceof d ? ((d) logEvent).f1899a : logEvent.f()) && ((str = this.f1898a) != null ? str.equals(logEvent.g()) : logEvent.g() == null) && this.c == logEvent.h()) {
                NetworkConnectionInfo networkConnectionInfo = this.f1896a;
                if (networkConnectionInfo == null) {
                    if (logEvent.e() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo.equals(logEvent.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public byte[] f() {
        return this.f1899a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public String g() {
        return this.f1898a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long h() {
        return this.c;
    }

    public int hashCode() {
        long j = this.f30414a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f1897a;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j2 = this.b;
        int iHashCode2 = (((((i ^ iHashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f1899a)) * 1000003;
        String str = this.f1898a;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.c;
        int i2 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f1896a;
        return i2 ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f30414a + ", eventCode=" + this.f1897a + ", eventUptimeMs=" + this.b + ", sourceExtension=" + Arrays.toString(this.f1899a) + ", sourceExtensionJsonProto3=" + this.f1898a + ", timezoneOffsetSeconds=" + this.c + ", networkConnectionInfo=" + this.f1896a + "}";
    }

    public d(long j, @Nullable Integer num, long j2, @Nullable byte[] bArr, @Nullable String str, long j3, @Nullable NetworkConnectionInfo networkConnectionInfo) {
        this.f30414a = j;
        this.f1897a = num;
        this.b = j2;
        this.f1899a = bArr;
        this.f1898a = str;
        this.c = j3;
        this.f1896a = networkConnectionInfo;
    }
}
