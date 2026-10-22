package com.alibaba.ariver.resource.api.appinfo;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UpdateAppException extends RuntimeException implements Parcelable {
    public static final Parcelable.Creator<UpdateAppException> CREATOR = new Parcelable.Creator<UpdateAppException>() { // from class: com.alibaba.ariver.resource.api.appinfo.UpdateAppException.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateAppException createFromParcel(Parcel parcel) {
            return new UpdateAppException(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateAppException[] newArray(int i) {
            return new UpdateAppException[i];
        }
    };
    public static final String ERROR_NO_APPINFO = "1";
    public static final String ERROR_UNKNOWN = "0";
    private String code;

    @Nullable
    private Map<String, String> extras;
    private boolean needShowError;

    public UpdateAppException(String str, String str2) {
        this(str, str2, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.code;
    }

    @Nullable
    public Map<String, String> getExtras() {
        return this.extras;
    }

    public boolean isNeedShowError() {
        return this.needShowError;
    }

    public void setNeedShowError(boolean z) {
        this.needShowError = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.code);
        int i2 = this.extras != null ? 1 : 0;
        parcel.writeByte((byte) i2);
        if (i2 != 0) {
            parcel.writeMap(this.extras);
        }
        parcel.writeByte(this.needShowError ? (byte) 1 : (byte) 0);
    }

    public UpdateAppException(String str, String str2, @Nullable Map<String, String> map) {
        super(str2);
        this.needShowError = true;
        this.code = str;
        this.extras = map;
    }

    public UpdateAppException(Parcel parcel) {
        this.extras = null;
        this.needShowError = true;
        this.code = parcel.readString();
        if (parcel.readByte() == 1) {
            parcel.readMap(this.extras, UpdateAppException.class.getClassLoader());
        }
        this.needShowError = parcel.readByte() == 1;
    }

    public UpdateAppException(Throwable th) {
        super(th);
        this.extras = null;
        this.needShowError = true;
        this.code = "0";
    }
}
