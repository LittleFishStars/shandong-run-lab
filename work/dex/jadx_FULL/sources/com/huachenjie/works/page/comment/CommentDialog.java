package com.huachenjie.works.page.comment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksDialogCommentBinding;
import com.huachenjie.works.page.comment.CommentDialog;
import com.huachenjie.works.page.comment.base.BaseCommentFragment;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.fx7;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u0007¢\u0006\u0004\b*\u0010+J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0017J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u001b\u0010\u0014\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R$\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcom/huachenjie/works/page/comment/CommentDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogCommentBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "getWidth", "getHeight", "getLayoutResID", "", "getVariables", "", "onStart", "initView", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "commentType$delegate", "Lkotlin/Lazy;", "getCommentType", "()I", "commentType", "", "bizNo$delegate", "getBizNo", "()Ljava/lang/String;", "bizNo", "authCode$delegate", "getAuthCode", "authCode", "commentSource$delegate", "getCommentSource", "commentSource", "Lkotlin/Function1;", "commentCallback", "Lkotlin/jvm/functions/Function1;", "commentCount", "I", "", "showOverlay$delegate", "getShowOverlay", "()Z", "showOverlay", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class CommentDialog extends BaseMVVMDialogFragment<WorksDialogCommentBinding, BaseViewModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_AUTH_CODE = "auth_code";

    @NotNull
    private static final String KEY_BIZ_NO = "biz_no";

    @NotNull
    private static final String KEY_COMMENT_COUNT = "comment_count";

    @NotNull
    private static final String KEY_COMMENT_SOURCE = "comment_source";

    @NotNull
    private static final String KEY_COMMENT_TYPE = "comment_type";

    @NotNull
    private static final String KEY_SHOW_OVERLAY = "show_overlay";

    @Nullable
    private Function1<? super Integer, Unit> commentCallback;
    private int commentCount;

    /* JADX INFO: renamed from: commentType$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy commentType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.comment.CommentDialog$commentType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m896invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("comment_type") : 1);
        }
    });

    /* JADX INFO: renamed from: bizNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy bizNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.comment.CommentDialog$bizNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("biz_no")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: authCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy authCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.comment.CommentDialog$authCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("auth_code")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: commentSource$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy commentSource = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.comment.CommentDialog$commentSource$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m895invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("comment_source") : 1);
        }
    });

    /* JADX INFO: renamed from: showOverlay$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy showOverlay = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.works.page.comment.CommentDialog$showOverlay$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m897invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("show_overlay", true) : true);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.works.page.comment.CommentDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018JP\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/page/comment/CommentDialog$a;", "", "", "commentType", "", "bizNo", "authCode", "commentCount", "commentSource", "", "showOverlay", "Lkotlin/Function1;", "", "commentCallback", "Lcom/huachenjie/works/page/comment/CommentDialog;", "a", "KEY_AUTH_CODE", "Ljava/lang/String;", "KEY_BIZ_NO", "KEY_COMMENT_COUNT", "KEY_COMMENT_SOURCE", "KEY_COMMENT_TYPE", "KEY_SHOW_OVERLAY", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CommentDialog a(int commentType, @NotNull String bizNo, @NotNull String authCode, int commentCount, int commentSource, boolean showOverlay, @Nullable Function1<? super Integer, Unit> commentCallback) {
            Intrinsics.checkNotNullParameter(bizNo, "bizNo");
            Intrinsics.checkNotNullParameter(authCode, "authCode");
            CommentDialog commentDialog = new CommentDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(CommentDialog.KEY_COMMENT_TYPE, commentType);
            bundle.putString(CommentDialog.KEY_BIZ_NO, bizNo);
            bundle.putString(CommentDialog.KEY_AUTH_CODE, authCode);
            bundle.putInt(CommentDialog.KEY_COMMENT_COUNT, commentCount);
            bundle.putInt(CommentDialog.KEY_COMMENT_SOURCE, commentSource);
            bundle.putBoolean(CommentDialog.KEY_SHOW_OVERLAY, showOverlay);
            commentDialog.setArguments(bundle);
            commentDialog.commentCallback = commentCallback;
            return commentDialog;
        }
    }

    private final String getAuthCode() {
        return (String) this.authCode.getValue();
    }

    private final String getBizNo() {
        return (String) this.bizNo.getValue();
    }

    private final int getCommentSource() {
        return ((Number) this.commentSource.getValue()).intValue();
    }

    private final int getCommentType() {
        return ((Number) this.commentType.getValue()).intValue();
    }

    private final boolean getShowOverlay() {
        return ((Boolean) this.showOverlay.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$3$lambda$2(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(CommentDialog commentDialog, View view) {
        Intrinsics.checkNotNullParameter(commentDialog, "this$0");
        commentDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(CommentDialog commentDialog, View view) {
        Intrinsics.checkNotNullParameter(commentDialog, "this$0");
        commentDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(BaseCommentFragment baseCommentFragment, View view) {
        Intrinsics.checkNotNullParameter(baseCommentFragment, "$baseCommentFragment");
        baseCommentFragment.showCommentInput();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_comment;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, BaseViewModel> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    @SuppressLint({"ClickableViewAccessibility"})
    public void initView() {
        BLLinearLayout bLLinearLayout;
        ImageView imageView;
        BLRelativeLayout bLRelativeLayout;
        View view;
        super.initView();
        Bundle arguments = getArguments();
        this.commentCount = arguments != null ? arguments.getInt(KEY_COMMENT_COUNT) : 0;
        int iH = (int) (((double) fx7.h()) * 0.66d);
        if (!getShowOverlay() && (view = getView()) != null) {
            view.setBackground(null);
        }
        WorksDialogCommentBinding mBinding = getMBinding();
        ImageView imageView2 = mBinding != null ? mBinding.d : null;
        if (imageView2 != null) {
            imageView2.setVisibility(getCommentType() == 1 ? 0 : 8);
        }
        int i = getCommentType() == 3 ? 8 : 0;
        WorksDialogCommentBinding mBinding2 = getMBinding();
        ImageView imageView3 = mBinding2 != null ? mBinding2.e : null;
        if (imageView3 != null) {
            imageView3.setVisibility(i);
        }
        WorksDialogCommentBinding mBinding3 = getMBinding();
        ImageView imageView4 = mBinding3 != null ? mBinding3.f14043a : null;
        if (imageView4 != null) {
            imageView4.setVisibility(i);
        }
        WorksDialogCommentBinding mBinding4 = getMBinding();
        ImageView imageView5 = mBinding4 != null ? mBinding4.c : null;
        if (imageView5 != null) {
            imageView5.setVisibility(i);
        }
        WorksDialogCommentBinding mBinding5 = getMBinding();
        if (mBinding5 != null && (bLRelativeLayout = mBinding5.f14047a) != null) {
            ViewGroup.LayoutParams layoutParams = bLRelativeLayout.getLayoutParams();
            layoutParams.height = iH;
            bLRelativeLayout.setLayoutParams(layoutParams);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, iH, 0.0f);
            translateAnimation.setDuration(300L);
            bLRelativeLayout.setAnimation(translateAnimation);
            bLRelativeLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.jo1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return CommentDialog.initView$lambda$3$lambda$2(view2, motionEvent);
                }
            });
        }
        View view2 = getView();
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ko1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    CommentDialog.initView$lambda$4(this.f42867a, view3);
                }
            });
        }
        WorksDialogCommentBinding mBinding6 = getMBinding();
        if (mBinding6 != null && (imageView = mBinding6.b) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.lo1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    CommentDialog.initView$lambda$5(this.f43112a, view3);
                }
            });
        }
        BaseCommentFragment.Companion companion = BaseCommentFragment.INSTANCE;
        int commentType = getCommentType();
        String bizNo = getBizNo();
        Intrinsics.checkNotNullExpressionValue(bizNo, "bizNo");
        String authCode = getAuthCode();
        Intrinsics.checkNotNullExpressionValue(authCode, "authCode");
        final BaseCommentFragment baseCommentFragmentA = companion.a(commentType, bizNo, authCode, this.commentCount, getCommentSource(), true, new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.comment.CommentDialog$initView$baseCommentFragment$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                this.this$0.commentCount = i2;
            }
        });
        WorksDialogCommentBinding mBinding7 = getMBinding();
        if (mBinding7 != null && (bLLinearLayout = mBinding7.f14046a) != null) {
            bLLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.mo1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    CommentDialog.initView$lambda$6(baseCommentFragmentA, view3);
                }
            });
        }
        getChildFragmentManager().beginTransaction().replace(R.id.fl_comment, baseCommentFragmentA).commit();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Function1<? super Integer, Unit> function1 = this.commentCallback;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this.commentCount));
        }
        super.onDismiss(dialog);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(0.0f);
    }
}
