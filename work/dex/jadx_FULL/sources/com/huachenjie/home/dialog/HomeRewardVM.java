package com.huachenjie.home.dialog;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.home.bean.reward.HomeRewardBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/home/dialog/HomeRewardVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Lkotlin/Function0;", "", RenderCallContext.TYPE_CALLBACK, "i", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/home/bean/reward/HomeRewardBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "rewardBean", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class HomeRewardVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<HomeRewardBean> rewardBean = new MutableLiveData<>();

    public final void i(@NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        BaseViewModelExtKt.b(this, true, false, null, null, new HomeRewardVM$getReward$1(this, callback, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<HomeRewardBean> j() {
        return this.rewardBean;
    }
}
