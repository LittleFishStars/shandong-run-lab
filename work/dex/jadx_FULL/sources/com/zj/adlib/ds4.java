package com.zj.adlib;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.KeyPathElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ds4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ds4 f41268a = new ds4("COMPOSITION");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public KeyPathElement f16067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<String> f16068a;

    public ds4(String... strArr) {
        this.f16068a = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ds4 a(String str) {
        ds4 ds4Var = new ds4(this);
        ds4Var.f16068a.add(str);
        return ds4Var;
    }

    public final boolean b() {
        List<String> list = this.f16068a;
        return list.get(list.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i) {
        if (i >= this.f16068a.size()) {
            return false;
        }
        boolean z = i == this.f16068a.size() - 1;
        String str2 = this.f16068a.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.f16068a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.f16068a.get(i + 1).equals(str)) {
            return i == this.f16068a.size() + (-2) || (i == this.f16068a.size() + (-3) && b());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.f16068a.size() - 1) {
            return false;
        }
        return this.f16068a.get(i2).equals(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPathElement d() {
        return this.f16067a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e(String str, int i) {
        if (f(str)) {
            return 0;
        }
        if (this.f16068a.get(i).equals("**")) {
            return (i != this.f16068a.size() - 1 && this.f16068a.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ds4 ds4Var = (ds4) obj;
        if (!this.f16068a.equals(ds4Var.f16068a)) {
            return false;
        }
        KeyPathElement keyPathElement = this.f16067a;
        KeyPathElement keyPathElement2 = ds4Var.f16067a;
        if (keyPathElement != null) {
            return keyPathElement.equals(keyPathElement2);
        }
        return keyPathElement2 == null;
    }

    public final boolean f(String str) {
        return "__container".equals(str);
    }

    public String g() {
        return this.f16068a.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        if (f(str)) {
            return true;
        }
        if (i >= this.f16068a.size()) {
            return false;
        }
        return this.f16068a.get(i).equals(str) || this.f16068a.get(i).equals("**") || this.f16068a.get(i).equals("*");
    }

    public int hashCode() {
        int iHashCode = this.f16068a.hashCode() * 31;
        KeyPathElement keyPathElement = this.f16067a;
        return iHashCode + (keyPathElement != null ? keyPathElement.hashCode() : 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean i(String str, int i) {
        return "__container".equals(str) || i < this.f16068a.size() - 1 || this.f16068a.get(i).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ds4 j(KeyPathElement keyPathElement) {
        ds4 ds4Var = new ds4(this);
        ds4Var.f16067a = keyPathElement;
        return ds4Var;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f16068a);
        sb.append(",resolved=");
        sb.append(this.f16067a != null);
        sb.append('}');
        return sb.toString();
    }

    public ds4(ds4 ds4Var) {
        this.f16068a = new ArrayList(ds4Var.f16068a);
        this.f16067a = ds4Var.f16067a;
    }
}
