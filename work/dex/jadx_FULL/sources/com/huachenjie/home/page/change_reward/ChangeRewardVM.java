package com.huachenjie.home.page.change_reward;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.home.bean.reward.ChangeRewardBean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/home/page/change_reward/ChangeRewardVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "k", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/home/bean/reward/ChangeRewardBean;", "b", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "changeRewardBean", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class ChangeRewardVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ChangeRewardBean> changeRewardBean = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<ChangeRewardBean> j() {
        return this.changeRewardBean;
    }

    public final void k() {
        BaseViewModelExtKt.b(this, false, false, null, null, new ChangeRewardVM$loadData$1(this, null), 15, null);
    }
}
