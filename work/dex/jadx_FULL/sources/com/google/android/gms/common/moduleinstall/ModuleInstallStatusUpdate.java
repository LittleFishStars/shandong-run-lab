package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.q3c;
import com.zj.adlib.yw6;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "ModuleInstallStatusUpdateCreator")
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new q3c();

    @SafeParcelable.Field(getter = "getSessionId", id = 1)
    private final int zaa;

    @InstallState
    @SafeParcelable.Field(getter = "getInstallState", id = 2)
    private final int zab;

    @Nullable
    @SafeParcelable.Field(getter = "getBytesDownloaded", id = 3)
    private final Long zac;

    @Nullable
    @SafeParcelable.Field(getter = "getTotalBytesToDownload", id = 4)
    private final Long zad;

    @SafeParcelable.Field(getter = "getErrorCode", id = 5)
    private final int zae;

    @Nullable
    private final a zaf;

    @Retention(RetentionPolicy.CLASS)
    public @interface InstallState {
        public static final int STATE_CANCELED = 3;
        public static final int STATE_COMPLETED = 4;
        public static final int STATE_DOWNLOADING = 2;
        public static final int STATE_DOWNLOAD_PAUSED = 7;
        public static final int STATE_FAILED = 5;
        public static final int STATE_INSTALLING = 6;
        public static final int STATE_PENDING = 1;
        public static final int STATE_UNKNOWN = 0;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f31304a;
        public final long b;

        public a(long j, long j2) {
            yw6.p(j2);
            this.f31304a = j;
            this.b = j2;
        }

        public long a() {
            return this.f31304a;
        }

        public long b() {
            return this.b;
        }
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    public ModuleInstallStatusUpdate(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) @InstallState int i2, @Nullable @SafeParcelable.Param(id = 3) Long l, @Nullable @SafeParcelable.Param(id = 4) Long l2, @SafeParcelable.Param(id = 5) int i3) {
        this.zaa = i;
        this.zab = i2;
        this.zac = l;
        this.zad = l2;
        this.zae = i3;
        this.zaf = (l == null || l2 == null || l2.longValue() == 0) ? null : new a(l.longValue(), l2.longValue());
    }

    public int getErrorCode() {
        return this.zae;
    }

    @InstallState
    public int getInstallState() {
        return this.zab;
    }

    @Nullable
    public a getProgressInfo() {
        return this.zaf;
    }

    public int getSessionId() {
        return this.zaa;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.F(parcel, 1, getSessionId());
        lu7.F(parcel, 2, getInstallState());
        lu7.N(parcel, 3, this.zac, false);
        lu7.N(parcel, 4, this.zad, false);
        lu7.F(parcel, 5, getErrorCode());
        lu7.b(parcel, iA);
    }
}
