package com.ipd.dsp.internal.g;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import com.ipd.dsp.Dsp;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class b<T> implements d<T> {
    public static final String i = "AssetPathFetcher";
    public final String f;
    public final AssetManager g;
    public T h;

    public b(AssetManager assetManager, String str) {
        this.g = assetManager;
        this.f = str;
    }

    public abstract T a(AssetManager assetManager, String str) throws IOException;

    @Override // com.ipd.dsp.internal.g.d
    public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull d.a<? super T> aVar) {
        try {
            T tA = a(this.g, this.f);
            this.h = tA;
            aVar.a(tA);
        } catch (IOException e) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(i, "Failed to load data from asset manager", e);
            }
            aVar.onLoadFailed(e);
        }
    }

    public abstract void a(T t) throws IOException;

    @Override // com.ipd.dsp.internal.g.d
    public void b() {
        T t = this.h;
        if (t == null) {
            return;
        }
        try {
            a(t);
        } catch (IOException unused) {
        }
    }

    @Override // com.ipd.dsp.internal.g.d
    @NonNull
    public com.ipd.dsp.internal.f.a c() {
        return com.ipd.dsp.internal.f.a.LOCAL;
    }

    @Override // com.ipd.dsp.internal.g.d
    public void cancel() {
    }
}
