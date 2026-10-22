package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e extends LogRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ClientInfo f1904a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final QosTier f1905a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f1906a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1907a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<LogEvent> f1908a;
    public final long b;

    public static final class b extends LogRequest.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ClientInfo f30417a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public QosTier f1909a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Integer f1910a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Long f1911a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1912a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<LogEvent> f1913a;
        public Long b;

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest a() {
            String str = "";
            if (this.f1911a == null) {
                str = " requestTimeMs";
            }
            if (this.b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new e(this.f1911a.longValue(), this.b.longValue(), this.f30417a, this.f1910a, this.f1912a, this.f1913a, this.f1909a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder b(@Nullable ClientInfo clientInfo) {
            this.f30417a = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder c(@Nullable List<LogEvent> list) {
            this.f1913a = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder d(@Nullable Integer num) {
            this.f1910a = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder e(@Nullable String str) {
            this.f1912a = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder f(@Nullable QosTier qosTier) {
            this.f1909a = qosTier;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder g(long j) {
            this.f1911a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder h(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Nullable
    public ClientInfo b() {
        return this.f1904a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Nullable
    @Encodable.Field(name = "logEvent")
    public List<LogEvent> c() {
        return this.f1908a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Nullable
    public Integer d() {
        return this.f1906a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Nullable
    public String e() {
        return this.f1907a;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.f30416a == logRequest.g() && this.b == logRequest.h() && ((clientInfo = this.f1904a) != null ? clientInfo.equals(logRequest.b()) : logRequest.b() == null) && ((num = this.f1906a) != null ? num.equals(logRequest.d()) : logRequest.d() == null) && ((str = this.f1907a) != null ? str.equals(logRequest.e()) : logRequest.e() == null) && ((list = this.f1908a) != null ? list.equals(logRequest.c()) : logRequest.c() == null)) {
            QosTier qosTier = this.f1905a;
            if (qosTier == null) {
                if (logRequest.f() == null) {
                    return true;
                }
            } else if (qosTier.equals(logRequest.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Nullable
    public QosTier f() {
        return this.f1905a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long g() {
        return this.f30416a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long h() {
        return this.b;
    }

    public int hashCode() {
        long j = this.f30416a;
        long j2 = this.b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        ClientInfo clientInfo = this.f1904a;
        int iHashCode = (i ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f1906a;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f1907a;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<LogEvent> list = this.f1908a;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f1905a;
        return iHashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f30416a + ", requestUptimeMs=" + this.b + ", clientInfo=" + this.f1904a + ", logSource=" + this.f1906a + ", logSourceName=" + this.f1907a + ", logEvents=" + this.f1908a + ", qosTier=" + this.f1905a + "}";
    }

    public e(long j, long j2, @Nullable ClientInfo clientInfo, @Nullable Integer num, @Nullable String str, @Nullable List<LogEvent> list, @Nullable QosTier qosTier) {
        this.f30416a = j;
        this.b = j2;
        this.f1904a = clientInfo;
        this.f1906a = num;
        this.f1907a = str;
        this.f1908a = list;
        this.f1905a = qosTier;
    }
}
