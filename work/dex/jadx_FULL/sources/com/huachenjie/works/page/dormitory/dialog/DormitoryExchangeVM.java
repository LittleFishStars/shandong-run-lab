package com.huachenjie.works.page.dormitory.dialog;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J*\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R%\u0010\u0011\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/page/dormitory/dialog/DormitoryExchangeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "perksNo", "", "charmCost", "Lkotlin/Function1;", "", "", RenderCallContext.TYPE_CALLBACK, "j", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "selectedType", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class DormitoryExchangeVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> selectedType = new MutableLiveData<>(0);

    @NotNull
    public final MutableLiveData<Integer> i() {
        return this.selectedType;
    }

    public final void j(@NotNull String perksNo, int charmCost, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(perksNo, "perksNo");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        BaseViewModelExtKt.b(this, true, false, null, null, new DormitoryExchangeVM$redeemMemberPerks$1(perksNo, charmCost, callback, null), 14, null);
    }
}
