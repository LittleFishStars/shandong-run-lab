package com.huachenjie.mall.page.merchants;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.android.material.appbar.AppBarLayout;
import com.gyf.immersionbar.e;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MerchantsBean;
import com.huachenjie.mall.databinding.MallActivityMerchantsBinding;
import com.huachenjie.mall.external.page.CommodityFragment;
import com.huachenjie.mall.page.merchants.MerchantsActivity;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.cr2;
import com.zj.adlib.hk0;
import com.zj.adlib.su9;
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
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Route(path = zj7.g.MERCHANTS)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001f\u0013B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/huachenjie/mall/page/merchants/MerchantsActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityMerchantsBinding;", "Lcom/huachenjie/mall/page/merchants/MerchantsVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "e0", "", "darkMode", "g0", "d0", "", "b", "Lkotlin/Lazy;", "c0", "()Ljava/lang/String;", "shopNo", "", "Lcom/huachenjie/mall/external/page/CommodityFragment;", "c", "Ljava/util/List;", "fragmentArray", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class MerchantsActivity extends BaseMVVMActivity<MallActivityMerchantsBinding, MerchantsVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "shopNo";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy shopNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.merchants.MerchantsActivity$shopNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra;
            Intent intent = this.this$0.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra("shopNo")) == null) ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public List<CommodityFragment> fragmentArray = new ArrayList();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/page/merchants/MerchantsActivity$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/mall/page/merchants/MerchantsActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MerchantsActivity.this.finish();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (MerchantsActivity.a0(MerchantsActivity.this).i().getValue() == null) {
                return;
            }
            MerchantsActivity merchantsActivity = MerchantsActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.c);
            sb.append("/#/mall/shop-license?shopNo=");
            MerchantsBean value = MerchantsActivity.a0(MerchantsActivity.this).i().getValue();
            Intrinsics.checkNotNull(value);
            sb.append(value.getShopNo());
            su9.v(merchantsActivity, sb.toString());
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.merchants.MerchantsActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/mall/page/merchants/MerchantsActivity$b;", "", "Landroid/content/Context;", "context", "", "shopNo", "", "a", "SHOP_NO", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String shopNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(shopNo, "shopNo");
            Intent intent = new Intent(context, (Class<?>) MerchantsActivity.class);
            intent.putExtra("shopNo", shopNo);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/mall/page/merchants/MerchantsActivity$c", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "", "position", "", "b", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements OnTabSelectListener {
        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void a(int position) {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void b(int position) {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35231a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35231a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35231a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35231a.invoke(obj);
        }
    }

    public static final /* synthetic */ MerchantsVM a0(MerchantsActivity merchantsActivity) {
        return merchantsActivity.getMViewModel();
    }

    public static final void f0(MallActivityMerchantsBinding mallActivityMerchantsBinding, MerchantsActivity merchantsActivity, float f, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(mallActivityMerchantsBinding, "$this_apply");
        Intrinsics.checkNotNullParameter(merchantsActivity, "this$0");
        float fAbs = Math.abs(i) / (mallActivityMerchantsBinding.f10283a.getHeight() - mallActivityMerchantsBinding.f10280a.getHeight());
        double d2 = fAbs;
        if (d2 > 0.5d) {
            merchantsActivity.g0(true);
            mallActivityMerchantsBinding.f34816a.setVisibility(0);
        } else {
            merchantsActivity.g0(false);
            mallActivityMerchantsBinding.f34816a.setVisibility(8);
        }
        mallActivityMerchantsBinding.f10280a.setBackgroundColor(Color.argb((int) (255 * fAbs), 255, 255, 255));
        float f2 = 1 - fAbs;
        int i2 = (int) (211 * f2);
        int iArgb = Color.argb(255, i2, i2, i2);
        if (d2 > 0.5d) {
            mallActivityMerchantsBinding.b.setTextColor(iArgb);
        } else {
            mallActivityMerchantsBinding.b.setTextColor(0);
        }
        mallActivityMerchantsBinding.f10278a.setImageTintList(ColorStateList.valueOf(iArgb));
        float f3 = f * f2;
        mallActivityMerchantsBinding.f10287a.setBackground(new DrawableCreator.Builder().setGradientColor(Color.parseColor("#FFFFFF"), Color.parseColor("#FFF5F5F5")).setCornersRadius(0.0f, 0.0f, f3, f3).build());
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().i().observe(this, new d(new Function1<MerchantsBean, Unit>() { // from class: com.huachenjie.mall.page.merchants.MerchantsActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MerchantsBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(MerchantsBean merchantsBean) {
                if (merchantsBean != null) {
                    MerchantsActivity merchantsActivity = this.this$0;
                    if (merchantsBean.getClose()) {
                        return;
                    }
                    merchantsActivity.d0();
                }
            }
        }));
    }

    public final String c0() {
        return (String) this.shopNo.getValue();
    }

    public final void d0() {
        MallActivityMerchantsBinding mBinding = getMBinding();
        if (mBinding != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(supportFragmentManager);
            mBinding.f10281a.setAdapter(viewPagerAdapter);
            List<String> listListOf = CollectionsKt.listOf(new String[]{"推荐", "销量", "最新"});
            CommodityFragment.Companion aVar = CommodityFragment.INSTANCE;
            String strC0 = c0();
            Intrinsics.checkNotNullExpressionValue(strC0, "shopNo");
            String strC1 = c0();
            Intrinsics.checkNotNullExpressionValue(strC1, "shopNo");
            String strC2 = c0();
            Intrinsics.checkNotNullExpressionValue(strC2, "shopNo");
            this.fragmentArray = CollectionsKt.mutableListOf(new CommodityFragment[]{aVar.a(strC0, 1, "店铺建设中，敬请期待…"), aVar.a(strC1, 2, "店铺建设中，敬请期待…"), aVar.a(strC2, 3, "店铺建设中，敬请期待…")});
            mBinding.f10281a.setOffscreenPageLimit(listListOf.size());
            viewPagerAdapter.a(listListOf, this.fragmentArray);
            mBinding.f10282a.setViewPager(mBinding.f10281a, listListOf);
            mBinding.f10282a.setOnTabSelectListener(new c());
        }
    }

    public final void e0() {
        final float fC = cr2.c(this, 20.0f);
        Integer value = getMViewModel().e().c().getValue();
        if (value == null) {
            value = 0;
        }
        int iIntValue = value.intValue();
        final MallActivityMerchantsBinding mBinding = getMBinding();
        if (mBinding != null) {
            Toolbar toolbar = mBinding.f10280a;
            ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
            layoutParams.height += iIntValue;
            toolbar.setLayoutParams(layoutParams);
            mBinding.f10280a.setPadding(0, iIntValue, 0, 0);
            mBinding.f10283a.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.zj.adlib.am5
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                    MerchantsActivity.f0(mBinding, this, fC, appBarLayout, i);
                }
            });
        }
    }

    public final void g0(boolean darkMode) {
        e.p3(this).G2(R.color.transparent).T2(darkMode).q1(false).u1(R.color.white).G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_merchants;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        MerchantsVM mViewModel = getMViewModel();
        String strC0 = c0();
        Intrinsics.checkNotNullExpressionValue(strC0, "shopNo");
        mViewModel.j(strC0);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        g0(false);
        e0();
        if (getMBinding() != null) {
            View viewFindViewById = findViewById(R.id.bt_empty);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            TextView textView = (TextView) findViewById(R.id.tv_empty);
            if (textView == null) {
                return;
            }
            textView.setText("当前店铺已关闭");
        }
    }
}
