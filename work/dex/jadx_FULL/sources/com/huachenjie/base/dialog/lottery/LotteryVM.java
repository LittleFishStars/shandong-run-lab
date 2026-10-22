package com.huachenjie.base.dialog.lottery;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004R%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001f\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\n8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/base/dialog/lottery/LotteryVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "lotteryNo", "", "inspiration", "awardNo", "source", "", "i", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "title", "b", "j", "requestSuccess", "Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "c", "k", "rewardInfoBean", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class LotteryVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> title = new MutableLiveData<>("");

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> requestSuccess = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<RewardInfoBean> rewardInfoBean = new MutableLiveData<>();

    public final void i(@NotNull String lotteryNo, int inspiration, @NotNull String awardNo, int source) {
        Intrinsics.checkNotNullParameter(lotteryNo, "lotteryNo");
        Intrinsics.checkNotNullParameter(awardNo, "awardNo");
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.base.dialog.lottery.LotteryVM$awardDraw$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.j().setValue(0);
                MutableLiveData<RewardInfoBean> mutableLiveDataK = this.this$0.k();
                String message = resultException.getMessage();
                if (message == null) {
                    message = "";
                }
                mutableLiveDataK.setValue(new RewardInfoBean(null, 0L, 0L, 0, null, null, 0L, 0, message, null, false, 1791, null));
                return Boolean.FALSE;
            }
        }, null, new LotteryVM$awardDraw$2(source, lotteryNo, inspiration, awardNo, this, null), 9, null);
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        return this.requestSuccess;
    }

    @NotNull
    public final MutableLiveData<RewardInfoBean> k() {
        return this.rewardInfoBean;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.title;
    }
}
