package com.byazt.xyr;

import android.content.Context;
import com.byazt.nr.zm;
import com.byazt.omf.x;
import com.byazt.sz.qy;
import com.byazt.sz.rl;
import com.byazt.sz.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION, 15})
public class uj extends com.byazt.ji.tt implements qy {
    public zm sl;

    public uj(Context context) {
        super(context);
        this.sl = new zm(context, 1, x.m().uj());
    }

    private int sl() {
        JSONObject jSONObjectC;
        com.byazt.xj.ve veVar = this.tt;
        if (veVar == null) {
            return 0;
        }
        JSONObject jSONObjectDa = veVar.da();
        if (jSONObjectDa != null) {
            return jSONObjectDa.optInt("meta_hashcode", 0);
        }
        yp ypVarQp = this.tt.qp();
        if (ypVarQp == null || (jSONObjectC = ypVarQp.c()) == null) {
            return 0;
        }
        return jSONObjectC.optInt("meta_hashcode", 0);
    }

    @Override // com.byazt.sz.qy
    public void c() {
    }

    @Override // com.byazt.sz.qy
    public void c(rl rlVar) {
    }

    @Override // com.byazt.sz.qy
    public void c(JSONObject jSONObject) {
    }

    @Override // com.byazt.sz.qy
    public void tt() {
    }

    @Override // com.byazt.sz.qy
    public void ve() {
    }

    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        Map<String, Object> mapTt;
        this.tt.c(this);
        if (this.sl == null) {
            this.sl = new zm(this.da, 1, x.m().uj());
        }
        yp ypVarQp = this.tt.qp();
        if (ypVarQp == null || (mapTt = ypVarQp.tt()) == null) {
            return false;
        }
        Object obj = mapTt.get("shake_value");
        if (obj instanceof Integer) {
            this.sl.c(((Integer) obj).floatValue());
        }
        Object obj2 = mapTt.get("calculation_method");
        if (obj2 instanceof Integer) {
            this.sl.n(((Integer) obj2).intValue());
        }
        Object obj3 = mapTt.get("shake_interact_conf");
        if (obj3 instanceof JSONObject) {
            this.sl.ve((JSONObject) obj3);
        }
        Object obj4 = mapTt.get("rotation_angle");
        if (obj4 instanceof Integer) {
            this.sl.tt(((Integer) obj4).floatValue());
        }
        Object obj5 = mapTt.get("twist_config");
        if (obj5 instanceof JSONObject) {
            this.sl.c((JSONObject) obj5);
        }
        Object obj6 = mapTt.get("twist_interact_conf");
        if (obj6 instanceof JSONObject) {
            this.sl.tt((JSONObject) obj6);
        }
        Object obj7 = mapTt.get("calculation_method_twist");
        if (!(obj7 instanceof Integer)) {
            return false;
        }
        this.sl.a(((Integer) obj7).intValue());
        return false;
    }

    @Override // com.byazt.sz.qy
    public void n() {
        zm zmVar = this.sl;
        if (zmVar != null) {
            zmVar.tt(sl());
        }
    }

    @Override // com.byazt.sz.qy
    public void uj() {
        if (this.sl == null || !this.tt.i().isShown()) {
            return;
        }
        this.sl.c(new zm.c() { // from class: com.byazt.xyr.uj.1
            @Override // com.byazt.nr.zm.c
            public void c(int i) {
                if (uj.this.c == null || i != 1) {
                    return;
                }
                uj.this.c.c(uj.this.tt, uj.this.f28697a, uj.this.ve.tt(), uj.this.ve);
            }
        });
        this.sl.c(sl());
    }

    @Override // com.byazt.sz.qy
    public void c(boolean z) {
        zm zmVar = this.sl;
        if (zmVar != null) {
            if (z) {
                zmVar.c(sl());
            } else {
                zmVar.tt(sl());
            }
        }
    }
}
