package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ivd {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public String f17288a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f42454a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zzag f17287a = zzag.zzl();
    public zzag b = zzag.zzl();

    @CanIgnoreReturnValue
    public final ivd a(long j) {
        this.f42454a = j;
        return this;
    }

    @CanIgnoreReturnValue
    public final ivd b(List list) {
        yw6.l(list);
        this.b = zzag.zzk(list);
        return this;
    }

    @CanIgnoreReturnValue
    public final ivd c(List list) {
        yw6.l(list);
        this.f17287a = zzag.zzk(list);
        return this;
    }

    @CanIgnoreReturnValue
    public final ivd d(String str) {
        this.f17288a = str;
        return this;
    }

    public final x7c e() {
        if (this.f17288a == null) {
            throw new IllegalStateException("packageName must be defined");
        }
        if (this.f42454a < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        }
        if (this.f17287a.isEmpty() && this.b.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        return new x7c(this.f17288a, this.f42454a, this.f17287a, this.b, null);
    }
}
