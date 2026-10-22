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
import androidx.constraintlayout.widget.Barrier;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.base.widget.calendar.CalendarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.AttendanceAdapter;
import com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler;
import com.huachenjie.sport.page.mine.attendance.AttendanceSubVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentAttendanceOutClassBindingImpl extends FragmentAttendanceOutClassBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13456a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13458a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f13462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f13463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f13464a;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceClickHandler f36465a;

        public a a(AttendanceClickHandler attendanceClickHandler) {
            this.f36465a = attendanceClickHandler;
            if (attendanceClickHandler == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36465a.clickToday(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceClickHandler f36466a;

        public b a(AttendanceClickHandler attendanceClickHandler) {
            this.f36466a = attendanceClickHandler;
            if (attendanceClickHandler == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36466a.clickAttendancePlan(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceClickHandler f36467a;

        public c a(AttendanceClickHandler attendanceClickHandler) {
            this.f36467a = attendanceClickHandler;
            if (attendanceClickHandler == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36467a.clickPreMonth(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceClickHandler f36468a;

        public d a(AttendanceClickHandler attendanceClickHandler) {
            this.f36468a = attendanceClickHandler;
            if (attendanceClickHandler == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36468a.clickAttendanceRule(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceClickHandler f36469a;

        public e a(AttendanceClickHandler attendanceClickHandler) {
            this.f36469a = attendanceClickHandler;
            if (attendanceClickHandler == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36469a.clickNextMonth(view);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceClickHandler f36470a;

        public f a(AttendanceClickHandler attendanceClickHandler) {
            this.f36470a = attendanceClickHandler;
            if (attendanceClickHandler == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36470a.clickRefreshTapResult(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36464a = sparseIntArray;
        sparseIntArray.put(R.id.ll_attendance_container, 17);
        sparseIntArray.put(R.id.rl_attendance_count, 18);
        sparseIntArray.put(R.id.tv_attendance_semester, 19);
        sparseIntArray.put(R.id.tv_attendance_semester_unit, 20);
        sparseIntArray.put(R.id.iv_attendance_count_arrow, 21);
        sparseIntArray.put(R.id.ll_attendance_stats, 22);
        sparseIntArray.put(R.id.ivTap, 23);
        sparseIntArray.put(R.id.tvTapTitle, 24);
        sparseIntArray.put(R.id.barrierTapContent, 25);
        sparseIntArray.put(R.id.line, 26);
        sparseIntArray.put(R.id.calendarView, 27);
        sparseIntArray.put(R.id.tvClocked, 28);
        sparseIntArray.put(R.id.line_bottom, 29);
    }

    public FragmentAttendanceOutClassBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 30, f13456a, f36464a));
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0184  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:28:0x006c  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        String str2;
        String str3;
        AttendanceAdapter attendanceAdapter;
        String str4;
        int i;
        boolean z2;
        String str5;
        int i2;
        int i3;
        String str6;
        String str7;
        String str8;
        String str9;
        int i4;
        b bVar;
        e eVarA;
        c cVar;
        a aVar;
        f fVar;
        d dVar;
        AttendanceAdapter value;
        int iS;
        int iR;
        String strQ;
        int i5;
        String str10;
        boolean zSafeUnbox;
        String str11;
        String str12;
        int i6;
        String str13;
        String value2;
        String str14;
        String value3;
        boolean zSafeUnbox2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f13457a;
            this.f13457a = 0L;
        }
        AttendanceSubVM attendanceSubVM = ((FragmentAttendanceOutClassBinding) this).f13445a;
        AttendanceClickHandler attendanceClickHandler = ((FragmentAttendanceOutClassBinding) this).f13444a;
        if ((12287 & j) != 0) {
            if ((j & 10241) == 0) {
                value = null;
            } else {
                MutableLiveData<AttendanceAdapter> mutableLiveDataE = attendanceSubVM != null ? attendanceSubVM.E() : null;
                updateLiveDataRegistration(0, mutableLiveDataE);
                if (mutableLiveDataE != null) {
                    value = mutableLiveDataE.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 10242) == 0) {
                iS = 0;
                iR = 0;
                strQ = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataP = attendanceSubVM != null ? attendanceSubVM.p() : null;
                updateLiveDataRegistration(1, mutableLiveDataP);
                Integer value4 = mutableLiveDataP != null ? mutableLiveDataP.getValue() : null;
                if (attendanceSubVM != null) {
                    iS = attendanceSubVM.s(value4);
                    iR = attendanceSubVM.r(value4);
                    strQ = attendanceSubVM.q(value4);
                } else {
                    iS = 0;
                    iR = 0;
                    strQ = null;
                }
            }
            long j4 = j & 10244;
            if (j4 != 0) {
                MutableLiveData<Integer> mutableLiveDataB = attendanceSubVM != null ? attendanceSubVM.B() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                Integer value5 = mutableLiveDataB != null ? mutableLiveDataB.getValue() : null;
                str10 = String.format(TimeModel.NUMBER_FORMAT, value5);
                boolean z3 = ViewDataBinding.safeUnbox(value5) == 0;
                if (j4 != 0) {
                    j |= z3 ? 131072L : PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                }
                i5 = z3 ? -3355444 : -35281;
            } else {
                i5 = 0;
                str10 = null;
            }
            if ((j & 10248) != 0) {
                MutableLiveData<Boolean> mutableLiveDataK = attendanceSubVM != null ? attendanceSubVM.K() : null;
                updateLiveDataRegistration(3, mutableLiveDataK);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataK != null ? mutableLiveDataK.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            long j5 = j & 10256;
            if (j5 != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = attendanceSubVM != null ? attendanceSubVM.m() : null;
                updateLiveDataRegistration(4, mutableLiveDataM);
                boolean zSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
                if (j5 != 0) {
                    if (zSafeUnbox3) {
                        j2 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        j3 = 2097152;
                    } else {
                        j2 = j | PlaybackStateCompat.ACTION_PREPARE | 262144;
                        j3 = 1048576;
                    }
                    j = j2 | j3;
                }
                i6 = zSafeUnbox3 ? -12858007 : -3355444;
                str12 = zSafeUnbox3 ? "已绑定" : "未绑定";
                str11 = zSafeUnbox3 ? "手动刷新碰一碰结果" : "前往支付宝绑定账号";
            } else {
                str11 = null;
                str12 = null;
                i6 = 0;
            }
            if ((j & 10272) != 0) {
                MutableLiveData<Integer> mutableLiveDataN = attendanceSubVM != null ? attendanceSubVM.N() : null;
                updateLiveDataRegistration(5, mutableLiveDataN);
                str13 = String.format(TimeModel.NUMBER_FORMAT, mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
            } else {
                str13 = null;
            }
            if ((j & 10304) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataO = attendanceSubVM != null ? attendanceSubVM.o() : null;
                updateLiveDataRegistration(6, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value2 = mutableLiveDataO.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 10368) != 0) {
                MutableLiveData<Integer> mutableLiveDataV = attendanceSubVM != null ? attendanceSubVM.v() : null;
                updateLiveDataRegistration(7, mutableLiveDataV);
                str14 = String.format(TimeModel.NUMBER_FORMAT, mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                str14 = null;
            }
            if ((j & 10496) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataZ = attendanceSubVM != null ? attendanceSubVM.z() : null;
                updateLiveDataRegistration(8, mutableLiveDataZ);
                if (mutableLiveDataZ != null) {
                    value3 = mutableLiveDataZ.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 10752) != 0) {
                MutableLiveData<Boolean> mutableLiveDataJ = attendanceSubVM != null ? attendanceSubVM.J() : null;
                updateLiveDataRegistration(9, mutableLiveDataJ);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null);
            } else {
                str14 = str14;
                zSafeUnbox2 = false;
            }
            if ((j & 11264) != 0) {
                MutableLiveData<String> mutableLiveDataL = attendanceSubVM != null ? attendanceSubVM.L() : null;
                updateLiveDataRegistration(10, mutableLiveDataL);
                String value6 = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                StringBuilder sb = new StringBuilder();
                sb.append("请在");
                sb.append(value6);
                String str15 = sb.toString() + "设备处碰一碰，完成后手动刷新结果";
                str = str13;
                j = j;
                int i7 = iR;
                str7 = str15;
                z = zSafeUnbox;
                i3 = i5;
                str5 = strQ;
                i = i7;
                String str16 = value3;
                str3 = value2;
                str2 = str14;
                str9 = str11;
                attendanceAdapter = value;
                i4 = i6;
                str8 = str12;
                str4 = str16;
                String str17 = str10;
                i2 = iS;
                z2 = zSafeUnbox2;
                str6 = str17;
            } else {
                z = zSafeUnbox;
                str = str13;
                i3 = i5;
                str5 = strQ;
                i = iR;
                str7 = null;
                String str18 = value3;
                str3 = value2;
                str2 = str14;
                str9 = str11;
                attendanceAdapter = value;
                i4 = i6;
                str8 = str12;
                str4 = str18;
                String str19 = str10;
                i2 = iS;
                z2 = zSafeUnbox2;
                str6 = str19;
            }
        } else {
            z = false;
            str = null;
            str2 = null;
            str3 = null;
            attendanceAdapter = null;
            str4 = null;
            i = 0;
            z2 = false;
            str5 = null;
            i2 = 0;
            i3 = 0;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            i4 = 0;
        }
        long j6 = j & 12288;
        if (j6 == 0 || attendanceClickHandler == null) {
            bVar = null;
            eVarA = null;
            cVar = null;
            aVar = null;
            fVar = null;
            dVar = null;
        } else {
            f fVar2 = this.f13464a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f13464a = fVar2;
            }
            f fVarA = fVar2.a(attendanceClickHandler);
            a aVar2 = this.f13459a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13459a = aVar2;
            }
            a aVarA = aVar2.a(attendanceClickHandler);
            b bVar2 = this.f13460a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f13460a = bVar2;
            }
            b bVarA = bVar2.a(attendanceClickHandler);
            c cVar2 = this.f13461a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f13461a = cVar2;
            }
            c cVarA = cVar2.a(attendanceClickHandler);
            d dVar2 = this.f13462a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f13462a = dVar2;
            }
            d dVarA = dVar2.a(attendanceClickHandler);
            e eVar = this.f13463a;
            if (eVar == null) {
                eVar = new e();
                this.f13463a = eVar;
            }
            eVarA = eVar.a(attendanceClickHandler);
            cVar = cVarA;
            aVar = aVarA;
            dVar = dVarA;
            bVar = bVarA;
            fVar = fVarA;
        }
        if ((j & 10248) != 0) {
            CommonBindingAdapter.l0(((FragmentAttendanceOutClassBinding) this).f13446a, z);
        }
        if (j6 != 0) {
            CommonBindingAdapter.q(((FragmentAttendanceOutClassBinding) this).f13449b, eVarA, null);
            CommonBindingAdapter.q(((FragmentAttendanceOutClassBinding) this).c, cVar, null);
            CommonBindingAdapter.q(((FragmentAttendanceOutClassBinding) this).f13439a, bVar, null);
            CommonBindingAdapter.q(((FragmentAttendanceOutClassBinding) this).e, dVar, null);
            CommonBindingAdapter.q(((FragmentAttendanceOutClassBinding) this).f13448a, fVar, null);
            CommonBindingAdapter.q(((FragmentAttendanceOutClassBinding) this).f13452b, aVar, null);
        }
        if ((j & 10752) != 0) {
            CommonBindingAdapter.l0(((FragmentAttendanceOutClassBinding) this).f13439a, z2);
            CommonBindingAdapter.l0(((FragmentAttendanceOutClassBinding) this).e, z2);
        }
        if ((j & 10241) != 0) {
            CommonBindingAdapter.g(this.f13458a, attendanceAdapter, false, false);
        }
        if ((j & 10304) != 0) {
            TextViewBindingAdapter.setText(this.j, str3);
        }
        if ((10368 & j) != 0) {
            TextViewBindingAdapter.setText(this.k, str2);
        }
        if ((j & 10244) != 0) {
            TextViewBindingAdapter.setText(this.l, str6);
            this.l.setTextColor(i3);
        }
        if ((j & 10242) != 0) {
            CommonBindingAdapter.x(((FragmentAttendanceOutClassBinding) this).f13441a, i);
            TextViewBindingAdapter.setText(((FragmentAttendanceOutClassBinding) this).f13441a, str5);
            ((FragmentAttendanceOutClassBinding) this).f13441a.setTextColor(i2);
        }
        if ((10272 & j) != 0) {
            TextViewBindingAdapter.setText(((FragmentAttendanceOutClassBinding) this).f13453c, str);
        }
        if ((10496 & j) != 0) {
            TextViewBindingAdapter.setText(((FragmentAttendanceOutClassBinding) this).f13455e, str4);
        }
        if ((j & 10256) != 0) {
            TextViewBindingAdapter.setText(((FragmentAttendanceOutClassBinding) this).f13448a, str9);
            TextViewBindingAdapter.setText(this.g, str8);
            DrawablesBindingAdapter.h(this.g, 0, Integer.valueOf(i4), 0, 0.0f, 0.0f, 0.0f, 9.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if ((j & 11264) != 0) {
            TextViewBindingAdapter.setText(this.h, str7);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13457a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13457a = 8192L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentAttendanceOutClassBinding
    public void l(@Nullable AttendanceClickHandler attendanceClickHandler) {
        ((FragmentAttendanceOutClassBinding) this).f13444a = attendanceClickHandler;
        synchronized (this) {
            this.f13457a |= 4096;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentAttendanceOutClassBinding
    public void m(@Nullable AttendanceSubVM attendanceSubVM) {
        ((FragmentAttendanceOutClassBinding) this).f13445a = attendanceSubVM;
        synchronized (this) {
            this.f13457a |= 2048;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13457a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13457a |= 64;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return t((MutableLiveData) obj, i2);
            case 1:
                return p((MutableLiveData) obj, i2);
            case 2:
                return s((MutableLiveData) obj, i2);
            case 3:
                return v((MutableLiveData) obj, i2);
            case 4:
                return n((MutableLiveData) obj, i2);
            case 5:
                return x((MutableLiveData) obj, i2);
            case 6:
                return o((MutableLiveData) obj, i2);
            case 7:
                return q((MutableLiveData) obj, i2);
            case 8:
                return r((MutableLiveData) obj, i2);
            case 9:
                return u((MutableLiveData) obj, i2);
            case 10:
                return w((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13457a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13457a |= 128;
        }
        return true;
    }

    public final boolean r(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13457a |= 256;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13457a |= 4;
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
            this.f13457a |= 1;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13457a |= 512;
        }
        return true;
    }

    public final boolean v(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13457a |= 8;
        }
        return true;
    }

    public final boolean w(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13457a |= 1024;
        }
        return true;
    }

    public final boolean x(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13457a |= 32;
        }
        return true;
    }

    public FragmentAttendanceOutClassBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 11, (Barrier) objArr[25], (CalendarView) objArr[27], (BLConstraintLayout) objArr[8], (ImageView) objArr[21], (ImageView) objArr[14], (ImageView) objArr[13], (ImageView) objArr[23], (View) objArr[26], (View) objArr[29], (BLLinearLayout) objArr[17], (LinearLayout) objArr[1], (ImageView) objArr[4], (LinearLayout) objArr[22], (RelativeLayout) objArr[18], (TextView) objArr[2], (TextView) objArr[19], (TextView) objArr[5], (TextView) objArr[20], (TextView) objArr[12], (TextView) objArr[28], (BLTextView) objArr[11], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[24], (BLTextView) objArr[15]);
        this.f13457a = -1L;
        ((FragmentAttendanceOutClassBinding) this).f13446a.setTag(null);
        ((FragmentAttendanceOutClassBinding) this).f13449b.setTag(null);
        ((FragmentAttendanceOutClassBinding) this).c.setTag(null);
        ((FragmentAttendanceOutClassBinding) this).f13439a.setTag(null);
        ((FragmentAttendanceOutClassBinding) this).e.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.c = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[16];
        this.f13458a = recyclerView;
        recyclerView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.j = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.k = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[7];
        this.l = textView3;
        textView3.setTag(null);
        ((FragmentAttendanceOutClassBinding) this).f13441a.setTag(null);
        ((FragmentAttendanceOutClassBinding) this).f13453c.setTag(null);
        ((FragmentAttendanceOutClassBinding) this).f13455e.setTag(null);
        ((FragmentAttendanceOutClassBinding) this).f13448a.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        ((FragmentAttendanceOutClassBinding) this).f13452b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
