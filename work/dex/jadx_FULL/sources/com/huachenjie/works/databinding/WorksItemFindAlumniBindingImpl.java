package com.huachenjie.works.databinding;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.SchoolMateBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemFindAlumniBindingImpl extends WorksItemFindAlumniBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14570a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14572a;

    @NonNull
    public final TextView c;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37030a = sparseIntArray;
        sparseIntArray.put(R.id.v_line, 9);
    }

    public WorksItemFindAlumniBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f14570a, f37030a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String gradeName;
        Drawable drawable;
        String str;
        RequestOptions requestOptions;
        String sexStr;
        String tag1;
        String userName;
        String str2;
        String str3;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String tag2;
        String avatarUrl;
        int sexIcon;
        boolean zIsApplied;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f14571a;
            this.f14571a = 0L;
        }
        SchoolMateBean schoolMateBean = ((WorksItemFindAlumniBinding) this).f14567a;
        long j4 = j & 3;
        String tag3 = null;
        if (j4 != 0) {
            requestOptions = ju3.d;
            if (schoolMateBean != null) {
                tag3 = schoolMateBean.getTag3();
                sexStr = schoolMateBean.getSexStr();
                tag1 = schoolMateBean.getTag1();
                userName = schoolMateBean.getUserName();
                sexIcon = schoolMateBean.getSexIcon();
                tag2 = schoolMateBean.getTag2();
                avatarUrl = schoolMateBean.getAvatarUrl();
                zIsApplied = schoolMateBean.isApplied();
                gradeName = schoolMateBean.getGradeName();
            } else {
                gradeName = null;
                sexStr = null;
                tag1 = null;
                userName = null;
                tag2 = null;
                avatarUrl = null;
                sexIcon = 0;
                zIsApplied = false;
            }
            if (j4 != 0) {
                if (zIsApplied) {
                    j2 = j | 8;
                    j3 = 32;
                } else {
                    j2 = j | 4;
                    j3 = 16;
                }
                j = j2 | j3;
            }
            boolean zIsEmpty = TextUtils.isEmpty(tag3);
            boolean zIsEmpty2 = TextUtils.isEmpty(tag1);
            boolean zIsEmpty3 = TextUtils.isEmpty(tag2);
            boolean z5 = !zIsApplied;
            drawable = zIsApplied ? AppCompatResources.getDrawable(((WorksItemFindAlumniBinding) this).f14568a.getContext(), R.drawable.works_ic_find_albumni_ok_unenable) : AppCompatResources.getDrawable(((WorksItemFindAlumniBinding) this).f14568a.getContext(), R.drawable.works_ic_find_albumni_ok);
            str = zIsApplied ? "已打招呼" : "打招呼";
            z = !zIsEmpty2;
            z4 = !zIsEmpty3;
            str3 = tag2;
            z3 = !zIsEmpty;
            i = sexIcon;
            z2 = z5;
            String str4 = avatarUrl;
            str2 = tag3;
            tag3 = str4;
        } else {
            gradeName = null;
            drawable = null;
            str = null;
            requestOptions = null;
            sexStr = null;
            tag1 = null;
            userName = null;
            str2 = null;
            str3 = null;
            i = 0;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        if ((j & 3) != 0) {
            CommonBindingAdapter.b0(((WorksItemFindAlumniBinding) this).f14565a, tag3, requestOptions, false);
            CommonBindingAdapter.d0(this.c, i);
            TextViewBindingAdapter.setText(this.c, sexStr);
            TextViewBindingAdapter.setText(((WorksItemFindAlumniBinding) this).f14566a, gradeName);
            TextViewBindingAdapter.setDrawableLeft(((WorksItemFindAlumniBinding) this).f14568a, drawable);
            CommonBindingAdapter.e0(((WorksItemFindAlumniBinding) this).f14568a, z2);
            TextViewBindingAdapter.setText(((WorksItemFindAlumniBinding) this).f14568a, str);
            TextViewBindingAdapter.setText(((WorksItemFindAlumniBinding) this).b, userName);
            TextViewBindingAdapter.setText(((WorksItemFindAlumniBinding) this).f14569b, tag1);
            CommonBindingAdapter.l0(((WorksItemFindAlumniBinding) this).f14569b, z);
            TextViewBindingAdapter.setText(super.c, str3);
            CommonBindingAdapter.l0(super.c, z4);
            TextViewBindingAdapter.setText(this.d, str2);
            CommonBindingAdapter.l0(this.d, z3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14571a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14571a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemFindAlumniBinding
    public void k(@Nullable SchoolMateBean Bean) {
        ((WorksItemFindAlumniBinding) this).f14567a = Bean;
        synchronized (this) {
            this.f14571a |= 1;
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
        k((SchoolMateBean) variable);
        return true;
    }

    public WorksItemFindAlumniBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (TextView) bindings[4], (BLTextView) bindings[2], (TextView) bindings[3], (BLTextView) bindings[6], (BLTextView) bindings[7], (BLTextView) bindings[8], (View) bindings[9]);
        this.f14571a = -1L;
        ((WorksItemFindAlumniBinding) this).f14565a.setTag(null);
        CardView cardView = (CardView) bindings[0];
        this.f14572a = cardView;
        cardView.setTag(null);
        TextView textView = (TextView) bindings[5];
        this.c = textView;
        textView.setTag(null);
        ((WorksItemFindAlumniBinding) this).f14566a.setTag(null);
        ((WorksItemFindAlumniBinding) this).f14568a.setTag(null);
        ((WorksItemFindAlumniBinding) this).b.setTag(null);
        ((WorksItemFindAlumniBinding) this).f14569b.setTag(null);
        super.c.setTag(null);
        this.d.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
