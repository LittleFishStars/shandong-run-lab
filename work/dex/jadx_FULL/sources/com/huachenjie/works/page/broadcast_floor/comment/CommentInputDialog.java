package com.huachenjie.works.page.broadcast_floor.comment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.huachenjie.base.bean.RichUserBean;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.util.rich_text.RichEditView;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.base.widget.input_panel.audio.AudioPanelView;
import com.huachenjie.base.widget.input_panel.audio.AudioRecordCallback;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.im.audio.ImAudioPlayCallback;
import com.huachenjie.im.audio.ImAudioRecordCallback;
import com.huachenjie.im.page.emoji.EmojiInputCallback;
import com.huachenjie.im.page.emoji.EmojiPanelFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BroadcastFloorMessageImageBean;
import com.huachenjie.works.bean.BroadcastFloorMessageVoiceBean;
import com.huachenjie.works.databinding.WorksDialogBroadcastFloorCommentInputBinding;
import com.huachenjie.works.page.broadcast_floor.comment.CommentInputDialog;
import com.huachenjie.works.page.broadcast_floor.comment.CommentInputDialog.ClickProxy;
import com.huachenjie.works.page.user.InputSelectUserFragment;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.vanniktech.emoji.EmojiEditText;
import com.zj.adlib.f64;
import com.zj.adlib.fv5;
import com.zj.adlib.g64;
import com.zj.adlib.m55;
import com.zj.adlib.qk0;
import com.zj.adlib.y6b;
import java.io.File;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001>\u0018\u0000 C2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002DEB\u0007¢\u0006\u0004\bA\u0010BJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0017J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016R6\u0010'\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0004\u0012\u00020\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u001f\u00102\u001a\u00060-R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006F"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogBroadcastFloorCommentInputBinding;", "Lcom/huachenjie/works/page/broadcast_floor/comment/CommentInputVM;", "", "initCommentChange", "initEtEvent", "initEmojiPanel", "initAudioPanel", "initKeyBoardListener", "", "height", "fitPanelViewHeight", "showKeyboard", "hideKeyboard", "goOtherPageAndHideKeyboard", "backAndShowKeyboard", "playVoice", "stopVoice", "onVoiceStop", "getWidth", "getHeight", "getLayoutResID", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "onStart", "", "", "getVariables", "initData", "initView", "onDestroyView", "onResume", "Lkotlin/Function3;", "", "Lcom/huachenjie/works/bean/BroadcastFloorMessageImageBean;", "Lcom/huachenjie/works/bean/BroadcastFloorMessageVoiceBean;", "onCommentCallback", "Lkotlin/jvm/functions/Function3;", "", "isShowingKeyboard", "Z", "backNeedShowKeyboard", "Lcom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$ClickProxy;", "clickProxy$delegate", "Lkotlin/Lazy;", "getClickProxy", "()Lcom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$ClickProxy;", "clickProxy", "Landroid/os/Handler;", "handler$delegate", "getHandler", "()Landroid/os/Handler;", "handler", "Lcom/huachenjie/im/page/emoji/EmojiPanelFragment;", "emojiPanelFragment", "Lcom/huachenjie/im/page/emoji/EmojiPanelFragment;", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "com/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$b", "audioRecordCallback", "Lcom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$b;", "<init>", "()V", "Companion", "ClickProxy", "a", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCommentInputDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentInputDialog.kt\ncom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,480:1\n65#2,16:481\n93#2,3:497\n95#3,14:500\n*S KotlinDebug\n*F\n+ 1 CommentInputDialog.kt\ncom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog\n*L\n157#1:481,16\n157#1:497,3\n284#1:500,14\n*E\n"})
public final class CommentInputDialog extends BaseMVVMDialogFragment<WorksDialogBroadcastFloorCommentInputBinding, CommentInputVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_HINT = "hint";

    @NotNull
    private static final String USER_TYPE_START = "@";
    private boolean backNeedShowKeyboard;

    @Nullable
    private EmojiPanelFragment emojiPanelFragment;
    private boolean isShowingKeyboard;

    @Nullable
    private Function3<? super String, ? super BroadcastFloorMessageImageBean, ? super BroadcastFloorMessageVoiceBean, Unit> onCommentCallback;
    private MediaPickerLauncher picker;

    /* JADX INFO: renamed from: clickProxy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy clickProxy = LazyKt.lazy(new Function0<ClickProxy>() { // from class: com.huachenjie.works.page.broadcast_floor.comment.CommentInputDialog$clickProxy$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CommentInputDialog.ClickProxy m869invoke() {
            return this.this$0.new ClickProxy();
        }
    });

    /* JADX INFO: renamed from: handler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.huachenjie.works.page.broadcast_floor.comment.CommentInputDialog$handler$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m870invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    @NotNull
    private final b audioRecordCallback = new b();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$ClickProxy;", "", "Landroid/view/View;", "view", "", "b", "e", "k", "i", "a", "", "isFromInputSymbol", t.d, "d", "c", y6b.g, "f", "j", y6b.f, "<init>", "(Lcom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nCommentInputDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentInputDialog.kt\ncom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$ClickProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,480:1\n1549#2:481\n1620#2,3:482\n*S KotlinDebug\n*F\n+ 1 CommentInputDialog.kt\ncom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$ClickProxy\n*L\n402#1:481\n402#1:482,3\n*E\n"})
    public final class ClickProxy {

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$ClickProxy$a", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onShow", "onDismiss", "works_release"}, k = 1, mv = {1, 8, 0})
        public static final class a implements BaseDialogFragment.DialogFragmentListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CommentInputDialog f37210a;

            public a(CommentInputDialog commentInputDialog) {
                this.f37210a = commentInputDialog;
            }

            @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
            public void onDismiss() {
                this.f37210a.backAndShowKeyboard();
            }

            @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
            public void onShow() {
                this.f37210a.goOtherPageAndHideKeyboard();
            }
        }

        public ClickProxy() {
        }

        public static /* synthetic */ void m(ClickProxy clickProxy, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            clickProxy.l(z);
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            m(this, false, 1, null);
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.this.dismissAllowingStateLoss();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).m().setValue(Boolean.TRUE);
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).l().setValue(Boolean.FALSE);
            CommentInputDialog.this.hideKeyboard();
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MutableLiveData<Boolean> mutableLiveDataM = CommentInputDialog.access$getMViewModel(CommentInputDialog.this).m();
            Boolean bool = Boolean.FALSE;
            mutableLiveDataM.setValue(bool);
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).l().setValue(bool);
            CommentInputDialog.this.showKeyboard();
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.this.goOtherPageAndHideKeyboard();
            MediaPickerLauncher mediaPickerLauncher = CommentInputDialog.this.picker;
            if (mediaPickerLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picker");
                mediaPickerLauncher = null;
            }
            MediaPickerLauncher.w(mediaPickerLauncher, 1080, 1024, false, 0.0f, 0.0f, false, 60, null);
        }

        public final void f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.this.playVoice();
        }

        public final void g(@NotNull View view) {
            RichEditView richEditView;
            Intrinsics.checkNotNullParameter(view, "view");
            WorksDialogBroadcastFloorCommentInputBinding worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            String richText = (worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding == null || (richEditView = worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding.f13981a) == null) ? null : richEditView.getRichText();
            if (TextUtils.isEmpty(richText) && CommentInputDialog.access$getMViewModel(CommentInputDialog.this).k().getValue() == null && CommentInputDialog.access$getMViewModel(CommentInputDialog.this).o().getValue() == null) {
                fv5.b("请先输入～");
                return;
            }
            Function3 function3 = CommentInputDialog.this.onCommentCallback;
            if (function3 != null) {
                function3.invoke(richText, CommentInputDialog.access$getMViewModel(CommentInputDialog.this).k().getValue(), CommentInputDialog.access$getMViewModel(CommentInputDialog.this).o().getValue());
            }
            CommentInputDialog.this.dismissAllowingStateLoss();
        }

        public final void h(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).m().setValue(Boolean.FALSE);
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).l().setValue(Boolean.TRUE);
            CommentInputDialog.this.hideKeyboard();
        }

        public final void i(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).k().setValue(null);
        }

        public final void j(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.this.stopVoice();
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).o().setValue(null);
        }

        public final void k(@NotNull View view) {
            String path;
            Intrinsics.checkNotNullParameter(view, "view");
            CommentInputDialog.this.goOtherPageAndHideKeyboard();
            BroadcastFloorMessageImageBean value = CommentInputDialog.access$getMViewModel(CommentInputDialog.this).k().getValue();
            if (value == null || (path = value.getPath()) == null) {
                path = "";
            }
            PicturePreviewUtil.i(view, path);
        }

        public final void l(final boolean isFromInputSymbol) {
            ArrayList<String> arrayList;
            RichEditView richEditView;
            List<RichUserBean> userList;
            FragmentManager childFragmentManager = CommentInputDialog.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            WorksDialogBroadcastFloorCommentInputBinding worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding == null || (richEditView = worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding.f13981a) == null || (userList = richEditView.getUserList()) == null) {
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
            inputSelectUserFragment.setSelectCallback(new Function1<UserInfoBean, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.comment.CommentInputDialog$ClickProxy$showSelectUser$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((UserInfoBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable UserInfoBean userInfoBean) {
                    WorksDialogBroadcastFloorCommentInputBinding worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2;
                    RichEditView richEditView2;
                    if (userInfoBean == null || (worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2 = CommentInputDialog.access$getMBinding(commentInputDialog)) == null || (richEditView2 = worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2.f13981a) == null) {
                        return;
                    }
                    richEditView2.insertRichTextField('@' + userInfoBean.getUserName() + ' ', RichTextUtils.f32968a.l(userInfoBean.getAppUserCode()), isFromInputSymbol);
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

    /* JADX INFO: renamed from: com.huachenjie.works.page.broadcast_floor.comment.CommentInputDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022$\u0010\b\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$a;", "", "", CommentInputDialog.KEY_HINT, "Lkotlin/Function3;", "Lcom/huachenjie/works/bean/BroadcastFloorMessageImageBean;", "Lcom/huachenjie/works/bean/BroadcastFloorMessageVoiceBean;", "", "onComment", "Lcom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog;", "a", "KEY_HINT", "Ljava/lang/String;", "USER_TYPE_START", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CommentInputDialog a(@NotNull String hint, @NotNull Function3<? super String, ? super BroadcastFloorMessageImageBean, ? super BroadcastFloorMessageVoiceBean, Unit> onComment) {
            Intrinsics.checkNotNullParameter(hint, CommentInputDialog.KEY_HINT);
            Intrinsics.checkNotNullParameter(onComment, "onComment");
            CommentInputDialog commentInputDialog = new CommentInputDialog();
            Bundle bundle = new Bundle();
            bundle.putString(CommentInputDialog.KEY_HINT, hint);
            commentInputDialog.setArguments(bundle);
            commentInputDialog.onCommentCallback = onComment;
            return commentInputDialog;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$b", "Lcom/huachenjie/im/audio/ImAudioRecordCallback;", "", "a", "Ljava/io/File;", "audioFile", "", "duration", "d", "time", "b", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements ImAudioRecordCallback {
        public b() {
        }

        @Override // com.huachenjie.im.audio.ImAudioRecordCallback
        public void a() {
            CommentInputDialog.this.stopVoice();
        }

        @Override // com.huachenjie.im.audio.ImAudioRecordCallback
        public void b(long time) {
            WorksDialogBroadcastFloorCommentInputBinding worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding;
            AudioPanelView audioPanelView;
            if (time <= 0 || (worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(CommentInputDialog.this)) == null || (audioPanelView = worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding.f13982a) == null) {
                return;
            }
            audioPanelView.showCountdown(time + "秒后自动结束录制");
        }

        @Override // com.huachenjie.im.audio.ImAudioRecordCallback
        public void d(@Nullable File audioFile, long duration) {
            AudioPanelView audioPanelView;
            WorksDialogBroadcastFloorCommentInputBinding worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding != null && (audioPanelView = worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding.f13982a) != null) {
                audioPanelView.showNormal();
            }
            if (audioFile == null || duration <= 0) {
                if (audioFile == null && duration == -1) {
                    fv5.b("语音录制失败，请重新尝试");
                    return;
                }
                return;
            }
            MutableLiveData<BroadcastFloorMessageVoiceBean> mutableLiveDataO = CommentInputDialog.access$getMViewModel(CommentInputDialog.this).o();
            String absolutePath = audioFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "audioFile.absolutePath");
            mutableLiveDataO.setValue(new BroadcastFloorMessageVoiceBean(absolutePath, (int) Math.ceil(duration / 1000.0d)));
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).k().setValue(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$4\n+ 3 CommentInputDialog.kt\ncom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$3\n+ 5 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$2\n*L\n1#1,136:1\n99#2:137\n284#3:138\n98#4:139\n97#5:140\n*E\n"})
    public static final class c implements Animator.AnimatorListener {
        public c() {
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$d", "Lcom/huachenjie/base/widget/input_panel/audio/AudioRecordCallback;", "", "a", "", "cancel", "b", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements AudioRecordCallback {
        public d() {
        }

        @Override // com.huachenjie.base.widget.input_panel.audio.AudioRecordCallback
        public void a() {
            g64.k().o(CommentInputDialog.this.getContext(), 60, CommentInputDialog.this.audioRecordCallback);
        }

        @Override // com.huachenjie.base.widget.input_panel.audio.AudioRecordCallback
        public void b(boolean cancel) {
            g64.k().i(cancel);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 CommentInputDialog.kt\ncom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n158#2,2:98\n71#3:100\n77#4:101\n*E\n"})
    public static final class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
            EmojiPanelFragment emojiPanelFragment = CommentInputDialog.this.emojiPanelFragment;
            if (emojiPanelFragment != null) {
                emojiPanelFragment.changeDeleteButton(!TextUtils.isEmpty(s));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$f", "Lcom/huachenjie/im/page/emoji/EmojiInputCallback;", "", "emoji", "", "b", "Landroid/view/KeyEvent;", "keyEventDown", "keyEventUp", "a", "url", "c", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class f implements EmojiInputCallback {
        public f() {
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
            WorksDialogBroadcastFloorCommentInputBinding worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding != null && (emojiEditText2 = worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding.f13981a) != null) {
                emojiEditText2.onKeyDown(keyEventDown.getKeyCode(), keyEventDown);
            }
            WorksDialogBroadcastFloorCommentInputBinding worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2 = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2 == null || (emojiEditText = worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2.f13981a) == null) {
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
            WorksDialogBroadcastFloorCommentInputBinding worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding == null || (emojiEditText = worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding.f13981a) == null || (editableText = emojiEditText.getEditableText()) == null) {
                return;
            }
            WorksDialogBroadcastFloorCommentInputBinding worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2 = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            editableText.insert((worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2 == null || (emojiEditText2 = worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2.f13981a) == null) ? 0 : emojiEditText2.getSelectionStart(), emoji);
        }

        @Override // com.huachenjie.im.page.emoji.EmojiInputCallback
        public void c(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).k().setValue(new BroadcastFloorMessageImageBean(url, 150, 150));
            CommentInputDialog.this.stopVoice();
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).o().setValue(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$g", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "works_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nCommentInputDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentInputDialog.kt\ncom/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$initView$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,480:1\n1#2:481\n*E\n"})
    public static final class g implements MediaPickerListener {
        public g() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!(result instanceof MediaPickerResult.Success)) {
                if (result instanceof MediaPickerResult.a) {
                    CommentInputDialog.this.backAndShowKeyboard();
                    return;
                } else {
                    if (result instanceof MediaPickerResult.Error) {
                        fv5.b(((MediaPickerResult.Error) result).f());
                        CommentInputDialog.this.backAndShowKeyboard();
                        return;
                    }
                    return;
                }
            }
            String str = (String) CollectionsKt.getOrNull(((MediaPickerResult.Success) result).g(), 0);
            if (str == null) {
                return;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).k().setValue(new BroadcastFloorMessageImageBean(str, options.outWidth, options.outHeight));
            CommentInputDialog.access$getMViewModel(CommentInputDialog.this).o().setValue(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/works/page/broadcast_floor/comment/CommentInputDialog$h", "Lcom/huachenjie/im/audio/ImAudioPlayCallback;", "", "uuid", "", "b", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class h implements ImAudioPlayCallback {
        public h() {
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void a(@NotNull String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            CommentInputDialog.this.onVoiceStop();
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void b(@NotNull String uuid) {
            ImageView imageView;
            LottieAnimationView lottieAnimationView;
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            WorksDialogBroadcastFloorCommentInputBinding worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding != null && (lottieAnimationView = worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding.f13980a) != null) {
                lottieAnimationView.playAnimation();
            }
            WorksDialogBroadcastFloorCommentInputBinding worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2 = CommentInputDialog.access$getMBinding(CommentInputDialog.this);
            if (worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2 == null || (imageView = worksDialogBroadcastFloorCommentInputBindingAccess$getMBinding2.f13978a) == null) {
                return;
            }
            imageView.setImageResource(R.drawable.works_ic_broadcast_message_voice_stop);
        }
    }

    public static final /* synthetic */ WorksDialogBroadcastFloorCommentInputBinding access$getMBinding(CommentInputDialog commentInputDialog) {
        return commentInputDialog.getMBinding();
    }

    public static final /* synthetic */ CommentInputVM access$getMViewModel(CommentInputDialog commentInputDialog) {
        return commentInputDialog.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void backAndShowKeyboard() {
        if (this.backNeedShowKeyboard) {
            Boolean value = getMViewModel().m().getValue();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(value, bool)) {
                this.backNeedShowKeyboard = false;
            } else if (Intrinsics.areEqual(getMViewModel().l().getValue(), bool)) {
                this.backNeedShowKeyboard = false;
            } else {
                getHandler().postDelayed(new Runnable() { // from class: com.zj.adlib.yo1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CommentInputDialog.backAndShowKeyboard$lambda$16(this.f46082a);
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

    private final void fitPanelViewHeight(int height) {
        FrameLayout frameLayout;
        WorksDialogBroadcastFloorCommentInputBinding mBinding = getMBinding();
        if ((mBinding == null || (frameLayout = mBinding.b) == null || frameLayout.getHeight() != 0) ? false : true) {
            this.isShowingKeyboard = true;
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, height);
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.oo1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CommentInputDialog.fitPanelViewHeight$lambda$12$lambda$10(this.f43791a, valueAnimator);
                }
            });
            Intrinsics.checkNotNullExpressionValue(valueAnimatorOfInt, "fitPanelViewHeight$lambda$12");
            valueAnimatorOfInt.addListener(new c());
            valueAnimatorOfInt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fitPanelViewHeight$lambda$12$lambda$10(CommentInputDialog commentInputDialog, ValueAnimator valueAnimator) {
        FrameLayout frameLayout;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(commentInputDialog, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, o.f);
        WorksDialogBroadcastFloorCommentInputBinding mBinding = commentInputDialog.getMBinding();
        if (mBinding == null || (frameLayout = mBinding.b) == null || (layoutParams = frameLayout.getLayoutParams()) == null) {
            return;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        WorksDialogBroadcastFloorCommentInputBinding mBinding2 = commentInputDialog.getMBinding();
        FrameLayout frameLayout2 = mBinding2 != null ? mBinding2.b : null;
        if (frameLayout2 == null) {
            return;
        }
        frameLayout2.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClickProxy getClickProxy() {
        return (ClickProxy) this.clickProxy.getValue();
    }

    private final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goOtherPageAndHideKeyboard() {
        stopVoice();
        this.backNeedShowKeyboard = true;
        hideKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideKeyboard() {
        EmojiEditText emojiEditText;
        WorksDialogBroadcastFloorCommentInputBinding mBinding = getMBinding();
        if (mBinding == null || (emojiEditText = mBinding.f13981a) == null) {
            return;
        }
        KeyboardUtils.k(emojiEditText);
    }

    private final void initAudioPanel() {
        AudioPanelView audioPanelView;
        WorksDialogBroadcastFloorCommentInputBinding mBinding = getMBinding();
        if (mBinding == null || (audioPanelView = mBinding.f13982a) == null) {
            return;
        }
        audioPanelView.setCallback(new d());
    }

    private final void initCommentChange() {
        EmojiEditText emojiEditText;
        WorksDialogBroadcastFloorCommentInputBinding mBinding = getMBinding();
        if (mBinding == null || (emojiEditText = mBinding.f13981a) == null) {
            return;
        }
        emojiEditText.addTextChangedListener(new e());
    }

    private final void initEmojiPanel() {
        this.emojiPanelFragment = EmojiPanelFragment.INSTANCE.a(new f());
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        int i = R.id.emoji_sticker_container;
        EmojiPanelFragment emojiPanelFragment = this.emojiPanelFragment;
        Intrinsics.checkNotNull(emojiPanelFragment);
        fragmentTransactionBeginTransaction.replace(i, emojiPanelFragment, EmojiPanelFragment.class.getName()).commit();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.TextView, com.huachenjie.base.util.rich_text.RichEditView] */
    private final void initEtEvent() {
        ?? r0;
        WorksDialogBroadcastFloorCommentInputBinding mBinding = getMBinding();
        if (mBinding == null || (r0 = mBinding.f13981a) == 0) {
            return;
        }
        r0.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.zj.adlib.qo1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return CommentInputDialog.initEtEvent$lambda$6$lambda$5(this.f44254a, textView, i, keyEvent);
            }
        });
        r0.setSpecialSymbolCallback(new Function1<String, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.comment.CommentInputDialog$initEtEvent$1$2
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
                    this.this$0.getClickProxy().l(true);
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
        clickProxy.g(textView);
        return true;
    }

    private final void initKeyBoardListener() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        KeyboardUtils.p(window, new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.zj.adlib.so1
            @Override // com.blankj.utilcode.util.KeyboardUtils.OnSoftInputChangedListener
            public final void a(int i) {
                CommentInputDialog.initKeyBoardListener$lambda$8$lambda$7(this.f44728a, i);
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
            Boolean value = commentInputDialog.getMViewModel().m().getValue();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(value, bool)) {
                commentInputDialog.getMViewModel().m().setValue(Boolean.FALSE);
            }
            if (Intrinsics.areEqual(commentInputDialog.getMViewModel().l().getValue(), bool)) {
                commentInputDialog.getMViewModel().l().setValue(Boolean.FALSE);
            }
            commentInputDialog.fitPanelViewHeight(i);
        } else {
            Boolean value2 = commentInputDialog.getMViewModel().m().getValue();
            Boolean bool2 = Boolean.TRUE;
            if (!Intrinsics.areEqual(value2, bool2) && !Intrinsics.areEqual(commentInputDialog.getMViewModel().l().getValue(), bool2) && !commentInputDialog.backNeedShowKeyboard) {
                commentInputDialog.dismissAllowingStateLoss();
            }
        }
        commentInputDialog.getMViewModel().n().setValue(Boolean.valueOf(i > 0));
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
    public final void onVoiceStop() {
        ImageView imageView;
        LottieAnimationView lottieAnimationView;
        WorksDialogBroadcastFloorCommentInputBinding mBinding = getMBinding();
        if (mBinding != null && (lottieAnimationView = mBinding.f13980a) != null) {
            lottieAnimationView.cancelAnimation();
        }
        WorksDialogBroadcastFloorCommentInputBinding mBinding2 = getMBinding();
        LottieAnimationView lottieAnimationView2 = mBinding2 != null ? mBinding2.f13980a : null;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setProgress(0.0f);
        }
        WorksDialogBroadcastFloorCommentInputBinding mBinding3 = getMBinding();
        if (mBinding3 == null || (imageView = mBinding3.f13978a) == null) {
            return;
        }
        imageView.setImageResource(R.drawable.works_ic_broadcast_message_voice_start);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playVoice() {
        String path;
        BroadcastFloorMessageVoiceBean value = getMViewModel().o().getValue();
        if (value == null || (path = value.getPath()) == null) {
            return;
        }
        f64.b().i(requireContext(), path, m55.c(path), new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showKeyboard() {
        EmojiEditText emojiEditText;
        WorksDialogBroadcastFloorCommentInputBinding mBinding = getMBinding();
        if (mBinding == null || (emojiEditText = mBinding.f13981a) == null) {
            return;
        }
        KeyboardUtils.s(emojiEditText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopVoice() {
        f64.b().j();
        onVoiceStop();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_broadcast_floor_comment_input;
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
        MutableLiveData<String> mutableLiveDataJ = getMViewModel().j();
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(KEY_HINT)) == null) {
            string = "";
        }
        mutableLiveDataJ.setValue(string);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    @SuppressLint({"ClickableViewAccessibility"})
    public void initView() {
        CardView cardView;
        super.initView();
        this.picker = MediaPicker.v(this, new g());
        WorksDialogBroadcastFloorCommentInputBinding mBinding = getMBinding();
        if (mBinding != null && (cardView = mBinding.f13979a) != null) {
            cardView.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.uo1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return CommentInputDialog.initView$lambda$1(view, motionEvent);
                }
            });
        }
        initCommentChange();
        initEtEvent();
        initEmojiPanel();
        initAudioPanel();
        initKeyBoardListener();
        getHandler().postDelayed(new Runnable() { // from class: com.zj.adlib.wo1
            @Override // java.lang.Runnable
            public final void run() {
                CommentInputDialog.initView$lambda$2(this.f45645a);
            }
        }, 300L);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new ComponentDialog(requireContext(), getTheme()) { // from class: com.huachenjie.works.page.broadcast_floor.comment.CommentInputDialog.onCreateDialog.1
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
        stopVoice();
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
