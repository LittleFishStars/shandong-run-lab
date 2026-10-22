package com.huachenjie.works.page.comment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.triver.basic.api.RequestPermission;
import com.blankj.utilcode.util.KeyboardUtils;
import com.huachenjie.base.bean.RichUserBean;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.util.rich_text.RichEditView;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.im.page.emoji.EmojiInputCallback;
import com.huachenjie.im.page.emoji.EmojiPanelFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentImageBean;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.huachenjie.works.bean.comment.CommentUserBean;
import com.huachenjie.works.bean.comment.TargetComment;
import com.huachenjie.works.databinding.WorksDialogCommentInputBinding;
import com.huachenjie.works.page.comment.CommentInputDialog;
import com.huachenjie.works.page.comment.CommentInputDialog.ClickProxy;
import com.huachenjie.works.page.user.InputSelectUserFragment;
import com.huachenjie.works.widget.PubWorkContentEditView;
import com.igexin.push.g.o;
import com.vanniktech.emoji.EmojiEditText;
import com.zj.adlib.ai9;
import com.zj.adlib.fv5;
import com.zj.adlib.jj8;
import com.zj.adlib.qk0;
import com.zj.adlib.v39;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 O2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002PQB\u0007¢\u0006\u0004\bM\u0010NJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0017J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\"\u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u00101\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u0010-R$\u00104\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R$\u00107\u001a\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010;\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001f\u0010A\u001a\u00060=R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010+\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010+\u001a\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006R"}, d2 = {"Lcom/huachenjie/works/page/comment/CommentInputDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogCommentInputBinding;", "Lcom/huachenjie/works/page/comment/CommentInputVM;", "", "initCommentChange", "Landroid/view/View;", "view", "", "default", "changeInputViewLayout", "initEtEvent", "initEmojiPanel", "initKeyBoardListener", "", "height", "fitEmojiPanelViewHeight", "showKeyboard", "hideKeyboard", "goOtherPageAndHideKeyboard", "backAndShowKeyboard", "getWidth", "getHeight", "getLayoutResID", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "onStart", "", "", "getVariables", "initData", "initView", "onDestroyView", "onResume", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "", "bizNo$delegate", "Lkotlin/Lazy;", "getBizNo", "()Ljava/lang/String;", "bizNo", "targetCommentNo$delegate", "getTargetCommentNo", "targetCommentNo", "Lkotlin/Function1;", "Lcom/huachenjie/works/bean/comment/CommentBean;", "onCommentCallback", "Lkotlin/jvm/functions/Function1;", "Lcom/huachenjie/works/bean/comment/CommentReplyBean;", "onReplyCallback", "isShowingKeyboard", "Z", "backNeedShowKeyboard", "commentInputStyle", "I", "Lcom/huachenjie/works/page/comment/CommentInputDialog$ClickProxy;", "clickProxy$delegate", "getClickProxy", "()Lcom/huachenjie/works/page/comment/CommentInputDialog$ClickProxy;", "clickProxy", "Landroid/os/Handler;", "handler$delegate", "getHandler", "()Landroid/os/Handler;", "handler", "Lcom/huachenjie/im/page/emoji/EmojiPanelFragment;", "emojiPanelFragment", "Lcom/huachenjie/im/page/emoji/EmojiPanelFragment;", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "<init>", "()V", "Companion", "ClickProxy", "a", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCommentInputDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentInputDialog.kt\ncom/huachenjie/works/page/comment/CommentInputDialog\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,546:1\n65#2,16:547\n93#2,3:563\n95#3,14:566\n*S KotlinDebug\n*F\n+ 1 CommentInputDialog.kt\ncom/huachenjie/works/page/comment/CommentInputDialog\n*L\n190#1:547,16\n190#1:563,3\n329#1:566,14\n*E\n"})
public final class CommentInputDialog extends BaseMVVMDialogFragment<WorksDialogCommentInputBinding, CommentInputVM> {
    private static final int COMMENT_INPUT_DEFAULT = 0;
    private static final int COMMENT_INPUT_LARGE = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_BIZ_NO = "biz_no";

    @NotNull
    private static final String KEY_COMMENT_TYPE = "comment_type";

    @NotNull
    private static final String KEY_HINT = "hint";

    @NotNull
    private static final String KEY_TARGET_COMMENT_NO = "target_comment_no";
    private static final int MAX_GOODS_NAME_LENGTH = 10;
    private static final int REQUEST_CODE = 1002;

    @NotNull
    private static final String USER_TYPE_START = "@";
    private boolean backNeedShowKeyboard;
    private int commentInputStyle;

    @Nullable
    private EmojiPanelFragment emojiPanelFragment;
    private boolean isShowingKeyboard;

    @Nullable
    private Function1<? super CommentBean, Unit> onCommentCallback;

    @Nullable
    private Function1<? super CommentReplyBean, Unit> onReplyCallback;
    private MediaPickerLauncher picker;

    /* JADX INFO: renamed from: bizNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy bizNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.comment.CommentInputDialog$bizNo$2
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

    /* JADX INFO: renamed from: targetCommentNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy targetCommentNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.comment.CommentInputDialog$targetCommentNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString("target_comment_no");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: clickProxy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy clickProxy = LazyKt.lazy(new Function0<ClickProxy>() { // from class: com.huachenjie.works.page.comment.CommentInputDialog$clickProxy$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CommentInputDialog.ClickProxy m899invoke() {
            return this.this$0.new ClickProxy();
        }
    });

    /* JADX INFO: renamed from: handler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.huachenjie.works.page.comment.CommentInputDialog$handler$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m900invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/works/page/comment/CommentInputDialog$ClickProxy;", "", "Landroid/view/View;", "view", "", "b", "d", y6b.g, y6b.f, "a", "", "isFromInputSymbol", "i", "c", "e", "f", "<init>", "(Lcom/huachenjie/works/page/comment/CommentInputDialog;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nCommentInputDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentInputDialog.kt\ncom/huachenjie/works/page/comment/CommentInputDialog$ClickProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,546:1\n1549#2:547\n1620#2,3:548\n1549#2:551\n1620#2,3:552\n*S KotlinDebug\n*F\n+ 1 CommentInputDialog.kt\ncom/huachenjie/works/page/comment/CommentInputDialog$ClickProxy\n*L\n433#1:547\n433#1:548,3\n504#1:551\n504#1:552,3\n*E\n"})
    public final class ClickProxy {

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/works/page/comment/CommentInputDialog$ClickProxy$a", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onShow", "onDismiss", "works_release"}, k = 1, mv = {1, 8, 0})
        public static final class a implements BaseDialogFragment.DialogFragmentListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CommentInputDialog f37242a;

            public a(CommentInputDialog commentInputDialog) {
                this.f37242a = commentInputDialog;
            }

            @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
            public void onDismiss() {
                this.f37242a.backAndShowKeyboard();
            }

            @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
            public void onShow() {
                this.f37242a.goOtherPageAndHideKeyboard();
            }
        }

        public ClickProxy() {
        }

        public static /* synthetic */ void j(ClickProxy clickProxy, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            clickProxy.i(z);
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            j(this, false, 1, null);
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.this.dismissAllowingStateLoss();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Boolean value = CommentInputDialog.access$getMViewModel(CommentInputDialog.this).m().getValue();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(value, bool)) {
                CommentInputDialog.access$getMViewModel(CommentInputDialog.this).m().setValue(Boolean.FALSE);
                CommentInputDialog.this.showKeyboard();
            } else {
                CommentInputDialog.access$getMViewModel(CommentInputDialog.this).m().setValue(bool);
                CommentInputDialog.this.hideKeyboard();
            }
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.this.goOtherPageAndHideKeyboard();
            MediaPickerLauncher mediaPickerLauncher = CommentInputDialog.this.picker;
            if (mediaPickerLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picker");
                mediaPickerLauncher = null;
            }
            MediaPickerLauncher.w(mediaPickerLauncher, 1080, 1024, false, 0.0f, 0.0f, false, 60, null);
        }

        public final void e(@Nullable View view) {
            CommentInputDialog.this.goOtherPageAndHideKeyboard();
            Intent intent = new Intent(CommentInputDialog.this.requireContext(), Class.forName("com.huachenjie.mall.external.page.share_goods.SelectGoodsActivity"));
            intent.putExtra(yj7.e.KEY_GOODS_SINGLE_SELECT, true);
            CommentInputDialog.this.startActivityForResult(intent, 1002);
        }

        public final void f(@NotNull View view) {
            ArrayList arrayList;
            PubWorkContentEditView pubWorkContentEditView;
            List<RichUserBean> userList;
            PubWorkContentEditView pubWorkContentEditView2;
            Intrinsics.checkNotNullParameter(view, "view");
            WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            String richText = (worksDialogCommentInputBindingAccess$getMBinding == null || (pubWorkContentEditView2 = worksDialogCommentInputBindingAccess$getMBinding.f14055a) == null) ? null : pubWorkContentEditView2.getRichText();
            if (TextUtils.isEmpty(richText) && CommentInputDialog.access$getMViewModel(CommentInputDialog.this).l().getValue() == null) {
                fv5.b(CommentInputDialog.this.getString(R.string.works_comment_empty));
                return;
            }
            WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding2 = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogCommentInputBindingAccess$getMBinding2 == null || (pubWorkContentEditView = worksDialogCommentInputBindingAccess$getMBinding2.f14055a) == null || (userList = pubWorkContentEditView.getUserList()) == null) {
                arrayList = null;
            } else {
                List<RichUserBean> list = userList;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((RichUserBean) it.next()).getAppUserCode());
                }
            }
            CommonUserInfo commonUserInfoE = ai9.e();
            CommentUserBean commentUserBean = new CommentUserBean(commonUserInfoE.getAvatar(), commonUserInfoE.getNickName(), commonUserInfoE.getUserId(), commonUserInfoE.getAvatarFrameImgUrl());
            if (CommentInputDialog.this.getTargetCommentNo() == null) {
                String bizNo = CommentInputDialog.this.getBizNo();
                Intrinsics.checkNotNullExpressionValue(bizNo, "bizNo");
                CommentBean commentBean = new CommentBean(bizNo, null, null, null, null, 0L, 0, false, false, null, commentUserBean, false, CommentInputDialog.access$getMViewModel(CommentInputDialog.this).l().getValue(), 0, arrayList, 0, 44030, null);
                if (!TextUtils.isEmpty(richText)) {
                    Intrinsics.checkNotNull(richText);
                    commentBean.setContent(richText);
                    commentBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, richText, 0, 2, null));
                }
                Function1 function1 = CommentInputDialog.this.onCommentCallback;
                if (function1 != null) {
                    function1.invoke(commentBean);
                }
                CommentInputDialog.this.dismissAllowingStateLoss();
                return;
            }
            String bizNo2 = CommentInputDialog.this.getBizNo();
            CommentImageBean value = CommentInputDialog.access$getMViewModel(CommentInputDialog.this).l().getValue();
            String targetCommentNo = CommentInputDialog.this.getTargetCommentNo();
            Intrinsics.checkNotNull(targetCommentNo);
            TargetComment targetComment = new TargetComment(targetCommentNo, null, 2, null);
            Intrinsics.checkNotNullExpressionValue(bizNo2, "bizNo");
            CommentReplyBean commentReplyBean = new CommentReplyBean(bizNo2, null, null, null, null, 0L, 0, false, commentUserBean, true, targetComment, value, arrayList, 0, 8446, null);
            if (!TextUtils.isEmpty(richText)) {
                Intrinsics.checkNotNull(richText);
                commentReplyBean.setContent(richText);
                commentReplyBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, richText, 0, 2, null));
            }
            Function1 function2 = CommentInputDialog.this.onReplyCallback;
            if (function2 != null) {
                function2.invoke(commentReplyBean);
            }
            CommentInputDialog.this.dismissAllowingStateLoss();
        }

        public final void g(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).l().setValue(null);
        }

        public final void h(@NotNull View view) {
            String path;
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.this.goOtherPageAndHideKeyboard();
            CommentImageBean value = CommentInputDialog.access$getMViewModel(CommentInputDialog.this).l().getValue();
            if (value == null || (path = value.getPath()) == null) {
                path = "";
            }
            PicturePreviewUtil.i(view, path);
        }

        public final void i(final boolean isFromInputSymbol) {
            ArrayList<String> arrayList;
            PubWorkContentEditView pubWorkContentEditView;
            List<RichUserBean> userList;
            FragmentManager childFragmentManager = CommentInputDialog.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogCommentInputBindingAccess$getMBinding == null || (pubWorkContentEditView = worksDialogCommentInputBindingAccess$getMBinding.f14055a) == null || (userList = pubWorkContentEditView.getUserList()) == null) {
                arrayList = null;
            } else {
                List<RichUserBean> list = userList;
                arrayList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((RichUserBean) it.next()).getAppUserCode());
                }
            }
            if ((arrayList != null ? arrayList.size() : 0) >= 5) {
                fv5.b(CommentInputDialog.this.getString(R.string.works_publish_work_menu_user_max));
                return;
            }
            InputSelectUserFragment inputSelectUserFragment = new InputSelectUserFragment();
            final CommentInputDialog commentInputDialog = CommentInputDialog.this;
            inputSelectUserFragment.setSelectCallback(new Function1<UserInfoBean, Unit>() { // from class: com.huachenjie.works.page.comment.CommentInputDialog$ClickProxy$showSelectUser$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((UserInfoBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable UserInfoBean userInfoBean) {
                    WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding2;
                    PubWorkContentEditView pubWorkContentEditView2;
                    if (userInfoBean == null || (worksDialogCommentInputBindingAccess$getMBinding2 = CommentInputDialog.access$getMBinding(commentInputDialog)) == null || (pubWorkContentEditView2 = worksDialogCommentInputBindingAccess$getMBinding2.f14055a) == null) {
                        return;
                    }
                    pubWorkContentEditView2.insertRichTextField('@' + userInfoBean.getUserName() + ' ', RichTextUtils.f32968a.l(userInfoBean.getAppUserCode()), isFromInputSymbol);
                }
            });
            Bundle bundle = new Bundle();
            Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
            bundle.putStringArrayList(InputSelectUserFragment.SELECTED_USER_KEY, arrayList);
            inputSelectUserFragment.setArguments(bundle);
            inputSelectUserFragment.setDialogFragmentListener(new a(commentInputDialog));
            inputSelectUserFragment.show(childFragmentManager, InputSelectUserFragment.class.getSimpleName());
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.comment.CommentInputDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJZ\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n\u0018\u00010\bR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/works/page/comment/CommentInputDialog$a;", "", "", "commentType", "", "bizNo", "targetCommentNo", CommentInputDialog.KEY_HINT, "Lkotlin/Function1;", "Lcom/huachenjie/works/bean/comment/CommentBean;", "", "onComment", "Lcom/huachenjie/works/bean/comment/CommentReplyBean;", "onReply", "Lcom/huachenjie/works/page/comment/CommentInputDialog;", "a", "COMMENT_INPUT_DEFAULT", "I", "COMMENT_INPUT_LARGE", "KEY_BIZ_NO", "Ljava/lang/String;", "KEY_COMMENT_TYPE", "KEY_HINT", "KEY_TARGET_COMMENT_NO", "MAX_GOODS_NAME_LENGTH", "REQUEST_CODE", "USER_TYPE_START", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CommentInputDialog a(int commentType, @NotNull String bizNo, @Nullable String targetCommentNo, @NotNull String hint, @Nullable Function1<? super CommentBean, Unit> onComment, @Nullable Function1<? super CommentReplyBean, Unit> onReply) {
            Intrinsics.checkNotNullParameter(bizNo, "bizNo");
            Intrinsics.checkNotNullParameter(hint, CommentInputDialog.KEY_HINT);
            CommentInputDialog commentInputDialog = new CommentInputDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(CommentInputDialog.KEY_COMMENT_TYPE, commentType);
            bundle.putString(CommentInputDialog.KEY_BIZ_NO, bizNo);
            bundle.putString(CommentInputDialog.KEY_TARGET_COMMENT_NO, targetCommentNo);
            bundle.putString(CommentInputDialog.KEY_HINT, hint);
            commentInputDialog.setArguments(bundle);
            commentInputDialog.onCommentCallback = onComment;
            commentInputDialog.onReplyCallback = onReply;
            return commentInputDialog;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$4\n+ 3 CommentInputDialog.kt\ncom/huachenjie/works/page/comment/CommentInputDialog\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$3\n+ 5 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$2\n*L\n1#1,136:1\n99#2:137\n329#3:138\n98#4:139\n97#5:140\n*E\n"})
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            CommentInputDialog.this.isShowingKeyboard = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 CommentInputDialog.kt\ncom/huachenjie/works/page/comment/CommentInputDialog\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n191#2,48:98\n71#3:146\n77#4:147\n*E\n"})
    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextPaint f37244a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ PubWorkContentEditView f14886a;

        public c(TextPaint textPaint, PubWorkContentEditView pubWorkContentEditView) {
            this.f37244a = textPaint;
            this.f14886a = pubWorkContentEditView;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
            float f;
            EmojiEditText emojiEditText;
            EmojiEditText emojiEditText2;
            EmojiPanelFragment emojiPanelFragment = CommentInputDialog.this.emojiPanelFragment;
            if (emojiPanelFragment != null) {
                emojiPanelFragment.changeDeleteButton(!TextUtils.isEmpty(s));
            }
            Integer value = CommentInputDialog.access$getMViewModel(CommentInputDialog.this).j().getValue();
            if (value != null && value.intValue() == 1) {
                f = 144.0f;
            } else {
                f = (value != null && value.intValue() == 3) ? 0.0f : 108.0f;
            }
            if (this.f37244a.measureText(String.valueOf(s)) > this.f14886a.getWidth() - jj8.a(f)) {
                if (CommentInputDialog.this.commentInputStyle != 1) {
                    CommentInputDialog.this.commentInputStyle = 1;
                    CommentInputDialog commentInputDialog = CommentInputDialog.this;
                    WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(commentInputDialog);
                    commentInputDialog.changeInputViewLayout(worksDialogCommentInputBindingAccess$getMBinding != null ? worksDialogCommentInputBindingAccess$getMBinding.c : null, false);
                    CommentInputDialog commentInputDialog2 = CommentInputDialog.this;
                    WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding2 = CommentInputDialog.access$getMBinding(commentInputDialog2);
                    commentInputDialog2.changeInputViewLayout(worksDialogCommentInputBindingAccess$getMBinding2 != null ? worksDialogCommentInputBindingAccess$getMBinding2.d : null, false);
                    CommentInputDialog commentInputDialog3 = CommentInputDialog.this;
                    WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding3 = CommentInputDialog.access$getMBinding(commentInputDialog3);
                    commentInputDialog3.changeInputViewLayout(worksDialogCommentInputBindingAccess$getMBinding3 != null ? worksDialogCommentInputBindingAccess$getMBinding3.b : null, false);
                    CommentInputDialog commentInputDialog4 = CommentInputDialog.this;
                    WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding4 = CommentInputDialog.access$getMBinding(commentInputDialog4);
                    commentInputDialog4.changeInputViewLayout(worksDialogCommentInputBindingAccess$getMBinding4 != null ? worksDialogCommentInputBindingAccess$getMBinding4.f14050a : null, false);
                    WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding5 = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
                    if (worksDialogCommentInputBindingAccess$getMBinding5 == null || (emojiEditText2 = worksDialogCommentInputBindingAccess$getMBinding5.f14055a) == null) {
                        return;
                    }
                    emojiEditText2.setPadding(jj8.a(0.0f), jj8.a(12.0f), jj8.a(0.0f), jj8.a(0.0f));
                    return;
                }
                return;
            }
            if (CommentInputDialog.this.commentInputStyle != 0) {
                CommentInputDialog.this.commentInputStyle = 0;
                CommentInputDialog commentInputDialog5 = CommentInputDialog.this;
                WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding6 = CommentInputDialog.access$getMBinding(commentInputDialog5);
                commentInputDialog5.changeInputViewLayout(worksDialogCommentInputBindingAccess$getMBinding6 != null ? worksDialogCommentInputBindingAccess$getMBinding6.c : null, true);
                CommentInputDialog commentInputDialog6 = CommentInputDialog.this;
                WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding7 = CommentInputDialog.access$getMBinding(commentInputDialog6);
                commentInputDialog6.changeInputViewLayout(worksDialogCommentInputBindingAccess$getMBinding7 != null ? worksDialogCommentInputBindingAccess$getMBinding7.d : null, true);
                CommentInputDialog commentInputDialog7 = CommentInputDialog.this;
                WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding8 = CommentInputDialog.access$getMBinding(commentInputDialog7);
                commentInputDialog7.changeInputViewLayout(worksDialogCommentInputBindingAccess$getMBinding8 != null ? worksDialogCommentInputBindingAccess$getMBinding8.b : null, true);
                CommentInputDialog commentInputDialog8 = CommentInputDialog.this;
                WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding9 = CommentInputDialog.access$getMBinding(commentInputDialog8);
                commentInputDialog8.changeInputViewLayout(worksDialogCommentInputBindingAccess$getMBinding9 != null ? worksDialogCommentInputBindingAccess$getMBinding9.f14050a : null, true);
                WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding10 = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
                if (worksDialogCommentInputBindingAccess$getMBinding10 == null || (emojiEditText = worksDialogCommentInputBindingAccess$getMBinding10.f14055a) == null) {
                    return;
                }
                emojiEditText.setPadding(jj8.a(0.0f), jj8.a(12.0f), jj8.a(0.0f), jj8.a(12.0f));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/works/page/comment/CommentInputDialog$d", "Lcom/huachenjie/im/page/emoji/EmojiInputCallback;", "", "emoji", "", "b", "Landroid/view/KeyEvent;", "keyEventDown", "keyEventUp", "a", "url", "c", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements EmojiInputCallback {
        public d() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.huachenjie.im.page.emoji.EmojiInputCallback
        public void a(@NotNull KeyEvent keyEventDown, @NotNull KeyEvent keyEventUp) {
            EmojiEditText emojiEditText;
            EmojiEditText emojiEditText2;
            Intrinsics.checkNotNullParameter(keyEventDown, "keyEventDown");
            Intrinsics.checkNotNullParameter(keyEventUp, "keyEventUp");
            WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogCommentInputBindingAccess$getMBinding != null && (emojiEditText2 = worksDialogCommentInputBindingAccess$getMBinding.f14055a) != null) {
                emojiEditText2.onKeyDown(keyEventDown.getKeyCode(), keyEventDown);
            }
            WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding2 = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogCommentInputBindingAccess$getMBinding2 == null || (emojiEditText = worksDialogCommentInputBindingAccess$getMBinding2.f14055a) == null) {
                return;
            }
            emojiEditText.onKeyUp(keyEventUp.getKeyCode(), keyEventUp);
        }

        @Override // com.huachenjie.im.page.emoji.EmojiInputCallback
        public void b(@NotNull String emoji) {
            EmojiEditText emojiEditText;
            Editable editableText;
            EmojiEditText emojiEditText2;
            Intrinsics.checkNotNullParameter(emoji, "emoji");
            WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogCommentInputBindingAccess$getMBinding == null || (emojiEditText = worksDialogCommentInputBindingAccess$getMBinding.f14055a) == null || (editableText = emojiEditText.getEditableText()) == null) {
                return;
            }
            WorksDialogCommentInputBinding worksDialogCommentInputBindingAccess$getMBinding2 = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            editableText.insert((worksDialogCommentInputBindingAccess$getMBinding2 == null || (emojiEditText2 = worksDialogCommentInputBindingAccess$getMBinding2.f14055a) == null) ? 0 : emojiEditText2.getSelectionStart(), emoji);
        }

        @Override // com.huachenjie.im.page.emoji.EmojiInputCallback
        public void c(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).l().setValue(new CommentImageBean(url, 150, 150));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/works/page/comment/CommentInputDialog$e", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "works_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nCommentInputDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentInputDialog.kt\ncom/huachenjie/works/page/comment/CommentInputDialog$initView$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,546:1\n1#2:547\n*E\n"})
    public static final class e implements MediaPickerListener {
        public e() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result instanceof MediaPickerResult.Success) {
                String str = (String) CollectionsKt.getOrNull(((MediaPickerResult.Success) result).g(), 0);
                if (str == null) {
                    return;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                CommentInputDialog.access$getMViewModel(CommentInputDialog.this).l().setValue(new CommentImageBean(str, options.outWidth, options.outHeight));
                return;
            }
            if (result instanceof MediaPickerResult.a) {
                CommentInputDialog.this.backAndShowKeyboard();
            } else if (result instanceof MediaPickerResult.Error) {
                fv5.b(((MediaPickerResult.Error) result).f());
                CommentInputDialog.this.backAndShowKeyboard();
            }
        }
    }

    public static final /* synthetic */ WorksDialogCommentInputBinding access$getMBinding(CommentInputDialog commentInputDialog) {
        return commentInputDialog.getMBinding();
    }

    public static final /* synthetic */ CommentInputVM access$getMViewModel(CommentInputDialog commentInputDialog) {
        return commentInputDialog.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void backAndShowKeyboard() {
        if (this.backNeedShowKeyboard) {
            if (Intrinsics.areEqual(getMViewModel().m().getValue(), Boolean.TRUE)) {
                this.backNeedShowKeyboard = false;
            } else {
                getHandler().postDelayed(new Runnable() { // from class: com.zj.adlib.no1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CommentInputDialog.backAndShowKeyboard$lambda$16(this.f43571a);
                    }
                }, 300L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void backAndShowKeyboard$lambda$16(CommentInputDialog commentInputDialog) {
        Intrinsics.checkNotNullParameter(commentInputDialog, "this$0");
        commentInputDialog.showKeyboard();
        commentInputDialog.backNeedShowKeyboard = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeInputViewLayout(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        if (z) {
            layoutParams2.removeRule(3);
        } else {
            layoutParams2.addRule(3, R.id.et_comment);
        }
        view.setLayoutParams(layoutParams2);
    }

    private final void fitEmojiPanelViewHeight(int height) {
        FrameLayout frameLayout;
        WorksDialogCommentInputBinding mBinding = getMBinding();
        if ((mBinding == null || (frameLayout = mBinding.f36849a) == null || frameLayout.getHeight() != 0) ? false : true) {
            this.isShowingKeyboard = true;
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, height);
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.po1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CommentInputDialog.fitEmojiPanelViewHeight$lambda$12$lambda$10(this.f44025a, valueAnimator);
                }
            });
            Intrinsics.checkNotNullExpressionValue(valueAnimatorOfInt, "fitEmojiPanelViewHeight$lambda$12");
            valueAnimatorOfInt.addListener(new b());
            valueAnimatorOfInt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fitEmojiPanelViewHeight$lambda$12$lambda$10(CommentInputDialog commentInputDialog, ValueAnimator valueAnimator) {
        FrameLayout frameLayout;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(commentInputDialog, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, o.f);
        WorksDialogCommentInputBinding mBinding = commentInputDialog.getMBinding();
        if (mBinding == null || (frameLayout = mBinding.f36849a) == null || (layoutParams = frameLayout.getLayoutParams()) == null) {
            return;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        WorksDialogCommentInputBinding mBinding2 = commentInputDialog.getMBinding();
        FrameLayout frameLayout2 = mBinding2 != null ? mBinding2.f36849a : null;
        if (frameLayout2 == null) {
            return;
        }
        frameLayout2.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBizNo() {
        return (String) this.bizNo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClickProxy getClickProxy() {
        return (ClickProxy) this.clickProxy.getValue();
    }

    private final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTargetCommentNo() {
        return (String) this.targetCommentNo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goOtherPageAndHideKeyboard() {
        this.backNeedShowKeyboard = true;
        hideKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideKeyboard() {
        EmojiEditText emojiEditText;
        WorksDialogCommentInputBinding mBinding = getMBinding();
        if (mBinding == null || (emojiEditText = mBinding.f14055a) == null) {
            return;
        }
        KeyboardUtils.k(emojiEditText);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.TextView, com.huachenjie.works.widget.PubWorkContentEditView] */
    private final void initCommentChange() {
        ?? r0;
        WorksDialogCommentInputBinding mBinding = getMBinding();
        if (mBinding == null || (r0 = mBinding.f14055a) == 0) {
            return;
        }
        r0.addTextChangedListener(new c(r0.getPaint(), r0));
    }

    private final void initEmojiPanel() {
        this.emojiPanelFragment = EmojiPanelFragment.INSTANCE.a(new d());
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        int i = R.id.emoji_sticker_container;
        EmojiPanelFragment emojiPanelFragment = this.emojiPanelFragment;
        Intrinsics.checkNotNull(emojiPanelFragment);
        fragmentTransactionBeginTransaction.replace(i, emojiPanelFragment, EmojiPanelFragment.class.getName()).commit();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.TextView, com.huachenjie.base.util.rich_text.RichEditView, com.huachenjie.works.widget.PubWorkContentEditView] */
    private final void initEtEvent() {
        ?? r0;
        WorksDialogCommentInputBinding mBinding = getMBinding();
        if (mBinding == null || (r0 = mBinding.f14055a) == 0) {
            return;
        }
        r0.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.zj.adlib.xo1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return CommentInputDialog.initEtEvent$lambda$6$lambda$5(this.f45861a, textView, i, keyEvent);
            }
        });
        r0.setSpecialSymbolCallback(new Function1<String, Unit>() { // from class: com.huachenjie.works.page.comment.CommentInputDialog$initEtEvent$1$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                if (Intrinsics.areEqual(str, "@")) {
                    Integer value = CommentInputDialog.access$getMViewModel(this.this$0).j().getValue();
                    if (value != null && value.intValue() == 3) {
                        return;
                    }
                    this.this$0.getClickProxy().i(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initEtEvent$lambda$6$lambda$5(CommentInputDialog commentInputDialog, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(commentInputDialog, "this$0");
        if (i != 4 && (keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
            return false;
        }
        ClickProxy clickProxy = commentInputDialog.getClickProxy();
        Intrinsics.checkNotNullExpressionValue(textView, "v");
        clickProxy.f(textView);
        return true;
    }

    private final void initKeyBoardListener() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        KeyboardUtils.p(window, new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.zj.adlib.vo1
            @Override // com.blankj.utilcode.util.KeyboardUtils.OnSoftInputChangedListener
            public final void a(int i) {
                CommentInputDialog.initKeyBoardListener$lambda$8$lambda$7(this.f45399a, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initKeyBoardListener$lambda$8$lambda$7(CommentInputDialog commentInputDialog, int i) {
        Intrinsics.checkNotNullParameter(commentInputDialog, "this$0");
        if (commentInputDialog.isShowingKeyboard) {
            return;
        }
        if (i > 0) {
            if (Intrinsics.areEqual(commentInputDialog.getMViewModel().m().getValue(), Boolean.TRUE)) {
                commentInputDialog.getMViewModel().m().setValue(Boolean.FALSE);
            }
            commentInputDialog.fitEmojiPanelViewHeight(i);
        } else {
            if (Intrinsics.areEqual(commentInputDialog.getMViewModel().m().getValue(), Boolean.TRUE) || commentInputDialog.backNeedShowKeyboard) {
                return;
            }
            commentInputDialog.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(CommentInputDialog commentInputDialog) {
        Intrinsics.checkNotNullParameter(commentInputDialog, "this$0");
        commentInputDialog.showKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showKeyboard() {
        EmojiEditText emojiEditText;
        WorksDialogCommentInputBinding mBinding = getMBinding();
        if (mBinding == null || (emojiEditText = mBinding.f14055a) == null) {
            return;
        }
        KeyboardUtils.s(emojiEditText);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_comment_input;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), getClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        String string;
        super.initData();
        MutableLiveData<Integer> mutableLiveDataJ = getMViewModel().j();
        Bundle arguments = getArguments();
        mutableLiveDataJ.setValue(Integer.valueOf(arguments != null ? arguments.getInt(KEY_COMMENT_TYPE) : 1));
        MutableLiveData<String> mutableLiveDataK = getMViewModel().k();
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString(KEY_HINT)) == null) {
            string = "";
        }
        mutableLiveDataK.setValue(string);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    @SuppressLint({"ClickableViewAccessibility"})
    public void initView() {
        CardView cardView;
        super.initView();
        this.picker = MediaPicker.v(this, new e());
        WorksDialogCommentInputBinding mBinding = getMBinding();
        if (mBinding != null && (cardView = mBinding.f14052a) != null) {
            cardView.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.ro1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return CommentInputDialog.initView$lambda$1(view, motionEvent);
                }
            });
        }
        initCommentChange();
        initEtEvent();
        initEmojiPanel();
        initKeyBoardListener();
        getHandler().postDelayed(new Runnable() { // from class: com.zj.adlib.to1
            @Override // java.lang.Runnable
            public final void run() {
                CommentInputDialog.initView$lambda$2(this.f44969a);
            }
        }, 300L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String stringExtra;
        PubWorkContentEditView pubWorkContentEditView;
        ArrayList<String> stringArrayListExtra;
        if (resultCode != -1 || requestCode != 1002) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        String str = (data == null || (stringArrayListExtra = data.getStringArrayListExtra(yj7.e.KEY_GOODS_NO_LIST)) == null) ? null : (String) CollectionsKt.getOrNull(stringArrayListExtra, 0);
        if (data != null && (stringExtra = data.getStringExtra(yj7.e.KEY_GOODS_SINGLE_NAME)) != null) {
            if (stringExtra.length() > 10) {
                StringBuilder sb = new StringBuilder();
                String strSubstring = stringExtra.substring(0, 10);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(strSubstring);
                sb.append(v39.CHARACTER_ELLIPSIZE);
                stringExtra = sb.toString();
            }
            WorksDialogCommentInputBinding mBinding = getMBinding();
            if (mBinding != null && (pubWorkContentEditView = mBinding.f14055a) != null) {
                String str2 = RichEditView.GOODS_START + stringExtra + ' ';
                RichTextUtils richTextUtils = RichTextUtils.f32968a;
                Intrinsics.checkNotNull(str);
                pubWorkContentEditView.insertRichTextField(str2, richTextUtils.f(str), false);
            }
        }
        backAndShowKeyboard();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new ComponentDialog(requireContext(), getTheme()) { // from class: com.huachenjie.works.page.comment.CommentInputDialog.onCreateDialog.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context, i);
                Intrinsics.checkNotNullExpressionValue(context, "requireContext()");
            }

            @Override // android.app.Dialog, android.content.DialogInterface
            public void dismiss() {
                CommentInputDialog.this.hideKeyboard();
                super.dismiss();
            }
        };
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            KeyboardUtils.v(window);
        }
        getHandler().removeCallbacksAndMessages(null);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        backAndShowKeyboard();
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
        window.setSoftInputMode(48);
    }
}
