package com.igexin.push.config;

import com.igexin.push.g.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f37911a = "FileConfig";

    /* JADX WARN: Code duplicated, block: B:103:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0052 A[Catch: all -> 0x00cc, Exception -> 0x00e2, TryCatch #17 {Exception -> 0x00e2, all -> 0x00cc, blocks: (B:22:0x0045, B:24:0x0052, B:27:0x007c, B:28:0x0083, B:29:0x0084), top: B:97:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x007b  */
    /* JADX WARN: Code duplicated, block: B:27:0x007c A[Catch: all -> 0x00cc, Exception -> 0x00e2, TryCatch #17 {Exception -> 0x00e2, all -> 0x00cc, blocks: (B:22:0x0045, B:24:0x0052, B:27:0x007c, B:28:0x0083, B:29:0x0084), top: B:97:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x009d A[Catch: all -> 0x00be, Exception -> 0x00c3, TryCatch #14 {Exception -> 0x00c3, all -> 0x00be, blocks: (B:31:0x0097, B:33:0x009d, B:35:0x00a5), top: B:101:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x00ad A[EDGE_INSN: B:83:0x00ad->B:37:0x00ad BREAK  A[LOOP:0: B:101:0x0097->B:104:0x0097], EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:24:0x0052, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v10 */
    public static void a() {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        String line;
        ?? Open = com.igexin.push.core.e.g + ".properties";
        ?? r3 = 0;
        bufferedReader = null;
        bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    try {
                        Open = com.igexin.push.core.e.l.getResources().getAssets().open(Open);
                        try {
                            a((InputStream) Open);
                            if (Open != 0) {
                                Open.close();
                                Open = Open;
                            }
                            while (true) {
                                try {
                                    line = bufferedReader.readLine();
                                    if (line != null) {
                                        try {
                                            break;
                                        } catch (IOException e) {
                                            com.igexin.c.a.c.a.a(e);
                                        }
                                    } else if (!line.startsWith("#")) {
                                        int length = line.split("=").length;
                                    }
                                } catch (Exception unused) {
                                    bufferedReader2 = bufferedReader;
                                    Open = fileInputStream;
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e2) {
                                            com.igexin.c.a.c.a.a(e2);
                                        }
                                    }
                                    if (Open != 0) {
                                        try {
                                            Open.close();
                                            return;
                                        } catch (Exception e3) {
                                            com.igexin.c.a.c.a.a(e3);
                                            return;
                                        }
                                    }
                                    return;
                                } catch (Throwable th) {
                                    bufferedReader3 = bufferedReader;
                                    Open = fileInputStream;
                                    th = th;
                                    if (bufferedReader3 != null) {
                                        try {
                                            bufferedReader3.close();
                                        } catch (IOException e4) {
                                            com.igexin.c.a.c.a.a(e4);
                                        }
                                    }
                                    if (Open == 0) {
                                        throw th;
                                    }
                                    try {
                                        Open.close();
                                        throw th;
                                    } catch (Exception e5) {
                                        com.igexin.c.a.c.a.a(e5);
                                        throw th;
                                    }
                                }
                            }
                        } catch (Exception unused2) {
                            if (Open != 0) {
                                Open.close();
                                Open = Open;
                            }
                            if (!new File(j.f38150a).exists()) {
                                j.f38150a = j.b(com.igexin.push.core.e.l) + com.igexin.push.core.e.g + ".properties";
                                if (new File(j.f38150a).exists()) {
                                    throw new RuntimeException("extraConfigPath no exists");
                                }
                            }
                            fileInputStream = new FileInputStream(j.f38150a);
                            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                            while (true) {
                                line = bufferedReader.readLine();
                                if (line != null) {
                                    break;
                                    break;
                                } else if (!line.startsWith("#")) {
                                    int length2 = line.split("=").length;
                                }
                            }
                            bufferedReader.close();
                            fileInputStream.close();
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            r3 = Open;
                            if (r3 != 0) {
                                try {
                                    r3.close();
                                } catch (Exception e6) {
                                    com.igexin.c.a.c.a.a(e6);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e7) {
                        com.igexin.c.a.c.a.a(e7);
                    }
                } catch (Exception unused3) {
                    Open = 0;
                } catch (Throwable th3) {
                    th = th3;
                }
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                bufferedReader.close();
                try {
                    fileInputStream.close();
                    return;
                } catch (Exception e8) {
                    com.igexin.c.a.c.a.a(e8);
                    return;
                }
            } catch (Exception unused4) {
            } catch (Throwable th4) {
                th = th4;
                Open = fileInputStream;
            }
            if (!new File(j.f38150a).exists()) {
                j.f38150a = j.b(com.igexin.push.core.e.l) + com.igexin.push.core.e.g + ".properties";
                if (new File(j.f38150a).exists()) {
                    throw new RuntimeException("extraConfigPath no exists");
                }
            }
            fileInputStream = new FileInputStream(j.f38150a);
        } catch (Exception unused5) {
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0121  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void a(InputStream inputStream) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (Exception e) {
                                com.igexin.c.a.c.a.a(e);
                                return;
                            }
                        }
                        if (!line.startsWith("#")) {
                            String[] strArrSplit = line.split("=");
                            byte b = 2;
                            if (strArrSplit.length >= 2) {
                                String strTrim = strArrSplit[0].trim();
                                String strTrim2 = strArrSplit[1].trim();
                                switch (strTrim.hashCode()) {
                                    case -1784363506:
                                        if (!strTrim.equals("sdk.readlocalcell.enable")) {
                                            b = -1;
                                        } else {
                                            b = 6;
                                        }
                                        break;
                                    case -1734610495:
                                        if (!strTrim.equals("sdk.enter.backup.detect.failed.cnt")) {
                                            b = -1;
                                        } else {
                                            b = 13;
                                        }
                                        break;
                                    case -1286040506:
                                        if (!strTrim.equals("sdk.detect.ip.expired.time")) {
                                            b = -1;
                                        } else {
                                            b = com.google.common.base.a.q;
                                        }
                                        break;
                                    case -1050591911:
                                        if (!strTrim.equals("sdk.feature.setsilenttime.enable")) {
                                            b = -1;
                                        } else {
                                            b = 9;
                                        }
                                        break;
                                    case -1004501973:
                                        if (!strTrim.equals("sdk.config_address")) {
                                            b = -1;
                                        } else {
                                            b = 1;
                                        }
                                        break;
                                    case -416668775:
                                        if (!strTrim.equals("sdk.feature.setsockettimeout.enable")) {
                                            b = -1;
                                        } else {
                                            b = 11;
                                        }
                                        break;
                                    case -367623287:
                                        if (!strTrim.equals("sdk.address.id")) {
                                            b = -1;
                                        } else {
                                            b = com.google.common.base.a.u;
                                        }
                                        break;
                                    case -52474114:
                                        if (!strTrim.equals("sdk.feature.sendmessage.enable")) {
                                            b = -1;
                                        } else {
                                            b = 7;
                                        }
                                        break;
                                    case 85426222:
                                        if (!strTrim.equals("sdk.cm_address_backup")) {
                                            b = -1;
                                        } else {
                                            b = 4;
                                        }
                                        break;
                                    case 178406040:
                                        if (!strTrim.equals("sdk.stay.backup.time")) {
                                            b = -1;
                                        } else {
                                            b = 12;
                                        }
                                        break;
                                    case 275980049:
                                        if (!strTrim.equals("sdk.login.failed.cnt")) {
                                            b = -1;
                                        } else {
                                            b = com.google.common.base.a.p;
                                        }
                                        break;
                                    case 352273926:
                                        if (!strTrim.equals("sdk.feature.setheartbeatinterval.enable")) {
                                            b = -1;
                                        } else {
                                            b = 10;
                                        }
                                        break;
                                    case 914256432:
                                        if (!strTrim.equals("sdk.bi_address")) {
                                            b = -1;
                                        }
                                        break;
                                    case 1188929677:
                                        if (!strTrim.equals("sdk.feature.settag.enable")) {
                                            b = -1;
                                        } else {
                                            b = 8;
                                        }
                                        break;
                                    case 1457933893:
                                        if (!strTrim.equals("sdk.log_address")) {
                                            b = -1;
                                        } else {
                                            b = 3;
                                        }
                                        break;
                                    case 1488582065:
                                        if (!strTrim.equals("sdk.address.key")) {
                                            b = -1;
                                        } else {
                                            b = 17;
                                        }
                                        break;
                                    case 1603576119:
                                        if (!strTrim.equals("sdk.domainbackup.enable")) {
                                            b = -1;
                                        } else {
                                            b = 5;
                                        }
                                        break;
                                    case 1676315519:
                                        if (!strTrim.equals("sdk.detect.interval.time")) {
                                            b = -1;
                                        } else {
                                            b = com.google.common.base.a.r;
                                        }
                                        break;
                                    case 2077859667:
                                        if (!strTrim.equals("sdk.cm_address")) {
                                            b = -1;
                                        } else {
                                            b = 0;
                                        }
                                        break;
                                    default:
                                        b = -1;
                                        break;
                                }
                                switch (b) {
                                    case 0:
                                        SDKUrlConfig.setXfrAddressIps(strTrim2.split(","));
                                        break;
                                    case 1:
                                        SDKUrlConfig.CONFIG_ADDRESS_IPS = strTrim2.split(",");
                                        break;
                                    case 2:
                                        SDKUrlConfig.BI_ADDRESS_IPS = strTrim2.split(",");
                                        break;
                                    case 3:
                                        SDKUrlConfig.LOG_ADDRESS_IPS = strTrim2.split(",");
                                        break;
                                    case 4:
                                        SDKUrlConfig.XFR_ADDRESS_BAK = strTrim2.split(",");
                                        break;
                                    case 5:
                                        d.g = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 6:
                                        d.h = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 7:
                                        d.j = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 8:
                                        d.k = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 9:
                                        d.l = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 10:
                                        d.m = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 11:
                                        d.n = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 12:
                                        d.r = Long.parseLong(strTrim2) * 1000;
                                        break;
                                    case 13:
                                        d.s = Integer.parseInt(strTrim2);
                                        break;
                                    case 14:
                                        d.t = Integer.parseInt(strTrim2);
                                        break;
                                    case 15:
                                        d.u = Long.parseLong(strTrim2) * 1000;
                                        break;
                                    case 16:
                                        d.v = Long.parseLong(strTrim2) * 1000;
                                        break;
                                    case 17:
                                        com.igexin.push.g.g.f38146a = strTrim2;
                                        break;
                                    case 18:
                                        com.igexin.push.g.g.b = strTrim2;
                                        break;
                                }
                                com.igexin.c.a.c.a.a(f37911a, "loadConfigFromFile, config line:".concat(line));
                            }
                        }
                    } catch (Exception unused) {
                        bufferedReader = bufferedReader2;
                        com.igexin.c.a.c.a.a(f37911a + "｜no config file found.", new Object[0]);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (Exception e2) {
                                com.igexin.c.a.c.a.a(e2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Boolean bool) {
        try {
            j.l();
            if (new File(j.e).exists()) {
                b(bool);
                return;
            }
            byte[] bytes = "sdk.debug=".concat(String.valueOf(bool)).getBytes();
            if (bytes != null) {
                j.a(bytes, j.e);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void a(boolean z, boolean z2) {
        try {
            j.l();
            com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.f37988a, Boolean.valueOf(z));
            com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.b, Boolean.valueOf(z2));
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static int b() {
        int i;
        try {
            j.l();
            Boolean boolA = com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.f37988a);
            if (boolA == null) {
                i = -1;
            } else {
                i = boolA.booleanValue() ? 1 : 0;
            }
            com.igexin.c.a.c.a.a(f37911a + "|getGuardMeFromFile gm= " + i, new Object[0]);
            return i;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }

    private static void b(Boolean bool) throws Throwable {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(j.e);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.startsWith("#")) {
                            sb.append(line);
                        } else {
                            String[] strArrSplit = line.split("=");
                            if (strArrSplit.length < 2) {
                                sb.append(line);
                            } else {
                                String strTrim = strArrSplit[0].trim();
                                strArrSplit[1].trim();
                                if (!strTrim.equals("sdk.debug")) {
                                    sb.append(line);
                                }
                            }
                        }
                        sb.append("\n");
                    }
                    sb.append("sdk.debug=".concat(String.valueOf(bool)));
                    byte[] bytes = sb.toString().getBytes();
                    if (bytes != null) {
                        j.a(bytes, j.e);
                    }
                    try {
                        bufferedReader2.close();
                    } catch (IOException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                    }
                } catch (Exception unused) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            com.igexin.c.a.c.a.a(e3);
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            com.igexin.c.a.c.a.a(e5);
                        }
                    }
                    if (fileInputStream == null) {
                        throw th;
                    }
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (Exception e6) {
                        com.igexin.c.a.c.a.a(e6);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static int c() {
        int i;
        try {
            Boolean boolA = com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.b);
            if (boolA == null) {
                i = -1;
            } else {
                i = boolA.booleanValue() ? 1 : 0;
            }
            com.igexin.c.a.c.a.a(f37911a + "|getGuardOthersFromFile gm= " + i, new Object[0]);
            return i;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }
}
