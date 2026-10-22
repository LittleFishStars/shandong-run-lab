package com.ipd.dsp.internal.components.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Trace;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.b.f;
import com.ipd.dsp.internal.components.glide.load.ImageHeaderParser;
import com.ipd.dsp.internal.components.glide.load.data.ParcelFileDescriptorRewinder;
import com.ipd.dsp.internal.d0.h;
import com.ipd.dsp.internal.f.k;
import com.ipd.dsp.internal.n.t;
import com.ipd.dsp.internal.n.u;
import com.ipd.dsp.internal.n.w;
import com.ipd.dsp.internal.n.x;
import com.ipd.dsp.internal.n.y;
import com.ipd.dsp.internal.n.z;
import com.ipd.dsp.internal.q.b0;
import com.ipd.dsp.internal.q.d0;
import com.ipd.dsp.internal.q.f0;
import com.ipd.dsp.internal.q.i0;
import com.ipd.dsp.internal.q.k0;
import com.ipd.dsp.internal.q.l;
import com.ipd.dsp.internal.q.m0;
import com.ipd.dsp.internal.q.p;
import com.ipd.dsp.internal.q.r;
import com.ipd.dsp.internal.q.v;
import com.ipd.dsp.internal.s.g;
import com.ipd.dsp.internal.u.j;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {

    public class a implements h.b<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f38247a;
        public final /* synthetic */ com.ipd.dsp.internal.components.glide.a b;
        public final /* synthetic */ List c;
        public final /* synthetic */ com.ipd.dsp.internal.x.a d;

        public a(com.ipd.dsp.internal.components.glide.a aVar, List list, com.ipd.dsp.internal.x.a aVar2) {
            this.b = aVar;
            this.c = list;
            this.d = aVar2;
        }

        @Override // com.ipd.dsp.internal.d0.h.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f get() {
            if (this.f38247a) {
                throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
            }
            Trace.beginSection("Glide registry");
            this.f38247a = true;
            try {
                return e.a(this.b, this.c, this.d);
            } finally {
                this.f38247a = false;
                Trace.endSection();
            }
        }
    }

    public static f a(com.ipd.dsp.internal.components.glide.a aVar, List<com.ipd.dsp.internal.x.c> list, @Nullable com.ipd.dsp.internal.x.a aVar2) {
        com.ipd.dsp.internal.j.e eVarE = aVar.e();
        com.ipd.dsp.internal.j.b bVarD = aVar.d();
        Context applicationContext = aVar.h().getApplicationContext();
        d dVarE = aVar.h().e();
        f fVar = new f();
        a(applicationContext, fVar, eVarE, bVarD, dVarE);
        a(applicationContext, aVar, fVar, list, aVar2);
        return fVar;
    }

    public static h.b<f> b(com.ipd.dsp.internal.components.glide.a aVar, List<com.ipd.dsp.internal.x.c> list, @Nullable com.ipd.dsp.internal.x.a aVar2) {
        return new a(aVar, list, aVar2);
    }

    public static void a(Context context, f fVar, com.ipd.dsp.internal.j.e eVar, com.ipd.dsp.internal.j.b bVar, d dVar) {
        k kVar;
        k i0Var;
        f fVar2;
        fVar.a((ImageHeaderParser) new p());
        int i = Build.VERSION.SDK_INT;
        if (i >= 27) {
            fVar.a((ImageHeaderParser) new v());
        }
        Resources resources = context.getResources();
        List<ImageHeaderParser> listA = fVar.a();
        com.ipd.dsp.internal.u.a aVar = new com.ipd.dsp.internal.u.a(context, listA, eVar, bVar);
        k<ParcelFileDescriptor, Bitmap> kVarC = m0.c(eVar);
        r rVar = new r(fVar.a(), resources.getDisplayMetrics(), eVar, bVar);
        if (i >= 28 && dVar.b(b.c.class)) {
            i0Var = new b0();
            kVar = new l();
        } else {
            kVar = new com.ipd.dsp.internal.q.k(rVar);
            i0Var = new i0(rVar, bVar);
        }
        if (i >= 28) {
            fVar.a("Animation", InputStream.class, Drawable.class, com.ipd.dsp.internal.s.a.b(listA, bVar));
            fVar.a("Animation", ByteBuffer.class, Drawable.class, com.ipd.dsp.internal.s.a.a(listA, bVar));
        }
        g gVar = new g(context);
        com.ipd.dsp.internal.q.e eVar2 = new com.ipd.dsp.internal.q.e(bVar);
        com.ipd.dsp.internal.v.a aVar2 = new com.ipd.dsp.internal.v.a();
        com.ipd.dsp.internal.v.d dVar2 = new com.ipd.dsp.internal.v.d();
        ContentResolver contentResolver = context.getContentResolver();
        fVar.a(ByteBuffer.class, new com.ipd.dsp.internal.n.c()).a(InputStream.class, new com.ipd.dsp.internal.n.v(bVar)).a("Bitmap", ByteBuffer.class, Bitmap.class, kVar).a("Bitmap", InputStream.class, Bitmap.class, i0Var);
        if (ParcelFileDescriptorRewinder.a()) {
            fVar.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new d0(rVar));
        }
        fVar.a("Bitmap", AssetFileDescriptor.class, Bitmap.class, m0.a(eVar));
        fVar.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, kVarC).a(Bitmap.class, Bitmap.class, x.a.a()).a("Bitmap", Bitmap.class, Bitmap.class, new k0()).a(Bitmap.class, (com.ipd.dsp.internal.f.l) eVar2).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.ipd.dsp.internal.q.a(resources, kVar)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.ipd.dsp.internal.q.a(resources, i0Var)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.ipd.dsp.internal.q.a(resources, kVarC)).a(BitmapDrawable.class, (com.ipd.dsp.internal.f.l) new com.ipd.dsp.internal.q.b(eVar, eVar2)).a("Animation", InputStream.class, com.ipd.dsp.internal.u.c.class, new j(listA, aVar, bVar)).a("Animation", ByteBuffer.class, com.ipd.dsp.internal.u.c.class, aVar).a(com.ipd.dsp.internal.u.c.class, (com.ipd.dsp.internal.f.l) new com.ipd.dsp.internal.u.d()).a(com.ipd.dsp.internal.e.a.class, com.ipd.dsp.internal.e.a.class, x.a.a()).a("Bitmap", com.ipd.dsp.internal.e.a.class, Bitmap.class, new com.ipd.dsp.internal.u.h(eVar)).a(Uri.class, Drawable.class, gVar).a(Uri.class, Bitmap.class, new f0(gVar, eVar)).a((com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<?>) new com.ipd.dsp.internal.r.a.C0913a()).a(File.class, ByteBuffer.class, new com.ipd.dsp.internal.n.d.b()).a(File.class, InputStream.class, new com.ipd.dsp.internal.n.g.e()).a(File.class, File.class, new com.ipd.dsp.internal.t.a()).a(File.class, ParcelFileDescriptor.class, new com.ipd.dsp.internal.n.g.b()).a(File.class, File.class, x.a.a()).a((com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<?>) new com.ipd.dsp.internal.components.glide.load.data.c.a(bVar));
        if (ParcelFileDescriptorRewinder.a()) {
            fVar2 = fVar;
            fVar2.a((com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<?>) new ParcelFileDescriptorRewinder.a());
        } else {
            fVar2 = fVar;
        }
        com.ipd.dsp.internal.n.p<Integer, InputStream> pVarC = com.ipd.dsp.internal.n.f.c(context);
        com.ipd.dsp.internal.n.p<Integer, AssetFileDescriptor> pVarA = com.ipd.dsp.internal.n.f.a(context);
        com.ipd.dsp.internal.n.p<Integer, Drawable> pVarB = com.ipd.dsp.internal.n.f.b(context);
        Class cls = Integer.TYPE;
        fVar2.a(cls, InputStream.class, pVarC).a(Integer.class, InputStream.class, pVarC).a(cls, AssetFileDescriptor.class, pVarA).a(Integer.class, AssetFileDescriptor.class, pVarA).a(cls, Drawable.class, pVarB).a(Integer.class, Drawable.class, pVarB).a(Uri.class, InputStream.class, u.b(context)).a(Uri.class, AssetFileDescriptor.class, u.a(context));
        t.d dVar3 = new t.d(resources);
        t.a aVar3 = new t.a(resources);
        t.c cVar = new t.c(resources);
        fVar2.a(Integer.class, Uri.class, dVar3).a(cls, Uri.class, dVar3).a(Integer.class, AssetFileDescriptor.class, aVar3).a(cls, AssetFileDescriptor.class, aVar3).a(Integer.class, InputStream.class, cVar).a(cls, InputStream.class, cVar);
        fVar2.a(String.class, InputStream.class, new com.ipd.dsp.internal.n.e.c()).a(Uri.class, InputStream.class, new com.ipd.dsp.internal.n.e.c()).a(String.class, InputStream.class, new w.c()).a(String.class, ParcelFileDescriptor.class, new w.b()).a(String.class, AssetFileDescriptor.class, new w.a()).a(Uri.class, InputStream.class, new com.ipd.dsp.internal.n.a.c(context.getAssets())).a(Uri.class, AssetFileDescriptor.class, new com.ipd.dsp.internal.n.a.b(context.getAssets())).a(Uri.class, InputStream.class, new com.ipd.dsp.internal.o.d.a(context)).a(Uri.class, InputStream.class, new com.ipd.dsp.internal.o.e.a(context));
        if (i >= 29) {
            fVar2.a(Uri.class, InputStream.class, new com.ipd.dsp.internal.o.f.c(context));
            fVar2.a(Uri.class, ParcelFileDescriptor.class, new com.ipd.dsp.internal.o.f.b(context));
        }
        fVar2.a(Uri.class, InputStream.class, new y.d(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new y.b(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new y.a(contentResolver)).a(Uri.class, InputStream.class, new z.a()).a(URL.class, InputStream.class, new com.ipd.dsp.internal.o.g.a()).a(Uri.class, File.class, new com.ipd.dsp.internal.n.l.a(context)).a(com.ipd.dsp.internal.n.h.class, InputStream.class, new com.ipd.dsp.internal.o.b.a()).a(byte[].class, ByteBuffer.class, new com.ipd.dsp.internal.n.b.a()).a(byte[].class, InputStream.class, new com.ipd.dsp.internal.n.b.d()).a(Uri.class, Uri.class, x.a.a()).a(Drawable.class, Drawable.class, x.a.a()).a(Drawable.class, Drawable.class, new com.ipd.dsp.internal.s.h()).a(Bitmap.class, BitmapDrawable.class, new com.ipd.dsp.internal.v.b(resources)).a(Bitmap.class, byte[].class, aVar2).a(Drawable.class, byte[].class, new com.ipd.dsp.internal.v.c(eVar, aVar2, dVar2)).a(com.ipd.dsp.internal.u.c.class, byte[].class, dVar2);
        k<ByteBuffer, Bitmap> kVarB = m0.b(eVar);
        fVar2.a(ByteBuffer.class, Bitmap.class, kVarB);
        fVar2.a(ByteBuffer.class, BitmapDrawable.class, new com.ipd.dsp.internal.q.a(resources, kVarB));
    }

    public static void a(Context context, com.ipd.dsp.internal.components.glide.a aVar, f fVar, List<com.ipd.dsp.internal.x.c> list, @Nullable com.ipd.dsp.internal.x.a aVar2) {
        for (com.ipd.dsp.internal.x.c cVar : list) {
            try {
                cVar.a(context, aVar, fVar);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + cVar.getClass().getName(), e);
            }
        }
        if (aVar2 != null) {
            aVar2.a(context, aVar, fVar);
        }
    }
}
