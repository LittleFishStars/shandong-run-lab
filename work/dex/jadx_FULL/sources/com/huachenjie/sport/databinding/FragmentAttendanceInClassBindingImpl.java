package com.huachenjie.sport.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.base.widget.calendar.CalendarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.AttendanceAdapter;
import com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler;
import com.huachenjie.sport.page.mine.attendance.AttendanceSubVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentAttendanceInClassBindingImpl extends FragmentAttendanceInClassBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13432a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13437a;

    @NonNull
    public final LinearLayout b;

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

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceClickHandler f36460a;

        public a a(AttendanceClickHandler attendanceClickHandler) {
            this.f36460a = attendanceClickHandler;
            if (attendanceClickHandler == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36460a.clickPreMonth(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceClickHandler f36461a;

        public b a(AttendanceClickHandler attendanceClickHandler) {
            this.f36461a = attendanceClickHandler;
            if (attendanceClickHandler == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36461a.clickNextMonth(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceClickHandler f36462a;

        public c a(AttendanceClickHandler attendanceClickHandler) {
            this.f36462a = attendanceClickHandler;
            if (attendanceClickHandler == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36462a.clickToday(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36459a = sparseIntArray;
        sparseIntArray.put(R.id.ll_attendance_container, 12);
        sparseIntArray.put(R.id.rl_attendance_count, 13);
        sparseIntArray.put(R.id.tv_attendance_semester, 14);
        sparseIntArray.put(R.id.tv_attendance_semester_unit, 15);
        sparseIntArray.put(R.id.iv_attendance_count_arrow, 16);
        sparseIntArray.put(R.id.ll_attendance_stats, 17);
        sparseIntArray.put(R.id.line, 18);
        sparseIntArray.put(R.id.calendarView, 19);
        sparseIntArray.put(R.id.tvClocked, 20);
        sparseIntArray.put(R.id.tvClocked_missing, 21);
        sparseIntArray.put(R.id.line_bottom, 22);
    }

    public FragmentAttendanceInClassBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 23, f13432a, f36459a));
    }

    /* JADX WARN: Code duplicated, block: B:113:0x018f  */
    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        String str3;
        int i2;
        AttendanceAdapter attendanceAdapter;
        int i3;
        String str4;
        String str5;
        String str6;
        String value;
        int i4;
        b bVarA;
        c cVar;
        a aVar;
        AttendanceAdapter value2;
        int i5;
        String str7;
        String str8;
        int i6;
        String str9;
        synchronized (this) {
            j = this.f13433a;
            this.f13433a = 0L;
        }
        AttendanceSubVM attendanceSubVM = ((FragmentAttendanceInClassBinding) this).f13426a;
        AttendanceClickHandler attendanceClickHandler = ((FragmentAttendanceInClassBinding) this).f13425a;
        if ((1535 & j) != 0) {
            if ((j & 1281) == 0) {
                value2 = null;
            } else {
                MutableLiveData<AttendanceAdapter> mutableLiveDataE = attendanceSubVM != null ? attendanceSubVM.E() : null;
                updateLiveDataRegistration(0, mutableLiveDataE);
                if (mutableLiveDataE != null) {
                    value2 = mutableLiveDataE.getValue();
                } else {
                    value2 = null;
                }
            }
            long j2 = j & 1282;
            if (j2 != 0) {
                MutableLiveData<Integer> mutableLiveDataB = attendanceSubVM != null ? attendanceSubVM.B() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                Integer value3 = mutableLiveDataB != null ? mutableLiveDataB.getValue() : null;
                str4 = String.format(TimeModel.NUMBER_FORMAT, value3);
                boolean z = ViewDataBinding.safeUnbox(value3) == 0;
                if (j2 != 0) {
                    j |= z ? 4096L : 2048L;
                }
                i3 = z ? -3355444 : -35281;
            } else {
                i3 = 0;
                str4 = null;
            }
            long j3 = j & 1284;
            if (j3 != 0) {
                MutableLiveData<Integer> mutableLiveDataC = attendanceSubVM != null ? attendanceSubVM.C() : null;
                updateLiveDataRegistration(2, mutableLiveDataC);
                Integer value4 = mutableLiveDataC != null ? mutableLiveDataC.getValue() : null;
                str7 = String.format(TimeModel.NUMBER_FORMAT, value4);
                boolean z2 = ViewDataBinding.safeUnbox(value4) == 0;
                if (j3 != 0) {
                    j |= z2 ? 262144L : 131072L;
                }
                i5 = z2 ? -3355444 : -35281;
            } else {
                i5 = 0;
                str7 = null;
            }
            if ((j & 1288) != 0) {
                MutableLiveData<Integer> mutableLiveDataN = attendanceSubVM != null ? attendanceSubVM.N() : null;
                updateLiveDataRegistration(3, mutableLiveDataN);
                str5 = String.format(TimeModel.NUMBER_FORMAT, mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
            } else {
                str5 = null;
            }
            long j4 = j & 1296;
            if (j4 != 0) {
                MutableLiveData<Integer> mutableLiveDataA = attendanceSubVM != null ? attendanceSubVM.A() : null;
                updateLiveDataRegistration(4, mutableLiveDataA);
                Integer value5 = mutableLiveDataA != null ? mutableLiveDataA.getValue() : null;
                int iSafeUnbox = ViewDataBinding.safeUnbox(value5);
                i = i5;
                str8 = str7;
                str9 = String.format(TimeModel.NUMBER_FORMAT, value5);
                boolean z3 = iSafeUnbox == 0;
                if (j4 != 0) {
                    j |= z3 ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                i6 = z3 ? -3355444 : -35281;
            } else {
                i = i5;
                str8 = str7;
                i6 = 0;
                str9 = null;
            }
            if ((j & 1312) != 0) {
                MutableLiveData<Integer> mutableLiveDataV = attendanceSubVM != null ? attendanceSubVM.v() : null;
                updateLiveDataRegistration(5, mutableLiveDataV);
                str6 = String.format(TimeModel.NUMBER_FORMAT, mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                str6 = null;
            }
            if ((j & 1344) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataZ = attendanceSubVM != null ? attendanceSubVM.z() : null;
                updateLiveDataRegistration(6, mutableLiveDataZ);
                if (mutableLiveDataZ != null) {
                    value = mutableLiveDataZ.getValue();
                } else {
                    value = null;
                }
            }
            long j5 = j & 1408;
            if (j5 != 0) {
                MutableLiveData<Integer> mutableLiveDataD = attendanceSubVM != null ? attendanceSubVM.D() : null;
                updateLiveDataRegistration(7, mutableLiveDataD);
                Integer value6 = mutableLiveDataD != null ? mutableLiveDataD.getValue() : null;
                String str10 = String.format(TimeModel.NUMBER_FORMAT, value6);
                boolean z4 = ViewDataBinding.safeUnbox(value6) == 0;
                if (j5 != 0) {
                    j |= z4 ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
                }
                str = str10;
                i4 = z4 ? -3355444 : -35281;
            } else {
                str = null;
                i4 = 0;
            }
            i2 = i6;
            attendanceAdapter = value2;
            str3 = str8;
            str2 = str9;
        } else {
            str = null;
            i = 0;
            str2 = null;
            str3 = null;
            i2 = 0;
            attendanceAdapter = null;
            i3 = 0;
            str4 = null;
            str5 = null;
            str6 = null;
            value = null;
            i4 = 0;
        }
        long j6 = j & 1536;
        if (j6 == 0 || attendanceClickHandler == null) {
            bVarA = null;
            cVar = null;
            aVar = null;
        } else {
            c cVar2 = this.f13437a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f13437a = cVar2;
            }
            c cVarA = cVar2.a(attendanceClickHandler);
            a aVar2 = this.f13435a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13435a = aVar2;
            }
            a aVarA = aVar2.a(attendanceClickHandler);
            b bVar = this.f13436a;
            if (bVar == null) {
                bVar = new b();
                this.f13436a = bVar;
            }
            bVarA = bVar.a(attendanceClickHandler);
            aVar = aVarA;
            cVar = cVarA;
        }
        if (j6 != 0) {
            CommonBindingAdapter.q(((FragmentAttendanceInClassBinding) this).f13429b, bVarA, null);
            CommonBindingAdapter.q(((FragmentAttendanceInClassBinding) this).c, aVar, null);
            CommonBindingAdapter.q(((FragmentAttendanceInClassBinding) this).f13428a, cVar, null);
        }
        if ((j & 1281) != 0) {
            CommonBindingAdapter.g(this.f13434a, attendanceAdapter, false, false);
        }
        if ((j & 1312) != 0) {
            TextViewBindingAdapter.setText(this.g, str6);
        }
        if ((j & 1282) != 0) {
            TextViewBindingAdapter.setText(this.h, str4);
            this.h.setTextColor(i3);
        }
        if ((1408 & j) != 0) {
            TextViewBindingAdapter.setText(this.i, str);
            this.i.setTextColor(i4);
        }
        if ((j & 1284) != 0) {
            TextViewBindingAdapter.setText(this.j, str3);
            this.j.setTextColor(i);
        }
        if ((1296 & j) != 0) {
            TextViewBindingAdapter.setText(this.k, str2);
            this.k.setTextColor(i2);
        }
        if ((1288 & j) != 0) {
            TextViewBindingAdapter.setText(((FragmentAttendanceInClassBinding) this).f13430b, str5);
        }
        if ((j & 1344) != 0) {
            TextViewBindingAdapter.setText(this.d, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13433a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13433a = 1024L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentAttendanceInClassBinding
    public void l(@Nullable AttendanceClickHandler attendanceClickHandler) {
        ((FragmentAttendanceInClassBinding) this).f13425a = attendanceClickHandler;
        synchronized (this) {
            this.f13433a |= 512;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentAttendanceInClassBinding
    public void m(@Nullable AttendanceSubVM attendanceSubVM) {
        ((FragmentAttendanceInClassBinding) this).f13426a = attendanceSubVM;
        synchronized (this) {
            this.f13433a |= 256;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13433a |= 32;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13433a |= 64;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return t((MutableLiveData) obj, i2);
            case 1:
                return q((MutableLiveData) obj, i2);
            case 2:
                return r((MutableLiveData) obj, i2);
            case 3:
                return u((MutableLiveData) obj, i2);
            case 4:
                return p((MutableLiveData) obj, i2);
            case 5:
                return n((MutableLiveData) obj, i2);
            case 6:
                return o((MutableLiveData) obj, i2);
            case 7:
                return s((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13433a |= 16;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13433a |= 2;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13433a |= 4;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13433a |= 128;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((AttendanceSubVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((AttendanceClickHandler) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<AttendanceAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13433a |= 1;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13433a |= 8;
        }
        return true;
    }

    public FragmentAttendanceInClassBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (CalendarView) objArr[19], (ImageView) objArr[16], (ImageView) objArr[9], (ImageView) objArr[8], (View) objArr[18], (View) objArr[22], (BLLinearLayout) objArr[12], (LinearLayout) objArr[17], (RelativeLayout) objArr[13], (TextView) objArr[14], (TextView) objArr[1], (TextView) objArr[15], (TextView) objArr[7], (TextView) objArr[20], (TextView) objArr[21], (BLTextView) objArr[10]);
        this.f13433a = -1L;
        ((FragmentAttendanceInClassBinding) this).f13429b.setTag(null);
        ((FragmentAttendanceInClassBinding) this).c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[11];
        this.f13434a = recyclerView;
        recyclerView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.g = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.h = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.i = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.j = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.k = textView5;
        textView5.setTag(null);
        ((FragmentAttendanceInClassBinding) this).f13430b.setTag(null);
        this.d.setTag(null);
        ((FragmentAttendanceInClassBinding) this).f13428a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
