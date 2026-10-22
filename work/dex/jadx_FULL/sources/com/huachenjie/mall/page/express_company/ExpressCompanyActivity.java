package com.huachenjie.mall.page.express_company;

import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressCompanyBean;
import com.huachenjie.mall.bean.ExpressCompanyListBean;
import com.huachenjie.mall.databinding.MallActivityExpressCompanyBinding;
import com.huachenjie.mall.page.express_company.ExpressCompanyActivity;
import com.igexin.push.g.o;
import com.zj.adlib.hk0;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/page/express_company/ExpressCompanyActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityExpressCompanyBinding;", "Lcom/huachenjie/mall/page/express_company/ExpressCompanyVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "f0", "c0", "e0", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nExpressCompanyActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExpressCompanyActivity.kt\ncom/huachenjie/mall/page/express_company/ExpressCompanyActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,84:1\n1#2:85\n*E\n"})
public final class ExpressCompanyActivity extends BaseMVVMActivity<MallActivityExpressCompanyBinding, ExpressCompanyVM> {

    @NotNull
    public static final String t = "express_bean";

    public static final void d0(ExpressCompanyAdapter expressCompanyAdapter, ExpressCompanyActivity expressCompanyActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(expressCompanyAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(expressCompanyActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ExpressCompanyBean expressCompanyBean = (ExpressCompanyBean) expressCompanyAdapter.getData().get(i);
        Intent intent = new Intent();
        intent.putExtra(t, expressCompanyBean);
        expressCompanyActivity.setIntent(intent);
        expressCompanyActivity.setResult(-1, expressCompanyActivity.getIntent());
        expressCompanyActivity.finish();
    }

    public static final void g0(ExpressCompanyActivity expressCompanyActivity, View view) {
        Intrinsics.checkNotNullParameter(expressCompanyActivity, "this$0");
        expressCompanyActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()));
    }

    public final void c0() {
        final ExpressCompanyAdapter value = getMViewModel().j().getValue();
        if (value != null) {
            y57.d(value, 0L, new OnItemClickListener() { // from class: com.zj.adlib.tb3
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ExpressCompanyActivity.d0(value, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
        }
    }

    public final void e0() {
        getMBinding().f10211a.openIntervalCallback(500L, new Function1<String, Unit>() { // from class: com.huachenjie.mall.page.express_company.ExpressCompanyActivity$initSearch$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                List<ExpressCompanyBean> list;
                Intrinsics.checkNotNullParameter(str, o.f);
                ExpressCompanyListBean value = this.this$0.getMViewModel().l().getValue();
                if (value == null || (list = value.getList()) == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (StringsKt.contains$default(((ExpressCompanyBean) obj).getShipperName(), str, false, 2, (Object) null)) {
                        arrayList.add(obj);
                    }
                }
                ExpressCompanyAdapter value2 = this.this$0.getMViewModel().j().getValue();
                if (value2 != null) {
                    value2.setList(arrayList);
                }
                if (arrayList.isEmpty()) {
                    this.this$0.getMViewModel().k().setValue(2);
                } else {
                    this.this$0.getMViewModel().k().setValue(1);
                }
            }
        });
    }

    public final void f0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(getString(R.string.mall_express_company_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ub3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpressCompanyActivity.g0(this.f45108a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_express_company;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().k().setValue(4);
        getMViewModel().m();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        getWindow().getDecorView().setBackgroundColor(zn1.a(R.color.white));
        super.initView();
        f0();
        c0();
        e0();
    }
}
