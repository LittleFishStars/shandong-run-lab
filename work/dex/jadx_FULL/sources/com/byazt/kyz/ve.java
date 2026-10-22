package com.byazt.kyz;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.byazt.aas.h;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.bzd.x;
import com.byazt.ete.bx;
import com.byazt.ete.gr;
import com.byazt.ete.i;
import com.byazt.ete.ic;
import com.byazt.ete.ir;
import com.byazt.ete.p;
import com.byazt.ete.pu;
import com.byazt.ete.xd;
import com.byazt.ete.zb;
import com.byazt.fh.uj;
import com.byazt.nc.n;
import com.byazt.nc.sp;
import com.byazt.nc.t;
import com.byazt.nc.u;
import com.byazt.nc.yp;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.my;
import com.byazt.omf.rl;
import com.byazt.ouz.gu;
import com.byazt.ouz.zm;
import com.byazt.pro.CreativeContainer;
import com.byazt.sy.a;
import com.byazt.sy.da;
import com.byazt.ui.UpieImageView;
import com.byazt.un.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.zj.adlib.y6b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 546, 54})
public class ve extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f28761a;
    public final my c;
    public yp da;
    public final boolean gr;
    public com.byazt.lsp.c gt;
    public com.byazt.dj.tt i;
    public float m;
    public a md;
    public com.byazt.lsp.ve my;
    public sp n;
    public da p;
    public TextView rl;
    public volatile ViewGroup sl;
    public int sp;
    public View t;
    public final ic tt;
    public Dialog uj;
    public final Context ve;
    public int x;
    public com.byazt.sy.n yv;
    public float z;
    public boolean u = false;
    public boolean yp = true;
    public AtomicBoolean nu = new AtomicBoolean(false);
    public AtomicBoolean rh = new AtomicBoolean(false);
    public boolean qy = false;
    public boolean gu = false;
    public volatile WeakReference<NativeVideoTsView> zm = null;
    public final com.byazt.un.c h = new com.byazt.un.c() { // from class: com.byazt.kyz.ve.1
        @Override // com.byazt.un.c
        public void c() {
            x.c(new Runnable() { // from class: com.byazt.kyz.ve.1.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewC = ve.this.c();
                    ve veVar = ve.this;
                    veVar.tt(veVar.sl, viewC);
                    ve.this.ve(viewC);
                    ve.this.tt(viewC);
                    ve.this.c(viewC);
                    ve.this.uj(viewC);
                }
            }, gt.tt().an());
        }
    };
    public volatile boolean d = false;
    public com.byazt.lsp.c eo = null;

    public ve(Context context, ic icVar, int i, com.byazt.dj.tt ttVar, boolean z) {
        com.byazt.nr.my.c(icVar, "materialMeta不能为null");
        this.gr = z;
        this.tt = icVar;
        if (context == null) {
            this.ve = gt.getContext();
        } else {
            this.ve = context;
        }
        this.sp = i;
        this.i = ttVar;
        my myVar = new my(this.ve, this, icVar, c(i));
        this.c = myVar;
        myVar.c(i);
        yp ypVarC = c(icVar);
        this.da = ypVarC;
        if (ypVarC == null) {
            com.byazt.rgb.tt.c(icVar, ttVar, i, getLifecycleId());
        }
        initComponentEngine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(int i) {
        if (i == 1) {
            return com.byazt.dyf.tt.AD_TAG_BANNER;
        }
        if (i == 2) {
            return "interaction";
        }
        if (i == 5) {
            return com.byazt.dyf.tt.AD_TAG_FEED;
        }
        if (i != 6) {
            return i != 9 ? com.byazt.dyf.tt.AD_TAG_FEED : "draw_ad";
        }
        return "stream";
    }

    @Override // com.byazt.nc.u
    public void destroy() {
        this.d = true;
        yp ypVar = this.da;
        if (ypVar != null) {
            ypVar.destroy();
        }
        ic icVar = this.tt;
        if (icVar != null) {
            rl.c(icVar.rl());
            rl.c(this.tt.lw());
        }
        my myVar = this.c;
        if (myVar != null) {
            myVar.tt();
        }
        this.yv.tt();
        this.p.c();
        this.md.c();
        com.byazt.rgb.tt.ve(getLifecycleId(), 2);
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (this.d) {
            return;
        }
        destroy();
    }

    @Override // com.byazt.nc.u
    public Bitmap getAdLogo() {
        ic icVar = this.tt;
        if (icVar == null) {
            return uj.c(1);
        }
        String strDn = icVar.dn();
        if (TextUtils.isEmpty(strDn)) {
            return uj.c(1);
        }
        if (this.rl == null) {
            this.rl = new TextView(gt.getContext());
            this.rl.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        pf.c(this.rl, strDn, gt.getContext());
        return pf.sp(this.rl);
    }

    @Override // com.byazt.nc.u
    public View getAdView() {
        return null;
    }

    @Override // com.byazt.nc.u
    public int getAppCommentNum() {
        if (this.tt.z() != null) {
            return this.tt.z().a();
        }
        return 0;
    }

    @Override // com.byazt.nc.u
    public int getAppScore() {
        if (this.tt.z() != null) {
            return this.tt.z().n();
        }
        return 0;
    }

    @Override // com.byazt.nc.u
    public int getAppSize() {
        if (this.tt.z() != null) {
            return this.tt.z().sp();
        }
        return 0;
    }

    @Override // com.byazt.nc.u
    public String getButtonText() {
        return this.tt.tj();
    }

    public ViewGroup getContainer() {
        return this.sl;
    }

    public Context getContext() {
        return this.ve;
    }

    @Override // com.byazt.nc.u
    public String getDescription() {
        ic icVar = this.tt;
        if (icVar == null) {
            return "";
        }
        if (com.byazt.ex.c.c(icVar) && !TextUtils.isEmpty(bx.a(this.tt))) {
            return bx.a(this.tt);
        }
        if (gt.tt().e()) {
            if (!TextUtils.isEmpty(this.tt.op())) {
                return this.tt.op();
            }
            if (!TextUtils.isEmpty(this.tt.v_())) {
                return this.tt.v_();
            }
        } else {
            if (!TextUtils.isEmpty(this.tt.v_())) {
                return this.tt.v_();
            }
            if (!TextUtils.isEmpty(this.tt.op())) {
                return this.tt.op();
            }
        }
        return "";
    }

    @Override // com.byazt.nc.u
    public sp getDislikeDialog(Activity activity) {
        if (this.da != null && this.rh.get()) {
            return this.da.getDislikeDialog(activity);
        }
        if (this.n == null) {
            c(activity);
        }
        return this.n;
    }

    @Override // com.byazt.nc.u
    public com.byazt.nc.uj getDislikeInfo() {
        ic icVar = this.tt;
        if (icVar == null || icVar.wq() == null) {
            return null;
        }
        this.tt.wq().tt(c(this.sp));
        return new com.byazt.vo.c(this.tt.wq());
    }

    @Override // com.byazt.nc.u
    public n getDownloadStatusController() {
        if (this.da != null && this.nu.get()) {
            return null;
        }
        ic icVar = this.tt;
        boolean z = icVar != null && icVar.i() == 4;
        if (this.f28761a == null && this.c != null && z) {
            this.f28761a = new n() { // from class: com.byazt.kyz.ve.8
                @Override // com.byazt.nc.n
                public void cancelDownload() {
                    com.byazt.pop.ve veVarC;
                    if (ve.this.eo == null || (veVarC = ve.this.c.c()) == null) {
                        return;
                    }
                    veVarC.n();
                }

                @Override // com.byazt.nc.n
                public void changeDownloadStatus() {
                    int iYp;
                    if (ve.this.eo != null) {
                        com.byazt.pop.ve veVarC = ve.this.c.c();
                        if ((veVarC instanceof com.byazt.wz.c) && (1 == (iYp = ((com.byazt.wz.c) veVarC).yp()) || 4 == iYp || 6 == iYp || 7 == iYp)) {
                            HashMap map = new HashMap();
                            map.put("downloadstatuscontroller_type", 1);
                            ve veVar = ve.this;
                            String strC = veVar.c(veVar.sp);
                            i.c cVar = new i.c();
                            float fA = pf.a(ve.this.ve);
                            com.byazt.ddx.uj.c("click", ve.this.tt, cVar.c(fA).tt(((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getDisplayDpi()).tt(pf.sp(ve.this.ve)).c(com.byazt.wz.x.tt(ve.this.tt)).c(), strC, true, map, 1, false, false);
                        }
                        if (veVarC != null) {
                            veVarC.ve(true);
                            veVarC.c(nb.qy(ve.this.tt), false);
                        }
                    }
                }
            };
        }
        return this.f28761a;
    }

    @Override // com.byazt.nc.u
    public t getIcon() {
        if (com.byazt.ex.c.c(this.tt)) {
            return TextUtils.isEmpty(bx.i(this.tt)) ? zb.c(0, 0, "", AudioStats.AUDIO_AMPLITUDE_NONE) : zb.c(bx.sl(this.tt), bx.da(this.tt), bx.i(this.tt), AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        return this.tt.te() == null ? zb.c(0, 0, "", AudioStats.AUDIO_AMPLITUDE_NONE) : zb.c(this.tt.te());
    }

    @Override // com.byazt.nc.u
    public List<t> getImageList() {
        ArrayList arrayList = new ArrayList();
        if (ic.tt(this.tt)) {
            com.byazt.ukr.yp.c().c(this.tt, 1, "Invalid invoke getImageList");
            return arrayList;
        }
        if (this.tt.pa() != null && !this.tt.pa().isEmpty()) {
            Iterator<zb> it = this.tt.pa().iterator();
            while (it.hasNext()) {
                t tVarC = zb.c(it.next());
                if (tVarC != null) {
                    arrayList.add(tVarC);
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.nc.u
    public int getImageMode() {
        ic icVar = this.tt;
        if (icVar == null) {
            return -1;
        }
        if (ic.tt(icVar)) {
            int iId = this.tt.id();
            if (iId == 5) {
                return 2001;
            }
            if (iId == 15) {
                return 2002;
            }
            if (com.byazt.ex.c.c(this.tt)) {
                return bx.t(this.tt) > bx.u(this.tt) ? 2001 : 2002;
            }
            List<zb> listPa = this.tt.pa();
            if (listPa != null && !listPa.isEmpty() && listPa.get(0) != null && listPa.get(0).n() && CreativeContainer.c(this.tt)) {
                return listPa.get(0).tt() >= listPa.get(0).ve() ? 2001 : 2002;
            }
        }
        List<zb> listPa2 = this.tt.pa();
        if (listPa2 == null || listPa2.isEmpty() || listPa2.get(0) == null || !listPa2.get(0).n() || !CreativeContainer.c(this.tt)) {
            return this.tt.id();
        }
        return listPa2.get(0).tt() >= listPa2.get(0).ve() ? 5 : 15;
    }

    public my getInteractionManager() {
        return this.c;
    }

    @Override // com.byazt.nc.u
    public int getInteractionType() {
        ic icVar = this.tt;
        if (icVar == null) {
            return -1;
        }
        return icVar.i();
    }

    @Override // com.byazt.nc.u
    public String getLifecycleId() {
        ic icVar = this.tt;
        if (icVar != null) {
            return icVar.zm();
        }
        return null;
    }

    public ic getMaterialMeta() {
        return this.tt;
    }

    @Override // com.byazt.nc.u
    public Map<String, Object> getMediaExtraInfo() {
        ic icVar = this.tt;
        if (icVar != null) {
            return icVar.yt();
        }
        return null;
    }

    @Override // com.byazt.nc.u
    public com.byazt.sbm.n getMediationManager() {
        return new com.byazt.ah.ve();
    }

    @Override // com.byazt.nc.u
    public String getSource() {
        return this.tt.an();
    }

    @Override // com.byazt.nc.u
    public String getTitle() {
        ic icVar = this.tt;
        if (icVar == null) {
            return "";
        }
        if (com.byazt.ex.c.c(icVar) && !TextUtils.isEmpty(bx.ve(this.tt))) {
            return bx.ve(this.tt);
        }
        if (gt.tt().e()) {
            if (!TextUtils.isEmpty(this.tt.v_())) {
                return this.tt.v_();
            }
            if (this.tt.z() != null && !TextUtils.isEmpty(this.tt.z().ve())) {
                return this.tt.z().ve();
            }
            if (!TextUtils.isEmpty(getSource())) {
                return getSource();
            }
        } else {
            if (this.tt.z() != null && !TextUtils.isEmpty(this.tt.z().ve())) {
                return this.tt.z().ve();
            }
            if (!TextUtils.isEmpty(getSource())) {
                return getSource();
            }
            if (!TextUtils.isEmpty(this.tt.v_())) {
                return this.tt.v_();
            }
        }
        return "";
    }

    @Override // com.byazt.nc.u
    public t getVideoCoverImage() {
        ic icVar = this.tt;
        if (icVar == null) {
            return zb.c(0, 0, "", AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        if (com.byazt.ex.c.c(icVar)) {
            return TextUtils.isEmpty(bx.x(this.tt)) ? zb.c(0, 0, "", AudioStats.AUDIO_AMPLITUDE_NONE) : zb.c(bx.u(this.tt), bx.t(this.tt), bx.x(this.tt), AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        if (xd.z(this.tt) != null) {
            return zb.c(xd.ve(this.tt), xd.uj(this.tt), xd.tt(this.tt), AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        List<zb> listPa = this.tt.pa();
        if (listPa == null || listPa.isEmpty() || listPa.get(0) == null || !listPa.get(0).n() || !CreativeContainer.c(this.tt)) {
            return zb.c(0, 0, "", AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        return zb.c(listPa.get(0).ve(), listPa.get(0).tt(), listPa.get(0).c(), AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public void initComponentEngine() {
        com.byazt.sy.c cVar = new com.byazt.sy.c() { // from class: com.byazt.kyz.ve.3
            @Override // com.byazt.ouz.sl
            public long c() {
                NativeVideoTsView nativeVideoTsView;
                com.byazt.dh.ve nativeVideoController;
                if (ve.this.zm == null || (nativeVideoTsView = (NativeVideoTsView) ve.this.zm.get()) == null || (nativeVideoController = nativeVideoTsView.getNativeVideoController()) == null) {
                    return 0L;
                }
                return ((int) nativeVideoController.sl()) / 1000;
            }

            @Override // com.byazt.ouz.sl
            public void c(float f) {
            }

            @Override // com.byazt.ouz.sl
            public void c(int i) {
            }

            @Override // com.byazt.ouz.sl
            public void c(int i, String str) {
            }

            @Override // com.byazt.sy.c
            public void c(ViewGroup viewGroup) {
            }

            @Override // com.byazt.ouz.sl
            public void c(ic icVar) {
            }

            @Override // com.byazt.ouz.sl
            public void n() {
            }

            @Override // com.byazt.ouz.sl
            public void setPauseFromExpressView(boolean z) {
            }

            @Override // com.byazt.ouz.sl
            public int tt() {
                NativeVideoTsView nativeVideoTsView;
                if (ve.this.zm == null || (nativeVideoTsView = (NativeVideoTsView) ve.this.zm.get()) == null) {
                    return 0;
                }
                com.byazt.dh.ve nativeVideoController = nativeVideoTsView.getNativeVideoController();
                if (nativeVideoController == null) {
                    return 4;
                }
                if (nativeVideoController.gt()) {
                    return 5;
                }
                if (nativeVideoController.qy()) {
                    return 1;
                }
                return ((nativeVideoController instanceof com.byazt.un.uj) && ((com.byazt.un.uj) nativeVideoController).bx()) ? 2 : 3;
            }

            @Override // com.byazt.ouz.sl
            public void tt(int i) {
            }

            @Override // com.byazt.ouz.sl
            public void uj() {
            }

            @Override // com.byazt.ouz.sl
            public void uj(int i) {
            }

            @Override // com.byazt.ouz.sl
            public int ve() {
                return 0;
            }

            @Override // com.byazt.ouz.sl
            public void ve(int i) {
            }

            @Override // com.byazt.sy.c
            public void c(View view) {
                com.byazt.rgb.tt.ve(ve.this.getLifecycleId());
                if (ve.this.gt != null) {
                    ve.this.gt.c(view, ve.this);
                }
                com.byazt.sy.ve.tt(ve.this.tt, p.sp(ve.this.tt), true, null);
            }

            @Override // com.byazt.sy.c
            public void c(View view, int i, com.byazt.sr.ve veVar, ir irVar) {
                String strOptString;
                com.byazt.ete.da daVar;
                boolean zOptBoolean;
                if (veVar instanceof gr) {
                    gr grVar = (gr) veVar;
                    daVar = new com.byazt.ete.da();
                    daVar.c(grVar.c);
                    daVar.tt(grVar.tt);
                    daVar.ve(grVar.ve);
                    daVar.uj(grVar.uj);
                    daVar.c(grVar.n);
                    daVar.tt(grVar.f28489a);
                    daVar.tt(grVar.z);
                    daVar.c(true);
                    strOptString = grVar.c().optString("uchain_event_name");
                    daVar.ve(strOptString);
                    zOptBoolean = grVar.c().optBoolean("isLottieInternalClick", false);
                } else {
                    strOptString = "";
                    daVar = null;
                    zOptBoolean = false;
                }
                boolean zC = com.byazt.sy.ve.c(ve.this.zm == null ? null : (NativeVideoTsView) ve.this.zm.get(), veVar);
                if (i == 1) {
                    ve.this.c.tt(view, daVar);
                    com.byazt.sy.ve.c(ve.this.tt, irVar, zC, (JSONObject) null, zOptBoolean);
                    return;
                }
                if (i == 2) {
                    ve.this.c.c(view, daVar);
                    com.byazt.sy.ve.c(ve.this.tt, irVar, zC, (JSONObject) null, zOptBoolean);
                } else {
                    if (i == 3) {
                        ve.this.n();
                        return;
                    }
                    if (i != 5) {
                        if (i == 7 && !nb.c(strOptString, ve.this.tt, ve.this.ve)) {
                            com.byazt.aas.n.c(ve.this.ve, ve.this.tt);
                            return;
                        }
                        return;
                    }
                    ve.this.tt(!(ve.this.tt.ab() == 1));
                }
            }

            @Override // com.byazt.sy.c
            public void c(View view, int i, com.byazt.sr.ve veVar, int i2) {
                com.byazt.ete.da daVar;
                if ((i == 1 || i == 2) && (veVar instanceof gr)) {
                    gr grVar = (gr) veVar;
                    daVar = new com.byazt.ete.da();
                    daVar.c(grVar.c);
                    daVar.tt(grVar.tt);
                    daVar.ve(grVar.ve);
                    daVar.uj(grVar.uj);
                    daVar.c(grVar.n);
                    daVar.tt(grVar.f28489a);
                    daVar.tt(grVar.z);
                } else {
                    daVar = null;
                }
                if (i == 2) {
                    ve.this.c.c(view, daVar);
                }
                if (i == 1) {
                    ve.this.c.tt(view, daVar);
                }
            }
        };
        this.yv = new com.byazt.sy.n(this.tt, cVar, this.i, this.ve);
        this.p = new da(this.tt, cVar, this.i, this.ve);
        this.md = new a(this.tt, cVar, this.i, this.ve);
    }

    public boolean isAllowDevOperate() {
        return this.u;
    }

    public boolean isAutoPlay() {
        return this.yp;
    }

    @Override // com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
        if (this.gu) {
            return;
        }
        h.c(this.tt, d, str, str2);
        this.gu = true;
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.lsp.c cVar, com.byazt.am.uj ujVar) {
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, View view, com.byazt.lsp.c cVar) {
        com.byazt.nr.my.c(viewGroup != null || this.rh.get(), "container不能为null");
        com.byazt.nr.my.c(view != null || this.rh.get(), "clickView不能为null");
        this.sl = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        registerViewForInteraction(viewGroup, arrayList, null, cVar);
    }

    @Override // com.byazt.nc.u
    public void render() {
        ve();
        com.byazt.dz.uj.c().c(this.tt).c(this.sp).tt(this.x);
    }

    @Override // com.byazt.nc.u
    public void setActivityForDownloadApp(Activity activity) {
        if (activity != null) {
            this.c.c(activity);
        }
    }

    @Override // com.byazt.nc.x
    public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
        ic icVar = this.tt;
        if (icVar != null) {
            rl.c(icVar.rl(), ttVar, com.byazt.ocd.tt.class);
        }
    }

    public void setAllowDevOperate(boolean z) {
        this.u = z;
    }

    public void setAutoPlay(boolean z) {
        this.yp = z;
    }

    @Override // com.byazt.nc.u
    public void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar) {
        yp ypVar;
        if (cVar == null || activity == null || (ypVar = this.da) == null) {
            return;
        }
        ypVar.setDislikeCallback(activity, cVar);
    }

    @Override // com.byazt.nc.u
    public void setDislikeDialog(final Dialog dialog, final Integer[] numArr) {
        yp ypVar = this.da;
        if (ypVar != null) {
            ypVar.setDislikeDialog(dialog, numArr);
        }
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.kyz.ve.9
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    com.byazt.vo.tt ttVarWq = ve.this.tt != null ? ve.this.tt.wq() : null;
                    if (ttVarWq != null) {
                        com.byazt.pr.tt.c(ttVarWq, dialog, numArr, new com.byazt.pr.tt.c() { // from class: com.byazt.kyz.ve.9.1
                            @Override // com.byazt.pr.tt.c
                            public void c(com.byazt.nc.a aVar) {
                                com.byazt.rgb.tt.ve(ve.this.getLifecycleId(), 1);
                            }
                        });
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable unused) {
        }
        c(dialog);
        ic icVar = this.tt;
        if (icVar != null) {
            rl.tt(icVar.lw(), dialog, Dialog.class);
        }
    }

    @Override // com.byazt.nc.u
    public void setDownloadListener(com.byazt.ocd.ve veVar) {
        com.byazt.nr.my.c(veVar, "downloadListener不能为null");
        this.c.c(com.byazt.pop.c.C0504c.c(veVar));
        yp ypVar = this.da;
        if (ypVar != null) {
            ypVar.setDownloadListener(veVar);
        }
    }

    @Override // com.byazt.nc.u
    public void setEasyPlayWidgetListener(com.byazt.lsp.tt ttVar) {
        this.yv.c(ttVar);
    }

    @Override // com.byazt.nc.u
    public void setExpressRenderListener(com.byazt.lsp.ve veVar) {
        this.my = veVar;
    }

    public void setPluginAdInteractionListener(com.byazt.lsp.c cVar) {
        this.eo = cVar;
    }

    @Override // com.byazt.nc.x
    public void setPrice(Double d) {
        my myVar = this.c;
        if (myVar != null) {
            myVar.c(d);
        }
    }

    public void setVideoViewEasyPlayableSender() {
        if (this.zm == null || this.zm.get() == null) {
            return;
        }
        this.zm.get().setEasyPlayableEventSender(this.yv.c());
    }

    public void setWeakReferenceTsView(WeakReference<NativeVideoTsView> weakReference) {
        this.zm = weakReference;
        my myVar = this.c;
        if (myVar != null) {
            myVar.c(weakReference);
        }
    }

    @Override // com.byazt.nc.u
    public void showInteractionExpressAd(Activity activity) {
    }

    @Override // com.byazt.nc.u
    public void uploadDislikeEvent(String str) {
        com.byazt.ddx.uj.tt(this.tt, str);
    }

    @Override // com.byazt.nc.x
    public void win(Double d) {
        if (this.qy) {
            return;
        }
        h.c(this.tt, d);
        this.qy = true;
    }

    @Override // com.byazt.nc.u
    public com.byazt.ete.t getComplianceInfo() {
        ic icVar = this.tt;
        if (icVar == null || icVar.i() != 4) {
            return null;
        }
        return new com.byazt.ete.t(this.tt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Dialog dialog = this.uj;
        if (dialog != null) {
            dialog.show();
            return;
        }
        sp spVar = this.n;
        if (spVar != null) {
            spVar.showDislikeDialog();
        } else {
            TTDelegateActivity.c(getContext(), this.tt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(View view) {
        final JSONObject jSONObject;
        if (this.sl == null || com.byazt.rgb.uj.a(getLifecycleId())) {
            return;
        }
        final JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("x", 0);
            jSONObject2.put("y", 0);
            jSONObject2.put("w", this.sl.getWidth());
            jSONObject2.put(y6b.g, this.sl.getHeight());
        } catch (JSONException unused) {
        }
        if (view != null) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("x", (int) view.getX());
                jSONObject.put("y", (int) view.getY());
                jSONObject.put("w", view.getWidth());
                jSONObject.put(y6b.g, view.getHeight());
            } catch (JSONException unused2) {
            }
        } else {
            jSONObject = null;
        }
        com.byazt.rgb.uj.c().c(getLifecycleId(), new com.byazt.ip.uj.c() { // from class: com.byazt.kyz.ve.5
            @Override // com.byazt.ip.uj.c
            public void c(com.byazt.ip.tt ttVar) {
                if (ttVar instanceof com.byazt.ha.n) {
                    com.byazt.ha.n nVar = (com.byazt.ha.n) ttVar;
                    nVar.c = jSONObject2;
                    if (ic.ve(ve.this.tt)) {
                        JSONObject jSONObject3 = jSONObject;
                        if (jSONObject3 != null) {
                            nVar.ve = jSONObject3;
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject4 = jSONObject;
                    if (jSONObject4 != null) {
                        nVar.tt = jSONObject4;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(View view) {
        if (gt.tt().iw()) {
            return;
        }
        this.md.c(this.sl, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tt(List<View> list, View view) {
        if (view != null && list != null) {
            for (int i = 0; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 == view) {
                    return true;
                }
                if ((view2 instanceof ViewGroup) && c((ViewGroup) view2, view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private NativeVideoTsView ve(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ("ado_tag".equals(childAt.getTag()) && (childAt instanceof NativeVideoTsView)) {
                return (NativeVideoTsView) childAt;
            }
        }
        return null;
    }

    @Override // com.byazt.nc.u
    public sp getDislikeDialog(final Dialog dialog, Integer[] numArr) {
        if (dialog != null) {
            com.byazt.pr.tt.c(this.tt.wq(), dialog, numArr, new com.byazt.pr.tt.c() { // from class: com.byazt.kyz.ve.6
                @Override // com.byazt.pr.tt.c
                public void c(com.byazt.nc.a aVar) {
                    com.byazt.rgb.tt.ve(ve.this.getLifecycleId(), 1);
                }
            });
            return new sp() { // from class: com.byazt.kyz.ve.7
                @Override // com.byazt.nc.sp
                public boolean isShow() {
                    return false;
                }

                @Override // com.byazt.nc.sp
                public void resetDislikeStatus() {
                }

                @Override // com.byazt.nc.sp
                public void setDislikeInteractionCallback(com.byazt.dhf.c cVar) {
                }

                @Override // com.byazt.nc.sp
                public void setDislikeSource(String str) {
                }

                @Override // com.byazt.nc.sp
                public void showDislikeDialog() {
                    if ((dialog.getContext() instanceof Activity) && !((Activity) dialog.getContext()).isFinishing()) {
                        dialog.show();
                    }
                }
            };
        }
        throw new IllegalArgumentException("dialog is null, please check");
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, com.byazt.lsp.c cVar) {
        boolean z = false;
        com.byazt.nr.my.c(viewGroup != null || this.rh.get(), "container不能为null");
        com.byazt.nr.my.c(list != null || this.rh.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        com.byazt.nr.my.c(z, "clickViews数量必须大于等于1");
        this.sl = viewGroup;
        registerViewForInteraction(viewGroup, list, list2, null, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View tt(ViewGroup viewGroup) {
        ImageView imageView = null;
        if (viewGroup != null) {
            ArrayList arrayList = new ArrayList();
            UpieImageView[] upieImageViewArr = {null};
            c(viewGroup, arrayList, upieImageViewArr);
            UpieImageView upieImageView = upieImageViewArr[0];
            if (upieImageView != null) {
                return upieImageView;
            }
            if (!arrayList.isEmpty()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ImageView imageView2 = arrayList.get(i);
                    if (imageView == null || (imageView2.getWidth() > imageView.getWidth() && imageView2.getHeight() > imageView.getHeight())) {
                        imageView = imageView2;
                    }
                }
            }
        }
        return imageView;
    }

    private void c(final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final List<View> list4) {
        x.uj(new Runnable() { // from class: com.byazt.kyz.ve.4
            @Override // java.lang.Runnable
            public void run() {
                int i;
                try {
                    View viewTt = ve.this.tt(viewGroup);
                    if (ve.tt((List<View>) list2, viewTt)) {
                        i = 1;
                    } else if (ve.tt((List<View>) list3, viewTt)) {
                        i = 2;
                    } else if (ve.tt((List<View>) list4, viewTt)) {
                        i = 3;
                    } else {
                        i = ve.tt((List<View>) list, viewTt) ? 4 : 0;
                    }
                    com.byazt.ukr.yp.c().c(ve.this.tt, ve.this.sp, i, viewTt);
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        });
    }

    private static boolean c(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null) {
            if (viewGroup == view) {
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt == view) {
                    return true;
                }
                if (childAt instanceof ViewGroup) {
                    return c((ViewGroup) childAt, view);
                }
            }
        }
        return false;
    }

    private void ve() {
        com.byazt.lsp.ve veVar;
        if (this.da == null) {
            com.byazt.lsp.ve veVar2 = this.my;
            if (veVar2 != null) {
                veVar2.c(this.sl, this.i.x(), this.i.i(), false);
                return;
            }
            return;
        }
        if (this.nu.get() && (veVar = this.my) != null) {
            veVar.c(this.t, this.z, this.m, this.rh.get());
        } else {
            this.da.setExpressInteractionListener(new com.byazt.ft.tt(null) { // from class: com.byazt.kyz.ve.2
                @Override // com.byazt.ft.tt
                public void c(View view, int i) {
                    com.byazt.rgb.tt.ve(ve.this.getLifecycleId());
                    if (ve.this.gt != null) {
                        ve.this.gt.c(view, ve.this);
                    }
                }

                @Override // com.byazt.ft.tt
                public void tt(View view, int i) {
                    com.byazt.rgb.tt.c(ve.this.getLifecycleId(), false);
                    if (ve.this.gt != null) {
                        ve.this.gt.c(ve.this);
                    }
                    if (ve.this.yv != null && ve.this.yv.c() != null) {
                        ve.this.yv.c().uj();
                    }
                    if (!ve.this.tt.yv() || ve.this.tt.yp() == null) {
                        return;
                    }
                    com.byazt.yxu.c.c().c(ve.this.ve, ve.this.tt.yp().tt());
                }

                @Override // com.byazt.ft.tt
                public void c(View view, String str, int i) {
                    ve.this.nu.set(true);
                    ve veVar3 = ve.this;
                    veVar3.t = veVar3.sl;
                    ve veVar4 = ve.this;
                    veVar4.z = veVar4.i.x();
                    ve veVar5 = ve.this;
                    veVar5.m = veVar5.i.i();
                    if (ve.this.my != null) {
                        ve.this.my.c(ve.this.sl, ve.this.i.x(), ve.this.i.i(), false);
                    }
                }

                @Override // com.byazt.ft.tt
                public void c(View view, float f, float f2) {
                    ve.this.nu.set(true);
                    ve.this.rh.set(true);
                    ve.this.t = view;
                    ve.this.z = f;
                    ve.this.m = f2;
                    if (ve.this.my != null) {
                        ve.this.my.c(view, f, f2, true);
                    }
                }
            });
            this.da.render();
        }
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.byazt.lsp.c cVar) {
        boolean z = false;
        com.byazt.nr.my.c(viewGroup != null || this.rh.get(), "container不能为null");
        com.byazt.nr.my.c(list != null || this.rh.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        com.byazt.nr.my.c(z, "clickViews数量必须大于等于1");
        this.sl = viewGroup;
        registerViewForInteraction(viewGroup, null, list, list2, view, cVar);
    }

    private void c(ViewGroup viewGroup, List<ImageView> list, UpieImageView[] upieImageViewArr) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ImageView) {
                    list.add((ImageView) childAt);
                } else if (childAt instanceof UpieImageView) {
                    upieImageViewArr[0] = (UpieImageView) childAt;
                    return;
                } else if (childAt instanceof ViewGroup) {
                    c((ViewGroup) childAt, list, upieImageViewArr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(View view) {
        this.p.c(this.sl, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(ViewGroup viewGroup, View view) {
        float fUj;
        float fUj2;
        float fUj3;
        float fUj4;
        if (viewGroup != null) {
            fUj2 = pf.uj(this.ve, viewGroup.getWidth());
            fUj = pf.uj(this.ve, viewGroup.getHeight());
        } else {
            fUj = 0.0f;
            fUj2 = 0.0f;
        }
        if (view != null) {
            fUj4 = pf.uj(this.ve, view.getWidth());
            fUj3 = pf.uj(this.ve, view.getHeight());
        } else {
            fUj3 = 0.0f;
            fUj4 = 0.0f;
        }
        boolean z = fUj2 > 0.0f && fUj > 0.0f;
        boolean z2 = fUj4 > 0.0f && fUj3 > 0.0f;
        if (z || z2) {
            ic icVar = this.tt;
            com.byazt.it.ve veVarC = com.byazt.vif.uj.c(icVar == null ? null : icVar.jl(), "ad_show_real_size");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ad_width", fUj2);
                jSONObject.put("ad_height", fUj);
                jSONObject.put("image_width", fUj4);
                jSONObject.put("image_height", fUj3);
            } catch (JSONException unused) {
            }
            veVarC.put(this.i.uj(), jSONObject.toString());
        }
    }

    private void uj() {
        if (this.sl == null || this.da == null || this.t == null) {
            return;
        }
        this.sl.removeAllViews();
        if (this.t.getParent() != null) {
            ((ViewGroup) this.t.getParent()).removeAllViews();
        }
        this.sl.addView(this.t);
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.byazt.lsp.c cVar) {
        boolean z = false;
        com.byazt.nr.my.c(viewGroup != null || this.rh.get(), "container不能为null");
        com.byazt.nr.my.c(list2 != null || this.rh.get(), "clickView不能为null");
        if (list2 != null && list2.size() > 0) {
            z = true;
        }
        com.byazt.nr.my.c(z, "clickViews数量必须大于等于1");
        this.sl = viewGroup;
        registerViewForInteraction(viewGroup, list, list2, list3, (List<View>) null, view, cVar);
    }

    private List<View> c(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.byazt.lsp.c cVar) {
        int i;
        List<View> listC = list3;
        boolean z = false;
        com.byazt.nr.my.c(viewGroup != null || this.rh.get(), "container不能为null");
        com.byazt.nr.my.c(list2 != null || this.rh.get(), "clickView不能为null");
        com.byazt.nr.my.c(list2 != null && list2.size() > 0, "clickViews数量必须大于等于1");
        this.sl = viewGroup;
        this.gt = cVar;
        if (listC != null && list3.size() > 0) {
            z = true;
        }
        c(z);
        if (tt()) {
            listC = c(list2, listC);
        }
        List<View> list5 = listC;
        if (this.rh.get() && ((i = this.sp) == 5 || i == 1 || i == 9)) {
            uj();
        }
        if (!this.rh.get()) {
            my myVar = this.c;
            if (myVar != null) {
                myVar.c(this.h);
                this.c.c(viewGroup, list, list2, list5, list4, view, cVar, this.eo);
            }
            c(viewGroup);
        }
        sp spVar = this.n;
        if (spVar instanceof com.byazt.dyf.tt) {
            ((com.byazt.dyf.tt) spVar).setMonitorView(this.sl);
        }
        if (!gt.tt().da() || ic.ve(this.tt) || CreativeContainer.c(this.tt)) {
            return;
        }
        c(viewGroup, list, list2, list5, list4);
    }

    private boolean tt() {
        ic icVar = this.tt;
        if (icVar == null || icVar.i() == 5) {
            return false;
        }
        if (this.x == 0) {
            this.x = nb.t(this.tt);
        }
        return gt.tt().sp(this.x) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        com.byazt.sy.sp spVarC = this.yv.c();
        if (spVarC != null) {
            spVarC.uj();
        }
        if (view instanceof NativeVideoTsView) {
            ((NativeVideoTsView) view).setEasyPlayableEventSender(spVarC);
        }
        this.yv.c(this.sl, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(boolean z) {
        NativeVideoTsView nativeVideoTsView = (this.zm == null || this.zm.get() == null) ? null : this.zm.get();
        if (nativeVideoTsView == null) {
            return;
        }
        nativeVideoTsView.tt(z, true);
        nativeVideoTsView.setIsQuiet(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View c() {
        if (ic.ve(this.tt)) {
            if (this.zm == null || this.zm.get() == null) {
                return null;
            }
            NativeVideoTsView nativeVideoTsView = this.zm.get();
            ic icVar = this.tt;
            if (icVar == null) {
                return nativeVideoTsView;
            }
            rl.tt(icVar.lw(), nativeVideoTsView, NativeVideoTsView.class);
            return nativeVideoTsView;
        }
        return tt(this.sl);
    }

    public void c(ViewGroup viewGroup) {
        if (viewGroup != null && this.gr && com.byazt.bzd.t.c(this.tt)) {
            NativeVideoTsView nativeVideoTsViewVe = ve(viewGroup);
            if (nativeVideoTsViewVe != null) {
                if (5 == this.sp) {
                    nativeVideoTsViewVe.setIsAutoPlay(this.u ? this.i.n() : this.yp);
                    return;
                } else {
                    nativeVideoTsViewVe.setIsAutoPlay(this.yp);
                    return;
                }
            }
            NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.ve, this.tt, false, false, nb.tt(this.sp), false, false);
            if (5 == this.sp) {
                nativeVideoTsView.setIsAutoPlay(this.u ? this.i.n() : this.yp);
            } else {
                nativeVideoTsView.setIsAutoPlay(this.yp);
            }
            nativeVideoTsView.setTag("ado_tag");
            nativeVideoTsView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            viewGroup.addView(nativeVideoTsView);
        }
    }

    private void c(Activity activity) {
        Context context = this.ve;
        Context context2 = activity;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            context2 = activity;
            context2 = this.ve;
        }
        context2 = activity;
        com.byazt.dyf.tt ttVar = new com.byazt.dyf.tt(context2, this.tt.wq(), c(this.sp), false, com.byazt.xky.tt.c()) { // from class: com.byazt.kyz.ve.10
            @Override // com.byazt.dyf.tt, com.byazt.nc.sp
            public void setDislikeInteractionCallback(final com.byazt.dhf.c cVar) {
                setDislikeInteractionCallback(new com.byazt.dyf.tt.c() { // from class: com.byazt.kyz.ve.10.1
                    @Override // com.byazt.dyf.tt.c
                    public void c() {
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.c();
                        }
                    }

                    @Override // com.byazt.dyf.tt.c
                    public void tt() {
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.tt();
                        }
                    }

                    @Override // com.byazt.dyf.tt.c
                    public void c(int i, String str, boolean z) {
                        com.byazt.rgb.tt.ve(ve.this.getLifecycleId(), 1);
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.c(i, str, z);
                        }
                    }
                });
            }
        };
        this.n = ttVar;
        com.byazt.tl.ve.c(context2, this.tt, ttVar);
        ic icVar = this.tt;
        if (icVar != null) {
            rl.tt(icVar.lw(), this.n, com.byazt.dyf.tt.class);
        }
    }

    private void c(boolean z) {
        com.byazt.ukr.yp.c().c(this.sp, this.tt, z);
    }

    private yp c(ic icVar) {
        ic icVar2 = this.tt;
        if (icVar2 == null || pu.c(icVar2) != 2) {
            return null;
        }
        boolean z = xd.z(icVar) != null;
        int i = this.sp;
        if (i == 1) {
            if (z) {
                return new com.byazt.tp.ve(this.ve, icVar, this.i);
            }
            return new com.byazt.tp.tt(this.ve, icVar, this.i);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new com.byazt.ouz.gr(this.ve, icVar, this.i, i);
        }
        if (z) {
            return new zm(this.ve, icVar, this.i, i);
        }
        return new gu(this.ve, icVar, this.i, i);
    }

    private void c(Dialog dialog) {
        if (dialog == null) {
            m.ve("dialog is null, please check");
        } else {
            this.uj = dialog;
        }
    }
}
