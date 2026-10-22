package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c extends ClientInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AndroidClientInfo f30412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ClientInfo.ClientType f1894a;

    public static final class b extends ClientInfo.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AndroidClientInfo f30413a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ClientInfo.ClientType f1895a;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo a() {
            return new c(this.f1895a, this.f30413a);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder b(@Nullable AndroidClientInfo androidClientInfo) {
            this.f30413a = androidClientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder c(@Nullable ClientInfo.ClientType clientType) {
            this.f1895a = clientType;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public AndroidClientInfo b() {
        return this.f30412a;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public ClientInfo.ClientType c() {
        return this.f1894a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f1894a;
        if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
            AndroidClientInfo androidClientInfo = this.f30412a;
            if (androidClientInfo == null) {
                if (clientInfo.b() == null) {
                    return true;
                }
            } else if (androidClientInfo.equals(clientInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.f1894a;
        int iHashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.f30412a;
        return iHashCode ^ (androidClientInfo != null ? androidClientInfo.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f1894a + ", androidClientInfo=" + this.f30412a + "}";
    }

    public c(@Nullable ClientInfo.ClientType clientType, @Nullable AndroidClientInfo androidClientInfo) {
        this.f1894a = clientType;
        this.f30412a = androidClientInfo;
    }
}
