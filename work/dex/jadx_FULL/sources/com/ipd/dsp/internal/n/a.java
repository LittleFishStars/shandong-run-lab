package com.ipd.dsp.internal.n;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a<Data> implements o<Uri, Data> {
    public static final String c = "android_asset";
    public static final String d = "file:///android_asset/";
    public static final int e = 22;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f38412a;
    public final InterfaceC0901a<Data> b;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.n.a$a, reason: collision with other inner class name */
    public interface InterfaceC0901a<Data> {
        com.ipd.dsp.internal.g.d<Data> a(AssetManager assetManager, String str);
    }

    public static class b implements p<Uri, AssetFileDescriptor>, InterfaceC0901a<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f38413a;

        public b(AssetManager assetManager) {
            this.f38413a = assetManager;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Uri, AssetFileDescriptor> a(s sVar) {
            return new a(this.f38413a, this);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }

        @Override // com.ipd.dsp.internal.n.a.InterfaceC0901a
        public com.ipd.dsp.internal.g.d<AssetFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.ipd.dsp.internal.g.f(assetManager, str);
        }
    }

    public static class c implements p<Uri, InputStream>, InterfaceC0901a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f38414a;

        public c(AssetManager assetManager) {
            this.f38414a = assetManager;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Uri, InputStream> a(s sVar) {
            return new a(this.f38414a, this);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }

        @Override // com.ipd.dsp.internal.n.a.InterfaceC0901a
        public com.ipd.dsp.internal.g.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.ipd.dsp.internal.g.j(assetManager, str);
        }
    }

    public a(AssetManager assetManager, InterfaceC0901a<Data> interfaceC0901a) {
        this.f38412a = assetManager;
        this.b = interfaceC0901a;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<Data> a(@NonNull Uri uri, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return new o.a<>(new com.ipd.dsp.internal.c0.e(uri), this.b.a(this.f38412a, uri.toString().substring(e)));
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && c.equals(uri.getPathSegments().get(0));
    }
}
