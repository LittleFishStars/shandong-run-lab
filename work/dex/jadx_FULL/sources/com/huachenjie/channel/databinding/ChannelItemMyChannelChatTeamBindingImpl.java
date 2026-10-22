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
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemMyChannelChatTeamBindingImpl extends ChannelItemMyChannelChatTeamBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33277a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8051a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8056a;

    public ChannelItemMyChannelChatTeamBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f8051a, f33277a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        int teamCount;
        String teamTitle;
        RequestOptions requestOptions;
        String logoUrl;
        String str;
        synchronized (this) {
            j = this.f8052a;
            this.f8052a = 0L;
        }
        MyChannelChatTeam myChannelChatTeam = ((ChannelItemMyChannelChatTeamBinding) this).f33276a;
        long j2 = j & 3;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (myChannelChatTeam != null) {
                teamCount = myChannelChatTeam.getTeamCount();
                logoUrl = myChannelChatTeam.getLogoUrl();
                teamTitle = myChannelChatTeam.getTeamTitle();
            } else {
                teamCount = 0;
                teamTitle = null;
                logoUrl = null;
            }
            z = teamCount > 99;
            if (j2 != 0) {
                j = z ? j | 8 : j | 4;
            }
        } else {
            z = false;
            teamCount = 0;
            teamTitle = null;
            requestOptions = null;
            logoUrl = null;
        }
        String strValueOf = (j & 4) != 0 ? String.valueOf(teamCount) : null;
        long j3 = j & 3;
        if (j3 != 0) {
            str = z ? "99+" : strValueOf;
        } else {
            str = null;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(this.f8053a, logoUrl, requestOptions, false);
            TextViewBindingAdapter.setText(this.f8055a, teamTitle);
            TextViewBindingAdapter.setText(this.f8056a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8052a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8052a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyChannelChatTeamBinding
    public void k(@Nullable MyChannelChatTeam myChannelChatTeam) {
        ((ChannelItemMyChannelChatTeamBinding) this).f33276a = myChannelChatTeam;
        synchronized (this) {
            this.f8052a |= 1;
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
        k((MyChannelChatTeam) obj);
        return true;
    }

    public ChannelItemMyChannelChatTeamBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f8052a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8054a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f8053a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f8055a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f8056a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
