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
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.external.widget.UserReportButton;
import com.huachenjie.works.page.campus_wall.detail.PostDetailActivity;
import com.huachenjie.works.page.campus_wall.detail.PostDetailViewModel;
import com.huachenjie.works.widget.PostDeleteButton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivityPostDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f13883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13885a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f13886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f13887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLOperateAnimView f13888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final UserReportButton f13889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PostDetailActivity.a f13890a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PostDetailViewModel f13891a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PostDeleteButton f13892a;

    @NonNull
    public final TextView b;

    public WorksActivityPostDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView cardBottom, FrameLayout flContainer, AvatarView ivAvatar, ImageView ivBack, PostDeleteButton ivDelete, UserReportButton ivReport, TextView tvName, TextView tvShare, View vHead, BLOperateAnimView vLike) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f13886a = cardBottom;
        this.f13883a = flContainer;
        this.f13887a = ivAvatar;
        this.f13884a = ivBack;
        this.f13892a = ivDelete;
        this.f13889a = ivReport;
        this.f13885a = tvName;
        this.b = tvShare;
        this.f36786a = vHead;
        this.f13888a = vLike;
    }

    public static WorksActivityPostDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivityPostDetailBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivityPostDetailBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_post_detail);
    }

    @NonNull
    public static WorksActivityPostDetailBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivityPostDetailBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivityPostDetailBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivityPostDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_post_detail, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivityPostDetailBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivityPostDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_post_detail, null, false, component);
    }

    @Nullable
    public PostDetailActivity.a f() {
        return this.f13890a;
    }

    @Nullable
    public PostDetailViewModel g() {
        return this.f13891a;
    }

    public abstract void l(@Nullable PostDetailActivity.a click);

    public abstract void m(@Nullable PostDetailViewModel vm);
}
