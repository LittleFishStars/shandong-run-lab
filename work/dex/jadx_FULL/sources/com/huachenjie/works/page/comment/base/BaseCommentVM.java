package com.huachenjie.works.page.comment.base;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentMoreBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R%\u0010%\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00040\u00040\r8\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012¨\u0006("}, d2 = {"Lcom/huachenjie/works/page/comment/base/BaseCommentVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", yj7.g.WORKS_NO, "", "commentType", "", "m", "Lcom/huachenjie/works/bean/comment/CommentBean;", "comment", "Lcom/huachenjie/works/bean/comment/CommentMoreBean;", "moreBean", "n", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/page/comment/base/BaseCommentAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "f", "Ljava/lang/String;", t.d, "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "refreshTime", "K", "I", "k", "()I", j.b, "(I)V", "pageNum", "kotlin.jvm.PlatformType", "b", "j", "listCommentCount", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class BaseCommentVM extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BaseCommentAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> listCommentCount = new MutableLiveData<>(0);

    @NotNull
    public final MutableLiveData<BaseCommentAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        return this.listCommentCount;
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

    public final void m(@NotNull String worksNo, int commentType) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        CommentUtil.f37253a.c(this, worksNo, commentType);
    }

    public final void n(@NotNull CommentBean comment, @NotNull CommentMoreBean moreBean, int commentType) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(moreBean, "moreBean");
        CommentUtil.f37253a.d(this, comment, moreBean, commentType);
    }

    public final void o(int i) {
        this.pageNum = i;
    }

    public final void p(@Nullable String str) {
        this.refreshTime = str;
    }
}
