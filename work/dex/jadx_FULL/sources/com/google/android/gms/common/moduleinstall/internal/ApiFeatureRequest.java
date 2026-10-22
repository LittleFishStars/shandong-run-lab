package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.zj.adlib.br5;
import com.zj.adlib.d2c;
import com.zj.adlib.i76;
import com.zj.adlib.lu7;
import com.zj.adlib.yw6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
@SafeParcelable.Class(creator = "ApiFeatureRequestCreator")
public class ApiFeatureRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new d2c();
    private static final Comparator zaa = new Comparator() { // from class: com.zj.adlib.f1c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Feature feature = (Feature) obj;
            Feature feature2 = (Feature) obj2;
            Parcelable.Creator<ApiFeatureRequest> creator = ApiFeatureRequest.CREATOR;
            return !feature.getName().equals(feature2.getName()) ? feature.getName().compareTo(feature2.getName()) : (feature.getVersion() > feature2.getVersion() ? 1 : (feature.getVersion() == feature2.getVersion() ? 0 : -1));
        }
    };

    @SafeParcelable.Field(getter = "getApiFeatures", id = 1)
    private final List zab;

    @SafeParcelable.Field(getter = "getIsUrgent", id = 2)
    private final boolean zac;

    @Nullable
    @SafeParcelable.Field(getter = "getFeatureRequestSessionId", id = 3)
    private final String zad;

    @Nullable
    @SafeParcelable.Field(getter = "getCallingPackage", id = 4)
    private final String zae;

    @SafeParcelable.Constructor
    public ApiFeatureRequest(@NonNull @SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) boolean z, @Nullable @SafeParcelable.Param(id = 3) String str, @Nullable @SafeParcelable.Param(id = 4) String str2) {
        yw6.l(list);
        this.zab = list;
        this.zac = z;
        this.zad = str;
        this.zae = str2;
    }

    @NonNull
    @KeepForSdk
    public static ApiFeatureRequest fromModuleInstallRequest(@NonNull br5 br5Var) {
        return zaa(br5Var.a(), true);
    }

    public static ApiFeatureRequest zaa(List list, boolean z) {
        TreeSet treeSet = new TreeSet(zaa);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Collections.addAll(treeSet, ((OptionalModuleApi) it.next()).g());
        }
        return new ApiFeatureRequest(new ArrayList(treeSet), z, null, null);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        return this.zac == apiFeatureRequest.zac && i76.b(this.zab, apiFeatureRequest.zab) && i76.b(this.zad, apiFeatureRequest.zad) && i76.b(this.zae, apiFeatureRequest.zae);
    }

    @NonNull
    @KeepForSdk
    public List<Feature> getApiFeatures() {
        return this.zab;
    }

    public final int hashCode() {
        return i76.c(Boolean.valueOf(this.zac), this.zab, this.zad, this.zae);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.d0(parcel, 1, getApiFeatures(), false);
        lu7.g(parcel, 2, this.zac);
        lu7.Y(parcel, 3, this.zad, false);
        lu7.Y(parcel, 4, this.zae, false);
        lu7.b(parcel, iA);
    }
}
