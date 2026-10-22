package com.byazt.zb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.byazt.bv.BaseConstants;
import com.byazt.nr.m;
import com.hjq.permissions.Permission;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 184, 71})
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29235a;
    public String aw;
    public int az;
    public boolean b;
    public List<JSONObject> bj;
    public int bm;
    public ViewTreeObserver.OnGlobalLayoutListener bp;
    public long bx;
    public final String c;
    public boolean ca;
    public float cf;
    public boolean cl;
    public long cu;
    public long d;
    public Runnable da;
    public int di;
    public com.byazt.nl.uj dz;
    public String e;
    public int ej;
    public long eo;
    public com.byazt.zb.c f;
    public int g;
    public String gk;
    public boolean gr;
    public String gt;
    public boolean gu;
    public Map<String, String> gx;
    public JSONObject gy;
    public int h;
    public String hd;
    public String hg;
    public int hj;
    public String hq;
    public Runnable i;
    public String ic;
    public int ij;
    public ve ir;
    public int is;
    public c iu;
    public boolean iw;
    public boolean iy;
    public Context j;
    public int jg;
    public int jt;
    public boolean k;
    public int kk;
    public String kp;
    public JSONObject kz;
    public boolean l;
    public int lo;
    public int lr;
    public int lt;
    public boolean m;
    public WeakReference<View> ma;
    public long md;
    public String mm;
    public float mq;
    public Set<String> my;
    public final String n;
    public long nb;
    public boolean nc;
    public int nl;
    public String nt;
    public boolean nu;
    public String nx;
    public String ny;
    public long or;
    public long os;
    public long oz;
    public long p;
    public String pe;
    public long pf;
    public int pl;
    public String pn;
    public int pu;
    public int q;
    public long qp;
    public boolean qy;
    public JSONObject r;
    public boolean rh;
    public String rl;
    public int s;
    public boolean sd;
    public Runnable sl;
    public final String sp;
    public String sv;
    public final Handler t;
    public int tk;
    public int to;
    public final String tt;
    public int tx;
    public Runnable u;
    public final String uj;
    public int v;
    public final String ve;
    public float vi;
    public String vp;
    public int w;
    public final Handler x;
    public JSONObject xd;
    public int y;
    public a yf;
    public String yo;
    public Runnable yp;
    public String yv;
    public tt z;
    public long zb;
    public boolean zm;

    public enum c {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    private x(Context context, com.byazt.nl.uj ujVar, ve veVar, com.byazt.zb.c cVar, c cVar2, boolean z) {
        this.f29235a = "playable_stuck_check_ping";
        this.sp = "playable_apply_media_permission_callback";
        this.x = new Handler(Looper.getMainLooper());
        this.t = new Handler(Looper.getMainLooper());
        this.m = true;
        this.nu = true;
        this.rh = true;
        this.c = "PL_sdk_playable_global_viewable";
        this.tt = "PL_sdk_page_screen_blank";
        this.ve = "PL_sdk_playable_destroy_analyze_summary";
        this.uj = "PL_sdk_playable_hardware_dialog_cancel";
        this.n = "PL_sdk_playable_hardware_dialog_setting";
        this.my = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.gt = null;
        this.rl = com.byazt.dyf.tt.AD_TAG_FEED;
        this.qy = true;
        this.gu = true;
        this.gr = true;
        this.zm = false;
        this.yv = "";
        this.p = 10L;
        this.md = 10L;
        this.h = 700;
        this.d = 0L;
        this.eo = 0L;
        this.zb = -1L;
        this.or = -1L;
        this.cu = -1L;
        this.qp = -1L;
        this.nb = -1L;
        this.pf = -1L;
        this.bx = -1L;
        this.sv = "";
        this.aw = "";
        this.ic = "";
        this.hd = "";
        this.bm = 0;
        this.lr = 0;
        this.l = false;
        this.lo = 0;
        this.pu = -1;
        this.lt = 0;
        this.to = 0;
        this.tk = 0;
        this.kp = null;
        this.b = false;
        this.q = 0;
        this.kk = 0;
        this.tx = 0;
        this.v = 0;
        this.os = 0L;
        this.oz = 0L;
        this.s = -2;
        this.y = 0;
        this.g = 0;
        this.hj = 0;
        this.xd = new JSONObject();
        this.gx = new HashMap();
        this.gy = new JSONObject();
        this.vp = "";
        this.vi = 0.0f;
        this.mq = 0.0f;
        this.iy = false;
        this.cl = false;
        this.iw = false;
        this.bj = new ArrayList();
        this.bp = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.zb.x.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) x.this.ma.get();
                    if (view == null) {
                        return;
                    }
                    x.this.tt(view);
                } catch (Throwable th) {
                    sp.c("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.s = 0;
        this.iu = cVar2;
        this.dz = ujVar;
        i.c(ujVar);
        if (!z) {
            c(ujVar.getView());
        }
        c(context, veVar, cVar);
    }

    private void nb() {
        String str;
        if (this.gy == null || (str = this.mm) == null || str.contains("/cid_")) {
            return;
        }
        String strOptString = this.gy.optString("cid");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        String host = Uri.parse(this.mm).getHost();
        if (TextUtils.isEmpty(host)) {
            this.mm += "/cid_" + strOptString;
            return;
        }
        this.mm = this.mm.replace(host, host + "/cid_" + strOptString);
    }

    private void pf() {
        Runnable runnable;
        Runnable runnable2;
        this.z.c(System.currentTimeMillis());
        Handler handler = this.t;
        if (handler != null) {
            int i = this.s;
            if (i == 0 && (runnable2 = this.u) != null) {
                handler.post(runnable2);
            } else if ((i == 1 || i == 2) && (runnable = this.yp) != null) {
                handler.post(runnable);
            }
            this.z.c(500);
        }
    }

    private void qp() {
        this.z = new tt(this, this.h);
        this.i = new Runnable() { // from class: com.byazt.zb.x.3
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.gu) {
                    x.this.gu = false;
                    x.this.x.removeCallbacks(x.this.da);
                    x.this.c(2, "容器加载超时");
                }
            }
        };
        this.da = new Runnable() { // from class: com.byazt.zb.x.4
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.gu) {
                    x.this.gu = false;
                    x.this.x.removeCallbacks(x.this.i);
                    x.this.c(3, "JSSDK加载超时");
                }
            }
        };
        this.u = new Runnable() { // from class: com.byazt.zb.x.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (x.this.dz != null) {
                    x.this.dz.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.byazt.zb.x.5.1
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (x.this.z != null) {
                                x.this.z.c(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (x.this.t != null) {
                    x.this.t.postDelayed(this, 500L);
                }
            }
        };
        this.yp = new Runnable() { // from class: com.byazt.zb.x.6
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                x.this.c("playable_stuck_check_ping", new JSONObject());
                if (x.this.t != null) {
                    x.this.t.postDelayed(this, 500L);
                }
            }
        };
        this.sl = new Runnable() { // from class: com.byazt.zb.x.7
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.oz <= 0) {
                    x.this.tt(1, "点击热区卡死");
                } else {
                    if (x.this.oz - x.this.os > x.this.h) {
                        x.this.tt(1, "点击热区卡死");
                        return;
                    }
                    x.this.d();
                    x.this.os = 0L;
                    x.this.oz = 0L;
                }
            }
        };
    }

    public static /* synthetic */ int t(x xVar) {
        int i = xVar.bm;
        xVar.bm = i + 1;
        return i;
    }

    public static /* synthetic */ int u(x xVar) {
        int i = xVar.lr;
        xVar.lr = i + 1;
        return i;
    }

    public String cu() {
        return "function playable_callJS(){return \"Android调用了JS的callJS方法\";}";
    }

    public void d() {
        if (this.gr) {
            this.pf = System.currentTimeMillis();
            if (this.iu == c.FEED_AWEME) {
                if (this.k && this.y == 3) {
                    tt ttVar = this.z;
                    if (ttVar != null && ttVar.tt()) {
                        pf();
                        return;
                    } else {
                        if (this.z == null) {
                            this.z = new tt(this, this.h);
                            pf();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.k && this.y == 2) {
                tt ttVar2 = this.z;
                if (ttVar2 != null && ttVar2.tt()) {
                    pf();
                } else if (this.z == null) {
                    this.z = new tt(this, this.h);
                    pf();
                }
            }
        }
    }

    public void eo() {
        try {
            tt ttVar = this.z;
            if (ttVar != null) {
                ttVar.c();
            }
            Handler handler = this.t;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused) {
        }
    }

    public Context getContext() {
        return this.j;
    }

    public void gr() {
        this.b = true;
    }

    public JSONObject gt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.cf);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.ij);
            jSONObject2.put("height", this.az);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.jt);
            jSONObject3.put("y", this.is);
            jSONObject3.put("width", this.w);
            jSONObject3.put("height", this.nl);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.pl);
            jSONObject4.put("y", this.ej);
            jSONObject4.put("width", this.di);
            jSONObject4.put("height", this.jg);
            jSONObject.put("visible", jSONObject4);
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "getViewport error", th);
        }
        return jSONObject;
    }

    public void gu() {
        this.pu = 2;
    }

    public void h() {
        this.x.removeCallbacks(this.i);
        this.x.removeCallbacks(this.da);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.cu > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.cu);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            ve("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public String m() {
        com.byazt.zb.c cVar;
        if (TextUtils.isEmpty(this.ic) && (cVar = this.f) != null) {
            this.ic = cVar.uj().toString();
        }
        return this.ic;
    }

    public void md() {
        tt ttVar;
        this.oz = System.currentTimeMillis();
        int i = this.s;
        if ((i == 1 || i == 2) && (ttVar = this.z) != null) {
            ttVar.c(System.currentTimeMillis());
        }
    }

    public JSONObject my() {
        return this.gy;
    }

    public com.byazt.zb.c nu() {
        return this.f;
    }

    public void or() {
        if (this.iw) {
            return;
        }
        this.iw = true;
        this.eo = 0L;
        this.nu = true;
        zb();
        try {
            View view = this.ma.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.bp);
            }
        } catch (Throwable unused) {
        }
        try {
            this.yf.tt();
        } catch (Throwable unused2) {
        }
        try {
            tt ttVar = this.z;
            if (ttVar != null) {
                ttVar.c();
                this.z = null;
            }
            Handler handler = this.t;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.mm)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.bm);
                jSONObject.put("playable_hit_times", this.lr);
                int i = this.bm;
                if (i > 0) {
                    jSONObject.put("playable_hit_ratio", ((double) this.lr) / (((double) i) * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                ve("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (!TextUtils.isEmpty(this.mm)) {
                if (this.zb != -1) {
                    this.d += System.currentTimeMillis() - this.zb;
                    this.zb = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.d);
                ve("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused5) {
        }
        this.x.removeCallbacks(this.i);
        this.x.removeCallbacks(this.da);
        this.x.removeCallbacksAndMessages(null);
    }

    public void p() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.nb > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.nb);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.cu > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.cu);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            ve("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void qy() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.nb > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.nb);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.cu > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.cu;
                this.bx = jCurrentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", jCurrentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            ve("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public JSONObject rh() {
        if (this.xd.isNull("width")) {
            View view = this.ma.get();
            if (view == null) {
                return this.xd;
            }
            tt(view);
        }
        return this.xd;
    }

    public void rl() {
        com.byazt.zb.c cVar = this.f;
        if (cVar != null) {
            cVar.c();
        }
    }

    public JSONObject yp() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.iu.ordinal());
            jSONObject.put("safe_area_top_height", this.vi);
            jSONObject.put("safe_area_bottom_height", this.mq);
            jSONObject.put("playable_enter_from", this.to);
            jSONObject.put("playable_retry_count", this.lt);
            jSONObject.put("playable_card_session", this.sv);
            jSONObject.put("playable_video_session", this.aw);
            jSONObject.put("playable_network_type", m());
            jSONObject.put("aweme_id", this.hd);
            return jSONObject;
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public void yv() {
        if (this.f != null) {
            c cVar = c.FEED_AWEME;
        }
    }

    public Intent z() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File fileC = n.c();
        if (fileC == null) {
            return null;
        }
        intent.putExtra(com.alibaba.ariver.remotedebug.b.c.g, FileProvider.getUriForFile(this.j, this.j.getPackageName() + ".playable.fileProvider", fileC));
        return intent;
    }

    public void zb() {
        this.g = 0;
        this.hj = 0;
        this.cf = 0.0f;
        this.ij = 0;
        this.az = 0;
        this.is = 0;
        this.jt = 0;
        this.w = 0;
        this.nl = 0;
        this.ej = 0;
        this.pl = 0;
        this.di = 0;
        this.jg = 0;
    }

    public void zm() {
        if (this.f != null) {
            c cVar = c.FEED_AWEME;
        }
    }

    private boolean da(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    public String a() {
        return this.hg;
    }

    public JSONObject i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.nc);
            return jSONObject;
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    public String n() {
        return this.nt;
    }

    public JSONObject sl() {
        try {
            boolean zC = n.c(this.j, Permission.RECORD_AUDIO);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zC);
            return jSONObject;
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public boolean sp() {
        return this.sd;
    }

    public JSONObject t() {
        try {
            boolean zC = n.c(this.j, Permission.CAMERA);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zC);
            return jSONObject;
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject u() {
        boolean zC;
        boolean zC2;
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 33) {
                zC = n.c(this.j, Permission.READ_MEDIA_IMAGES);
                zC2 = true;
            } else {
                zC = n.c(this.j, "android.permission.READ_EXTERNAL_STORAGE");
                zC2 = n.c(this.j, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", zC);
            jSONObject.put("isHasWrite", zC2);
            if (!zC || !zC2) {
                z = false;
            }
            jSONObject.put("result", z);
            return jSONObject;
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public String uj() {
        return this.hq;
    }

    public String ve() {
        return this.ny;
    }

    public boolean x() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.g == view.getWidth() && this.hj == view.getHeight()) {
                return;
            }
            this.g = view.getWidth();
            this.hj = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.g);
            jSONObject.put("height", this.hj);
            c("resize", jSONObject);
            this.xd = jSONObject;
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.kp = jSONObject.optString("section");
        }
    }

    public Set<String> da() {
        Set<String> setC = this.yf.c();
        Set<String> set = this.my;
        if (set == null || set.size() <= 0) {
            return setC;
        }
        HashSet hashSet = new HashSet();
        for (String str : setC) {
            if (!this.my.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public x n(JSONObject jSONObject) {
        this.gy = jSONObject;
        return this;
    }

    public void sp(JSONObject jSONObject) {
        this.r = jSONObject;
        this.tk++;
        eo();
        this.x.removeCallbacks(this.sl);
        if (this.gr) {
            this.pf = System.currentTimeMillis();
            this.os = System.currentTimeMillis();
            this.oz = 0L;
            int i = this.s;
            if (i == 0) {
                com.byazt.nl.uj ujVar = this.dz;
                if (ujVar != null) {
                    ujVar.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.byazt.zb.x.8
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            x.this.oz = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i == 1 || i == 2) {
                c("playable_stuck_check_ping", new JSONObject());
            }
            this.x.postDelayed(this.sl, this.h);
        }
    }

    public x uj(String str) {
        this.hg = str;
        return this;
    }

    public x ve(String str) {
        this.nt = str;
        return this;
    }

    public void x(JSONObject jSONObject) {
        tt(2, jSONObject != null ? jSONObject.optString("error_msg", "素材直接调用端上异常兜底蒙层") : "素材直接调用端上异常兜底蒙层");
    }

    public void a(String str) {
        int i;
        int i2;
        this.y = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.cu = jCurrentTimeMillis;
            long j = this.or;
            jSONObject.put("playable_page_show_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        ve("PL_sdk_html_load_start", jSONObject);
        if (this.qy && ((i = this.s) == 0 || i == 1 || i == 2)) {
            this.x.postDelayed(this.i, this.p * 1000);
            if (da(this.mm) || (i2 = this.s) == 1 || i2 == 2) {
                this.x.postDelayed(this.da, this.md * 1000);
            }
            this.qy = false;
        }
        if (this.nu) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (n.c(this.j, n.t)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (n.tt(this.j, Permission.RECORD_AUDIO)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (n.c(this.j, n.sl)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (n.c(this.j, n.da)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (n.c(this.j, n.i)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (n.c(this.j, n.x)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (n.tt(this.j, Permission.CAMERA)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (n.c(this.j, n.sp)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (n.c(this.j)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                ve("PL_sdk_hardware_detect", jSONObject2);
                this.nu = false;
            } catch (Throwable th2) {
                sp.c("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public x n(String str) {
        int iIndexOf;
        String strDecode;
        this.vp = str;
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                String host = uri.getHost();
                if (!"webview".equalsIgnoreCase(host) && (host == null || !host.contains("webview"))) {
                    if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                        if (this.s == -1) {
                            tt(2);
                        } else {
                            tt(1);
                        }
                    }
                } else {
                    tt(0);
                    String queryParameter = uri.getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter) && (strDecode = Uri.decode(queryParameter)) != null) {
                        int iIndexOf2 = strDecode.indexOf("?");
                        str = iIndexOf2 != -1 ? strDecode.substring(0, iIndexOf2) : strDecode;
                    }
                }
            } else {
                tt(0);
                if (str != null && (iIndexOf = str.indexOf("?")) != -1) {
                    str = str.substring(0, iIndexOf);
                }
            }
        } catch (Throwable unused) {
        }
        this.mm = str;
        return this;
    }

    public void uj(JSONObject jSONObject) {
        if (this.f != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    public x ve(boolean z) {
        this.nc = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.nc);
            c("change_playable_click", jSONObject);
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    private void c(Context context, ve veVar, com.byazt.zb.c cVar) {
        this.gt = UUID.randomUUID().toString();
        this.j = context;
        this.f = cVar;
        this.ir = veVar;
        da.c(cVar);
        this.yf = new a(this);
        qp();
    }

    public void x(String str) {
        this.x.post(new Runnable() { // from class: com.byazt.zb.x.10
            @Override // java.lang.Runnable
            public void run() {
                x.t(x.this);
            }
        });
    }

    public JSONObject i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt == 1) {
            return sl();
        }
        if (iOptInt != 2) {
            return iOptInt != 3 ? jSONObject2 : u();
        }
        return t();
    }

    public void sl(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("success", true);
            if (zOptBoolean) {
                this.y = 3;
                d();
            } else {
                this.y = -2;
            }
            if (zOptBoolean || !this.gu) {
                return;
            }
            this.gu = false;
            this.x.removeCallbacks(this.i);
            this.x.removeCallbacks(this.da);
            c(4, "素材渲染失败");
        }
    }

    public x uj(boolean z) {
        this.gr = z;
        return this;
    }

    private String uj(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.yo) && !TextUtils.isEmpty(this.vp)) {
            Uri uri = Uri.parse(this.vp);
            String host = uri.getHost();
            if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                queryParameter = uri.getQueryParameter("surl");
                queryParameter2 = uri.getQueryParameter("playable_hash");
            } else {
                queryParameter = "";
                queryParameter2 = "";
            }
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme(uri.getScheme()).authority(host).appendQueryParameter("surl", queryParameter);
            if (!TextUtils.isEmpty(queryParameter2)) {
                builderAppendQueryParameter.appendQueryParameter("playable_hash", queryParameter2);
            }
            this.yo = builderAppendQueryParameter.toString();
        }
        return this.yo;
    }

    public JSONObject da(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (iOptInt == 1) {
                jSONObject2.put("result", n.tt(this.j, Permission.RECORD_AUDIO));
            } else {
                if (iOptInt != 2) {
                    if (iOptInt == 3) {
                        jSONObject2.put("result", n.c(this.j));
                    }
                    return jSONObject2;
                }
                jSONObject2.put("result", n.tt(this.j, Permission.CAMERA));
            }
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public void ve(JSONObject jSONObject) {
        com.byazt.zb.c cVar = this.f;
        if (cVar == null || cVar.c(jSONObject) || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        int iOptInt = jSONObject.optInt("resource_type", -1);
        String strOptString2 = jSONObject.optString("resource_name", "playable_media");
        if (iOptInt == 1) {
            tt(strOptString2, strOptString);
        } else if (iOptInt == 2) {
            ve(strOptString2, strOptString);
        }
    }

    public void c(View view) {
        if (view == null) {
            return;
        }
        try {
            this.ma = new WeakReference<>(view);
            tt(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.bp);
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    public void i(String str) {
        this.x.post(new Runnable() { // from class: com.byazt.zb.x.2
            @Override // java.lang.Runnable
            public void run() {
                x.u(x.this);
            }
        });
    }

    public x tt(String str) {
        this.ny = str;
        return this;
    }

    public JSONObject tt() {
        return this.kz;
    }

    public x tt(long j) {
        if (j <= 0) {
            this.md = 10L;
        } else {
            this.md = j;
        }
        return this;
    }

    public x c(String str, String str2) {
        this.gx.put(str, str2);
        return this;
    }

    public void sp(String str) {
        com.byazt.nl.uj ujVar;
        this.y = 2;
        this.pn = str;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.qp = jCurrentTimeMillis;
            long j = this.cu;
            jSONObject.put("playable_html_load_start_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        ve("PL_sdk_html_load_finish", jSONObject);
        this.x.removeCallbacks(this.i);
        try {
            if (this.s == 0) {
                if (this.m && (ujVar = this.dz) != null) {
                    this.m = false;
                    ujVar.evaluateJavascript(cu(), new ValueCallback<String>() { // from class: com.byazt.zb.x.9
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                d();
            }
        } catch (Throwable th2) {
            sp.c("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public x tt(boolean z) {
        if (this.k == z) {
            return this;
        }
        this.k = z;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.k) {
                jSONObject.put("playable_background_show_type", this.kk);
            }
        } catch (JSONException e) {
            m.c(e);
        }
        ve(this.k ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
        if (this.or == -1 && this.k) {
            this.or = System.currentTimeMillis();
            ve("PL_sdk_page_show", (JSONObject) null);
        }
        if (this.or != -1 && !this.k && !this.iy) {
            this.iy = true;
        }
        if (this.k) {
            this.zb = System.currentTimeMillis();
        } else if (this.zb != -1) {
            this.d += System.currentTimeMillis() - this.zb;
            this.zb = -1L;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("viewStatus", this.k);
            c("viewableChange", jSONObject2);
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "setViewable error", th);
        }
        if (this.k) {
            d();
        } else {
            eo();
        }
        return this;
    }

    public Map<String, String> c() {
        return this.gx;
    }

    public void ve(String str, String str2) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.j, "视频保存失败", 0).show();
            return;
        }
        File fileC = n.c(str, str2);
        if (fileC != null && fileC.exists()) {
            Uri uriFromFile = Uri.fromFile(fileC);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uriFromFile);
            this.j.sendBroadcast(intent);
            Toast.makeText(this.j, "视频已保存到相册", 0).show();
            return;
        }
        Toast.makeText(this.j, "视频保存失败", 0).show();
    }

    public x c(String str) {
        this.hq = str;
        return this;
    }

    public x c(boolean z) {
        this.sd = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.sd);
            c("volumeChange", jSONObject);
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    public JSONObject uj(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        JSONObject jSONObjectC = this.yf.c(str, jSONObject);
        if (sp.c()) {
            System.currentTimeMillis();
        }
        return jSONObjectC;
    }

    private String n(String str, String str2) {
        String str3 = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.mm = str3;
        return str3;
    }

    public x c(long j) {
        if (j <= 0) {
            this.p = 10L;
        } else {
            this.p = j;
        }
        return this;
    }

    private void n(String str, JSONObject jSONObject) {
        try {
            int i = this.s;
            if (i == 0) {
                if (this.iu != c.LAND_PAGE && !da(this.mm)) {
                    nb();
                }
                jSONObject.put("playable_url", this.mm);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", n(this.pe, this.nx));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", uj(this.gk, this.e));
            }
            jSONObject.put("playable_render_type", this.s);
            if (this.f != null && this.s == 0 && this.iu == c.LAND_PAGE) {
                da(this.mm);
            }
        } catch (JSONException unused) {
        }
    }

    public void c(JSONObject jSONObject) {
        if (this.f != null) {
            z();
        }
    }

    private void ve(int i, String str) {
        com.byazt.zb.c cVar = this.f;
        if (cVar != null) {
            cVar.c(i, str);
        }
    }

    public Intent c(int i) {
        Intent intent = new Intent("android.intent.action.PICK");
        if (i == 0) {
            intent.setType("*/*");
        } else if (i == 1) {
            intent.setType("image/*");
        } else if (i == 2) {
            intent.setType("video/mp4");
        } else {
            intent.setType("*/*");
        }
        return intent;
    }

    public void ve(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.l && this.lr > 0) {
                this.l = true;
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.k);
            jSONObject.put("playable_session_id", this.gt);
            int i = this.s;
            if (i == 0) {
                if (this.iu != c.LAND_PAGE && !da(this.mm)) {
                    nb();
                }
                jSONObject.put("playable_url", this.mm);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", n(this.pe, this.nx));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", uj(this.gk, this.e));
            }
            jSONObject.put("playable_full_url", this.vp);
            jSONObject.put("playable_replay_count", this.lo);
            jSONObject.put("playable_is_prerender", this.ca);
            jSONObject.put("playable_is_preload", this.l);
            jSONObject.put("playable_render_type", this.s);
            jSONObject.put("playable_scenes_type", this.iu.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.gk) ? "" : this.gk);
            if (!TextUtils.isEmpty(this.e)) {
                str2 = this.e;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.5.1");
            jSONObject.put("playable_minigamelite_id", this.pe);
            jSONObject.put("playable_minigamelite_schema", this.nx);
            jSONObject.put("playable_is_debug", this.cl);
            jSONObject.put("playable_retry_count", this.lt);
            jSONObject.put("playable_enter_from", this.to);
            jSONObject.put("playable_sequence", this.tk);
            jSONObject.put("playable_current_section", this.kp);
            jSONObject.put("is_playable_finish", this.b);
            jSONObject.put("playable_card_session", this.sv);
            jSONObject.put("playable_video_session", this.aw);
            jSONObject.put("playable_network_type", m());
            jSONObject.put("playable_lynx_version", this.yv);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
            jSONObject2.put("tag", this.rl);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", BaseConstants.CATEGORY_UMENG);
            jSONObject2.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put("value", this.gy.opt("cid"));
            jSONObject2.put("log_extra", this.gy.opt("log_extra"));
            int i2 = this.s;
            if (i2 != -1 && i2 != -2) {
                if (this.f != null) {
                    List<JSONObject> list = this.bj;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.bj.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObjectOptJSONObject = it.next().optJSONObject(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.put("playable_render_type", this.s);
                                jSONObjectOptJSONObject.put("playable_url", this.mm);
                            }
                        }
                        this.bj.clear();
                    }
                    if (this.s == 0 && this.iu == c.LAND_PAGE) {
                        da(this.mm);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.bj == null) {
                this.bj = new ArrayList();
            }
            this.bj.add(jSONObject2);
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "reportEvent error", th);
        }
    }

    public void c(String str, JSONObject jSONObject) {
        ve veVar = this.ir;
        if (veVar != null) {
            veVar.c(str, jSONObject);
        }
    }

    public void c(int i, String str) {
        eo();
        ve(i, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "reportRenderFatal error", th);
        }
        ve("PL_sdk_global_faild", jSONObject);
    }

    public void tt(JSONObject jSONObject) {
        int iOptInt = 0;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("resource_type", 0);
            n.ve = jSONObject.optInt("video_min_duration", 1);
            n.uj = jSONObject.optInt("video_max_duration", 20);
            n.n = Math.min(jSONObject.optLong("video_max_size", 15360L), 15360L);
        }
        if (this.f != null) {
            c(iOptInt);
        }
    }

    public void c(int i, String str, String str2) {
        this.y = -1;
        this.pn = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
        } catch (Throwable th) {
            sp.c("PlayablePlugin", "onWebReceivedError error", th);
        }
        ve("PL_sdk_html_load_error", jSONObject);
        if (this.gu) {
            this.gu = false;
            this.x.removeCallbacks(this.i);
            this.x.removeCallbacks(this.da);
            c(1, "容器加载失败");
        }
    }

    public void tt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.j, "照片保存失败", 0).show();
            return;
        }
        Bitmap bitmapTt = n.tt(str2);
        if (bitmapTt != null) {
            MediaStore.Images.Media.insertImage(this.j.getContentResolver(), bitmapTt, str, "");
            Toast.makeText(this.j, "照片已保存到相册", 0).show();
        } else {
            Toast.makeText(this.j, "照片保存失败", 0).show();
        }
    }

    public x tt(int i) {
        this.s = i;
        return this;
    }

    public void c(boolean z, String str, int i) {
        if (z) {
            this.y = -1;
            this.pn = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
            } catch (Throwable th) {
                sp.c("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            ve("PL_sdk_html_load_error", jSONObject);
            if (this.gu) {
                this.gu = false;
                this.x.removeCallbacks(this.i);
                this.x.removeCallbacks(this.da);
                c(1, "容器加载失败");
            }
        }
    }

    public void tt(int i, String str) {
        this.pu = i;
        if (this.r == null) {
            this.r = new JSONObject();
        }
        try {
            this.r.put("playable_stuck_type", i);
            this.r.put("playable_stuck_reason", str);
            if (this.pf > 0) {
                this.r.put("playable_stuck_duration", System.currentTimeMillis() - this.pf);
            } else {
                this.r.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        ve("PL_sdk_page_stuck", this.r);
        eo();
        if (this.f == null || i != 2) {
            return;
        }
        this.r = new JSONObject();
    }

    public static x c(Context context, com.byazt.nl.uj ujVar, ve veVar, com.byazt.zb.c cVar, Set<String> set, c cVar2, boolean z) {
        if (ujVar == null || veVar == null || cVar == null) {
            return null;
        }
        return new x(context, ujVar, veVar, cVar, set, cVar2, z);
    }

    public void tt(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n(str, jSONObject);
    }

    private x(Context context, com.byazt.nl.uj ujVar, ve veVar, com.byazt.zb.c cVar, Set<String> set, c cVar2, boolean z) {
        this(context, ujVar, veVar, cVar, cVar2, z);
        this.my = set;
    }
}
