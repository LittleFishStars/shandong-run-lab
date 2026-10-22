package com.ipd.dsp.internal.n;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class t<Data> implements o<Integer, Data> {
    public static final String c = "ResourceLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<Uri, Data> f38443a;
    public final Resources b;

    public static final class a implements p<Integer, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f38444a;

        public a(Resources resources) {
            this.f38444a = resources;
        }

        @Override // com.ipd.dsp.internal.n.p
        public o<Integer, AssetFileDescriptor> a(s sVar) {
            return new t(this.f38444a, sVar.a(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    @Deprecated
    public static class b implements p<Integer, ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f38445a;

        public b(Resources resources) {
            this.f38445a = resources;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Integer, ParcelFileDescriptor> a(s sVar) {
            return new t(this.f38445a, sVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public static class c implements p<Integer, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f38446a;

        public c(Resources resources) {
            this.f38446a = resources;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Integer, InputStream> a(s sVar) {
            return new t(this.f38446a, sVar.a(Uri.class, InputStream.class));
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public static class d implements p<Integer, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f38447a;

        public d(Resources resources) {
            this.f38447a = resources;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Integer, Uri> a(s sVar) {
            return new t(this.f38447a, x.a());
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public t(Resources resources, o<Uri, Data> oVar) {
        this.b = resources;
        this.f38443a = oVar;
    }

    @Override // com.ipd.dsp.internal.n.o
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Integer num) {
        return true;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<Data> a(@NonNull Integer num, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        Uri uriA2 = a2(num);
        if (uriA2 == null) {
            return null;
        }
        return this.f38443a.a(uriA2, i, i2, iVar);
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public final Uri a2(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + '/' + this.b.getResourceTypeName(num.intValue()) + '/' + this.b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (!Dsp.isDebugLogEnable()) {
                return null;
            }
            com.ipd.dsp.internal.c2.k.e(c, "Received invalid resource id: " + num, e);
            return null;
        }
    }
}
