package com.huachenjie.mine.page.home.showcase;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mall.external.adapter.CommodityAdapter;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002R%\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010%\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 ¨\u0006("}, d2 = {"Lcom/huachenjie/mine/page/home/showcase/ShowcaseVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "p", "n", j.b, "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/mall/external/adapter/CommodityAdapter;", "b", "i", "adapter", "", "K", "I", "j", "()I", "q", "(I)V", "pageNum", "", "f", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "r", "(Ljava/lang/String;)V", "refreshTime", y6b.f, t.d, "s", ShowcaseFragment.USER_NO, "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class ShowcaseVM extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @Nullable
    public String userNo;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CommodityAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    @NotNull
    public final MutableLiveData<CommodityAdapter> i() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    @Nullable
    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getUserNo() {
        return this.userNo;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.isRefreshing;
    }

    public final void n() {
        this.pageNum++;
        o();
    }

    public final void o() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mine.page.home.showcase.ShowcaseVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    this.this$0.m().setValue(Boolean.FALSE);
                    CommodityAdapter value = this.this$0.i().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    CommodityAdapter value2 = this.this$0.i().getValue();
                    if (value2 != null) {
                        value2.q();
                    }
                } else {
                    ShowcaseVM showcaseVM = this.this$0;
                    showcaseVM.q(showcaseVM.getPageNum() - 1);
                }
                CommodityAdapter value3 = this.this$0.i().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new ShowcaseVM$queryPageList$2(this, null), 11, null);
    }

    public final void p() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        o();
    }

    public final void q(int i) {
        this.pageNum = i;
    }

    public final void r(@Nullable String str) {
        this.refreshTime = str;
    }

    public final void s(@Nullable String str) {
        this.userNo = str;
    }
}
