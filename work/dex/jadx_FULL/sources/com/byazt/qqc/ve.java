package com.byazt.qqc;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.Window;
import androidx.camera.video.AudioStats;
import com.aliyun.credentials.utils.AuthConstant;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_MAXDURATION, 54})
public class ve {
    public static final ve c = new ve();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f28982a;
    public volatile boolean n;
    public volatile boolean sl;
    public ic sp;
    public com.byazt.wee.tt x;
    public float tt = -2.0f;
    public float ve = -2.0f;
    public double uj = -2.0d;
    public AtomicInteger i = new AtomicInteger();
    public AtomicInteger da = new AtomicInteger();
    public ConcurrentHashMap<Window, com.byazt.cb.tt> t = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Window, com.byazt.wee.tt> u = new ConcurrentHashMap<>();

    private ve() {
        com.byazt.aas.c cVarVe = x.m().ve();
        if (cVarVe == null) {
            return;
        }
        cVarVe.tt(new com.byazt.aas.c.ve() { // from class: com.byazt.qqc.ve.1
            @Override // com.byazt.aas.c.ve, com.byazt.aas.c.InterfaceC0346c
            public void c(String str, Window window) {
                super.c(str, window);
                if (!TextUtils.isEmpty(str) && str.contains("com.byted.live.lite")) {
                    ve veVar = ve.this;
                    veVar.c(window, veVar.sp, ve.this.sl);
                }
            }

            @Override // com.byazt.aas.c.ve, com.byazt.aas.c.InterfaceC0346c
            public void tt(String str, Window window) {
                super.tt(str, window);
                if (!TextUtils.isEmpty(str) && str.contains("com.byted.live.lite")) {
                    ve veVar = ve.this;
                    veVar.tt(window, veVar.sp, false);
                }
            }
        });
    }

    private void da() {
        if (this.i.get() > 0 && nb.ve(this.sp)) {
            this.i.decrementAndGet();
        }
    }

    private void i() {
        if (nb.ve(this.sp)) {
            this.i.incrementAndGet();
        }
    }

    private void sp() {
        if (nb.ve(this.sp)) {
            this.da.incrementAndGet();
        }
    }

    private void x() {
        if (this.da.get() > 0 && nb.ve(this.sp)) {
            this.da.decrementAndGet();
        }
    }

    public float a() {
        if (this.ve == -2.0f) {
            AudioManager audioManager = (AudioManager) gt.getContext().getSystemService("audio");
            if (audioManager == null) {
                return 0.0f;
            }
            this.ve = audioManager.getStreamVolume(3);
        }
        return this.ve;
    }

    public float n() {
        return this.tt;
    }

    public boolean uj() {
        return this.f28982a;
    }

    public boolean ve() {
        return this.n;
    }

    public static ve c() {
        return c;
    }

    private void ve(Window window, ic icVar) {
        boolean z;
        if (window == null) {
            return;
        }
        com.byazt.wee.tt ttVar = this.u.get(window);
        if (ttVar != null) {
            int iSl = nb.sl(icVar);
            if (nb.ve(icVar)) {
                x();
                z = this.da.get() == 0;
            }
            ttVar.n(iSl);
        }
        if (z) {
            this.u.remove(window);
        }
    }

    public double tt() {
        return this.uj;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        double dOptDouble = jSONObject.optDouble("day_factor", AudioStats.AUDIO_AMPLITUDE_NONE);
        double dOptDouble2 = jSONObject.optDouble("week_factor", AudioStats.AUDIO_AMPLITUDE_NONE);
        double dOptDouble3 = jSONObject.optDouble("battery_factor", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.uj = c.c(((((double) (tt.c() ? 1 : -1)) * dOptDouble2) + (((double) (tt.ve() ? 1 : -1)) * dOptDouble) + (((double) (DeviceUtils.c.tt(gt.getContext()) < 50.0f ? -1 : 1)) * dOptDouble3)) * jSONObject.optDouble("factor", AudioStats.AUDIO_AMPLITUDE_NONE), jSONObject);
    }

    public void tt(float f) {
        this.ve = f;
    }

    public void tt(@ForbidWrapParam Context context, ic icVar, boolean z) {
        tt(c(context), icVar, z);
    }

    public void tt(Window window, ic icVar, boolean z) {
        if (nb.a(icVar) && z) {
            tt(window, icVar);
        }
        if (nb.n(icVar)) {
            ve(window, icVar);
        }
    }

    private void tt(Window window, ic icVar) {
        boolean z;
        if (window == null) {
            return;
        }
        com.byazt.cb.tt ttVar = this.t.get(window);
        if (ttVar != null) {
            boolean zVe = nb.ve(icVar);
            int iSl = nb.sl(icVar);
            if (zVe) {
                da();
                z = this.i.get() == 0;
            }
            ttVar.n(iSl);
        }
        if (z) {
            this.t.remove(window);
        }
    }

    public void c(boolean z) {
        this.n = z;
    }

    public void c(float f) {
        this.tt = f;
    }

    public void c(Context context, ic icVar, boolean z) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        this.sl = z;
        c(window, icVar, z);
    }

    private void c(Window window, ic icVar) {
        if (nb.a(icVar)) {
            this.sp = icVar;
            com.byazt.cb.tt ttVar = new com.byazt.cb.tt(window);
            boolean zVe = ttVar.ve(nb.sl(icVar));
            if (window == null || !zVe) {
                return;
            }
            i();
            this.t.put(window, ttVar);
        }
    }

    private void c(boolean z, ic icVar, Window window) {
        if (!z && nb.n(icVar)) {
            this.sp = icVar;
            com.byazt.wee.tt ttVar = new com.byazt.wee.tt();
            this.x = ttVar;
            ttVar.c(xd.sp(icVar));
            this.x.c(nb.p(icVar));
            boolean zVe = this.x.ve(nb.sl(icVar));
            if (window == null || !zVe) {
                return;
            }
            sp();
            this.u.put(window, this.x);
        }
    }

    public void c(Window window, ic icVar, boolean z) {
        if (window == null) {
            return;
        }
        c(window, icVar);
        c(z, icVar, window);
    }

    private Window c(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow();
        }
        return null;
    }

    public int c(int i, ic icVar) {
        JSONObject jSONObjectYo;
        JSONArray jSONArrayOptJSONArray;
        int i2;
        int iSl = nb.sl(icVar);
        if ((iSl == 9 || iSl == 5) && (jSONObjectYo = gt.tt().yo()) != null) {
            int iOptInt = jSONObjectYo.optInt(AuthConstant.INI_ENABLE);
            double dOptDouble = jSONObjectYo.optDouble("value");
            if (iOptInt == 1 && (jSONArrayOptJSONArray = jSONObjectYo.optJSONArray("valid_type")) != null && jSONArrayOptJSONArray.length() != 0) {
                boolean z = false;
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    if (iSl == jSONArrayOptJSONArray.optInt(i3)) {
                        z = true;
                    }
                }
                if (z && (i2 = (int) (dOptDouble * 100.0d)) >= 0 && i2 <= 100) {
                    return i2;
                }
            }
        }
        return i;
    }

    public void c(int i) {
        com.byazt.wee.tt ttVar = this.x;
        if (ttVar != null) {
            int iN = ttVar.n();
            if (this.f28982a) {
                return;
            }
            this.f28982a = iN != i;
            return;
        }
        this.f28982a = true;
    }
}
