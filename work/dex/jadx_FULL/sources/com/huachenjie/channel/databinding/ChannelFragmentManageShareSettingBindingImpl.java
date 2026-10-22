package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelBasicInfo;
import com.huachenjie.channel.page.manage_channel.share.ShareSettingFragment;
import com.huachenjie.channel.page.manage_channel.share.ShareSettingVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentManageShareSettingBindingImpl extends ChannelFragmentManageShareSettingBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7824a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f7830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f7831a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7832a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareSettingFragment.a f33186a;

        public a a(ShareSettingFragment.a aVar) {
            this.f33186a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33186a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareSettingFragment.a f33187a;

        public b a(ShareSettingFragment.a aVar) {
            this.f33187a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33187a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33185a = sparseIntArray;
        sparseIntArray.put(R.id.card_view, 9);
        sparseIntArray.put(R.id.v_line, 10);
        sparseIntArray.put(R.id.iv_qrcode, 11);
    }

    public ChannelFragmentManageShareSettingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f7824a, f33185a));
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0112  */
    /* JADX WARN: Code duplicated, block: B:72:0x011c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x011e  */
    /* JADX WARN: Code duplicated, block: B:75:0x012d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0130  */
    /* JADX WARN: Code duplicated, block: B:79:0x0151  */
    /* JADX WARN: Code duplicated, block: B:82:0x0165  */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        RequestOptions requestOptions2;
        int i;
        boolean zIsEmpty;
        int i2;
        String channelDescription;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        long j2;
        a aVarA;
        b bVarA;
        long j3;
        Object obj;
        Object drawable;
        int i3;
        int iSafeUnbox;
        String str6;
        String channelNumber;
        String logo;
        String channelName;
        synchronized (this) {
            j = this.f7825a;
            this.f7825a = 0L;
        }
        ShareSettingVM shareSettingVM = ((ChannelFragmentManageShareSettingBinding) this).f7822a;
        ShareSettingFragment.a aVar = ((ChannelFragmentManageShareSettingBinding) this).f7821a;
        if ((j & 21) != 0) {
            requestOptions = ju3.h;
            requestOptions2 = ju3.p;
        } else {
            requestOptions = null;
            requestOptions2 = null;
        }
        if ((23 & j) != 0) {
            long j4 = j & 22;
            if (j4 != 0) {
                BaseViewModel.b bVarE = shareSettingVM != null ? shareSettingVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(1, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
                boolean z = iSafeUnbox > 0;
                if (j4 != 0) {
                    j |= z ? 64L : 32L;
                }
                i3 = z ? 12 : 30;
            } else {
                i3 = 0;
                iSafeUnbox = 0;
            }
            long j5 = j & 21;
            if (j5 != 0) {
                MutableLiveData<ChannelBasicInfo> mutableLiveDataI = shareSettingVM != null ? shareSettingVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                ChannelBasicInfo value = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                if (value != null) {
                    String coverUrl = value.getCoverUrl();
                    channelNumber = value.getChannelNumber();
                    logo = value.getLogo();
                    channelName = value.getChannelName();
                    channelDescription = value.getChannelDescription();
                    str6 = coverUrl;
                } else {
                    channelDescription = null;
                    str6 = null;
                    channelNumber = null;
                    logo = null;
                    channelName = null;
                }
                zIsEmpty = TextUtils.isEmpty(str6);
                str = String.format(this.b.getResources().getString(R.string.channel_main_code), channelNumber);
                if (j5 != 0) {
                    j |= zIsEmpty ? 256L : 128L;
                }
                i2 = iSafeUnbox;
                str2 = channelNumber;
                str3 = logo;
                String str7 = channelName;
                i = i3;
                str4 = str7;
                str5 = str6;
            } else {
                i = i3;
                i2 = iSafeUnbox;
                zIsEmpty = false;
            }
            j2 = 24 & j;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
                bVarA = null;
            } else {
                b bVar = this.f7829a;
                if (bVar == null) {
                    bVar = new b();
                    this.f7829a = bVar;
                }
                bVarA = bVar.a(aVar);
                a aVar2 = this.f7828a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f7828a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            j3 = j & 21;
            drawable = str5;
            if (j3 != 0) {
                if (zIsEmpty) {
                    drawable = AppCompatResources.getDrawable(this.f7826a.getContext(), R.drawable.channel_ic_share_default_bg);
                }
                obj = drawable;
            } else {
                obj = null;
            }
            if (j3 != 0) {
                CommonBindingAdapter.b0(((ChannelFragmentManageShareSettingBinding) this).f7823a, str3, requestOptions2, false);
                TextViewBindingAdapter.setText(this.f7832a, str2);
                CommonBindingAdapter.b0(this.f7826a, obj, requestOptions, false);
                TextViewBindingAdapter.setText(this.b, str);
                TextViewBindingAdapter.setText(this.c, channelDescription);
                TextViewBindingAdapter.setText(((ChannelFragmentManageShareSettingBinding) this).f7819a, str4);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.f7832a, aVarA, null);
                CommonBindingAdapter.q(this.f7831a, bVarA, null);
            }
            if ((j & 22) != 0) {
                CommonBindingAdapter.O(this.f7830a, 0, 0, 0, i2, null);
                CommonBindingAdapter.I(this.f7831a, 0, 20, 0, i, null);
            }
        }
        i = 0;
        zIsEmpty = false;
        i2 = 0;
        channelDescription = null;
        str = null;
        str2 = null;
        str3 = null;
        str4 = null;
        str5 = null;
        j2 = 24 & j;
        if (j2 != 0) {
            aVarA = null;
            bVarA = null;
        } else {
            aVarA = null;
            bVarA = null;
        }
        j3 = j & 21;
        drawable = str5;
        if (j3 != 0) {
            if (zIsEmpty) {
                drawable = AppCompatResources.getDrawable(this.f7826a.getContext(), R.drawable.channel_ic_share_default_bg);
            }
            obj = drawable;
        } else {
            obj = null;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(((ChannelFragmentManageShareSettingBinding) this).f7823a, str3, requestOptions2, false);
            TextViewBindingAdapter.setText(this.f7832a, str2);
            CommonBindingAdapter.b0(this.f7826a, obj, requestOptions, false);
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(this.c, channelDescription);
            TextViewBindingAdapter.setText(((ChannelFragmentManageShareSettingBinding) this).f7819a, str4);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f7832a, aVarA, null);
            CommonBindingAdapter.q(this.f7831a, bVarA, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.O(this.f7830a, 0, 0, 0, i2, null);
            CommonBindingAdapter.I(this.f7831a, 0, 20, 0, i, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7825a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7825a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentManageShareSettingBinding
    public void l(@Nullable ShareSettingFragment.a aVar) {
        ((ChannelFragmentManageShareSettingBinding) this).f7821a = aVar;
        synchronized (this) {
            this.f7825a |= 8;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentManageShareSettingBinding
    public void m(@Nullable ShareSettingVM shareSettingVM) {
        ((ChannelFragmentManageShareSettingBinding) this).f7822a = shareSettingVM;
        synchronized (this) {
            this.f7825a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ChannelBasicInfo> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7825a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7825a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((ShareSettingVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((ShareSettingFragment.a) obj);
        }
        return true;
    }

    public ChannelFragmentManageShareSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (CardView) objArr[9], (BLImageView) objArr[3], (BLImageView) objArr[11], (TextView) objArr[4], (View) objArr[10]);
        this.f7825a = -1L;
        ((ChannelFragmentManageShareSettingBinding) this).f7823a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7827a = linearLayout;
        linearLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[1];
        this.f7832a = bLTextView;
        bLTextView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f7826a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.c = textView2;
        textView2.setTag(null);
        ShadowConstraintLayout shadowConstraintLayout = (ShadowConstraintLayout) objArr[7];
        this.f7830a = shadowConstraintLayout;
        shadowConstraintLayout.setTag(null);
        BLButton bLButton = (BLButton) objArr[8];
        this.f7831a = bLButton;
        bLButton.setTag(null);
        ((ChannelFragmentManageShareSettingBinding) this).f7819a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
