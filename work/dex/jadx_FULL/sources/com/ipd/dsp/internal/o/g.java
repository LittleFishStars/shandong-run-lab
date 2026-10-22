package com.ipd.dsp.internal.o;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.n.h;
import com.ipd.dsp.internal.n.o;
import com.ipd.dsp.internal.n.p;
import com.ipd.dsp.internal.n.s;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g implements o<URL, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<h, InputStream> f38476a;

    public static class a implements p<URL, InputStream> {
        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<URL, InputStream> a(s sVar) {
            return new g(sVar.a(h.class, InputStream.class));
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public g(o<h, InputStream> oVar) {
        this.f38476a = oVar;
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull URL url) {
        return true;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<InputStream> a(@NonNull URL url, int i, int i2, @NonNull i iVar) {
        return this.f38476a.a(new h(url), i, i2, iVar);
    }
}
