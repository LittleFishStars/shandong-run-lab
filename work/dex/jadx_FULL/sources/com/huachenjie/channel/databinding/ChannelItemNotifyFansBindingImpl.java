package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.channel.external.widget.FriendFollowButton;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLView;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;
import com.zj.adlib.yv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemNotifyFansBindingImpl extends ChannelItemNotifyFansBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8111a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8112a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f8114a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33295a = sparseIntArray;
        sparseIntArray.put(R.id.iv_menu, 5);
    }

    public ChannelItemNotifyFansBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f8111a, f33295a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean readFlag;
        String avatarFrameImgUrl;
        String nickName;
        String avatar;
        synchronized (this) {
            j = this.f8112a;
            this.f8112a = 0L;
        }
        FansBean fansBean = ((ChannelItemNotifyFansBinding) this).f8109a;
        long j2 = j & 3;
        if (j2 == 0 || fansBean == null) {
            readFlag = false;
            avatarFrameImgUrl = null;
            nickName = null;
            avatar = null;
        } else {
            avatarFrameImgUrl = fansBean.getAvatarFrameImgUrl();
            readFlag = fansBean.getReadFlag();
            nickName = fansBean.getNickName();
            avatar = fansBean.getAvatar();
        }
        if (j2 != 0) {
            yv9.a(((ChannelItemNotifyFansBinding) this).f8110a, fansBean, 2);
            aw9.d(((ChannelItemNotifyFansBinding) this).f8108a, avatar, false, null);
            aw9.c(((ChannelItemNotifyFansBinding) this).f8108a, avatarFrameImgUrl, null);
            CommonBindingAdapter.l0(this.f8114a, readFlag);
            TextViewBindingAdapter.setText(((ChannelItemNotifyFansBinding) this).f8107a, nickName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8112a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8112a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemNotifyFansBinding
    public void k(@Nullable FansBean fansBean) {
        ((ChannelItemNotifyFansBinding) this).f8109a = fansBean;
        synchronized (this) {
            this.f8112a |= 1;
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
        k((FansBean) obj);
        return true;
    }

    public ChannelItemNotifyFansBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FriendFollowButton) objArr[4], (AvatarView) objArr[1], (ImageView) objArr[5], (TextView) objArr[3]);
        this.f8112a = -1L;
        ((ChannelItemNotifyFansBinding) this).f8110a.setTag(null);
        ((ChannelItemNotifyFansBinding) this).f8108a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8113a = linearLayout;
        linearLayout.setTag(null);
        BLView bLView = (BLView) objArr[2];
        this.f8114a = bLView;
        bLView.setTag(null);
        ((ChannelItemNotifyFansBinding) this).f8107a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
