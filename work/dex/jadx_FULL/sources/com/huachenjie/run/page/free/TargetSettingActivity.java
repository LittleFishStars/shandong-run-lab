package com.huachenjie.run.page.free;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.camera.video.AudioStats;
import androidx.coroutines.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.baidu.location.LocationClientOption;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.google.android.material.tabs.TabLayout;
import com.hjq.permissions.Permission;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.bean.AlertTip;
import com.huachenjie.common.bean.UnfinishedRun;
import com.huachenjie.common.bean.ViewItem;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.SportConstants;
import com.huachenjie.common.permission.RequiredSettingComponent;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.util.RxViewUtil;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.common.widget.ruler.VerticalRulerView;
import com.huachenjie.run.R;
import com.huachenjie.run.adapter.TargetPagerAdapter;
import com.huachenjie.run.page.free.TargetSettingActivity;
import com.huachenjie.run.utils.StopRunUtils;
import com.kc.aw.lib.constants.BiddingConst;
import com.kc.openset.advertisers.hl.HLADNID;
import com.zj.adlib.en7;
import com.zj.adlib.fv5;
import com.zj.adlib.hb0;
import com.zj.adlib.ja1;
import com.zj.adlib.kq5;
import com.zj.adlib.lj0;
import com.zj.adlib.r90;
import com.zj.adlib.s72;
import com.zj.adlib.vo6;
import com.zj.adlib.wo2;
import com.zj.adlib.ys8;
import com.zj.adlib.zn1;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.d)
public class TargetSettingActivity extends BaseActivity<com.huachenjie.run.page.free.d> implements TargetSettingContact.TargetSettingView {
    public static final String t = "TargetSettingActivity";
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView H;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewPager f12427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TabLayout f12428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RequiredSettingComponent f12429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VerticalRulerView f12430a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TargetPagerAdapter f12431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i f12432a;
    public VerticalRulerView b;
    public List<String> c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public List<String> f12433d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public List<String> f12434e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public List<String> f12435f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f35827a = 0;
    public long d = 0;
    public long e = 0;
    public long f = 0;
    public long g = 0;
    public long j = 0;
    public long l = 0;
    public int L = 0;

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TargetSettingActivity.this.L = i;
        }
    }

    public class b implements VerticalRulerView.ScrollFinishListener {
        public b() {
        }

        @Override // com.huachenjie.common.widget.ruler.VerticalRulerView.ScrollFinishListener
        public void onScrollFinish(double scaleValue) {
            TargetSettingActivity.this.d = BigDecimal.valueOf(scaleValue).longValue();
            TargetSettingActivity.this.D.setText(BigDecimal.valueOf(TargetSettingActivity.this.d).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP).toString());
        }
    }

    public class c implements OnItemSelectedListener {
        public c() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int index) {
            TargetSettingActivity.this.e = ((long) index) * 60 * 60;
            TargetSettingActivity targetSettingActivity = TargetSettingActivity.this;
            targetSettingActivity.j = targetSettingActivity.e + TargetSettingActivity.this.f + TargetSettingActivity.this.g;
            TargetSettingActivity.this.E.setText(s72.n(TargetSettingActivity.this.j));
        }
    }

    public class d implements OnItemSelectedListener {
        public d() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int index) {
            TargetSettingActivity.this.f = ((long) index) * 60;
            TargetSettingActivity targetSettingActivity = TargetSettingActivity.this;
            targetSettingActivity.j = targetSettingActivity.e + TargetSettingActivity.this.f + TargetSettingActivity.this.g;
            TargetSettingActivity.this.E.setText(s72.n(TargetSettingActivity.this.j));
        }
    }

    public class e implements OnItemSelectedListener {
        public e() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int index) {
            TargetSettingActivity.this.g = index;
            TargetSettingActivity targetSettingActivity = TargetSettingActivity.this;
            targetSettingActivity.j = targetSettingActivity.e + TargetSettingActivity.this.f + TargetSettingActivity.this.g;
            TargetSettingActivity.this.E.setText(s72.n(TargetSettingActivity.this.j));
        }
    }

    public class f implements VerticalRulerView.ScrollFinishListener {
        public f() {
        }

        @Override // com.huachenjie.common.widget.ruler.VerticalRulerView.ScrollFinishListener
        public void onScrollFinish(double scaleValue) {
            TargetSettingActivity.this.l = BigDecimal.valueOf(scaleValue).longValue();
            TargetSettingActivity.this.F.setText(BigDecimal.valueOf(TargetSettingActivity.this.l).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP).toString());
        }
    }

    public class g implements RxViewUtil.ClickAction {
        public g() {
        }

        @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
        public void onClick() {
            TargetSettingActivity.this.f35827a = 0L;
            TargetSettingActivity.this.O0();
        }
    }

    public class h implements PermissionResultListener {
        public h() {
        }

        @Override // com.huachenjie.common.util.permission.PermissionResultListener
        public void onResult(boolean granted) {
            if (granted) {
                TargetSettingActivity.this.a1();
            }
        }
    }

    public static class i implements HCJLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<TargetSettingActivity> f35836a;

        public i(TargetSettingActivity activity) {
            if (activity != null) {
                this.f35836a = new WeakReference<>(activity);
            }
        }

        public void onLocationListener(int code, HCJAddressInfo hcjAddressInfo) {
            TargetSettingActivity targetSettingActivity;
            WeakReference<TargetSettingActivity> weakReference = this.f35836a;
            if (weakReference == null || (targetSettingActivity = weakReference.get()) == null || targetSettingActivity.isDestroyed()) {
                return;
            }
            Log.e(TargetSettingActivity.t, "location code:+" + code);
            if (hcjAddressInfo != null) {
                Log.e(TargetSettingActivity.t, "location code:+" + code + "   lat,lng:" + hcjAddressInfo.getLat() + "," + hcjAddressInfo.getLng() + "    accuracy:" + hcjAddressInfo.getAccuracy());
            }
            targetSettingActivity.Z0();
            targetSettingActivity.dismissLoadingDialogs();
            if (code != 0 || hcjAddressInfo == null) {
                targetSettingActivity.W0(code);
            } else {
                r90.k0(hcjAddressInfo);
                targetSettingActivity.X0();
            }
        }
    }

    public static /* synthetic */ void P0(UnfinishedRun unfinishedRun) {
        StopRunUtils.o(unfinishedRun, StopRunUtils.h(unfinishedRun.getRunRecordCode()), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0() {
        ARouter.getInstance().build(RoutePathConstants.Run.j).navigation();
        kq5.b(getContext(), "start_sun_run", null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(UnfinishedRun unfinishedRun) {
        HashMap map = new HashMap();
        map.put("runRecordCode", unfinishedRun.getRunRecordCode());
        ((com.huachenjie.run.page.free.d) ((BaseActivity) this).f8487a).h(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(BigDecimal bigDecimal) {
        this.f35827a = bigDecimal.multiply(new BigDecimal(HLADNID.Reason.OTHER)).longValue();
        O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0() {
        new CustomDistanceFragment().setInputComplete(new CustomDistanceFragment.InputComplete() { // from class: com.huachenjie.run.page.free.c
            @Override // com.huachenjie.run.page.free.CustomDistanceFragment.InputComplete
            public final void a(BigDecimal bigDecimal) {
                this.f35843a.S0(bigDecimal);
            }
        }).show(getSupportFragmentManager(), BiddingConst.ADN_ID.MM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(int i2) {
        this.l = i2;
        O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0() {
        new CustomCaloriesFragment().setInputComplete(new CustomCaloriesFragment.InputComplete() { // from class: com.huachenjie.run.page.free.b
            @Override // com.huachenjie.run.page.free.CustomCaloriesFragment.InputComplete
            public final void a(int i2) {
                this.f35842a.U0(i2);
            }
        }).show(getSupportFragmentManager(), "CUSTOM_CALORIES_FRAGMENT");
    }

    public final void N0(HCJAddressInfo addressInfo) {
        if (addressInfo == null || addressInfo.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) {
            fv5.b("定位失败");
        } else {
            ((com.huachenjie.run.page.free.d) ((BaseActivity) this).f8487a).f();
        }
    }

    public final void O0() {
        if (!vo6.a(((BaseActivity) this).c)) {
            this.f12429a.d(1);
        } else if (vo6.c(this, Permission.POST_NOTIFICATIONS)) {
            en7.e(this, new h());
        } else {
            this.f12429a.d(2);
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int U() {
        return R.drawable.ic_back_v2;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int V() {
        return zn1.a(R.color.black);
    }

    public final void W0(int code) {
        fv5.a(R.string.location_once_failed);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public CharSequence X() {
        return ((BaseActivity) this).c.getString(R.string.run_set_target);
    }

    public final void X0() {
        N0(r90.o());
    }

    public final void Y0(long outtimeMills) {
        showLoadingDialog(false);
        if (this.f12432a == null) {
            this.f12432a = new i(this);
        }
        lj0.o(this, false, LocationClientOption.LocationMode.Hight_Accuracy, this.f12432a);
    }

    public final void Z0() {
        lj0.s(this, false);
    }

    public final void a1() {
        HCJAddressInfo hCJAddressInfoO = r90.o();
        if (hCJAddressInfoO == null || System.currentTimeMillis() - hCJAddressInfoO.getTime() >= 3000) {
            Y0(10000L);
        } else {
            N0(hCJAddressInfoO);
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity
    @ColorRes
    public int b0() {
        return R.color.color_E6E8EC;
    }

    @Override // com.huachenjie.run.page.free.TargetSettingContact.TargetSettingView
    public void finishRunFailed(int code, String message) {
        fv5.a(R.string.finish_run_failed_warn);
    }

    @Override // com.huachenjie.run.page.free.TargetSettingContact.TargetSettingView
    public void finishRunSucceed() {
    }

    @Override // com.huachenjie.run.page.free.TargetSettingContact.TargetSettingView
    public void g(String runRecordCode, long aimDistance, long aimDuration, long aimCalorie) {
        ARouter.getInstance().build(RoutePathConstants.Run.e).withString("runRecordCode", runRecordCode).withLong(FreeRunActivity.y, aimDistance).withLong(FreeRunActivity.z, aimDuration).withLong(FreeRunActivity.A, aimCalorie).navigation();
        finish();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return R.layout.run_activity_target_setting;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void h0() {
        com.gyf.immersionbar.e eVarD3 = com.gyf.immersionbar.e.p3(this).d3(((BaseActivity) this).f8486a);
        int i2 = R.color.transparent;
        eVarD3.G2(i2).T2(true).u1(i2).G1(false).a1();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(Intent intent) {
    }

    @Override // com.huachenjie.run.page.free.TargetSettingContact.TargetSettingView
    public void haveUnFinishedRun(final UnfinishedRun unfinishedRun) {
        if (unfinishedRun.getSportType() == 6) {
            AlertTip alertTip = unfinishedRun.getAlertTip();
            DialogUtil.u(alertTip.getTitle(), alertTip.getContent(), "立即结束", true, true, new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.v09
                @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                public final void onClicked() {
                    TargetSettingActivity.P0(unfinishedRun);
                }
            }).create(this).show();
        } else if (unfinishedRun.getSportType() == 1) {
            AlertTip alertTip2 = unfinishedRun.getAlertTip();
            DialogUtil.H(this, alertTip2.getTitle(), alertTip2.getContent(), ys8.e(R.string.unfinish_sunshine_run_button), new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.w09
                @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                public final void onClicked() {
                    this.f45502a.Q0();
                }
            });
        } else if (unfinishedRun.getSportType() == 2) {
            DialogUtil.H(this, ys8.e(R.string.unfinish_free_run_title), ys8.e(R.string.unfinish_free_run_content), ys8.e(R.string.unfinish_free_run_button), new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.x09
                @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                public final void onClicked() {
                    this.f20587a.R0(unfinishedRun);
                }
            });
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
        this.c = Arrays.asList(((BaseActivity) this).c.getResources().getStringArray(R.array.run_distance_target_desc));
        this.f12435f = Arrays.asList(((BaseActivity) this).c.getResources().getStringArray(R.array.run_calories_target_desc));
        this.f12433d = Arrays.asList(((BaseActivity) this).c.getResources().getStringArray(R.array.run_duration_target_hour));
        this.f12434e = Arrays.asList(((BaseActivity) this).c.getResources().getStringArray(R.array.run_duration_target_min));
        this.d = 1200L;
        this.j = 300L;
        this.l = 200000L;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
        this.f12428a = (TabLayout) S(R.id.tab_target);
        ViewPager viewPager = (ViewPager) S(R.id.viewpager_target);
        this.f12427a = viewPager;
        viewPager.addOnPageChangeListener(new a());
        ArrayList arrayList = new ArrayList();
        View root = DataBindingUtil.inflate(getLayoutInflater(), R.layout.run_layout_distance_target, null, false).getRoot();
        TextView textView = (TextView) root.findViewById(R.id.tv_distance_target);
        this.D = textView;
        textView.setText(BigDecimal.valueOf(this.d).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP).toString());
        VerticalRulerView verticalRulerView = (VerticalRulerView) root.findViewById(R.id.ruler_distance);
        this.f12430a = verticalRulerView;
        verticalRulerView.setConfig(SportConstants.RUN_TARGET_ARRAY.f8557a, 1.0d, 2);
        this.f12430a.setCurrentScaleValue(BigDecimal.valueOf(1200L).doubleValue());
        this.f12430a.setExtraInfo(this.c);
        this.f12430a.setScaleTransform(new wo2());
        this.f12430a.setScrollFinishListener(new b());
        RxViewUtil.f(root.findViewById(R.id.tv_custom_distance), 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.t09
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                this.f44822a.T0();
            }
        });
        arrayList.add(new ViewItem(((BaseActivity) this).c.getString(R.string.kilometer), root));
        View root2 = DataBindingUtil.inflate(getLayoutInflater(), R.layout.run_layout_duration_target, null, false).getRoot();
        TextView textView2 = (TextView) root2.findViewById(R.id.tv_duration_target);
        this.E = textView2;
        textView2.setText(s72.n(BigDecimal.valueOf(this.j).longValue()));
        WheelView wheelView = (WheelView) root2.findViewById(R.id.duration_options1);
        WheelView wheelView2 = (WheelView) root2.findViewById(R.id.duration_options2);
        WheelView wheelView3 = (WheelView) root2.findViewById(R.id.duration_options3);
        wheelView.setAdapter(new hb0(this.f12433d));
        wheelView2.setAdapter(new hb0(this.f12434e));
        wheelView3.setAdapter(new hb0(this.f12434e));
        wheelView.setCurrentItem(0);
        wheelView2.setCurrentItem(5);
        wheelView3.setCurrentItem(0);
        wheelView.setItemsVisibleCount(11);
        wheelView2.setItemsVisibleCount(11);
        wheelView3.setItemsVisibleCount(11);
        wheelView.setOnItemSelectedListener(new c());
        wheelView2.setOnItemSelectedListener(new d());
        wheelView3.setOnItemSelectedListener(new e());
        arrayList.add(new ViewItem(((BaseActivity) this).c.getString(R.string.costed_time), root2));
        View root3 = DataBindingUtil.inflate(getLayoutInflater(), R.layout.run_layout_calories_costed_target, null, false).getRoot();
        TextView textView3 = (TextView) root3.findViewById(R.id.tv_calories_target);
        this.F = textView3;
        textView3.setText(BigDecimal.valueOf(this.l).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP).toString());
        VerticalRulerView verticalRulerView2 = (VerticalRulerView) root3.findViewById(R.id.ruler_calorias);
        this.b = verticalRulerView2;
        verticalRulerView2.setConfig(SportConstants.RUN_TARGET_ARRAY.b, 1.0d, 0);
        this.b.setCurrentScaleValue(BigDecimal.valueOf(200000L).doubleValue());
        this.b.setExtraInfo(this.f12435f);
        this.b.setScaleTransform(new ja1());
        this.b.setScrollFinishListener(new f());
        RxViewUtil.f(root3.findViewById(R.id.tv_custom_calories), 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.u09
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                this.f45040a.V0();
            }
        });
        arrayList.add(new ViewItem(((BaseActivity) this).c.getString(R.string.run_costed), root3));
        TargetPagerAdapter targetPagerAdapter = new TargetPagerAdapter(arrayList);
        this.f12431a = targetPagerAdapter;
        this.f12427a.setAdapter(targetPagerAdapter);
        this.f12428a.setupWithViewPager(this.f12427a);
        this.f12429a = new RequiredSettingComponent(this);
        getLifecycle().addObserver(this.f12429a);
        TextView textView4 = (TextView) findViewById(R.id.tv_start_run);
        this.H = textView4;
        RxViewUtil.f(textView4, 2000L, new g());
    }

    @Override // com.huachenjie.run.page.free.TargetSettingContact.TargetSettingView
    public void noUnFinishedRun() {
        HCJAddressInfo hCJAddressInfoO = r90.o();
        if (this.f35827a != 0 && hCJAddressInfoO != null && hCJAddressInfoO.getLat() != AudioStats.AUDIO_AMPLITUDE_NONE) {
            ((com.huachenjie.run.page.free.d) ((BaseActivity) this).f8487a).g(hCJAddressInfoO.getLat(), hCJAddressInfoO.getLng(), this.f35827a, 0L, 0L);
            return;
        }
        int i2 = this.L;
        if (i2 == 0) {
            if (hCJAddressInfoO == null || hCJAddressInfoO.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) {
                return;
            }
            ((com.huachenjie.run.page.free.d) ((BaseActivity) this).f8487a).g(hCJAddressInfoO.getLat(), hCJAddressInfoO.getLng(), this.d, 0L, 0L);
            return;
        }
        if (i2 != 1) {
            if (i2 != 2 || hCJAddressInfoO == null || hCJAddressInfoO.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) {
                return;
            }
            ((com.huachenjie.run.page.free.d) ((BaseActivity) this).f8487a).g(hCJAddressInfoO.getLat(), hCJAddressInfoO.getLng(), 0L, 0L, this.l);
            return;
        }
        if (hCJAddressInfoO == null || hCJAddressInfoO.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        if (this.j < 60) {
            fv5.b("时长必须大于1分钟！");
        } else {
            ((com.huachenjie.run.page.free.d) ((BaseActivity) this).f8487a).g(hCJAddressInfoO.getLat(), hCJAddressInfoO.getLng(), 0L, this.j, 0L);
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Z0();
        this.f12432a = null;
        dismissLoadingDialogs();
    }

    @Override // com.huachenjie.run.page.free.TargetSettingContact.TargetSettingView
    public void startRunFailed(String message) {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public com.huachenjie.run.page.free.d initPresenter() {
        return new com.huachenjie.run.page.free.d();
    }
}
