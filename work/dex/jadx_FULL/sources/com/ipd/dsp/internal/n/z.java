package com.ipd.dsp.internal.n;

import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class z<Data> implements o<Uri, Data> {
    public static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<h, Data> f38459a;

    public static class a implements p<Uri, InputStream> {
        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Uri, InputStream> a(s sVar) {
            return new z(sVar.a(h.class, InputStream.class));
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public z(o<h, Data> oVar) {
        this.f38459a = oVar;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<Data> a(@NonNull Uri uri, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return this.f38459a.a(new h(uri.toString()), i, i2, iVar);
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Uri uri) {
        return b.contains(uri.getScheme());
    }
}
