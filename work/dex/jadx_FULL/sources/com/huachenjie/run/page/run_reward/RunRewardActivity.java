package com.huachenjie.run.page.run_reward;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.ariver.kernel.RVParams;
import com.blankj.utilcode.util.SizeUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.base.bean.TabEntity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunRunActivityRunRewardBinding;
import com.huachenjie.run.page.run_reward.RunRewardActivity;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.lk0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u0007¢\u0006\u0004\b'\u0010(J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010&\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/huachenjie/run/page/run_reward/RunRewardActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunRunActivityRunRewardBinding;", "Lcom/huachenjie/run/page/run_reward/RunRewardVM;", "", "getLayoutResID", "", "V", "", "initView", "initData", "initTitleBar", "f0", "", "sticky", "j0", "h0", "", "b", "Lkotlin/Lazy;", "e0", "()Ljava/lang/String;", "semesterCode", "c", "d0", "runPlanCode", "", "d", "c0", "()F", "contentCorner", "K", "I", RVParams.LONG_TITLE_COLOR, "L", "lastVerticalOffset", "a", "Ljava/lang/Boolean;", "lastSticky", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunRewardActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunRewardActivity.kt\ncom/huachenjie/run/page/run_reward/RunRewardActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n262#2,2:162\n1855#3,2:164\n*S KotlinDebug\n*F\n+ 1 RunRewardActivity.kt\ncom/huachenjie/run/page/run_reward/RunRewardActivity\n*L\n119#1:162,2\n139#1:164,2\n*E\n"})
public final class RunRewardActivity extends BaseMVVMActivity<RunRunActivityRunRewardBinding, RunRewardVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "rewardDistance";

    @NotNull
    public static final String x = "rewardTimes";

    @NotNull
    public static final String y = "semesterCode";

    @NotNull
    public static final String z = "runPlanCode";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Boolean lastSticky;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy semesterCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.run_reward.RunRewardActivity$semesterCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("semesterCode");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy runPlanCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.run_reward.RunRewardActivity$runPlanCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("runPlanCode");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy contentCorner = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.run.page.run_reward.RunRewardActivity$contentCorner$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m687invoke() {
            return Float.valueOf(SizeUtils.b(20.0f));
        }
    });

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int titleColor = zn1.a(R.color.color_191F20);

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int lastVerticalOffset = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: com.huachenjie.run.page.run_reward.RunRewardActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J2\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/run/page/run_reward/RunRewardActivity$a;", "", "Landroid/content/Context;", "context", "", RunRewardActivity.t, RunRewardActivity.x, "semesterCode", "runPlanCode", "", "a", "KEY_REWARD_DISTANCE", "Ljava/lang/String;", "KEY_REWARD_TIMES", "KEY_RUN_PLAN_CODE", "KEY_SEMESTER_CODE", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String rewardDistance, @NotNull String rewardTimes, @Nullable String semesterCode, @Nullable String runPlanCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rewardDistance, RunRewardActivity.t);
            Intrinsics.checkNotNullParameter(rewardTimes, RunRewardActivity.x);
            context.startActivity(new Intent(context, (Class<?>) RunRewardActivity.class).putExtra(RunRewardActivity.t, rewardDistance).putExtra(RunRewardActivity.x, rewardTimes).putExtra("semesterCode", semesterCode).putExtra("runPlanCode", runPlanCode));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/run/page/run_reward/RunRewardActivity$b", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "", "position", "", "b", "a", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements OnTabSelectListener {
        public b() {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void a(int position) {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void b(int position) {
            RunRewardActivity.b0(RunRewardActivity.this).f12290a.setCurrentItem(position);
        }
    }

    public static final /* synthetic */ RunRunActivityRunRewardBinding b0(RunRewardActivity runRewardActivity) {
        return runRewardActivity.getMBinding();
    }

    public static final void g0(RunRewardActivity runRewardActivity, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(runRewardActivity, "this$0");
        if (runRewardActivity.lastVerticalOffset == i) {
            return;
        }
        runRewardActivity.lastVerticalOffset = i;
        int totalScrollRange = appBarLayout.getTotalScrollRange();
        if (totalScrollRange <= 0) {
            return;
        }
        float fCoerceIn = RangesKt.coerceIn(Math.abs(i) / totalScrollRange, 0.0f, 1.0f);
        boolean z2 = fCoerceIn >= 0.99f;
        boolean zAreEqual = true ^ Intrinsics.areEqual(runRewardActivity.lastSticky, Boolean.valueOf(z2));
        MutableLiveData<BindingTitleBean> mutableLiveDataI = runRewardActivity.getMViewModel().i();
        BindingTitleBean value = runRewardActivity.getMViewModel().i().getValue();
        if (value != null) {
            int i2 = (int) (fCoerceIn * 255);
            value.setBackground(ColorUtils.setAlphaComponent(-1, i2));
            value.setTitleTextColor(ColorUtils.setAlphaComponent(runRewardActivity.titleColor, i2));
            if (zAreEqual) {
                value.setShowDivider(z2);
            }
        } else {
            value = null;
        }
        mutableLiveDataI.setValue(value);
        if (zAreEqual) {
            runRewardActivity.lastSticky = Boolean.valueOf(z2);
            runRewardActivity.j0(z2);
        }
    }

    public static final void i0(RunRewardActivity runRewardActivity, View view) {
        Intrinsics.checkNotNullParameter(runRewardActivity, "this$0");
        runRewardActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, RunRewardVM> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()));
    }

    public final float c0() {
        return ((Number) this.contentCorner.getValue()).floatValue();
    }

    public final String d0() {
        return (String) this.runPlanCode.getValue();
    }

    public final String e0() {
        return (String) this.semesterCode.getValue();
    }

    public final void f0() {
        getMBinding().f12292a.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.zj.adlib.mm7
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                RunRewardActivity.g0(this.f43335a, appBarLayout, i);
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_run_activity_run_reward;
    }

    public final void h0() {
        List<String> listListOf = CollectionsKt.listOf(new String[]{"跑步奖励", "其他奖励"});
        RunRewardListFragment.Companion aVar = RunRewardListFragment.INSTANCE;
        List<? extends Fragment> listListOf2 = CollectionsKt.listOf(new RunRewardListFragment[]{aVar.a(e0(), d0(), 1), aVar.a(e0(), d0(), 2)});
        getMBinding().f12290a.setOffscreenPageLimit(listListOf.size());
        ViewPager viewPager = getMBinding().f12290a;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(supportFragmentManager);
        viewPagerAdapter.a(listListOf, listListOf2);
        viewPager.setAdapter(viewPagerAdapter);
        CommonTabLayout commonTabLayout = getMBinding().f12291a;
        ArrayList<CustomTabEntity> arrayList = new ArrayList<>();
        Iterator<T> it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new TabEntity((String) it.next()));
        }
        commonTabLayout.setTabData(arrayList);
        getMBinding().f12291a.setOnTabSelectListener(new b());
        getMBinding().f12290a.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.huachenjie.run.page.run_reward.RunRewardActivity$initTabLayout$4
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                RunRewardActivity.b0(this.f35936a).f12291a.setCurrentTab(position);
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().j().setValue(getIntent().getStringExtra(t));
        getMViewModel().k().setValue(getIntent().getStringExtra(x));
    }

    public final void initTitleBar() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean showDivider = new BindingTitleBean().setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(this.titleColor)).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.nm7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunRewardActivity.i0(this.f43559a, view);
            }
        }).setTitleName("跑步奖励").setTitleTextColor(ColorUtils.setAlphaComponent(this.titleColor, 0)).setBackground(0).setShowDivider(false);
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            value = 0;
        }
        mutableLiveDataI.setValue(showDivider.setStatusBarHeight(value.intValue()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initTitleBar();
        h0();
        f0();
    }

    public final void j0(boolean sticky) {
        LinearLayout linearLayout = getMBinding().f12286a;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.llTabHeader");
        BLLinearLayout bLLinearLayout = getMBinding().f12296b;
        Intrinsics.checkNotNullExpressionValue(bLLinearLayout, "mBinding.llTabSticky");
        BLLinearLayout bLLinearLayout2 = getMBinding().f12295a;
        Intrinsics.checkNotNullExpressionValue(bLLinearLayout2, "mBinding.llContent");
        if (linearLayout.getParent() != (sticky ? bLLinearLayout : bLLinearLayout2)) {
            ViewParent parent = linearLayout.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(linearLayout);
            if (sticky) {
                bLLinearLayout.addView(linearLayout);
            } else {
                bLLinearLayout2.addView(linearLayout, 0);
            }
        }
        bLLinearLayout.setVisibility(sticky ? 0 : 8);
        float fC0 = sticky ? 0.0f : c0();
        bLLinearLayout2.setBackground(new DrawableCreator.Builder().setSolidColor(-1).setCornersRadius(c0(), c0(), fC0, fC0).build());
    }
}
