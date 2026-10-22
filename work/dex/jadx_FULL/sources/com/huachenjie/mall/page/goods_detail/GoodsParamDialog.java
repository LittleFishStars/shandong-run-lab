package com.huachenjie.mall.page.goods_detail;

import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailAttribute;
import com.huachenjie.mall.databinding.MallDialogGoodsParamBinding;
import com.zj.adlib.fx7;
import com.zj.adlib.hk0;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsParamDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/mall/databinding/MallDialogGoodsParamBinding;", "Lcom/huachenjie/mall/page/goods_detail/GoodsParamVM;", "", "initAdapter", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "initView", "<init>", "()V", "Companion", "a", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class GoodsParamDialog extends BaseMVVMBottomDialogFragment<MallDialogGoodsParamBinding, GoodsParamVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_GOODS_ATTRIBUTE_LIST = "goods_attribute_list";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsParamDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/mall/page/goods_detail/GoodsParamDialog;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GoodsParamDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.goods_detail.GoodsParamDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsParamDialog$b;", "", "Ljava/util/ArrayList;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailAttribute;", "Lkotlin/collections/ArrayList;", "goodsAttributeList", "Lcom/huachenjie/mall/page/goods_detail/GoodsParamDialog;", "a", "", "KEY_GOODS_ATTRIBUTE_LIST", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GoodsParamDialog a(@NotNull ArrayList<GoodsDetailAttribute> goodsAttributeList) {
            Intrinsics.checkNotNullParameter(goodsAttributeList, "goodsAttributeList");
            GoodsParamDialog goodsParamDialog = new GoodsParamDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(GoodsParamDialog.KEY_GOODS_ATTRIBUTE_LIST, goodsAttributeList);
            goodsParamDialog.setArguments(bundle);
            return goodsParamDialog;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAdapter() {
        MutableLiveData<GoodsParamAdapter> mutableLiveDataI = ((GoodsParamVM) getMViewModel()).i();
        GoodsParamAdapter goodsParamAdapter = new GoodsParamAdapter();
        Bundle arguments = getArguments();
        goodsParamAdapter.setList(arguments != null ? arguments.getParcelableArrayList(KEY_GOODS_ATTRIBUTE_LIST) : null);
        mutableLiveDataI.setValue(goodsParamAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return (int) (fx7.c() * 0.75f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_dialog_goods_param;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }
}
