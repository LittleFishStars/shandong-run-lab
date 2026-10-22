package com.ipd.dsp.internal.o;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.hjq.permissions.Permission;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.n.o;
import com.ipd.dsp.internal.n.p;
import com.ipd.dsp.internal.n.s;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@RequiresApi(29)
public final class f<DataT> implements o<Uri, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f38474a;
    public final o<File, DataT> b;
    public final o<Uri, DataT> c;
    public final Class<DataT> d;

    public static abstract class a<DataT> implements p<Uri, DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38475a;
        public final Class<DataT> b;

        public a(Context context, Class<DataT> cls) {
            this.f38475a = context;
            this.b = cls;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public final o<Uri, DataT> a(@NonNull s sVar) {
            return new f(this.f38475a, sVar.a(File.class, this.b), sVar.a(Uri.class, this.b), this.b);
        }

        @Override // com.ipd.dsp.internal.n.p
        public final void b() {
        }
    }

    @RequiresApi(29)
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    @RequiresApi(29)
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    public f(Context context, o<File, DataT> oVar, o<Uri, DataT> oVar2, Class<DataT> cls) {
        this.f38474a = context.getApplicationContext();
        this.b = oVar;
        this.c = oVar2;
        this.d = cls;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<DataT> a(@NonNull Uri uri, int i, int i2, @NonNull i iVar) {
        return new o.a<>(new com.ipd.dsp.internal.c0.e(uri), new d(this.f38474a, this.b, this.c, uri, i, i2, iVar, this.d));
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && com.ipd.dsp.internal.h.b.c(uri);
    }

    public static final class d<DataT> implements com.ipd.dsp.internal.g.d<DataT> {
        public static final String[] p = {"_data"};
        public final Context f;
        public final o<File, DataT> g;
        public final o<Uri, DataT> h;
        public final Uri i;
        public final int j;
        public final int k;
        public final i l;
        public final Class<DataT> m;
        public volatile boolean n;

        @Nullable
        public volatile com.ipd.dsp.internal.g.d<DataT> o;

        public d(Context context, o<File, DataT> oVar, o<Uri, DataT> oVar2, Uri uri, int i, int i2, i iVar, Class<DataT> cls) {
            this.f = context.getApplicationContext();
            this.g = oVar;
            this.h = oVar2;
            this.i = uri;
            this.j = i;
            this.k = i2;
            this.l = iVar;
            this.m = cls;
        }

        @Override // com.ipd.dsp.internal.g.d
        public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull com.ipd.dsp.internal.g.d.a<? super DataT> aVar) {
            try {
                com.ipd.dsp.internal.g.d<DataT> dVarE = e();
                if (dVarE == null) {
                    aVar.onLoadFailed(new IllegalArgumentException("Failed to build fetcher for: " + this.i));
                    return;
                }
                this.o = dVarE;
                if (this.n) {
                    cancel();
                } else {
                    dVarE.a(eVar, aVar);
                }
            } catch (FileNotFoundException e) {
                aVar.onLoadFailed(e);
            }
        }

        @Override // com.ipd.dsp.internal.g.d
        public void b() {
            com.ipd.dsp.internal.g.d<DataT> dVar = this.o;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // com.ipd.dsp.internal.g.d
        @NonNull
        public com.ipd.dsp.internal.f.a c() {
            return com.ipd.dsp.internal.f.a.LOCAL;
        }

        @Override // com.ipd.dsp.internal.g.d
        public void cancel() {
            this.n = true;
            com.ipd.dsp.internal.g.d<DataT> dVar = this.o;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Nullable
        public final o.a<DataT> d() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.g.a(a(this.i), this.j, this.k, this.l);
            }
            if (com.ipd.dsp.internal.h.b.a(this.i)) {
                return this.h.a(this.i, this.j, this.k, this.l);
            }
            return this.h.a(f() ? MediaStore.setRequireOriginal(this.i) : this.i, this.j, this.k, this.l);
        }

        @Nullable
        public final com.ipd.dsp.internal.g.d<DataT> e() throws FileNotFoundException {
            o.a<DataT> aVarD = d();
            if (aVarD != null) {
                return aVarD.c;
            }
            return null;
        }

        public final boolean f() {
            return this.f.checkSelfPermission(Permission.ACCESS_MEDIA_LOCATION) == 0;
        }

        @Override // com.ipd.dsp.internal.g.d
        @NonNull
        public Class<DataT> a() {
            return this.m;
        }

        @NonNull
        public final File a(Uri uri) throws FileNotFoundException {
            Cursor cursorQuery = this.f.getContentResolver().query(uri, p, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (!TextUtils.isEmpty(string)) {
                            File file = new File(string);
                            cursorQuery.close();
                            return file;
                        }
                        throw new FileNotFoundException("File path was empty in media store for: " + uri);
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            throw new FileNotFoundException("Failed to media store entry for: " + uri);
        }
    }
}
