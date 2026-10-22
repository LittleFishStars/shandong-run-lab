package com.huachenjie.home.page.rebate_goods_list;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.base.adapter.BaseViewPager2Adapter;
import com.huachenjie.base.util.CustomTabStyle;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.home.R;
import com.huachenjie.home.databinding.HomeActivityRebateGoodsListBinding;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.xk0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0016\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/home/page/rebate_goods_list/RebateGoodsListActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/home/databinding/HomeActivityRebateGoodsListBinding;", "Lcom/huachenjie/home/page/rebate_goods_list/RebateGoodsListVM;", "", "", "", "V", "getLayoutResID", "", "initView", "", "", "titles", "a0", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "fragmentList", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class RebateGoodsListActivity extends BaseMVVMActivity<HomeActivityRebateGoodsListBinding, RebateGoodsListVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<Fragment> fragmentList = CollectionsKt.arrayListOf(new Fragment[]{new RebateGoodsUnionFragment(), new RebateGoodsUnionFragment()});

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/home/page/rebate_goods_list/RebateGoodsListActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/home/page/rebate_goods_list/RebateGoodsListActivity;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View view) {
            RebateGoodsListActivity.this.onBackPressed();
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @Nullable
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(xk0.k), new a())});
    }

    public final void a0(List<String> titles) {
        BaseViewPager2Adapter<String> baseViewPager2Adapter = new BaseViewPager2Adapter<String>() { // from class: com.huachenjie.home.page.rebate_goods_list.RebateGoodsListActivity$initTab2$pagerAdapter$1
            {
                super(this.f34362a);
            }

            @Override // com.huachenjie.base.adapter.BaseViewPager2Adapter
            @NotNull
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Fragment c(int position, @NotNull String bean) {
                Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
                Object obj = this.f34362a.fragmentList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "fragmentList[position]");
                return (Fragment) obj;
            }
        };
        getMBinding().f34210a.setAdapter(baseViewPager2Adapter);
        baseViewPager2Adapter.setList(titles);
        getMBinding().f9299a.setViewPager(getMBinding().f34210a, titles);
        CustomTabStyle customTabStyle = new CustomTabStyle();
        SlidingTabLayout2 slidingTabLayout2 = getMBinding().f9299a;
        Intrinsics.checkNotNullExpressionValue(slidingTabLayout2, "mBinding.tabLayout");
        CustomTabStyle.h(customTabStyle, slidingTabLayout2, getMBinding().f34210a, null, 0, 12, null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_activity_rebate_goods_list;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        String[] stringArray = getResources().getStringArray(R.array.home_rebate_goods_tab);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray…ay.home_rebate_goods_tab)");
        a0(ArraysKt.toList(stringArray));
    }
}
