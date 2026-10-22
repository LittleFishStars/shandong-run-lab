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
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeamGroup;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemMyChannelChatTeamGroupBindingImpl extends ChannelItemMyChannelChatTeamGroupBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33279a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8057a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8061a;

    public ChannelItemMyChannelChatTeamGroupBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f8057a, f33279a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean isExpanded;
        synchronized (this) {
            j = this.f8058a;
            this.f8058a = 0L;
        }
        MyChannelChatTeamGroup myChannelChatTeamGroup = ((ChannelItemMyChannelChatTeamGroupBinding) this).f33278a;
        long j2 = j & 3;
        int i = 0;
        String teamGroupTitle = null;
        if (j2 != 0) {
            if (myChannelChatTeamGroup != null) {
                teamGroupTitle = myChannelChatTeamGroup.getTeamGroupTitle();
                isExpanded = myChannelChatTeamGroup.getIsExpanded();
            } else {
                isExpanded = false;
            }
            if (j2 != 0) {
                j |= isExpanded ? 8L : 4L;
            }
            if (!isExpanded) {
                i = 270;
            }
        }
        if ((j & 3) != 0) {
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.f8059a.setRotation(i);
            }
            TextViewBindingAdapter.setText(this.f8061a, teamGroupTitle);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8058a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8058a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyChannelChatTeamGroupBinding
    public void k(@Nullable MyChannelChatTeamGroup myChannelChatTeamGroup) {
        ((ChannelItemMyChannelChatTeamGroupBinding) this).f33278a = myChannelChatTeamGroup;
        synchronized (this) {
            this.f8058a |= 1;
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
        k((MyChannelChatTeamGroup) obj);
        return true;
    }

    public ChannelItemMyChannelChatTeamGroupBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f8058a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8060a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f8059a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f8061a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
