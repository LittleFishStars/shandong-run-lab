package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.ShowWindowModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.fastjson.JSON;
import java.io.ObjectStreamException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m2 {
    public static View c = null;
    public static WindowManager d = null;
    public static String e = "MainService";
    public static m2 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f23083a;
    public AccessiblityModel b;

    public static m2 a() {
        if (f == null) {
            synchronized (m2.class) {
                if (f == null) {
                    f = new m2();
                }
            }
        }
        return f;
    }

    public final Object b() throws ObjectStreamException {
        return f;
    }

    public void c(Service service, AccessiblityModel accessiblityModel, com.acse.ottn.service.a.u0 u0Var) {
        if (accessiblityModel == null || accessiblityModel.getData() == null || TextUtils.isEmpty(accessiblityModel.getData().getPackage_name())) {
            return;
        }
        h2.a(e, "开始显示弹框=" + accessiblityModel.toString());
        if (accessiblityModel.getData().getPackage_name().equals(o.c().S)) {
            a(service, R.layout.video_aiqiyi_background);
            com.acse.ottn.service.a.b().k(service, c, accessiblityModel, u0Var);
            this.f23083a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(o.c().M)) {
            a(service, R.layout.youku_background);
            com.acse.ottn.service.a.b().n(service, c, accessiblityModel, u0Var);
            this.f23083a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(o.c().L)) {
            a(service, R.layout.tencent_background);
            com.acse.ottn.service.a.b().j(service, c, accessiblityModel, u0Var);
            this.f23083a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(o.c().q)) {
            a(service, R.layout.baidu_wnagpan_background);
            com.acse.ottn.service.a.b().a(service, c, accessiblityModel, u0Var);
            this.f23083a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(o.c().s)) {
            a(service, R.layout.kfc_background);
            com.acse.ottn.service.a.b().f(service, c, accessiblityModel, u0Var);
            this.f23083a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(o.c().r)) {
            a(service, R.layout.hxz_shop_big_background);
            com.acse.ottn.service.a.b().H(service, c, accessiblityModel, u0Var);
            this.f23083a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(o.c().Q)) {
            h2.a(e, "xbk大图");
            a(accessiblityModel.getData().getPackage_name());
            a(service, R.layout.xbk_background);
            com.acse.ottn.service.a.b().D(service, c, accessiblityModel, u0Var);
            this.f23083a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(o.c().n)) {
            a(service, R.layout.xhs_main_background);
            com.acse.ottn.service.a.b().m(service, c, accessiblityModel, u0Var);
            this.f23083a.height = -1;
        } else {
            h2.a(e, "show setGoodData");
            b(service, accessiblityModel, u0Var);
        }
        h2.a(e, "show view   CommonUtil.isShowConpunInfor= " + l0.e);
        if (l0.e) {
            try {
                h2.a(e, "show view");
                d.addView(c, this.f23083a);
                if (accessiblityModel.getData().getPlay_audio() == 1) {
                    HelpShopAppUtil.playVideo(service);
                }
            } catch (Exception e2) {
                h2.a(e, "添加失败 e=" + e2.getMessage());
            }
        }
    }

    public final void b(Service service, AccessiblityModel accessiblityModel, com.acse.ottn.service.a.u0 u0Var) {
        if (accessiblityModel == null || accessiblityModel.getData() == null || TextUtils.isEmpty(accessiblityModel.getData().getPackage_name())) {
            return;
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getCoupon_type()) && "1".equals(accessiblityModel.getData().getCoupon_type())) {
            if (accessiblityModel.getData().getPackage_name().equals(o.c().t) || accessiblityModel.getData().getPackage_name().equals(o.c().u)) {
                if ("1".equals(accessiblityModel.getData().getPic_type())) {
                    h2.a(e, "taobao礼金大图");
                    a(service, R.layout.tb_lijin_big_background);
                    com.acse.ottn.service.a.b().B(service, c, accessiblityModel, u0Var);
                    this.f23083a.height = -1;
                    return;
                }
                a(accessiblityModel.getData().getPackage_name());
                h2.a(e, "淘宝大图");
                a(service, R.layout.taobao_old_big_background);
                com.acse.ottn.service.a.b().z(service, c, accessiblityModel, u0Var);
                this.f23083a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(o.c().w)) {
                if ("1".equals(accessiblityModel.getData().getPic_type())) {
                    h2.a(e, "jd礼金大图");
                    a(service, R.layout.jd_lijin_big_background);
                    com.acse.ottn.service.a.b().J(service, c, accessiblityModel, u0Var);
                    this.f23083a.height = -1;
                    return;
                }
                h2.a(e, "jd大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.jd_shop_big_background);
                com.acse.ottn.service.a.b().I(service, c, accessiblityModel, u0Var);
                this.f23083a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(o.c().J) || accessiblityModel.getData().getPackage_name().equals(o.c().N) || accessiblityModel.getData().getPackage_name().equals(o.c().l)) {
                h2.a(e, "mt大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.meituan_big_background);
                com.acse.ottn.service.a.b().y(service, c, accessiblityModel, u0Var);
                this.f23083a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(o.c().m)) {
                h2.a(e, "tb FZ大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.tbfz_shop_big_background);
                com.acse.ottn.service.a.b().u(service, c, accessiblityModel, u0Var);
                this.f23083a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(o.c().O) || accessiblityModel.getData().getPackage_name().equals(o.c().R)) {
                h2.a(e, "eleme大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.eleme_shop_big_background);
                com.acse.ottn.service.a.b().E(service, c, accessiblityModel, u0Var);
                this.f23083a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(o.c().x)) {
                h2.a(e, "京东外卖大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.jdwm_shop_big_background);
                com.acse.ottn.service.a.b().v(service, c, accessiblityModel, u0Var);
                this.f23083a.height = -1;
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(o.c().K)) {
                h2.a(e, "didi大图");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.didi_big_background);
                this.f23083a.height = -1;
                com.acse.ottn.service.a.b().s(service, c, accessiblityModel, u0Var);
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(o.c().U)) {
                a(service, R.layout.video_taobao_main_background);
                com.acse.ottn.service.a.b().b(service, c, accessiblityModel, u0Var);
                this.f23083a.height = -1;
                return;
            }
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().t) || accessiblityModel.getData().getPackage_name().equals(o.c().u)) {
            if ("1".equals(accessiblityModel.getData().getPic_type())) {
                h2.a(e, "taobao礼金图");
                a(service, R.layout.tb_lj_smile_background);
                com.acse.ottn.service.a.b().A(service, c, accessiblityModel, u0Var);
                this.f23083a.height = -1;
                return;
            }
            h2.a(e, "tb小图");
            this.f23083a.height = x0.a((Context) service, 320.0f);
            a(service, R.layout.shop_smile_background);
            com.acse.ottn.service.a.b().C(service, c, accessiblityModel, u0Var);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().w)) {
            h2.a(e, "jd小图");
            a(service, R.layout.jd_shop_smile_background);
            com.acse.ottn.service.a.b().K(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().J) || accessiblityModel.getData().getPackage_name().equals(o.c().N) || accessiblityModel.getData().getPackage_name().equals(o.c().l)) {
            h2.a(e, "mt小图");
            a(service, R.layout.meituan_smile_background);
            com.acse.ottn.service.a.b().x(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().m)) {
            h2.a(e, "tb FZ小图");
            a(service, R.layout.tbfz_smile_background);
            com.acse.ottn.service.a.b().G(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().O) || accessiblityModel.getData().getPackage_name().equals(o.c().R)) {
            h2.a(e, "eleme小图");
            a(service, R.layout.eleme_smile_background);
            com.acse.ottn.service.a.b().F(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().x)) {
            h2.a(e, "京东小图");
            a(service, R.layout.jdwm_smile_background);
            com.acse.ottn.service.a.b().w(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().K)) {
            h2.a(e, "didi小图");
            a(service, R.layout.didi_smile_background);
            com.acse.ottn.service.a.b().t(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().y)) {
            h2.a(e, "美团鲜花");
            a(service, R.layout.mt_xh_smile_background);
            com.acse.ottn.service.a.b().o(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().A)) {
            h2.a(e, "美团医药");
            a(service, R.layout.mt_yy_smile_background);
            com.acse.ottn.service.a.b().q(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().B)) {
            h2.a(e, "美团酒店");
            a(service, R.layout.mt_hotel_smile_background);
            com.acse.ottn.service.a.b().p(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().D)) {
            h2.a(e, "美团超市");
            a(service, R.layout.mt_shop_smile_background);
            com.acse.ottn.service.a.b().r(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().F)) {
            h2.a(e, "咸鱼");
            a(service, R.layout.idlefish_smile_background);
            com.acse.ottn.service.a.b().d(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().G)) {
            h2.a(e, "闪购");
            a(service, R.layout.shangou_smile_background);
            com.acse.ottn.service.a.b().h(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().T)) {
            h2.a(e, "淘宝首页");
            a(service, R.layout.tb_home_smile_background);
            com.acse.ottn.service.a.b().i(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().W)) {
            h2.a(e, "jd首页");
            a(service, R.layout.jd_home_smile_background);
            com.acse.ottn.service.a.b().e(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().o) || accessiblityModel.getData().getPackage_name().equals(o.c().p)) {
            h2.a(e, "快手和快手极速版");
            a(service, R.layout.ks_smile_background);
            com.acse.ottn.service.a.b().g(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().b0)) {
            h2.a(e, "唯品会");
            a(service, R.layout.wph_smile_background);
            com.acse.ottn.service.a.b().l(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(o.c().U)) {
            a(service, R.layout.custom_smile_background);
            com.acse.ottn.service.a.b().c(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
        }
    }

    public final void a(Service service, int i) {
        h2.a(e, "setLayoutView ");
        try {
            if (!h4.a().a(service)) {
                service = (AccessibilityService) service;
            }
            View viewInflate = LayoutInflater.from(service.getApplication()).inflate(i, (ViewGroup) null);
            c = viewInflate;
            viewInflate.measure(0, 0);
        } catch (Exception e2) {
            h2.a(e, "setLayoutView e = " + e2.getMessage());
        }
    }

    public final void a(String str) {
        String strE;
        ShowWindowModel showWindowModel;
        String str2 = str + "pic_type";
        h2.a("ShopHelperService", "isShowBigPicture ");
        if (n3.a() != null) {
            strE = n3.a().e(str2);
            h2.a("MainServiceShowUtil", " ---samon QuickPreference.getInstance() jsondata=" + strE);
        } else {
            strE = "";
        }
        if (!TextUtils.isEmpty(strE) && strE != null) {
            showWindowModel = (ShowWindowModel) JSON.parseObject(strE, ShowWindowModel.class);
            h2.a("MainServiceShowUtil", "isShowBigPicture ---samon jsondata= " + strE);
            h2.a("MainServiceShowUtil", "isShowBigPicture ---samon label1= " + showWindowModel.toString());
        } else {
            showWindowModel = new ShowWindowModel();
            h2.a("MainServiceShowUtil", "isShowBigPicture ---samon jsondata= is null");
            h2.a("MainServiceShowUtil", "isShowBigPicture ---samon label1= " + showWindowModel.toString());
        }
        showWindowModel.setAppName(str2);
        String strA = s0.d().a();
        h2.a("MainServiceShowUtil", "isShowBigPicture ---samon label2 = " + showWindowModel.toString());
        h2.a("MainServiceShowUtil", "isShowBigPicture ---samon date= " + strA);
        if (showWindowModel.getShowBigWindowData().equals(strA)) {
            return;
        }
        showWindowModel.setShowBigWindowData(strA);
        h2.a("MainServiceShowUtil", "isShowBigPicture ---samon label3 = " + showWindowModel.toString());
        String jSONString = JSON.toJSONString(showWindowModel);
        h2.a("MainServiceShowUtil", "isShowBigPicture ---samon  str= " + jSONString);
        if (n3.a() != null) {
            n3.a().b(str2, jSONString);
            h2.a("MainServiceShowUtil", "isShowBigPicture ---samon  jsondata= is null");
            h2.a("MainServiceShowUtil", " ---samon s= " + n3.a().e(str2));
        }
    }

    public void a(Service service) {
        this.f23083a = new WindowManager.LayoutParams();
        if (h4.a().a(service)) {
            d = (WindowManager) service.getApplication().getSystemService("window");
            WindowManager.LayoutParams layoutParams = this.f23083a;
            layoutParams.type = 2038;
            layoutParams.flags = 8;
        } else {
            d = (WindowManager) service.getSystemService("window");
            WindowManager.LayoutParams layoutParams2 = this.f23083a;
            layoutParams2.type = 2032;
            layoutParams2.flags = 800;
        }
        WindowManager.LayoutParams layoutParams3 = this.f23083a;
        layoutParams3.format = 1;
        layoutParams3.windowAnimations = android.R.style.Animation.Translucent;
        layoutParams3.gravity = 51;
        layoutParams3.x = 0;
        layoutParams3.y = 0;
        layoutParams3.width = -1;
    }

    public void a(Service service, String str, com.acse.ottn.service.a.u0 u0Var) {
        h2.c(e, "noShowCoupon ");
        try {
            d.removeView(c);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(service, R.layout.coupon_no_showbackground);
            com.acse.ottn.service.a.b().a(c, str, true, u0Var);
            WindowManager.LayoutParams layoutParams = this.f23083a;
            layoutParams.height = -2;
            d.addView(c, layoutParams);
        } catch (Exception e2) {
            h2.c(e, "noShowCoupon e=" + e2.getMessage());
        }
    }

    public void a(Service service, AccessiblityModel accessiblityModel, com.acse.ottn.service.a.u0 u0Var) {
        if (accessiblityModel == null || accessiblityModel.getData() == null) {
            return;
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getCoupon_type()) && "1".equals(accessiblityModel.getData().getCoupon_type())) {
            a(service, R.layout.video_taobao_main_background);
            com.acse.ottn.service.a.b().b(service, c, accessiblityModel, u0Var);
            this.f23083a.height = -1;
        } else {
            a(service, R.layout.custom_smile_background);
            com.acse.ottn.service.a.b().c(service, c, accessiblityModel, u0Var);
            this.f23083a.height = x0.a((Context) service, 320.0f);
        }
        if (l0.e) {
            try {
                h2.a(e, "show view");
                d.addView(c, this.f23083a);
                if (accessiblityModel.getData().getPlay_audio() == 1) {
                    HelpShopAppUtil.playVideo(service);
                }
            } catch (Exception e2) {
                h2.a(e, "添加失败 e=" + e2.getMessage());
            }
        }
    }

    public void b(Service service) {
        try {
            View view = c;
            if (view != null) {
                view.setVisibility(8);
            }
            d.removeView(c);
            if (!h4.a().a(service)) {
                service = (AccessibilityService) service;
            }
            service.stopSelf();
        } catch (Exception e2) {
            h2.a(e, "dismiss e=" + e2.getMessage());
        }
    }
}
