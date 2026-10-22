package com.huachenjie.sport.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.bean.AttendanceRecordBean;
import com.huachenjie.sport.bean.ClockRecordBean;
import com.huachenjie.sport.page.mine.attendance.AttendanceAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.ju3;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemAttendanceBindingImpl extends ItemAttendanceBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36489a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13523a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f13525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f13527a;

    @NonNull
    public final View b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceAdapter.a f36490a;

        public a a(AttendanceAdapter.a aVar) {
            this.f36490a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36490a.a(view);
        }
    }

    public ItemAttendanceBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f13523a, f36489a));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:103:0x0236  */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:41:0x0109  */
    /* JADX WARN: Code duplicated, block: B:46:0x0117  */
    /* JADX WARN: Code duplicated, block: B:51:0x0125  */
    /* JADX WARN: Code duplicated, block: B:54:0x012f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x0131  */
    /* JADX WARN: Code duplicated, block: B:56:0x0136  */
    /* JADX WARN: Code duplicated, block: B:59:0x013c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0143  */
    /* JADX WARN: Code duplicated, block: B:61:0x0145  */
    /* JADX WARN: Code duplicated, block: B:66:0x0154  */
    /* JADX WARN: Code duplicated, block: B:71:0x0164  */
    /* JADX WARN: Code duplicated, block: B:74:0x016e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x0171  */
    /* JADX WARN: Code duplicated, block: B:79:0x0175  */
    /* JADX WARN: Code duplicated, block: B:82:0x017a  */
    /* JADX WARN: Code duplicated, block: B:85:0x017e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0183  */
    /* JADX WARN: Code duplicated, block: B:91:0x0188  */
    /* JADX WARN: Code duplicated, block: B:94:0x018d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0191  */
    /* JADX WARN: Code duplicated, block: B:99:0x0197  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zShowEndClock;
        RequestOptions requestOptions;
        int statusBackground;
        String imgUrl;
        ClockRecordBean endRecord;
        boolean z;
        int i;
        String str;
        int i2;
        String str2;
        String str3;
        String str4;
        int i3;
        long j2;
        a aVarA;
        int textColor;
        int statusBackground2;
        int statusColor;
        String text;
        boolean z2;
        String location;
        int icon;
        String status;
        long j3;
        String str5;
        int i4;
        boolean zShowStartLocation;
        ClockRecordBean startRecord;
        synchronized (this) {
            j = this.f13524a;
            this.f13524a = 0L;
        }
        AttendanceRecordBean attendanceRecordBean = ((ItemAttendanceBinding) this).f13520a;
        AttendanceAdapter.a aVar = ((ItemAttendanceBinding) this).f13521a;
        long j4 = j & 5;
        if (j4 != 0) {
            RequestOptions requestOptions2 = ju3.h;
            if (attendanceRecordBean != null) {
                endRecord = attendanceRecordBean.getEndRecord();
                zShowStartLocation = attendanceRecordBean.showStartLocation();
                startRecord = attendanceRecordBean.getStartRecord();
                zShowEndClock = attendanceRecordBean.showEndClock();
            } else {
                zShowEndClock = false;
                endRecord = null;
                zShowStartLocation = false;
                startRecord = null;
            }
            if (j4 != 0) {
                j = zShowEndClock ? j | 16 | 64 | 256 | 1024 | 4096 | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH | 262144 : j | 8 | 32 | 128 | 512 | 2048 | 8192 | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | 131072;
            }
            imgUrl = endRecord != null ? endRecord.getImgUrl() : null;
            if (startRecord != null) {
                int icon2 = startRecord.getIcon();
                String imgUrl2 = startRecord.getImgUrl();
                int textColor2 = startRecord.getTextColor();
                String location2 = startRecord.getLocation();
                String status2 = startRecord.getStatus();
                String text2 = startRecord.getText();
                int statusColor2 = startRecord.getStatusColor();
                requestOptions = requestOptions2;
                z = zShowStartLocation;
                statusBackground = startRecord.getStatusBackground();
                i = icon2;
                str = imgUrl2;
                i2 = textColor2;
                str2 = location2;
                str3 = status2;
                str4 = text2;
                i3 = statusColor2;
            } else {
                requestOptions = requestOptions2;
                z = zShowStartLocation;
                statusBackground = 0;
            }
            j2 = j & 6;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
            } else {
                a aVar2 = this.f13526a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f13526a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if ((j & 262144) != 0 || endRecord == null) {
                textColor = 0;
            } else {
                textColor = endRecord.getTextColor();
            }
            if ((j & 256) != 0 || endRecord == null) {
                statusBackground2 = 0;
            } else {
                statusBackground2 = endRecord.getStatusBackground();
            }
            if ((j & 64) != 0 || endRecord == null) {
                statusColor = 0;
            } else {
                statusColor = endRecord.getStatusColor();
            }
            if ((1024 & j) != 0 || endRecord == null) {
                text = null;
            } else {
                text = endRecord.getText();
            }
            if ((j & 81920) != 0) {
                if (endRecord != null) {
                    location = endRecord.getLocation();
                } else {
                    location = null;
                }
                if ((PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH & j) != 0) {
                    z2 = !TextUtils.isEmpty(location);
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
                location = null;
            }
            if ((j & 16) != 0 || endRecord == null) {
                icon = 0;
            } else {
                icon = endRecord.getIcon();
            }
            if ((j & 4096) != 0 || endRecord == null) {
                status = null;
            } else {
                status = endRecord.getStatus();
            }
            j3 = j & 5;
            if (j3 != 0) {
                if (!zShowEndClock) {
                    icon = 0;
                }
                if (!zShowEndClock) {
                    statusColor = 0;
                }
                if (!zShowEndClock) {
                    statusBackground2 = 0;
                }
                if (!zShowEndClock) {
                    text = "";
                }
                if (!zShowEndClock) {
                    status = "";
                }
                if (!zShowEndClock) {
                    location = "";
                }
                if (!zShowEndClock) {
                    z2 = false;
                }
                if (!zShowEndClock) {
                    textColor = 0;
                }
                str5 = status;
                i4 = statusColor;
            } else {
                str5 = null;
                i4 = 0;
                z2 = false;
                icon = 0;
                textColor = 0;
                statusBackground2 = 0;
                text = null;
                location = null;
            }
            if (j3 != 0) {
                CommonBindingAdapter.a0(((ItemAttendanceBinding) this).f36488a, i);
                CommonBindingAdapter.a0(((ItemAttendanceBinding) this).b, icon);
                CommonBindingAdapter.l0(((ItemAttendanceBinding) this).b, zShowEndClock);
                CommonBindingAdapter.x(((ItemAttendanceBinding) this).f13519a, statusBackground2);
                CommonBindingAdapter.l0(((ItemAttendanceBinding) this).f13519a, zShowEndClock);
                TextViewBindingAdapter.setText(((ItemAttendanceBinding) this).f13519a, str5);
                ((ItemAttendanceBinding) this).f13519a.setTextColor(i4);
                CommonBindingAdapter.x(((ItemAttendanceBinding) this).f13522b, statusBackground);
                TextViewBindingAdapter.setText(((ItemAttendanceBinding) this).f13522b, str3);
                ((ItemAttendanceBinding) this).f13522b.setTextColor(i3);
                CommonBindingAdapter.l0(this.f13525a, zShowEndClock);
                String str6 = str;
                this.f13525a.setTag(str6);
                CommonBindingAdapter.l0(this.b, zShowEndClock);
                this.b.setTag(imgUrl);
                CommonBindingAdapter.b0(this.c, str6, requestOptions, false);
                CommonBindingAdapter.l0(this.d, zShowEndClock);
                CommonBindingAdapter.b0(this.d, imgUrl, requestOptions, false);
                CommonBindingAdapter.l0(super.c, z2);
                TextViewBindingAdapter.setText(super.c, location);
                CommonBindingAdapter.l0(super.d, zShowEndClock);
                TextViewBindingAdapter.setText(super.d, text);
                super.d.setTextColor(textColor);
                CommonBindingAdapter.l0(this.e, z);
                TextViewBindingAdapter.setText(this.e, str2);
                TextViewBindingAdapter.setText(this.f, str4);
                this.f.setTextColor(i2);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.f13525a, aVarA, null);
                CommonBindingAdapter.q(this.b, aVarA, null);
            }
        }
        zShowEndClock = false;
        requestOptions = null;
        statusBackground = 0;
        imgUrl = null;
        endRecord = null;
        z = false;
        i = 0;
        str = null;
        i2 = 0;
        str2 = null;
        str3 = null;
        str4 = null;
        i3 = 0;
        j2 = j & 6;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if ((j & 262144) != 0) {
            textColor = 0;
        } else {
            textColor = 0;
        }
        if ((j & 256) != 0) {
            statusBackground2 = 0;
        } else {
            statusBackground2 = 0;
        }
        if ((j & 64) != 0) {
            statusColor = 0;
        } else {
            statusColor = 0;
        }
        if ((1024 & j) != 0) {
            text = null;
        } else {
            text = null;
        }
        if ((j & 81920) != 0) {
            if (endRecord != null) {
                location = endRecord.getLocation();
            } else {
                location = null;
            }
            if ((PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH & j) != 0) {
                z2 = !TextUtils.isEmpty(location);
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
            location = null;
        }
        if ((j & 16) != 0) {
            icon = 0;
        } else {
            icon = 0;
        }
        if ((j & 4096) != 0) {
            status = null;
        } else {
            status = null;
        }
        j3 = j & 5;
        if (j3 != 0) {
            if (!zShowEndClock) {
                icon = 0;
            }
            if (!zShowEndClock) {
                statusColor = 0;
            }
            if (!zShowEndClock) {
                statusBackground2 = 0;
            }
            if (!zShowEndClock) {
                text = "";
            }
            if (!zShowEndClock) {
                status = "";
            }
            if (!zShowEndClock) {
                location = "";
            }
            if (!zShowEndClock) {
                z2 = false;
            }
            if (!zShowEndClock) {
                textColor = 0;
            }
            str5 = status;
            i4 = statusColor;
        } else {
            str5 = null;
            i4 = 0;
            z2 = false;
            icon = 0;
            textColor = 0;
            statusBackground2 = 0;
            text = null;
            location = null;
        }
        if (j3 != 0) {
            CommonBindingAdapter.a0(((ItemAttendanceBinding) this).f36488a, i);
            CommonBindingAdapter.a0(((ItemAttendanceBinding) this).b, icon);
            CommonBindingAdapter.l0(((ItemAttendanceBinding) this).b, zShowEndClock);
            CommonBindingAdapter.x(((ItemAttendanceBinding) this).f13519a, statusBackground2);
            CommonBindingAdapter.l0(((ItemAttendanceBinding) this).f13519a, zShowEndClock);
            TextViewBindingAdapter.setText(((ItemAttendanceBinding) this).f13519a, str5);
            ((ItemAttendanceBinding) this).f13519a.setTextColor(i4);
            CommonBindingAdapter.x(((ItemAttendanceBinding) this).f13522b, statusBackground);
            TextViewBindingAdapter.setText(((ItemAttendanceBinding) this).f13522b, str3);
            ((ItemAttendanceBinding) this).f13522b.setTextColor(i3);
            CommonBindingAdapter.l0(this.f13525a, zShowEndClock);
            String str7 = str;
            this.f13525a.setTag(str7);
            CommonBindingAdapter.l0(this.b, zShowEndClock);
            this.b.setTag(imgUrl);
            CommonBindingAdapter.b0(this.c, str7, requestOptions, false);
            CommonBindingAdapter.l0(this.d, zShowEndClock);
            CommonBindingAdapter.b0(this.d, imgUrl, requestOptions, false);
            CommonBindingAdapter.l0(super.c, z2);
            TextViewBindingAdapter.setText(super.c, location);
            CommonBindingAdapter.l0(super.d, zShowEndClock);
            TextViewBindingAdapter.setText(super.d, text);
            super.d.setTextColor(textColor);
            CommonBindingAdapter.l0(this.e, z);
            TextViewBindingAdapter.setText(this.e, str2);
            TextViewBindingAdapter.setText(this.f, str4);
            this.f.setTextColor(i2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f13525a, aVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13524a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13524a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemAttendanceBinding
    public void l(@Nullable AttendanceAdapter.a aVar) {
        ((ItemAttendanceBinding) this).f13521a = aVar;
        synchronized (this) {
            this.f13524a |= 2;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemAttendanceBinding
    public void m(@Nullable AttendanceRecordBean attendanceRecordBean) {
        ((ItemAttendanceBinding) this).f13520a = attendanceRecordBean;
        synchronized (this) {
            this.f13524a |= 1;
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
        if (ok0.p0 == i) {
            m((AttendanceRecordBean) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((AttendanceAdapter.a) obj);
        }
        return true;
    }

    public ItemAttendanceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ImageView) objArr[6], (TextView) objArr[8], (TextView) objArr[4], (TextView) objArr[10], (TextView) objArr[7], (TextView) objArr[3], (TextView) objArr[2]);
        this.f13524a = -1L;
        ((ItemAttendanceBinding) this).f36488a.setTag(null);
        ((ItemAttendanceBinding) this).b.setTag(null);
        ((ItemAttendanceBinding) this).f13519a.setTag(null);
        ((ItemAttendanceBinding) this).f13522b.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f13527a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        View view2 = (View) objArr[11];
        this.f13525a = view2;
        view2.setTag(null);
        View view3 = (View) objArr[12];
        this.b = view3;
        view3.setTag(null);
        ImageView imageView = (ImageView) objArr[5];
        this.c = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[9];
        this.d = imageView2;
        imageView2.setTag(null);
        super.c.setTag(null);
        super.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
