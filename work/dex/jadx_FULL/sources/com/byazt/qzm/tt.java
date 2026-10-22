package com.byazt.qzm;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ete.bx;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.fk.sp;
import com.byazt.jzl.uj;
import com.byazt.nr.m;
import com.byazt.xj.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 694, 13})
public class tt extends ve<NativeVideoView> {
    public boolean c;
    public boolean cf;
    public c ij;
    public String kz;
    public ic mq;
    public uj vi;
    public String vp;
    public String yo;

    public tt(Context context) {
        super(context);
        this.cf = false;
    }

    private void r() {
        if (!this.c) {
            this.mq = new ic();
            this.vi = new uj();
            return;
        }
        if (!TextUtils.isEmpty(this.kz)) {
            try {
                this.mq = com.byazt.omf.c.c(new JSONObject(this.kz));
                this.kz = null;
            } catch (JSONException e) {
                m.c(e);
            }
        }
        ic icVar = this.mq;
        if (icVar == null) {
            this.mq = new ic();
            this.vi = new uj();
            return;
        }
        uj ujVarZ = xd.z(icVar);
        this.vi = ujVarZ;
        if (ujVarZ == null) {
            this.vi = new uj();
        }
    }

    public void b() {
        c((com.byazt.ua.c) null);
    }

    public void kk() {
        T t = this.n;
        if (t != 0) {
            ((NativeVideoView) t).x();
            if (this.c) {
                ((NativeVideoView) this.n).c(true, false);
            } else {
                ((NativeVideoView) this.n).c(this.vp);
            }
        }
    }

    public boolean os() {
        sp spVarNu;
        T t = this.n;
        if (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null || (spVarNu = ((NativeVideoView) this.n).getNativeVideoController().nu()) == null) {
            return false;
        }
        return spVarNu.isCompleted();
    }

    public void oz() {
        if (os()) {
            T t = this.n;
            if (t != 0) {
                ((NativeVideoView) t).my();
                return;
            }
            return;
        }
        if (v()) {
            kk();
        } else {
            q();
        }
    }

    public void q() {
        T t = this.n;
        if (t != 0) {
            ((NativeVideoView) t).S_();
        }
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public NativeVideoView c() {
        NativeVideoView nativeVideoView = new NativeVideoView(this.tt);
        nativeVideoView.c(this);
        return nativeVideoView;
    }

    public void tx() {
        T t = this.n;
        if (t != 0) {
            ((NativeVideoView) t).n();
            ((NativeVideoView) this.n).c(this.vp);
        }
    }

    public boolean v() {
        sp spVarNu;
        T t = this.n;
        if (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null || (spVarNu = ((NativeVideoView) this.n).getNativeVideoController().nu()) == null) {
            return false;
        }
        return spVarNu.isPlaying();
    }

    public boolean x() {
        T t = this.n;
        return (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null) ? this.cf : ((NativeVideoView) this.n).getNativeVideoController().my();
    }

    public void n(boolean z) {
        T t = this.n;
        if (t != 0) {
            ((NativeVideoView) t).setNeedNativeVideoPlayBtnVisible(z);
        }
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        r();
        this.vi.setVideo_url(this.yo);
        this.vi.setResolution(this.u + "x" + this.yp);
        this.vi.setCover_url(this.vp);
        this.mq.c(this.vi);
        ((NativeVideoView) this.n).setMaterialMeta(this.mq);
        ((NativeVideoView) this.n).setIsAutoPlay(true);
        ((NativeVideoView) this.n).setIsQuiet(this.cf);
        ((NativeVideoView) this.n).setVisibility(0);
        ((NativeVideoView) this.n).setEnableAutoCheck(false);
        ((NativeVideoView) this.n).c(this.tt, 25, this.vp);
        ((NativeVideoView) this.n).c(0L, true, false);
        ((NativeVideoView) this.n).c(this.vp);
        com.byazt.dh.ve nativeVideoController = ((NativeVideoView) this.n).getNativeVideoController();
        if (nativeVideoController != null) {
            c cVar = new c();
            this.ij = cVar;
            nativeVideoController.c(cVar);
        }
    }

    public void uj(boolean z) {
        this.cf = z;
        T t = this.n;
        if (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null) {
            return;
        }
        ((NativeVideoView) this.n).getNativeVideoController().tt(z);
    }

    public void c(com.byazt.ua.c cVar) {
        ic icVar;
        if (da() != null && (icVar = this.mq) != null) {
            if (icVar.id() == 0) {
                int iOptInt = da().optInt("image_mode");
                this.mq.ic(iOptInt);
                this.mq.c(new bx(da()));
                if (iOptInt == 166) {
                    this.mq.q(-2);
                    ((NativeVideoView) this.n).setPlayerType(-2);
                }
            }
        } else {
            ((NativeVideoView) this.n).setPlayerType(0);
        }
        if (cVar != null) {
            com.byazt.dh.ve nativeVideoController = ((NativeVideoView) this.n).getNativeVideoController();
            nativeVideoController.uj(cVar.uj);
            nativeVideoController.tt(cVar.x);
            if (cVar.c) {
                nativeVideoController.tt(0L);
            } else {
                nativeVideoController.tt(cVar.sp);
            }
        }
        ((NativeVideoView) this.n).uj();
    }

    @com.byazt.zqa.c(c = {0, 1, 694, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public class c implements com.byazt.dh.ve.c {
        public com.byazt.dh.ve.c c;

        private c() {
        }

        @Override // com.byazt.dh.ve.c
        public void c(long j, int i) {
            if (tt.this.c) {
                if (tt.this.n != null) {
                    ((NativeVideoView) tt.this.n).setComplete(true);
                }
                if (tt.this.n != null) {
                    ((NativeVideoView) tt.this.n).c(true, true);
                }
            }
            com.byazt.dh.ve.c cVar = this.c;
            if (cVar != null) {
                cVar.c(j, i);
            }
        }

        @Override // com.byazt.dh.ve.c
        public void tt(long j, int i) {
            com.byazt.dh.ve.c cVar = this.c;
            if (cVar != null) {
                cVar.tt(j, i);
            }
        }

        @Override // com.byazt.dh.ve.c
        public void c() {
            com.byazt.dh.ve.c cVar = this.c;
            if (cVar != null) {
                cVar.c();
            }
        }

        @Override // com.byazt.dh.ve.c
        public void c(long j, long j2) {
            com.byazt.dh.ve.c cVar = this.c;
            if (cVar != null) {
                cVar.c(j, j2);
            }
        }
    }

    @Override // com.byazt.xj.ve
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "coverSrc":
                this.vp = str2;
                break;
            case "src":
                this.yo = str2;
                break;
            case "isLp":
                try {
                    boolean zBooleanValue = Boolean.valueOf(str2).booleanValue();
                    this.c = zBooleanValue;
                    T t = this.n;
                    if (t != 0) {
                        ((NativeVideoView) t).setLp(zBooleanValue);
                    }
                    break;
                } catch (Exception unused) {
                    return;
                }
                break;
            case "mate":
                this.kz = str2;
                break;
        }
    }

    public void c(Map<String, Object> map) {
        T t = this.n;
        if (t != 0) {
            ((NativeVideoView) t).setExtraMap(map);
        }
    }
}
