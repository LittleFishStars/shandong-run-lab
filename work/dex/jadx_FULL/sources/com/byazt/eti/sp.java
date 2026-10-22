package com.byazt.eti;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.ete.ic;
import com.byazt.ete.x;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.ipd.dsp.internal.e1.i;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 384, 91})
public class sp {
    public static final Map<String, AtomicBoolean> ve = new ConcurrentHashMap();
    public c c;
    public final com.byazt.eti.tt tt;

    @com.byazt.zqa.c(c = {0, 1, 384, 180})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f28527a;
        public final String c;
        public final int n;
        public final int sp;
        public final int tt;
        public final boolean uj;
        public final int ve;

        /* JADX INFO: renamed from: com.byazt.eti.sp$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 384, 1063})
        public static class C0398c {
            public int tt;
            public int ve;
            public String c = "Default";
            public boolean uj = true;
            public int n = 1;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f28528a = 0;
            public int sp = 1;

            public C0398c c(String str) {
                this.c = str;
                return this;
            }

            public C0398c tt(int i) {
                this.f28528a = i;
                return this;
            }

            public C0398c uj(int i) {
                this.n = i;
                return this;
            }

            public C0398c ve(int i) {
                this.sp = i;
                return this;
            }

            public C0398c c(int i) {
                this.tt = i;
                return this;
            }

            public C0398c c(boolean z) {
                this.uj = z;
                return this;
            }

            public c c() {
                return new c(this);
            }
        }

        public int n() {
            return this.sp;
        }

        public int uj() {
            return this.n;
        }

        public boolean ve() {
            return this.uj;
        }

        private c(C0398c c0398c) {
            this.c = c0398c.c;
            this.tt = c0398c.tt;
            this.ve = c0398c.ve;
            this.uj = c0398c.uj;
            this.f28527a = c0398c.f28528a;
            this.sp = c0398c.sp;
            this.n = c0398c.n;
        }

        public String c() {
            return this.c;
        }

        public int tt() {
            return this.tt;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 384, 904})
    public static class tt {
        public long c;
        public String n;
        public long tt;
        public int uj = 7611;
        public String ve;

        public tt(String str, long j, long j2, String str2) {
            this.c = j;
            this.tt = j2;
            this.ve = str;
            this.n = str2;
        }

        public boolean c() {
            return (TextUtils.isEmpty(this.ve) || this.c == 0) ? false : true;
        }
    }

    public sp(int i) {
        c cVarTt = tt(i);
        this.c = cVarTt;
        if (cVarTt.f28527a != 1) {
            this.tt = new ve();
        } else {
            this.tt = new uj();
        }
    }

    private AtomicBoolean n(String str) {
        Map<String, AtomicBoolean> map = ve;
        if (!map.containsKey(str)) {
            map.put(str, new AtomicBoolean(false));
        }
        return map.get(str);
    }

    public void c(String str, tt ttVar, boolean z, long j, int i) {
        try {
            com.byazt.eti.c cVar = gt.tt().ox() ? new com.byazt.eti.c() { // from class: com.byazt.eti.sp.1
                @Override // com.byazt.eti.c
                public void c(tt ttVar2) {
                    try {
                        ic icVarC = com.byazt.omf.c.c(new JSONObject(com.byazt.nr.c.ve(ttVar2.ve)));
                        icVarC.bn().uj(3);
                        com.byazt.ddx.uj.ve(icVarC, com.byazt.dyf.tt.AD_TAG_FEED);
                    } catch (Exception unused) {
                    }
                }
            } : null;
            synchronized (n(str)) {
                a aVar = new a();
                aVar.c = z;
                aVar.tt = (int) j;
                aVar.ve = i;
                this.tt.c(str, ttVar, aVar, this.c, cVar);
            }
        } catch (Throwable unused) {
        }
    }

    public void tt(String str) {
        com.byazt.eti.c cVar = gt.tt().dn() ? new com.byazt.eti.c() { // from class: com.byazt.eti.sp.2
            @Override // com.byazt.eti.c
            public void c(tt ttVar) {
                try {
                    ic icVarC = com.byazt.omf.c.c(new JSONObject(com.byazt.nr.c.ve(ttVar.ve)));
                    icVarC.bn().uj(2);
                    com.byazt.ddx.uj.ve(icVarC, com.byazt.dyf.tt.AD_TAG_FEED);
                } catch (Exception unused) {
                }
            }
        } : null;
        try {
            m.uj("cache_tag", "广告类型 " + this.c.tt + " ---缓存清理中--- rit: " + str);
            this.tt.c(str, this.c, cVar);
        } catch (Throwable unused) {
        }
    }

    public boolean uj(String str) {
        boolean zC;
        try {
            synchronized (n(str)) {
                zC = this.tt.c(str, this.c);
            }
            return zC;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void ve(String str) {
        try {
            if (n(str).compareAndSet(false, true)) {
                System.currentTimeMillis();
                this.tt.tt(str);
                System.currentTimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    private c tt(int i) {
        String str;
        x.ve veVarC = x.c(i);
        switch (i) {
            case 1:
                str = i.d;
                break;
            case 2:
            default:
                str = "Default";
                break;
            case 3:
            case 4:
                str = "Splash";
                break;
            case 5:
                str = "Feed";
                break;
            case 6:
                str = "Stream";
                break;
            case 7:
                str = ExploreConstants.SCENE_REWARD;
                break;
            case 8:
                str = ExploreConstants.SCENE_FULL;
                break;
            case 9:
                str = i.f;
                break;
        }
        if (veVarC == null) {
            return new c.C0398c().c();
        }
        return new c.C0398c().c(str).c(i).c(veVarC.x()).tt(veVarC.n()).ve(veVarC.tt()).uj(veVarC.ve()).c();
    }

    public tt c(String str, boolean z, long j) {
        tt ttVarC;
        try {
            synchronized (n(str)) {
                ttVarC = this.tt.c(str, this.c, j, null);
                if (ttVarC != null && ttVarC.c() && z) {
                    this.tt.c(str, ttVarC.n, true);
                }
            }
            return ttVarC;
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<tt> c(String str, boolean z, long j, int i, double d) {
        ArrayList<tt> arrayList = new ArrayList();
        try {
            synchronized (n(str)) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < i; i2++) {
                    tt ttVarC = this.tt.c(str, this.c, j, arrayList2);
                    if (ttVarC == null || !ttVarC.c()) {
                        break;
                    }
                    arrayList2.add(ttVarC.n);
                    arrayList.add(ttVarC);
                }
                if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    int iFloor = (int) Math.floor(((double) i) * d);
                    arrayList.size();
                    if (arrayList.size() < iFloor) {
                        return Collections.emptyList();
                    }
                }
                for (tt ttVar : arrayList) {
                    if (z) {
                        this.tt.c(str, ttVar.n, true);
                    }
                }
                return arrayList;
            }
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    public tt c(String str, long j, List<String> list) {
        tt ttVarC;
        try {
            synchronized (n(str)) {
                System.currentTimeMillis();
                ttVarC = this.tt.c(str, this.c, j, list);
                if (ttVarC != null && ttVarC.c()) {
                    System.currentTimeMillis();
                }
            }
            return ttVarC;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void c() {
        try {
            this.tt.c(this.c);
        } catch (Throwable unused) {
        }
    }

    public void c(String str) {
        try {
            this.tt.c(str);
        } catch (Throwable unused) {
        }
    }

    public void c(String str, String str2, boolean z) {
        try {
            synchronized (n(str)) {
                this.tt.c(str, str2, z);
            }
        } catch (Throwable unused) {
        }
    }

    public void c(String str, String str2) {
        try {
            synchronized (n(str)) {
                this.tt.c(str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public void c(int i) {
        this.c = tt(i);
    }
}
