package com.byazt.cq;

import android.text.TextUtils;
import com.byazt.nd.a;
import com.byazt.nd.n;
import com.byazt.nd.uj;
import com.byazt.nd.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2016, 13})
public class tt implements uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28372a;
    public String c;
    public com.byazt.cq.c n;
    public JSONObject tt;
    public ve uj;
    public Map<String, Object> ve;

    @com.byazt.zqa.c(c = {0, 1, 2016, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, Object> f28373a;
        public int c;
        public JSONObject n;
        public ve sp;
        public String tt;
        public String uj;
        public String ve;
        public JSONObject x;

        public c(String str) {
            this.tt = str;
            this.c = 1;
        }

        public c c(JSONObject jSONObject) {
            this.n = jSONObject;
            return this;
        }

        public c tt(JSONObject jSONObject) {
            this.x = jSONObject;
            return this;
        }

        public c c(Map<String, Object> map) {
            this.f28373a = map;
            return this;
        }

        public c(String str, int i) {
            this.c = i;
            if (i == 3) {
                this.uj = str;
            } else if (i == 2) {
                this.ve = str;
            }
        }

        public c c(ve veVar) {
            this.sp = veVar;
            return this;
        }

        public tt c() {
            return new tt(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        ve veVar = this.uj;
        if (veVar != null) {
            veVar.c(this);
        }
    }

    @Override // com.byazt.nd.uj
    public a tt() {
        return null;
    }

    @Override // com.byazt.nd.uj
    public n ve() {
        return new n() { // from class: com.byazt.cq.tt.1
            @Override // com.byazt.nd.n
            public void c(com.byazt.cq.c cVar, Map<String, Object> map) {
                List<com.byazt.bh.c> listC = com.byazt.bh.tt.INSTANCE.c(tt.this.c).c(cVar.x(), cVar.ve(), map);
                if (!cVar.a() && listC.isEmpty()) {
                    tt.this.uj();
                }
                Iterator<com.byazt.bh.c> it = listC.iterator();
                while (it.hasNext()) {
                    tt.this.c(it.next(), map);
                }
            }

            @Override // com.byazt.nd.n
            public void c(com.byazt.cq.c cVar, Map<String, Object> map, com.byazt.qb.c cVar2) {
                List<com.byazt.bh.c> listTt = com.byazt.bh.tt.INSTANCE.c(tt.this.c).tt(cVar.x(), cVar.ve(), map);
                if (!cVar.a() && listTt.isEmpty()) {
                    tt.this.uj();
                }
                Iterator<com.byazt.bh.c> it = listTt.iterator();
                while (it.hasNext()) {
                    tt.this.c(it.next(), map);
                }
            }
        };
    }

    private tt(c cVar) {
        this.f28372a = 1;
        this.f28372a = cVar.c;
        if (cVar.c == 2) {
            this.n = new com.byazt.cq.c(cVar.ve, 2, cVar.n, cVar.f28373a);
        } else if (cVar.c == 3) {
            this.n = new com.byazt.cq.c(cVar.uj, 3, cVar.n, cVar.f28373a);
        } else {
            this.c = cVar.tt;
            if (cVar.x != null) {
                com.byazt.bh.tt.INSTANCE.c(cVar.x);
            }
        }
        this.tt = cVar.n;
        this.ve = cVar.f28373a;
        this.uj = cVar.sp;
    }

    public void c() {
        com.byazt.bh.ve veVarC;
        int i = this.f28372a;
        if (i != 2 && i != 3) {
            if (TextUtils.isEmpty(this.c) || (veVarC = com.byazt.bh.tt.INSTANCE.c(this.c)) == null) {
                return;
            }
            c(veVarC.tt(), this.ve);
            return;
        }
        ve veVar = this.uj;
        if (veVar != null) {
            veVar.c(this.n);
        }
        this.n.sp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.bh.c cVar, Map<String, Object> map) {
        if (cVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        com.byazt.cq.c cVar2 = new com.byazt.cq.c(cVar, this.tt, map);
        cVar2.c(this.c);
        cVar2.c(this);
        ve veVar = this.uj;
        if (veVar != null) {
            veVar.c(cVar2);
        }
        List<com.byazt.bh.c> listVe = com.byazt.bh.tt.INSTANCE.c(this.c).ve(cVar, cVar2.ve(), map);
        if (!listVe.isEmpty()) {
            cVar2.c(true);
        }
        cVar2.sp();
        for (com.byazt.bh.c cVar3 : listVe) {
            if (cVar3 != null) {
                c(cVar3, map);
            }
        }
    }
}
