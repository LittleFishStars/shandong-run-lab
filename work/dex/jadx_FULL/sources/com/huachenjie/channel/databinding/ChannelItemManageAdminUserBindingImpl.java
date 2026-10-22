package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.bean.ChannelAdminBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemManageAdminUserBindingImpl extends ChannelItemManageAdminUserBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33261a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8017a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f8019a;

    public ChannelItemManageAdminUserBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f8017a, f33261a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean canCancel;
        boolean z;
        String avatarFrameImgUrl;
        String slogan;
        String nickName;
        String avatar;
        synchronized (this) {
            j = this.f8018a;
            this.f8018a = 0L;
        }
        ChannelAdminBean channelAdminBean = ((ChannelItemManageAdminUserBinding) this).f8015a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (channelAdminBean != null) {
                avatarFrameImgUrl = channelAdminBean.getAvatarFrameImgUrl();
                slogan = channelAdminBean.getSlogan();
                nickName = channelAdminBean.getNickName();
                avatar = channelAdminBean.getAvatar();
                canCancel = channelAdminBean.getCanCancel();
            } else {
                canCancel = false;
                avatarFrameImgUrl = null;
                slogan = null;
                nickName = null;
                avatar = null;
            }
            z = !TextUtils.isEmpty(slogan);
        } else {
            canCancel = false;
            z = false;
            avatarFrameImgUrl = null;
            slogan = null;
            nickName = null;
            avatar = null;
        }
        if (j2 != 0) {
            aw9.d(((ChannelItemManageAdminUserBinding) this).f8014a, avatar, false, null);
            aw9.c(((ChannelItemManageAdminUserBinding) this).f8014a, avatarFrameImgUrl, null);
            CommonBindingAdapter.l0(((ChannelItemManageAdminUserBinding) this).f8016a, canCancel);
            TextViewBindingAdapter.setText(((ChannelItemManageAdminUserBinding) this).f33260a, slogan);
            CommonBindingAdapter.l0(((ChannelItemManageAdminUserBinding) this).f33260a, z);
            TextViewBindingAdapter.setText(this.b, nickName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8018a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8018a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemManageAdminUserBinding
    public void k(@Nullable ChannelAdminBean channelAdminBean) {
        ((ChannelItemManageAdminUserBinding) this).f8015a = channelAdminBean;
        synchronized (this) {
            this.f8018a |= 1;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.g != i) {
            return false;
        }
        k((ChannelAdminBean) obj);
        return true;
    }

    public ChannelItemManageAdminUserBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[1], (BLTextView) objArr[4], (TextView) objArr[3], (TextView) objArr[2]);
        this.f8018a = -1L;
        ((ChannelItemManageAdminUserBinding) this).f8014a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f8019a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ((ChannelItemManageAdminUserBinding) this).f8016a.setTag(null);
        ((ChannelItemManageAdminUserBinding) this).f33260a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
