package com.huachenjie.works.page.alumni.good_stuff;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.GoodStuffTabBean;
import com.huachenjie.works.databinding.WorksFragmentGoodStuffBinding;
import com.igexin.push.g.o;
import com.zj.adlib.lq5;
import com.zj.adlib.qk0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/page/alumni/good_stuff/GoodStuffFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentGoodStuffBinding;", "Lcom/huachenjie/works/page/alumni/good_stuff/GoodStuffVM;", "", "", "titles", "codeList", "", "initTab", "", "", "", "getVariables", "getLayoutResID", "initDataObservable", "initData", "<init>", "()V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nGoodStuffFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoodStuffFragment.kt\ncom/huachenjie/works/page/alumni/good_stuff/GoodStuffFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,78:1\n1864#2,3:79\n*S KotlinDebug\n*F\n+ 1 GoodStuffFragment.kt\ncom/huachenjie/works/page/alumni/good_stuff/GoodStuffFragment\n*L\n49#1:79,3\n*E\n"})
public final class GoodStuffFragment extends BaseMVVMFragment<WorksFragmentGoodStuffBinding, GoodStuffVM> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/works/page/alumni/good_stuff/GoodStuffFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/works/page/alumni/good_stuff/GoodStuffFragment;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37173a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37173a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37173a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37173a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initTab(final List<String> titles, final List<String> codeList) {
        WorksFragmentGoodStuffBinding mBinding = getMBinding();
        if (mBinding == null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(childFragmentManager);
        mBinding.f14197a.setAdapter(viewPagerAdapter);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : codeList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(GoodStuffItemFragment.INSTANCE.a((String) obj, titles.get(i)));
            i = i2;
        }
        mBinding.f14197a.setOffscreenPageLimit(titles.size());
        viewPagerAdapter.a(titles, arrayList);
        mBinding.f14198a.setViewPager(mBinding.f14197a, titles);
        mBinding.f14198a.updateTabSelection(0);
        mBinding.f14197a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.huachenjie.works.page.alumni.good_stuff.GoodStuffFragment.initTab.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                Context context = GoodStuffFragment.this.getContext();
                if (context != null) {
                    lq5.d(context, codeList.get(position), titles.get(position));
                }
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_good_stuff;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().k();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().i().observe(this, new b(new Function1<List<GoodStuffTabBean>, Unit>() { // from class: com.huachenjie.works.page.alumni.good_stuff.GoodStuffFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<GoodStuffTabBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<GoodStuffTabBean> list) {
                try {
                    if (list.isEmpty()) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Intrinsics.checkNotNullExpressionValue(list, o.f);
                    for (GoodStuffTabBean goodStuffTabBean : list) {
                        arrayList.add(goodStuffTabBean.getZoneName());
                        arrayList2.add(goodStuffTabBean.getZoneNo());
                    }
                    GoodStuffFragment.this.initTab(arrayList, arrayList2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));
    }
}
