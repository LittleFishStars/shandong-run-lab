package com.alibaba.analytics.a;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static i f23744a = new i();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private b f620a;

    public class a implements Comparator<String> {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }

    public class b implements Comparator<String> {
        private b() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * (-1);
        }
    }

    private i() {
        this.f620a = new b();
        this.f619a = new a();
    }

    public static i a() {
        return f23744a;
    }

    public String[] a(String[] strArr, boolean z) {
        Comparator comparator = z ? this.f619a : this.f620a;
        if (comparator == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
