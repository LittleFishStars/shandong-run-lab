package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.page.comment.CommentInputDialog;
import com.huachenjie.works.page.comment.CommentInputVM;
import com.huachenjie.works.widget.PubWorkContentEditView;
import com.noober.background.view.BLRelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogCommentInputBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommentInputDialog.ClickProxy f14053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommentInputVM f14054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PubWorkContentEditView f14055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f14056a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final CardView f14057b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    public WorksDialogCommentInputBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView cardView, CardView cvPic, FrameLayout emojiStickerContainer, PubWorkContentEditView etComment, ImageView ivAt, ImageView ivEmoji, ImageView ivGoods, ImageView ivPic, BLRelativeLayout rlCommentInput, TextView tvSend) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14052a = cardView;
        this.f14057b = cvPic;
        this.f36849a = emojiStickerContainer;
        this.f14055a = etComment;
        this.f14050a = ivAt;
        this.b = ivEmoji;
        this.c = ivGoods;
        this.d = ivPic;
        this.f14056a = rlCommentInput;
        this.f14051a = tvSend;
    }

    public static WorksDialogCommentInputBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogCommentInputBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogCommentInputBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_comment_input);
    }

    @NonNull
    public static WorksDialogCommentInputBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogCommentInputBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogCommentInputBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogCommentInputBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_comment_input, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogCommentInputBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogCommentInputBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_comment_input, null, false, component);
    }

    @Nullable
    public CommentInputDialog.ClickProxy f() {
        return this.f14053a;
    }

    @Nullable
    public CommentInputVM g() {
        return this.f14054a;
    }

    public abstract void l(@Nullable CommentInputDialog.ClickProxy click);

    public abstract void m(@Nullable CommentInputVM vm);
}
