package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.widget.TagListView;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemAttentionWorksHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f14443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkDetailBean f14446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TagListView f14447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14448a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f14449b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public WorksItemAttentionWorksHeaderBinding(Object _bindingComponent, View _root, int _localFieldCount, AvatarView ivAvatar, RelativeLayout llNickName, TagListView tagListView, TextView tvContent, BLTextView tvLevel, TextView tvLookAll, TextView tvNickName, TextView tvPublishTime, BLTextView tvTag, TextView tvTitle, View vLine) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14445a = ivAvatar;
        this.f14443a = llNickName;
        this.f14447a = tagListView;
        this.f14444a = tvContent;
        this.f14448a = tvLevel;
        this.b = tvLookAll;
        this.c = tvNickName;
        this.d = tvPublishTime;
        this.f14449b = tvTag;
        this.e = tvTitle;
        this.f36999a = vLine;
    }

    public static WorksItemAttentionWorksHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemAttentionWorksHeaderBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemAttentionWorksHeaderBinding) ViewDataBinding.bind(component, view, R.layout.works_item_attention_works_header);
    }

    @NonNull
    public static WorksItemAttentionWorksHeaderBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemAttentionWorksHeaderBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemAttentionWorksHeaderBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemAttentionWorksHeaderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_attention_works_header, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemAttentionWorksHeaderBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemAttentionWorksHeaderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_attention_works_header, null, false, component);
    }

    @Nullable
    public WorkDetailBean f() {
        return this.f14446a;
    }

    public abstract void k(@Nullable WorkDetailBean vm);
}
