package huachenjie.sdk.logcat;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.zj.adlib.c25;
import com.zj.adlib.px6;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends LogTransaction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46379a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    public static final int i = 8;
    public static final int j = 9;
    public static final int k = 10;
    public static final int l = 11;
    public static final int m = 12;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LogLevel f21163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<Long, C1340a> f21164a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Map<Long, C1340a> f21165b = new HashMap();

    /* JADX INFO: renamed from: huachenjie.sdk.logcat.a$a, reason: collision with other inner class name */
    public static final class C1340a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f46380a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public C1340a f21166a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f21167a;
        public C1340a b;
    }

    public a(LogLevel logLevel) {
        this.f21163a = logLevel;
    }

    public static String q(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException | NullPointerException | NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "null";
        }
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction a(boolean z) {
        p(9, Boolean.valueOf(z));
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction b() {
        p(5, "");
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction c(@NonNull String str) {
        p(5, str);
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction d(@NonNull String str) {
        p(8, str);
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction e(@NonNull String str) {
        p(11, str);
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction f(@NonNull String str, Object... objArr) {
        p(7, new Pair(str, Arrays.asList(objArr)));
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction g() {
        p(6, c25.f15688b);
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction h(@NonNull Object obj) {
        p(3, obj);
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction i(@NonNull Object... objArr) {
        p(4, objArr);
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction j() {
        if (!c25.E()) {
            return this;
        }
        long id = Thread.currentThread().getId();
        if (!this.f21164a.containsKey(Long.valueOf(id)) || !this.f21165b.containsKey(Long.valueOf(id))) {
            return this;
        }
        C1340a c1340a = this.f21164a.get(Long.valueOf(id));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        String str = null;
        while (c1340a != null) {
            switch (c1340a.f46380a) {
                case 1:
                    arrayList2.add((String) c1340a.f21167a);
                    break;
                case 2:
                    arrayList2.addAll(Arrays.asList((String[]) c1340a.f21167a));
                    break;
                case 3:
                    arrayList.add(c1340a.f21167a);
                    break;
                case 4:
                    arrayList.addAll(Arrays.asList((Object[]) c1340a.f21167a));
                    break;
                case 5:
                    str = (String) c1340a.f21167a;
                    break;
                case 6:
                    arrayList.add(c1340a.f21167a);
                    break;
                case 7:
                    Pair pair = (Pair) c1340a.f21167a;
                    arrayList.add(String.format((String) pair.first, ((List) pair.second).toArray()));
                    break;
                case 8:
                    String str2 = (String) c1340a.f21167a;
                    String strR = c25.R(str2, q(str2));
                    if (!TextUtils.isEmpty(strR)) {
                        arrayList.add("json short in " + strR);
                    } else {
                        arrayList.add(px6.d(str2));
                    }
                    break;
                case 9:
                    ((Boolean) c1340a.f21167a).booleanValue();
                    break;
                case 10:
                    ((Integer) c1340a.f21167a).intValue();
                    break;
                case 11:
                    String str3 = (String) c1340a.f21167a;
                    String strR2 = c25.R(str3, q(str3));
                    if (!TextUtils.isEmpty(strR2)) {
                        arrayList.add("xml short in " + strR2);
                    } else {
                        arrayList.add(px6.e(str3));
                    }
                    break;
                case 12:
                    z = true;
                    break;
            }
            c1340a = c1340a.f21166a;
            if (c1340a != null) {
                c1340a.b = null;
            }
        }
        this.f21164a.remove(Long.valueOf(id));
        this.f21165b.remove(Long.valueOf(id));
        if (z) {
            return this;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String string = it.next().toString();
            sb.append(string);
            String str4 = c25.f15688b;
            if (!str4.equals(string)) {
                sb.append(" ");
            }
            sb.append(str4);
        }
        String[] strArr = new String[arrayList2.size()];
        arrayList2.toArray(strArr);
        c25.L(this.f21163a.value, null, null, null, null, str, sb.toString(), strArr);
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction k() {
        p(12, null);
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction l(int i2) {
        p(10, Integer.valueOf(i2));
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction m(@NonNull String str) {
        p(1, str);
        return this;
    }

    @Override // huachenjie.sdk.logcat.LogTransaction
    public LogTransaction n(@NonNull String... strArr) {
        p(2, strArr);
        return this;
    }

    public void o(C1340a c1340a) {
        long id = Thread.currentThread().getId();
        C1340a c1340a2 = this.f21164a.containsKey(Long.valueOf(id)) ? this.f21164a.get(Long.valueOf(id)) : null;
        C1340a c1340a3 = this.f21165b.containsKey(Long.valueOf(id)) ? this.f21165b.get(Long.valueOf(id)) : null;
        if (c1340a2 == null) {
            c1340a2 = c1340a;
        } else {
            c1340a.b = c1340a3;
            if (c1340a3 != null) {
                c1340a3.f21166a = c1340a;
            }
        }
        this.f21164a.put(Long.valueOf(id), c1340a2);
        this.f21165b.put(Long.valueOf(id), c1340a);
    }

    public final void p(int i2, Object obj) {
        if (obj == null) {
            obj = "null";
        }
        C1340a c1340a = new C1340a();
        c1340a.f46380a = i2;
        c1340a.f21167a = obj;
        o(c1340a);
    }
}
