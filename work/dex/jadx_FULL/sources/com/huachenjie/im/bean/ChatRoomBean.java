package com.huachenjie.im.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatRoomBean implements Parcelable {
    public static final Parcelable.Creator<ChatRoomBean> CREATOR = new Parcelable.Creator<ChatRoomBean>() { // from class: com.huachenjie.im.bean.ChatRoomBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatRoomBean createFromParcel(Parcel parcel) {
            return new ChatRoomBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatRoomBean[] newArray(int i) {
            return new ChatRoomBean[i];
        }
    };
    private int muted;
    private String roomId;

    public ChatRoomBean(Parcel parcel) {
        this.roomId = parcel.readString();
        this.muted = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getMuted() {
        return this.muted;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setMuted(int i) {
        this.muted = i;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.roomId);
        parcel.writeInt(this.muted);
    }
}
