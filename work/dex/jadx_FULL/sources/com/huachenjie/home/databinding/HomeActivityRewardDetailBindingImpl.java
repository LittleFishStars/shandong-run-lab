package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.base.bean.reward.RewardInfoDetailBean;
import com.huachenjie.base.bean.reward.RewardInfoImageInfoBean;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.home.R;
import com.huachenjie.home.page.reward_detail.RewardDetailActivity;
import com.huachenjie.home.page.reward_detail.RewardDetailVM;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeActivityRewardDetailBindingImpl extends HomeActivityRewardDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9313a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9314a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f9317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f9320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9321a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f9322b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9323b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f9324b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f9325b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f9326c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f9327c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f9328d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f9329d;

    @NonNull
    public final ImageView e;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RewardDetailActivity.a f34215a;

        public a a(RewardDetailActivity.a aVar) {
            this.f34215a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34215a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RewardDetailActivity.a f34216a;

        public b a(RewardDetailActivity.a aVar) {
            this.f34216a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34216a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34214a = sparseIntArray;
        sparseIntArray.put(R.id.ll_status, 19);
    }

    public HomeActivityRewardDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, f9313a, f34214a));
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:106:0x01e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:110:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:112:0x01ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:114:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:115:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:118:0x0200 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x0202  */
    /* JADX WARN: Code duplicated, block: B:120:0x0205  */
    /* JADX WARN: Code duplicated, block: B:122:0x020a  */
    /* JADX WARN: Code duplicated, block: B:125:0x0214 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0217  */
    /* JADX WARN: Code duplicated, block: B:129:0x021c  */
    /* JADX WARN: Code duplicated, block: B:131:0x021f  */
    /* JADX WARN: Code duplicated, block: B:134:0x0294  */
    /* JADX WARN: Code duplicated, block: B:137:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0197  */
    /* JADX WARN: Code duplicated, block: B:81:0x019c  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d3  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        int awardType;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        boolean z4;
        boolean z5;
        boolean z6;
        String url;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        long j2;
        RequestOptions requestOptions;
        a aVarA;
        b bVarA;
        boolean z7;
        boolean z8;
        long j3;
        boolean z9;
        long j4;
        boolean z10;
        int iSafeUnbox;
        int iSafeUnbox2;
        int i4;
        int i5;
        boolean zShowValidTime;
        boolean zShowMenu;
        String str7;
        String str8;
        String str9;
        String str10;
        RewardInfoDetailBean awardInfo;
        String winningRecordNo;
        RewardInfoImageInfoBean imageInfo;
        String awardName;
        synchronized (this) {
            j = this.f9314a;
            this.f9314a = 0L;
        }
        RewardDetailVM rewardDetailVM = ((HomeActivityRewardDetailBinding) this).f9310a;
        RewardDetailActivity.a aVar = ((HomeActivityRewardDetailBinding) this).f9309a;
        float f = 0.0f;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                BaseViewModel.b bVarE = rewardDetailVM != null ? rewardDetailVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(0, mutableLiveDataB);
                int iSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox3 + 4));
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox3 + 65));
            } else {
                iSafeUnbox = 0;
                iSafeUnbox2 = 0;
            }
            long j5 = j & 22;
            if (j5 != 0) {
                MutableLiveData<RewardInfoBean> mutableLiveDataI = rewardDetailVM != null ? rewardDetailVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                RewardInfoBean value = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                if (value != null) {
                    str8 = value.formatterStatus();
                    str9 = value.formatterValidTime();
                    i5 = value.formatterStatusIcon();
                    str10 = value.formatterWinTime();
                    zShowValidTime = value.showValidTime();
                    zShowMenu = value.showMenu();
                    int receivedStatus = value.getReceivedStatus();
                    awardInfo = value.getAwardInfo();
                    winningRecordNo = value.getWinningRecordNo();
                    str7 = value.formatterMenuName(false, false);
                    i4 = receivedStatus;
                } else {
                    i4 = 0;
                    i5 = 0;
                    zShowValidTime = false;
                    zShowMenu = false;
                    str7 = null;
                    str8 = null;
                    str9 = null;
                    str10 = null;
                    awardInfo = null;
                    winningRecordNo = null;
                }
                boolean z11 = i4 == -1;
                if (j5 != 0) {
                    j |= z11 ? 1024L : 512L;
                }
                if (awardInfo != null) {
                    awardType = awardInfo.getAwardType();
                    imageInfo = awardInfo.getImageInfo();
                    awardName = awardInfo.getAwardName();
                } else {
                    awardType = 0;
                    imageInfo = null;
                    awardName = null;
                }
                float f2 = z11 ? 0.5f : 1.0f;
                boolean z12 = awardType == 1;
                z2 = awardType != 1;
                z = awardType == 6;
                z3 = awardType == 3;
                if ((j & 22) != 0) {
                    j = z2 ? j | 64 : j | 32;
                }
                if ((j & 22) != 0) {
                    j = z3 ? j | 4096 : j | 2048;
                }
                if (imageInfo != null) {
                    str4 = str7;
                    f = f2;
                    str6 = str8;
                    url = imageInfo.getUrl();
                    i3 = i5;
                    str3 = str10;
                    z4 = zShowValidTime;
                    z5 = zShowMenu;
                    str5 = awardName;
                    z6 = z12;
                    str2 = winningRecordNo;
                    i = iSafeUnbox;
                    i2 = iSafeUnbox2;
                    str = str9;
                } else {
                    str4 = str7;
                    i = iSafeUnbox;
                    f = f2;
                    str6 = str8;
                    str = str9;
                    i3 = i5;
                    str3 = str10;
                    z4 = zShowValidTime;
                    z5 = zShowMenu;
                    str5 = awardName;
                    z6 = z12;
                    str2 = winningRecordNo;
                    url = null;
                    i2 = iSafeUnbox2;
                }
            } else {
                i = iSafeUnbox;
                z = false;
                awardType = 0;
                z2 = false;
                z3 = false;
                i3 = 0;
                z4 = false;
                z5 = false;
                z6 = false;
                i2 = iSafeUnbox2;
            }
            j2 = j & 22;
            if (j2 != 0) {
                requestOptions = ju3.n;
            } else {
                requestOptions = null;
            }
            if ((j & 24) != 0 || aVar == null) {
                aVarA = null;
                bVarA = null;
            } else {
                b bVar = this.f9319a;
                if (bVar == null) {
                    bVar = new b();
                    this.f9319a = bVar;
                }
                bVarA = bVar.a(aVar);
                a aVar2 = this.f9318a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f9318a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if ((64 & j) != 0 || awardType == 3) {
                z7 = false;
            } else {
                z7 = true;
            }
            if ((2048 & j) == 0 && awardType == 4) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (j2 != 0) {
                if (!z2) {
                    z7 = false;
                }
                if (z3) {
                    z8 = true;
                }
                if (j2 != 0) {
                    if (z7) {
                        j |= 256;
                    } else {
                        j |= 128;
                    }
                }
            } else {
                z7 = false;
                z8 = false;
            }
            if ((j & 256) != 0) {
                if (awardType != 4) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                j3 = 22;
            } else {
                j3 = 22;
                z9 = false;
            }
            j4 = j & j3;
            if (j4 != 0) {
                if (!z7) {
                    z9 = false;
                }
                z10 = z9;
            } else {
                z10 = false;
            }
            if (j4 != 0) {
                CommonBindingAdapter.c0(((HomeActivityRewardDetailBinding) this).f9311a, f);
                CommonBindingAdapter.S(this.f9316a, i3);
                TextViewBindingAdapter.setText(this.f9323b, str5);
                CommonBindingAdapter.l0(this.f9321a, z4);
                TextViewBindingAdapter.setText(this.f9321a, str);
                TextViewBindingAdapter.setText(this.f9326c, str3);
                TextViewBindingAdapter.setText(this.f9328d, str2);
                CommonBindingAdapter.l0(this.b, z5);
                TextViewBindingAdapter.setText(this.f9320a, str4);
                CommonBindingAdapter.l0(this.f9317a, z6);
                CommonBindingAdapter.b0(this.f9317a, url, requestOptions, false);
                CommonBindingAdapter.l0(this.f9324b, z10);
                CommonBindingAdapter.b0(this.c, url, null, false);
                CommonBindingAdapter.l0(this.f9327c, z8);
                CommonBindingAdapter.b0(this.d, url, null, false);
                CommonBindingAdapter.l0(this.f9329d, z);
                CommonBindingAdapter.b0(this.e, url, null, false);
                TextViewBindingAdapter.setText(((HomeActivityRewardDetailBinding) this).f34213a, str6);
            }
            if ((21 & j) != 0) {
                CommonBindingAdapter.I(this.f9325b, 0, i, 0, 0, null);
                CommonBindingAdapter.I(this.f9322b, 16, i2, 0, 0, null);
            }
            if ((j & 24) != 0) {
                CommonBindingAdapter.q(this.f9320a, bVarA, null);
                CommonBindingAdapter.q(this.f9322b, aVarA, null);
            }
        }
        z = false;
        awardType = 0;
        i = 0;
        i2 = 0;
        z2 = false;
        z3 = false;
        i3 = 0;
        z4 = false;
        z5 = false;
        z6 = false;
        url = null;
        str = null;
        str2 = null;
        str3 = null;
        str4 = null;
        str5 = null;
        str6 = null;
        j2 = j & 22;
        if (j2 != 0) {
            requestOptions = ju3.n;
        } else {
            requestOptions = null;
        }
        if ((j & 24) != 0) {
            aVarA = null;
            bVarA = null;
        } else {
            aVarA = null;
            bVarA = null;
        }
        if ((64 & j) != 0) {
            z7 = false;
        } else {
            z7 = false;
        }
        if ((2048 & j) == 0) {
            z8 = false;
        } else {
            z8 = false;
        }
        if (j2 != 0) {
            if (!z2) {
                z7 = false;
            }
            if (z3) {
                z8 = true;
            }
            if (j2 != 0) {
                if (z7) {
                    j |= 256;
                } else {
                    j |= 128;
                }
            }
        } else {
            z7 = false;
            z8 = false;
        }
        if ((j & 256) != 0) {
            if (awardType != 4) {
                z9 = true;
            } else {
                z9 = false;
            }
            j3 = 22;
        } else {
            j3 = 22;
            z9 = false;
        }
        j4 = j & j3;
        if (j4 != 0) {
            if (!z7) {
                z9 = false;
            }
            z10 = z9;
        } else {
            z10 = false;
        }
        if (j4 != 0) {
            CommonBindingAdapter.c0(((HomeActivityRewardDetailBinding) this).f9311a, f);
            CommonBindingAdapter.S(this.f9316a, i3);
            TextViewBindingAdapter.setText(this.f9323b, str5);
            CommonBindingAdapter.l0(this.f9321a, z4);
            TextViewBindingAdapter.setText(this.f9321a, str);
            TextViewBindingAdapter.setText(this.f9326c, str3);
            TextViewBindingAdapter.setText(this.f9328d, str2);
            CommonBindingAdapter.l0(this.b, z5);
            TextViewBindingAdapter.setText(this.f9320a, str4);
            CommonBindingAdapter.l0(this.f9317a, z6);
            CommonBindingAdapter.b0(this.f9317a, url, requestOptions, false);
            CommonBindingAdapter.l0(this.f9324b, z10);
            CommonBindingAdapter.b0(this.c, url, null, false);
            CommonBindingAdapter.l0(this.f9327c, z8);
            CommonBindingAdapter.b0(this.d, url, null, false);
            CommonBindingAdapter.l0(this.f9329d, z);
            CommonBindingAdapter.b0(this.e, url, null, false);
            TextViewBindingAdapter.setText(((HomeActivityRewardDetailBinding) this).f34213a, str6);
        }
        if ((21 & j) != 0) {
            CommonBindingAdapter.I(this.f9325b, 0, i, 0, 0, null);
            CommonBindingAdapter.I(this.f9322b, 16, i2, 0, 0, null);
        }
        if ((j & 24) != 0) {
            CommonBindingAdapter.q(this.f9320a, bVarA, null);
            CommonBindingAdapter.q(this.f9322b, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9314a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9314a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityRewardDetailBinding
    public void l(@Nullable RewardDetailActivity.a aVar) {
        ((HomeActivityRewardDetailBinding) this).f9309a = aVar;
        synchronized (this) {
            this.f9314a |= 8;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityRewardDetailBinding
    public void m(@Nullable RewardDetailVM rewardDetailVM) {
        ((HomeActivityRewardDetailBinding) this).f9310a = rewardDetailVM;
        synchronized (this) {
            this.f9314a |= 4;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<RewardInfoBean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9314a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9314a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 == i) {
            m((RewardDetailVM) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            l((RewardDetailActivity.a) obj);
        }
        return true;
    }

    public HomeActivityRewardDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (BLFrameLayout) objArr[2], (BLLinearLayout) objArr[19], (TextView) objArr[11]);
        this.f9314a = -1L;
        ((HomeActivityRewardDetailBinding) this).f9311a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9315a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f9325b = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[10];
        this.f9316a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[12];
        this.f9323b = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[13];
        this.f9321a = bLTextView;
        bLTextView.setTag(null);
        TextView textView2 = (TextView) objArr[14];
        this.f9326c = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[15];
        this.f9328d = textView3;
        textView3.setTag(null);
        FrameLayout frameLayout2 = (FrameLayout) objArr[16];
        this.b = frameLayout2;
        frameLayout2.setTag(null);
        BLButton bLButton = (BLButton) objArr[17];
        this.f9320a = bLButton;
        bLButton.setTag(null);
        ImageView imageView2 = (ImageView) objArr[18];
        this.f9322b = imageView2;
        imageView2.setTag(null);
        RoundImageView roundImageView = (RoundImageView) objArr[3];
        this.f9317a = roundImageView;
        roundImageView.setTag(null);
        BLFrameLayout bLFrameLayout = (BLFrameLayout) objArr[4];
        this.f9324b = bLFrameLayout;
        bLFrameLayout.setTag(null);
        ImageView imageView3 = (ImageView) objArr[5];
        this.c = imageView3;
        imageView3.setTag(null);
        BLFrameLayout bLFrameLayout2 = (BLFrameLayout) objArr[6];
        this.f9327c = bLFrameLayout2;
        bLFrameLayout2.setTag(null);
        ImageView imageView4 = (ImageView) objArr[7];
        this.d = imageView4;
        imageView4.setTag(null);
        BLFrameLayout bLFrameLayout3 = (BLFrameLayout) objArr[8];
        this.f9329d = bLFrameLayout3;
        bLFrameLayout3.setTag(null);
        ImageView imageView5 = (ImageView) objArr[9];
        this.e = imageView5;
        imageView5.setTag(null);
        ((HomeActivityRewardDetailBinding) this).f34213a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
