package com.huachenjie.home.page.draw;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.LotteryDrawBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR%\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u000f0\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\b8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/huachenjie/home/page/draw/LotteryDrawVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "t", "s", "p", "q", "r", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/base/bean/LotteryDrawBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "lotteryBean", "", "b", "j", "beforeRequestLotteryPage", "c", "n", "todaySignStatus", "kotlin.jvm.PlatformType", "d", j.b, "isRefreshing", "Lcom/huachenjie/home/page/draw/PointsGoodStuffAdapter;", "e", "i", "adapter", "", "K", "I", t.d, "()I", "u", "(I)V", "pageNum", "", "f", "Ljava/lang/String;", "m", "()Ljava/lang/String;", "v", "(Ljava/lang/String;)V", "refreshTime", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class LotteryDrawVM extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<LotteryDrawBean> lotteryBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> beforeRequestLotteryPage = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> todaySignStatus = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PointsGoodStuffAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    @NotNull
    public final MutableLiveData<PointsGoodStuffAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.beforeRequestLotteryPage;
    }

    @NotNull
    public final MutableLiveData<LotteryDrawBean> k() {
        return this.lotteryBean;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: m, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.todaySignStatus;
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
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.home.page.draw.LotteryDrawVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    this.this$0.o().setValue(Boolean.FALSE);
                    PointsGoodStuffAdapter value = this.this$0.i().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    PointsGoodStuffAdapter value2 = this.this$0.i().getValue();
                    if (value2 != null) {
                        value2.q();
                    }
                } else {
                    LotteryDrawVM lotteryDrawVM = this.this$0;
                    lotteryDrawVM.u(lotteryDrawVM.getPageNum() - 1);
                }
                PointsGoodStuffAdapter value3 = this.this$0.i().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new LotteryDrawVM$queryPageList$2(this, null), 11, null);
    }

    public final void r() {
        BaseViewModelExtKt.b(this, false, false, null, null, new LotteryDrawVM$querySignTodayStatus$1(this, null), 15, null);
    }

    public final void s() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        q();
    }

    public final void t() {
        BaseViewModelExtKt.b(this, false, false, null, null, new LotteryDrawVM$requestLotteryPage$1(this, null), 15, null);
    }

    public final void u(int i) {
        this.pageNum = i;
    }

    public final void v(@Nullable String str) {
        this.refreshTime = str;
    }
}
