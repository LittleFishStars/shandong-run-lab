package com.ipd.dsp.internal.l0;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f0.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {
    public static final String h = "ConnectTrial";
    public static final Pattern i = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    public static final Pattern j = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final com.ipd.dsp.internal.f0.f f38397a;

    @NonNull
    public final com.ipd.dsp.internal.h0.b b;
    public boolean c;

    @IntRange(from = -1)
    public long d;

    @Nullable
    public String e;

    @Nullable
    public String f;
    public int g;

    public c(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar) {
        this.f38397a = fVar;
        this.b = bVar;
    }

    public void a() throws IOException {
        h.j().f().a(this.f38397a);
        h.j().f().a();
        com.ipd.dsp.internal.j0.a aVarA = h.j().c().a(this.f38397a.e());
        try {
            if (!com.ipd.dsp.internal.g0.c.a((CharSequence) this.b.c())) {
                aVarA.a("If-Match", this.b.c());
            }
            aVarA.a("Range", "bytes=0-0");
            Map<String, List<String>> mapK = this.f38397a.k();
            if (mapK != null) {
                com.ipd.dsp.internal.g0.c.b(mapK, aVarA);
            }
            com.ipd.dsp.internal.f0.c cVarA = h.j().b().a();
            cVarA.connectTrialStart(this.f38397a, aVarA.d());
            com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886aG = aVarA.g();
            this.f38397a.a(interfaceC0886aG.b());
            com.ipd.dsp.internal.g0.c.a(h, "task[" + this.f38397a.b() + "] redirect location: " + this.f38397a.r());
            this.g = interfaceC0886aG.f();
            this.c = d(interfaceC0886aG);
            this.d = c(interfaceC0886aG);
            this.e = a(interfaceC0886aG);
            this.f = b(interfaceC0886aG);
            Map<String, List<String>> mapE = interfaceC0886aG.e();
            if (mapE == null) {
                mapE = new HashMap<>();
            }
            cVarA.connectTrialEnd(this.f38397a, this.g, mapE);
            boolean zA = a(this.d, interfaceC0886aG);
            aVarA.a();
            if (zA) {
                i();
            }
        } catch (Throwable th) {
            aVarA.a();
            throw th;
        }
    }

    public long b() {
        return this.d;
    }

    public int c() {
        return this.g;
    }

    @Nullable
    public String d() {
        return this.e;
    }

    @Nullable
    public String e() {
        return this.f;
    }

    public boolean f() {
        return this.c;
    }

    public boolean g() {
        return this.d == -1;
    }

    public boolean h() {
        return (this.b.c() == null || this.b.c().equals(this.e)) ? false : true;
    }

    public void i() throws IOException {
        com.ipd.dsp.internal.j0.a aVarA = h.j().c().a(this.f38397a.e());
        com.ipd.dsp.internal.f0.c cVarA = h.j().b().a();
        try {
            aVarA.b(com.ipd.dsp.internal.g0.c.f38307a);
            Map<String, List<String>> mapK = this.f38397a.k();
            if (mapK != null) {
                com.ipd.dsp.internal.g0.c.b(mapK, aVarA);
            }
            cVarA.connectTrialStart(this.f38397a, aVarA.d());
            com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886aG = aVarA.g();
            cVarA.connectTrialEnd(this.f38397a, interfaceC0886aG.f(), interfaceC0886aG.e());
            this.d = com.ipd.dsp.internal.g0.c.b(interfaceC0886aG.a("Content-Length"));
        } finally {
            aVarA.a();
        }
    }

    @Nullable
    public static String b(com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886a) throws IOException {
        return a(interfaceC0886a.a("Content-Disposition"));
    }

    public static long c(com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886a) {
        long jB = b(interfaceC0886a.a("Content-Range"));
        if (jB != -1) {
            return jB;
        }
        if (!c(interfaceC0886a.a("Transfer-Encoding"))) {
            com.ipd.dsp.internal.g0.c.c(h, "Transfer-Encoding isn't chunked but there is no valid instance length found either!");
        }
        return -1L;
    }

    public static boolean d(@NonNull com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886a) throws IOException {
        if (interfaceC0886a.f() == 206) {
            return true;
        }
        return "bytes".equals(interfaceC0886a.a("Accept-Ranges"));
    }

    public static long b(@Nullable String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split(WVNativeCallbackUtil.SEPERATER);
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.ipd.dsp.internal.g0.c.c(h, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static boolean c(@Nullable String str) {
        return str != null && str.equals(com.ipd.dsp.internal.g0.c.k);
    }

    @Nullable
    public static String a(String str) throws IOException {
        String strGroup;
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = i.matcher(str);
            if (matcher.find()) {
                strGroup = matcher.group(1);
            } else {
                Matcher matcher2 = j.matcher(str);
                strGroup = matcher2.find() ? matcher2.group(1) : null;
            }
            if (strGroup != null && strGroup.contains("../")) {
                throw new com.ipd.dsp.internal.m0.a("The filename [" + strGroup + "] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability");
            }
            return strGroup;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    @Nullable
    public static String a(com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886a) {
        return interfaceC0886a.a(com.ipd.dsp.internal.g0.c.g);
    }

    public boolean a(long j2, @NonNull com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886a) {
        String strA;
        if (j2 != -1) {
            return false;
        }
        String strA2 = interfaceC0886a.a("Content-Range");
        return (strA2 == null || strA2.length() <= 0) && !c(interfaceC0886a.a("Transfer-Encoding")) && (strA = interfaceC0886a.a("Content-Length")) != null && strA.length() > 0;
    }
}
