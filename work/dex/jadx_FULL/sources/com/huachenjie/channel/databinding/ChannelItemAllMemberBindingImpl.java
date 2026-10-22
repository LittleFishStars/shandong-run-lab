package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemAllMemberBindingImpl extends ChannelItemAllMemberBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33223a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7915a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f7918a;

    public ChannelItemAllMemberBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f7915a, f33223a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String avatarFrameImgUrl;
        String nickName;
        String avatar;
        synchronized (this) {
            j = this.f7916a;
            this.f7916a = 0L;
        }
        ChannelMemberBean channelMemberBean = ((ChannelItemAllMemberBinding) this).f7914a;
        long j2 = j & 3;
        if (j2 == 0 || channelMemberBean == null) {
            avatarFrameImgUrl = null;
            nickName = null;
            avatar = null;
        } else {
            avatarFrameImgUrl = channelMemberBean.getAvatarFrameImgUrl();
            nickName = channelMemberBean.getNickName();
            avatar = channelMemberBean.getAvatar();
        }
        if (j2 != 0) {
            aw9.d(this.f7918a, avatar, false, null);
            aw9.c(this.f7918a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(((ChannelItemAllMemberBinding) this).f33222a, nickName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7916a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7916a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemAllMemberBinding
    public void k(@Nullable ChannelMemberBean channelMemberBean) {
        ((ChannelItemAllMemberBinding) this).f7914a = channelMemberBean;
        synchronized (this) {
            this.f7916a |= 1;
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

    public ChannelItemAllMemberBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2]);
        this.f7916a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7917a = linearLayout;
        linearLayout.setTag(null);
        AvatarView avatarView = (AvatarView) objArr[1];
        this.f7918a = avatarView;
        avatarView.setTag(null);
        ((ChannelItemAllMemberBinding) this).f33222a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
