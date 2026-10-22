package com.ipd.dsp.internal.n;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class y<Data> implements o<Uri, Data> {
    public static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", com.google.android.exoplayer2.upstream.c.h)));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c<Data> f38455a;

    public static final class a implements p<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f38456a;

        public a(ContentResolver contentResolver) {
            this.f38456a = contentResolver;
        }

        @Override // com.ipd.dsp.internal.n.p
        public o<Uri, AssetFileDescriptor> a(s sVar) {
            return new y(this);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }

        @Override // com.ipd.dsp.internal.n.y.c
        public com.ipd.dsp.internal.g.d<AssetFileDescriptor> a(Uri uri) {
            return new com.ipd.dsp.internal.g.a(this.f38456a, uri);
        }
    }

    public static class b implements p<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f38457a;

        public b(ContentResolver contentResolver) {
            this.f38457a = contentResolver;
        }

        @Override // com.ipd.dsp.internal.n.y.c
        public com.ipd.dsp.internal.g.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.ipd.dsp.internal.g.g(this.f38457a, uri);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Uri, ParcelFileDescriptor> a(s sVar) {
            return new y(this);
        }
    }

    public interface c<Data> {
        com.ipd.dsp.internal.g.d<Data> a(Uri uri);
    }

    public static class d implements p<Uri, InputStream>, c<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f38458a;

        public d(ContentResolver contentResolver) {
            this.f38458a = contentResolver;
        }

        @Override // com.ipd.dsp.internal.n.y.c
        public com.ipd.dsp.internal.g.d<InputStream> a(Uri uri) {
            return new com.ipd.dsp.internal.g.k(this.f38458a, uri);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Uri, InputStream> a(s sVar) {
            return new y(this);
        }
    }

    public y(c<Data> cVar) {
        this.f38455a = cVar;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<Data> a(@NonNull Uri uri, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return new o.a<>(new com.ipd.dsp.internal.c0.e(uri), this.f38455a.a(uri));
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Uri uri) {
        return b.contains(uri.getScheme());
    }
}
