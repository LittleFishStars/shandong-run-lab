package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.zj.adlib.f33;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends SendRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Event<?> f30422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Transformer<?, byte[]> f1924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TransportContext f1925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final f33 f1926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1927a;

    /* JADX INFO: renamed from: com.google.android.datatransport.runtime.b$b, reason: collision with other inner class name */
    public static final class C0667b extends SendRequest.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Event<?> f30423a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Transformer<?, byte[]> f1928a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TransportContext f1929a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public f33 f1930a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1931a;

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest a() {
            String str = "";
            if (this.f1929a == null) {
                str = " transportContext";
            }
            if (this.f1931a == null) {
                str = str + " transportName";
            }
            if (this.f30423a == null) {
                str = str + " event";
            }
            if (this.f1928a == null) {
                str = str + " transformer";
            }
            if (this.f1930a == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new b(this.f1929a, this.f1931a, this.f30423a, this.f1928a, this.f1930a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder b(f33 f33Var) {
            if (f33Var == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f1930a = f33Var;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder c(Event<?> event) {
            if (event == null) {
                throw new NullPointerException("Null event");
            }
            this.f30423a = event;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder e(Transformer<?, byte[]> transformer) {
            if (transformer == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f1928a = transformer;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder f(TransportContext transportContext) {
            if (transportContext == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f1929a = transportContext;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder g(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f1931a = str;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public f33 b() {
        return this.f1926a;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public Event<?> c() {
        return this.f30422a;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public Transformer<?, byte[]> e() {
        return this.f1924a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendRequest)) {
            return false;
        }
        SendRequest sendRequest = (SendRequest) obj;
        return this.f1925a.equals(sendRequest.f()) && this.f1927a.equals(sendRequest.g()) && this.f30422a.equals(sendRequest.c()) && this.f1924a.equals(sendRequest.e()) && this.f1926a.equals(sendRequest.b());
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public TransportContext f() {
        return this.f1925a;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public String g() {
        return this.f1927a;
    }

    public int hashCode() {
        return ((((((((this.f1925a.hashCode() ^ 1000003) * 1000003) ^ this.f1927a.hashCode()) * 1000003) ^ this.f30422a.hashCode()) * 1000003) ^ this.f1924a.hashCode()) * 1000003) ^ this.f1926a.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f1925a + ", transportName=" + this.f1927a + ", event=" + this.f30422a + ", transformer=" + this.f1924a + ", encoding=" + this.f1926a + "}";
    }

    public b(TransportContext transportContext, String str, Event<?> event, Transformer<?, byte[]> transformer, f33 f33Var) {
        this.f1925a = transportContext;
        this.f1927a = str;
        this.f30422a = event;
        this.f1924a = transformer;
        this.f1926a = f33Var;
    }
}
