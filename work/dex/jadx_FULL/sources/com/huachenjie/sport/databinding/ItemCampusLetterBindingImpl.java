package com.huachenjie.sport.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.CampusLetterBean;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemCampusLetterBindingImpl extends ItemCampusLetterBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13559a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13560a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f13561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f13562a;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36498a = sparseIntArray;
        sparseIntArray.put(R.id.v_line, 9);
    }

    public ItemCampusLetterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f13559a, f36498a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String schoolLetterSummary;
        String schoolLetterTitle;
        int i;
        boolean z;
        int i2;
        int i3;
        boolean zShowDetail;
        boolean z2;
        String passStatus;
        int i4;
        boolean zShowPassStatus;
        int icon;
        long j2;
        long j3;
        boolean readFlag;
        synchronized (this) {
            j = this.f13560a;
            this.f13560a = 0L;
        }
        CampusLetterBean campusLetterBean = ((ItemCampusLetterBinding) this).f13556a;
        long j4 = j & 3;
        Drawable drawable = null;
        String str3 = null;
        int i5 = 0;
        boolean z3 = 0;
        if (j4 != 0) {
            if (campusLetterBean != null) {
                readFlag = campusLetterBean.getReadFlag();
                int passBg = campusLetterBean.formatPassBg();
                String letterTime = campusLetterBean.formatLetterTime();
                zShowPassStatus = campusLetterBean.showPassStatus();
                zShowDetail = campusLetterBean.showDetail();
                icon = campusLetterBean.formatIcon();
                schoolLetterSummary = campusLetterBean.getSchoolLetterSummary();
                schoolLetterTitle = campusLetterBean.getSchoolLetterTitle();
                passStatus = campusLetterBean.formatPassStatus();
                i4 = passBg;
                str3 = letterTime;
            } else {
                passStatus = null;
                schoolLetterSummary = null;
                schoolLetterTitle = null;
                i4 = 0;
                zShowPassStatus = false;
                zShowDetail = false;
                icon = 0;
            }
            if (j4 != 0) {
                if (z3 != 0) {
                    j2 = j | 8 | 32;
                    j3 = 128;
                } else {
                    j2 = j | 4 | 16;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            int i6 = z3 != 0 ? -7759964 : -10155284;
            Drawable drawable2 = z3 != 0 ? AppCompatResources.getDrawable(((ItemCampusLetterBinding) this).b.getContext(), R.drawable.ic_campus_letter_arrow) : AppCompatResources.getDrawable(((ItemCampusLetterBinding) this).b.getContext(), R.drawable.ic_campus_letter_arrow_unread);
            int i7 = !z3;
            int i8 = z3 != 0 ? -7759964 : -13877680;
            z = i7 == true ? 1 : 0;
            i = i4;
            i2 = i8;
            i5 = icon;
            z2 = zShowPassStatus;
            i3 = i6;
            Drawable drawable3 = drawable2;
            str2 = passStatus;
            str = str3;
            drawable = drawable3;
        } else {
            str = null;
            str2 = null;
            schoolLetterSummary = null;
            schoolLetterTitle = null;
            i = 0;
            z = false;
            i2 = 0;
            i3 = 0;
            zShowDetail = false;
            z2 = false;
        }
        if ((j & 3) != 0) {
            DrawablesBindingAdapter.e(((ItemCampusLetterBinding) this).f13554a, i5);
            CommonBindingAdapter.l0(((ItemCampusLetterBinding) this).b, zShowDetail);
            ImageViewBindingAdapter.setImageDrawable(((ItemCampusLetterBinding) this).b, drawable);
            CommonBindingAdapter.l0(this.f13562a, z);
            CommonBindingAdapter.z(this.c, z);
            TextViewBindingAdapter.setText(this.c, schoolLetterSummary);
            this.c.setTextColor(i2);
            CommonBindingAdapter.z(this.d, z);
            TextViewBindingAdapter.setText(this.d, str);
            this.d.setTextColor(i2);
            CommonBindingAdapter.l0(((ItemCampusLetterBinding) this).f13555a, zShowDetail);
            CommonBindingAdapter.z(((ItemCampusLetterBinding) this).f13555a, z);
            ((ItemCampusLetterBinding) this).f13555a.setTextColor(i3);
            CommonBindingAdapter.l0(((ItemCampusLetterBinding) this).f13557a, z2);
            CommonBindingAdapter.x(((ItemCampusLetterBinding) this).f13557a, i);
            TextViewBindingAdapter.setText(((ItemCampusLetterBinding) this).f13557a, str2);
            TextViewBindingAdapter.setText(((ItemCampusLetterBinding) this).f13558b, schoolLetterTitle);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13560a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13560a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemCampusLetterBinding
    public void k(@Nullable CampusLetterBean campusLetterBean) {
        ((ItemCampusLetterBinding) this).f13556a = campusLetterBean;
        synchronized (this) {
            this.f13560a |= 1;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 != i) {
            return false;
        }
        k((CampusLetterBean) obj);
        return true;
    }

    public ItemCampusLetterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ImageView) objArr[6], (TextView) objArr[7], (BLTextView) objArr[4], (TextView) objArr[3], (View) objArr[9]);
        this.f13560a = -1L;
        ((ItemCampusLetterBinding) this).f13554a.setTag(null);
        ((ItemCampusLetterBinding) this).b.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f13561a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        BLView bLView = (BLView) objArr[2];
        this.f13562a = bLView;
        bLView.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[8];
        this.d = textView2;
        textView2.setTag(null);
        ((ItemCampusLetterBinding) this).f13555a.setTag(null);
        ((ItemCampusLetterBinding) this).f13557a.setTag(null);
        ((ItemCampusLetterBinding) this).f13558b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
