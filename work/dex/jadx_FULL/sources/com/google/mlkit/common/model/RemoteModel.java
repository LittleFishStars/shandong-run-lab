package com.google.mlkit.common.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import com.zj.adlib.dvd;
import com.zj.adlib.i76;
import com.zj.adlib.l7c;
import com.zj.adlib.yw6;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class RemoteModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f32450a = new EnumMap(BaseModel.class);

    @NonNull
    @VisibleForTesting
    public static final Map b = new EnumMap(BaseModel.class);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ModelType f6619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final BaseModel f6620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f6621a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f6622b;

    @KeepForSdk
    public RemoteModel(@Nullable String str, @Nullable BaseModel baseModel, @NonNull ModelType modelType) {
        yw6.b(TextUtils.isEmpty(str) == (baseModel != null), "One of cloud model name and base model cannot be empty");
        this.f6621a = str;
        this.f6620a = baseModel;
        this.f6619a = modelType;
    }

    @KeepForSdk
    public boolean a(@NonNull String str) {
        BaseModel baseModel = this.f6620a;
        if (baseModel == null) {
            return false;
        }
        return str.equals(f32450a.get(baseModel));
    }

    @NonNull
    @KeepForSdk
    public String b() {
        return this.f6622b;
    }

    @Nullable
    @KeepForSdk
    public String c() {
        return this.f6621a;
    }

    @NonNull
    @KeepForSdk
    public String d() {
        String str = this.f6621a;
        return str != null ? str : (String) b.get(this.f6620a);
    }

    @NonNull
    @KeepForSdk
    public ModelType e() {
        return this.f6619a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoteModel)) {
            return false;
        }
        RemoteModel remoteModel = (RemoteModel) obj;
        return i76.b(this.f6621a, remoteModel.f6621a) && i76.b(this.f6620a, remoteModel.f6620a) && i76.b(this.f6619a, remoteModel.f6619a);
    }

    @NonNull
    @KeepForSdk
    public String f() {
        String str = this.f6621a;
        return str != null ? str : "COM.GOOGLE.BASE_".concat(String.valueOf((String) b.get(this.f6620a)));
    }

    @KeepForSdk
    public boolean g() {
        return this.f6620a != null;
    }

    @KeepForSdk
    public void h(@NonNull String str) {
        this.f6622b = str;
    }

    public int hashCode() {
        return i76.c(this.f6621a, this.f6620a, this.f6619a);
    }

    @NonNull
    public String toString() {
        dvd dvdVarB = l7c.b("RemoteModel");
        dvdVarB.a("modelName", this.f6621a);
        dvdVarB.a("baseModel", this.f6620a);
        dvdVarB.a("modelType", this.f6619a);
        return dvdVarB.toString();
    }
}
