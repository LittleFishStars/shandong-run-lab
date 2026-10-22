package com.huachenjie.works.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemSearchResultUserBindingImpl extends WorksItemSearchResultUserBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37070a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14685a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14688a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public WorksItemSearchResultUserBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f14685a, f37070a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        String avatar;
        String userName;
        String avatarFrameImgUrl;
        String slogan;
        String str2;
        synchronized (this) {
            j = this.f14686a;
            this.f14686a = 0L;
        }
        UserInfoBean userInfoBean = ((WorksItemSearchResultUserBinding) this).f14684a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (userInfoBean != null) {
                str = userInfoBean.formatterFollowedCount();
                userName = userInfoBean.getUserName();
                avatarFrameImgUrl = userInfoBean.getAvatarFrameImgUrl();
                slogan = userInfoBean.getSlogan();
                str2 = userInfoBean.formatterWorksCount();
                avatar = userInfoBean.getAvatar();
            } else {
                str = null;
                avatar = null;
                userName = null;
                avatarFrameImgUrl = null;
                slogan = null;
                str2 = null;
            }
            z = !TextUtils.isEmpty(slogan);
        } else {
            z = false;
            str = null;
            avatar = null;
            userName = null;
            avatarFrameImgUrl = null;
            slogan = null;
            str2 = null;
        }
        if (j2 != 0) {
            aw9.d(this.f14688a, avatar, false, null);
            aw9.c(this.f14688a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(this.b, slogan);
            CommonBindingAdapter.l0(this.b, z);
            TextViewBindingAdapter.setText(this.c, str2);
            TextViewBindingAdapter.setText(this.d, str);
            TextViewBindingAdapter.setText(((WorksItemSearchResultUserBinding) this).f37069a, userName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14686a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14686a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemSearchResultUserBinding
    public void k(@Nullable UserInfoBean Bean) {
        ((WorksItemSearchResultUserBinding) this).f14684a = Bean;
        synchronized (this) {
            this.f14686a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((UserInfoBean) variable);
        return true;
    }

    public WorksItemSearchResultUserBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[2]);
        this.f14686a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14687a = linearLayout;
        linearLayout.setTag(null);
        AvatarView avatarView = (AvatarView) bindings[1];
        this.f14688a = avatarView;
        avatarView.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[4];
        this.c = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[5];
        this.d = textView3;
        textView3.setTag(null);
        ((WorksItemSearchResultUserBinding) this).f37069a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
