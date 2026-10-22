package com.kwad.library.solder.lib.ext;

import android.os.Build;
import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {
    private final int aEM;
    private final String aFa;
    private final String aFb;
    private final String aFc;
    private final String aFd;
    private final String aFe;
    private final String aFf;
    private final String aFg;
    private final boolean aFh;
    private final boolean aFi;
    private final boolean aFj;
    private ExecutorService aFk;
    private String aFl;
    private byte[] aFm;
    private boolean aFn;
    private int aFo;

    public static class a {
        private static final String aFp;
        private String aFg;
        private boolean aFj;
        private ExecutorService aFk;
        private String aFl;
        private byte[] aFm;
        private boolean aFn;
        private int aFq;
        private int aEM = 3;
        private String aFa = "sodler";
        private String aFb = "code-cache";
        private String aFc = "lib";
        private String aFd = "temp";
        private String aFf = aFp;
        private String aFe = ".tmp";
        private boolean aFi = false;
        private boolean aFh = false;

        static {
            aFp = Ev() ? "base-1_apk" : "base-1.apk";
        }

        private static boolean Ev() {
            int i = Build.VERSION.SDK_INT;
            return i == 30 || i == 31 || i == 32;
        }

        public final c Ew() {
            return new c(this.aFh, this.aFi, this.aFg, this.aFa, this.aFb, this.aFc, this.aFd, this.aFe, this.aFf, this.aEM, this.aFl, this.aFm, this.aFn, this.aFj, this.aFk, this.aFq, (byte) 0);
        }

        public final a a(ExecutorService executorService) {
            this.aFk = executorService;
            return this;
        }

        public final a bA(boolean z) {
            this.aFj = z;
            return this;
        }

        public final a bz(boolean z) {
            this.aFn = false;
            return this;
        }

        public final a cI(@NonNull String str) {
            this.aFa = str;
            return this;
        }

        public final a di(int i) {
            if (i > 0) {
                this.aEM = i;
            }
            return this;
        }

        public final a dj(int i) {
            this.aFq = i;
            return this;
        }
    }

    public /* synthetic */ c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService, int i2, byte b) {
        this(z, z2, str, str2, str3, str4, str5, str6, str7, i, str8, bArr, z3, z4, executorService, i2);
    }

    public final int El() {
        return this.aFo;
    }

    public final String Em() {
        return this.aFa;
    }

    public final String En() {
        return this.aFb;
    }

    public final String Eo() {
        return this.aFc;
    }

    public final String Ep() {
        return this.aFd;
    }

    public final String Eq() {
        return this.aFe;
    }

    public final String Er() {
        return this.aFf;
    }

    public final boolean Es() {
        return this.aFi;
    }

    public final boolean Et() {
        return this.aFj;
    }

    public final ExecutorService Eu() {
        return this.aFk;
    }

    public final int getRetryCount() {
        return this.aEM;
    }

    private c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService, int i2) {
        this.aEM = i;
        this.aFa = str2;
        this.aFb = str3;
        this.aFc = str4;
        this.aFd = str5;
        this.aFe = str6;
        this.aFf = str7;
        this.aFg = str;
        this.aFh = z;
        this.aFi = z2;
        this.aFl = str8;
        this.aFm = bArr;
        this.aFn = z3;
        this.aFj = z4;
        this.aFk = executorService;
        this.aFo = i2;
    }
}
