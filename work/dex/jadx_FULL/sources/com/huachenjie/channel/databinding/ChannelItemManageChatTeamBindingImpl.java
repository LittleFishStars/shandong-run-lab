package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemManageChatTeamBindingImpl extends ChannelItemManageChatTeamBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8021a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f8024a;

    @NonNull
    public final ImageView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33263a = sparseIntArray;
        sparseIntArray.put(R.id.iv_edit, 3);
    }

    public ChannelItemManageChatTeamBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f8021a, f33263a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String teamTitle;
        synchronized (this) {
            j = this.f8022a;
            this.f8022a = 0L;
        }
        MyChannelChatTeam myChannelChatTeam = ((ChannelItemManageChatTeamBinding) this).f8020a;
        long j2 = j & 3;
        String logoUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.d;
            if (myChannelChatTeam != null) {
                logoUrl = myChannelChatTeam.getLogoUrl();
                teamTitle = myChannelChatTeam.getTeamTitle();
            } else {
                teamTitle = null;
            }
        } else {
            requestOptions = null;
            teamTitle = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.b, logoUrl, requestOptions, false);
            TextViewBindingAdapter.setText(this.f8023a, teamTitle);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8022a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8022a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemManageChatTeamBinding
    public void k(@Nullable MyChannelChatTeam myChannelChatTeam) {
        ((ChannelItemManageChatTeamBinding) this).f8020a = myChannelChatTeam;
        synchronized (this) {
            this.f8022a |= 1;
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

    public ChannelItemManageChatTeamBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3]);
        this.f8022a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f8024a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.b = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f8023a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
