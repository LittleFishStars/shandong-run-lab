package com.byazt.xyr;

import android.text.TextUtils;
import android.view.View;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f29195a;
    public JSONArray c;
    public JSONArray n;
    public final com.byazt.xj.ve sp;
    public JSONArray tt;
    public JSONArray uj;
    public JSONArray ve;

    public c(com.byazt.xj.ve veVar) {
        this.sp = veVar;
    }

    private void tt(com.byazt.xj.ve veVar) {
        Map<String, List<com.byazt.ji.tt>> mapX;
        if (veVar == null || veVar.kp() == null || (mapX = veVar.kp().x()) == null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        for (List<com.byazt.ji.tt> list : mapX.values()) {
            if (list != null && !list.isEmpty()) {
                Iterator<com.byazt.ji.tt> it = list.iterator();
                while (it.hasNext()) {
                    List<com.byazt.pm.a.c> listTt = it.next().da().tt();
                    if (listTt != null && !listTt.isEmpty()) {
                        for (com.byazt.pm.a.c cVar : listTt) {
                            if (cVar != null && !TextUtils.isEmpty(cVar.tt())) {
                                String strTt = cVar.tt();
                                strTt.hashCode();
                                switch (strTt) {
                                    case "openPrivacy":
                                        if (!z5) {
                                            c(this.n, veVar);
                                        }
                                        z5 = true;
                                        break;
                                    case "skip":
                                        if (!z6) {
                                            c(this.f29195a, veVar);
                                        }
                                        z6 = true;
                                        break;
                                    case "close":
                                        if (!z) {
                                            c(this.c, veVar);
                                        }
                                        z = true;
                                        break;
                                    case "convert":
                                        if (!z2) {
                                            c(this.tt, veVar);
                                        }
                                        z2 = true;
                                        break;
                                    case "muteVideo":
                                        if (!z4) {
                                            c(this.uj, veVar);
                                        }
                                        z4 = true;
                                        break;
                                    case "dislike":
                                        if (!z3) {
                                            c(this.ve, veVar);
                                        }
                                        z3 = true;
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        this.c = new JSONArray();
        this.tt = new JSONArray();
        this.ve = new JSONArray();
        this.uj = new JSONArray();
        this.n = new JSONArray();
        this.f29195a = new JSONArray();
        c(this.sp);
        if (this.c.length() > 0) {
            jSONObject.putOpt("close", this.c);
        }
        if (this.tt.length() > 0) {
            jSONObject.putOpt("convert", this.tt);
        }
        if (this.ve.length() > 0) {
            jSONObject.putOpt(com.byazt.dyf.tt.AD_TAG_DISLIKE, this.ve);
        }
        if (this.uj.length() > 0) {
            jSONObject.putOpt("muteVideo", this.uj);
        }
        if (this.n.length() > 0) {
            jSONObject.putOpt("openPrivacy", this.n);
        }
        if (this.f29195a.length() > 0) {
            jSONObject.putOpt(FreeSpaceBox.TYPE, this.f29195a);
        }
        return jSONObject;
    }

    private void c(com.byazt.xj.ve veVar) {
        if (veVar == null) {
            return;
        }
        if (veVar instanceof com.byazt.xj.c) {
            c((com.byazt.xj.c<?>) veVar);
        } else {
            tt(veVar);
        }
    }

    private void c(com.byazt.xj.c<?> cVar) {
        tt(cVar);
        List<com.byazt.xj.ve<View>> listSp = cVar.sp();
        if (listSp == null || listSp.isEmpty()) {
            return;
        }
        Iterator<com.byazt.xj.ve<View>> it = listSp.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
    }

    private void c(JSONArray jSONArray, com.byazt.xj.ve veVar) {
        View viewI;
        View viewI2;
        if (jSONArray == null || veVar == null || (viewI = veVar.i()) == null || (viewI2 = this.sp.i()) == null) {
            return;
        }
        int[] iArr = new int[2];
        viewI.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        viewI2.getLocationInWindow(iArr2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", veVar.eo());
            jSONObject.putOpt("width", Integer.valueOf(viewI.getWidth()));
            jSONObject.putOpt("height", Integer.valueOf(viewI.getHeight()));
            jSONObject.putOpt("x", Integer.valueOf(iArr[0] - iArr2[0]));
            jSONObject.putOpt("y", Integer.valueOf(iArr[1] - iArr2[1]));
        } catch (Throwable th) {
            m.c(th);
        }
        jSONArray.put(jSONObject);
    }
}
