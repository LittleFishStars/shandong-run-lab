package com.huachenjie.mall.page.comment.detail;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.page.comment.list.CommodityCommentAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/page/comment/detail/CommentDetailVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "orderNo", "", "k", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/mall/page/comment/list/CommodityCommentAdapter;", "b", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CommentDetailVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CommodityCommentAdapter> adapter = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<CommodityCommentAdapter> j() {
        return this.adapter;
    }

    public final void k(@NotNull String orderNo) {
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new CommentDetailVM$queryMyCommentList$1(orderNo, this, null), 14, null);
    }
}
