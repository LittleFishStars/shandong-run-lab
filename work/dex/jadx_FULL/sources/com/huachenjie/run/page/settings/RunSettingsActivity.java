package com.huachenjie.run.page.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.RxViewUtil;
import com.huachenjie.common.widget.DividerLayoutDecoration;
import com.huachenjie.run.R;
import com.huachenjie.run.adapter.GuideGalleryAdapter;
import com.zj.adlib.jj8;
import com.zj.adlib.om2;
import com.zj.adlib.vo6;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.g)
public class RunSettingsActivity extends BaseActivity {
    public static final int L = 10010;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView H;
    public TextView I;
    public TextView J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f35939a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GuideGalleryAdapter f12510a;
    public GuideGalleryAdapter b;
    public RecyclerView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public List<Integer> f12511c;
    public List<Integer> d;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0() {
        vo6.n(((BaseActivity) this).c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0() {
        vo6.m(((BaseActivity) this).c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0() {
        vo6.i(((BaseActivity) this).c, 10010);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int U() {
        return R.drawable.ic_back_white;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int Y() {
        return R.color.color_373b4e;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int b0() {
        return R.color.color_373b4e;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return R.layout.run_activity_settings;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void h0() {
        e.p3(this).d3(((BaseActivity) this).f8486a).T2(true).u1(R.color.white).G1(true).a1();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(Intent intent) {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
        this.f12510a = new GuideGalleryAdapter();
        this.b = new GuideGalleryAdapter();
        this.f12511c = new ArrayList();
        this.d = new ArrayList();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
        i0(getString(R.string.run_setting));
        ((BaseActivity) this).f8486a.setBackgroundColor(ContextCompat.getColor(((BaseActivity) this).c, R.color.white));
        this.p.setTextColor(-16777216);
        Drawable drawable = ContextCompat.getDrawable(((BaseActivity) this).f8485a, R.drawable.ic_back_black);
        if (drawable != null) {
            drawable.setTint(zn1.a(R.color.black));
        }
        ((BaseActivity) this).f8491d.setImageDrawable(drawable);
        this.H = (TextView) S(R.id.tv_bg_keep_live_entry);
        this.I = (TextView) S(R.id.tv_anti_sleep_entry);
        this.J = (TextView) S(R.id.tv_bettery_white_order_entry);
        RxViewUtil.f(this.H, 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.sm7
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                this.f44717a.r0();
            }
        });
        RxViewUtil.f(this.I, 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.tm7
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                this.f44953a.s0();
            }
        });
        RxViewUtil.f(this.J, 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.um7
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                this.f45178a.t0();
            }
        });
        this.D = (TextView) S(R.id.tv_keep_wifi_tip);
        this.E = (TextView) S(R.id.tv_bg_keep_live_click_tips);
        this.F = (TextView) S(R.id.tv_anti_sleep_click_tips);
        this.f35939a = (RecyclerView) S(R.id.recycler_keep_live_guide);
        this.c = (RecyclerView) S(R.id.recycler_anti_sleep_guide);
        this.D.setText(R.string.run_keep_wifi_tip);
        q0();
        p0();
        o0();
    }

    public final void o0() {
        this.J.setText(vo6.d(((BaseActivity) this).c) ? R.string.set_already : R.string.run_quick_setting);
        this.J.setEnabled(!vo6.d(((BaseActivity) this).c));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10010) {
            o0();
        }
    }

    public final void p0() {
        switch (om2.a()) {
            case 1:
                this.f12511c.clear();
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_xiaomi_keep_live1));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_xiaomi_keep_live2));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_xiaomi_keep_live3));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_xiaomi_keep_live4));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_xiaomi_keep_live5));
                this.d.clear();
                this.d.add(Integer.valueOf(R.drawable.run_img_xiaomi_anti_sleep1));
                this.d.add(Integer.valueOf(R.drawable.run_img_xiaomi_anti_sleep2));
                this.d.add(Integer.valueOf(R.drawable.run_img_xiaomi_anti_sleep3));
                this.d.add(Integer.valueOf(R.drawable.run_img_xiaomi_anti_sleep4));
                this.d.add(Integer.valueOf(R.drawable.run_img_xiaomi_anti_sleep5));
                this.d.add(Integer.valueOf(R.drawable.run_img_xiaomi_anti_sleep6));
                break;
            case 2:
                this.f12511c.clear();
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_huawei_keep_live1));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_huawei_keep_live2));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_huawei_keep_live3));
                this.d.clear();
                this.d.add(Integer.valueOf(R.drawable.run_img_huawei_anti_sleep1));
                this.d.add(Integer.valueOf(R.drawable.run_img_huawei_anti_sleep2));
                this.d.add(Integer.valueOf(R.drawable.run_img_huawei_anti_sleep3));
                this.d.add(Integer.valueOf(R.drawable.run_img_huawei_anti_sleep4));
                break;
            case 3:
                this.f12511c.clear();
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_vivo_keep_live1));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_vivo_keep_live2));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_vivo_keep_live3));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_vivo_keep_live4));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_vivo_keep_live5));
                this.d.clear();
                this.d.add(Integer.valueOf(R.drawable.run_img_vivo_anti_sleep1));
                this.d.add(Integer.valueOf(R.drawable.run_img_vivo_anti_sleep2));
                this.d.add(Integer.valueOf(R.drawable.run_img_vivo_anti_sleep3));
                this.d.add(Integer.valueOf(R.drawable.run_img_vivo_anti_sleep4));
                break;
            case 4:
                this.f12511c.clear();
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_oppo_keep_live1));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_oppo_keep_live2));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_oppo_keep_live3));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_oppo_keep_live4));
                this.d.clear();
                this.d.add(Integer.valueOf(R.drawable.run_img_oppo_anti_sleep1));
                this.d.add(Integer.valueOf(R.drawable.run_img_oppo_anti_sleep2));
                this.d.add(Integer.valueOf(R.drawable.run_img_oppo_anti_sleep3));
                this.d.add(Integer.valueOf(R.drawable.run_img_oppo_anti_sleep4));
                break;
            case 5:
                this.f12511c.clear();
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_meizu_keep_live1));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_meizu_keep_live2));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_meizu_keep_live3));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_meizu_keep_live4));
                this.f12511c.add(Integer.valueOf(R.drawable.run_img_meizu_keep_live5));
                this.d.clear();
                break;
            case 6:
                this.f12511c.clear();
                this.d.clear();
                this.d.add(Integer.valueOf(R.drawable.run_img_oneplus_anti_sleep1));
                this.d.add(Integer.valueOf(R.drawable.run_img_oneplus_anti_sleep2));
                this.d.add(Integer.valueOf(R.drawable.run_img_oneplus_anti_sleep3));
                this.d.add(Integer.valueOf(R.drawable.run_img_oneplus_anti_sleep4));
                this.d.add(Integer.valueOf(R.drawable.run_img_oneplus_anti_sleep5));
                break;
            default:
                this.f12511c.clear();
                this.d.clear();
                break;
        }
        List<Integer> list = this.f12511c;
        if (list == null || list.isEmpty()) {
            this.f35939a.setVisibility(8);
            this.E.setVisibility(8);
        } else {
            this.f35939a.setVisibility(0);
            this.E.setVisibility(0);
            this.f12510a.setList(this.f12511c);
        }
        List<Integer> list2 = this.d;
        if (list2 == null || list2.isEmpty()) {
            this.c.setVisibility(8);
            this.F.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.F.setVisibility(0);
            this.b.setList(this.d);
        }
    }

    public final void q0() {
        this.f35939a.setLayoutManager(new LinearLayoutManager(((BaseActivity) this).c, 0, false));
        RecyclerView recyclerView = this.f35939a;
        Activity activity = ((BaseActivity) this).c;
        int iB = jj8.b(8.0f, activity);
        Resources resources = ((BaseActivity) this).c.getResources();
        int i = R.color.transparent;
        recyclerView.addItemDecoration(new DividerLayoutDecoration(activity, 0, iB, ResourcesCompat.getColor(resources, i, null)));
        this.f35939a.setAdapter(this.f12510a);
        this.c.setLayoutManager(new LinearLayoutManager(((BaseActivity) this).c, 0, false));
        RecyclerView recyclerView2 = this.c;
        Activity activity2 = ((BaseActivity) this).c;
        recyclerView2.addItemDecoration(new DividerLayoutDecoration(activity2, 0, jj8.b(8.0f, activity2), ResourcesCompat.getColor(((BaseActivity) this).c.getResources(), i, null)));
        this.c.setAdapter(this.b);
        RxViewUtil.f(this.E, 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.rm7
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                this.f44484a.u0();
            }
        });
        RxViewUtil.f(this.F, 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.rm7
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                this.f44484a.u0();
            }
        });
    }

    public final void u0() {
        ARouter.getInstance().build(RoutePathConstants.Common.c).withString("title", "").withString("url", Environment.b + "/h5/screen/setting.html?type=" + om2.a()).navigation();
    }
}
