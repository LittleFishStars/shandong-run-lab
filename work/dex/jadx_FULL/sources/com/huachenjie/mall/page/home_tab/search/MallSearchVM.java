package com.huachenjie.mall.page.home_tab.search;

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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0002R%\u0010\u000f\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R%\u0010%\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b8\u0006¢\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b$\u0010\u000eR%\u0010(\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b8\u0006¢\u0006\f\n\u0004\b&\u0010\f\u001a\u0004\b'\u0010\u000eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!¨\u0006."}, d2 = {"Lcom/huachenjie/mall/page/home_tab/search/MallSearchVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "keyword", "", "r", "p", "q", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/mall/external/adapter/CommodityAdapter;", "b", "i", "adapter", "", "K", "I", "k", "()I", "t", "(I)V", "pageNum", "f", "Ljava/lang/String;", t.d, "()Ljava/lang/String;", "u", "(Ljava/lang/String;)V", "refreshTime", "c", "m", "showHistory", "d", "n", "showHistoryDelete", y6b.f, "j", "s", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class MallSearchVM extends BaseViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CommodityAdapter> adapter;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showHistory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showHistoryDelete;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public String keyword;

    public MallSearchVM() {
        Boolean bool = Boolean.FALSE;
        this.isRefreshing = new MutableLiveData<>(bool);
        this.adapter = new MutableLiveData<>();
        this.pageNum = 1;
        this.showHistory = new MutableLiveData<>(Boolean.TRUE);
        this.showHistoryDelete = new MutableLiveData<>(bool);
        this.keyword = "";
    }

    @NotNull
    public final MutableLiveData<CommodityAdapter> i() {
        return this.adapter;
    }

    @NotNull
    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getKeyword() {
        return this.keyword;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.showHistory;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.showHistoryDelete;
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
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.page.home_tab.search.MallSearchVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    this.this$0.o().setValue(Boolean.FALSE);
                    CommodityAdapter value = this.this$0.i().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    CommodityAdapter value2 = this.this$0.i().getValue();
                    if (value2 != null) {
                        value2.q();
                    }
                } else {
                    MallSearchVM mallSearchVM = this.this$0;
                    mallSearchVM.t(mallSearchVM.getPageNum() - 1);
                }
                CommodityAdapter value3 = this.this$0.i().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new MallSearchVM$queryPageList$2(this, null), 11, null);
    }

    public final void r(@NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        CommodityAdapter value = this.adapter.getValue();
        if (value != null) {
            value.setList(null);
        }
        CommodityAdapter value2 = this.adapter.getValue();
        if (value2 != null) {
            value2.q();
        }
        this.keyword = keyword;
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        q();
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyword = str;
    }

    public final void t(int i) {
        this.pageNum = i;
    }

    public final void u(@Nullable String str) {
        this.refreshTime = str;
    }
}
