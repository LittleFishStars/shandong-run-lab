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
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemAddSubAdminBindingImpl extends ChannelItemAddSubAdminBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33219a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7904a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7905a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f7906a;

    public ChannelItemAddSubAdminBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f7904a, f33219a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        String adminStr;
        String avatar;
        String avatarFrameImgUrl;
        String slogan;
        String nickName;
        int channelMemberType;
        synchronized (this) {
            j = this.f7905a;
            this.f7905a = 0L;
        }
        ChannelMemberBean channelMemberBean = ((ChannelItemAddSubAdminBinding) this).f7902a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (channelMemberBean != null) {
                adminStr = channelMemberBean.getAdminStr();
                channelMemberType = channelMemberBean.getChannelMemberType();
                avatarFrameImgUrl = channelMemberBean.getAvatarFrameImgUrl();
                slogan = channelMemberBean.getSlogan();
                nickName = channelMemberBean.getNickName();
                avatar = channelMemberBean.getAvatar();
            } else {
                channelMemberType = 0;
                adminStr = null;
                avatar = null;
                avatarFrameImgUrl = null;
                slogan = null;
                nickName = null;
            }
            z = channelMemberType == 3;
            z2 = !TextUtils.isEmpty(slogan);
        } else {
            z = false;
            z2 = false;
            adminStr = null;
            avatar = null;
            avatarFrameImgUrl = null;
            slogan = null;
            nickName = null;
        }
        if (j2 != 0) {
            aw9.d(((ChannelItemAddSubAdminBinding) this).f7901a, avatar, false, null);
            aw9.c(((ChannelItemAddSubAdminBinding) this).f7901a, avatarFrameImgUrl, null);
            CommonBindingAdapter.e0(((ChannelItemAddSubAdminBinding) this).f7903a, z);
            TextViewBindingAdapter.setText(((ChannelItemAddSubAdminBinding) this).f7903a, adminStr);
            CommonBindingAdapter.l0(((ChannelItemAddSubAdminBinding) this).f33218a, z2);
            TextViewBindingAdapter.setText(((ChannelItemAddSubAdminBinding) this).f33218a, slogan);
            TextViewBindingAdapter.setText(this.b, nickName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7905a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7905a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemAddSubAdminBinding
    public void k(@Nullable ChannelMemberBean channelMemberBean) {
        ((ChannelItemAddSubAdminBinding) this).f7902a = channelMemberBean;
        synchronized (this) {
            this.f7905a |= 1;
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
        k((ChannelMemberBean) obj);
        return true;
    }

    public ChannelItemAddSubAdminBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[1], (BLTextView) objArr[4], (TextView) objArr[3], (TextView) objArr[2]);
        this.f7905a = -1L;
        ((ChannelItemAddSubAdminBinding) this).f7901a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f7906a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ((ChannelItemAddSubAdminBinding) this).f7903a.setTag(null);
        ((ChannelItemAddSubAdminBinding) this).f33218a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
