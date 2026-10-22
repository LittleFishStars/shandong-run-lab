package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@NullMarked
abstract class zzj implements Iterator {
    public int K = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public Object f31332a;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.K;
        if (i == 4) {
            throw new IllegalStateException();
        }
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            return true;
        }
        if (i2 != 2) {
            this.K = 4;
            this.f31332a = zza();
            if (this.K != 3) {
                this.K = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.K = 2;
        Object obj = this.f31332a;
        this.f31332a = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    public abstract Object zza();

    @CanIgnoreReturnValue
    @CheckForNull
    public final Object zzb() {
        this.K = 3;
        return null;
    }
}
