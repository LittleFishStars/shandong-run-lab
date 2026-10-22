package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.comment.write.WriteReviewActivity;
import com.huachenjie.mall.page.comment.write.WriteReviewVM;
import com.huachenjie.mall.widget.CommentStarView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityWriteReviewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f10480a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10482a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f10483a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WriteReviewActivity.a f10485a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WriteReviewVM f10486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommentStarView f10487a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final CommentStarView f10488b;

    @NonNull
    public final CommentStarView c;

    public MallActivityWriteReviewBinding(Object obj, View view, int i, CommentStarView commentStarView, EditText editText, TextView textView, RecyclerView recyclerView, RoundImageView roundImageView, CommentStarView commentStarView2, CommentStarView commentStarView3, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView2, View view2) {
        super(obj, view, i);
        this.f10487a = commentStarView;
        this.f10480a = editText;
        this.f10481a = textView;
        this.f10482a = recyclerView;
        this.f10483a = roundImageView;
        this.f10488b = commentStarView2;
        this.c = commentStarView3;
        this.f10484a = layoutToolbarBindingBinding;
        this.b = textView2;
        this.f34887a = view2;
    }

    public static MallActivityWriteReviewBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityWriteReviewBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityWriteReviewBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_write_review);
    }

    @NonNull
    public static MallActivityWriteReviewBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityWriteReviewBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityWriteReviewBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityWriteReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_write_review, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityWriteReviewBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityWriteReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_write_review, null, false, obj);
    }

    @Nullable
    public WriteReviewActivity.a f() {
        return this.f10485a;
    }

    @Nullable
    public WriteReviewVM g() {
        return this.f10486a;
    }

    public abstract void l(@Nullable WriteReviewActivity.a aVar);

    public abstract void m(@Nullable WriteReviewVM writeReviewVM);
}
