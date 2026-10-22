package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.zj.adlib.om6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new a();
    public final List<c> events;

    public class a implements Parcelable.Creator<SpliceScheduleCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30780a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f3480a;

        public /* synthetic */ b(int i, long j, a aVar) {
            this(i, j);
        }

        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        public final void d(Parcel parcel) {
            parcel.writeInt(this.f30780a);
            parcel.writeLong(this.f3480a);
        }

        public b(int i, long j) {
            this.f30780a = i;
            this.f3480a = j;
        }
    }

    public /* synthetic */ SpliceScheduleCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static SpliceScheduleCommand parseFromSection(om6 om6Var) {
        int iG = om6Var.G();
        ArrayList arrayList = new ArrayList(iG);
        for (int i = 0; i < iG; i++) {
            arrayList.add(c.e(om6Var));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.events.get(i2).f(parcel);
        }
    }

    private SpliceScheduleCommand(List<c> list) {
        this.events = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(c.d(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30781a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f3481a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<b> f3482a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3483a;
        public final int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final long f3484b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final boolean f3485b;
        public final int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public final long f3486c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public final boolean f3487c;
        public final boolean d;

        public c(long j, boolean z, boolean z2, boolean z3, List<b> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.f3481a = j;
            this.f3483a = z;
            this.f3485b = z2;
            this.f3487c = z3;
            this.f3482a = Collections.unmodifiableList(list);
            this.f3484b = j2;
            this.d = z4;
            this.f3486c = j3;
            this.f30781a = i;
            this.b = i2;
            this.c = i3;
        }

        public static c d(Parcel parcel) {
            return new c(parcel);
        }

        public static c e(om6 om6Var) {
            ArrayList arrayList;
            boolean z;
            long j;
            boolean z2;
            long j2;
            int i;
            int i2;
            int iG;
            boolean z3;
            boolean z4;
            long jI;
            long jI2 = om6Var.I();
            boolean z5 = (om6Var.G() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z5) {
                arrayList = arrayList2;
                z = false;
                j = -9223372036854775807L;
                z2 = false;
                j2 = -9223372036854775807L;
                i = 0;
                i2 = 0;
                iG = 0;
                z3 = false;
            } else {
                int iG2 = om6Var.G();
                boolean z6 = (iG2 & 128) != 0;
                boolean z7 = (iG2 & 64) != 0;
                boolean z8 = (iG2 & 32) != 0;
                long jI3 = z7 ? om6Var.I() : -9223372036854775807L;
                if (!z7) {
                    int iG3 = om6Var.G();
                    ArrayList arrayList3 = new ArrayList(iG3);
                    for (int i3 = 0; i3 < iG3; i3++) {
                        arrayList3.add(new b(om6Var.G(), om6Var.I(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long jG = om6Var.G();
                    boolean z9 = (128 & jG) != 0;
                    jI = ((((jG & 1) << 32) | om6Var.I()) * 1000) / 90;
                    z4 = z9;
                } else {
                    z4 = false;
                    jI = -9223372036854775807L;
                }
                int iM = om6Var.M();
                int iG4 = om6Var.G();
                z3 = z7;
                iG = om6Var.G();
                j2 = jI;
                arrayList = arrayList2;
                long j3 = jI3;
                i = iM;
                i2 = iG4;
                j = j3;
                boolean z10 = z6;
                z2 = z4;
                z = z10;
            }
            return new c(jI2, z5, z, z3, arrayList, j, z2, j2, i, i2, iG);
        }

        public final void f(Parcel parcel) {
            parcel.writeLong(this.f3481a);
            parcel.writeByte(this.f3483a ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f3485b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f3487c ? (byte) 1 : (byte) 0);
            int size = this.f3482a.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                this.f3482a.get(i).d(parcel);
            }
            parcel.writeLong(this.f3484b);
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f3486c);
            parcel.writeInt(this.f30781a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
        }

        public c(Parcel parcel) {
            this.f3481a = parcel.readLong();
            this.f3483a = parcel.readByte() == 1;
            this.f3485b = parcel.readByte() == 1;
            this.f3487c = parcel.readByte() == 1;
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(b.c(parcel));
            }
            this.f3482a = Collections.unmodifiableList(arrayList);
            this.f3484b = parcel.readLong();
            this.d = parcel.readByte() == 1;
            this.f3486c = parcel.readLong();
            this.f30781a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
        }
    }
}
