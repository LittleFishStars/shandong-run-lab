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
import com.huachenjie.channel.bean.OrganizeTeamBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLTextView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemMyChannelOrganizeChatBindingImpl extends ChannelItemMyChannelOrganizeChatBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33283a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8070a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8074a;

    @NonNull
    public final TextView b;

    public ChannelItemMyChannelOrganizeChatBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f8070a, f33283a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        int i;
        String message;
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        String str;
        String str2;
        int i3;
        String teamTitle;
        Context context;
        int i4;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f8071a;
            this.f8071a = 0L;
        }
        Boolean bool = ((ChannelItemMyChannelOrganizeChatBinding) this).f8069a;
        OrganizeTeamBean organizeTeamBean = ((ChannelItemMyChannelOrganizeChatBinding) this).f33282a;
        long j4 = j & 5;
        if (j4 != 0) {
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j4 != 0) {
                if (zSafeUnbox) {
                    j2 = j | 16;
                    j3 = 256;
                } else {
                    j2 = j | 8;
                    j3 = 128;
                }
                j = j2 | j3;
            }
            int i5 = zSafeUnbox ? 20 : 0;
            if (zSafeUnbox) {
                context = this.f8072a.getContext();
                i4 = R.drawable.channel_bg_topic_chat_last;
            } else {
                context = this.f8072a.getContext();
                i4 = R.drawable.channel_bg_topic_chat_normal;
            }
            drawable = AppCompatResources.getDrawable(context, i4);
            i = i5;
        } else {
            drawable = null;
            i = 0;
        }
        long j5 = j & 6;
        if (j5 != 0) {
            if (organizeTeamBean != null) {
                int messageCount = organizeTeamBean.getMessageCount();
                teamTitle = organizeTeamBean.getTeamTitle();
                message = organizeTeamBean.getMessage();
                i3 = messageCount;
            } else {
                message = null;
                i3 = 0;
                teamTitle = null;
            }
            boolean z4 = i3 > 0;
            boolean z5 = i3 > 99;
            boolean zIsEmpty = TextUtils.isEmpty(message);
            if (j5 != 0) {
                j = z5 ? j | 64 : j | 32;
            }
            z = !zIsEmpty;
            z3 = z5;
            str = teamTitle;
            i2 = i3;
            z2 = z4;
        } else {
            message = null;
            z = false;
            z2 = false;
            i2 = 0;
            z3 = false;
            str = null;
        }
        if ((32 & j) != 0) {
            str2 = i2 + "";
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
            ViewBindingAdapter.setBackground(this.f8072a, drawable);
            CommonBindingAdapter.O(this.f8072a, 12, 20, 12, i, null);
        }
        if (j6 != 0) {
            TextViewBindingAdapter.setText(this.f8073a, str);
            TextViewBindingAdapter.setText(this.b, message);
            CommonBindingAdapter.l0(this.b, z);
            TextViewBindingAdapter.setText(this.f8074a, str2);
            CommonBindingAdapter.l0(this.f8074a, z2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8071a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8071a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyChannelOrganizeChatBinding
    public void l(@Nullable OrganizeTeamBean organizeTeamBean) {
        ((ChannelItemMyChannelOrganizeChatBinding) this).f33282a = organizeTeamBean;
        synchronized (this) {
            this.f8071a |= 2;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyChannelOrganizeChatBinding
    public void m(@Nullable Boolean bool) {
        ((ChannelItemMyChannelOrganizeChatBinding) this).f8069a = bool;
        synchronized (this) {
            this.f8071a |= 1;
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
            l((OrganizeTeamBean) obj);
        }
        return true;
    }

    public ChannelItemMyChannelOrganizeChatBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f8071a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8072a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f8073a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.b = textView2;
        textView2.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f8074a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
