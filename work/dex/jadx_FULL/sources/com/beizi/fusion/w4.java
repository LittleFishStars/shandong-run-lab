package com.beizi.fusion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class w4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f27897a;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f27898a;
        private final Context b;
        private final nb c;

        private a(Context context, Bitmap bitmap, nb nbVar) {
            this.b = context;
            this.f27898a = bitmap;
            this.c = nbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmapA = l8.a(this.b, this.f27898a, 20.0f);
            if (bitmapA != null) {
                this.c.a(bitmapA);
            } else {
                this.c.a();
            }
        }
    }

    public interface b extends le {
        void a(String str, Bitmap bitmap);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static w4 f27899a = new w4();
    }

    public static class d extends LinkedHashMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27900a;

        private d(int i) {
            super(i, 0.75f, true);
            this.f27900a = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > this.f27900a;
        }
    }

    private w4() {
        this.f27897a = new d(20);
        if (c.f27899a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public static w4 a() {
        return c.f27899a;
    }

    private String b(String str) {
        return qh.a(str);
    }

    public void a(Context context, String str, boolean z, nb nbVar) {
        if (TextUtils.isEmpty(str)) {
            if (nbVar != null) {
                nbVar.a();
                return;
            }
            return;
        }
        Bitmap bitmapA = a(b(str));
        if (bitmapA == null) {
            nf.b().a(context, str, z ? ph.TEMPORARY : ph.PERMANENT, new e(nbVar), null);
        } else if (nbVar != null) {
            nbVar.a(bitmapA);
        }
    }

    public static class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final nb f27901a;

        private e(nb nbVar) {
            this.f27901a = nbVar;
        }

        @Override // com.beizi.fusion.le
        public void a(String str, File file) {
            if (file.exists()) {
                try {
                    file.setLastModified(System.currentTimeMillis());
                } catch (IllegalArgumentException | SecurityException unused) {
                }
                try {
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), new BitmapFactory.Options());
                    if (bitmapDecodeFile != null) {
                        w4.a().a(str, bitmapDecodeFile);
                        this.f27901a.a(bitmapDecodeFile);
                        return;
                    }
                } catch (Exception e) {
                    om.a(e);
                }
            }
            this.f27901a.a();
        }

        @Override // com.beizi.fusion.le
        public void a(String str) {
            this.f27901a.a();
        }

        @Override // com.beizi.fusion.w4.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap != null) {
                w4.a().a(str, bitmap);
                this.f27901a.a(bitmap);
            } else {
                this.f27901a.a();
            }
        }
    }

    public Bitmap a(Context context, String str, int i) {
        Bitmap bitmapA;
        return (TextUtils.isEmpty(str) || (bitmapA = nf.b().a(context, str, true)) == null) ? BitmapFactory.decodeResource(context.getResources(), i) : bitmapA;
    }

    public void a(Context context, Bitmap bitmap, nb nbVar) {
        if (context != null) {
            ((fb) cn.a().b(context)).f(new a(context, bitmap, nbVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Bitmap bitmap) {
        synchronized (this.f27897a) {
            this.f27897a.put(str, bitmap);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Bitmap a(String str) {
        Bitmap bitmap;
        synchronized (this.f27897a) {
            bitmap = (Bitmap) this.f27897a.get(str);
        }
        return bitmap;
    }
}
