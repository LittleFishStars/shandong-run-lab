package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopicChat;
import com.noober.background.view.BLTextView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemManageTopicChatBindingImpl extends ChannelItemManageTopicChatBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8038a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8040a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33271a = sparseIntArray;
        sparseIntArray.put(R.id.iv_icon, 3);
    }

    public ChannelItemManageTopicChatBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f8038a, f33271a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String subjectGroupName;
        int teamCount;
        synchronized (this) {
            j = this.f8039a;
            this.f8039a = 0L;
        }
        ManageTopicChat manageTopicChat = ((ChannelItemManageTopicChatBinding) this).f8036a;
        long j2 = j & 3;
        String str = null;
        if (j2 != 0) {
            if (manageTopicChat != null) {
                teamCount = manageTopicChat.getTeamCount();
                subjectGroupName = manageTopicChat.getSubjectGroupName();
            } else {
                subjectGroupName = null;
                teamCount = 0;
            }
            str = teamCount + "";
        } else {
            subjectGroupName = null;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((ChannelItemManageTopicChatBinding) this).f8037a, str);
            TextViewBindingAdapter.setText(((ChannelItemManageTopicChatBinding) this).f8035a, subjectGroupName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8039a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8039a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemManageTopicChatBinding
    public void k(@Nullable ManageTopicChat manageTopicChat) {
        ((ChannelItemManageTopicChatBinding) this).f8036a = manageTopicChat;
        synchronized (this) {
            this.f8039a |= 1;
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
        k((ManageTopicChat) obj);
        return true;
    }

    public ChannelItemManageTopicChatBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (BLTextView) objArr[2], (TextView) objArr[1]);
        this.f8039a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f8040a = relativeLayout;
        relativeLayout.setTag(null);
        ((ChannelItemManageTopicChatBinding) this).f8037a.setTag(null);
        ((ChannelItemManageTopicChatBinding) this).f8035a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
