package com.huachenjie.compat.databinding;

import android.content.Context;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.compat.bean.PersonalInfo;
import com.huachenjie.compat.page.personal.PersonalV2Activity;
import com.huachenjie.compat.page.personal.PersonalV2VM;
import com.zj.adlib.ai9;
import com.zj.adlib.aw9;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityPersonalV2BindingImpl extends ActivityPersonalV2Binding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f9128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f9131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f9132a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f9136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f9137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f9138a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9139b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f9140c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9141d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f9142d;

    @NonNull
    public final LinearLayout e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f9143e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PersonalV2Activity.e f34042a;

        public a a(PersonalV2Activity.e eVar) {
            this.f34042a = eVar;
            if (eVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34042a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PersonalV2Activity.e f34043a;

        public b a(PersonalV2Activity.e eVar) {
            this.f34043a = eVar;
            if (eVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34043a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PersonalV2Activity.e f34044a;

        public c a(PersonalV2Activity.e eVar) {
            this.f34044a = eVar;
            if (eVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34044a.d(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PersonalV2Activity.e f34045a;

        public d a(PersonalV2Activity.e eVar) {
            this.f34045a = eVar;
            if (eVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34045a.c(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PersonalV2Activity.e f34046a;

        public e a(PersonalV2Activity.e eVar) {
            this.f34046a = eVar;
            if (eVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34046a.e(view);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PersonalV2Activity.e f34047a;

        public f a(PersonalV2Activity.e eVar) {
            this.f34047a = eVar;
            if (eVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34047a.f(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(27);
        f9126a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{22}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34041a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_class_name, 23);
        sparseIntArray.put(com.huachenjie.compat.R.id.iv_class_arrow, 24);
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_address_name, 25);
        sparseIntArray.put(com.huachenjie.compat.R.id.iv_address_arrow, 26);
    }

    public ActivityPersonalV2BindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 27, f9126a, f34041a));
    }

    /* JADX WARN: Code duplicated, block: B:76:0x013a  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String userName;
        boolean zIsEmpty;
        String departmentName;
        String str;
        boolean zIsEmpty2;
        boolean zIsEmpty3;
        String avatarFrameImgUrl;
        Drawable drawable;
        String gradeName;
        String subSchoolName;
        String studentNumber;
        String avatar;
        String str2;
        int i;
        boolean zSafeUnbox;
        String nation;
        BindingTitleBean value;
        String birthday;
        String className;
        f fVar;
        d dVar;
        c cVar;
        b bVar;
        long j2;
        e eVarA;
        a aVar;
        String str3;
        String str4;
        String str5;
        int i2;
        long j3;
        String schoolName;
        int i3;
        SchoolInfo schoolInfo;
        Context context;
        int i4;
        synchronized (this) {
            j = this.f9127a;
            this.f9127a = 0L;
        }
        PersonalV2VM personalV2VM = ((ActivityPersonalV2Binding) this).f9124a;
        PersonalV2Activity.e eVar = ((ActivityPersonalV2Binding) this).f9123a;
        if ((95 & j) != 0) {
            long j4 = j & 81;
            if (j4 != 0) {
                MutableLiveData<Boolean> mutableLiveData = personalV2VM != null ? personalV2VM.l : null;
                updateLiveDataRegistration(0, mutableLiveData);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
                if (j4 != 0) {
                    j |= zSafeUnbox ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
                }
                i2 = zSafeUnbox ? -90 : 90;
            } else {
                i2 = 0;
                zSafeUnbox = false;
            }
            long j5 = j & 82;
            if (j5 != 0) {
                MutableLiveData<PersonalInfo> mutableLiveData2 = personalV2VM != null ? personalV2VM.j : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                PersonalInfo value2 = mutableLiveData2 != null ? mutableLiveData2.getValue() : null;
                if (value2 != null) {
                    int sex = value2.getSex();
                    schoolInfo = value2.getSchoolInfo();
                    userName = value2.getUserName();
                    nation = value2.getNation();
                    avatarFrameImgUrl = value2.getAvatarFrameImgUrl();
                    birthday = value2.getBirthday();
                    avatar = value2.getAvatar();
                    i3 = sex;
                } else {
                    i3 = 0;
                    avatar = null;
                    schoolInfo = null;
                    userName = null;
                    nation = null;
                    avatarFrameImgUrl = null;
                    birthday = null;
                }
                boolean z = i3 == 1;
                zIsEmpty2 = TextUtils.isEmpty(nation);
                zIsEmpty3 = TextUtils.isEmpty(birthday);
                if (j5 != 0) {
                    j |= z ? 256L : 128L;
                }
                if ((j & 82) != 0) {
                    j |= zIsEmpty2 ? 4096L : 2048L;
                }
                if ((j & 82) != 0) {
                    j |= zIsEmpty3 ? 1024L : 512L;
                }
                if (schoolInfo != null) {
                    subSchoolName = schoolInfo.getSubSchoolName();
                    departmentName = schoolInfo.getDepartmentName();
                    gradeName = schoolInfo.getGradeName();
                    studentNumber = schoolInfo.getStudentNumber();
                    className = schoolInfo.getClassName();
                    schoolName = schoolInfo.getSchoolName();
                } else {
                    subSchoolName = null;
                    departmentName = null;
                    schoolName = null;
                    gradeName = null;
                    studentNumber = null;
                    className = null;
                }
                if (z) {
                    context = ((ActivityPersonalV2Binding) this).c.getContext();
                    i4 = com.huachenjie.compat.R.drawable.ic_sex_woman;
                } else {
                    context = ((ActivityPersonalV2Binding) this).c.getContext();
                    i4 = com.huachenjie.compat.R.drawable.ic_sex_man;
                }
                drawable = AppCompatResources.getDrawable(context, i4);
                j3 = 84;
            } else {
                zIsEmpty2 = false;
                zIsEmpty3 = false;
                avatar = null;
                drawable = null;
                subSchoolName = null;
                j3 = 84;
                departmentName = null;
                schoolName = null;
                userName = null;
                nation = null;
                avatarFrameImgUrl = null;
                birthday = null;
                gradeName = null;
                studentNumber = null;
                className = null;
            }
            if ((j & j3) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveData3 = personalV2VM != null ? personalV2VM.i : null;
                updateLiveDataRegistration(2, mutableLiveData3);
                if (mutableLiveData3 != null) {
                    value = mutableLiveData3.getValue();
                } else {
                    value = null;
                }
            }
            long j6 = j & 88;
            if (j6 != 0) {
                MutableLiveData<String> mutableLiveData4 = personalV2VM != null ? personalV2VM.n : null;
                updateLiveDataRegistration(3, mutableLiveData4);
                String value3 = mutableLiveData4 != null ? mutableLiveData4.getValue() : null;
                zIsEmpty = TextUtils.isEmpty(value3);
                if (j6 != 0) {
                    j |= zIsEmpty ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                str2 = value3;
            } else {
                zIsEmpty = false;
                str2 = null;
            }
            String str6 = schoolName;
            i = i2;
            str = str6;
        } else {
            userName = null;
            zIsEmpty = false;
            departmentName = null;
            str = null;
            zIsEmpty2 = false;
            zIsEmpty3 = false;
            avatarFrameImgUrl = null;
            drawable = null;
            gradeName = null;
            subSchoolName = null;
            studentNumber = null;
            avatar = null;
            str2 = null;
            i = 0;
            zSafeUnbox = false;
            nation = null;
            value = null;
            birthday = null;
            className = null;
        }
        long j7 = j & 96;
        if (j7 == 0 || eVar == null) {
            fVar = null;
            dVar = null;
            cVar = null;
            bVar = null;
            j2 = 82;
            eVarA = null;
            aVar = null;
        } else {
            f fVar2 = this.f9138a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f9138a = fVar2;
            }
            f fVarA = fVar2.a(eVar);
            a aVar2 = this.f9133a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9133a = aVar2;
            }
            a aVarA = aVar2.a(eVar);
            b bVar2 = this.f9134a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f9134a = bVar2;
            }
            b bVarA = bVar2.a(eVar);
            c cVar2 = this.f9135a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f9135a = cVar2;
            }
            c cVarA = cVar2.a(eVar);
            d dVar2 = this.f9136a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f9136a = dVar2;
            }
            d dVarA = dVar2.a(eVar);
            e eVar2 = this.f9137a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f9137a = eVar2;
            }
            eVarA = eVar2.a(eVar);
            fVar = fVarA;
            aVar = aVarA;
            bVar = bVarA;
            cVar = cVarA;
            dVar = dVarA;
            j2 = 82;
        }
        long j8 = j & j2;
        if (j8 != 0) {
            str4 = zIsEmpty3 ? "暂无" : birthday;
            str3 = zIsEmpty2 ? "暂无" : nation;
        } else {
            str3 = null;
            str4 = null;
        }
        long j9 = j & 88;
        if (j9 != 0) {
            str5 = zIsEmpty ? "暂无" : str2;
        } else {
            str5 = null;
        }
        String str7 = str5;
        if (j8 != 0) {
            ImageViewBindingAdapter.setImageDrawable(((ActivityPersonalV2Binding) this).c, drawable);
            TextViewBindingAdapter.setText(this.f9140c, userName);
            TextViewBindingAdapter.setText(this.f9142d, str4);
            TextViewBindingAdapter.setText(this.f9143e, str3);
            aw9.d(this.f9131a, avatar, false, null);
            aw9.c(this.f9131a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(this.g, studentNumber);
            TextViewBindingAdapter.setText(this.i, str);
            TextViewBindingAdapter.setText(this.j, subSchoolName);
            TextViewBindingAdapter.setText(this.k, gradeName);
            TextViewBindingAdapter.setText(this.l, departmentName);
            TextViewBindingAdapter.setText(this.m, className);
        }
        if ((84 & j) != 0) {
            this.f9132a.k(value);
        }
        if ((81 & j) != 0) {
            boolean z2 = zSafeUnbox;
            CommonBindingAdapter.l0(this.b, z2);
            CommonBindingAdapter.l0(this.c, z2);
            CommonBindingAdapter.l0(this.f9130a, z2);
            CommonBindingAdapter.l0(this.f9128a, z2);
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.d.setRotation(i);
            }
        }
        if (j7 != 0) {
            CommonBindingAdapter.q(this.b, dVar, null);
            CommonBindingAdapter.q(this.c, fVar, null);
            CommonBindingAdapter.q(this.f9130a, bVar, null);
            CommonBindingAdapter.q(this.f9141d, aVar, null);
            CommonBindingAdapter.q(this.e, cVar, null);
            CommonBindingAdapter.q(this.f9139b, eVarA, null);
        }
        if (j9 != 0) {
            TextViewBindingAdapter.setText(this.f, str7);
        }
        if ((j & 64) != 0) {
            CommonBindingAdapter.l0(this.h, ai9.m());
            CommonBindingAdapter.l0(this.e, ai9.m());
            CommonBindingAdapter.l0(this.f9139b, ai9.m());
        }
        ViewDataBinding.executeBindingsOn(this.f9132a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9127a != 0) {
                return true;
            }
            return this.f9132a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9127a = 64L;
        }
        this.f9132a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityPersonalV2Binding
    public void l(@Nullable PersonalV2Activity.e eVar) {
        ((ActivityPersonalV2Binding) this).f9123a = eVar;
        synchronized (this) {
            this.f9127a |= 32;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityPersonalV2Binding
    public void m(@Nullable PersonalV2VM personalV2VM) {
        ((ActivityPersonalV2Binding) this).f9124a = personalV2VM;
        synchronized (this) {
            this.f9127a |= 16;
        }
        notifyPropertyChanged(wk0.L);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9127a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9127a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<PersonalInfo> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9127a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9127a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f9132a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.L == i) {
            m((PersonalV2VM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((PersonalV2Activity.e) obj);
        }
        return true;
    }

    public ActivityPersonalV2BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ImageView) objArr[26], (ImageView) objArr[24], (ImageView) objArr[20], (TextView) objArr[25], (TextView) objArr[23]);
        this.f9127a = -1L;
        ((ActivityPersonalV2Binding) this).c.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[22];
        this.f9132a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9129a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f9140c = textView;
        textView.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[10];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView2 = (TextView) objArr[11];
        this.f9142d = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[12];
        this.c = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView3 = (TextView) objArr[13];
        this.f9143e = textView3;
        textView3.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[14];
        this.f9130a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView4 = (TextView) objArr[15];
        this.f = textView4;
        textView4.setTag(null);
        View view2 = (View) objArr[16];
        this.f9128a = view2;
        view2.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[17];
        this.f9141d = linearLayout4;
        linearLayout4.setTag(null);
        ImageView imageView = (ImageView) objArr[18];
        this.d = imageView;
        imageView.setTag(null);
        AvatarView avatarView = (AvatarView) objArr[19];
        this.f9131a = avatarView;
        avatarView.setTag(null);
        TextView textView5 = (TextView) objArr[2];
        this.g = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[21];
        this.h = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[3];
        this.i = textView7;
        textView7.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) objArr[4];
        this.e = linearLayout5;
        linearLayout5.setTag(null);
        TextView textView8 = (TextView) objArr[5];
        this.j = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[6];
        this.k = textView9;
        textView9.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[7];
        this.f9139b = constraintLayout2;
        constraintLayout2.setTag(null);
        TextView textView10 = (TextView) objArr[8];
        this.l = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[9];
        this.m = textView11;
        textView11.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
