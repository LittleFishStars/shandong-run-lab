package com.ipd.dsp.internal.f0;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class l {
    public final List<Integer> b = new ArrayList();
    public final c c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<ArrayList<c>> f38305a = new SparseArray<>();

    public class a implements c {
        public a() {
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void connectEnd(@NonNull f fVar, int i, int i2, @NonNull Map<String, List<String>> map) {
            c[] cVarArrB = l.b(fVar, l.this.f38305a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.connectEnd(fVar, i, i2, map);
                }
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void connectStart(@NonNull f fVar, int i, @NonNull Map<String, List<String>> map) {
            c[] cVarArrB = l.b(fVar, l.this.f38305a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.connectStart(fVar, i, map);
                }
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void connectTrialEnd(@NonNull f fVar, int i, @NonNull Map<String, List<String>> map) {
            c[] cVarArrB = l.b(fVar, l.this.f38305a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.connectTrialEnd(fVar, i, map);
                }
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void connectTrialStart(@NonNull f fVar, @NonNull Map<String, List<String>> map) {
            c[] cVarArrB = l.b(fVar, l.this.f38305a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.connectTrialStart(fVar, map);
                }
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void downloadFromBeginning(@NonNull f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull com.ipd.dsp.internal.i0.b bVar2) {
            c[] cVarArrB = l.b(fVar, l.this.f38305a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.downloadFromBeginning(fVar, bVar, bVar2);
                }
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void downloadFromBreakpoint(@NonNull f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar) {
            c[] cVarArrB = l.b(fVar, l.this.f38305a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.downloadFromBreakpoint(fVar, bVar);
                }
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void fetchEnd(@NonNull f fVar, int i, long j) {
            c[] cVarArrB = l.b(fVar, l.this.f38305a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.fetchEnd(fVar, i, j);
                }
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void fetchProgress(@NonNull f fVar, int i, long j) {
            c[] cVarArrB = l.b(fVar, l.this.f38305a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.fetchProgress(fVar, i, j);
                }
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void fetchStart(@NonNull f fVar, int i, long j) {
            c[] cVarArrB = l.b(fVar, l.this.f38305a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.fetchStart(fVar, i, j);
                }
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void taskEnd(@NonNull f fVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
            c[] cVarArrB = l.b(fVar, l.this.f38305a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.taskEnd(fVar, aVar, exc);
                }
            }
            if (l.this.b.contains(Integer.valueOf(fVar.b()))) {
                l.this.b(fVar.b());
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void taskStart(@NonNull f fVar) {
            c[] cVarArrB = l.b(fVar, l.this.f38305a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.taskStart(fVar);
                }
            }
        }
    }

    public synchronized void b(int i) {
        this.f38305a.remove(i);
    }

    public synchronized void c(int i) {
        this.b.remove(Integer.valueOf(i));
    }

    public synchronized void d(@NonNull f fVar, @NonNull c cVar) {
        b(fVar, cVar);
        fVar.a(this.c);
    }

    public synchronized void e(@NonNull f fVar, @NonNull c cVar) {
        b(fVar, cVar);
        fVar.b(this.c);
    }

    public synchronized void a(int i) {
        if (this.b.contains(Integer.valueOf(i))) {
            return;
        }
        this.b.add(Integer.valueOf(i));
    }

    public synchronized void b(@NonNull f fVar, @NonNull c cVar) {
        int iB = fVar.b();
        ArrayList<c> arrayList = this.f38305a.get(iB);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f38305a.put(iB, arrayList);
        }
        if (!arrayList.contains(cVar)) {
            arrayList.add(cVar);
            if (cVar instanceof com.ipd.dsp.internal.r0.d) {
                ((com.ipd.dsp.internal.r0.d) cVar).setAlwaysRecoverAssistModelIfNotSet(true);
            }
        }
    }

    public synchronized boolean c(@NonNull f fVar, c cVar) {
        int iB = fVar.b();
        ArrayList<c> arrayList = this.f38305a.get(iB);
        if (arrayList == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(cVar);
        if (!arrayList.isEmpty()) {
            return zRemove;
        }
        this.f38305a.remove(iB);
        return zRemove;
    }

    public synchronized void a(c cVar) {
        int size = this.f38305a.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<c> arrayListValueAt = this.f38305a.valueAt(i2);
            if (arrayListValueAt != null) {
                arrayListValueAt.remove(cVar);
                if (arrayListValueAt.isEmpty()) {
                    arrayList.add(Integer.valueOf(this.f38305a.keyAt(i2)));
                }
            }
        }
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            this.f38305a.remove(((Integer) obj).intValue());
        }
    }

    public static c[] b(f fVar, SparseArray<ArrayList<c>> sparseArray) {
        ArrayList<c> arrayList = sparseArray.get(fVar.b());
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        c[] cVarArr = new c[arrayList.size()];
        arrayList.toArray(cVarArr);
        return cVarArr;
    }

    public synchronized void a(@NonNull f fVar, @NonNull c cVar) {
        b(fVar, cVar);
        if (a(fVar)) {
            return;
        }
        fVar.a(this.c);
    }

    @NonNull
    public c a() {
        return this.c;
    }

    public boolean a(@NonNull f fVar) {
        return k.e(fVar);
    }
}
