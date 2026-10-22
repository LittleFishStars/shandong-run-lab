package com.ipd.dsp.internal.o0;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.f0.h;
import com.ipd.dsp.internal.l0.f;
import com.ipd.dsp.internal.m0.g;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements c.a, c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38477a = "BreakpointInterceptor";
    public static final Pattern b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");

    @Override // com.ipd.dsp.internal.o0.c.a
    @NonNull
    public com.ipd.dsp.internal.j0.a.InterfaceC0886a a(f fVar) throws IOException {
        com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886aN = fVar.n();
        com.ipd.dsp.internal.h0.b bVarH = fVar.h();
        if (fVar.d().f()) {
            throw com.ipd.dsp.internal.m0.c.f;
        }
        if (bVarH.b() == 1 && !bVarH.k()) {
            long jA = a(interfaceC0886aN);
            long jH = bVarH.h();
            if (jA > 0 && jA != jH) {
                com.ipd.dsp.internal.g0.c.a(f38477a, "SingleBlock special check: the response instance-length[" + jA + "] isn't equal to the instance length from trial-connection[" + jH + "]");
                boolean z = bVarH.b(0).d() != 0;
                com.ipd.dsp.internal.h0.a aVar = new com.ipd.dsp.internal.h0.a(0L, jA);
                bVarH.n();
                bVarH.a(aVar);
                if (z) {
                    com.ipd.dsp.internal.g0.c.c(f38477a, "Discard breakpoint because of on this special case, we have to download from beginning");
                    throw new g("Discard breakpoint because of on this special case, we have to download from beginning");
                }
                h.j().b().a().downloadFromBeginning(fVar.k(), bVarH, com.ipd.dsp.internal.i0.b.CONTENT_LENGTH_CHANGED);
            }
        }
        try {
            if (fVar.g().a(bVarH)) {
                return interfaceC0886aN;
            }
            throw new IOException("Update store failed!");
        } catch (Exception e) {
            throw new IOException("Update store failed!", e);
        }
    }

    @Override // com.ipd.dsp.internal.o0.c.b
    public long b(f fVar) throws IOException {
        long j = fVar.j();
        int iC = fVar.c();
        boolean z = j != -1;
        com.ipd.dsp.internal.n0.d dVarI = fVar.i();
        long j2 = 0;
        while (true) {
            try {
                long jM = fVar.m();
                if (jM == -1) {
                    break;
                }
                j2 += jM;
            } catch (Throwable th) {
                fVar.b();
                if (!fVar.d().k()) {
                    dVarI.c(iC);
                }
                throw th;
            }
        }
        fVar.b();
        if (!fVar.d().k()) {
            dVarI.c(iC);
        }
        if (z) {
            dVarI.d(iC);
            if (j2 != j) {
                throw new IOException("Fetch-length isn't equal to the response content-length, " + j2 + "!= " + j);
            }
        }
        return j2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @IntRange(from = -1)
    public long a(@NonNull com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886a) {
        long j;
        String strA = interfaceC0886a.a("Content-Range");
        if (com.ipd.dsp.internal.g0.c.a((CharSequence) strA)) {
            j = -1;
        } else {
            long jA = a(strA);
            if (jA > 0) {
                j = jA + 1;
            } else {
                j = -1;
            }
        }
        if (j >= 0) {
            return j;
        }
        String strA2 = interfaceC0886a.a("Content-Length");
        return !com.ipd.dsp.internal.g0.c.a((CharSequence) strA2) ? Long.parseLong(strA2) : j;
    }

    @IntRange(from = -1)
    public static long a(@NonNull String str) {
        Matcher matcher = b.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }
}
