package com.huachenjie.mall.page.goods_detail;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.SizeUtils;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpecValue;
import com.huachenjie.mall.databinding.MallActivityGoodsSpecificationPreviewBinding;
import com.zj.adlib.fx7;
import com.zj.adlib.hk0;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\r\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\rB\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u001b\u0010\u0011\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationPreviewActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityGoodsSpecificationPreviewBinding;", "Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationPreviewVM;", "", "S", "", "", "", "V", "getLayoutResID", "initView", "onBackPressed", "b", "Lkotlin/Lazy;", "a0", "()I", "specIndex", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class GoodsSpecificationPreviewActivity extends BaseMVVMActivity<MallActivityGoodsSpecificationPreviewBinding, GoodsSpecificationPreviewVM> {

    @NotNull
    public static final String A = "spec_index";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "result_position";

    @NotNull
    public static final String x = "result_spec_index";

    @NotNull
    public static final String y = "position";

    @NotNull
    public static final String z = "list";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy specIndex = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity$specIndex$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m539invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra(GoodsSpecificationPreviewActivity.A, 0));
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationPreviewActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationPreviewActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GoodsSpecificationPreviewActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationPreviewActivity$b;", "", "Landroid/content/Context;", "context", "", "position", "Ljava/util/ArrayList;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSpecValue;", "Lkotlin/collections/ArrayList;", GoodsSpecificationPreviewActivity.z, "specIndex", "Landroid/content/Intent;", "a", "", "KEY_LIST", "Ljava/lang/String;", "KEY_POSITION", "KEY_SPEC_INDEX", "RESULT_POSITION", "RESULT_SPEC_INDEX", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, int position, @NotNull ArrayList<GoodsDetailSpecValue> list, int specIndex) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
            Intent intent = new Intent(context, (Class<?>) GoodsSpecificationPreviewActivity.class);
            intent.putExtra("position", position);
            intent.putExtra(GoodsSpecificationPreviewActivity.z, list);
            intent.putExtra(GoodsSpecificationPreviewActivity.A, specIndex);
            return intent;
        }
    }

    public static final /* synthetic */ GoodsSpecificationPreviewVM Z(GoodsSpecificationPreviewActivity goodsSpecificationPreviewActivity) {
        return goodsSpecificationPreviewActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).G2(R.color.transparent).T2(false).u1(R.color.black).G1(false).k3().a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    public final int a0() {
        return ((Number) this.specIndex.getValue()).intValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_goods_specification_preview;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        float height;
        super.initView();
        getWindow().getDecorView().setBackgroundColor(-16777216);
        int intExtra = getIntent().getIntExtra("position", 0);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(z);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            return;
        }
        getMViewModel().i().setValue(Integer.valueOf(intExtra));
        getMViewModel().k().setValue(parcelableArrayListExtra);
        try {
            ImageBean specImageInfo = ((GoodsDetailSpecValue) parcelableArrayListExtra.get(0)).getSpecImageInfo();
            Intrinsics.checkNotNull(specImageInfo);
            float width = specImageInfo.getWidth();
            ImageBean specImageInfo2 = ((GoodsDetailSpecValue) parcelableArrayListExtra.get(0)).getSpecImageInfo();
            Intrinsics.checkNotNull(specImageInfo2);
            height = width / specImageInfo2.getHeight();
        } catch (Exception unused) {
            height = 1.0f;
        }
        float fJ = fx7.j() / (height > 0.0f ? height : 1.0f);
        getMBinding().f34799a.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity.initView.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                GoodsSpecificationPreviewActivity.Z(GoodsSpecificationPreviewActivity.this).i().setValue(Integer.valueOf(position));
            }
        });
        ViewPager2 viewPager2 = getMBinding().f34799a;
        GoodsSpecificationPreviewAdapter goodsSpecificationPreviewAdapter = new GoodsSpecificationPreviewAdapter();
        goodsSpecificationPreviewAdapter.g(SizeUtils.g(((fx7.h() - fJ) / 2.0f) + fJ) + 20);
        goodsSpecificationPreviewAdapter.setList(parcelableArrayListExtra);
        viewPager2.setAdapter(goodsSpecificationPreviewAdapter);
        getMBinding().f34799a.setCurrentItem(intExtra, false);
        getMViewModel().j().setValue(Integer.valueOf(SizeUtils.g((fx7.h() - fJ) / 2.0f) + 12));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        Integer value = getMViewModel().i().getValue();
        if (value == null) {
            value = 0;
        }
        Intrinsics.checkNotNullExpressionValue(value, "mViewModel.currentIndex.value ?: 0");
        intent.putExtra(t, value.intValue());
        intent.putExtra(x, a0());
        Unit unit = Unit.INSTANCE;
        setResult(-1, intent);
        super.onBackPressed();
    }
}
