package com.ipd.dsp.internal.p0;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.f0.h;
import com.ipd.dsp.internal.l0.f;
import com.ipd.dsp.internal.o0.c;
import com.zj.adlib.c49;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38484a = "HeaderInterceptor";

    @Override // com.ipd.dsp.internal.o0.c.a
    @NonNull
    public com.ipd.dsp.internal.j0.a.InterfaceC0886a a(f fVar) throws IOException {
        com.ipd.dsp.internal.h0.b bVarH = fVar.h();
        com.ipd.dsp.internal.j0.a aVarF = fVar.f();
        com.ipd.dsp.internal.f0.f fVarK = fVar.k();
        Map<String, List<String>> mapK = fVarK.k();
        if (mapK != null) {
            com.ipd.dsp.internal.g0.c.b(mapK, aVarF);
        }
        if (mapK == null || !mapK.containsKey("User-Agent")) {
            com.ipd.dsp.internal.g0.c.a(aVarF);
        }
        int iC = fVar.c();
        com.ipd.dsp.internal.h0.a aVarB = bVarH.b(iC);
        if (aVarB == null) {
            throw new IOException("No block-info found on " + iC);
        }
        aVarF.a("Range", ("bytes=" + aVarB.d() + c49.f40900a) + aVarB.e());
        com.ipd.dsp.internal.g0.c.a(f38484a, "AssembleHeaderRange (" + fVarK.b() + ") block(" + iC + ") downloadFrom(" + aVarB.d() + ") currentOffset(" + aVarB.c() + ")");
        String strC = bVarH.c();
        if (!com.ipd.dsp.internal.g0.c.a((CharSequence) strC)) {
            aVarF.a("If-Match", strC);
        }
        if (fVar.d().f()) {
            throw com.ipd.dsp.internal.m0.c.f;
        }
        h.j().b().a().connectStart(fVarK, iC, aVarF.d());
        com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886aN = fVar.n();
        if (fVar.d().f()) {
            throw com.ipd.dsp.internal.m0.c.f;
        }
        Map<String, List<String>> mapE = interfaceC0886aN.e();
        if (mapE == null) {
            mapE = new HashMap<>();
        }
        h.j().b().a().connectEnd(fVarK, iC, interfaceC0886aN.f(), mapE);
        h.j().f().a(interfaceC0886aN, iC, bVarH).a();
        String strA = interfaceC0886aN.a("Content-Length");
        fVar.b((strA == null || strA.length() == 0) ? com.ipd.dsp.internal.g0.c.c(interfaceC0886aN.a("Content-Range")) : com.ipd.dsp.internal.g0.c.b(strA));
        return interfaceC0886aN;
    }
}
