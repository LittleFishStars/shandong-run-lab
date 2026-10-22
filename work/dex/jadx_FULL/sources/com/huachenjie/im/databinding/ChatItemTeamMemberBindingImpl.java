package com.huachenjie.im.databinding;

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
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.im.bean.TeamMemberBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatItemTeamMemberBindingImpl extends ChatItemTeamMemberBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34412a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9663a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f9667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9668a;

    public ChatItemTeamMemberBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9663a, f34412a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        String name;
        String avatar;
        String avatarFrameImgUrl;
        Boolean boolIsOwner;
        synchronized (this) {
            j = this.f9664a;
            this.f9664a = 0L;
        }
        TeamMemberBean teamMemberBean = ((ChatItemTeamMemberBinding) this).f34411a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (teamMemberBean != null) {
                name = teamMemberBean.getName();
                avatarFrameImgUrl = teamMemberBean.getAvatarFrameImgUrl();
                boolIsOwner = teamMemberBean.isOwner();
                avatar = teamMemberBean.getAvatar();
            } else {
                name = null;
                avatar = null;
                avatarFrameImgUrl = null;
                boolIsOwner = null;
            }
            zSafeUnbox = ViewDataBinding.safeUnbox(boolIsOwner);
        } else {
            zSafeUnbox = false;
            name = null;
            avatar = null;
            avatarFrameImgUrl = null;
        }
        if (j2 != 0) {
            aw9.d(this.f9667a, avatar, false, null);
            aw9.c(this.f9667a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(this.f9666a, name);
            CommonBindingAdapter.l0(this.f9668a, zSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9664a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9664a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.ChatItemTeamMemberBinding
    public void k(@Nullable TeamMemberBean teamMemberBean) {
        ((ChatItemTeamMemberBinding) this).f34411a = teamMemberBean;
        synchronized (this) {
            this.f9664a |= 1;
        }
        notifyPropertyChanged(yk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (yk0.g != i) {
            return false;
        }
        k((TeamMemberBean) obj);
        return true;
    }

    public ChatItemTeamMemberBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f9664a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9665a = linearLayout;
        linearLayout.setTag(null);
        AvatarView avatarView = (AvatarView) objArr[1];
        this.f9667a = avatarView;
        avatarView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f9666a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f9668a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
