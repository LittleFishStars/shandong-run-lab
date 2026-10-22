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
import com.huachenjie.channel.bean.OrganizeTeamUserBean;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemOrganizeMemberBindingImpl extends ChannelItemOrganizeMemberBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33303a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8142a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f8145a;

    public ChannelItemOrganizeMemberBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f8142a, f33303a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String avatarFrameImgUrl;
        String nickName;
        String avatar;
        synchronized (this) {
            j = this.f8143a;
            this.f8143a = 0L;
        }
        OrganizeTeamUserBean organizeTeamUserBean = ((ChannelItemOrganizeMemberBinding) this).f8141a;
        long j2 = j & 3;
        if (j2 == 0 || organizeTeamUserBean == null) {
            avatarFrameImgUrl = null;
            nickName = null;
            avatar = null;
        } else {
            avatarFrameImgUrl = organizeTeamUserBean.getAvatarFrameImgUrl();
            nickName = organizeTeamUserBean.getNickName();
            avatar = organizeTeamUserBean.getAvatar();
        }
        if (j2 != 0) {
            aw9.d(this.f8145a, avatar, false, null);
            aw9.c(this.f8145a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(((ChannelItemOrganizeMemberBinding) this).f33302a, nickName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8143a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8143a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemOrganizeMemberBinding
    public void k(@Nullable OrganizeTeamUserBean organizeTeamUserBean) {
        ((ChannelItemOrganizeMemberBinding) this).f8141a = organizeTeamUserBean;
        synchronized (this) {
            this.f8143a |= 1;
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
        k((OrganizeTeamUserBean) obj);
        return true;
    }

    public ChannelItemOrganizeMemberBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2]);
        this.f8143a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8144a = linearLayout;
        linearLayout.setTag(null);
        AvatarView avatarView = (AvatarView) objArr[1];
        this.f8145a = avatarView;
        avatarView.setTag(null);
        ((ChannelItemOrganizeMemberBinding) this).f33302a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
