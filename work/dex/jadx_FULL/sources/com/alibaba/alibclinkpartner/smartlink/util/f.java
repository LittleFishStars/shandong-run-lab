package com.alibaba.alibclinkpartner.smartlink.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f23582a;
    private static SharedPreferences b;

    private f(Context context, String str) {
        b = context.getSharedPreferences(str, 0);
    }

    public static void a(Context context, String str) {
        if (f23582a == null) {
            f23582a = new f(context, str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004d  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean a(String str, Object obj) {
        byte b2;
        SharedPreferences.Editor editorEdit = b.edit();
        String simpleName = obj.getClass().getSimpleName();
        boolean z = false;
        try {
            switch (simpleName.hashCode()) {
                case -1808118735:
                    if (!simpleName.equals("String")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case -672261858:
                    if (!simpleName.equals("Integer")) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                case 2374300:
                    if (!simpleName.equals("Long")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case 67973692:
                    if (!simpleName.equals("Float")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 1729365000:
                    if (!simpleName.equals("Boolean")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (b2 == 1) {
                editorEdit.putLong(str, ((Long) obj).longValue());
            } else if (b2 == 2) {
                editorEdit.putFloat(str, ((Float) obj).floatValue());
            } else if (b2 == 3) {
                editorEdit.putString(str, (String) obj);
            } else if (b2 == 4) {
                editorEdit.putInt(str, ((Integer) obj).intValue());
            }
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        editorEdit.apply();
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Object b(String str, Object obj) {
        byte b2;
        Object objValueOf;
        String simpleName = obj.getClass().getSimpleName();
        try {
            switch (simpleName.hashCode()) {
                case -1808118735:
                    if (!simpleName.equals("String")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case -672261858:
                    if (!simpleName.equals("Integer")) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                case 2374300:
                    if (!simpleName.equals("Long")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case 67973692:
                    if (!simpleName.equals("Float")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 1729365000:
                    if (!simpleName.equals("Boolean")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                objValueOf = Boolean.valueOf(b.getBoolean(str, ((Boolean) obj).booleanValue()));
            } else if (b2 == 1) {
                objValueOf = Long.valueOf(b.getLong(str, ((Long) obj).longValue()));
            } else if (b2 == 2) {
                objValueOf = Float.valueOf(b.getFloat(str, ((Float) obj).floatValue()));
            } else if (b2 == 3) {
                objValueOf = b.getString(str, (String) obj);
            } else {
                if (b2 != 4) {
                    return obj;
                }
                objValueOf = Integer.valueOf(b.getInt(str, ((Integer) obj).intValue()));
            }
            return objValueOf;
        } catch (Exception unused) {
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0045 -> B:30:0x0048). Please report as a decompilation issue!!! */
    public static void c(String str, Object obj) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        SharedPreferences.Editor editorEdit = b.edit();
        ?? r1 = 0;
        objectOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        r1 = 0;
        r1 = 0;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream2.writeObject(obj);
                        String str2 = "UTF-8";
                        editorEdit.putString(str, URLEncoder.encode(byteArrayOutputStream.toString("ISO-8859-1"), "UTF-8"));
                        editorEdit.commit();
                        objectOutputStream2.close();
                        byteArrayOutputStream.close();
                        r1 = str2;
                    } catch (Exception e) {
                        e = e;
                        objectOutputStream = objectOutputStream2;
                        e.printStackTrace();
                        objectOutputStream.close();
                        byteArrayOutputStream.close();
                        r1 = objectOutputStream;
                    } catch (Throwable th) {
                        th = th;
                        r1 = objectOutputStream2;
                        try {
                            r1.close();
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            r1 = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    public static Object d(String str, Object obj) throws Throwable {
        Object object;
        Exception e;
        ObjectInputStream objectInputStream;
        ?? byteArrayInputStream = "";
        String string = b.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            object = obj;
        } else {
            ?? r0 = 0;
            r0 = 0;
            try {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(URLDecoder.decode(string, "UTF-8").getBytes("ISO-8859-1"));
                    try {
                        objectInputStream = new ObjectInputStream(byteArrayInputStream);
                        try {
                            object = objectInputStream.readObject();
                            try {
                                objectInputStream.close();
                                byteArrayInputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            try {
                                objectInputStream.close();
                                byteArrayInputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            object = obj;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        objectInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            r0.close();
                            byteArrayInputStream.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r0 = string;
                }
            } catch (Exception e7) {
                byteArrayInputStream = 0;
                e = e7;
                objectInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayInputStream = 0;
            }
        }
        return object == null ? obj : object;
    }
}
