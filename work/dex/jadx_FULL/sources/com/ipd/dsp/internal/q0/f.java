package com.ipd.dsp.internal.q0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f implements com.ipd.dsp.internal.f0.c {

    @NonNull
    public final com.ipd.dsp.internal.f0.c[] f;

    public f(@NonNull com.ipd.dsp.internal.f0.c[] cVarArr) {
        this.f = cVarArr;
    }

    public boolean a(com.ipd.dsp.internal.f0.c cVar) {
        for (com.ipd.dsp.internal.f0.c cVar2 : this.f) {
            if (cVar2 == cVar) {
                return true;
            }
        }
        return false;
    }

    public int b(com.ipd.dsp.internal.f0.c cVar) {
        int i = 0;
        while (true) {
            com.ipd.dsp.internal.f0.c[] cVarArr = this.f;
            if (i >= cVarArr.length) {
                return -1;
            }
            if (cVarArr[i] == cVar) {
                return i;
            }
            i++;
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void connectEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, int i2, @NonNull Map<String, List<String>> map) {
        for (com.ipd.dsp.internal.f0.c cVar : this.f) {
            cVar.connectEnd(fVar, i, i2, map);
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void connectStart(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, @NonNull Map<String, List<String>> map) {
        for (com.ipd.dsp.internal.f0.c cVar : this.f) {
            cVar.connectStart(fVar, i, map);
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void connectTrialEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, @NonNull Map<String, List<String>> map) {
        for (com.ipd.dsp.internal.f0.c cVar : this.f) {
            cVar.connectTrialEnd(fVar, i, map);
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void connectTrialStart(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull Map<String, List<String>> map) {
        for (com.ipd.dsp.internal.f0.c cVar : this.f) {
            cVar.connectTrialStart(fVar, map);
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void downloadFromBeginning(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull com.ipd.dsp.internal.i0.b bVar2) {
        for (com.ipd.dsp.internal.f0.c cVar : this.f) {
            cVar.downloadFromBeginning(fVar, bVar, bVar2);
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void downloadFromBreakpoint(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar) {
        for (com.ipd.dsp.internal.f0.c cVar : this.f) {
            cVar.downloadFromBreakpoint(fVar, bVar);
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void fetchEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, long j) {
        for (com.ipd.dsp.internal.f0.c cVar : this.f) {
            cVar.fetchEnd(fVar, i, j);
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void fetchProgress(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, long j) {
        for (com.ipd.dsp.internal.f0.c cVar : this.f) {
            cVar.fetchProgress(fVar, i, j);
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void fetchStart(@NonNull com.ipd.dsp.internal.f0.f fVar, int i, long j) {
        for (com.ipd.dsp.internal.f0.c cVar : this.f) {
            cVar.fetchStart(fVar, i, j);
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void taskEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
        for (com.ipd.dsp.internal.f0.c cVar : this.f) {
            cVar.taskEnd(fVar, aVar, exc);
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void taskStart(@NonNull com.ipd.dsp.internal.f0.f fVar) {
        for (com.ipd.dsp.internal.f0.c cVar : this.f) {
            cVar.taskStart(fVar);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<com.ipd.dsp.internal.f0.c> f38522a = new ArrayList();

        public f a() {
            List<com.ipd.dsp.internal.f0.c> list = this.f38522a;
            return new f((com.ipd.dsp.internal.f0.c[]) list.toArray(new com.ipd.dsp.internal.f0.c[list.size()]));
        }

        public boolean b(com.ipd.dsp.internal.f0.c cVar) {
            return this.f38522a.remove(cVar);
        }

        public a a(@Nullable com.ipd.dsp.internal.f0.c cVar) {
            if (cVar != null && !this.f38522a.contains(cVar)) {
                this.f38522a.add(cVar);
            }
            return this;
        }
    }
}
