package com.huachenjie.mall.dialog.poster;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.bean.PosterDetailBean;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00078\u0006¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f¨\u0006 "}, d2 = {"Lcom/huachenjie/mall/dialog/poster/CreatePosterVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", CreatePosterDialog.SHARE_NO, "", "p", j.b, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/mall/dialog/poster/PosterBgAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "b", "n", "posterUrl", "c", "k", CreatePosterDialog.SHARE_GOODS_DES, "d", "j", "avatar", "e", t.d, UserConstants.USER_PARAMS.b, "Lcom/huachenjie/mall/bean/PosterDetailBean;", "f", "m", "posterDetailBean", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CreatePosterVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<PosterBgAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> posterUrl = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> goodsDes = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> avatar = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> nickName = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PosterDetailBean> posterDetailBean = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<PosterBgAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.avatar;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.goodsDes;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.nickName;
    }

    @NotNull
    public final MutableLiveData<PosterDetailBean> m() {
        return this.posterDetailBean;
    }

    @NotNull
    public final MutableLiveData<String> n() {
        return this.posterUrl;
    }

    public final void o() {
        BaseViewModelExtKt.b(this, false, false, null, null, new CreatePosterVM$queryPosterBgList$1(this, null), 15, null);
    }

    public final void p(@NotNull String shareNo) {
        Intrinsics.checkNotNullParameter(shareNo, CreatePosterDialog.SHARE_NO);
        BaseViewModelExtKt.b(this, false, false, null, null, new CreatePosterVM$queryPosterDetail$1(shareNo, this, null), 15, null);
    }
}
