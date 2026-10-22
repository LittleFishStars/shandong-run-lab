package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class mna extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f43343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public yna f18267a;

    public mna(Context context) {
        this.f43343a = context;
        this.f18267a = yna.b(context);
    }

    public static tna a(File file) throws Throwable {
        String strW = zwa.w(file);
        tna tnaVar = new tna();
        tnaVar.o(strW);
        return tnaVar;
    }

    public static boolean e(String str, ArrayList<tna> arrayList) {
        Iterator<tna> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().j())) {
                return true;
            }
        }
        return false;
    }

    public final tna b(String str) throws Throwable {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        com.amap.api.col.p0003l.ay ayVarB = com.amap.api.col.p0003l.ay.b(this.f43343a);
        tna tnaVarA = null;
        if (ayVarB != null) {
            String strD = ayVarB.D(str);
            File[] fileArrListFiles = new File(zwa.f0(this.f43343a)).listFiles();
            if (fileArrListFiles == null) {
                return null;
            }
            for (File file : fileArrListFiles) {
                if ((file.getName().contains(strD) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) {
                    tnaVarA = a(file);
                    if (tnaVarA.a() != null) {
                        return tnaVarA;
                    }
                }
            }
        }
        return tnaVarA;
    }

    public final void c() {
        tna tnaVarB;
        String strI;
        int iIndexOf;
        boolean z;
        String strI2;
        int iIndexOf2;
        String strI3;
        int iIndexOf3;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<tna> arrayListC = this.f18267a.c();
        d(arrayList, "vmap/");
        d(arrayList, "map/");
        g(arrayList, "map/");
        ArrayList<String> arrayListF = f();
        for (tna tnaVar : arrayListC) {
            if (tnaVar != null && tnaVar.a() != null) {
                int i = ((wna) tnaVar).c;
                boolean z2 = true;
                if (i == 4 || i == 7) {
                    boolean zContains = arrayList.contains(tnaVar.j());
                    if (zContains || (strI = boa.i(tnaVar.g())) == null || (iIndexOf = arrayList.indexOf(strI)) == -1) {
                        z2 = zContains;
                    } else {
                        arrayList.set(iIndexOf, tnaVar.j());
                    }
                    if (!z2) {
                        this.f18267a.k(tnaVar);
                    }
                } else if (i == 0 || i == 1) {
                    z = arrayListF.contains(tnaVar.e()) || arrayListF.contains(tnaVar.j());
                    if (z || (strI2 = boa.i(tnaVar.g())) == null || (iIndexOf2 = arrayListF.indexOf(strI2)) == -1) {
                        z2 = z;
                    } else {
                        arrayListF.set(iIndexOf2, tnaVar.j());
                    }
                    if (!z2) {
                        this.f18267a.k(tnaVar);
                    }
                } else if (i == 3 && tnaVar.i() != 0) {
                    z = arrayListF.contains(tnaVar.e()) || arrayListF.contains(tnaVar.j());
                    if (z || (strI3 = boa.i(tnaVar.g())) == null || (iIndexOf3 = arrayListF.indexOf(strI3)) == -1) {
                        z2 = z;
                    } else {
                        arrayListF.set(iIndexOf3, tnaVar.j());
                    }
                    if (!z2) {
                        this.f18267a.k(tnaVar);
                    }
                }
            }
        }
        for (String str : arrayList) {
            if (!e(str, arrayListC) && (tnaVarB = b(str)) != null) {
                this.f18267a.e(tnaVarB);
            }
        }
        com.amap.api.col.p0003l.ay ayVarB = com.amap.api.col.p0003l.ay.b(this.f43343a);
        if (ayVarB != null) {
            ayVarB.j();
        }
    }

    public final void d(ArrayList<String> arrayList, String str) {
        File[] fileArrListFiles;
        String name;
        int iLastIndexOf;
        File file = new File(zwa.X(this.f43343a) + str);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.getName().endsWith(".dat") && (iLastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && iLastIndexOf < name.length()) {
                    String strSubstring = name.substring(0, iLastIndexOf);
                    if (!arrayList.contains(strSubstring)) {
                        arrayList.add(strSubstring);
                    }
                }
            }
        }
    }

    public final ArrayList<String> f() {
        File[] fileArrListFiles;
        String name;
        int iLastIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(zwa.f0(this.f43343a));
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
            return arrayList;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.getName().endsWith(".zip") && (iLastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && iLastIndexOf < name.length()) {
                arrayList.add(name.substring(0, iLastIndexOf));
            }
        }
        return arrayList;
    }

    public final void g(ArrayList<String> arrayList, String str) {
        File[] fileArrListFiles;
        String[] list;
        File file = new File(zwa.v(this.f43343a) + str);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && (list = file2.list()) != null && list.length > 0 && !arrayList.contains(name)) {
                        boolean z = true;
                        if (!name.equals("a0")) {
                            boolean z2 = false;
                            boolean z3 = false;
                            for (String str2 : list) {
                                if ("m1.ans".equals(str2)) {
                                    z2 = true;
                                }
                                if ("m3.ans".equals(str2)) {
                                    z3 = true;
                                }
                            }
                            if (!z2 || !z3) {
                                z = false;
                                break;
                            }
                        } else {
                            int length = list.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    z = false;
                                    break;
                                } else if ("m1.ans".equals(list[i])) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                        }
                        if (z) {
                            arrayList.add(name);
                        }
                    }
                }
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
