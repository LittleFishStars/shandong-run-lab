package com.kc.cw.ad;

import android.os.Bundle;
import com.kc.cw.ad.internal.x;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class AdRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38643a = com.kc.cw.ad.internal.b.a.f38864a;
    private final com.kc.cw.ad.internal.b.a.C1001a b;

    @Keep
    public static final class Builder {
        private final com.kc.cw.ad.internal.b.a.C1001a mImpl;

        public Builder() {
            com.kc.cw.ad.internal.b.a.C1001a c1001a = new com.kc.cw.ad.internal.b.a.C1001a();
            this.mImpl = c1001a;
            c1001a.b(AdRequest.f38643a);
        }

        public Builder addKeyword(String str) {
            this.mImpl.a(str);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends Object> cls, Bundle bundle) {
            this.mImpl.a(cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.mImpl.b(str);
            return this;
        }

        public AdRequest build() {
            return new AdRequest(this);
        }

        public Builder setBirthday(Date date) {
            this.mImpl.a(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            x.a(str, (Object) "Content URL must be non-null.");
            x.a(str, (Object) "Content URL must be non-empty.");
            x.a(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.mImpl.c(str);
            return this;
        }

        public Builder setGender(int i) {
            this.mImpl.a(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.mImpl.b(z);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.mImpl.d(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.mImpl.a(z);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.b = builder.mImpl;
    }

    public com.kc.cw.ad.internal.b.a.C1001a a() {
        return this.b;
    }
}
