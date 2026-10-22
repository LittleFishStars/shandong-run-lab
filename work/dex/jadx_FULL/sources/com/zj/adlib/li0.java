package com.zj.adlib;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.time.Clock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class li0 extends CreationContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f43071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f17953a;
    public final Clock b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f17954b;

    public li0(Context context, Clock clock, Clock clock2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f43071a = context;
        if (clock == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f17953a = clock;
        if (clock2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.b = clock2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f17954b = str;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Context c() {
        return this.f43071a;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    @NonNull
    public String d() {
        return this.f17954b;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        return this.f43071a.equals(creationContext.c()) && this.f17953a.equals(creationContext.f()) && this.b.equals(creationContext.e()) && this.f17954b.equals(creationContext.d());
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock f() {
        return this.f17953a;
    }

    public int hashCode() {
        return ((((((this.f43071a.hashCode() ^ 1000003) * 1000003) ^ this.f17953a.hashCode()) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.f17954b.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f43071a + ", wallClock=" + this.f17953a + ", monotonicClock=" + this.b + ", backendName=" + this.f17954b + "}";
    }
}
