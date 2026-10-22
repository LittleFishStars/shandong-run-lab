package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.school.ThisSchoolFragment;
import com.huachenjie.works.page.alumni.school.ThisSchoolVM;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksHeadThisSchoolBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14405a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ThisSchoolFragment.ClickProxy f14406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ThisSchoolVM f14407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f14408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Banner f14410a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14411b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLImageView f14412b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final BLImageView f14413c;

    @NonNull
    public final TextView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final BLImageView f14414d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public WorksHeadThisSchoolBinding(Object _bindingComponent, View _root, int _localFieldCount, Banner banner, BLTextView channelMain, View headerStatusSpace, BLImageView ivAvatar, ImageView ivBg, ImageView ivSwitchSchool, BLImageView ivUser1, BLImageView ivUser2, BLImageView ivUser3, TextView tvHotList, TextView tvName, TextView tvNew, TextView tvPost1, TextView tvPost2, TextView tvPost3, TextView tvPost4, TextView tvPost5, TextView tvPost6) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14410a = banner;
        this.f14409a = channelMain;
        this.f36987a = headerStatusSpace;
        this.f14408a = ivAvatar;
        this.f14404a = ivBg;
        this.b = ivSwitchSchool;
        this.f14412b = ivUser1;
        this.f14413c = ivUser2;
        this.f14414d = ivUser3;
        this.f14405a = tvHotList;
        this.f14411b = tvName;
        this.c = tvNew;
        this.d = tvPost1;
        this.e = tvPost2;
        this.f = tvPost3;
        this.g = tvPost4;
        this.h = tvPost5;
        this.i = tvPost6;
    }

    public static WorksHeadThisSchoolBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksHeadThisSchoolBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksHeadThisSchoolBinding) ViewDataBinding.bind(component, view, R.layout.works_head_this_school);
    }

    @NonNull
    public static WorksHeadThisSchoolBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksHeadThisSchoolBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksHeadThisSchoolBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksHeadThisSchoolBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_head_this_school, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksHeadThisSchoolBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksHeadThisSchoolBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_head_this_school, null, false, component);
    }

    @Nullable
    public ThisSchoolFragment.ClickProxy f() {
        return this.f14406a;
    }

    @Nullable
    public ThisSchoolVM g() {
        return this.f14407a;
    }

    public abstract void l(@Nullable ThisSchoolFragment.ClickProxy click);

    public abstract void m(@Nullable ThisSchoolVM vm);
}
