package com.ipd.dsp.internal.k;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d implements com.ipd.dsp.internal.k.a.InterfaceC0888a {
    public final long c;
    public final c d;

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f38373a;

        public a(String str) {
            this.f38373a = str;
        }

        @Override // com.ipd.dsp.internal.k.d.c
        public File a() {
            return new File(this.f38373a);
        }
    }

    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f38374a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.f38374a = str;
            this.b = str2;
        }

        @Override // com.ipd.dsp.internal.k.d.c
        public File a() {
            return new File(this.f38374a, this.b);
        }
    }

    public interface c {
        File a();
    }

    public d(String str, long j) {
        this(new a(str), j);
    }

    @Override // com.ipd.dsp.internal.k.a.InterfaceC0888a
    public com.ipd.dsp.internal.k.a build() {
        File fileA = this.d.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.isDirectory() || fileA.mkdirs()) {
            return e.a(fileA, this.c);
        }
        return null;
    }

    public d(String str, String str2, long j) {
        this(new b(str, str2), j);
    }

    public d(c cVar, long j) {
        this.c = j;
        this.d = cVar;
    }
}
