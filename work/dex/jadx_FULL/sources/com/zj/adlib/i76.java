package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class i76 {

    @KeepForSdk
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f42295a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List f17162a;

        public /* synthetic */ a(Object obj, a9c a9cVar) {
            yw6.l(obj);
            this.f42295a = obj;
            this.f17162a = new ArrayList();
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a a(@NonNull String str, @Nullable Object obj) {
            List list = this.f17162a;
            yw6.l(str);
            list.add(str + "=" + String.valueOf(obj));
            return this;
        }

        @NonNull
        @KeepForSdk
        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f42295a.getClass().getSimpleName());
            sb.append('{');
            int size = this.f17162a.size();
            for (int i = 0; i < size; i++) {
                sb.append((String) this.f17162a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public i76() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static boolean a(@NonNull Bundle bundle, @NonNull Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        Set<String> setKeySet = bundle.keySet();
        if (!setKeySet.containsAll(bundle2.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!b(bundle.get(str), bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    @KeepForSdk
    public static boolean b(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @KeepForSdk
    public static int c(@NonNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @NonNull
    @KeepForSdk
    public static a d(@NonNull Object obj) {
        return new a(obj, null);
    }
}
