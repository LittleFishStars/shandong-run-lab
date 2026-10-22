package com.ipd.dsp.internal.n;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f<DataT> implements o<Integer, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f38423a;
    public final e<DataT> b;

    public interface e<DataT> {
        Class<DataT> a();

        DataT a(@Nullable Resources.Theme theme, Resources resources, int i);

        void a(DataT datat) throws IOException;
    }

    public f(Context context, e<DataT> eVar) {
        this.f38423a = context.getApplicationContext();
        this.b = eVar;
    }

    public static p<Integer, Drawable> b(Context context) {
        return new b(context);
    }

    public static p<Integer, InputStream> c(Context context) {
        return new c(context);
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Integer num) {
        return true;
    }

    public static final class a implements p<Integer, AssetFileDescriptor>, e<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38424a;

        public a(Context context) {
            this.f38424a = context;
        }

        @Override // com.ipd.dsp.internal.n.f.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AssetFileDescriptor a(@Nullable Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResourceFd(i);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }

        @Override // com.ipd.dsp.internal.n.f.e
        public void a(AssetFileDescriptor assetFileDescriptor) throws IOException {
            assetFileDescriptor.close();
        }

        @Override // com.ipd.dsp.internal.n.f.e
        public Class<AssetFileDescriptor> a() {
            return AssetFileDescriptor.class;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Integer, AssetFileDescriptor> a(@NonNull s sVar) {
            return new f(this.f38424a, this);
        }
    }

    public static final class b implements p<Integer, Drawable>, e<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38425a;

        public b(Context context) {
            this.f38425a = context;
        }

        @Override // com.ipd.dsp.internal.n.f.e
        public void a(Drawable drawable) throws IOException {
        }

        @Override // com.ipd.dsp.internal.n.f.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Drawable a(@Nullable Resources.Theme theme, Resources resources, int i) {
            return com.ipd.dsp.internal.s.c.a(this.f38425a, i, theme);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }

        @Override // com.ipd.dsp.internal.n.f.e
        public Class<Drawable> a() {
            return Drawable.class;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Integer, Drawable> a(@NonNull s sVar) {
            return new f(this.f38425a, this);
        }
    }

    public static final class c implements p<Integer, InputStream>, e<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38426a;

        public c(Context context) {
            this.f38426a = context;
        }

        @Override // com.ipd.dsp.internal.n.f.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public InputStream a(@Nullable Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResource(i);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Integer, InputStream> a(@NonNull s sVar) {
            return new f(this.f38426a, this);
        }

        @Override // com.ipd.dsp.internal.n.f.e
        public void a(InputStream inputStream) throws IOException {
            inputStream.close();
        }

        @Override // com.ipd.dsp.internal.n.f.e
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public static final class d<DataT> implements com.ipd.dsp.internal.g.d<DataT> {

        @Nullable
        public final Resources.Theme f;
        public final Resources g;
        public final e<DataT> h;
        public final int i;

        @Nullable
        public DataT j;

        public d(@Nullable Resources.Theme theme, Resources resources, e<DataT> eVar, int i) {
            this.f = theme;
            this.g = resources;
            this.h = eVar;
            this.i = i;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [DataT, java.lang.Object] */
        @Override // com.ipd.dsp.internal.g.d
        public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull com.ipd.dsp.internal.g.d.a<? super DataT> aVar) {
            try {
                DataT datatA = this.h.a(this.f, this.g, this.i);
                this.j = datatA;
                aVar.a(datatA);
            } catch (Resources.NotFoundException e) {
                aVar.onLoadFailed(e);
            }
        }

        @Override // com.ipd.dsp.internal.g.d
        public void b() {
            DataT datat = this.j;
            if (datat != null) {
                try {
                    this.h.a(datat);
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

        @Override // com.ipd.dsp.internal.g.d
        @NonNull
        public Class<DataT> a() {
            return this.h.a();
        }
    }

    public static p<Integer, AssetFileDescriptor> a(Context context) {
        return new a(context);
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<DataT> a(@NonNull Integer num, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        Resources resources;
        Resources.Theme theme = (Resources.Theme) iVar.a(com.ipd.dsp.internal.s.g.b);
        if (theme != null) {
            resources = theme.getResources();
        } else {
            resources = this.f38423a.getResources();
        }
        return new o.a<>(new com.ipd.dsp.internal.c0.e(num), new d(theme, resources, this.b, num.intValue()));
    }
}
