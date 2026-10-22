package com.huachenjie.works.page.alumni.recommend;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.base.util.CustomTabStyle;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.RecommendWorksBean;
import com.huachenjie.works.databinding.WorksFragmentAlumniRecommendBinding;
import com.huachenjie.works.dialog.PublishEntryDialog;
import com.igexin.push.g.o;
import com.zj.adlib.dq1;
import com.zj.adlib.qk0;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J$\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/works/page/alumni/recommend/RecommendFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentAlumniRecommendBinding;", "Lcom/huachenjie/works/page/alumni/recommend/RecommendVM;", "", "", "titles", "channelCodeList", "", "initTab", "", "", "", "getVariables", "getLayoutResID", "onFragmentResume", "initDataObservable", "Lcom/huachenjie/base/util/CustomTabStyle;", "customTabStyle$delegate", "Lkotlin/Lazy;", "getCustomTabStyle", "()Lcom/huachenjie/base/util/CustomTabStyle;", "customTabStyle", "<init>", "()V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRecommendFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecommendFragment.kt\ncom/huachenjie/works/page/alumni/recommend/RecommendFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,117:1\n1855#2,2:118\n*S KotlinDebug\n*F\n+ 1 RecommendFragment.kt\ncom/huachenjie/works/page/alumni/recommend/RecommendFragment\n*L\n62#1:118,2\n*E\n"})
public final class RecommendFragment extends BaseMVVMFragment<WorksFragmentAlumniRecommendBinding, RecommendVM> {

    /* JADX INFO: renamed from: customTabStyle$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy customTabStyle = LazyKt.lazy(new Function0<CustomTabStyle>() { // from class: com.huachenjie.works.page.alumni.recommend.RecommendFragment$customTabStyle$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CustomTabStyle m856invoke() {
            return new CustomTabStyle();
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/works/page/alumni/recommend/RecommendFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/works/page/alumni/recommend/RecommendFragment;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            SlidingTabLayout slidingTabLayout;
            Intrinsics.checkNotNullParameter(view, "view");
            WorksFragmentAlumniRecommendBinding worksFragmentAlumniRecommendBindingAccess$getMBinding = RecommendFragment.access$getMBinding(RecommendFragment.this);
            if (worksFragmentAlumniRecommendBindingAccess$getMBinding == null || (slidingTabLayout = worksFragmentAlumniRecommendBindingAccess$getMBinding.f14168a) == null) {
                return;
            }
            int currentTab = slidingTabLayout.getCurrentTab();
            ArrayList<RecommendWorksBean> value = RecommendFragment.access$getMViewModel(RecommendFragment.this).i().getValue();
            if (value == null) {
                return;
            }
            if (currentTab >= 0 && currentTab < value.size()) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                PublishEntryDialog.Companion aVar = PublishEntryDialog.INSTANCE;
                int i = iArr[0];
                int i2 = iArr[1];
                String categoryNo = value.get(currentTab).getCategoryNo();
                if (categoryNo == null) {
                    categoryNo = "";
                }
                PublishEntryDialog publishEntryDialogA = aVar.a(i, i2, value, categoryNo);
                FragmentManager childFragmentManager = RecommendFragment.this.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                publishEntryDialogA.show(childFragmentManager, PublishEntryDialog.class.getSimpleName());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/works/page/alumni/recommend/RecommendFragment$b", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "", "position", "", "b", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements OnTabSelectListener {
        public b() {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void a(int position) {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void b(int position) {
            ArrayList<RecommendWorksBean> value = RecommendFragment.access$getMViewModel(RecommendFragment.this).i().getValue();
            if (value == null) {
                return;
            }
            boolean z = false;
            if (position >= 0 && position < value.size()) {
                z = true;
            }
            if (z) {
                RecommendFragment.access$getMViewModel(RecommendFragment.this).j().setValue(value.get(position).getLogoUrl());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37188a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37188a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37188a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37188a.invoke(obj);
        }
    }

    public static final /* synthetic */ WorksFragmentAlumniRecommendBinding access$getMBinding(RecommendFragment recommendFragment) {
        return recommendFragment.getMBinding();
    }

    public static final /* synthetic */ RecommendVM access$getMViewModel(RecommendFragment recommendFragment) {
        return recommendFragment.getMViewModel();
    }

    private final CustomTabStyle getCustomTabStyle() {
        return (CustomTabStyle) this.customTabStyle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initTab(List<String> titles, List<String> channelCodeList) {
        WorksFragmentAlumniRecommendBinding mBinding = getMBinding();
        if (mBinding == null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(childFragmentManager);
        mBinding.f14167a.setAdapter(viewPagerAdapter);
        ArrayList arrayList = new ArrayList();
        for (String str : channelCodeList) {
            if (TextUtils.equals("-1", str)) {
                Object objNavigation = ARouter.getInstance().build(zj7.g.MALL_HOME_TAB).navigation();
                Intrinsics.checkNotNull(objNavigation, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                arrayList.add((Fragment) objNavigation);
            } else {
                arrayList.add(RecommendWorksFragment.INSTANCE.a(str));
            }
        }
        mBinding.f14167a.setOffscreenPageLimit(titles.size());
        viewPagerAdapter.a(titles, arrayList);
        mBinding.f14168a.setViewPager(mBinding.f14167a, titles);
        mBinding.f14168a.updateTabSelection(0);
        ArrayList<RecommendWorksBean> value = getMViewModel().i().getValue();
        if (value != null && (!value.isEmpty())) {
            getMViewModel().j().setValue(value.get(0).getLogoUrl());
        }
        CustomTabStyle customTabStyle = getCustomTabStyle();
        SlidingTabLayout slidingTabLayout = mBinding.f14168a;
        Intrinsics.checkNotNullExpressionValue(slidingTabLayout, "binding.tabLayout");
        CustomTabStyle.f(customTabStyle, slidingTabLayout, mBinding.f14167a, new b(), 0, 8, null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_alumni_recommend;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().i().observe(this, new c(new Function1<ArrayList<RecommendWorksBean>, Unit>() { // from class: com.huachenjie.works.page.alumni.recommend.RecommendFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ArrayList<RecommendWorksBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ArrayList<RecommendWorksBean> arrayList) {
                try {
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Intrinsics.checkNotNullExpressionValue(arrayList, o.f);
                    for (RecommendWorksBean recommendWorksBean : arrayList) {
                        arrayList2.add(recommendWorksBean.getCategoryName());
                        arrayList3.add(recommendWorksBean.getCategoryNo());
                    }
                    RecommendFragment.this.initTab(arrayList2, arrayList3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onFragmentResume() {
        ArrayList<RecommendWorksBean> value = getMViewModel().i().getValue();
        boolean z = false;
        if (value != null && (!value.isEmpty())) {
            z = true;
        }
        if (z || dq1.d() == null) {
            return;
        }
        getMViewModel().l();
    }
}
