package com.byazt.ut;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.SparseArray;
import com.byazt.dna.nu;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 834, 34})
public class a implements nu, Function {
    public static final int TYPE_NEW_SHARED_PREFERENCES = 3;
    public static File tt;
    public static final Set<String> ve = new HashSet();
    public Map<String, com.byazt.iy.n> c = new ConcurrentHashMap();

    public a() {
        ve.add("sp_bidding_opt_libra");
    }

    private com.byazt.iy.n c(String str) {
        int iFr = gt.tt().fr();
        com.byazt.ogz.a aVarYt = gt.tt().yt();
        if (iFr != 3 || Build.VERSION.SDK_INT == 27) {
            return new com.byazt.wr.uj(gt.getContext().getSharedPreferences(tt(str), 0));
        }
        File spFile = getSpFile(str);
        return new com.byazt.wr.ve(spFile, c(spFile, str), c(str, aVarYt.c), aVarYt.tt);
    }

    public static com.byazt.iy.n getKVStore(String str) {
        return ((nu) uj.getService("kv_store_factory")).get(str);
    }

    public static File getSpFile(String str) {
        if (tt == null) {
            tt = ve();
        }
        return new File(tt, tt(str) + ".xml");
    }

    private com.byazt.yy.tt tt() {
        return com.byazt.wr.n.c() ? new com.byazt.wr.n(null) : new com.byazt.wr.a(null);
    }

    private static File ve() {
        String name;
        File fileC = com.byazt.nr.sp.c(gt.getContext(), false, null);
        do {
            name = fileC.getName();
            if (name == null) {
                break;
            }
            fileC = fileC.getParentFile();
        } while (!name.equals("files"));
        return new File(fileC, "shared_prefs");
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            com.byazt.iy.n nVar = get((String) sparseArray.get(1));
            return nVar != null ? new com.byazt.iy.a(nVar) : nVar;
        }
        if (iIntValue == 2) {
            com.byazt.iy.n nVar2 = get((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
            return nVar2 != null ? new com.byazt.iy.a(nVar2) : nVar2;
        }
        if (iIntValue == 3) {
            com.byazt.iy.ve encrypt = getEncrypt(((Integer) sparseArray.get(1)).intValue());
            return encrypt != null ? new com.byazt.iy.uj(encrypt) : encrypt;
        }
        if (iIntValue == 4) {
            store();
            return null;
        }
        if (iIntValue != 5) {
            return null;
        }
        clear();
        return null;
    }

    @Override // com.byazt.dna.nu
    public void clear() {
        synchronized (this.c) {
            this.c.clear();
        }
    }

    @Override // com.byazt.dna.nu
    public com.byazt.iy.n get(String str) {
        if (str == null) {
            str = "tt_sp";
        }
        com.byazt.iy.n nVar = this.c.get(str);
        if (nVar != null) {
            return nVar;
        }
        synchronized (this.c) {
            com.byazt.iy.n nVar2 = this.c.get(str);
            if (nVar2 != null) {
                return nVar2;
            }
            com.byazt.iy.n nVarC = c(str);
            this.c.put(str, nVarC);
            return nVarC;
        }
    }

    @Override // com.byazt.dna.nu
    public com.byazt.iy.ve getEncrypt(int i) {
        if (i != 32) {
            return null;
        }
        return new com.byazt.et.c();
    }

    @Override // com.byazt.dna.nu
    public void store() {
        Iterator<String> it = this.c.keySet().iterator();
        while (it.hasNext()) {
            com.byazt.iy.n nVar = this.c.get(it.next());
            if (nVar != null) {
                nVar.apply();
            }
        }
    }

    public static SharedPreferences getKVStore(@ForbidWrapParam Context context, String str, int i) {
        return getKVStore(str);
    }

    private static String tt(String str) {
        return !str.startsWith("pangle_") ? "pangle_com.byted.pangle_".concat(str) : str;
    }

    @Override // com.byazt.dna.nu
    public com.byazt.iy.n get(String str, int i) {
        return get(str);
    }

    private com.byazt.yy.c c(File file, String str) {
        if (ve.contains(str)) {
            return c();
        }
        if (p.uj >= 6900) {
            c(file);
            return new com.byazt.wr.c(null);
        }
        return c();
    }

    private com.byazt.yy.tt c(String str, boolean z) {
        if (ve.contains(str)) {
            return tt();
        }
        com.byazt.et.c cVar = z ? new com.byazt.et.c() : null;
        if (Build.VERSION.SDK_INT != 27 && p.uj >= 6900) {
            return new com.byazt.wr.c(cVar);
        }
        return tt();
    }

    private com.byazt.yy.c c() {
        if (com.byazt.wr.n.c()) {
            return new com.byazt.wr.n(null);
        }
        return new com.byazt.wr.a(null);
    }

    private void c(File file) {
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (!file2.exists() || file2.length() <= 0) {
            return;
        }
        file.delete();
    }
}
