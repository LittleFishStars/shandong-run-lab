package com.huachenjie.college.page.recreation;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.base.mob.MobClickConstants;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.CollegeRecommendBean;
import com.huachenjie.college.bean.CollegeTownBean;
import com.huachenjie.college.databinding.CollegeActivityRecreationBinding;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.college.page.popcorn.PopcornWebActivity;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.igexin.push.g.o;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.kq5;
import com.zj.adlib.su9;
import com.zj.adlib.uk0;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.Iterator;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Route(path = zj7.c.RECREATION)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0016\u0010\u0010\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/college/page/recreation/RecreationActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/college/databinding/CollegeActivityRecreationBinding;", "Lcom/huachenjie/college/page/recreation/RecreationVM;", "", "getLayoutResID", "", "", "V", "", "initView", "initData", "W", "", "Lcom/huachenjie/college/bean/CollegeRecommendBean;", "typeList", "d0", "position", "e0", "<init>", "()V", "ClickProxy", "college_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRecreationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecreationActivity.kt\ncom/huachenjie/college/page/recreation/RecreationActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,117:1\n1549#2:118\n1620#2,3:119\n1549#2:122\n1620#2,3:123\n*S KotlinDebug\n*F\n+ 1 RecreationActivity.kt\ncom/huachenjie/college/page/recreation/RecreationActivity\n*L\n55#1:118\n55#1:119,3\n56#1:122\n56#1:123,3\n*E\n"})
public final class RecreationActivity extends BaseMVVMActivity<CollegeActivityRecreationBinding, RecreationVM> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/college/page/recreation/RecreationActivity$ClickProxy;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/college/page/recreation/RecreationActivity;)V", "college_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RecreationActivity.this.finish();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final void b(@NotNull final View view) {
            SlidingTabLayout2 slidingTabLayout2;
            RecreationVM recreationVMA0;
            MutableLiveData<CollegeTownBean> mutableLiveDataK;
            CollegeTownBean value;
            List<CollegeRecommendBean> typeList;
            Intrinsics.checkNotNullParameter(view, "view");
            CollegeActivityRecreationBinding collegeActivityRecreationBindingZ = RecreationActivity.Z(RecreationActivity.this);
            if (collegeActivityRecreationBindingZ == null || (slidingTabLayout2 = collegeActivityRecreationBindingZ.f8378a) == null || (recreationVMA0 = RecreationActivity.a0(RecreationActivity.this)) == null || (mutableLiveDataK = recreationVMA0.k()) == null || (value = mutableLiveDataK.getValue()) == null || (typeList = value.getTypeList()) == null) {
                return;
            }
            int size = typeList.size();
            int currentTab = slidingTabLayout2.getCurrentTab();
            boolean z = false;
            if (currentTab >= 0 && currentTab < size) {
                z = true;
            }
            if (z) {
                String type = typeList.get(slidingTabLayout2.getCurrentTab()).getType();
                int iHashCode = type.hashCode();
                if (iHashCode == 52) {
                    if (type.equals("4")) {
                        RecreationVM recreationVMA1 = RecreationActivity.a0(RecreationActivity.this);
                        final RecreationActivity recreationActivity = RecreationActivity.this;
                        recreationVMA1.m(new Function1<String, Unit>() { // from class: com.huachenjie.college.page.recreation.RecreationActivity$ClickProxy$clickLookAll$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((String) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull String str) {
                                Context context;
                                Intrinsics.checkNotNullParameter(str, o.f);
                                Intent intent = new Intent(recreationActivity, (Class<?>) PopcornWebActivity.class);
                                intent.putExtra("url", str);
                                View view2 = view;
                                if (view2 == null || (context = view2.getContext()) == null) {
                                    return;
                                }
                                context.startActivity(intent);
                            }
                        });
                        return;
                    }
                    return;
                }
                switch (iHashCode) {
                    case 1567:
                        if (type.equals("10")) {
                            kq5.c(view.getContext(), MobClickConstants.c);
                            ARouter.getInstance().build(zj7.g.MALL_HOME).navigation();
                            break;
                        }
                        break;
                    case 1568:
                        if (type.equals("11")) {
                            su9.r(view.getContext());
                            break;
                        }
                        break;
                    case 1569:
                        if (type.equals("12")) {
                            su9.g(view.getContext());
                            break;
                        }
                        break;
                }
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33613a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33613a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33613a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33613a.invoke(obj);
        }
    }

    public static final /* synthetic */ CollegeActivityRecreationBinding Z(RecreationActivity recreationActivity) {
        return recreationActivity.getMBinding();
    }

    public static final /* synthetic */ RecreationVM a0(RecreationActivity recreationActivity) {
        return recreationActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(uk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(uk0.k), new ClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().k().observe(this, new a(new Function1<CollegeTownBean, Unit>() { // from class: com.huachenjie.college.page.recreation.RecreationActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CollegeTownBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(CollegeTownBean collegeTownBean) {
                List<CollegeRecommendBean> typeList;
                if (collegeTownBean == null || (typeList = collegeTownBean.getTypeList()) == null) {
                    return;
                }
                this.this$0.d0(typeList);
            }
        }));
    }

    public final void d0(List<CollegeRecommendBean> typeList) {
        SlidingTabLayout2 slidingTabLayout2;
        CollegeActivityRecreationBinding mBinding;
        ViewPager2 viewPager2;
        if (typeList.isEmpty()) {
            CollegeActivityRecreationBinding mBinding2 = getMBinding();
            BLLinearLayout bLLinearLayout = mBinding2 != null ? mBinding2.f8382a : null;
            if (bLLinearLayout == null) {
                return;
            }
            bLLinearLayout.setVisibility(8);
            return;
        }
        CollegeActivityRecreationBinding mBinding3 = getMBinding();
        if (mBinding3 == null || (slidingTabLayout2 = mBinding3.f8378a) == null || (mBinding = getMBinding()) == null || (viewPager2 = mBinding.f33564a) == null) {
            return;
        }
        List<CollegeRecommendBean> list = typeList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((CollegeRecommendBean) it.next()).getName());
        }
        List<String> list2 = CollectionsKt.toList(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(CollegeTownItemFragment.INSTANCE.a(((CollegeRecommendBean) it2.next()).getType()));
        }
        List<Fragment> list3 = CollectionsKt.toList(arrayList2);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.huachenjie.college.page.recreation.RecreationActivity$initTab$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                this.f33614a.e0(position);
            }
        });
        slidingTabLayout2.setViewPager(viewPager2, list2, this, list3);
    }

    public final void e0(int position) {
        MutableLiveData<CollegeTownBean> mutableLiveDataK;
        CollegeTownBean value;
        List<CollegeRecommendBean> typeList;
        BLLinearLayout bLLinearLayout;
        RecreationVM mViewModel = getMViewModel();
        if (mViewModel == null || (mutableLiveDataK = mViewModel.k()) == null || (value = mutableLiveDataK.getValue()) == null || (typeList = value.getTypeList()) == null) {
            return;
        }
        if (position >= 0 && position < typeList.size()) {
            CollegeRecommendBean collegeRecommendBean = typeList.get(position);
            if (TextUtils.equals(collegeRecommendBean.getType(), "4") || TextUtils.equals(collegeRecommendBean.getType(), "10") || TextUtils.equals(collegeRecommendBean.getType(), "11") || TextUtils.equals(collegeRecommendBean.getType(), "12")) {
                CollegeActivityRecreationBinding mBinding = getMBinding();
                bLLinearLayout = mBinding != null ? mBinding.f8382a : null;
                if (bLLinearLayout == null) {
                    return;
                }
                bLLinearLayout.setVisibility(0);
                return;
            }
            CollegeActivityRecreationBinding mBinding2 = getMBinding();
            bLLinearLayout = mBinding2 != null ? mBinding2.f8382a : null;
            if (bLLinearLayout == null) {
                return;
            }
            bLLinearLayout.setVisibility(8);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.college_activity_recreation;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().l();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
    }
}
