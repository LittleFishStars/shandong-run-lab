package com.huachenjie.mall.page.home_tab.cat;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityCatBinding;
import com.huachenjie.mall.page.home_tab.MallItemFragment;
import com.huachenjie.mall.page.home_tab.cat.MallCatActivity;
import com.zj.adlib.hk0;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Route(path = zj7.g.MALL_CAT)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/mall/page/home_tab/cat/MallCatActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityCatBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "getLayoutResID", "", "", "V", "", "initView", "initData", "", "b", "Lkotlin/Lazy;", "a0", "()Ljava/lang/String;", "catNo", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class MallCatActivity extends BaseMVVMActivity<MallActivityCatBinding, BaseTitleViewModel> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy catNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.home_tab.cat.MallCatActivity$catNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("catNo");
        }
    });

    public static final void b0(MallCatActivity mallCatActivity, View view) {
        Intrinsics.checkNotNullParameter(mallCatActivity, "this$0");
        mallCatActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()));
    }

    public final String a0() {
        return (String) this.catNo.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_cat;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, MallItemFragment.Companion.b(MallItemFragment.INSTANCE, null, null, a0(), 3, null)).commit();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("").setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.r65
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MallCatActivity.b0(this.f44383a, view);
            }
        }));
    }
}
