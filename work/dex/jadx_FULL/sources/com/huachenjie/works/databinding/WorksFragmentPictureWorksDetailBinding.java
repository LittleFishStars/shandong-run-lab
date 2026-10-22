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
import com.huachenjie.works.external.widget.UserLaoButton;
import com.huachenjie.works.external.widget.UserReportButton;
import com.huachenjie.works.page.details.picture.PictureWorksDetailFragment;
import com.huachenjie.works.page.details.picture.PictureWorksDetailModel;
import com.huachenjie.works.widget.TagListView;
import com.huachenjie.works.widget.WorksDeleteButton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentPictureWorksDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f14248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLOperateAnimView f14253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final UserLaoButton f14254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final UserReportButton f14255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PictureWorksDetailFragment.a f14256a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PictureWorksDetailModel f14257a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TagListView f14258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WorksDeleteButton f14259a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLOperateAnimView f14260b;

    @NonNull
    public final TextView c;

    public WorksFragmentPictureWorksDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, UserLaoButton btLao, CardView cardBottom, FrameLayout flContainer, AvatarView ivAvatar, ImageView ivBack, WorksDeleteButton ivDelete, UserReportButton ivReport, TagListView tagList, TextView tvComment, TextView tvName, TextView tvShare, BLOperateAnimView vCollection, View vHead, BLOperateAnimView vLike) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14254a = btLao;
        this.f14251a = cardBottom;
        this.f14248a = flContainer;
        this.f14252a = ivAvatar;
        this.f14249a = ivBack;
        this.f14259a = ivDelete;
        this.f14255a = ivReport;
        this.f14258a = tagList;
        this.f14250a = tvComment;
        this.b = tvName;
        this.c = tvShare;
        this.f14253a = vCollection;
        this.f36927a = vHead;
        this.f14260b = vLike;
    }

    public static WorksFragmentPictureWorksDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentPictureWorksDetailBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentPictureWorksDetailBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_picture_works_detail);
    }

    @NonNull
    public static WorksFragmentPictureWorksDetailBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentPictureWorksDetailBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentPictureWorksDetailBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentPictureWorksDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_picture_works_detail, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentPictureWorksDetailBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentPictureWorksDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_picture_works_detail, null, false, component);
    }

    @Nullable
    public PictureWorksDetailFragment.a f() {
        return this.f14256a;
    }

    @Nullable
    public PictureWorksDetailModel g() {
        return this.f14257a;
    }

    public abstract void l(@Nullable PictureWorksDetailFragment.a click);

    public abstract void m(@Nullable PictureWorksDetailModel vm);
}
