package com.byazt.ouz;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.un.NativeVideoTsView;
import com.byazt.xv.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 2140})
public abstract class BackupView extends FrameLayout implements com.byazt.xv.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28915a;
    public Context c;
    public boolean da;
    public boolean i;
    public String n;
    public String sl;
    public int sp;
    public com.byazt.ua.c t;
    public ic tt;
    public NativeVideoTsView u;
    public Dialog uj;
    public com.byazt.dyf.tt ve;
    public int x;

    public BackupView(Context context) {
        super(context);
        this.n = com.byazt.dyf.tt.AD_TAG_FEED;
        this.i = true;
        this.da = true;
        this.t = new com.byazt.ua.c();
        tt();
    }

    private boolean n() {
        return TextUtils.equals(this.n, "splash_ad") || TextUtils.equals(this.n, "cache_splash_ad");
    }

    private void tt() {
        setTag("tt_express_backup_fl_tag_26");
    }

    private boolean uj() {
        com.byazt.jzl.uj ujVarZ;
        ic icVar = this.tt;
        return (icVar == null || icVar.w() == 1 || (ujVarZ = xd.z(this.tt)) == null || TextUtils.isEmpty(ujVarZ.getVideo_url())) ? false : true;
    }

    private boolean ve() {
        if (n()) {
            return uj();
        }
        ic icVar = this.tt;
        return icVar != null && ic.ve(icVar);
    }

    @Override // com.byazt.xv.c
    public void b_(int i) {
    }

    public void c() {
        Dialog dialog = this.uj;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.byazt.dyf.tt ttVar = this.ve;
        if (ttVar != null) {
            ttVar.showDislikeDialog();
        } else {
            TTDelegateActivity.c(getContext(), this.tt);
        }
    }

    public abstract void c(View view, int i, com.byazt.ete.gr grVar);

    public String getDescription() {
        if (TextUtils.isEmpty(this.tt.v_())) {
            return !TextUtils.isEmpty(this.tt.op()) ? this.tt.op() : "";
        }
        return this.tt.v_();
    }

    public ic getMeta() {
        return this.tt;
    }

    public String getNameOrSource() {
        ic icVar = this.tt;
        if (icVar == null) {
            return "";
        }
        if (icVar.z() == null || TextUtils.isEmpty(this.tt.z().ve())) {
            return !TextUtils.isEmpty(this.tt.an()) ? this.tt.an() : "";
        }
        return this.tt.z().ve();
    }

    public float getRealHeight() {
        return pf.uj(this.c, this.sp);
    }

    public float getRealWidth() {
        return pf.uj(this.c, this.f28915a);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public String getTitle() {
        if (this.tt.z() != null && !TextUtils.isEmpty(this.tt.z().ve())) {
            return this.tt.z().ve();
        }
        if (TextUtils.isEmpty(this.tt.an())) {
            return !TextUtils.isEmpty(this.tt.v_()) ? this.tt.v_() : "";
        }
        return this.tt.an();
    }

    public com.byazt.ua.c getVideoModel() {
        return this.t;
    }

    public void setDislikeInner(com.byazt.nc.sp spVar) {
        if (spVar instanceof com.byazt.dyf.tt) {
            this.ve = (com.byazt.dyf.tt) spVar;
        }
    }

    public void setDislikeOuter(Dialog dialog) {
        this.uj = dialog;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setThemeChangeReceiver(ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        if (themeStatusBroadcastReceiver == null) {
            return;
        }
        themeStatusBroadcastReceiver.c(this);
    }

    public void tt(int i) {
        this.da = this.tt.ab() == 1;
        int iA = com.byazt.omf.gt.tt().a(i);
        if (3 == iA) {
            this.i = false;
            return;
        }
        if (1 != iA || !com.byazt.nr.rh.uj(this.c)) {
            if (2 == iA) {
                if (com.byazt.nr.rh.n(this.c) || com.byazt.nr.rh.uj(this.c) || com.byazt.nr.rh.a(this.c)) {
                    this.i = true;
                    return;
                }
                return;
            }
            if (5 != iA) {
                return;
            }
            if (!com.byazt.nr.rh.uj(this.c) && !com.byazt.nr.rh.a(this.c)) {
                return;
            }
        }
        this.i = true;
    }

    public void c(View view, boolean z) {
        final com.byazt.hkv.tt ttVar;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.c;
            ic icVar = this.tt;
            String str = this.n;
            ttVar = new com.byazt.hkv.c(context, icVar, str, nb.uj(str));
        } else {
            Context context2 = this.c;
            ic icVar2 = this.tt;
            String str2 = this.n;
            ttVar = new com.byazt.hkv.tt(context2, icVar2, str2, nb.uj(str2));
        }
        view.setOnTouchListener(ttVar);
        view.setOnClickListener(ttVar);
        ve veVar = new ve() { // from class: com.byazt.ouz.BackupView.1
            @Override // com.byazt.ouz.ve
            public void c(View view2, int i, com.byazt.ete.gr grVar) {
                try {
                    grVar.c().put("click_extra_map", ((com.byazt.vis.c) ttVar.c(com.byazt.vis.c.class)).n());
                } catch (JSONException unused) {
                }
                BackupView.this.c(view2, i, grVar);
            }
        };
        com.byazt.wdw.c cVar = (com.byazt.wdw.c) ttVar.c(com.byazt.wdw.c.class);
        if (cVar != null) {
            cVar.c(veVar);
            cVar.c(z ? 2 : 1);
        }
    }

    public View c(final NativeExpressView nativeExpressView) {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2 = this.u;
        if (nativeVideoTsView2 != null) {
            return nativeVideoTsView2;
        }
        if (this.tt != null && this.c != null) {
            if (ve()) {
                try {
                    NativeVideoTsView nativeVideoTsViewC = c(this.c, this.tt, this.n, true, false);
                    this.u = nativeVideoTsViewC;
                    nativeVideoTsViewC.setAdCreativeClickListener(new NativeVideoTsView.c() { // from class: com.byazt.ouz.BackupView.2
                        @Override // com.byazt.un.NativeVideoTsView.c
                        public void c(View view, int i) {
                            c expressInteractionListener = nativeExpressView.getExpressInteractionListener();
                            if (expressInteractionListener == null) {
                                return;
                            }
                            expressInteractionListener.c(view, i);
                        }
                    });
                    this.u.setVideoCacheUrl(this.sl);
                    this.u.setControllerStatusCallBack(new NativeVideoTsView.uj() { // from class: com.byazt.ouz.BackupView.3
                        @Override // com.byazt.un.NativeVideoTsView.uj
                        public void c(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                            com.byazt.ua.c cVar = BackupView.this.t;
                            cVar.c = z;
                            cVar.n = j;
                            cVar.f29083a = j2;
                            cVar.sp = j3;
                            cVar.uj = z2;
                            cVar.x = z3;
                        }
                    });
                    this.u.setIsAutoPlay(this.i);
                    this.u.setIsQuiet(this.da);
                } catch (Throwable unused) {
                    this.u = null;
                }
            }
            if (ve() && (nativeVideoTsView = this.u) != null && nativeVideoTsView.c(0L, true, false)) {
                return this.u;
            }
        }
        return null;
    }

    public NativeVideoTsView c(Context context, ic icVar, String str, boolean z, boolean z2) {
        return new NativeVideoTsView(context, icVar, str, z, z2);
    }

    public void c(View view) {
        if (xd.z(this.tt) == null || view == null) {
            return;
        }
        c(view, this.tt.vp() == 1 && this.i);
    }
}
