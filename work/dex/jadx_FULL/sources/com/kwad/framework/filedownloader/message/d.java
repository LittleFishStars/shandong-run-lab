package com.kwad.framework.filedownloader.message;

import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class d extends MessageSnapshot {

    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        public a(int i, boolean z, long j) {
            super(i, true, j);
        }
    }

    public static class e extends f {
        public e(int i, long j, long j2) {
            super(i, j, j2);
        }

        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) -2;
        }
    }

    public static class f extends d {
        private final long aCv;
        private final long totalBytes;

        public f(f fVar) {
            this(fVar.getId(), fVar.CO(), fVar.CM());
        }

        public byte AH() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long CM() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long CO() {
            return this.aCv;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aCv);
            parcel.writeLong(this.totalBytes);
        }

        public f(int i, long j, long j2) {
            super(i);
            this.aCv = j;
            this.totalBytes = j2;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.aCv = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }
    }

    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        public i(int i, long j, long j2) {
            super(i, j, j2);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        public j(int i, long j, long j2) {
            super(i, j, j2);
        }

        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) -4;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot CQ() {
            return new f(this);
        }

        public j(Parcel parcel) {
            super(parcel);
        }
    }

    public d(int i2) {
        super(i2);
        this.aCx = true;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int CK() {
        if (CO() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) CO();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int CL() {
        if (CM() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) CM();
    }

    public static class g extends d {
        private final long aCv;

        public g(int i, long j) {
            super(i);
            this.aCv = j;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long CO() {
            return this.aCv;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aCv);
        }

        public g(Parcel parcel) {
            super(parcel);
            this.aCv = parcel.readLong();
        }
    }

    public static class h extends C1260d {
        private final int aCc;

        public h(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.aCc = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C1260d, com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int AL() {
            return this.aCc;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C1260d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C1260d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aCc);
        }

        public h(Parcel parcel) {
            super(parcel);
            this.aCc = parcel.readInt();
        }
    }

    public static class b extends d {
        private final boolean aCt;
        private final long totalBytes;

        public b(int i, boolean z, long j) {
            super(i);
            this.aCt = z;
            this.totalBytes = j;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) -3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long CM() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean CN() {
            return this.aCt;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aCt ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.aCt = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }
    }

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.message.d$d, reason: collision with other inner class name */
    public static class C1260d extends d {
        private final long aCv;
        private final Throwable aCw;

        public C1260d(int i, long j, Throwable th) {
            super(i);
            this.aCv = j;
            this.aCw = th;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public byte AH() {
            return (byte) -1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long CO() {
            return this.aCv;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable CP() {
            return this.aCw;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aCv);
            parcel.writeSerializable(this.aCw);
        }

        public C1260d(Parcel parcel) {
            super(parcel);
            this.aCv = parcel.readLong();
            this.aCw = (Throwable) parcel.readSerializable();
        }
    }

    public d(Parcel parcel) {
        super(parcel);
    }

    public static class c extends d {
        private final String aAR;
        private final boolean aCu;
        private final String fileName;
        private final long totalBytes;

        public c(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.aCu = z;
            this.totalBytes = j;
            this.aAR = str;
            this.fileName = str2;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean CC() {
            return this.aCu;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long CM() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.aAR;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.fileName;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aCu ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.aAR);
            parcel.writeString(this.fileName);
        }

        public c(Parcel parcel) {
            super(parcel);
            this.aCu = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
            this.aAR = parcel.readString();
            this.fileName = parcel.readString();
        }
    }
}
