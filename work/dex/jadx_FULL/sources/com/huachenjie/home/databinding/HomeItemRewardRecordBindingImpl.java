package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.base.bean.reward.RewardInfoDetailBean;
import com.huachenjie.base.bean.reward.RewardInfoImageInfoBean;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemRewardRecordBindingImpl extends HomeItemRewardRecordBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9526a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f9528a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34288a = sparseIntArray;
        sparseIntArray.put(R.id.ll_info, 8);
    }

    public HomeItemRewardRecordBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f9526a, f34288a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        float f;
        String str;
        int colorFromResource;
        int colorFromResource2;
        String str2;
        String url;
        boolean z;
        RequestOptions requestOptions;
        boolean z2;
        String str3;
        String str4;
        String str5;
        boolean z3;
        String str6;
        int i;
        boolean zShowValidTime;
        boolean zShowMenu;
        int position;
        String str7;
        String str8;
        RewardInfoDetailBean awardInfo;
        RewardInfoImageInfoBean imageInfo;
        String awardName;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f9527a;
            this.f9527a = 0L;
        }
        RewardInfoBean rewardInfoBean = ((HomeItemRewardRecordBinding) this).f9523a;
        long j4 = j & 3;
        if (j4 != 0) {
            requestOptions = ju3.m;
            if (rewardInfoBean != null) {
                str3 = rewardInfoBean.formatterWinTime();
                str4 = rewardInfoBean.formatterStatus();
                zShowValidTime = rewardInfoBean.showValidTime();
                str8 = rewardInfoBean.formatterMenuName(true, false);
                zShowMenu = rewardInfoBean.showMenu();
                awardInfo = rewardInfoBean.getAwardInfo();
                position = rewardInfoBean.getPosition();
                int receivedStatus = rewardInfoBean.getReceivedStatus();
                str7 = rewardInfoBean.formatterValidTime();
                i = receivedStatus;
            } else {
                i = 0;
                zShowValidTime = false;
                zShowMenu = false;
                position = 0;
                str7 = null;
                str3 = null;
                str4 = null;
                str8 = null;
                awardInfo = null;
            }
            if (awardInfo != null) {
                awardName = awardInfo.getAwardName();
                imageInfo = awardInfo.getImageInfo();
            } else {
                imageInfo = null;
                awardName = null;
            }
            boolean z4 = position > 0;
            boolean z5 = i == 1;
            boolean z6 = i == -1;
            if (j4 != 0) {
                j |= z5 ? 512L : 256L;
            }
            if ((j & 3) != 0) {
                if (z6) {
                    j2 = j | 8 | 32;
                    j3 = 128;
                } else {
                    j2 = j | 4 | 16;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            url = imageInfo != null ? imageInfo.getUrl() : null;
            str2 = z5 ? "#00B6DE" : "#CCCCCC";
            colorFromResource = z6 ? ViewDataBinding.getColorFromResource(this.d, R.color.color_CCCCCC) : ViewDataBinding.getColorFromResource(this.d, R.color.color_757979);
            colorFromResource2 = ViewDataBinding.getColorFromResource(this.b, z6 ? R.color.color_CCCCCC : R.color.color_191F20);
            float f2 = z6 ? 0.5f : 1.0f;
            z2 = zShowMenu;
            z3 = zShowValidTime;
            f = f2;
            z = z4;
            str6 = str8;
            str5 = str7;
            str = awardName;
        } else {
            f = 0.0f;
            str = null;
            colorFromResource = 0;
            colorFromResource2 = 0;
            str2 = null;
            url = null;
            z = false;
            requestOptions = null;
            z2 = false;
            str3 = null;
            str4 = null;
            str5 = null;
            z3 = false;
            str6 = null;
        }
        if ((j & 3) != 0) {
            CommonBindingAdapter.c0(((HomeItemRewardRecordBinding) this).f9524a, f);
            CommonBindingAdapter.b0(((HomeItemRewardRecordBinding) this).f9524a, url, requestOptions, false);
            CommonBindingAdapter.l0(((HomeItemRewardRecordBinding) this).f34287a, z);
            TextViewBindingAdapter.setText(this.b, str);
            this.b.setTextColor(colorFromResource2);
            TextViewBindingAdapter.setText(this.c, str4);
            CommonBindingAdapter.W(this.c, str2);
            TextViewBindingAdapter.setText(this.d, str3);
            this.d.setTextColor(colorFromResource);
            CommonBindingAdapter.l0(((HomeItemRewardRecordBinding) this).f9525a, z2);
            TextViewBindingAdapter.setText(((HomeItemRewardRecordBinding) this).f9525a, str6);
            CommonBindingAdapter.l0(((HomeItemRewardRecordBinding) this).f9522a, z3);
            TextViewBindingAdapter.setText(((HomeItemRewardRecordBinding) this).f9522a, str5);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9527a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9527a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemRewardRecordBinding
    public void k(@Nullable RewardInfoBean rewardInfoBean) {
        ((HomeItemRewardRecordBinding) this).f9523a = rewardInfoBean;
        synchronized (this) {
            this.f9527a |= 1;
        }
        notifyPropertyChanged(xk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.g != i) {
            return false;
        }
        k((RewardInfoBean) obj);
        return true;
    }

    public HomeItemRewardRecordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundImageView) objArr[2], (View) objArr[1], (LinearLayout) objArr[8], (BLTextView) objArr[7], (TextView) objArr[5]);
        this.f9527a = -1L;
        ((HomeItemRewardRecordBinding) this).f9524a.setTag(null);
        ((HomeItemRewardRecordBinding) this).f34287a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f9528a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.c = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[6];
        this.d = textView3;
        textView3.setTag(null);
        ((HomeItemRewardRecordBinding) this).f9525a.setTag(null);
        ((HomeItemRewardRecordBinding) this).f9522a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
