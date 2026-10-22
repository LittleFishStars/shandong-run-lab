package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f31303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Object f5685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5686a = false;

    public zzc(BaseGmsClient baseGmsClient, Object obj) {
        this.f31303a = baseGmsClient;
        this.f5685a = obj;
    }

    public final void a() {
        Object obj;
        synchronized (this) {
            obj = this.f5685a;
            if (this.f5686a) {
                Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                zza(obj);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.f5686a = true;
        }
        c();
    }

    public final void b() {
        synchronized (this) {
            this.f5685a = null;
        }
    }

    public final void c() {
        b();
        synchronized (this.f31303a.f5669a) {
            this.f31303a.f5669a.remove(this);
        }
    }

    public abstract void zza(Object obj);

    public abstract void zzc();
}
