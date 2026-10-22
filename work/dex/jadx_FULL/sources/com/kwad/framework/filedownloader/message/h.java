package com.kwad.framework.filedownloader.message;

import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class h extends MessageSnapshot {

    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        public a(int i, boolean z, int i2) {
            super(i, true, i2);
        }
    }

    public static class e extends f {
        public e(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) -2;
        }
    }

    public static class f extends h {
        private final int aCH;
        private final int aCI;

        public f(f fVar) {
            this(fVar.getId(), fVar.CK(), fVar.CL());
        }

        public byte AH() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int CK() {
            return this.aCI;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int CL() {
            return this.aCH;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aCI);
            parcel.writeInt(this.aCH);
        }

        public f(int i, int i2, int i3) {
            super(i);
            this.aCI = i2;
            this.aCH = i3;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.aCI = parcel.readInt();
            this.aCH = parcel.readInt();
        }
    }

    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        public i(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        public j(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
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

    public h(int i2) {
        super(i2);
        this.aCx = false;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long CM() {
        return CL();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long CO() {
        return CK();
    }

    public static class g extends h {
        private final int aCI;

        public g(int i, int i2) {
            super(i);
            this.aCI = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int CK() {
            return this.aCI;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aCI);
        }

        public g(Parcel parcel) {
            super(parcel);
            this.aCI = parcel.readInt();
        }
    }

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.message.h$h, reason: collision with other inner class name */
    public static class C1261h extends d {
        private final int aCc;

        public C1261h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.aCc = i3;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int AL() {
            return this.aCc;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aCc);
        }

        public C1261h(Parcel parcel) {
            super(parcel);
            this.aCc = parcel.readInt();
        }
    }

    public static class b extends h {
        private final int aCH;
        private final boolean aCt;

        public b(int i, boolean z, int i2) {
            super(i);
            this.aCt = z;
            this.aCH = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) -3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int CL() {
            return this.aCH;
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
            parcel.writeInt(this.aCH);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.aCt = parcel.readByte() != 0;
            this.aCH = parcel.readInt();
        }
    }

    public static class d extends h {
        private final int aCI;
        private final Throwable aCw;

        public d(int i, int i2, Throwable th) {
            super(i);
            this.aCI = i2;
            this.aCw = th;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public byte AH() {
            return (byte) -1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int CK() {
            return this.aCI;
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
            parcel.writeInt(this.aCI);
            parcel.writeSerializable(this.aCw);
        }

        public d(Parcel parcel) {
            super(parcel);
            this.aCI = parcel.readInt();
            this.aCw = (Throwable) parcel.readSerializable();
        }
    }

    public h(Parcel parcel) {
        super(parcel);
    }

    public static class c extends h {
        private final String aAR;
        private final int aCH;
        private final boolean aCu;
        private final String fileName;

        public c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.aCu = z;
            this.aCH = i2;
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
        public final int CL() {
            return this.aCH;
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
            parcel.writeInt(this.aCH);
            parcel.writeString(this.aAR);
            parcel.writeString(this.fileName);
        }

        public c(Parcel parcel) {
            super(parcel);
            this.aCu = parcel.readByte() != 0;
            this.aCH = parcel.readInt();
            this.aAR = parcel.readString();
            this.fileName = parcel.readString();
        }
    }
}
