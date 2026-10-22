package com.ipd.dsp.internal.n;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class w<Data> implements o<String, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<Uri, Data> f38452a;

    public static final class a implements p<String, AssetFileDescriptor> {
        @Override // com.ipd.dsp.internal.n.p
        public o<String, AssetFileDescriptor> a(@NonNull s sVar) {
            return new w(sVar.a(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public static class b implements p<String, ParcelFileDescriptor> {
        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<String, ParcelFileDescriptor> a(@NonNull s sVar) {
            return new w(sVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public static class c implements p<String, InputStream> {
        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<String, InputStream> a(@NonNull s sVar) {
            return new w(sVar.a(Uri.class, InputStream.class));
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public w(o<Uri, Data> oVar) {
        this.f38452a = oVar;
    }

    @Nullable
    public static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return c(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? c(str) : uri;
    }

    public static Uri c(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull String str) {
        return true;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<Data> a(@NonNull String str, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        Uri uriB = b(str);
        if (uriB == null || !this.f38452a.a(uriB)) {
            return null;
        }
        return this.f38452a.a(uriB, i, i2, iVar);
    }
}
