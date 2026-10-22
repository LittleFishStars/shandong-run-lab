package com.king.zxing;

import android.content.Intent;
import android.net.Uri;
import com.google.zxing.BarcodeFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Set<BarcodeFormat>> f40020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Set<BarcodeFormat> f15047a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f15048a = Pattern.compile(",");
    public static final Set<BarcodeFormat> b;
    public static final Set<BarcodeFormat> c;
    public static final Set<BarcodeFormat> d;
    public static final Set<BarcodeFormat> e;
    public static final Set<BarcodeFormat> f;
    public static final Set<BarcodeFormat> g;

    static {
        EnumSet enumSetOf = EnumSet.of(BarcodeFormat.QR_CODE);
        d = enumSetOf;
        EnumSet enumSetOf2 = EnumSet.of(BarcodeFormat.DATA_MATRIX);
        e = enumSetOf2;
        EnumSet enumSetOf3 = EnumSet.of(BarcodeFormat.AZTEC);
        f = enumSetOf3;
        EnumSet enumSetOf4 = EnumSet.of(BarcodeFormat.PDF_417);
        g = enumSetOf4;
        EnumSet enumSetOf5 = EnumSet.of(BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED);
        f15047a = enumSetOf5;
        EnumSet enumSetOf6 = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        b = enumSetOf6;
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) enumSetOf5);
        c = enumSetCopyOf;
        enumSetCopyOf.addAll(enumSetOf6);
        HashMap map = new HashMap();
        f40020a = map;
        map.put(e.c.d, enumSetCopyOf);
        map.put(e.c.c, enumSetOf5);
        map.put(e.c.e, enumSetOf);
        map.put(e.c.f, enumSetOf2);
        map.put(e.c.g, enumSetOf3);
        map.put(e.c.h, enumSetOf4);
    }

    public static Set<BarcodeFormat> a(Intent intent) {
        String stringExtra = intent.getStringExtra(e.c.i);
        return c(stringExtra != null ? Arrays.asList(f15048a.split(stringExtra)) : null, intent.getStringExtra(e.c.b));
    }

    public static Set<BarcodeFormat> b(Uri uri) {
        List<String> queryParameters = uri.getQueryParameters(e.c.i);
        if (queryParameters != null && queryParameters.size() == 1 && queryParameters.get(0) != null) {
            queryParameters = Arrays.asList(f15048a.split(queryParameters.get(0)));
        }
        return c(queryParameters, uri.getQueryParameter(e.c.b));
    }

    public static Set<BarcodeFormat> c(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet enumSetNoneOf = EnumSet.noneOf(BarcodeFormat.class);
            try {
                Iterator<String> it = iterable.iterator();
                while (it.hasNext()) {
                    enumSetNoneOf.add(BarcodeFormat.valueOf(it.next()));
                }
                return enumSetNoneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f40020a.get(str);
        }
        return null;
    }
}
