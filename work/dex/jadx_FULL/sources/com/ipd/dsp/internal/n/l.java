package com.ipd.dsp.internal.n;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class l implements o<Uri, File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f38432a;

    public static final class a implements p<Uri, File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38433a;

        public a(Context context) {
            this.f38433a = context;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Uri, File> a(s sVar) {
            return new l(this.f38433a);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public l(Context context) {
        this.f38432a = context;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<File> a(@NonNull Uri uri, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return new o.a<>(new com.ipd.dsp.internal.c0.e(uri), new b(this.f38432a, uri));
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Uri uri) {
        return com.ipd.dsp.internal.h.b.c(uri);
    }

    public static class b implements com.ipd.dsp.internal.g.d<File> {
        public static final String[] h = {"_data"};
        public final Context f;
        public final Uri g;

        public b(Context context, Uri uri) {
            this.f = context;
            this.g = uri;
        }

        @Override // com.ipd.dsp.internal.g.d
        public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull com.ipd.dsp.internal.g.d.a<? super File> aVar) {
            Cursor cursorQuery = this.f.getContentResolver().query(this.g, h, null, null, null);
            String string = null;
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.a(new File(string));
                return;
            }
            aVar.onLoadFailed(new FileNotFoundException("Failed to find file path for: " + this.g));
        }

        @Override // com.ipd.dsp.internal.g.d
        public void b() {
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
        public Class<File> a() {
            return File.class;
        }
    }
}
