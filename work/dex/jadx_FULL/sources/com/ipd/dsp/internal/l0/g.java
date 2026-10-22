package com.ipd.dsp.internal.l0;

import android.net.ConnectivityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.utils.FileUtil;
import com.ipd.dsp.internal.f0.h;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g {
    public static final String c = "DownloadStrategy";
    public static final long d = 1048576;
    public static final long e = 5242880;
    public static final long f = 52428800;
    public static final long g = 104857600;
    public static final Pattern h = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f38399a = null;
    public ConnectivityManager b = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile String f38400a;
        public final boolean b = false;

        public a() {
        }

        public void a(@NonNull String str) {
            this.f38400a = str;
        }

        public boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            if (this.f38400a == null) {
                return ((a) obj).f38400a == null;
            }
            return this.f38400a.equals(((a) obj).f38400a);
        }

        public int hashCode() {
            if (this.f38400a == null) {
                return 0;
            }
            return this.f38400a.hashCode();
        }

        @Nullable
        public String a() {
            return this.f38400a;
        }

        public a(@NonNull String str) {
            this.f38400a = str;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public com.ipd.dsp.internal.j0.a.InterfaceC0886a f38401a;

        @NonNull
        public com.ipd.dsp.internal.h0.b b;
        public int c;

        public b(@NonNull com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886a, int i, @NonNull com.ipd.dsp.internal.h0.b bVar) {
            this.f38401a = interfaceC0886a;
            this.b = bVar;
            this.c = i;
        }

        public void a() throws IOException {
            com.ipd.dsp.internal.h0.a aVarB = this.b.b(this.c);
            int iF = this.f38401a.f();
            com.ipd.dsp.internal.i0.b bVarA = h.j().f().a(iF, aVarB.c() != 0, this.b, this.f38401a.a(com.ipd.dsp.internal.g0.c.g));
            if (bVarA != null) {
                throw new com.ipd.dsp.internal.m0.f(bVarA);
            }
            if (h.j().f().a(iF, aVarB.c() != 0)) {
                throw new com.ipd.dsp.internal.m0.h(iF, aVarB.c());
            }
        }
    }

    public b a(com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886a, int i, com.ipd.dsp.internal.h0.b bVar) {
        return new b(interfaceC0886a, i, bVar);
    }

    public boolean a(int i, boolean z) {
        if (i == 206 || i == 200) {
            return i == 200 && z;
        }
        return true;
    }

    public long b() {
        return FileUtil.LOCAL_REPORT_FILE_MAX_SIZE;
    }

    public void b(@NonNull String str, @NonNull com.ipd.dsp.internal.f0.f fVar) {
        if (com.ipd.dsp.internal.g0.c.a((CharSequence) fVar.a())) {
            fVar.i().a(str);
        }
    }

    public int a(@NonNull com.ipd.dsp.internal.f0.f fVar, long j) {
        if (fVar.s() != null) {
            return fVar.s().intValue();
        }
        if (j < 1048576) {
            return 1;
        }
        if (j < 5242880) {
            return 2;
        }
        if (j < f) {
            return 3;
        }
        return j < g ? 4 : 5;
    }

    public boolean a(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, long j) {
        com.ipd.dsp.internal.h0.c cVarA;
        com.ipd.dsp.internal.h0.b bVarA;
        if (!fVar.z() || (bVarA = (cVarA = h.j().a()).a(fVar, bVar)) == null) {
            return false;
        }
        cVarA.remove(bVarA.g());
        if (bVarA.i() <= h.j().f().b()) {
            return false;
        }
        if ((bVarA.c() != null && !bVarA.c().equals(bVar.c())) || bVarA.h() != j || bVarA.d() == null || !bVarA.d().exists()) {
            return false;
        }
        bVar.a(bVarA);
        com.ipd.dsp.internal.g0.c.a(c, "Reuse another same info: " + bVar);
        return true;
    }

    public boolean b(@NonNull com.ipd.dsp.internal.f0.f fVar) {
        String strA = h.j().a().a(fVar.e());
        if (strA == null) {
            return false;
        }
        fVar.i().a(strA);
        return true;
    }

    public boolean a(boolean z) {
        if (h.j().h().a()) {
            return z;
        }
        return false;
    }

    public void a(@Nullable String str, @NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar) throws IOException {
        if (com.ipd.dsp.internal.g0.c.a((CharSequence) fVar.a())) {
            String strA = a(str, fVar);
            if (com.ipd.dsp.internal.g0.c.a((CharSequence) fVar.a())) {
                synchronized (fVar) {
                    if (com.ipd.dsp.internal.g0.c.a((CharSequence) fVar.a())) {
                        fVar.i().a(strA);
                        bVar.f().a(strA);
                    }
                }
            }
        }
    }

    public String a(@Nullable String str, @NonNull com.ipd.dsp.internal.f0.f fVar) throws IOException {
        if (!com.ipd.dsp.internal.g0.c.a((CharSequence) str)) {
            return str;
        }
        String strE = fVar.e();
        Matcher matcher = h.matcher(strE);
        String strD = null;
        while (matcher.find()) {
            strD = matcher.group(1);
        }
        if (com.ipd.dsp.internal.g0.c.a((CharSequence) strD)) {
            strD = com.ipd.dsp.internal.g0.c.d(strE);
        }
        if (strD != null) {
            return strD;
        }
        throw new IOException("Can't find valid filename.");
    }

    public void a(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.e eVar) {
        long length;
        com.ipd.dsp.internal.h0.b bVarE = eVar.e(fVar.b());
        if (bVarE == null) {
            bVarE = new com.ipd.dsp.internal.h0.b(fVar.b(), fVar.e(), fVar.c(), fVar.a());
            if (com.ipd.dsp.internal.g0.c.c(fVar.x())) {
                length = com.ipd.dsp.internal.g0.c.b(fVar.x());
            } else {
                File fileH = fVar.h();
                if (fileH == null) {
                    com.ipd.dsp.internal.g0.c.c(c, "file is not ready on valid info for task on complete state " + fVar);
                    length = 0;
                } else {
                    length = fileH.length();
                }
            }
            long j = length;
            bVarE.a(new com.ipd.dsp.internal.h0.a(0L, j, j));
        }
        com.ipd.dsp.internal.f0.f.c.a(fVar, bVarE);
    }

    @Nullable
    public com.ipd.dsp.internal.i0.b a(int i, boolean z, @NonNull com.ipd.dsp.internal.h0.b bVar, @Nullable String str) {
        String strC = bVar.c();
        if (i == 412) {
            return com.ipd.dsp.internal.i0.b.RESPONSE_PRECONDITION_FAILED;
        }
        if (!com.ipd.dsp.internal.g0.c.a((CharSequence) strC) && !com.ipd.dsp.internal.g0.c.a((CharSequence) str) && !str.equals(strC)) {
            return com.ipd.dsp.internal.i0.b.RESPONSE_ETAG_CHANGED;
        }
        if (i == 201 && z) {
            return com.ipd.dsp.internal.i0.b.RESPONSE_CREATED_RANGE_NOT_FROM_0;
        }
        if (i == 205 && z) {
            return com.ipd.dsp.internal.i0.b.RESPONSE_RESET_RANGE_NOT_FROM_0;
        }
        return null;
    }

    public void a() throws UnknownHostException {
        if (this.f38399a == null) {
            this.f38399a = Boolean.valueOf(com.ipd.dsp.internal.g0.c.a("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.f38399a.booleanValue()) {
            if (this.b == null) {
                this.b = (ConnectivityManager) h.j().d().getSystemService("connectivity");
            }
            if (!com.ipd.dsp.internal.g0.c.a(this.b)) {
                throw new UnknownHostException("network is not available!");
            }
        }
    }

    public void a(@NonNull com.ipd.dsp.internal.f0.f fVar) throws IOException {
        if (this.f38399a == null) {
            this.f38399a = Boolean.valueOf(com.ipd.dsp.internal.g0.c.a("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (fVar.B()) {
            if (this.f38399a.booleanValue()) {
                if (this.b == null) {
                    this.b = (ConnectivityManager) h.j().d().getSystemService("connectivity");
                }
                if (com.ipd.dsp.internal.g0.c.b(this.b)) {
                    throw new com.ipd.dsp.internal.m0.d();
                }
                return;
            }
            throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
        }
    }
}
