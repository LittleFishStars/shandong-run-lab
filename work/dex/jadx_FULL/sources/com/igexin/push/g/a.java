package com.igexin.push.g;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38138a = "BasicCheck";

    private static String a(int i) {
        String strTrim;
        try {
            strTrim = a(String.format("/proc/%d/cmdline", Integer.valueOf(i))).trim();
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            strTrim = null;
        }
        try {
            if (TextUtils.isEmpty(strTrim)) {
                return a(String.format("/proc/%d/stat", Integer.valueOf(i))).split("\\s+")[1].replace("(", "").replace(")", "");
            }
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
        return strTrim;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v9 */
    private static String a(String str) throws Throwable {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                fileReader = new FileReader((String) str);
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                            sb.append("\n");
                        } catch (Exception e) {
                            e = e;
                            com.igexin.c.a.c.a.a(e);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception e2) {
                                    com.igexin.c.a.c.a.a(e2);
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e3) {
                                    com.igexin.c.a.c.a.a(e3);
                                }
                            }
                            return null;
                        }
                    }
                    if (sb.length() > 2) {
                        String strSubstring = sb.substring(0, sb.length() - 2);
                        try {
                            fileReader.close();
                        } catch (Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                            com.igexin.c.a.c.a.a(e5);
                        }
                        return strSubstring;
                    }
                    String string = sb.toString();
                    try {
                        fileReader.close();
                    } catch (Exception e6) {
                        com.igexin.c.a.c.a.a(e6);
                    }
                    try {
                        bufferedReader.close();
                    } catch (Exception e7) {
                        com.igexin.c.a.c.a.a(e7);
                    }
                    return string;
                } catch (Exception e8) {
                    e = e8;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e9) {
                            com.igexin.c.a.c.a.a(e9);
                        }
                    }
                    if (str == 0) {
                        throw th;
                    }
                    try {
                        str.close();
                        throw th;
                    } catch (Exception e10) {
                        com.igexin.c.a.c.a.a(e10);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
            bufferedReader = null;
            fileReader = null;
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            str = 0;
        }
    }

    public static boolean a() {
        try {
            Class.forName("com.igexin.push.g.g");
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }

    public static boolean b() {
        try {
            for (String str : com.igexin.push.config.d.B.split(",")) {
                if (n.e().toLowerCase().contains(str.toLowerCase())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }

    private static boolean c() {
        try {
            for (String str : com.igexin.push.core.e.aI.split(",")) {
                if (com.igexin.push.core.e.F.toLowerCase().contains(str.toLowerCase())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }
}
