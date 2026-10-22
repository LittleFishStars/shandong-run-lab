package com.huachenjie.channel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.notify.NotifyFavoritesBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLView;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.s72;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemNotifyFavoritesBindingImpl extends ChannelItemNotifyFavoritesBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33297a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8117a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f8121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f8122a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public ChannelItemNotifyFavoritesBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f8117a, f33297a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String coverImg;
        Drawable drawable;
        String str;
        RequestOptions requestOptions;
        String strT;
        String str2;
        String avatarFrameImgUrl;
        String str3;
        boolean readFlag;
        boolean z;
        long messageTime;
        String nickName;
        String avatar;
        String str4;
        int i;
        boolean zShowFavorType;
        synchronized (this) {
            j = this.f8118a;
            this.f8118a = 0L;
        }
        NotifyFavoritesBean notifyFavoritesBean = ((ChannelItemNotifyFavoritesBinding) this).f8116a;
        long j2 = j & 3;
        if (j2 != 0) {
            requestOptions = ju3.p;
            if (notifyFavoritesBean != null) {
                messageTime = notifyFavoritesBean.getMessageTime();
                avatarFrameImgUrl = notifyFavoritesBean.getAvatarFrameImgUrl();
                readFlag = notifyFavoritesBean.getReadFlag();
                nickName = notifyFavoritesBean.getNickName();
                avatar = notifyFavoritesBean.getAvatar();
                int favorType = notifyFavoritesBean.getFavorType();
                str4 = notifyFavoritesBean.formatterContent();
                zShowFavorType = notifyFavoritesBean.showFavorType();
                coverImg = notifyFavoritesBean.getCoverImg();
                i = favorType;
            } else {
                messageTime = 0;
                coverImg = null;
                avatarFrameImgUrl = null;
                nickName = null;
                avatar = null;
                str4 = null;
                i = 0;
                readFlag = false;
                zShowFavorType = false;
            }
            strT = s72.t(messageTime);
            boolean z2 = i == 1;
            if (j2 != 0) {
                j |= z2 ? 8L : 4L;
            }
            drawable = AppCompatResources.getDrawable(this.f8119a.getContext(), z2 ? R.drawable.channel_ic_notify_liked : R.drawable.channel_ic_notify_collected);
            str = nickName;
            str2 = avatar;
            str3 = str4;
            z = zShowFavorType;
        } else {
            coverImg = null;
            drawable = null;
            str = null;
            requestOptions = null;
            strT = null;
            str2 = null;
            avatarFrameImgUrl = null;
            str3 = null;
            readFlag = false;
            z = false;
        }
        if ((j & 3) != 0) {
            aw9.d(((ChannelItemNotifyFavoritesBinding) this).f8115a, str2, false, null);
            aw9.c(((ChannelItemNotifyFavoritesBinding) this).f8115a, avatarFrameImgUrl, null);
            CommonBindingAdapter.l0(this.f8122a, readFlag);
            CommonBindingAdapter.l0(this.f8119a, z);
            ImageViewBindingAdapter.setImageDrawable(this.f8119a, drawable);
            TextViewBindingAdapter.setText(this.b, str3);
            TextViewBindingAdapter.setText(this.c, strT);
            CommonBindingAdapter.b0(this.f8121a, coverImg, requestOptions, false);
            TextViewBindingAdapter.setText(((ChannelItemNotifyFavoritesBinding) this).f33296a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8118a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8118a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemNotifyFavoritesBinding
    public void k(@Nullable NotifyFavoritesBean notifyFavoritesBean) {
        ((ChannelItemNotifyFavoritesBinding) this).f8116a = notifyFavoritesBean;
        synchronized (this) {
            this.f8118a |= 1;
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
        k((NotifyFavoritesBean) obj);
        return true;
    }

    public ChannelItemNotifyFavoritesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[1], (TextView) objArr[4]);
        this.f8118a = -1L;
        ((ChannelItemNotifyFavoritesBinding) this).f8115a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8120a = linearLayout;
        linearLayout.setTag(null);
        BLView bLView = (BLView) objArr[2];
        this.f8122a = bLView;
        bLView.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f8119a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.c = textView2;
        textView2.setTag(null);
        BLImageView bLImageView = (BLImageView) objArr[7];
        this.f8121a = bLImageView;
        bLImageView.setTag(null);
        ((ChannelItemNotifyFavoritesBinding) this).f33296a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
