package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.external.widget.UserLaoButton;
import com.huachenjie.works.external.widget.UserReportButton;
import com.huachenjie.works.widget.TagListView;
import com.huachenjie.works.widget.WorksDeleteButton;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemWorkDetailListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f37075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14695a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ExpandableTextView f14699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkDetailBean f14701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLOperateAnimView f14702a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final UserLaoButton f14703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final UserReportButton f14704a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TagListView f14705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WorksDeleteButton f14706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f14707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14709a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14710b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLOperateAnimView f14711b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f14712b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public WorksItemWorkDetailListBinding(Object _bindingComponent, View _root, int _localFieldCount, UserLaoButton btLao, ConstraintLayout flLevel, AvatarView ivAvatar, BLImageView ivBack, ImageView ivComment, WorksDeleteButton ivDelete, ImageView ivShare, BLOperateAnimView llCollection, LinearLayout llLeftContainer, BLOperateAnimView llLiked, TextView nickName, UserReportButton reportButton, TagListView tagListView, TextView tvComment, ExpandableTextView tvContent, BLTextView tvLevel, TextView tvLike, TextView tvLocation, TextView tvShare, BLTextView tvTag, BLLinearLayout vBottomContainer, View vLao) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14703a = btLao;
        this.f14698a = flLevel;
        this.f14700a = ivAvatar;
        this.f14707a = ivBack;
        this.f14695a = ivComment;
        this.f14706a = ivDelete;
        this.b = ivShare;
        this.f14702a = llCollection;
        this.f14696a = llLeftContainer;
        this.f14711b = llLiked;
        this.f14697a = nickName;
        this.f14704a = reportButton;
        this.f14705a = tagListView;
        this.f14710b = tvComment;
        this.f14699a = tvContent;
        this.f14709a = tvLevel;
        this.c = tvLike;
        this.d = tvLocation;
        this.e = tvShare;
        this.f14712b = tvTag;
        this.f14708a = vBottomContainer;
        this.f37075a = vLao;
    }

    public static WorksItemWorkDetailListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemWorkDetailListBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemWorkDetailListBinding) ViewDataBinding.bind(component, view, R.layout.works_item_work_detail_list);
    }

    @NonNull
    public static WorksItemWorkDetailListBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemWorkDetailListBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemWorkDetailListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemWorkDetailListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_work_detail_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemWorkDetailListBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemWorkDetailListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_work_detail_list, null, false, component);
    }

    @Nullable
    public WorkDetailBean f() {
        return this.f14701a;
    }

    public abstract void k(@Nullable WorkDetailBean vm);
}
