package com.ipd.dsp.internal.n;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class u<DataT> implements o<Uri, DataT> {
    public static final int c = 0;
    public static final String d = "ResourceUriLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f38448a;
    public final o<Integer, DataT> b;

    public static final class a implements p<Uri, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38449a;

        public a(Context context) {
            this.f38449a = context;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Uri, AssetFileDescriptor> a(@NonNull s sVar) {
            return new u(this.f38449a, sVar.a(Integer.class, AssetFileDescriptor.class));
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public static final class b implements p<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38450a;

        public b(Context context) {
            this.f38450a = context;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Uri, InputStream> a(@NonNull s sVar) {
            return new u(this.f38450a, sVar.a(Integer.class, InputStream.class));
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public u(Context context, o<Integer, DataT> oVar) {
        this.f38448a = context.getApplicationContext();
        this.b = oVar;
    }

    public static p<Uri, InputStream> b(Context context) {
        return new b(context);
    }

    @Nullable
    public final o.a<DataT> c(@NonNull Uri uri, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        List<String> pathSegments = uri.getPathSegments();
        int identifier = this.f38448a.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.f38448a.getPackageName());
        if (identifier != 0) {
            return this.b.a(Integer.valueOf(identifier), i, i2, iVar);
        }
        if (!Dsp.isDebugLogEnable()) {
            return null;
        }
        com.ipd.dsp.internal.c2.k.f(d, "Failed to find resource id for: " + uri);
        return null;
    }

    @Nullable
    public final o.a<DataT> b(@NonNull Uri uri, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        try {
            int i3 = Integer.parseInt(uri.getPathSegments().get(0));
            if (i3 != 0) {
                return this.b.a(Integer.valueOf(i3), i, i2, iVar);
            }
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.f(d, "Failed to parse a valid non-0 resource id from: " + uri);
            }
            return null;
        } catch (NumberFormatException e) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(d, "Failed to parse resource id from: " + uri, e);
            }
            return null;
        }
    }

    public static p<Uri, AssetFileDescriptor> a(Context context) {
        return new a(context);
    }

    @Override // com.ipd.dsp.internal.n.o
    @Nullable
    public o.a<DataT> a(@NonNull Uri uri, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return b(uri, i, i2, iVar);
        }
        if (pathSegments.size() == 2) {
            return c(uri, i, i2, iVar);
        }
        if (!Dsp.isDebugLogEnable()) {
            return null;
        }
        com.ipd.dsp.internal.c2.k.f(d, "Failed to parse resource uri: " + uri);
        return null;
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Uri uri) {
        return com.google.android.exoplayer2.upstream.c.h.equals(uri.getScheme()) && this.f38448a.getPackageName().equals(uri.getAuthority());
    }
}
