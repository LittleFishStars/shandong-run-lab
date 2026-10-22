package com.ipd.dsp.internal.n0;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.f0.f;
import com.ipd.dsp.internal.f0.h;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f38464a = new c();

    @NonNull
    public d a(@NonNull f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull com.ipd.dsp.internal.h0.e eVar) {
        return new d(fVar, bVar, eVar);
    }

    public void a(@NonNull d dVar, @NonNull f fVar) {
    }

    public boolean b(@NonNull f fVar) {
        if (!h.j().h().a()) {
            return false;
        }
        if (fVar.t() != null) {
            return fVar.t().booleanValue();
        }
        return true;
    }

    public void a(@NonNull f fVar) throws IOException {
        File fileH = fVar.h();
        if (fileH != null && fileH.exists() && !fileH.delete()) {
            throw new IOException("Delete file failed!");
        }
    }

    @NonNull
    public c a() {
        return this.f38464a;
    }
}
