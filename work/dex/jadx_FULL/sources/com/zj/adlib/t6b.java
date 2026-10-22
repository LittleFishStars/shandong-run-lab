package com.zj.adlib;

import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0003l.gh;
import com.blankj.utilcode.util.e;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class t6b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile gh f44858a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Properties f19716a = f();

    public static gh a() {
        if (f44858a == null) {
            synchronized (t6b.class) {
                if (f44858a == null) {
                    try {
                        gh ghVarB = b(Build.MANUFACTURER);
                        if ("".equals(ghVarB.a())) {
                            Iterator it = Arrays.asList(gh.MIUI.a(), gh.Flyme.a(), gh.EMUI.a(), gh.ColorOS.a(), gh.FuntouchOS.a(), gh.SmartisanOS.a(), gh.AmigoOS.a(), gh.Sense.a(), gh.LG.a(), gh.Google.a(), gh.NubiaUI.a()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    ghVarB = gh.Other;
                                    break;
                                }
                                gh ghVarB2 = b((String) it.next());
                                if (!"".equals(ghVarB2.a())) {
                                    ghVarB = ghVarB2;
                                    break;
                                }
                            }
                        }
                        f44858a = ghVarB;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return f44858a;
    }

    public static gh b(String str) {
        if (str == null || str.length() <= 0) {
            return gh.Other;
        }
        gh ghVar = gh.MIUI;
        if (!str.equals(ghVar.a())) {
            gh ghVar2 = gh.Flyme;
            if (!str.equals(ghVar2.a())) {
                gh ghVar3 = gh.EMUI;
                if (!str.equals(ghVar3.a())) {
                    gh ghVar4 = gh.ColorOS;
                    if (!str.equals(ghVar4.a())) {
                        gh ghVar5 = gh.FuntouchOS;
                        if (!str.equals(ghVar5.a())) {
                            gh ghVar6 = gh.SmartisanOS;
                            if (!str.equals(ghVar6.a())) {
                                gh ghVar7 = gh.AmigoOS;
                                if (!str.equals(ghVar7.a())) {
                                    gh ghVar8 = gh.EUI;
                                    if (!str.equals(ghVar8.a())) {
                                        gh ghVar9 = gh.Sense;
                                        if (!str.equals(ghVar9.a())) {
                                            gh ghVar10 = gh.LG;
                                            if (!str.equals(ghVar10.a())) {
                                                gh ghVar11 = gh.Google;
                                                if (!str.equals(ghVar11.a())) {
                                                    gh ghVar12 = gh.NubiaUI;
                                                    if (str.equals(ghVar12.a()) && r(ghVar12)) {
                                                        return ghVar12;
                                                    }
                                                } else if (q(ghVar11)) {
                                                    return ghVar11;
                                                }
                                            } else if (p(ghVar10)) {
                                                return ghVar10;
                                            }
                                        } else if (o(ghVar9)) {
                                            return ghVar9;
                                        }
                                    } else if (n(ghVar8)) {
                                        return ghVar8;
                                    }
                                } else if (m(ghVar7)) {
                                    return ghVar7;
                                }
                            } else if (l(ghVar6)) {
                                return ghVar6;
                            }
                        } else if (k(ghVar5)) {
                            return ghVar5;
                        }
                    } else if (j(ghVar4)) {
                        return ghVar4;
                    }
                } else if (i(ghVar3)) {
                    return ghVar3;
                }
            } else if (g(ghVar2)) {
                return ghVar2;
            }
        } else if (d(ghVar)) {
            return ghVar;
        }
        return gh.Other;
    }

    public static void c(gh ghVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String strGroup = matcher.group(1);
                ghVar.a(strGroup);
                ghVar.a(Integer.parseInt(strGroup.split("\\.")[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean d(gh ghVar) {
        if (TextUtils.isEmpty(e(XmSystemUtils.KEY_VERSION_MIUI))) {
            return false;
        }
        String strE = e(e.c);
        c(ghVar, strE);
        ghVar.b(strE);
        return true;
    }

    public static String e(String str) {
        String property = f19716a.getProperty("[" + str + "]", null);
        return TextUtils.isEmpty(property) ? h(str) : property.replace("[", "").replace("]", "");
    }

    public static Properties f() {
        Properties properties = new Properties();
        try {
            properties.load(Runtime.getRuntime().exec("getprop").getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static boolean g(gh ghVar) {
        String strE = e("ro.flyme.published");
        String strE2 = e("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(strE) && TextUtils.isEmpty(strE2)) {
            return false;
        }
        String strE3 = e("ro.build.display.id");
        c(ghVar, strE3);
        ghVar.b(strE3);
        return true;
    }

    public static String h(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return line;
            } catch (IOException unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean i(gh ghVar) {
        String strE = e("ro.build.version.emui");
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        c(ghVar, strE);
        ghVar.b(strE);
        return true;
    }

    public static boolean j(gh ghVar) {
        String strE = e(e.d);
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        c(ghVar, strE);
        ghVar.b(strE);
        return true;
    }

    public static boolean k(gh ghVar) {
        String strE = e(e.b);
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        c(ghVar, strE);
        ghVar.b(strE);
        return true;
    }

    public static boolean l(gh ghVar) {
        String strE = e("ro.smartisan.version");
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        c(ghVar, strE);
        ghVar.b(strE);
        return true;
    }

    public static boolean m(gh ghVar) {
        String strE = e("ro.build.display.id");
        if (TextUtils.isEmpty(strE) || !strE.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        c(ghVar, strE);
        ghVar.b(strE);
        return true;
    }

    public static boolean n(gh ghVar) {
        String strE = e(e.e);
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        c(ghVar, strE);
        ghVar.b(strE);
        return true;
    }

    public static boolean o(gh ghVar) {
        String strE = e("ro.build.sense.version");
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        c(ghVar, strE);
        ghVar.b(strE);
        return true;
    }

    public static boolean p(gh ghVar) {
        String strE = e("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        c(ghVar, strE);
        ghVar.b(strE);
        return true;
    }

    public static boolean q(gh ghVar) {
        if (!"android-google".equals(e("ro.com.google.clientidbase"))) {
            return false;
        }
        String strE = e("ro.build.version.release");
        ghVar.a(Build.VERSION.SDK_INT);
        ghVar.b(strE);
        return true;
    }

    public static boolean r(gh ghVar) {
        String strE = e("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        c(ghVar, strE);
        ghVar.b(strE);
        return true;
    }
}
