package com.huachenjie.mall.external.page.share_goods;

import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivitySelectGoodsBinding;
import com.huachenjie.mall.external.page.share_goods.SelectGoodsActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Route(path = zj7.g.SELECT_GOODS)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nJ\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002R+\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0014j\b\u0012\u0004\u0012\u00020\r`\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010!¨\u0006%"}, d2 = {"Lcom/huachenjie/mall/external/page/share_goods/SelectGoodsActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivitySelectGoodsBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "", "V", "getLayoutResID", "", "initView", "", "b0", "type", "", "code", "checked", "j0", "d0", "g0", "i0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Lkotlin/Lazy;", "c0", "()Ljava/util/ArrayList;", "selectedGoodsList", "c", "h0", "()Z", "isSingleSelect", "", "Lcom/huachenjie/mall/external/page/share_goods/SelectGoodsFragment;", "Ljava/util/List;", "fragments", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class SelectGoodsActivity extends BaseMVVMActivity<MallActivitySelectGoodsBinding, BaseTitleViewModel> {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @Nullable
    public List<SelectGoodsFragment> fragments;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy selectedGoodsList = LazyKt.lazy(new Function0<ArrayList<String>>() { // from class: com.huachenjie.mall.external.page.share_goods.SelectGoodsActivity$selectedGoodsList$2
        {
            super(0);
        }

        @NotNull
        public final ArrayList<String> invoke() {
            ArrayList<String> stringArrayListExtra = this.this$0.getIntent().getStringArrayListExtra(yj7.e.KEY_GOODS_NO_LIST);
            return stringArrayListExtra == null ? new ArrayList<>() : stringArrayListExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy isSingleSelect = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.external.page.share_goods.SelectGoodsActivity$isSingleSelect$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m483invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra(yj7.e.KEY_GOODS_SINGLE_SELECT, false));
        }
    });

    public static final void e0(SelectGoodsActivity selectGoodsActivity, View view) {
        Intrinsics.checkNotNullParameter(selectGoodsActivity, "this$0");
        selectGoodsActivity.finish();
    }

    public static final void f0(SelectGoodsActivity selectGoodsActivity, View view) {
        Intrinsics.checkNotNullParameter(selectGoodsActivity, "this$0");
        if (selectGoodsActivity.h0()) {
            selectGoodsActivity.finish();
        } else {
            selectGoodsActivity.i0();
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, BaseTitleViewModel> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()));
    }

    public final boolean b0() {
        if (c0().size() >= 10) {
            fv5.b("超出最大可选数量");
        }
        return c0().size() < 10;
    }

    @NotNull
    public final ArrayList<String> c0() {
        return (ArrayList) this.selectedGoodsList.getValue();
    }

    public final void d0() {
        String str;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean background = bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1);
        if (h0()) {
            str = "选择分享商品";
        } else {
            str = "选择分享商品 (" + c0().size() + "/10)";
        }
        BindingTitleBean showRightText = background.setTitleName(str).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.i48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectGoodsActivity.e0(this.f42277a, view);
            }
        }).setShowDivider(true).setShowRightText(true);
        if (!h0()) {
            showRightText.setRightButtonText("确认");
        }
        mutableLiveDataI.setValue(showRightText.setRightButtonTextColor(-10155284).setRightTextClick(new View.OnClickListener() { // from class: com.zj.adlib.j48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectGoodsActivity.f0(this.f42507a, view);
            }
        }));
    }

    public final void g0() {
        this.fragments = CollectionsKt.listOf(SelectGoodsFragment.INSTANCE.a(2, h0()));
        getMBinding().f10393a.setViewPager(getMBinding().f34857a, new String[]{"全部商品"}, this, this.fragments);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_select_goods;
    }

    public final boolean h0() {
        return ((Boolean) this.isSingleSelect.getValue()).booleanValue();
    }

    public final void i0() {
        Intent intent = new Intent();
        intent.putStringArrayListExtra(yj7.e.KEY_GOODS_NO_LIST, c0());
        Unit unit = Unit.INSTANCE;
        setResult(-1, intent);
        finish();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        d0();
        g0();
    }

    public final void j0(int type, @NotNull String code, boolean checked) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (checked) {
            c0().add(code);
        } else {
            c0().remove(code);
        }
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean value = getMViewModel().i().getValue();
        if (value != null) {
            value.setTitleName("选择分享商品 (" + c0().size() + "/10)");
        } else {
            value = null;
        }
        mutableLiveDataI.setValue(value);
        List<SelectGoodsFragment> list = this.fragments;
        if (list != null) {
            SelectGoodsFragment selectGoodsFragment = (SelectGoodsFragment) CollectionsKt.getOrNull(list, type != 1 ? 0 : 1);
            if (selectGoodsFragment != null) {
                selectGoodsFragment.updateSelected(code, checked);
            }
        }
    }
}
