package com.zj.adlib;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class s6b {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f19527a = "9aj&#k81";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f19529a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static byte[] f19530a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static String f19531b = "IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f19532b = false;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static String f19533c = "ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKASEDawAJA3QADQOBABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PUNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlJWVdsa1BRPT1NZkhObGNtbGhiRDA9UVlXNWtjbTlwWkY5cFpBPT0=";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile ConcurrentHashMap<String, String> f19528a = new ConcurrentHashMap<>(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer f44621a = 1;
    public static final Integer b = 2;
    public static final Integer c = 3;
    public static final Integer d = 4;
    public static final Integer e = 5;

    public static String a(String str) {
        String str2 = "";
        try {
            synchronized (f19528a) {
                if (f19528a != null && f19528a.containsKey(str)) {
                    str2 = f19528a.get(str);
                }
            }
        } catch (Throwable unused) {
        }
        return str2;
    }

    public static void b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                synchronized (f19528a) {
                    try {
                        if (f19528a == null) {
                            f19528a = new ConcurrentHashMap<>(8);
                        }
                        if (!f19528a.containsKey(str)) {
                            f19528a.put(str, str2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static byte[] c(int i) {
        if (f19530a == null) {
            f19530a = m4b.g(f19533c);
        }
        byte[] bArr = new byte[4];
        System.arraycopy(f19530a, i * 4, bArr, 0, 4);
        int i2 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        int i3 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(f19530a, i2, bArr2, 0, i3);
        return bArr2;
    }
}
