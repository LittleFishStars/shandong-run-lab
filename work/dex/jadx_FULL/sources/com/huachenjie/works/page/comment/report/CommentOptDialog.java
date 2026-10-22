package com.huachenjie.works.page.comment.report;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksDialogCommentOptBinding;
import com.huachenjie.works.page.comment.base.CommentDelegate;
import com.huachenjie.works.page.comment.report.CommentOptDialog;
import com.igexin.push.g.o;
import com.zj.adlib.ai9;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002#$B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001b\u0010\u0011\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0015R$\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/huachenjie/works/page/comment/report/CommentOptDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogCommentOptBinding;", "Lcom/huachenjie/works/page/comment/report/CommentOptVM;", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "", "initDataObserve", "commentType$delegate", "Lkotlin/Lazy;", "getCommentType", "()I", "commentType", "", "authCode$delegate", "getAuthCode", "()Ljava/lang/String;", CommentOptDialog.KEY_AUTH_CODE, "appUserCode$delegate", "getAppUserCode", "appUserCode", "commentNo$delegate", "getCommentNo", CommentOptDialog.KEY_COMMENT_NO, "Lkotlin/Function1;", "deleteCallback", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "Companion", "a", "b", "works_release"}, k = 1, mv = {1, 8, 0})
public final class CommentOptDialog extends BaseMVVMBottomDialogFragment<WorksDialogCommentOptBinding, CommentOptVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_APP_USER_CODE = "appUserCode";

    @NotNull
    private static final String KEY_AUTH_CODE = "authCode";

    @NotNull
    private static final String KEY_COMMENT_NO = "commentNo";

    @NotNull
    private static final String KEY_COMMENT_TYPE = "comment_type";

    @Nullable
    private Function1<? super Integer, Unit> deleteCallback;

    /* JADX INFO: renamed from: commentType$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy commentType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.comment.report.CommentOptDialog$commentType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m914invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("comment_type") : 1);
        }
    });

    /* JADX INFO: renamed from: authCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy authCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.comment.report.CommentOptDialog$authCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("authCode")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: appUserCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy appUserCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.comment.report.CommentOptDialog$appUserCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("appUserCode")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: commentNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy commentNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.comment.report.CommentOptDialog$commentNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("commentNo")) == null) ? "" : string;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/works/page/comment/report/CommentOptDialog$a;", "", "Landroid/view/View;", "view", "", "b", "d", "<init>", "(Lcom/huachenjie/works/page/comment/report/CommentOptDialog;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void c(CommentOptDialog commentOptDialog, View view) {
            Intrinsics.checkNotNullParameter(commentOptDialog, "this$0");
            CommentOptVM commentOptVMAccess$getMViewModel = CommentOptDialog.access$getMViewModel(commentOptDialog);
            String commentNo = commentOptDialog.getCommentNo();
            Intrinsics.checkNotNullExpressionValue(commentNo, CommentOptDialog.KEY_COMMENT_NO);
            commentOptVMAccess$getMViewModel.i(commentNo, commentOptDialog.getCommentType());
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Context contextRequireContext = CommentOptDialog.this.requireContext();
            final CommentOptDialog commentOptDialog = CommentOptDialog.this;
            ft1.u(contextRequireContext, "确定删除该评论吗？", "确定", new View.OnClickListener() { // from class: com.zj.adlib.jp1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommentOptDialog.a.c(commentOptDialog, view2);
                }
            });
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (Intrinsics.areEqual(ai9.e().getUserId(), CommentOptDialog.this.getAppUserCode())) {
                fv5.b(CommentOptDialog.this.getString(R.string.works_comment_report_self));
                return;
            }
            Postcard postcardWithString = ARouter.getInstance().build(RoutePathConstants.SocialContact.d).withString(UserConstants.CHAT_PARAMS.f, CommentOptDialog.this.getCommentNo());
            CommentDelegate commentDelegate = CommentDelegate.f37252a;
            postcardWithString.withInt(UserConstants.CHAT_PARAMS.h, commentDelegate.g(CommentOptDialog.this.getCommentType())).withInt(UserConstants.CHAT_PARAMS.e, commentDelegate.h(CommentOptDialog.this.getCommentType())).navigation();
            CommentOptDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.comment.report.CommentOptDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J:\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/page/comment/report/CommentOptDialog$b;", "", "", "commentType", "", CommentOptDialog.KEY_COMMENT_NO, CommentOptDialog.KEY_AUTH_CODE, "appUserCode", "Lkotlin/Function1;", "", "onDelete", "Lcom/huachenjie/works/page/comment/report/CommentOptDialog;", "a", "KEY_APP_USER_CODE", "Ljava/lang/String;", "KEY_AUTH_CODE", "KEY_COMMENT_NO", "KEY_COMMENT_TYPE", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CommentOptDialog a(int commentType, @NotNull String commentNo, @NotNull String authCode, @NotNull String appUserCode, @NotNull Function1<? super Integer, Unit> onDelete) {
            Intrinsics.checkNotNullParameter(commentNo, CommentOptDialog.KEY_COMMENT_NO);
            Intrinsics.checkNotNullParameter(authCode, CommentOptDialog.KEY_AUTH_CODE);
            Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
            Intrinsics.checkNotNullParameter(onDelete, "onDelete");
            CommentOptDialog commentOptDialog = new CommentOptDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(CommentOptDialog.KEY_COMMENT_TYPE, commentType);
            bundle.putString(CommentOptDialog.KEY_COMMENT_NO, commentNo);
            bundle.putString(CommentOptDialog.KEY_AUTH_CODE, authCode);
            bundle.putString("appUserCode", appUserCode);
            commentOptDialog.setArguments(bundle);
            commentOptDialog.deleteCallback = onDelete;
            return commentOptDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37259a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37259a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37259a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37259a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ CommentOptVM access$getMViewModel(CommentOptDialog commentOptDialog) {
        return (CommentOptVM) commentOptDialog.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAppUserCode() {
        return (String) this.appUserCode.getValue();
    }

    private final String getAuthCode() {
        return (String) this.authCode.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCommentNo() {
        return (String) this.commentNo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCommentType() {
        return ((Number) this.commentType.getValue()).intValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_comment_opt;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel());
        pairArr[1] = TuplesKt.to(Integer.valueOf(qk0.k), new a());
        pairArr[2] = TuplesKt.to(Integer.valueOf(qk0.G), Boolean.valueOf(Intrinsics.areEqual(getAuthCode(), ai9.e().getUserId()) || Intrinsics.areEqual(getAppUserCode(), ai9.e().getUserId())));
        return MapsKt.mapOf(pairArr);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        super.initDataObserve();
        ((CommentOptVM) getMViewModel()).j().observe(this, new c(new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.comment.report.CommentOptDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                Intrinsics.checkNotNullExpressionValue(num, o.f);
                if (num.intValue() > 0) {
                    Function1 function1 = CommentOptDialog.this.deleteCallback;
                    if (function1 != null) {
                        function1.invoke(num);
                    }
                    CommentOptDialog.this.dismiss();
                }
            }
        }));
    }
}
