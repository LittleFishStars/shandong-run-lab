package com.huachenjie.works.page.alumni.original;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.bean.OriginalPageEntity;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR%\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/works/page/alumni/original/OriginalChannelSubVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "Lcom/huachenjie/works/page/alumni/original/OriginalChannelFragment;", "channelFragment", "", "D", "", "isRefreshData", "w", "", y6b.f, "Ljava/lang/String;", "C", "()Ljava/lang/String;", "E", "(Ljava/lang/String;)V", "originalNo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/page/alumni/original/OriginalChannelSubAdapter;", "kotlin.jvm.PlatformType", "f", "Landroidx/lifecycle/MutableLiveData;", "B", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class OriginalChannelSubVM extends BaseStateRequestModel {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public String originalNo = "";

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OriginalChannelSubAdapter> adapter = new MutableLiveData<>(new OriginalChannelSubAdapter());

    @NotNull
    public final MutableLiveData<OriginalChannelSubAdapter> B() {
        return this.adapter;
    }

    @NotNull
    /* JADX INFO: renamed from: C, reason: from getter */
    public final String getOriginalNo() {
        return this.originalNo;
    }

    public final void D(@Nullable OriginalChannelFragment channelFragment) {
        OriginalPageEntity originalPageEntityQueryCachePageEntity;
        if (u().getValue() != null || channelFragment == null || (originalPageEntityQueryCachePageEntity = channelFragment.queryCachePageEntity(this.originalNo)) == null) {
            return;
        }
        u().setValue(originalPageEntityQueryCachePageEntity);
    }

    public final void E(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originalNo = str;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, !isRefreshData, false, q(), null, new OriginalChannelSubVM$loadMoreData$1(this, null), 10, null);
    }
}
