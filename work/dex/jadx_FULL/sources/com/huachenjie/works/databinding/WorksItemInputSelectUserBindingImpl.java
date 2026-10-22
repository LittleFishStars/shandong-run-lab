package com.huachenjie.works.databinding;

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
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemInputSelectUserBindingImpl extends WorksItemInputSelectUserBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37040a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14593a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14594a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14595a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14596a;

    @NonNull
    public final TextView b;

    public WorksItemInputSelectUserBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14593a, f37040a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String slogan;
        String userName;
        String avatar;
        String avatarFrameImgUrl;
        synchronized (this) {
            j = this.f14594a;
            this.f14594a = 0L;
        }
        UserInfoBean userInfoBean = ((WorksItemInputSelectUserBinding) this).f14592a;
        long j2 = j & 3;
        if (j2 == 0 || userInfoBean == null) {
            slogan = null;
            userName = null;
            avatar = null;
            avatarFrameImgUrl = null;
        } else {
            slogan = userInfoBean.getSlogan();
            userName = userInfoBean.getUserName();
            avatarFrameImgUrl = userInfoBean.getAvatarFrameImgUrl();
            avatar = userInfoBean.getAvatar();
        }
        if (j2 != 0) {
            aw9.d(this.f14596a, avatar, false, null);
            aw9.c(this.f14596a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(this.b, slogan);
            TextViewBindingAdapter.setText(((WorksItemInputSelectUserBinding) this).f37039a, userName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14594a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14594a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemInputSelectUserBinding
    public void k(@Nullable UserInfoBean Bean) {
        ((WorksItemInputSelectUserBinding) this).f14592a = Bean;
        synchronized (this) {
            this.f14594a |= 1;
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

    public WorksItemInputSelectUserBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[2]);
        this.f14594a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14595a = linearLayout;
        linearLayout.setTag(null);
        AvatarView avatarView = (AvatarView) bindings[1];
        this.f14596a = avatarView;
        avatarView.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.b = textView;
        textView.setTag(null);
        ((WorksItemInputSelectUserBinding) this).f37039a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
