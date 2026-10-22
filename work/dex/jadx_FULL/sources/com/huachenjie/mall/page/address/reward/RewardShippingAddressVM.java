package com.huachenjie.mall.page.address.reward;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0002H\u0002R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u000b0\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010,\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'¨\u0006/"}, d2 = {"Lcom/huachenjie/mall/page/address/reward/RewardShippingAddressVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "s", "q", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "address", "j", "t", "r", "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "showEmpty", "kotlin.jvm.PlatformType", "c", "p", "isRefreshing", "Lcom/huachenjie/mall/page/address/reward/RewardShippingAddressAdapter;", "d", "k", "adapter", "", "K", "I", "m", "()I", "v", "(I)V", "pageNum", "", "f", "Ljava/lang/String;", "n", "()Ljava/lang/String;", "w", "(Ljava/lang/String;)V", "refreshTime", y6b.f, t.d, "u", "oldAddressNo", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class RewardShippingAddressVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @Nullable
    public String oldAddressNo;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showEmpty = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<RewardShippingAddressAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    public final void j(@NotNull ShippingAddressBean address) {
        Intrinsics.checkNotNullParameter(address, "address");
        BaseViewModelExtKt.b(this, true, false, null, null, new RewardShippingAddressVM$deleteAddress$1(address, this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<RewardShippingAddressAdapter> k() {
        return this.adapter;
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
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.page.address.reward.RewardShippingAddressVM$queryPageList$1
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
                    RewardShippingAddressAdapter value = this.this$0.k().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                } else {
                    RewardShippingAddressVM rewardShippingAddressVM = this.this$0;
                    rewardShippingAddressVM.v(rewardShippingAddressVM.getPageNum() - 1);
                }
                RewardShippingAddressAdapter value2 = this.this$0.k().getValue();
                if (value2 != null && (loadMoreModule = value2.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new RewardShippingAddressVM$queryPageList$2(this, null), 11, null);
    }

    public final void s() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        r();
    }

    public final void t(@NotNull ShippingAddressBean address) {
        Intrinsics.checkNotNullParameter(address, "address");
        BaseViewModelExtKt.b(this, true, false, null, null, new RewardShippingAddressVM$setDefaultAddress$1(address, this, null), 14, null);
    }

    public final void u(@Nullable String str) {
        this.oldAddressNo = str;
    }

    public final void v(int i) {
        this.pageNum = i;
    }

    public final void w(@Nullable String str) {
        this.refreshTime = str;
    }
}
