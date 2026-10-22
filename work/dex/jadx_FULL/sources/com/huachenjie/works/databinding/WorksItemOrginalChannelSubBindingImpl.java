package com.huachenjie.works.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.OriginalChannelHotspotBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemOrginalChannelSubBindingImpl extends WorksItemOrginalChannelSubBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14605a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14607a;

    @NonNull
    public final RoundImageView b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final RoundImageView f14608c;

    @NonNull
    public final TextView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final RoundImageView f14609d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37042a = sparseIntArray;
        sparseIntArray.put(R.id.ll_info, 12);
        sparseIntArray.put(R.id.tv_enter, 13);
        sparseIntArray.put(R.id.ll_pic, 14);
    }

    public WorksItemOrginalChannelSubBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 15, f14605a, f37042a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        String str2;
        boolean z2;
        RequestOptions requestOptions;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        String blurb;
        String strFirstWorksUrl;
        String avatar;
        String strSecondWorksUrl;
        String strThirdWorksUrl;
        String str12;
        String coverImgUrl;
        String title;
        String ownerName;
        int picWidthDp;
        int position;
        boolean zShowRankIcon;
        synchronized (this) {
            j = this.f14606a;
            this.f14606a = 0L;
        }
        OriginalChannelHotspotBean originalChannelHotspotBean = ((WorksItemOrginalChannelSubBinding) this).f14601a;
        long j2 = j & 3;
        if (j2 != 0) {
            requestOptions = ju3.t;
            if (originalChannelHotspotBean != null) {
                str3 = originalChannelHotspotBean.formatterRankColor();
                blurb = originalChannelHotspotBean.getBlurb();
                strFirstWorksUrl = originalChannelHotspotBean.firstWorksUrl();
                avatar = originalChannelHotspotBean.getAvatar();
                strSecondWorksUrl = originalChannelHotspotBean.secondWorksUrl();
                strThirdWorksUrl = originalChannelHotspotBean.thirdWorksUrl();
                str12 = originalChannelHotspotBean.formatterRank();
                coverImgUrl = originalChannelHotspotBean.getCoverImgUrl();
                title = originalChannelHotspotBean.getTitle();
                ownerName = originalChannelHotspotBean.getOwnerName();
                picWidthDp = originalChannelHotspotBean.getPicWidthDp();
                position = originalChannelHotspotBean.getPosition();
                zShowRankIcon = originalChannelHotspotBean.showRankIcon();
            } else {
                str3 = null;
                blurb = null;
                strFirstWorksUrl = null;
                avatar = null;
                strSecondWorksUrl = null;
                strThirdWorksUrl = null;
                str12 = null;
                coverImgUrl = null;
                title = null;
                ownerName = null;
                picWidthDp = 0;
                position = 0;
                zShowRankIcon = false;
            }
            if (j2 != 0) {
                j = zShowRankIcon ? j | 8 : j | 4;
            }
            boolean zIsEmpty = TextUtils.isEmpty(blurb);
            boolean z6 = strFirstWorksUrl != null;
            boolean z7 = strSecondWorksUrl != null;
            boolean z8 = strThirdWorksUrl != null;
            z = !zIsEmpty;
            str = (position + 1) + "";
            str2 = blurb;
            str4 = strFirstWorksUrl;
            str5 = avatar;
            str6 = strSecondWorksUrl;
            str7 = strThirdWorksUrl;
            str8 = str12;
            str9 = coverImgUrl;
            str10 = title;
            str11 = ownerName;
            i = picWidthDp;
            z2 = zShowRankIcon;
            z3 = z6;
            z4 = z7;
            z5 = z8;
        } else {
            z = false;
            str = null;
            str2 = null;
            z2 = false;
            requestOptions = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            i = 0;
            z3 = false;
            z4 = false;
            z5 = false;
        }
        boolean zShowTextRank = ((4 & j) == 0 || originalChannelHotspotBean == null) ? false : originalChannelHotspotBean.showTextRank();
        long j3 = j & 3;
        if (j3 == 0) {
            zShowTextRank = false;
        } else if (z2) {
            zShowTextRank = true;
        }
        if (j3 != 0) {
            aw9.d(((WorksItemOrginalChannelSubBinding) this).f14600a, str5, false, null);
            CommonBindingAdapter.b0(((WorksItemOrginalChannelSubBinding) this).f14599a, str9, OriginalChannelHotspotBean.getOption(), false);
            CommonBindingAdapter.l0(((WorksItemOrginalChannelSubBinding) this).f37041a, z2);
            CommonBindingAdapter.l0(this.b, z4);
            float f = i;
            CommonBindingAdapter.H(this.b, f);
            CommonBindingAdapter.G(this.b, f);
            CommonBindingAdapter.b0(this.b, str6, requestOptions, false);
            CommonBindingAdapter.l0(this.f14608c, z5);
            CommonBindingAdapter.H(this.f14608c, f);
            CommonBindingAdapter.G(this.f14608c, f);
            CommonBindingAdapter.b0(this.f14608c, str7, requestOptions, false);
            TextViewBindingAdapter.setText(this.c, str8);
            CommonBindingAdapter.W(this.c, str3);
            CommonBindingAdapter.l0(this.c, zShowTextRank);
            CommonBindingAdapter.l0(this.d, z);
            TextViewBindingAdapter.setText(this.d, str2);
            CommonBindingAdapter.l0(this.f14609d, z3);
            CommonBindingAdapter.H(this.f14609d, f);
            CommonBindingAdapter.G(this.f14609d, f);
            CommonBindingAdapter.b0(this.f14609d, str4, requestOptions, false);
            TextViewBindingAdapter.setText(((WorksItemOrginalChannelSubBinding) this).f14598a, str10);
            TextViewBindingAdapter.setText(((WorksItemOrginalChannelSubBinding) this).f14603b, str11);
            TextViewBindingAdapter.setText(((WorksItemOrginalChannelSubBinding) this).f14604b, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14606a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14606a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemOrginalChannelSubBinding
    public void k(@Nullable OriginalChannelHotspotBean Bean) {
        ((WorksItemOrginalChannelSubBinding) this).f14601a = Bean;
        synchronized (this) {
            this.f14606a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((OriginalChannelHotspotBean) variable);
        return true;
    }

    public WorksItemOrginalChannelSubBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AvatarView) bindings[2], (RoundImageView) bindings[1], (ImageView) bindings[4], (LinearLayout) bindings[12], (LinearLayout) bindings[14], (BLTextView) bindings[13], (TextView) bindings[7], (TextView) bindings[3], (BLTextView) bindings[5]);
        this.f14606a = -1L;
        ((WorksItemOrginalChannelSubBinding) this).f14600a.setTag(null);
        ((WorksItemOrginalChannelSubBinding) this).f14599a.setTag(null);
        ((WorksItemOrginalChannelSubBinding) this).f37041a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14607a = constraintLayout;
        constraintLayout.setTag(null);
        RoundImageView roundImageView = (RoundImageView) bindings[10];
        this.b = roundImageView;
        roundImageView.setTag(null);
        RoundImageView roundImageView2 = (RoundImageView) bindings[11];
        this.f14608c = roundImageView2;
        roundImageView2.setTag(null);
        TextView textView = (TextView) bindings[6];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[8];
        this.d = textView2;
        textView2.setTag(null);
        RoundImageView roundImageView3 = (RoundImageView) bindings[9];
        this.f14609d = roundImageView3;
        roundImageView3.setTag(null);
        ((WorksItemOrginalChannelSubBinding) this).f14598a.setTag(null);
        ((WorksItemOrginalChannelSubBinding) this).f14603b.setTag(null);
        ((WorksItemOrginalChannelSubBinding) this).f14604b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
