package com.beizi.fusion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class nf extends ta {
    private static final String f;
    private static final String g;

    public class a implements ta.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f27558a;

        private a(File file) {
            this.f27558a = file;
        }

        @Override // com.beizi.fusion.ta.b
        public void a(String str, InputStream inputStream) {
            synchronized (nf.this.e) {
                nf.this.e(str);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferQualityOverSpeed = false;
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            nf.this.a(str, bitmapDecodeStream);
            if (bitmapDecodeStream == null || this.f27558a == null) {
                return;
            }
            try {
                bitmapDecodeStream.compress(Bitmap.CompressFormat.WEBP, 100, new FileOutputStream(this.f27558a));
            } catch (FileNotFoundException unused) {
            }
        }

        @Override // com.beizi.fusion.ta.b
        public void a(String str) {
            synchronized (nf.this.e) {
                nf.this.e(str);
                nf.this.a(str, (File) null);
            }
        }
    }

    public static class b extends ta.c {
        public b(String str, File file, String str2) {
            super(str, file, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            q5 q5VarA = new q5().a(true).a(new a());
            q5VarA.a(this.f27782a);
            q5VarA.a().run();
        }

        public class a implements sa {
            public a() {
            }

            @Override // com.beizi.fusion.sa
            public void a(int i, InputStream inputStream) {
                b bVar = b.this;
                ta.b bVar2 = bVar.d;
                if (bVar2 != null) {
                    bVar2.a(bVar.c, inputStream);
                }
            }

            @Override // com.beizi.fusion.sa
            public void a(nc ncVar) {
                b bVar = b.this;
                ta.b bVar2 = bVar.d;
                if (bVar2 != null) {
                    bVar2.a(bVar.c);
                }
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static nf f27560a = new nf();
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Image_permanent");
        String str = File.separator;
        sb.append(str);
        f = sb.toString();
        g = "Image_temporary" + str;
    }

    private nf() {
        if (c.f27560a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public static nf b() {
        return c.f27560a;
    }

    @Override // com.beizi.fusion.ta
    public int a() {
        return 200;
    }

    public Bitmap a(Context context, String str, boolean z) {
        Bitmap bitmapDecodeFile;
        File fileB = b(context, str, z ? ph.TEMPORARY : ph.PERMANENT);
        if (fileB != null && fileB.exists() && (bitmapDecodeFile = BitmapFactory.decodeFile(fileB.getAbsolutePath())) != null) {
            return bitmapDecodeFile;
        }
        b().a(context, str, z ? ph.TEMPORARY : ph.PERMANENT);
        return null;
    }

    @Override // com.beizi.fusion.ta
    public File a(Context context, ph phVar) {
        if (context != null) {
            File file = phVar == ph.PERMANENT ? new File(context.getCacheDir(), f) : null;
            if (phVar == ph.TEMPORARY) {
                file = new File(context.getCacheDir(), g);
            }
            if (file != null) {
                try {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    return file;
                } catch (SecurityException unused) {
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.ta
    public String a(String str) {
        return qh.a(str);
    }

    @Override // com.beizi.fusion.ta
    public ta.c a(String str, File file, String str2) {
        b bVar = new b(str, file, str2);
        bVar.a(new a(file));
        return bVar;
    }
}
