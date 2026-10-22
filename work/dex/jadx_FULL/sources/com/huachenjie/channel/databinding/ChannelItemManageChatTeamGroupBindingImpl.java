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
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeamGroup;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemManageChatTeamGroupBindingImpl extends ChannelItemManageChatTeamGroupBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8027a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8029a;

    @NonNull
    public final TextView c;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33265a = sparseIntArray;
        sparseIntArray.put(R.id.tv_edit, 3);
        sparseIntArray.put(R.id.tv_delete, 4);
    }

    public ChannelItemManageChatTeamGroupBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f8027a, f33265a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean isExpanded;
        synchronized (this) {
            j = this.f8028a;
            this.f8028a = 0L;
        }
        MyChannelChatTeamGroup myChannelChatTeamGroup = ((ChannelItemManageChatTeamGroupBinding) this).f8026a;
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
                ((ChannelItemManageChatTeamGroupBinding) this).f33264a.setRotation(i);
            }
            TextViewBindingAdapter.setText(this.c, teamGroupTitle);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8028a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8028a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemManageChatTeamGroupBinding
    public void k(@Nullable MyChannelChatTeamGroup myChannelChatTeamGroup) {
        ((ChannelItemManageChatTeamGroupBinding) this).f8026a = myChannelChatTeamGroup;
        synchronized (this) {
            this.f8028a |= 1;
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

    public ChannelItemManageChatTeamGroupBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[3]);
        this.f8028a = -1L;
        ((ChannelItemManageChatTeamGroupBinding) this).f33264a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8029a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.c = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
