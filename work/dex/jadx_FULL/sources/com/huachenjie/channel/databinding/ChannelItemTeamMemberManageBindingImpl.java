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
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.im.bean.TeamMemberBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemTeamMemberManageBindingImpl extends ChannelItemTeamMemberManageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33314a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8172a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f8176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8177a;

    public ChannelItemTeamMemberManageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f8172a, f33314a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int checkIcon;
        boolean zSafeUnbox;
        String name;
        String avatar;
        String avatarFrameImgUrl;
        Boolean boolIsOwner;
        synchronized (this) {
            j = this.f8173a;
            this.f8173a = 0L;
        }
        TeamMemberBean teamMemberBean = ((ChannelItemTeamMemberManageBinding) this).f8171a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (teamMemberBean != null) {
                name = teamMemberBean.getName();
                checkIcon = teamMemberBean.formatCheckIcon();
                avatarFrameImgUrl = teamMemberBean.getAvatarFrameImgUrl();
                boolIsOwner = teamMemberBean.isOwner();
                avatar = teamMemberBean.getAvatar();
            } else {
                checkIcon = 0;
                name = null;
                avatar = null;
                avatarFrameImgUrl = null;
                boolIsOwner = null;
            }
            zSafeUnbox = ViewDataBinding.safeUnbox(boolIsOwner);
        } else {
            checkIcon = 0;
            zSafeUnbox = false;
            name = null;
            avatar = null;
            avatarFrameImgUrl = null;
        }
        if (j2 != 0) {
            DrawablesBindingAdapter.e(((ChannelItemTeamMemberManageBinding) this).f33313a, checkIcon);
            aw9.d(this.f8176a, avatar, false, null);
            aw9.c(this.f8176a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(this.f8175a, name);
            CommonBindingAdapter.l0(this.f8177a, zSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8173a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8173a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemTeamMemberManageBinding
    public void k(@Nullable TeamMemberBean teamMemberBean) {
        ((ChannelItemTeamMemberManageBinding) this).f8171a = teamMemberBean;
        synchronized (this) {
            this.f8173a |= 1;
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
        k((TeamMemberBean) obj);
        return true;
    }

    public ChannelItemTeamMemberManageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1]);
        this.f8173a = -1L;
        ((ChannelItemTeamMemberManageBinding) this).f33313a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8174a = linearLayout;
        linearLayout.setTag(null);
        AvatarView avatarView = (AvatarView) objArr[2];
        this.f8176a = avatarView;
        avatarView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f8175a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f8177a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
