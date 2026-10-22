package com.ipd.dsp.internal.h;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c implements com.ipd.dsp.internal.g.d<InputStream> {
    public static final String i = "MediaStoreThumbFetcher";
    public final Uri f;
    public final e g;
    public InputStream h;

    public static class a implements d {
        public static final String[] b = {"_data"};
        public static final String c = "kind = 1 AND image_id = ?";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f38312a;

        public a(ContentResolver contentResolver) {
            this.f38312a = contentResolver;
        }

        @Override // com.ipd.dsp.internal.h.d
        public Cursor a(Uri uri) {
            return this.f38312a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public static class b implements d {
        public static final String[] b = {"_data"};
        public static final String c = "kind = 1 AND video_id = ?";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f38313a;

        public b(ContentResolver contentResolver) {
            this.f38313a = contentResolver;
        }

        @Override // com.ipd.dsp.internal.h.d
        public Cursor a(Uri uri) {
            return this.f38313a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    public c(Uri uri, e eVar) {
        this.f = uri;
        this.g = eVar;
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    @Override // com.ipd.dsp.internal.g.d
    @NonNull
    public com.ipd.dsp.internal.f.a c() {
        return com.ipd.dsp.internal.f.a.LOCAL;
    }

    @Override // com.ipd.dsp.internal.g.d
    public void cancel() {
    }

    public final InputStream d() throws FileNotFoundException {
        InputStream inputStreamC = this.g.c(this.f);
        int iA = inputStreamC != null ? this.g.a(this.f) : -1;
        return iA != -1 ? new com.ipd.dsp.internal.g.e(inputStreamC, iA) : inputStreamC;
    }

    public static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.ipd.dsp.internal.components.glide.a.a(context).i().a(), dVar, com.ipd.dsp.internal.components.glide.a.a(context).d(), context.getContentResolver()));
    }

    @Override // com.ipd.dsp.internal.g.d
    public void b() {
        InputStream inputStream = this.h;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.ipd.dsp.internal.g.d
    public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull com.ipd.dsp.internal.g.d.a<? super InputStream> aVar) {
        try {
            InputStream inputStreamD = d();
            this.h = inputStreamD;
            aVar.a(inputStreamD);
        } catch (FileNotFoundException e) {
            if (Dsp.isDebugLogEnable()) {
                k.a(i, "Failed to find thumbnail file", e);
            }
            aVar.onLoadFailed(e);
        }
    }

    @Override // com.ipd.dsp.internal.g.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
