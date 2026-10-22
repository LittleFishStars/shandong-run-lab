package com.huachenjie.channel.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
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
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.AdvertiseBean;
import com.huachenjie.channel.bean.ChannelMainBean;
import com.huachenjie.channel.page.channel_main.ChannelMainActivity;
import com.huachenjie.channel.page.channel_main.ChannelMainVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.noober.background.view.BLImageView;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelLayoutChannelMainHeaderBindingImpl extends ChannelLayoutChannelMainHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8194a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f8198a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final TextView e;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChannelMainActivity.a f33319a;

        public a a(ChannelMainActivity.a aVar) {
            this.f33319a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33319a.d(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChannelMainActivity.a f33320a;

        public b a(ChannelMainActivity.a aVar) {
            this.f33320a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33320a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33318a = sparseIntArray;
        sparseIntArray.put(R.id.v_line_horizontal, 15);
        sparseIntArray.put(R.id.v_line_vertical, 16);
    }

    public ChannelLayoutChannelMainHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, f8194a, f33318a));
    }

    /* JADX WARN: Code duplicated, block: B:126:0x0301  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        List<AdvertiseBean> value;
        String avatar3;
        boolean z;
        boolean z2;
        String str;
        String str2;
        String avatar2;
        Drawable drawable;
        Drawable drawable2;
        ChannelMainBean value2;
        String str3;
        boolean z3;
        boolean z4;
        String str4;
        String str5;
        String str6;
        Drawable drawable3;
        boolean z5;
        boolean hostFlag;
        String str7;
        boolean z6;
        int i;
        String str8;
        String str9;
        RequestOptions requestOptions;
        RequestOptions requestOptions2;
        a aVarA;
        b bVar;
        Object drawable4;
        boolean z7;
        String str10;
        String str11;
        Drawable drawable5;
        boolean z8;
        boolean z9;
        boolean zIsEmpty;
        boolean z10;
        String avatar1;
        String channelDescription;
        String logo;
        String str12;
        long j2;
        boolean z11;
        int iSafeUnbox;
        boolean zIsRunOrUniverseChannel;
        boolean joinFlag;
        String channelName;
        String str13;
        String channelUserValue;
        String popularityValue;
        String channelNumber;
        long j3;
        long j4;
        String coverUrl;
        synchronized (this) {
            j = this.f8195a;
            this.f8195a = 0L;
        }
        ChannelMainVM channelMainVM = ((ChannelLayoutChannelMainHeaderBinding) this).f8186a;
        ChannelMainActivity.a aVar = ((ChannelLayoutChannelMainHeaderBinding) this).f8185a;
        if ((47 & j) != 0) {
            long j5 = j & 41;
            if (j5 != 0) {
                MutableLiveData<ChannelMainBean> mutableLiveDataL = channelMainVM != null ? channelMainVM.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                value2 = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                if (value2 != null) {
                    avatar2 = value2.getAvatar2();
                    zIsRunOrUniverseChannel = value2.isRunOrUniverseChannel();
                    avatar1 = value2.getAvatar1();
                    channelDescription = value2.getChannelDescription();
                    joinFlag = value2.getJoinFlag();
                    logo = value2.getLogo();
                    avatar3 = value2.getAvatar3();
                    channelName = value2.getChannelName();
                    hostFlag = value2.getHostFlag();
                    coverUrl = value2.getCoverUrl();
                    channelUserValue = value2.getChannelUserValue();
                    popularityValue = value2.getPopularityValue();
                    channelNumber = value2.getChannelNumber();
                } else {
                    zIsRunOrUniverseChannel = false;
                    joinFlag = false;
                    hostFlag = false;
                    avatar2 = null;
                    avatar1 = null;
                    channelDescription = null;
                    logo = null;
                    avatar3 = null;
                    channelName = null;
                    str13 = null;
                    channelUserValue = null;
                    popularityValue = null;
                    channelNumber = null;
                }
                if (j5 != 0) {
                    if (joinFlag) {
                        j3 = j | 2048 | 8192;
                        j4 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    } else {
                        j3 = j | 1024 | 4096;
                        j4 = 262144;
                    }
                    j = j3 | j4;
                }
                str13 = coverUrl;
                if ((j & 41) != 0) {
                    j = hostFlag ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | 131072 : j | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                }
                boolean z12 = avatar2 != null;
                z10 = !zIsRunOrUniverseChannel;
                z11 = avatar1 != null;
                String string = joinFlag ? ((ChannelLayoutChannelMainHeaderBinding) this).f8188a.getResources().getString(R.string.channel_main_has_add) : ((ChannelLayoutChannelMainHeaderBinding) this).f8188a.getResources().getString(R.string.channel_main_un_add);
                Drawable drawable6 = AppCompatResources.getDrawable(((ChannelLayoutChannelMainHeaderBinding) this).f8188a.getContext(), joinFlag ? R.drawable.channel_bg_join_channel : R.drawable.channel_bg_un_join_channel);
                drawable2 = AppCompatResources.getDrawable(((ChannelLayoutChannelMainHeaderBinding) this).f8188a.getContext(), joinFlag ? R.drawable.channel_ic_channel_main_has_add : R.drawable.channel_ic_channel_main_un_add);
                z9 = avatar3 != null;
                String str14 = String.format("@%s", channelName);
                Drawable drawable7 = AppCompatResources.getDrawable(this.e.getContext(), hostFlag ? R.drawable.channel_bg_channel_main_official : R.drawable.channel_bg_channel_main_orz_official);
                zIsEmpty = TextUtils.isEmpty(str13);
                str8 = str14;
                str9 = String.format(((ChannelLayoutChannelMainHeaderBinding) this).d.getResources().getString(R.string.channel_main_user_num), channelUserValue);
                String str15 = String.format(((ChannelLayoutChannelMainHeaderBinding) this).f8190b.getResources().getString(R.string.channel_my_channel_hot), popularityValue);
                String str16 = String.format(((ChannelLayoutChannelMainHeaderBinding) this).f8183a.getResources().getString(R.string.channel_main_code), channelNumber);
                if ((j & 41) != 0) {
                    j |= zIsEmpty ? 128L : 64L;
                }
                drawable = drawable6;
                str2 = string;
                z8 = z12;
                drawable5 = drawable7;
                str11 = str16;
                str10 = str15;
                j2 = 44;
                str12 = str13;
            } else {
                str10 = null;
                str11 = null;
                drawable5 = null;
                z8 = false;
                str2 = null;
                drawable = null;
                drawable2 = null;
                value2 = null;
                z9 = false;
                zIsEmpty = false;
                avatar2 = null;
                z10 = false;
                avatar1 = null;
                channelDescription = null;
                logo = null;
                avatar3 = null;
                str8 = null;
                hostFlag = false;
                str12 = null;
                str9 = null;
                j2 = 44;
                z11 = false;
            }
            if ((j & j2) != 0) {
                BaseViewModel.b bVarE = channelMainVM != null ? channelMainVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 80));
            } else {
                str10 = str10;
                iSafeUnbox = 0;
            }
            long j6 = j & 42;
            if (j6 != 0) {
                MutableLiveData<List<AdvertiseBean>> mutableLiveDataJ = channelMainVM != null ? channelMainVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                value = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                z6 = value != null;
                if (j6 != 0) {
                    j = z6 ? j | 512 : j | 256;
                }
                i = iSafeUnbox;
            } else {
                i = iSafeUnbox;
                value = null;
                z6 = false;
            }
            z4 = zIsEmpty;
            z5 = z10;
            str4 = str10;
            z3 = z9;
            str3 = avatar1;
            str5 = channelDescription;
            str6 = str11;
            z = z8;
            str = logo;
            drawable3 = drawable5;
            z2 = z11;
            str7 = str12;
        } else {
            value = null;
            avatar3 = null;
            z = false;
            z2 = false;
            str = null;
            str2 = null;
            avatar2 = null;
            drawable = null;
            drawable2 = null;
            value2 = null;
            str3 = null;
            z3 = false;
            z4 = false;
            str4 = null;
            str5 = null;
            str6 = null;
            drawable3 = null;
            z5 = false;
            hostFlag = false;
            str7 = null;
            z6 = false;
            i = 0;
            str8 = null;
            str9 = null;
        }
        long j7 = j & 41;
        if (j7 != 0) {
            requestOptions = ju3.b;
            requestOptions2 = ju3.h;
        } else {
            requestOptions = null;
            requestOptions2 = null;
        }
        long j8 = j & 48;
        if (j8 == 0 || aVar == null) {
            aVarA = null;
            bVar = null;
        } else {
            b bVar2 = this.f8198a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f8198a = bVar2;
            }
            b bVarA = bVar2.a(aVar);
            a aVar2 = this.f8197a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f8197a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            bVar = bVarA;
        }
        if (j7 != 0) {
            drawable4 = z4 ? AppCompatResources.getDrawable(((ChannelLayoutChannelMainHeaderBinding) this).f8182a.getContext(), R.drawable.base_bg_channel_main_head) : str7;
        } else {
            aVarA = aVarA;
            bVar = bVar;
            drawable4 = null;
        }
        if ((j & 512) == 0) {
            z7 = false;
        } else {
            if ((value != null ? value.size() : 0) > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        boolean certificationFlag = ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0 || value2 == null) ? false : value2.getCertificationFlag();
        long j9 = j & 42;
        if (j9 == 0 || !z6) {
            z7 = false;
        }
        if (j7 == 0) {
            certificationFlag = false;
        } else if (hostFlag) {
            certificationFlag = true;
        }
        if (j9 != 0) {
            CommonBindingAdapter.l0(((ChannelLayoutChannelMainHeaderBinding) this).f8187a, z7);
        }
        if (j7 != 0) {
            ViewBindingAdapter.setBackground(((ChannelLayoutChannelMainHeaderBinding) this).f8188a, drawable);
            TextViewBindingAdapter.setDrawableStart(((ChannelLayoutChannelMainHeaderBinding) this).f8188a, drawable2);
            TextViewBindingAdapter.setText(((ChannelLayoutChannelMainHeaderBinding) this).f8188a, str2);
            CommonBindingAdapter.b0(((ChannelLayoutChannelMainHeaderBinding) this).f8189a, str, requestOptions, false);
            CommonBindingAdapter.b0(((ChannelLayoutChannelMainHeaderBinding) this).f8182a, drawable4, requestOptions2, false);
            CommonBindingAdapter.l0(((ChannelLayoutChannelMainHeaderBinding) this).f8191b, z2);
            CommonBindingAdapter.b0(((ChannelLayoutChannelMainHeaderBinding) this).f8191b, str3, requestOptions, false);
            CommonBindingAdapter.l0(((ChannelLayoutChannelMainHeaderBinding) this).f8192c, z);
            CommonBindingAdapter.b0(((ChannelLayoutChannelMainHeaderBinding) this).f8192c, avatar2, requestOptions, false);
            CommonBindingAdapter.l0(((ChannelLayoutChannelMainHeaderBinding) this).f8193d, z3);
            CommonBindingAdapter.b0(((ChannelLayoutChannelMainHeaderBinding) this).f8193d, avatar3, requestOptions, false);
            CommonBindingAdapter.l0(this.b, z5);
            ViewBindingAdapter.setBackground(this.e, drawable3);
            CommonBindingAdapter.l0(this.e, certificationFlag);
            TextViewBindingAdapter.setText(((ChannelLayoutChannelMainHeaderBinding) this).f8183a, str6);
            aw9.f(((ChannelLayoutChannelMainHeaderBinding) this).f8184a, str5);
            TextViewBindingAdapter.setText(((ChannelLayoutChannelMainHeaderBinding) this).f8190b, str4);
            TextViewBindingAdapter.setText(((ChannelLayoutChannelMainHeaderBinding) this).c, str8);
            TextViewBindingAdapter.setText(((ChannelLayoutChannelMainHeaderBinding) this).d, str9);
        }
        if (j8 != 0) {
            CommonBindingAdapter.q(((ChannelLayoutChannelMainHeaderBinding) this).f8188a, aVarA, null);
            b bVar3 = bVar;
            CommonBindingAdapter.q(this.b, bVar3, null);
            CommonBindingAdapter.q(((ChannelLayoutChannelMainHeaderBinding) this).d, bVar3, null);
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.I(((ChannelLayoutChannelMainHeaderBinding) this).f8189a, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8195a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8195a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelLayoutChannelMainHeaderBinding
    public void l(@Nullable ChannelMainActivity.a aVar) {
        ((ChannelLayoutChannelMainHeaderBinding) this).f8185a = aVar;
        synchronized (this) {
            this.f8195a |= 16;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelLayoutChannelMainHeaderBinding
    public void m(@Nullable ChannelMainVM channelMainVM) {
        ((ChannelLayoutChannelMainHeaderBinding) this).f8186a = channelMainVM;
        synchronized (this) {
            this.f8195a |= 8;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<List<AdvertiseBean>> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f8195a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<ChannelMainBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f8195a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f8195a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((ChannelMainVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((ChannelMainActivity.a) obj);
        }
        return true;
    }

    public ChannelLayoutChannelMainHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (CommonBanner) objArr[14], (DrawableCenterButton) objArr[13], (BLImageView) objArr[2], (ImageView) objArr[1], (BLImageView) objArr[8], (BLImageView) objArr[9], (BLImageView) objArr[10], (TextView) objArr[5], (ExpandableTextView) objArr[6], (TextView) objArr[7], (TextView) objArr[4], (TextView) objArr[11], (View) objArr[15], (View) objArr[16]);
        this.f8195a = -1L;
        ((ChannelLayoutChannelMainHeaderBinding) this).f8187a.setTag(null);
        ((ChannelLayoutChannelMainHeaderBinding) this).f8188a.setTag(null);
        ((ChannelLayoutChannelMainHeaderBinding) this).f8189a.setTag(null);
        ((ChannelLayoutChannelMainHeaderBinding) this).f8182a.setTag(null);
        ((ChannelLayoutChannelMainHeaderBinding) this).f8191b.setTag(null);
        ((ChannelLayoutChannelMainHeaderBinding) this).f8192c.setTag(null);
        ((ChannelLayoutChannelMainHeaderBinding) this).f8193d.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8196a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[12];
        this.b = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.e = textView;
        textView.setTag(null);
        ((ChannelLayoutChannelMainHeaderBinding) this).f8183a.setTag(null);
        ((ChannelLayoutChannelMainHeaderBinding) this).f8184a.setTag(null);
        ((ChannelLayoutChannelMainHeaderBinding) this).f8190b.setTag(null);
        ((ChannelLayoutChannelMainHeaderBinding) this).c.setTag(null);
        ((ChannelLayoutChannelMainHeaderBinding) this).d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
