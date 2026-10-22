package com.alibaba.ariver.resource.api.prepare;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class PrepareException extends Exception implements Parcelable {
    public static final Parcelable.Creator<PrepareException> CREATOR = new Parcelable.Creator<PrepareException>() { // from class: com.alibaba.ariver.resource.api.prepare.PrepareException.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrepareException createFromParcel(Parcel parcel) {
            return new PrepareException(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrepareException[] newArray(int i) {
            return new PrepareException[i];
        }
    };
    public static final String ERROR_APPX_CHECK_FAILED = "7";
    public static final String ERROR_AUTH_FAIL = "8";
    public static final String ERROR_DOWNLOAD_EXCEPTION = "4";
    public static final String ERROR_NO_APPINFO = "1";
    public static final String ERROR_NO_URL = "6";
    public static final String ERROR_RPC_EXCEPTION = "2";
    public static final String ERROR_TIMEOUT = "3";
    public static final String ERROR_UNKNOWN = "0";
    public static final String ERROR_UNZIP_EXCEPTION = "5";
    private String code;
    private boolean needShowFail;
    private String stage;

    public PrepareException(String str) {
        this("0", str, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.code;
    }

    public String getStage() {
        return this.stage;
    }

    public boolean isNeedShowFail() {
        return this.needShowFail;
    }

    public void setNeedShowFail(boolean z) {
        this.needShowFail = z;
    }

    public void setStage(String str) {
        this.stage = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.code);
    }

    public PrepareException(String str, String str2) {
        this(str, str2, null);
    }

    public PrepareException(String str, String str2, Throwable th) {
        super(str2, th);
        this.code = str;
        str.hashCode();
        switch (str) {
            case "2":
            case "3":
            case "4":
            case "5":
                this.needShowFail = true;
                break;
        }
    }

    public PrepareException(Parcel parcel) {
        this.code = parcel.readString();
    }
}
