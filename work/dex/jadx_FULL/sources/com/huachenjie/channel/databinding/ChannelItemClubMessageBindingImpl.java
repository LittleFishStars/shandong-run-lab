package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ClubMessageBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemClubMessageBindingImpl extends ChannelItemClubMessageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7950a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7951a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f7952a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7953a;

    @NonNull
    public final TextView c;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33237a = sparseIntArray;
        sparseIntArray.put(R.id.v_line, 7);
    }

    public ChannelItemClubMessageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f7950a, f33237a));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003f  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        RequestOptions requestOptions2;
        String str;
        String messageTitle;
        String applyTimeStr;
        String firstImageUrl;
        String nickName;
        synchronized (this) {
            j = this.f7951a;
            this.f7951a = 0L;
        }
        ClubMessageBean clubMessageBean = ((ChannelItemClubMessageBinding) this).f7948a;
        long j2 = j & 3;
        String str2 = null;
        if (j2 != 0) {
            requestOptions = ju3.b;
            requestOptions2 = ju3.h;
            if (clubMessageBean != null) {
                String clubName = clubMessageBean.getClubName();
                messageTitle = clubMessageBean.getMessageTitle();
                applyTimeStr = clubMessageBean.getApplyTimeStr();
                firstImageUrl = clubMessageBean.getFirstImageUrl();
                nickName = clubMessageBean.getNickName();
                String avatar = clubMessageBean.getAvatar();
                str = clubName;
                str2 = avatar;
            } else {
                str = null;
            }
            if (j2 != 0) {
                CommonBindingAdapter.b0(((ChannelItemClubMessageBinding) this).f7946a, str2, requestOptions, false);
                CommonBindingAdapter.b0(((ChannelItemClubMessageBinding) this).b, firstImageUrl, requestOptions2, false);
                TextViewBindingAdapter.setText(this.f7953a, str);
                TextViewBindingAdapter.setText(this.c, applyTimeStr);
                TextViewBindingAdapter.setText(((ChannelItemClubMessageBinding) this).f7947a, nickName);
                TextViewBindingAdapter.setText(((ChannelItemClubMessageBinding) this).f7949b, messageTitle);
            }
        }
        requestOptions = null;
        requestOptions2 = null;
        str = null;
        messageTitle = str;
        applyTimeStr = messageTitle;
        firstImageUrl = applyTimeStr;
        nickName = firstImageUrl;
        if (j2 != 0) {
            CommonBindingAdapter.b0(((ChannelItemClubMessageBinding) this).f7946a, str2, requestOptions, false);
            CommonBindingAdapter.b0(((ChannelItemClubMessageBinding) this).b, firstImageUrl, requestOptions2, false);
            TextViewBindingAdapter.setText(this.f7953a, str);
            TextViewBindingAdapter.setText(this.c, applyTimeStr);
            TextViewBindingAdapter.setText(((ChannelItemClubMessageBinding) this).f7947a, nickName);
            TextViewBindingAdapter.setText(((ChannelItemClubMessageBinding) this).f7949b, messageTitle);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7951a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7951a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemClubMessageBinding
    public void k(@Nullable ClubMessageBean clubMessageBean) {
        ((ChannelItemClubMessageBinding) this).f7948a = clubMessageBean;
        synchronized (this) {
            this.f7951a |= 1;
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
        k((ClubMessageBean) obj);
        return true;
    }

    public ChannelItemClubMessageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (ImageView) objArr[1], (TextView) objArr[5], (TextView) objArr[3], (View) objArr[7]);
        this.f7951a = -1L;
        ((ChannelItemClubMessageBinding) this).f7946a.setTag(null);
        ((ChannelItemClubMessageBinding) this).b.setTag(null);
        CardView cardView = (CardView) objArr[0];
        this.f7952a = cardView;
        cardView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f7953a = bLTextView;
        bLTextView.setTag(null);
        TextView textView = (TextView) objArr[6];
        this.c = textView;
        textView.setTag(null);
        ((ChannelItemClubMessageBinding) this).f7947a.setTag(null);
        ((ChannelItemClubMessageBinding) this).f7949b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
