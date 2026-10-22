package com.kwad.framework.filedownloader.message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g {
    private final List<a> aCB = new ArrayList();
    private final e.b aCz;

    public class a {
        private final List<Integer> aCC = new ArrayList();
        private final Executor aCD;

        public a(int i) {
            this.aCD = com.kwad.framework.filedownloader.f.b.w(1, "Flow-" + i);
        }

        public final void cT(int i) {
            this.aCC.add(Integer.valueOf(i));
        }

        public final void u(final MessageSnapshot messageSnapshot) {
            this.aCD.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.aCz.r(messageSnapshot);
                    try {
                        a.this.aCC.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public g(int i, e.b bVar) {
        this.aCz = bVar;
        for (int i2 = 0; i2 < 5; i2++) {
            this.aCB.add(new a(i2));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.aCB) {
                int id = messageSnapshot.getId();
                for (a aVar2 : this.aCB) {
                    if (aVar2.aCC.contains(Integer.valueOf(id))) {
                        aVar = aVar2;
                        break;
                    }
                }
                if (aVar == null) {
                    int size = 0;
                    for (a aVar3 : this.aCB) {
                        if (aVar3.aCC.size() <= 0) {
                            aVar = aVar3;
                            break;
                        } else if (size == 0 || aVar3.aCC.size() < size) {
                            size = aVar3.aCC.size();
                            aVar = aVar3;
                        }
                    }
                }
                if (aVar != null) {
                    aVar.cT(id);
                }
            }
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
            throw th;
        }
    }
}
