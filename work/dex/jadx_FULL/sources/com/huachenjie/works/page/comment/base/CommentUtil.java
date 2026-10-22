package com.huachenjie.works.page.comment.base;

import android.content.Context;
import com.alibaba.ariver.kernel.RVParams;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentMoreBean;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.huachenjie.works.page.comment.report.CommentOptVM;
import com.igexin.push.g.o;
import com.zj.adlib.u66;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010'J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J[\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00132!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\u0015Je\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00132!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0015J\u001e\u0010\"\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J-\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/huachenjie/works/page/comment/base/CommentUtil;", "", "Lcom/huachenjie/works/page/comment/base/BaseCommentVM;", "viewModel", "", yj7.g.WORKS_NO, "", "commentType", "", "c", "Lcom/huachenjie/works/bean/comment/CommentBean;", "comment", "Lcom/huachenjie/works/bean/comment/CommentMoreBean;", "moreBean", "d", "Landroid/content/Context;", "context", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "commentBean", "Lkotlin/Function0;", "onFail", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onSuccess", "e", "Lcom/huachenjie/works/bean/comment/CommentReplyBean;", "commentReplyBean", "", RVParams.LONG_SHOW_LOADING, "replyBean", y6b.f, "Lcom/huachenjie/works/page/comment/report/CommentOptVM;", "commentNo", "b", "localPath", "i", "(Landroid/content/Context;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class CommentUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CommentUtil f37253a = new CommentUtil();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/works/page/comment/base/CommentUtil$a", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f37254a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Ref.ObjectRef<String> f14887a;

        public a(Ref.ObjectRef<String> objectRef, CountDownLatch countDownLatch) {
            this.f14887a = objectRef;
            this.f37254a = countDownLatch;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            this.f37254a.countDown();
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            Ref.ObjectRef<String> objectRef = this.f14887a;
            if (fileUrl == null) {
                fileUrl = "";
            }
            objectRef.element = fileUrl;
            this.f37254a.countDown();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(CommentUtil commentUtil, Context context, BaseViewModel baseViewModel, CommentBean commentBean, int i, Function0 function0, Function1 function1, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            function0 = null;
        }
        commentUtil.e(context, baseViewModel, commentBean, i, function0, function1);
    }

    public final void b(@NotNull CommentOptVM viewModel, @NotNull String commentNo, int commentType) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        BaseViewModelExtKt.b(viewModel, true, false, null, null, new CommentUtil$deleteComment$1(commentType, commentNo, viewModel, null), 14, null);
    }

    public final void c(@NotNull BaseCommentVM viewModel, @NotNull String worksNo, int commentType) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        BaseViewModelExtKt.b(viewModel, false, false, null, null, new CommentUtil$loadCommentData$1(commentType, viewModel, worksNo, null), 15, null);
    }

    public final void d(@NotNull final BaseCommentVM viewModel, @NotNull final CommentBean comment, @NotNull final CommentMoreBean moreBean, int commentType) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(moreBean, "moreBean");
        BaseViewModelExtKt.b(viewModel, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.comment.base.CommentUtil$loadCommentReply$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                moreBean.setLoading(false);
                BaseCommentAdapter value = viewModel.i().getValue();
                if (value != null) {
                    CommentBean commentBean = comment;
                    CommentMoreBean commentMoreBean = moreBean;
                    List<BaseNode> childNode = commentBean.getChildNode();
                    value.nodeSetData(commentBean, childNode != null ? childNode.indexOf(commentMoreBean) : 0, commentMoreBean);
                }
                return Boolean.FALSE;
            }
        }, null, new CommentUtil$loadCommentReply$2(commentType, comment, viewModel, moreBean, null), 11, null);
    }

    public final void e(@NotNull Context context, @NotNull BaseViewModel viewModel, @NotNull CommentBean commentBean, int commentType, @Nullable final Function0<Unit> onFail, @NotNull Function1<? super CommentBean, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(commentBean, "commentBean");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        BaseViewModelExtKt.b(viewModel, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.comment.base.CommentUtil$publishComment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                Function0<Unit> function0 = onFail;
                if (function0 != null) {
                    function0.invoke();
                }
                return Boolean.FALSE;
            }
        }, null, new CommentUtil$publishComment$2(commentBean, onFail, commentType, context, onSuccess, null), 11, null);
    }

    public final void g(@NotNull Context context, @NotNull BaseViewModel viewModel, @NotNull CommentReplyBean commentReplyBean, boolean showLoading, int commentType, @Nullable final Function0<Unit> onFail, @NotNull Function1<? super CommentReplyBean, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(commentReplyBean, "commentReplyBean");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        BaseViewModelExtKt.b(viewModel, showLoading, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.comment.base.CommentUtil$publishCommentReply$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                Function0<Unit> function0 = onFail;
                if (function0 != null) {
                    function0.invoke();
                }
                return Boolean.FALSE;
            }
        }, null, new CommentUtil$publishCommentReply$2(commentReplyBean, onFail, commentType, context, onSuccess, null), 10, null);
    }

    public final Object i(Context context, String str, int i, Continuation<? super String> continuation) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        u66.d(context, CommentDelegate.f37252a.i(i), str, new a(objectRef, countDownLatch));
        countDownLatch.await();
        return objectRef.element;
    }
}
