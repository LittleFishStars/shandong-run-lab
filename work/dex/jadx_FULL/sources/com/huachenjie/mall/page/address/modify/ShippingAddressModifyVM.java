package com.huachenjie.mall.page.address.modify;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR%\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00070\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010+\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&¨\u0006."}, d2 = {"Lcom/huachenjie/mall/page/address/modify/ShippingAddressModifyVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "s", "q", "r", "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "showEmpty", "c", "k", "canModify", "kotlin.jvm.PlatformType", "d", "p", "isRefreshing", "Lcom/huachenjie/mall/page/address/modify/ShippingAddressModifyAdapter;", "e", "j", "adapter", "", "K", "I", "m", "()I", "u", "(I)V", "pageNum", "", "f", "Ljava/lang/String;", "n", "()Ljava/lang/String;", "v", "(Ljava/lang/String;)V", "refreshTime", y6b.f, t.d, "t", "oldAddressNo", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ShippingAddressModifyVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showEmpty = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> canModify;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ShippingAddressModifyAdapter> adapter;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @Nullable
    public String oldAddressNo;

    public ShippingAddressModifyVM() {
        Boolean bool = Boolean.FALSE;
        this.canModify = new MutableLiveData<>(bool);
        this.isRefreshing = new MutableLiveData<>(bool);
        this.adapter = new MutableLiveData<>();
        this.pageNum = 1;
    }

    @NotNull
    public final MutableLiveData<ShippingAddressModifyAdapter> j() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.canModify;
    }

    @Nullable
    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getOldAddressNo() {
        return this.oldAddressNo;
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
        return this.showEmpty;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.isRefreshing;
    }

    public final void q() {
        this.pageNum++;
        r();
    }

    public final void r() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.page.address.modify.ShippingAddressModifyVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    this.this$0.p().setValue(Boolean.FALSE);
                    this.this$0.o().setValue(Boolean.TRUE);
                    ShippingAddressModifyAdapter value = this.this$0.j().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                } else {
                    ShippingAddressModifyVM shippingAddressModifyVM = this.this$0;
                    shippingAddressModifyVM.u(shippingAddressModifyVM.getPageNum() - 1);
                }
                ShippingAddressModifyAdapter value2 = this.this$0.j().getValue();
                if (value2 != null && (loadMoreModule = value2.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new ShippingAddressModifyVM$queryPageList$2(this, null), 11, null);
    }

    public final void s() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        this.canModify.setValue(Boolean.FALSE);
        r();
    }

    public final void t(@Nullable String str) {
        this.oldAddressNo = str;
    }

    public final void u(int i) {
        this.pageNum = i;
    }

    public final void v(@Nullable String str) {
        this.refreshTime = str;
    }
}
