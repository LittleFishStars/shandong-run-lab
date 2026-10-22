package com.huachenjie.channel.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelDetail;
import com.huachenjie.channel.page.my_channel.MyChannelFragment;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelLayoutMyChannelHeaderBindingImpl extends ChannelLayoutMyChannelHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8207a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8209a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f8212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f8213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f8214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8215a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8216b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f8217b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MyChannelFragment.ClickProxy f33323a;

        public a a(MyChannelFragment.ClickProxy clickProxy) {
            this.f33323a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33323a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MyChannelFragment.ClickProxy f33324a;

        public b a(MyChannelFragment.ClickProxy clickProxy) {
            this.f33324a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33324a.c(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MyChannelFragment.ClickProxy f33325a;

        public c a(MyChannelFragment.ClickProxy clickProxy) {
            this.f33325a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33325a.d(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MyChannelFragment.ClickProxy f33326a;

        public d a(MyChannelFragment.ClickProxy clickProxy) {
            this.f33326a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33326a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33322a = sparseIntArray;
        sparseIntArray.put(R.id.card_view, 16);
    }

    public ChannelLayoutMyChannelHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, f8207a, f33322a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        RequestOptions requestOptions2;
        String str;
        String str2;
        String str3;
        Drawable drawable;
        String str4;
        int i;
        String str5;
        boolean zIsShowOptBtn;
        Drawable drawable2;
        boolean z;
        String str6;
        String str7;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean zIsOfficial;
        Drawable drawable3;
        Drawable drawable4;
        String channelName;
        int i2;
        int i3;
        String coverUrl;
        c cVarA;
        d dVar;
        a aVar;
        b bVar;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        Drawable drawable5;
        String str8;
        String str9;
        Drawable drawable6;
        boolean z11;
        boolean z12;
        boolean showAdmin;
        Drawable optBtnIcon;
        boolean z13;
        String logo;
        String avatar2;
        Drawable bottomBg;
        String avatar1;
        String optBtnText;
        String avatar3;
        boolean zIsBgDark;
        boolean zIsRunOrUniverseChannel;
        String popularityValue;
        String channelUserValue;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f8208a;
            this.f8208a = 0L;
        }
        RequestOptions requestOptions3 = ((ChannelLayoutMyChannelHeaderBinding) this).f8202a;
        MyChannelDetail myChannelDetail = ((ChannelLayoutMyChannelHeaderBinding) this).f8203a;
        MyChannelFragment.ClickProxy clickProxy = ((ChannelLayoutMyChannelHeaderBinding) this).f8204a;
        long j4 = j & 10;
        if (j4 != 0) {
            requestOptions = ju3.b;
            requestOptions2 = ju3.p;
        } else {
            requestOptions = null;
            requestOptions2 = null;
        }
        if ((j & 11) != 0) {
            if (j4 != 0) {
                if (myChannelDetail != null) {
                    showAdmin = myChannelDetail.getShowAdmin();
                    zIsBgDark = myChannelDetail.isBgDark();
                    optBtnIcon = myChannelDetail.getOptBtnIcon();
                    popularityValue = myChannelDetail.getPopularityValue();
                    zIsShowOptBtn = myChannelDetail.isShowOptBtn();
                    logo = myChannelDetail.getLogo();
                    avatar2 = myChannelDetail.getAvatar2();
                    bottomBg = myChannelDetail.getBottomBg();
                    avatar1 = myChannelDetail.getAvatar1();
                    zIsRunOrUniverseChannel = myChannelDetail.isRunOrUniverseChannel();
                    channelUserValue = myChannelDetail.getChannelUserValue();
                    zIsOfficial = myChannelDetail.isOfficial();
                    optBtnText = myChannelDetail.getOptBtnText();
                    channelName = myChannelDetail.getChannelName();
                    avatar3 = myChannelDetail.getAvatar3();
                } else {
                    showAdmin = false;
                    zIsBgDark = false;
                    zIsShowOptBtn = false;
                    zIsRunOrUniverseChannel = false;
                    zIsOfficial = false;
                    optBtnIcon = null;
                    popularityValue = null;
                    logo = null;
                    avatar2 = null;
                    bottomBg = null;
                    avatar1 = null;
                    channelUserValue = null;
                    optBtnText = null;
                    channelName = null;
                    avatar3 = null;
                }
                if (j4 != 0) {
                    if (zIsBgDark) {
                        j2 = j | 128 | 8192 | 2097152;
                        j3 = 8388608;
                    } else {
                        j2 = j | 64 | 4096 | 1048576;
                        j3 = PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                    }
                    j = j2 | j3;
                }
                if ((j & 10) != 0) {
                    j = zIsOfficial ? j | 2048 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : j | 1024 | 262144;
                }
                i2 = zIsBgDark ? -1 : 1294745168;
                i3 = zIsBgDark ? -1 : -13877680;
                i = zIsBgDark ? -1 : -13421773;
                drawable5 = zIsBgDark ? AppCompatResources.getDrawable(((ChannelLayoutMyChannelHeaderBinding) this).f8200a.getContext(), R.drawable.channel_ic_hot_white) : AppCompatResources.getDrawable(((ChannelLayoutMyChannelHeaderBinding) this).f8200a.getContext(), R.drawable.channel_ic_hot_black);
                str8 = String.format(((ChannelLayoutMyChannelHeaderBinding) this).f8200a.getResources().getString(R.string.channel_my_channel_hot), popularityValue);
                boolean zIsEmpty = TextUtils.isEmpty(avatar2);
                boolean zIsEmpty2 = TextUtils.isEmpty(avatar1);
                z5 = !zIsRunOrUniverseChannel;
                str9 = String.format(((ChannelLayoutMyChannelHeaderBinding) this).b.getResources().getString(R.string.channel_my_channel_user_num), channelUserValue);
                drawable6 = AppCompatResources.getDrawable(this.c.getContext(), zIsOfficial ? R.drawable.channel_bg_main_channel_official : R.drawable.channel_bg_main_orz_official);
                boolean zIsEmpty3 = TextUtils.isEmpty(avatar3);
                if ((j & 10) != 0) {
                    j |= z5 ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                }
                z11 = !zIsEmpty;
                z13 = !zIsEmpty2;
                z12 = !zIsEmpty3;
                if ((j & 10) != 0) {
                    j |= z11 ? 32L : 16L;
                }
                if ((j & 10) != 0) {
                    j |= z13 ? 131072L : PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                }
                if ((j & 10) != 0) {
                    j |= z12 ? 512L : 256L;
                }
            } else {
                drawable5 = null;
                str8 = null;
                str9 = null;
                drawable6 = null;
                i = 0;
                z11 = false;
                z12 = false;
                showAdmin = false;
                optBtnIcon = null;
                z13 = false;
                zIsShowOptBtn = false;
                logo = null;
                avatar2 = null;
                bottomBg = null;
                avatar1 = null;
                z5 = false;
                zIsOfficial = false;
                optBtnText = null;
                channelName = null;
                avatar3 = null;
                i2 = 0;
                i3 = 0;
            }
            coverUrl = myChannelDetail != null ? myChannelDetail.getCoverUrl() : null;
            str6 = str9;
            drawable4 = drawable6;
            drawable = bottomBg;
            str4 = avatar3;
            z3 = z12;
            drawable2 = optBtnIcon;
            str = logo;
            str7 = str8;
            str3 = avatar1;
            z4 = z11;
            str5 = avatar2;
            z2 = z13;
            z = showAdmin;
            String str10 = optBtnText;
            drawable3 = drawable5;
            str2 = str10;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            drawable = null;
            str4 = null;
            i = 0;
            str5 = null;
            zIsShowOptBtn = false;
            drawable2 = null;
            z = false;
            str6 = null;
            str7 = null;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            zIsOfficial = false;
            drawable3 = null;
            drawable4 = null;
            channelName = null;
            i2 = 0;
            i3 = 0;
            coverUrl = null;
        }
        long j5 = j & 12;
        if (j5 == 0 || clickProxy == null) {
            cVarA = null;
            dVar = null;
            aVar = null;
            bVar = null;
        } else {
            d dVar2 = this.f8214a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f8214a = dVar2;
            }
            d dVarA = dVar2.a(clickProxy);
            a aVar2 = this.f8211a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f8211a = aVar2;
            }
            a aVarA = aVar2.a(clickProxy);
            b bVar2 = this.f8212a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f8212a = bVar2;
            }
            b bVarA = bVar2.a(clickProxy);
            c cVar = this.f8213a;
            if (cVar == null) {
                cVar = new c();
                this.f8213a = cVar;
            }
            cVarA = cVar.a(clickProxy);
            dVar = dVarA;
            bVar = bVarA;
            aVar = aVarA;
        }
        long j6 = j & 10;
        if (j6 != 0) {
            boolean z14 = z4 ? z : false;
            boolean z15 = z3 ? z : false;
            z9 = z5 ? z : false;
            z6 = z14;
            z7 = z2 ? z : false;
            z8 = z15;
        } else {
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
        }
        boolean certificationFlag = ((j & 262144) == 0 || myChannelDetail == null) ? false : myChannelDetail.getCertificationFlag();
        if (j6 != 0) {
            z10 = zIsOfficial ? true : certificationFlag;
        } else {
            z10 = false;
        }
        long j7 = j;
        if (j5 != 0) {
            CommonBindingAdapter.q(((ChannelLayoutMyChannelHeaderBinding) this).f8199a, bVar, null);
            CommonBindingAdapter.q(this.f8215a, cVarA, null);
            CommonBindingAdapter.q(this.f8209a, dVar, null);
            CommonBindingAdapter.q(this.f8217b, aVar, null);
            CommonBindingAdapter.q(((ChannelLayoutMyChannelHeaderBinding) this).b, dVar, null);
        }
        if (j6 != 0) {
            CommonBindingAdapter.b0(((ChannelLayoutMyChannelHeaderBinding) this).f8205a, str, requestOptions2, false);
            CommonBindingAdapter.l0(((ChannelLayoutMyChannelHeaderBinding) this).f8206b, z7);
            CommonBindingAdapter.b0(((ChannelLayoutMyChannelHeaderBinding) this).f8206b, str3, requestOptions, false);
            CommonBindingAdapter.l0(super.c, z6);
            CommonBindingAdapter.b0(super.c, str5, requestOptions, false);
            CommonBindingAdapter.l0(super.d, z8);
            CommonBindingAdapter.b0(super.d, str4, requestOptions, false);
            TextViewBindingAdapter.setDrawableStart(this.f8215a, drawable2);
            TextViewBindingAdapter.setText(this.f8215a, str2);
            CommonBindingAdapter.l0(this.f8215a, zIsShowOptBtn);
            CommonBindingAdapter.l0(this.f8209a, z9);
            CommonBindingAdapter.Y(this.f8209a, Integer.valueOf(i));
            ViewBindingAdapter.setBackground(this.f8216b, drawable);
            ViewBindingAdapter.setBackground(this.c, drawable4);
            CommonBindingAdapter.l0(this.c, z10);
            TextViewBindingAdapter.setText(this.d, channelName);
            this.d.setTextColor(i3);
            TextViewBindingAdapter.setDrawableStart(((ChannelLayoutMyChannelHeaderBinding) this).f8200a, drawable3);
            TextViewBindingAdapter.setText(((ChannelLayoutMyChannelHeaderBinding) this).f8200a, str7);
            int i4 = i;
            ((ChannelLayoutMyChannelHeaderBinding) this).f8200a.setTextColor(i4);
            TextViewBindingAdapter.setText(((ChannelLayoutMyChannelHeaderBinding) this).b, str6);
            ((ChannelLayoutMyChannelHeaderBinding) this).b.setTextColor(i4);
            boolean z16 = z;
            CommonBindingAdapter.l0(((ChannelLayoutMyChannelHeaderBinding) this).b, z16);
            ((ChannelLayoutMyChannelHeaderBinding) this).f33321a.setBackgroundColor(i2);
            CommonBindingAdapter.l0(((ChannelLayoutMyChannelHeaderBinding) this).f33321a, z16);
        }
        if ((j7 & 11) != 0) {
            CommonBindingAdapter.b0(this.b, coverUrl, requestOptions3, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8208a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8208a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelLayoutMyChannelHeaderBinding
    public void m(@Nullable MyChannelDetail myChannelDetail) {
        ((ChannelLayoutMyChannelHeaderBinding) this).f8203a = myChannelDetail;
        synchronized (this) {
            this.f8208a |= 2;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelLayoutMyChannelHeaderBinding
    public void n(@Nullable RequestOptions requestOptions) {
        ((ChannelLayoutMyChannelHeaderBinding) this).f8202a = requestOptions;
        synchronized (this) {
            this.f8208a |= 1;
        }
        notifyPropertyChanged(tk0.h);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelLayoutMyChannelHeaderBinding
    public void o(@Nullable MyChannelFragment.ClickProxy clickProxy) {
        ((ChannelLayoutMyChannelHeaderBinding) this).f8204a = clickProxy;
        synchronized (this) {
            this.f8208a |= 4;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.h == i) {
            n((RequestOptions) obj);
        } else if (tk0.g == i) {
            m((MyChannelDetail) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            o((MyChannelFragment.ClickProxy) obj);
        }
        return true;
    }

    public ChannelLayoutMyChannelHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageButton) objArr[3], (CardView) objArr[16], (BLImageView) objArr[6], (BLImageView) objArr[11], (BLImageView) objArr[12], (BLImageView) objArr[13], (TextView) objArr[9], (TextView) objArr[14], (View) objArr[10]);
        this.f8208a = -1L;
        ((ChannelLayoutMyChannelHeaderBinding) this).f8199a.setTag(null);
        ((ChannelLayoutMyChannelHeaderBinding) this).f8205a.setTag(null);
        ((ChannelLayoutMyChannelHeaderBinding) this).f8206b.setTag(null);
        super.c.setTag(null);
        super.d.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f8210a = relativeLayout;
        relativeLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[1];
        this.f8215a = bLTextView;
        bLTextView.setTag(null);
        ImageView imageView = (ImageView) objArr[15];
        this.f8209a = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[2];
        this.b = imageView2;
        imageView2.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[4];
        this.f8217b = bLTextView2;
        bLTextView2.setTag(null);
        RelativeLayout relativeLayout2 = (RelativeLayout) objArr[5];
        this.f8216b = relativeLayout2;
        relativeLayout2.setTag(null);
        TextView textView = (TextView) objArr[7];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[8];
        this.d = textView2;
        textView2.setTag(null);
        ((ChannelLayoutMyChannelHeaderBinding) this).f8200a.setTag(null);
        ((ChannelLayoutMyChannelHeaderBinding) this).b.setTag(null);
        ((ChannelLayoutMyChannelHeaderBinding) this).f33321a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
