package com.huachenjie.mine.page.dressing_table.avatar_frame;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mine.bean.AvatarFrameBean;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/avatar_frame/AvatarFrameVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", j.b, "Lcom/huachenjie/mine/bean/AvatarFrameBean;", "item", "i", "j", "p", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/mine/page/dressing_table/avatar_frame/AvatarFrameAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "b", t.d, "cancelFlag", "c", "n", "wearFlag", "d", "m", "unlockFlag", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class AvatarFrameVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<AvatarFrameAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AvatarFrameBean> cancelFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AvatarFrameBean> wearFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AvatarFrameBean> unlockFlag = new MutableLiveData<>();

    public final void i(@NotNull AvatarFrameBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        BaseViewModelExtKt.b(this, true, false, null, null, new AvatarFrameVM$cancelWear$1(item, this, null), 14, null);
    }

    public final void j(@NotNull AvatarFrameBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        BaseViewModelExtKt.b(this, true, false, null, null, new AvatarFrameVM$changeAvatarFrame$1(item, this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<AvatarFrameAdapter> k() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<AvatarFrameBean> l() {
        return this.cancelFlag;
    }

    @NotNull
    public final MutableLiveData<AvatarFrameBean> m() {
        return this.unlockFlag;
    }

    @NotNull
    public final MutableLiveData<AvatarFrameBean> n() {
        return this.wearFlag;
    }

    public final void o() {
        BaseViewModelExtKt.b(this, false, false, null, null, new AvatarFrameVM$loadAvatarFrame$1(this, null), 15, null);
    }

    public final void p(@NotNull AvatarFrameBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        BaseViewModelExtKt.b(this, true, false, null, null, new AvatarFrameVM$unlockAvatarFrame$1(item, this, null), 14, null);
    }
}
