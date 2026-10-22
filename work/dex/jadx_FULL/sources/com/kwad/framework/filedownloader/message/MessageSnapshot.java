package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class MessageSnapshot implements Parcelable, c {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new Parcelable.Creator<MessageSnapshot>() { // from class: com.kwad.framework.filedownloader.message.MessageSnapshot.1
        /* JADX WARN: Code duplicated, block: B:46:0x0094  */
        /* JADX WARN: Code duplicated, block: B:48:0x0097  */
        /* JADX WARN: Instruction removed from duplicated block: B:48:0x0097, please report this as an issue */
        private static MessageSnapshot c(Parcel parcel) {
            MessageSnapshot jVar;
            MessageSnapshot messageSnapshot;
            boolean z = parcel.readByte() == 1;
            byte b2 = parcel.readByte();
            if (b2 == -4) {
                jVar = z ? new d.j(parcel) : new h.j(parcel);
            } else if (b2 == -3) {
                jVar = z ? new d.b(parcel) : new h.b(parcel);
            } else if (b2 == -1) {
                jVar = z ? new d.C1260d(parcel) : new h.d(parcel);
            } else if (b2 == 1) {
                jVar = z ? new d.f(parcel) : new h.f(parcel);
            } else if (b2 == 2) {
                jVar = z ? new d.c(parcel) : new h.c(parcel);
            } else if (b2 == 3) {
                jVar = z ? new d.g(parcel) : new h.g(parcel);
            } else {
                if (b2 != 5) {
                    if (b2 != 6) {
                        messageSnapshot = null;
                    } else {
                        jVar = new b(parcel);
                    }
                    if (messageSnapshot != null) {
                        messageSnapshot.aCx = z;
                        return messageSnapshot;
                    }
                    throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) b2));
                }
                jVar = z ? new d.h(parcel) : new h.C1261h(parcel);
            }
            messageSnapshot = jVar;
            if (messageSnapshot != null) {
                messageSnapshot.aCx = z;
                return messageSnapshot;
            }
            throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) b2));
        }

        private static MessageSnapshot[] cS(int i) {
            return new MessageSnapshot[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot[] newArray(int i) {
            return cS(i);
        }
    };
    protected boolean aCx;
    private final int id;

    public static class NoFieldException extends IllegalStateException {
        public NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(com.kwad.framework.filedownloader.f.f.c("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.AH()), messageSnapshot.getClass().getName()));
        }
    }

    public interface a {
        MessageSnapshot CQ();
    }

    public static class b extends MessageSnapshot {
        public b(int i) {
            super(i);
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 6;
        }

        public b(Parcel parcel) {
            super(parcel);
        }
    }

    public MessageSnapshot(int i) {
        this.id = i;
    }

    public int AL() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public final boolean AN() {
        return this.aCx;
    }

    public boolean CC() {
        throw new NoFieldException("isResuming", this);
    }

    public int CK() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int CL() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public long CM() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public boolean CN() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    public long CO() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public Throwable CP() {
        throw new NoFieldException("getThrowable", this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEtag() {
        throw new NoFieldException("getEtag", this);
    }

    public String getFileName() {
        throw new NoFieldException("getFileName", this);
    }

    public final int getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.aCx ? (byte) 1 : (byte) 0);
        parcel.writeByte(AH());
        parcel.writeInt(this.id);
    }

    public MessageSnapshot(Parcel parcel) {
        this.id = parcel.readInt();
    }
}
