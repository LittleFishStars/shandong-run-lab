package com.kwad.framework.filedownloader.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.framework.filedownloader.d.b.1
        private static b[] cU(int i) {
            return new b[i];
        }

        private static b d(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i) {
            return cU(i);
        }
    };
    private HashMap<String, List<String>> aCJ;

    public b() {
    }

    public final void A(String str, String str2) {
        az.hY(str);
        az.hY(str2);
        if (this.aCJ == null) {
            this.aCJ = new HashMap<>();
        }
        List<String> arrayList = this.aCJ.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.aCJ.put(str, arrayList);
        }
        if (arrayList.contains(str2)) {
            return;
        }
        arrayList.add(str2);
    }

    public final HashMap<String, List<String>> CW() {
        return this.aCJ;
    }

    public final void cf(String str) {
        HashMap<String, List<String>> map = this.aCJ;
        if (map == null) {
            return;
        }
        map.remove(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.aCJ.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.aCJ);
    }

    public b(Parcel parcel) {
        this.aCJ = parcel.readHashMap(String.class.getClassLoader());
    }
}
