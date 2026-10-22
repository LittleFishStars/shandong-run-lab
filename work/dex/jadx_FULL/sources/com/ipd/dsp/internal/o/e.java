package com.ipd.dsp.internal.o;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.n.o;
import com.ipd.dsp.internal.n.p;
import com.ipd.dsp.internal.n.s;
import com.ipd.dsp.internal.q.m0;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e implements o<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f38472a;

    public static class a implements p<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38473a;

        public a(Context context) {
            this.f38473a = context;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Uri, InputStream> a(s sVar) {
            return new e(this.f38473a);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public e(Context context) {
        this.f38472a = context.getApplicationContext();
    }

    @Override // com.ipd.dsp.internal.n.o
    @Nullable
    public o.a<InputStream> a(@NonNull Uri uri, int i, int i2, @NonNull i iVar) {
        if (com.ipd.dsp.internal.h.b.a(i, i2) && a(iVar)) {
            return new o.a<>(new com.ipd.dsp.internal.c0.e(uri), com.ipd.dsp.internal.h.c.b(this.f38472a, uri));
        }
        return null;
    }

    public final boolean a(i iVar) {
        Long l = (Long) iVar.a(m0.g);
        return l != null && l.longValue() == -1;
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Uri uri) {
        return com.ipd.dsp.internal.h.b.d(uri);
    }
}
