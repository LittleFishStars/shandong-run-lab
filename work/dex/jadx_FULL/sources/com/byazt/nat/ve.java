package com.byazt.nat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.byazt.aas.nb;
import com.byazt.bzd.x;
import com.byazt.ete.ic;
import com.byazt.hv.TTDownloadField;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.omf.rl;
import com.byazt.ukr.yp;
import com.byazt.un.NativeVideoTsView;
import com.byazt.un.sp;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1196, 54})
public class ve extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28808a;
    public sp sp;
    public boolean x;

    private boolean da() {
        return this.x;
    }

    private boolean i() {
        if (this.c == null || da() || !ic.ve(this.c)) {
            return false;
        }
        if (this.f28808a == 0) {
            this.f28808a = nb.sl(this.c);
        }
        n();
        sp();
        a();
        if (this.f28808a == 5 && sl() && sp() && !n() && !a()) {
            return false;
        }
        int i = this.f28808a;
        return i == 1 || i == 2 || i == 5;
    }

    private boolean sl() {
        ic icVar = this.c;
        return icVar != null && icVar.vp() == 1 && ic.ve(this.c);
    }

    private boolean tt(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof NativeVideoTsView) || view.getId() == 2114387961 || view.getId() == 2114387664 || view.getId() == 2114387957 || view.getId() == 2114387764 || view.getId() == 2114387686 || view.getId() == 2114387626) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return false;
            }
            if (tt(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean x() {
        return i() && tt(this.uj) && !this.n.tt();
    }

    public boolean a() {
        sp spVar = this.sp;
        if (spVar == null) {
            return false;
        }
        return spVar.tt();
    }

    public boolean n() {
        sp spVar = this.sp;
        if (spVar == null) {
            return false;
        }
        return spVar.c();
    }

    public boolean sp() {
        ic icVar = this.c;
        if (icVar == null) {
            return true;
        }
        int iA = gt.tt().a(nb.t(icVar));
        if (iA == 1) {
            return rh.uj(this.tt);
        }
        if (iA == 2) {
            return rh.n(this.tt) || rh.uj(this.tt) || rh.a(this.tt);
        }
        if (iA != 3) {
            return iA != 5 || rh.uj(this.tt) || rh.a(this.tt);
        }
        return false;
    }

    @Override // com.byazt.nat.c, com.byazt.zo.c
    public int c(Map<String, Object> map, com.byazt.zo.ve veVar) {
        boolean z;
        tt(this.c.i());
        ve();
        final c.InterfaceC0470c interfaceC0470cC = this.n.c();
        x.c(new Runnable() { // from class: com.byazt.nat.ve.1
            @Override // java.lang.Runnable
            public void run() {
                c.InterfaceC0470c interfaceC0470c = interfaceC0470cC;
                if (interfaceC0470c != null) {
                    interfaceC0470c.c(ve.this.uj, ve.this.n.ve());
                }
            }
        });
        Map<String, Object> mapX = this.n.x();
        String strGr = this.ve.gr();
        if (TextUtils.isEmpty(strGr)) {
            strGr = "clickEvent";
        }
        String str = strGr;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        mapX.put("click_from_uchain", 1);
        mapX.put("event_type", str);
        nb.md();
        HashMap map2 = new HashMap();
        map2.put("material_meta", this.c);
        map2.put("click_chain", veVar);
        map2.put("dpa_tag", this.ve.gu());
        map2.put("context", this.tt);
        map2.put("event_tag", this.n.i());
        map2.put("landing_page_source", Integer.valueOf(this.n.sp()));
        map2.put("view", this.uj);
        View view = this.uj;
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            z = text != null && (text.toString().contains("下载") || text.toString().contains("安装"));
            if (this.uj instanceof Button) {
                z = true;
            }
        } else {
            z = false;
        }
        map2.put("handle_chain_data", map);
        com.byazt.pop.ve veVarA = this.n.a();
        if (veVarA != null) {
            map2.put("download_adapter", veVarA);
            map2.put("is_market_covert", Boolean.valueOf(veVarA.uj()));
            map2.put("has_show_dl_factors", Boolean.valueOf(veVarA.sp()));
            Map<String, Object> mapA = veVarA.a();
            if (mapA != null && !(mapA.get(TTDownloadField.TT_ACTIVITY) instanceof Activity) && com.byazt.ete.gt.my(this.c)) {
                try {
                    Activity activityC = com.byazt.wz.tt.c(this.uj);
                    if (activityC != null) {
                        veVarA.c(activityC, true);
                        mapA.put(TTDownloadField.TT_ACTIVITY, activityC);
                    }
                } catch (Exception e) {
                    yp.c().c("openMarketInApp", e);
                }
            }
            if (mapA != null) {
                map2.putAll(mapA);
            }
        } else {
            map2.put("has_show_dl_factors", Boolean.FALSE);
        }
        map2.put("is_click_button", Boolean.valueOf(z || this.ve.uj()));
        Map<String, Object> mapC = com.byazt.rv.c.c().c(this.c.hashCode() + this.c.qy());
        this.sp = (sp) rl.ve(this.c.lw(), sp.class);
        Object objRemove = mapC.remove("is_express_ad");
        if (objRemove instanceof Boolean) {
            this.x = ((Boolean) objRemove).booleanValue();
        }
        map2.put("is_video_lp", Boolean.valueOf(x()));
        map2.putAll(mapC);
        Boolean bool = Boolean.FALSE;
        map2.put("convert_from_downloader", bool);
        map2.put("convert_from_landing_page", Boolean.valueOf(this.n.tt()));
        map2.put("pip_controller", this.n.t());
        map2.put("open_video_detail_page_direct", Boolean.valueOf(!x() && this.n.uj()));
        map2.put("is_from_video_layout", Boolean.valueOf(this.n.da()));
        map2.put("is_open_web_page", bool);
        map2.put("is_feed_register_direct_download", Boolean.valueOf(this.ve.uj()));
        com.byazt.ppf.ve.c(this.c, mapX, str, map2, this.n.i(), new HashMap(), veVar.c());
        uj();
        return 0;
    }
}
