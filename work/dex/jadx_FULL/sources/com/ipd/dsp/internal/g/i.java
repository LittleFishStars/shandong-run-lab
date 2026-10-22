package com.ipd.dsp.internal.g;

import android.content.ContentResolver;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.ipd.dsp.Dsp;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class i<T> implements d<T> {
    public static final String i = "LocalUriFetcher";
    public final Uri f;
    public final ContentResolver g;
    public T h;

    public i(ContentResolver contentResolver, Uri uri) {
        this.g = contentResolver;
        this.f = uri;
    }

    public abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.ipd.dsp.internal.g.d
    public final void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull d.a<? super T> aVar) {
        try {
            T tA = a(this.f, this.g);
            this.h = tA;
            aVar.a(tA);
        } catch (FileNotFoundException e) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(i, "Failed to open Uri", e);
            }
            aVar.onLoadFailed(e);
        }
    }

    public abstract void a(T t) throws IOException;

    @Override // com.ipd.dsp.internal.g.d
    public void b() {
        T t = this.h;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
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
