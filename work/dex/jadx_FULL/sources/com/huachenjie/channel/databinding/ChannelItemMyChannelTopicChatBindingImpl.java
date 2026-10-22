package com.huachenjie.channel.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicChat;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLTextView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemMyChannelTopicChatBindingImpl extends ChannelItemMyChannelTopicChatBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33287a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8083a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8084a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8086a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8087a;

    @NonNull
    public final TextView b;

    public ChannelItemMyChannelTopicChatBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f8083a, f33287a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        int i;
        int i2;
        String message;
        boolean z;
        boolean z2;
        int i3;
        boolean z3;
        String str;
        String str2;
        int i4;
        String subjectGroupName;
        Context context;
        int i5;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f8084a;
            this.f8084a = 0L;
        }
        Boolean bool = ((ChannelItemMyChannelTopicChatBinding) this).f8082a;
        MyChannelTopicChat myChannelTopicChat = ((ChannelItemMyChannelTopicChatBinding) this).f33286a;
        long j4 = j & 5;
        if (j4 != 0) {
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j4 != 0) {
                if (zSafeUnbox) {
                    j2 = j | 16 | 256;
                    j3 = 1024;
                } else {
                    j2 = j | 8 | 128;
                    j3 = 512;
                }
                j = j2 | j3;
            }
            int i6 = zSafeUnbox ? 20 : 0;
            int i7 = zSafeUnbox ? 12 : 0;
            if (zSafeUnbox) {
                context = this.f8085a.getContext();
                i5 = R.drawable.channel_bg_topic_chat_last;
            } else {
                context = this.f8085a.getContext();
                i5 = R.drawable.channel_bg_topic_chat_normal;
            }
            drawable = AppCompatResources.getDrawable(context, i5);
            i = i6;
            i2 = i7;
        } else {
            drawable = null;
            i = 0;
            i2 = 0;
        }
        long j5 = j & 6;
        if (j5 != 0) {
            if (myChannelTopicChat != null) {
                int messageCount = myChannelTopicChat.getMessageCount();
                subjectGroupName = myChannelTopicChat.getSubjectGroupName();
                message = myChannelTopicChat.getMessage();
                i4 = messageCount;
            } else {
                message = null;
                i4 = 0;
                subjectGroupName = null;
            }
            boolean z4 = i4 > 0;
            boolean z5 = i4 > 99;
            boolean zIsEmpty = TextUtils.isEmpty(message);
            if (j5 != 0) {
                j = z5 ? j | 64 : j | 32;
            }
            z = !zIsEmpty;
            z3 = z5;
            str = subjectGroupName;
            i3 = i4;
            z2 = z4;
        } else {
            message = null;
            z = false;
            z2 = false;
            i3 = 0;
            z3 = false;
            str = null;
        }
        if ((32 & j) != 0) {
            str2 = i3 + "";
        } else {
            str2 = null;
        }
        long j6 = 6 & j;
        if (j6 == 0) {
            str2 = null;
        } else if (z3) {
            str2 = "99+";
        }
        if ((j & 5) != 0) {
            ViewBindingAdapter.setBackground(this.f8085a, drawable);
            CommonBindingAdapter.O(this.f8085a, 12, 20, 12, i, null);
            CommonBindingAdapter.I(this.f8085a, 12, 0, 12, i2, null);
        }
        if (j6 != 0) {
            TextViewBindingAdapter.setText(this.f8086a, str);
            TextViewBindingAdapter.setText(this.b, message);
            CommonBindingAdapter.l0(this.b, z);
            TextViewBindingAdapter.setText(this.f8087a, str2);
            CommonBindingAdapter.l0(this.f8087a, z2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8084a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8084a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyChannelTopicChatBinding
    public void l(@Nullable MyChannelTopicChat myChannelTopicChat) {
        ((ChannelItemMyChannelTopicChatBinding) this).f33286a = myChannelTopicChat;
        synchronized (this) {
            this.f8084a |= 2;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyChannelTopicChatBinding
    public void m(@Nullable Boolean bool) {
        ((ChannelItemMyChannelTopicChatBinding) this).f8082a = bool;
        synchronized (this) {
            this.f8084a |= 1;
        }
        notifyPropertyChanged(tk0.C);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.C == i) {
            m((Boolean) obj);
        } else {
            if (tk0.g != i) {
                return false;
            }
            l((MyChannelTopicChat) obj);
        }
        return true;
    }

    public ChannelItemMyChannelTopicChatBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f8084a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8085a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f8086a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.b = textView2;
        textView2.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f8087a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
