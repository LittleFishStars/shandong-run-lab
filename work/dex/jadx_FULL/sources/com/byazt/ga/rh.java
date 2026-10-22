package com.byazt.ga;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 256, 115})
public class rh {
    public boolean c = false;
    public final Set<Object> tt = new c();
    public final Map<String, com.byazt.kk.x> ve = new HashMap();
    public final Comparator<Pair<String, Float>> uj = new Comparator<Pair<String, Float>>() { // from class: com.byazt.ga.rh.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    public void c(boolean z) {
        this.c = z;
    }

    public void c(String str, float f) {
        if (this.c) {
            com.byazt.kk.x xVar = this.ve.get(str);
            if (xVar == null) {
                xVar = new com.byazt.kk.x();
                this.ve.put(str, xVar);
            }
            xVar.c(f);
            if ("__container".equals(str)) {
                Iterator<Object> it = this.tt.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
