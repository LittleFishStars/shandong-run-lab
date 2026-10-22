package com.huachenjie.mall.page.comment.list;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import com.gyf.immersionbar.e;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityCommodityCommentListBinding;
import com.huachenjie.mall.page.comment.list.CommodityCommentListActivity;
import com.zj.adlib.hk0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/mall/page/comment/list/CommodityCommentListActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityCommodityCommentListBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "", "", "V", "getLayoutResID", "", "initView", "b0", "d0", "c0", "", "b", "Lkotlin/Lazy;", "a0", "()Ljava/lang/String;", "goodsNo", "", "Lcom/huachenjie/mall/page/comment/list/CommodityCommentListFragment;", "c", "Ljava/util/List;", "fragmentArray", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CommodityCommentListActivity extends BaseMVVMActivity<MallActivityCommodityCommentListBinding, BaseTitleViewModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "goodsNo";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy goodsNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.comment.list.CommodityCommentListActivity$goodsNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("goodsNo");
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public List<CommodityCommentListFragment> fragmentArray = new ArrayList();

    /* JADX INFO: renamed from: com.huachenjie.mall.page.comment.list.CommodityCommentListActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/mall/page/comment/list/CommodityCommentListActivity$a;", "", "Landroid/content/Context;", "context", "", "goodsNo", "", "a", "GOODS_NO", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String goodsNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
            Intent intent = new Intent(context, (Class<?>) CommodityCommentListActivity.class);
            intent.putExtra("goodsNo", goodsNo);
            context.startActivity(intent);
        }
    }

    public static final void e0(CommodityCommentListActivity commodityCommentListActivity, View view) {
        Intrinsics.checkNotNullParameter(commodityCommentListActivity, "this$0");
        commodityCommentListActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @Nullable
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()));
    }

    public final String a0() {
        return (String) this.goodsNo.getValue();
    }

    public final void b0() {
        e.p3(this).M2(0).T2(true).u1(R.color.black).G1(false).g0(true).a1();
    }

    public final void c0() {
        MallActivityCommodityCommentListBinding mBinding = getMBinding();
        if (mBinding != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(supportFragmentManager);
            mBinding.f34783a.setAdapter(viewPagerAdapter);
            List<String> listListOf = CollectionsKt.listOf(new String[]{"全部", "好评", "中评", "差评"});
            CommodityCommentListFragment[] commodityCommentListFragmentArr = new CommodityCommentListFragment[4];
            CommodityCommentListFragment.Companion aVar = CommodityCommentListFragment.INSTANCE;
            String strA0 = a0();
            if (strA0 == null) {
                strA0 = "";
            }
            Intrinsics.checkNotNullExpressionValue(strA0, "goodsNo?:\"\"");
            commodityCommentListFragmentArr[0] = aVar.a(strA0, 0);
            String strA1 = a0();
            if (strA1 == null) {
                strA1 = "";
            }
            Intrinsics.checkNotNullExpressionValue(strA1, "goodsNo?:\"\"");
            commodityCommentListFragmentArr[1] = aVar.a(strA1, 3);
            String strA2 = a0();
            if (strA2 == null) {
                strA2 = "";
            }
            Intrinsics.checkNotNullExpressionValue(strA2, "goodsNo?:\"\"");
            commodityCommentListFragmentArr[2] = aVar.a(strA2, 2);
            String strA3 = a0();
            String str = strA3 != null ? strA3 : "";
            Intrinsics.checkNotNullExpressionValue(str, "goodsNo?:\"\"");
            commodityCommentListFragmentArr[3] = aVar.a(str, 1);
            this.fragmentArray = CollectionsKt.mutableListOf(commodityCommentListFragmentArr);
            mBinding.f34783a.setOffscreenPageLimit(listListOf.size());
            viewPagerAdapter.a(listListOf, this.fragmentArray);
            mBinding.f10177a.setViewPager(mBinding.f34783a, listListOf);
        }
    }

    public final void d0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleName("评价");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.op1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommodityCommentListActivity.e0(this.f43798a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_commodity_comment_list;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        b0();
        d0();
        c0();
    }
}
