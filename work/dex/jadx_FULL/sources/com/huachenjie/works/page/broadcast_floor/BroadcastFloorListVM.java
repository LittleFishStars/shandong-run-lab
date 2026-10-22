package com.huachenjie.works.page.broadcast_floor;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u00068\u0006¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b)\u0010\u000b¨\u0006-"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "r", "p", "q", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", BroadcastFloorFragment.BROADCAST_TYPE, "b", "j", BroadcastFloorFragment.BROADCAST_RANGE, "", "kotlin.jvm.PlatformType", "c", j.b, "isRefreshing", "Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorAdapter;", "d", "i", "adapter", "K", "I", "m", "()I", "s", "(I)V", "pageNum", "", "f", "Ljava/lang/String;", "n", "()Ljava/lang/String;", "t", "(Ljava/lang/String;)V", "refreshTime", "e", t.d, "closeBroadcastFloor", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class BroadcastFloorListVM extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> broadcastType = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> broadcastRange = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BroadcastFloorAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> closeBroadcastFloor = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<BroadcastFloorAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        return this.broadcastRange;
    }

    @NotNull
    public final MutableLiveData<Integer> k() {
        return this.broadcastType;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.closeBroadcastFloor;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: n, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.isRefreshing;
    }

    public final void p() {
        this.pageNum++;
        q();
    }

    public final void q() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorListVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                boolean z = true;
                if (resultException.getCode() == 21001) {
                    fv5.b(resultException.getMessage());
                    this.this$0.l().setValue(Boolean.TRUE);
                } else {
                    if (this.this$0.getPageNum() == 1) {
                        this.this$0.o().setValue(Boolean.FALSE);
                    } else {
                        BroadcastFloorListVM broadcastFloorListVM = this.this$0;
                        broadcastFloorListVM.s(broadcastFloorListVM.getPageNum() - 1);
                    }
                    BroadcastFloorAdapter value = this.this$0.i().getValue();
                    if (value != null && (loadMoreModule = value.getLoadMoreModule()) != null) {
                        BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                    }
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, null, new BroadcastFloorListVM$queryPageList$2(this, null), 11, null);
    }

    public void r() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        q();
    }

    public final void s(int i) {
        this.pageNum = i;
    }

    public final void t(@Nullable String str) {
        this.refreshTime = str;
    }
}
