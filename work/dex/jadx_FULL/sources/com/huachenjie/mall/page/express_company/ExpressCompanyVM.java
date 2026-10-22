package com.huachenjie.mall.page.express_company;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mall.bean.ExpressCompanyListBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR%\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\tR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/mall/page/express_company/ExpressCompanyVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "m", "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "layoutState", "Lcom/huachenjie/mall/page/express_company/ExpressCompanyAdapter;", "kotlin.jvm.PlatformType", "c", "j", "adapter", "Lcom/huachenjie/mall/bean/ExpressCompanyListBean;", "d", t.d, "originList", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ExpressCompanyVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> layoutState = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ExpressCompanyAdapter> adapter = new MutableLiveData<>(new ExpressCompanyAdapter());

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ExpressCompanyListBean> originList = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<ExpressCompanyAdapter> j() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Integer> k() {
        return this.layoutState;
    }

    @NotNull
    public final MutableLiveData<ExpressCompanyListBean> l() {
        return this.originList;
    }

    public final void m() {
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.page.express_company.ExpressCompanyVM$queryExpressCompanyList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.k().setValue(3);
                return Boolean.FALSE;
            }
        }, null, new ExpressCompanyVM$queryExpressCompanyList$2(this, null), 10, null);
    }
}
