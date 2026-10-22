package com.alibaba.ariver.kernel.ipc;

import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IpcMessage implements Parcelable {
    public static final Parcelable.Creator<IpcMessage> CREATOR = new Parcelable.Creator<IpcMessage>() { // from class: com.alibaba.ariver.kernel.ipc.IpcMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpcMessage createFromParcel(Parcel parcel) {
            return new IpcMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpcMessage[] newArray(int i) {
            return new IpcMessage[i];
        }
    };
    public String biz;
    public Message bizMsg;
    public String clientId;
    public int lpid;
    public int pid;

    public IpcMessage() {
    }

    public static byte[] marshall(IpcMessage ipcMessage) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeValue(ipcMessage);
            return parcelObtain.marshall();
        } catch (Exception e) {
            RVLogger.e(RVConstants.TAG, "IpcMsg marshall error " + Log.getStackTraceString(e));
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    public static IpcMessage unmarshall(byte[] bArr) {
        IpcMessage ipcMessage = null;
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                IpcMessage ipcMessage2 = (IpcMessage) parcelObtain.readValue(IpcMessage.class.getClassLoader());
                parcelObtain.recycle();
                ipcMessage = ipcMessage2;
            } catch (Exception e) {
                RVLogger.e(RVConstants.TAG, "IpcMsg unmarshall error " + Log.getStackTraceString(e));
                parcelObtain.recycle();
            }
            return ipcMessage;
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.pid);
        parcel.writeInt(this.lpid);
        parcel.writeString(this.clientId);
        parcel.writeString(this.biz);
        parcel.writeParcelable(this.bizMsg, i);
    }

    public IpcMessage(Parcel parcel) {
        this.pid = parcel.readInt();
        this.lpid = parcel.readInt();
        this.clientId = parcel.readString();
        this.biz = parcel.readString();
        this.bizMsg = (Message) parcel.readParcelable(Message.class.getClassLoader());
    }
}
