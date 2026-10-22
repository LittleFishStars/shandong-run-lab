package cn.jy.ad.sdk;

import android.util.SparseArray;
import cn.jy.ad.sdk.jycfg.AdCode;
import cn.jy.ad.sdk.jycfg.JyConfig;
import cn.jy.ad.sdk.jyinter.AdListener;
import cn.jy.ad.sdk.jyinter.ValueSet;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: cn.jy.ad.sdk.a$a, reason: collision with other inner class name */
    public static class C0087a implements ValueSet {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<Object> f22760a;

        public C0087a(SparseArray<Object> sparseArray) {
            this.f22760a = sparseArray;
        }

        @Override // cn.jy.ad.sdk.jyinter.ValueSet
        public boolean containsKey(int i) {
            return this.f22760a.indexOfKey(i) >= 0;
        }

        @Override // cn.jy.ad.sdk.jyinter.ValueSet
        public boolean isEmpty() {
            return this.f22760a.size() <= 0;
        }

        @Override // cn.jy.ad.sdk.jyinter.ValueSet
        public Set<Integer> keys() {
            int size = this.f22760a.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.f22760a.keyAt(i)));
            }
            return hashSet;
        }

        @Override // cn.jy.ad.sdk.jyinter.ValueSet
        public Object objectValue(int i) {
            return this.f22760a.get(i);
        }

        @Override // cn.jy.ad.sdk.jyinter.ValueSet
        public int size() {
            return this.f22760a.size();
        }
    }

    public static ValueSet a(AdCode adCode, AdListener adListener) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(2, adCode);
        sparseArray.put(3, adListener);
        return new C0087a(sparseArray);
    }

    public static ValueSet a(JyConfig jyConfig) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, jyConfig);
        return new C0087a(sparseArray);
    }
}
