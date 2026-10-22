package com.ipd.dsp.internal.o;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.n.o;
import com.ipd.dsp.internal.n.p;
import com.ipd.dsp.internal.n.s;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d implements o<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f38470a;

    public static class a implements p<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38471a;

        public a(Context context) {
            this.f38471a = context;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Uri, InputStream> a(s sVar) {
            return new d(this.f38471a);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public d(Context context) {
        this.f38470a = context.getApplicationContext();
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<InputStream> a(@NonNull Uri uri, int i, int i2, @NonNull i iVar) {
        if (com.ipd.dsp.internal.h.b.a(i, i2)) {
            return new o.a<>(new com.ipd.dsp.internal.c0.e(uri), com.ipd.dsp.internal.h.c.a(this.f38470a, uri));
        }
        return null;
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Uri uri) {
        return com.ipd.dsp.internal.h.b.b(uri);
    }
}
