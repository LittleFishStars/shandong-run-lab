package com.beizi.fusion;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class xp extends ta {
    private static final String f;
    private static final String g;

    public class a implements ta.b {
        public a() {
        }

        @Override // com.beizi.fusion.ta.b
        public void a(String str, File file) {
            synchronized (xp.this.e) {
                xp.this.e(str);
                xp.this.a(str, file);
            }
        }

        @Override // com.beizi.fusion.ta.b
        public void a(String str) {
            synchronized (xp.this.e) {
                xp.this.e(str);
                xp.this.a(str, (File) null);
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static xp f28043a = new xp();
    }

    public static class c extends ta.c {
        public c(String str, File file, String str2) {
            super(str, file, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            q5 q5VarA = new q5().a(true).a(new a());
            q5VarA.a(this.f27782a, this.b);
            q5VarA.a().run();
        }

        public class a extends b1 {
            public a() {
            }

            @Override // com.beizi.fusion.b1
            public void a(ra raVar) {
                c cVar = c.this;
                ta.b bVar = cVar.d;
                if (bVar != null) {
                    bVar.a(cVar.c, cVar.b);
                }
            }

            @Override // com.beizi.fusion.sa
            public void a(nc ncVar) {
                c cVar = c.this;
                ta.b bVar = cVar.d;
                if (bVar != null) {
                    bVar.a(cVar.c);
                }
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Video_permanent");
        String str = File.separator;
        sb.append(str);
        f = sb.toString();
        g = "Video_temporary" + str;
    }

    private xp() {
        if (b.f28043a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public static xp b() {
        return b.f28043a;
    }

    @Override // com.beizi.fusion.ta
    public int a() {
        return 300;
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
    public ta.c a(String str, File file, String str2) {
        c cVar = new c(str, file, str2);
        cVar.a(new a());
        return cVar;
    }
}
