package com.ipd.dsp.internal.c1;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.e1.d;
import com.ipd.dsp.internal.f0.f;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {
    public static final String h = "ADH";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f38212a;
    public final com.ipd.dsp.internal.j1.b b;
    public boolean c = false;
    public boolean d = false;
    public InterfaceC0865b e;
    public f f;
    public com.ipd.dsp.internal.q0.c g;

    public class a extends com.ipd.dsp.internal.q0.c {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public a(String str, String str2) {
            this.f = str;
            this.g = str2;
        }

        @Override // com.ipd.dsp.internal.q0.c
        public void canceled(@NonNull f fVar) {
            b.this.c = false;
            if (Dsp.isDebugLogEnable()) {
                k.a(b.h, "canceled");
            }
        }

        @Override // com.ipd.dsp.internal.q0.c
        public void completed(@NonNull f fVar) {
            b.this.c = false;
            if (Dsp.isDebugLogEnable()) {
                k.a(b.h, "completed");
            }
            com.ipd.dsp.internal.h1.a.a(b.this.b, com.ipd.dsp.internal.h1.a.e.h);
            b.this.d = true;
            try {
                File file = new File(this.f, this.g);
                String str = this.f;
                String str2 = this.g;
                File file2 = new File(str, str2.substring(0, str2.length() - 4));
                if (!file.renameTo(file2)) {
                    throw new IOException("Error renaming file " + file + " to " + file2 + " for completion!");
                }
            } catch (Throwable th) {
                r.a(th);
            }
            if (b.this.e != null) {
                b.this.e.onSuccess();
            }
        }

        @Override // com.ipd.dsp.internal.r0.a.InterfaceC0914a
        public void connected(@NonNull f fVar, int i, long j, long j2) {
            if (Dsp.isDebugLogEnable()) {
                k.a(b.h, "connected");
            }
            if (b.this.e != null) {
                b.this.e.onStart();
            }
            com.ipd.dsp.internal.h1.a.a(b.this.b, com.ipd.dsp.internal.h1.a.e.g);
        }

        @Override // com.ipd.dsp.internal.q0.c
        public void error(@NonNull f fVar, @NonNull Exception exc) {
            b.this.c = false;
            if (Dsp.isDebugLogEnable()) {
                k.e(b.h, "error", exc);
            }
            if (b.this.e != null) {
                b.this.e.onFailure(Log.getStackTraceString(exc));
            }
        }

        @Override // com.ipd.dsp.internal.r0.a.InterfaceC0914a
        public void progress(@NonNull f fVar, long j, long j2) {
            if (Dsp.isDebugLogEnable()) {
                k.a(b.h, "progress[" + Math.max(0.0f, j / j2) + "]");
            }
            if (b.this.e != null) {
                b.this.e.a(j, j2);
            }
        }

        @Override // com.ipd.dsp.internal.r0.a.InterfaceC0914a
        public void retry(@NonNull f fVar, @NonNull com.ipd.dsp.internal.i0.b bVar) {
            if (Dsp.isDebugLogEnable()) {
                k.a(b.h, "retry:" + bVar);
            }
        }

        @Override // com.ipd.dsp.internal.q0.c
        public void started(@NonNull f fVar) {
            if (Dsp.isDebugLogEnable()) {
                k.a(b.h, "started");
            }
        }

        @Override // com.ipd.dsp.internal.q0.c
        public void warn(@NonNull f fVar) {
            if (Dsp.isDebugLogEnable()) {
                k.a(b.h, AliyunLogCommon.LogLevel.WARN);
            }
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.c1.b$b, reason: collision with other inner class name */
    public interface InterfaceC0865b {
        void a(long j, long j2);

        void onFailure(String str);

        void onStart();

        void onSuccess();
    }

    public b(d dVar, com.ipd.dsp.internal.j1.b bVar) {
        this.f38212a = dVar;
        this.b = bVar;
    }

    public boolean c() {
        return !this.c;
    }

    public void d() {
        if (c()) {
            c.a(this.f38212a);
            this.e = null;
        }
    }

    public void e() {
        f fVar = this.f;
        if (fVar != null) {
            try {
                fVar.f();
            } catch (Throwable th) {
                k.e(h, "", th);
            }
        }
    }

    public void f() {
        f fVar = this.f;
        if (fVar != null) {
            try {
                fVar.a((com.ipd.dsp.internal.f0.c) this.g);
            } catch (Throwable th) {
                k.e(h, "", th);
            }
        }
    }

    public void g() {
        Context context = Dsp.getContext();
        if (context != null) {
            try {
                Toast.makeText(context, com.ipd.dsp.internal.b1.b.a.l, 0).show();
            } catch (Throwable unused) {
            }
            this.c = true;
            String strA = a(context);
            String str = a() + ".tmp";
            this.f = new f.a(this.f38212a.r.k, strA, str).a(1).c(1000).a(false).a();
            a aVar = new a(strA, str);
            this.g = aVar;
            this.f.a((com.ipd.dsp.internal.f0.c) aVar);
        }
    }

    public void a(InterfaceC0865b interfaceC0865b) {
        this.e = interfaceC0865b;
    }

    public boolean b() {
        Context context = Dsp.getContext();
        if (!this.d && context != null) {
            try {
                this.d = new File(a(a(context), a())).exists();
            } catch (Throwable unused) {
            }
        }
        return this.d;
    }

    public final String a() {
        if (o.c(this.f38212a.r.l)) {
            return this.f38212a.r.l;
        }
        return this.f38212a.j + ".apk";
    }

    public void a(File file) throws IOException {
        final Context context = Dsp.getContext();
        if (context != null) {
            if (file == null) {
                file = new File(a(a(context), a()));
            }
            if (file.exists()) {
                if (Dsp.isDebugLogEnable()) {
                    k.a(h, "install");
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.dka
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(context, "开始安装", 0).show();
                    }
                });
                com.ipd.dsp.internal.d1.a.a(context, this.b, file);
                return;
            }
            this.d = false;
            throw new IOException("install error, file not exist.");
        }
        this.d = false;
        throw new IOException("install error, context == null or file not exist.");
    }

    public final String a(@NonNull Context context) {
        String str = context.getCacheDir() + "/ipd_dsp_dl/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return str;
    }

    public final String a(String str, String str2) {
        return str + WVNativeCallbackUtil.SEPERATER + str2;
    }
}
