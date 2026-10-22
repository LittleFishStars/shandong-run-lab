package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.base.util.rich_text.RichEditView;
import com.huachenjie.base.widget.input_panel.audio.AudioPanelView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.broadcast_floor.comment.CommentInputDialog;
import com.huachenjie.works.page.broadcast_floor.comment.CommentInputVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogBroadcastFloorCommentInputBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f13979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f13980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RichEditView f13981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AudioPanelView f13982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommentInputDialog.ClickProxy f13983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommentInputVM f13984a;

    @NonNull
    public final FrameLayout b;

    public WorksDialogBroadcastFloorCommentInputBinding(Object _bindingComponent, View _root, int _localFieldCount, AudioPanelView audioPanel, CardView cardView, FrameLayout emojiStickerContainer, RichEditView etComment, FrameLayout flPanel, ImageView ivIcon, LottieAnimationView jsonAudio) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f13982a = audioPanel;
        this.f13979a = cardView;
        this.f36820a = emojiStickerContainer;
        this.f13981a = etComment;
        this.b = flPanel;
        this.f13978a = ivIcon;
        this.f13980a = jsonAudio;
    }

    public static WorksDialogBroadcastFloorCommentInputBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogBroadcastFloorCommentInputBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogBroadcastFloorCommentInputBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_broadcast_floor_comment_input);
    }

    @NonNull
    public static WorksDialogBroadcastFloorCommentInputBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogBroadcastFloorCommentInputBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogBroadcastFloorCommentInputBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogBroadcastFloorCommentInputBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_broadcast_floor_comment_input, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogBroadcastFloorCommentInputBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogBroadcastFloorCommentInputBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_broadcast_floor_comment_input, null, false, component);
    }

    @Nullable
    public CommentInputDialog.ClickProxy f() {
        return this.f13983a;
    }

    @Nullable
    public CommentInputVM g() {
        return this.f13984a;
    }

    public abstract void l(@Nullable CommentInputDialog.ClickProxy click);

    public abstract void m(@Nullable CommentInputVM vm);
}
