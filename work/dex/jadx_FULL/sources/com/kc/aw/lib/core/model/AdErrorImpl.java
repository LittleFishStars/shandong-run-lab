package com.kc.aw.lib.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kc.aw._jf;
import com.kc.aw._mm;
import com.kc.aw.lib.model.AdError;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdErrorImpl implements AdError, Parcelable {
    public static final Parcelable.Creator<AdErrorImpl> CREATOR = new _a();
    public int _a;
    public String _b;
    public String _c;
    public int _d;
    public String _e;
    public Throwable _f;

    @Keep
    public final class _a implements Parcelable.Creator<AdErrorImpl> {
        @Override // android.os.Parcelable.Creator
        public final AdErrorImpl createFromParcel(Parcel parcel) {
            AdErrorImpl adErrorImpl = new AdErrorImpl();
            adErrorImpl._c = parcel.readString();
            adErrorImpl._a = parcel.readInt();
            adErrorImpl._b = parcel.readString();
            adErrorImpl._f = (Throwable) parcel.readSerializable();
            adErrorImpl._d = parcel.readInt();
            adErrorImpl._e = parcel.readString();
            return adErrorImpl;
        }

        @Override // android.os.Parcelable.Creator
        public final AdErrorImpl[] newArray(int i) {
            return new AdErrorImpl[i];
        }
    }

    public AdErrorImpl() {
        this(0, "");
    }

    public AdErrorImpl(int i, String str) {
        this(i, str, 0);
    }

    public AdErrorImpl(int i, String str, int i2) {
        this(i, str, (Object) null);
    }

    public AdErrorImpl(int i, String str, Object obj) {
        this._a = i;
        this._b = str;
        this._f = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.kc.aw.lib.model.AdError
    public final int getConsumerErrCode() {
        return this._d;
    }

    @Override // com.kc.aw.lib.model.AdError
    public final String getConsumerErrMsg() {
        return this._e;
    }

    @Override // com.kc.aw.lib.model.AdError
    public final String getConsumerType() {
        return this._c;
    }

    @Override // com.kc.aw.lib.model.AdError
    public final int getErrorCode() {
        return this._a;
    }

    @Override // com.kc.aw.lib.model.AdError
    public final String getMessage() {
        return this._b;
    }

    @Override // com.kc.aw.lib.model.AdError
    public final Throwable getThrowable() {
        return this._f;
    }

    public final String toString() {
        StringBuilder sb_a = _jf._a("AdErrorImpl{errorCode=");
        sb_a.append(this._a);
        sb_a.append(", message='");
        StringBuilder sb_a2 = _mm._a(_mm._a(sb_a, this._b, '\'', ", consumerType='"), this._c, '\'', ", consumerErrCode=");
        sb_a2.append(this._d);
        sb_a2.append(", consumerErrMsg='");
        sb_a2.append(this._e);
        sb_a2.append('\'');
        sb_a2.append('}');
        return sb_a2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeInt(this._a);
            parcel.writeString(this._b);
            parcel.writeSerializable(this._f);
            parcel.writeInt(this._d);
            parcel.writeString(this._e);
        }
    }
}
