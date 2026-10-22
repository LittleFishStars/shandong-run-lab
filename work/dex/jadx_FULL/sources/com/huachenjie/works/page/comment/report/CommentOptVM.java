package com.huachenjie.works.page.comment.report;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.page.comment.base.CommentUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/works/page/comment/report/CommentOptVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "commentNo", "", "commentType", "", "i", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "deleteResult", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class CommentOptVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> deleteResult = new MutableLiveData<>();

    public final void i(@NotNull String commentNo, int commentType) {
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        CommentUtil.f37253a.b(this, commentNo, commentType);
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        return this.deleteResult;
    }
}
