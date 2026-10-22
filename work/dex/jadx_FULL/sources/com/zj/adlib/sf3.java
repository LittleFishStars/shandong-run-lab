package com.zj.adlib;

import com.google.zxing.NotFoundException;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class sf3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f44680a;
    public static final Map<String, a> b;
    public static final Map<String, a> c;
    public static final Map<String, a> d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f44681a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f19568a;

        public a(boolean z, int i) {
            this.f19568a = z;
            this.f44681a = i;
        }

        public static a a(int i) {
            return new a(false, i);
        }

        public static a b(int i) {
            return new a(true, i);
        }
    }

    static {
        HashMap map = new HashMap();
        f44680a = map;
        map.put("00", a.a(18));
        map.put(HiAnalyticsConstant.KeyAndValue.NUMBER_01, a.a(14));
        map.put("02", a.a(14));
        map.put("10", a.b(20));
        map.put("11", a.a(6));
        map.put("12", a.a(6));
        map.put("13", a.a(6));
        map.put("15", a.a(6));
        map.put("17", a.a(6));
        map.put("20", a.a(2));
        map.put("21", a.b(20));
        map.put("22", a.b(29));
        map.put("30", a.b(8));
        map.put("37", a.b(8));
        for (int i = 90; i <= 99; i++) {
            f44680a.put(String.valueOf(i), a.b(30));
        }
        HashMap map2 = new HashMap();
        b = map2;
        map2.put("240", a.b(30));
        map2.put("241", a.b(30));
        map2.put("242", a.b(6));
        map2.put("250", a.b(30));
        map2.put("251", a.b(30));
        map2.put("253", a.b(17));
        map2.put("254", a.b(20));
        map2.put("400", a.b(30));
        map2.put("401", a.b(30));
        map2.put("402", a.a(17));
        map2.put("403", a.b(30));
        map2.put("410", a.a(13));
        map2.put("411", a.a(13));
        map2.put("412", a.a(13));
        map2.put("413", a.a(13));
        map2.put("414", a.a(13));
        map2.put("420", a.b(20));
        map2.put("421", a.b(15));
        map2.put("422", a.a(3));
        map2.put("423", a.b(15));
        map2.put("424", a.a(3));
        map2.put("425", a.a(3));
        map2.put("426", a.a(3));
        c = new HashMap();
        for (int i2 = 310; i2 <= 316; i2++) {
            c.put(String.valueOf(i2), a.a(6));
        }
        for (int i3 = 320; i3 <= 336; i3++) {
            c.put(String.valueOf(i3), a.a(6));
        }
        for (int i4 = 340; i4 <= 357; i4++) {
            c.put(String.valueOf(i4), a.a(6));
        }
        for (int i5 = 360; i5 <= 369; i5++) {
            c.put(String.valueOf(i5), a.a(6));
        }
        Map<String, a> map3 = c;
        map3.put("390", a.b(15));
        map3.put("391", a.b(18));
        map3.put("392", a.b(15));
        map3.put("393", a.b(18));
        map3.put("703", a.b(30));
        HashMap map4 = new HashMap();
        d = map4;
        map4.put("7001", a.a(13));
        map4.put("7002", a.b(30));
        map4.put("7003", a.a(10));
        map4.put("8001", a.a(14));
        map4.put("8002", a.b(20));
        map4.put("8003", a.b(30));
        map4.put("8004", a.b(30));
        map4.put("8005", a.a(6));
        map4.put("8006", a.a(18));
        map4.put("8007", a.b(30));
        map4.put("8008", a.b(12));
        map4.put("8018", a.a(18));
        map4.put("8020", a.b(25));
        map4.put("8100", a.a(6));
        map4.put("8101", a.a(10));
        map4.put("8102", a.a(2));
        map4.put("8110", a.b(70));
        map4.put("8200", a.b(70));
    }

    public static String a(String str) throws NotFoundException {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() < 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        a aVar = f44680a.get(str.substring(0, 2));
        if (aVar != null) {
            return aVar.f19568a ? c(2, aVar.f44681a, str) : b(2, aVar.f44681a, str);
        }
        if (str.length() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        String strSubstring = str.substring(0, 3);
        a aVar2 = b.get(strSubstring);
        if (aVar2 != null) {
            return aVar2.f19568a ? c(3, aVar2.f44681a, str) : b(3, aVar2.f44681a, str);
        }
        if (str.length() < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        a aVar3 = c.get(strSubstring);
        if (aVar3 != null) {
            return aVar3.f19568a ? c(4, aVar3.f44681a, str) : b(4, aVar3.f44681a, str);
        }
        a aVar4 = d.get(str.substring(0, 4));
        if (aVar4 != null) {
            return aVar4.f19568a ? c(4, aVar4.f44681a, str) : b(4, aVar4.f44681a, str);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static String b(int i, int i2, String str) throws NotFoundException {
        if (str.length() < i) {
            throw NotFoundException.getNotFoundInstance();
        }
        String strSubstring = str.substring(0, i);
        int i3 = i2 + i;
        if (str.length() < i3) {
            throw NotFoundException.getNotFoundInstance();
        }
        String strSubstring2 = str.substring(i, i3);
        String str2 = '(' + strSubstring + ')' + strSubstring2;
        String strA = a(str.substring(i3));
        if (strA == null) {
            return str2;
        }
        return str2 + strA;
    }

    public static String c(int i, int i2, String str) throws NotFoundException {
        String strSubstring = str.substring(0, i);
        int iMin = Math.min(str.length(), i2 + i);
        String strSubstring2 = str.substring(i, iMin);
        String str2 = '(' + strSubstring + ')' + strSubstring2;
        String strA = a(str.substring(iMin));
        if (strA == null) {
            return str2;
        }
        return str2 + strA;
    }
}
