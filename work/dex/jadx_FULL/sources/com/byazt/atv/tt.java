package com.byazt.atv;

import com.byazt.sz.qy;
import com.byazt.xl.u;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 134, 13})
public class tt extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28301a;
    public JSONObject c;
    public boolean n;
    public qy tt;
    public float uj;
    public float ve;

    @com.byazt.zqa.c(c = {0, 1, 134, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c extends u.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28302a;
        public JSONObject c;
        public boolean n;
        public qy tt;
        public float uj;
        public float ve;

        public c sl(int i) {
            this.f28302a = i;
            return this;
        }

        public c n(JSONObject jSONObject) {
            this.c = jSONObject;
            return this;
        }

        public c tt(float f) {
            this.uj = f;
            return this;
        }

        public c c(qy qyVar) {
            this.tt = qyVar;
            return this;
        }

        public c n(boolean z) {
            this.n = z;
            return this;
        }

        @Override // com.byazt.xl.u.c
        /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
        public tt c() {
            return new tt(this);
        }

        public c c(float f) {
            this.ve = f;
            return this;
        }
    }

    public tt(c cVar) {
        super(cVar);
        this.f28301a = 3;
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve;
        this.uj = cVar.uj;
        this.n = cVar.n;
        this.f28301a = cVar.f28302a;
    }

    public boolean cu() {
        return this.n;
    }

    public float d() {
        return this.ve;
    }

    public float eo() {
        return this.uj;
    }

    public qy or() {
        return this.tt;
    }

    public int qp() {
        return this.f28301a;
    }

    public JSONObject zb() {
        return this.c;
    }
}
