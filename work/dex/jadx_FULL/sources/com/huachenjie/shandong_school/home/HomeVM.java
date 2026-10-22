package com.huachenjie.shandong_school.home;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.ActivityPopBean;
import com.huachenjie.base.bean.UserThirdInfo;
import com.huachenjie.common.bean.VersionUpgrade;
import com.huachenjie.common.dialog.VersionUpgradeDialog;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.av3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\u0002R\u001f\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00138\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00138\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001f\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00138\u0006¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018¨\u0006("}, d2 = {"Lcom/huachenjie/shandong_school/home/HomeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "q", "s", "r", "j", j.b, "", "activityNo", "u", "t", "authAgreementCode", "", "status", "i", "cid", "v", "p", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/VersionUpgrade;", "a", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", VersionUpgradeDialog.x, "", "b", t.d, "flashCoinsRedDot", "Lcom/huachenjie/base/bean/ActivityPopBean;", "c", "k", "activityPopInfo", "Lcom/huachenjie/base/bean/UserThirdInfo;", "d", "m", "userThirdInfo", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class HomeVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<VersionUpgrade> versionUpgrade = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> flashCoinsRedDot = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ActivityPopBean> activityPopInfo = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<UserThirdInfo> userThirdInfo = new MutableLiveData<>();

    public final void i(@NotNull String authAgreementCode, int status) {
        Intrinsics.checkNotNullParameter(authAgreementCode, "authAgreementCode");
        BaseViewModelExtKt.b(this, false, false, null, null, new HomeVM$bindAuthAgreementNew$1(authAgreementCode, status, null), 15, null);
    }

    public final void j() {
        BaseViewModelExtKt.b(this, false, false, null, null, new HomeVM$checkFlashCoinsRedDot$1(this, null), 15, null);
    }

    @NotNull
    public final MutableLiveData<ActivityPopBean> k() {
        return this.activityPopInfo;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.flashCoinsRedDot;
    }

    @NotNull
    public final MutableLiveData<UserThirdInfo> m() {
        return this.userThirdInfo;
    }

    @NotNull
    public final MutableLiveData<VersionUpgrade> n() {
        return this.versionUpgrade;
    }

    public final void o() {
        BaseViewModelExtKt.b(this, false, false, null, null, new HomeVM$queryActivityPopInfo$1(this, null), 15, null);
    }

    public final void p() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.shandong_school.home.HomeVM$queryBrandPromotionConfig$1
            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                return Boolean.FALSE;
            }
        }, null, new HomeVM$queryBrandPromotionConfig$2(null), 11, null);
    }

    public final void q() {
        BaseViewModelExtKt.b(this, false, false, null, null, new HomeVM$queryCommonUserInfo$1(null), 15, null);
    }

    public final void r() {
        av3.f15400a.h();
    }

    public final void s() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.shandong_school.home.HomeVM$queryUpgrade$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.n().setValue(null);
                return Boolean.FALSE;
            }
        }, null, new HomeVM$queryUpgrade$2(this, null), 11, null);
    }

    public final void t() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.shandong_school.home.HomeVM$queryUserThirdInfo$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.m().setValue(null);
                return Boolean.FALSE;
            }
        }, null, new HomeVM$queryUserThirdInfo$2(this, null), 11, null);
    }

    public final void u(@NotNull String activityNo) {
        Intrinsics.checkNotNullParameter(activityNo, "activityNo");
        BaseViewModelExtKt.b(this, false, false, null, null, new HomeVM$setActivityRead$1(activityNo, null), 15, null);
    }

    public final void v(@NotNull String cid) {
        Intrinsics.checkNotNullParameter(cid, "cid");
        BaseViewModelExtKt.b(this, false, false, null, null, new HomeVM$updateGeTuiCid$1(cid, null), 15, null);
    }
}
