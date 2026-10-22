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
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.notify.NotifyMailBoxBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemNotifyMailboxBindingImpl extends ChannelItemNotifyMailboxBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8128a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f8130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f8131a;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33299a = sparseIntArray;
        sparseIntArray.put(R.id.iv_icon, 8);
        sparseIntArray.put(R.id.v_line, 9);
    }

    public ChannelItemNotifyMailboxBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f8128a, f33299a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String passStatus;
        String str2;
        int colorFromResource;
        boolean z;
        boolean z2;
        int i;
        int i2;
        String msgContent;
        String msgTitle;
        boolean z3;
        boolean zShowPassStatus;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f8129a;
            this.f8129a = 0L;
        }
        NotifyMailBoxBean notifyMailBoxBean = ((ChannelItemNotifyMailboxBinding) this).f8125a;
        long j4 = j & 3;
        String str3 = null;
        boolean readFlag = false;
        if (j4 != 0) {
            if (notifyMailBoxBean != null) {
                readFlag = notifyMailBoxBean.getReadFlag();
                boolean zShowLookDetail = notifyMailBoxBean.showLookDetail();
                String letterTime = notifyMailBoxBean.formatLetterTime();
                msgTitle = notifyMailBoxBean.getMsgTitle();
                passStatus = notifyMailBoxBean.formatPassStatus();
                zShowPassStatus = notifyMailBoxBean.showPassStatus();
                msgContent = notifyMailBoxBean.getMsgContent();
                z3 = zShowLookDetail;
                str3 = letterTime;
            } else {
                msgContent = null;
                msgTitle = null;
                passStatus = null;
                z3 = false;
                zShowPassStatus = false;
            }
            if (j4 != 0) {
                if (readFlag) {
                    j2 = j | 8 | 32;
                    j3 = 128;
                } else {
                    j2 = j | 4 | 16;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            colorFromResource = ViewDataBinding.getColorFromResource(((ChannelItemNotifyMailboxBinding) this).b, readFlag ? R.color.Color_FF650AEC : R.color.color_8997A4);
            int i3 = readFlag ? -13877680 : -7759964;
            i2 = readFlag ? -10155284 : -7759964;
            String str4 = str3;
            str3 = msgContent;
            str = str4;
            boolean z4 = z3;
            z = readFlag;
            readFlag = z4;
            int i4 = i3;
            str2 = msgTitle;
            z2 = zShowPassStatus;
            i = i4;
        } else {
            str = null;
            passStatus = null;
            str2 = null;
            colorFromResource = 0;
            z = false;
            z2 = false;
            i = 0;
            i2 = 0;
        }
        if ((j & 3) != 0) {
            CommonBindingAdapter.l0(((ChannelItemNotifyMailboxBinding) this).b, readFlag);
            CommonBindingAdapter.Y(((ChannelItemNotifyMailboxBinding) this).b, Integer.valueOf(colorFromResource));
            CommonBindingAdapter.l0(this.f8131a, z);
            CommonBindingAdapter.z(this.c, z);
            TextViewBindingAdapter.setText(this.c, str3);
            this.c.setTextColor(i);
            CommonBindingAdapter.z(this.d, z);
            TextViewBindingAdapter.setText(this.d, str);
            this.d.setTextColor(i);
            CommonBindingAdapter.z(((ChannelItemNotifyMailboxBinding) this).f8124a, z);
            ((ChannelItemNotifyMailboxBinding) this).f8124a.setTextColor(i2);
            CommonBindingAdapter.l0(((ChannelItemNotifyMailboxBinding) this).f8124a, readFlag);
            CommonBindingAdapter.l0(((ChannelItemNotifyMailboxBinding) this).f8126a, z2);
            TextViewBindingAdapter.setText(((ChannelItemNotifyMailboxBinding) this).f8126a, passStatus);
            TextViewBindingAdapter.setText(((ChannelItemNotifyMailboxBinding) this).f8127b, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8129a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8129a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemNotifyMailboxBinding
    public void k(@Nullable NotifyMailBoxBean notifyMailBoxBean) {
        ((ChannelItemNotifyMailboxBinding) this).f8125a = notifyMailBoxBean;
        synchronized (this) {
            this.f8129a |= 1;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((NotifyMailBoxBean) obj);
        return true;
    }

    public ChannelItemNotifyMailboxBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[8], (ImageView) objArr[5], (TextView) objArr[6], (BLTextView) objArr[3], (TextView) objArr[2], (View) objArr[9]);
        this.f8129a = -1L;
        ((ChannelItemNotifyMailboxBinding) this).b.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f8130a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        BLView bLView = (BLView) objArr[1];
        this.f8131a = bLView;
        bLView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.d = textView2;
        textView2.setTag(null);
        ((ChannelItemNotifyMailboxBinding) this).f8124a.setTag(null);
        ((ChannelItemNotifyMailboxBinding) this).f8126a.setTag(null);
        ((ChannelItemNotifyMailboxBinding) this).f8127b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
