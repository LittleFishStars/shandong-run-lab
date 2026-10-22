package com.igexin.push.core;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.MotionEventCompat;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38074a = -1;
    public static final int b = 0;
    public static final int c = 1;
    private static final String d = "LoginInteractor";
    private static k e;

    public static k a() {
        if (e == null) {
            e = new k();
        }
        return e;
    }

    private static void a(List<com.igexin.push.d.c.j> list) {
        if (ServiceManager.getInstance().initType == null) {
            return;
        }
        int iIntValue = ((Integer) ServiceManager.getInstance().initType.first).intValue();
        String strValueOf = String.valueOf(iIntValue);
        if (iIntValue == 1) {
            strValueOf = strValueOf + "#" + ((String) ServiceManager.getInstance().initType.second);
        }
        com.igexin.push.d.c.j jVar = new com.igexin.push.d.c.j();
        jVar.f38104a = (byte) 5;
        jVar.b = strValueOf;
        list.add(jVar);
    }

    public static int b() {
        if (!e.s || !com.igexin.push.g.c.a()) {
            com.igexin.c.a.c.a.a(d, "keyNegotiate stop ++++++++++");
            com.igexin.c.a.c.a.a("LoginInteractor|keyNegotiate stop ++++++++++", new Object[0]);
            return -1;
        }
        com.igexin.push.d.c.g gVar = new com.igexin.push.d.c.g();
        gVar.b = e.f38001a;
        int iA = d.a.f37984a.h.a("K-", gVar, true);
        com.igexin.c.a.c.a.a("LoginInteractor|keyNegotiate result=".concat(String.valueOf(iA)), new Object[0]);
        return iA < 0 ? 0 : 1;
    }

    public static void c() {
        com.igexin.c.a.c.a.d.a().a("[LoginInteractor] Start login appid = " + e.f38001a);
        if (e.t) {
            e.t = false;
            e.T = System.currentTimeMillis() + (((long) Math.abs(new Random().nextInt() % 24)) * 3600000);
        }
        com.igexin.push.c.c.a().d().d();
        if (e.z != 0) {
            com.igexin.push.d.c.i iVarD = d();
            com.igexin.c.a.c.a.a("loginReqBefore|" + iVarD.b, new Object[0]);
            com.igexin.push.e.a aVar = d.a.f37984a.h;
            StringBuilder sb = new StringBuilder("S-");
            sb.append(e.z);
            if (aVar.a(sb.toString(), iVarD, true) >= 0) {
                String str = e.A;
                com.igexin.c.a.c.a.a("LoginInteractor|loginReq|" + e.A, new Object[0]);
                return;
            }
            return;
        }
        com.igexin.c.a.c.a.a("registerReq #####", new Object[0]);
        com.igexin.push.d.c.d dVar = new com.igexin.push.d.c.d(e.D, e.E, e.L, e.f38001a);
        String str2 = e.D;
        String str3 = e.E;
        String str4 = e.L;
        com.igexin.push.e.a aVar2 = d.a.f37984a.h;
        StringBuilder sb2 = new StringBuilder("R-");
        sb2.append(e.L);
        com.igexin.c.a.c.a.a("registerReq|" + (aVar2.a(sb2.toString(), dVar, true) >= 0) + "|" + e.L, new Object[0]);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005a A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:3:0x0015, B:15:0x004a, B:17:0x0050, B:19:0x005a, B:21:0x0068, B:22:0x0075, B:25:0x0081, B:27:0x0089, B:29:0x0091, B:30:0x00a0, B:32:0x00a4, B:34:0x00ae, B:35:0x00bb, B:37:0x00c3, B:39:0x00d7, B:40:0x00f3, B:49:0x0141, B:51:0x0147, B:48:0x013e, B:12:0x0044, B:5:0x001c, B:7:0x0028, B:9:0x002e, B:41:0x0100, B:42:0x0109, B:44:0x010f, B:45:0x012d), top: B:58:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0068 A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:3:0x0015, B:15:0x004a, B:17:0x0050, B:19:0x005a, B:21:0x0068, B:22:0x0075, B:25:0x0081, B:27:0x0089, B:29:0x0091, B:30:0x00a0, B:32:0x00a4, B:34:0x00ae, B:35:0x00bb, B:37:0x00c3, B:39:0x00d7, B:40:0x00f3, B:49:0x0141, B:51:0x0147, B:48:0x013e, B:12:0x0044, B:5:0x001c, B:7:0x0028, B:9:0x002e, B:41:0x0100, B:42:0x0109, B:44:0x010f, B:45:0x012d), top: B:58:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0081 A[Catch: all -> 0x014a, TRY_ENTER, TryCatch #1 {all -> 0x014a, blocks: (B:3:0x0015, B:15:0x004a, B:17:0x0050, B:19:0x005a, B:21:0x0068, B:22:0x0075, B:25:0x0081, B:27:0x0089, B:29:0x0091, B:30:0x00a0, B:32:0x00a4, B:34:0x00ae, B:35:0x00bb, B:37:0x00c3, B:39:0x00d7, B:40:0x00f3, B:49:0x0141, B:51:0x0147, B:48:0x013e, B:12:0x0044, B:5:0x001c, B:7:0x0028, B:9:0x002e, B:41:0x0100, B:42:0x0109, B:44:0x010f, B:45:0x012d), top: B:58:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a4 A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:3:0x0015, B:15:0x004a, B:17:0x0050, B:19:0x005a, B:21:0x0068, B:22:0x0075, B:25:0x0081, B:27:0x0089, B:29:0x0091, B:30:0x00a0, B:32:0x00a4, B:34:0x00ae, B:35:0x00bb, B:37:0x00c3, B:39:0x00d7, B:40:0x00f3, B:49:0x0141, B:51:0x0147, B:48:0x013e, B:12:0x0044, B:5:0x001c, B:7:0x0028, B:9:0x002e, B:41:0x0100, B:42:0x0109, B:44:0x010f, B:45:0x012d), top: B:58:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ae A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:3:0x0015, B:15:0x004a, B:17:0x0050, B:19:0x005a, B:21:0x0068, B:22:0x0075, B:25:0x0081, B:27:0x0089, B:29:0x0091, B:30:0x00a0, B:32:0x00a4, B:34:0x00ae, B:35:0x00bb, B:37:0x00c3, B:39:0x00d7, B:40:0x00f3, B:49:0x0141, B:51:0x0147, B:48:0x013e, B:12:0x0044, B:5:0x001c, B:7:0x0028, B:9:0x002e, B:41:0x0100, B:42:0x0109, B:44:0x010f, B:45:0x012d), top: B:58:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3 A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:3:0x0015, B:15:0x004a, B:17:0x0050, B:19:0x005a, B:21:0x0068, B:22:0x0075, B:25:0x0081, B:27:0x0089, B:29:0x0091, B:30:0x00a0, B:32:0x00a4, B:34:0x00ae, B:35:0x00bb, B:37:0x00c3, B:39:0x00d7, B:40:0x00f3, B:49:0x0141, B:51:0x0147, B:48:0x013e, B:12:0x0044, B:5:0x001c, B:7:0x0028, B:9:0x002e, B:41:0x0100, B:42:0x0109, B:44:0x010f, B:45:0x012d), top: B:58:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d7 A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:3:0x0015, B:15:0x004a, B:17:0x0050, B:19:0x005a, B:21:0x0068, B:22:0x0075, B:25:0x0081, B:27:0x0089, B:29:0x0091, B:30:0x00a0, B:32:0x00a4, B:34:0x00ae, B:35:0x00bb, B:37:0x00c3, B:39:0x00d7, B:40:0x00f3, B:49:0x0141, B:51:0x0147, B:48:0x013e, B:12:0x0044, B:5:0x001c, B:7:0x0028, B:9:0x002e, B:41:0x0100, B:42:0x0109, B:44:0x010f, B:45:0x012d), top: B:58:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x010f A[Catch: all -> 0x013d, LOOP:0: B:42:0x0109->B:44:0x010f, LOOP_END, TryCatch #2 {all -> 0x013d, blocks: (B:41:0x0100, B:42:0x0109, B:44:0x010f, B:45:0x012d), top: B:60:0x0100, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0147 A[Catch: all -> 0x014a, TRY_LEAVE, TryCatch #1 {all -> 0x014a, blocks: (B:3:0x0015, B:15:0x004a, B:17:0x0050, B:19:0x005a, B:21:0x0068, B:22:0x0075, B:25:0x0081, B:27:0x0089, B:29:0x0091, B:30:0x00a0, B:32:0x00a4, B:34:0x00ae, B:35:0x00bb, B:37:0x00c3, B:39:0x00d7, B:40:0x00f3, B:49:0x0141, B:51:0x0147, B:48:0x013e, B:12:0x0044, B:5:0x001c, B:7:0x0028, B:9:0x002e, B:41:0x0100, B:42:0x0109, B:44:0x010f, B:45:0x012d), top: B:58:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x00d7, please report this as an issue */
    public static com.igexin.push.d.c.i d() {
        String strP;
        StringBuilder sb;
        int iIntValue;
        String strValueOf;
        String strT;
        String[] strArrSplit;
        Pair<String, String> pairB;
        String str;
        String str2;
        NetworkInfo activeNetworkInfo;
        com.igexin.push.d.c.i iVar = new com.igexin.push.d.c.i();
        iVar.b = e.z;
        iVar.c = (byte) 0;
        iVar.d = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        iVar.e = e.f38001a;
        try {
            ArrayList<com.igexin.push.d.c.j> arrayList = new ArrayList();
            int type = -1;
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) e.l.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    if (type == 1 && (pairB = com.igexin.push.g.n.b()) != null) {
                        str = (String) pairB.first;
                        str2 = (String) pairB.second;
                        if (str != null) {
                            com.igexin.push.d.c.j jVar = new com.igexin.push.d.c.j();
                            jVar.f38104a = (byte) 1;
                            jVar.b = str;
                            arrayList.add(jVar);
                        }
                        if (str2 != null) {
                            com.igexin.push.d.c.j jVar2 = new com.igexin.push.d.c.j();
                            jVar2.f38104a = (byte) 4;
                            jVar2.b = str2;
                            arrayList.add(jVar2);
                        }
                    }
                    strP = com.igexin.push.g.n.p();
                    if (!TextUtils.isEmpty(strP)) {
                        strArrSplit = strP.split("#");
                        if (strArrSplit.length >= 3 && !TextUtils.isEmpty(strArrSplit[2])) {
                            com.igexin.push.d.c.j jVar3 = new com.igexin.push.d.c.j();
                            jVar3.f38104a = (byte) 6;
                            jVar3.b = strArrSplit[2];
                            arrayList.add(jVar3);
                        }
                    }
                    if (com.igexin.push.config.d.am) {
                        strT = com.igexin.push.g.n.t();
                        if (!TextUtils.isEmpty(strT)) {
                            com.igexin.push.d.c.j jVar4 = new com.igexin.push.d.c.j();
                            jVar4.f38104a = (byte) 7;
                            jVar4.b = strT;
                            arrayList.add(jVar4);
                        }
                    }
                    if (ServiceManager.getInstance().initType != null) {
                        iIntValue = ((Integer) ServiceManager.getInstance().initType.first).intValue();
                        strValueOf = String.valueOf(iIntValue);
                        if (iIntValue == 1) {
                            strValueOf = strValueOf + "#" + ((String) ServiceManager.getInstance().initType.second);
                        }
                        com.igexin.push.d.c.j jVar5 = new com.igexin.push.d.c.j();
                        jVar5.f38104a = (byte) 5;
                        jVar5.b = strValueOf;
                        arrayList.add(jVar5);
                    }
                    try {
                        sb = new StringBuilder();
                        for (com.igexin.push.d.c.j jVar6 : arrayList) {
                            sb.append((int) jVar6.f38104a);
                            sb.append(u15.f19942b);
                            sb.append((String) jVar6.b);
                            sb.append("|");
                        }
                        com.igexin.c.a.c.a.a("LoginInteractor| ".concat(String.valueOf(sb)), new Object[0]);
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                    if (!arrayList.isEmpty()) {
                        iVar.f = arrayList;
                    }
                } else {
                    type = activeNetworkInfo.getType();
                    com.igexin.push.d.c.j jVar7 = new com.igexin.push.d.c.j();
                    jVar7.f38104a = (byte) 2;
                    jVar7.b = String.valueOf(type);
                    arrayList.add(jVar7);
                    if (type == 1) {
                        str = (String) pairB.first;
                        str2 = (String) pairB.second;
                        if (str != null) {
                            com.igexin.push.d.c.j jVar8 = new com.igexin.push.d.c.j();
                            jVar8.f38104a = (byte) 1;
                            jVar8.b = str;
                            arrayList.add(jVar8);
                        }
                        if (str2 != null) {
                            com.igexin.push.d.c.j jVar9 = new com.igexin.push.d.c.j();
                            jVar9.f38104a = (byte) 4;
                            jVar9.b = str2;
                            arrayList.add(jVar9);
                        }
                    }
                    strP = com.igexin.push.g.n.p();
                    if (!TextUtils.isEmpty(strP)) {
                        strArrSplit = strP.split("#");
                        if (strArrSplit.length >= 3) {
                            com.igexin.push.d.c.j jVar10 = new com.igexin.push.d.c.j();
                            jVar10.f38104a = (byte) 6;
                            jVar10.b = strArrSplit[2];
                            arrayList.add(jVar10);
                        }
                    }
                    if (com.igexin.push.config.d.am) {
                        strT = com.igexin.push.g.n.t();
                        if (!TextUtils.isEmpty(strT)) {
                            com.igexin.push.d.c.j jVar11 = new com.igexin.push.d.c.j();
                            jVar11.f38104a = (byte) 7;
                            jVar11.b = strT;
                            arrayList.add(jVar11);
                        }
                    }
                    if (ServiceManager.getInstance().initType != null) {
                        iIntValue = ((Integer) ServiceManager.getInstance().initType.first).intValue();
                        strValueOf = String.valueOf(iIntValue);
                        if (iIntValue == 1) {
                            strValueOf = strValueOf + "#" + ((String) ServiceManager.getInstance().initType.second);
                        }
                        com.igexin.push.d.c.j jVar12 = new com.igexin.push.d.c.j();
                        jVar12.f38104a = (byte) 5;
                        jVar12.b = strValueOf;
                        arrayList.add(jVar12);
                    }
                    sb = new StringBuilder();
                    while (r4.hasNext()) {
                        sb.append((int) jVar6.f38104a);
                        sb.append(u15.f19942b);
                        sb.append((String) jVar6.b);
                        sb.append("|");
                    }
                    com.igexin.c.a.c.a.a("LoginInteractor| ".concat(String.valueOf(sb)), new Object[0]);
                    if (!arrayList.isEmpty()) {
                        iVar.f = arrayList;
                    }
                }
            } catch (Throwable th2) {
                com.igexin.c.a.c.a.a(th2);
            }
        } catch (Throwable th3) {
            com.igexin.c.a.c.a.a(th3);
        }
        return iVar;
    }
}
