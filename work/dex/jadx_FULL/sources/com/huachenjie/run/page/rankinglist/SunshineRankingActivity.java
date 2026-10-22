package com.huachenjie.run.page.rankinglist;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RankingRangeBean;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.databinding.RunActivitySunshineRankingBinding;
import com.huachenjie.run.page.activities_run.DetailActivity;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.zj.adlib.i4a;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import com.zj.adlib.r5a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(extras = 1, path = RoutePathConstants.Run.p)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001dB\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J2\u0010\u0017\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R*\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR'\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\n0\u0018j\b\u0012\u0004\u0012\u00020\n`\u00198\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/SunshineRankingActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/run/page/rankinglist/SunshineRankingActivityVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "Lcom/huachenjie/run/page/rankinglist/SunshineRankingFragment;", "i0", "n0", "initView", "", "j0", "", "Lcom/huachenjie/run/bean/RankingRangeBean;", GoodsSpecificationPreviewActivity.z, "timeList", "", "Lcom/huachenjie/run/bean/RunPlanBean;", "planData", "m0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", SunshineRankingActivity.x, "b", "k0", "()Ljava/util/ArrayList;", "fragmentList", "Lcom/lxj/xpopup/core/BasePopupView;", "Lcom/lxj/xpopup/core/BasePopupView;", "l0", "()Lcom/lxj/xpopup/core/BasePopupView;", "o0", "(Lcom/lxj/xpopup/core/BasePopupView;)V", "popupView", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class SunshineRankingActivity extends BaseVmActivity<SunshineRankingActivityVM> {

    @NotNull
    public static final String x = "planList";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public BasePopupView popupView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Autowired(name = x)
    @JvmField
    @Nullable
    public ArrayList<RunPlanBean> planList;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final ArrayList<SunshineRankingFragment> fragmentList = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/SunshineRankingActivity$a;", "", "Landroid/view/View;", "v", "", "a", "b", "<init>", "(Lcom/huachenjie/run/page/rankinglist/SunshineRankingActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SunshineRankingActivity.this.finish();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(new RankingRangeBean("班级", 10));
            arrayList.add(new RankingRangeBean("院系", 30));
            if (SunshineRankingActivity.this.j0() == 2) {
                arrayList.add(new RankingRangeBean("年级", 20));
            } else {
                arrayList.add(new RankingRangeBean("全校", 50));
            }
            if (SunshineRankingActivity.this.j0() == 1) {
                arrayList2.add(new RankingRangeBean("周榜", 10));
                arrayList2.add(new RankingRangeBean("月榜", 20));
                arrayList2.add(new RankingRangeBean("学期榜", 30));
            }
            SunshineRankingActivity sunshineRankingActivity = SunshineRankingActivity.this;
            List<RunPlanBean> value = ((SunshineRankingActivityVM) ((BaseVmActivity) sunshineRankingActivity).f8507a).i().getValue();
            if (value == null) {
                value = new ArrayList<>();
            }
            sunshineRankingActivity.m0(arrayList, arrayList2, value);
            BasePopupView popupView = SunshineRankingActivity.this.getPopupView();
            if (popupView != null) {
                popupView.show();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/run/page/rankinglist/SunshineRankingActivity$c", "Lcom/huachenjie/run/page/rankinglist/RankingDrawer$OnConfirmListener;", "", "code", "timeCode", "", DetailActivity.x, "", "a", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements RankingDrawer.OnConfirmListener {
        public c() {
        }

        @Override // com.huachenjie.run.page.rankinglist.RankingDrawer.OnConfirmListener
        public void a(int code, int timeCode, @NotNull String planCode) {
            Intrinsics.checkNotNullParameter(planCode, DetailActivity.x);
            SunshineRankingFragment sunshineRankingFragmentI0 = SunshineRankingActivity.this.i0();
            if (sunshineRankingFragmentI0 != null) {
                i4a.a(RenderCallContext.TYPE_CALLBACK);
                sunshineRankingFragmentI0.setScope(Integer.valueOf(code));
                sunshineRankingFragmentI0.setRankCycle(Integer.valueOf(timeCode));
                sunshineRankingFragmentI0.setPlanCode(planCode);
                sunshineRankingFragmentI0.refreshData();
            }
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.run_activity_sunshine_ranking), Integer.valueOf(lk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(lk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Nullable
    public final SunshineRankingFragment i0() {
        if (getBinding() == null) {
            return null;
        }
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunActivitySunshineRankingBinding");
        try {
            return this.fragmentList.get(((RunActivitySunshineRankingBinding) binding).f11605a.getCurrentItem());
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        n0();
        initView();
        if (this.planList != null) {
            ((SunshineRankingActivityVM) ((BaseVmActivity) this).f8507a).i().setValue(this.planList);
        } else {
            ((SunshineRankingActivityVM) ((BaseVmActivity) this).f8507a).l();
        }
    }

    public final void initView() {
        this.fragmentList.clear();
        ArrayList<SunshineRankingFragment> arrayList = this.fragmentList;
        SunshineRankingFragment.Companion bVar = SunshineRankingFragment.INSTANCE;
        arrayList.add(bVar.a(1));
        this.fragmentList.add(bVar.a(2));
        this.fragmentList.add(bVar.a(3));
        RankingVPAdapter rankingVPAdapter = new RankingVPAdapter(this.fragmentList, this);
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunActivitySunshineRankingBinding");
        RunActivitySunshineRankingBinding runActivitySunshineRankingBinding = (RunActivitySunshineRankingBinding) binding;
        runActivitySunshineRankingBinding.f11605a.setAdapter(rankingVPAdapter);
        runActivitySunshineRankingBinding.f11605a.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.huachenjie.run.page.rankinglist.SunshineRankingActivity.initView.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                i4a.a("onPageSelected" + position);
                SunshineRankingActivity.this.k0().get(position).checkScrollOffset();
                SunshineRankingActivity.this.k0().get(position).resetCode();
            }
        });
        runActivitySunshineRankingBinding.f11606a.setViewPager(runActivitySunshineRankingBinding.f11605a, new String[]{"单次里程", "总里程", "总进度"});
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final int j0() {
        RunActivitySunshineRankingBinding runActivitySunshineRankingBinding;
        ViewPager2 viewPager2;
        if (getBinding() == null || (runActivitySunshineRankingBinding = (RunActivitySunshineRankingBinding) getBinding()) == null || (viewPager2 = runActivitySunshineRankingBinding.f11605a) == null) {
            return 0;
        }
        return viewPager2.getCurrentItem();
    }

    @NotNull
    public final ArrayList<SunshineRankingFragment> k0() {
        return this.fragmentList;
    }

    @Nullable
    /* JADX INFO: renamed from: l0, reason: from getter */
    public final BasePopupView getPopupView() {
        return this.popupView;
    }

    public final void m0(List<RankingRangeBean> list, List<RankingRangeBean> timeList, List<RunPlanBean> planData) {
        SunshineRankingFragment sunshineRankingFragmentI0 = i0();
        if (sunshineRankingFragmentI0 == null) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Integer numValueOf = Integer.valueOf(sunshineRankingFragmentI0.getScope());
        Integer numValueOf2 = Integer.valueOf(sunshineRankingFragmentI0.getRankCycle());
        String planCode = sunshineRankingFragmentI0.getPlanCode();
        if (planCode == null) {
            planCode = "";
        }
        RankingDrawer rankingDrawer = new RankingDrawer(context, numValueOf, numValueOf2, planCode, list, timeList, planData);
        this.popupView = new r5a.b(getContext()).q0(PopupPosition.Right).U(false).b0(true).r(rankingDrawer);
        rankingDrawer.setListener(new c());
    }

    public final void n0() {
        e.p3(this).l3().T2(false).a1();
    }

    public final void o0(@Nullable BasePopupView basePopupView) {
        this.popupView = basePopupView;
    }
}
