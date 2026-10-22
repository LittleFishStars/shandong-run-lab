package com.kwad.components.core.innerEc.live.widget;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class g {

    public static final class a extends g {
        private final int ro;

        public final int sU() {
            return this.ro;
        }

        public final String toString() {
            return "FixedTimeSpeed(time=" + this.ro + ")";
        }
    }

    public static final class b extends g {
        public final String toString() {
            return "ImmediatelySpeed";
        }
    }

    public static final class c extends g {
        public static final c YZ = new c();

        public final String toString() {
            return "NormalSpeed";
        }
    }

    public static final class d extends g {
        private final List<l> Za;
        private volatile List<k> Zb;
        private volatile boolean Zc;
        private final Context context;

        private List<k> o(@NonNull List<l> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<l> it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                i += it.next().aad;
            }
            ArrayList arrayList2 = new ArrayList();
            for (l lVar : list) {
                float f = (lVar.aad * 1.0f) / i;
                arrayList.add(Integer.valueOf((int) (((f * 1000.0f) * 1000.0f) / com.kwad.sdk.c.a.a.a(this.context, lVar.aae))));
                k kVar = new k();
                kVar.aac = f;
                arrayList2.add(kVar);
            }
            Iterator it2 = arrayList.iterator();
            int iIntValue = 0;
            while (it2.hasNext()) {
                iIntValue += ((Integer) it2.next()).intValue();
            }
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                ((k) arrayList2.get(i2)).aab = (((Integer) arrayList.get(i2)).intValue() * 1.0f) / iIntValue;
            }
            com.kwad.sdk.core.d.c.i("LiveCommentScrollSpeedStrategy", "covertSegmentsToPercentDataListsegments " + list + "percentDataList" + arrayList2);
            return arrayList2;
        }

        public final int bi(int i) {
            try {
                Iterator<l> it = this.Za.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    i2 += it.next().aad;
                }
                if (i2 <= 0) {
                    return 0;
                }
                int iA = 0;
                for (l lVar : this.Za) {
                    iA += (int) (((i * ((lVar.aad * 1.0f) / i2)) * 1000.0f) / com.kwad.sdk.c.a.a.a(this.context, lVar.aae));
                }
                return iA;
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.i("LiveCommentScrollSpeedStrategy", "SegmentsSpeed calculateScrollTime error" + e);
                return 0;
            }
        }

        @Nullable
        public final List<k> sV() {
            if (!this.Zc) {
                synchronized (this) {
                    if (!this.Zc) {
                        try {
                            this.Zb = o(this.Za);
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.c.i("LiveCommentScrollSpeedStrategy", "covertSegmentsToPercentDataList error" + e);
                            this.Zb = null;
                        }
                        this.Zc = true;
                    }
                }
            }
            return this.Zb;
        }

        public final String toString() {
            return "SegmentsSpeed(segments=" + this.Za + ")";
        }
    }

    public static final class e extends g {
        public final String toString() {
            return "SlowSpeed";
        }
    }

    public static final class f extends g {
        private final int Zd;

        public final int sW() {
            return this.Zd;
        }

        public final String toString() {
            return "SpecificSpeed(speedPx=" + this.Zd + ")";
        }
    }

    public static boolean n(@Nullable List<k> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (k kVar : list) {
            if (kVar.aac <= 0.0f || kVar.aab <= 0.0f) {
                return false;
            }
        }
        return true;
    }
}
