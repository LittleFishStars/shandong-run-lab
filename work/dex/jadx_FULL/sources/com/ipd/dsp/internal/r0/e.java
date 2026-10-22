package com.ipd.dsp.internal.r0;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f0.f;
import com.ipd.dsp.internal.r0.e.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e<T extends a> implements d {
    public volatile T f;
    public final SparseArray<T> g = new SparseArray<>();
    public Boolean h;
    public final b<T> i;

    public interface a {
        void a(@NonNull com.ipd.dsp.internal.h0.b bVar);

        int getId();
    }

    public interface b<T extends a> {
        T a(int i);
    }

    public e(b<T> bVar) {
        this.i = bVar;
    }

    @NonNull
    public T a(@NonNull f fVar, @Nullable com.ipd.dsp.internal.h0.b bVar) {
        T t = (T) this.i.a(fVar.b());
        synchronized (this) {
            if (this.f == null) {
                this.f = t;
            } else {
                this.g.put(fVar.b(), t);
            }
            if (bVar != null) {
                t.a(bVar);
            }
        }
        return t;
    }

    @Nullable
    public T b(@NonNull f fVar, @Nullable com.ipd.dsp.internal.h0.b bVar) {
        T t;
        int iB = fVar.b();
        synchronized (this) {
            t = (this.f == null || this.f.getId() != iB) ? null : this.f;
        }
        if (t == null) {
            t = this.g.get(iB);
        }
        return (t == null && isAlwaysRecoverAssistModel()) ? (T) a(fVar, bVar) : t;
    }

    @NonNull
    public T c(@NonNull f fVar, @Nullable com.ipd.dsp.internal.h0.b bVar) {
        T t;
        int iB = fVar.b();
        synchronized (this) {
            if (this.f == null || this.f.getId() != iB) {
                t = this.g.get(iB);
                this.g.remove(iB);
            } else {
                t = this.f;
                this.f = null;
            }
        }
        if (t != null) {
            return t;
        }
        T t2 = (T) this.i.a(iB);
        if (bVar != null) {
            t2.a(bVar);
        }
        return t2;
    }

    @Override // com.ipd.dsp.internal.r0.d
    public boolean isAlwaysRecoverAssistModel() {
        Boolean bool = this.h;
        return bool != null && bool.booleanValue();
    }

    @Override // com.ipd.dsp.internal.r0.d
    public void setAlwaysRecoverAssistModel(boolean z) {
        this.h = Boolean.valueOf(z);
    }

    @Override // com.ipd.dsp.internal.r0.d
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        if (this.h == null) {
            this.h = Boolean.valueOf(z);
        }
    }
}
