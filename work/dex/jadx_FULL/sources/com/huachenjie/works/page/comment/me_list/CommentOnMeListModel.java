package com.huachenjie.works.page.comment.me_list;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.external.adapter.CommentOnMeAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/page/comment/me_list/CommentOnMeListModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "isRefreshData", "", "w", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/external/adapter/CommentOnMeAdapter;", "f", "Landroidx/lifecycle/MutableLiveData;", "B", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class CommentOnMeListModel extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CommentOnMeAdapter> adapter = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<CommentOnMeAdapter> B() {
        return this.adapter;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, false, false, q(), null, new CommentOnMeListModel$loadMoreData$1(this, null), 11, null);
    }
}
