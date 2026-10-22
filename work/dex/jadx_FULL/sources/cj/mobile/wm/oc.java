package cj.mobile.wm;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class oc {
    public String dexa;
    public String dexb;
    public boolean dexc;
    public boolean dexd;
    public boolean dexe;
    public SharedPreferences dexf;
    public nc dexg;
    public SharedPreferences.Editor dexh = null;
    public nc.dexa dexi = null;
    public Context dexj;
    public pc dexk;
    public boolean dexl;

    /* JADX WARN: Code duplicated, block: B:19:0x005b  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f2  */
    public oc(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        long j;
        long jDexa;
        SharedPreferences sharedPreferences;
        nc ncVar;
        nc ncVar2;
        this.dexd = false;
        this.dexe = false;
        String externalStorageState = null;
        this.dexf = null;
        this.dexg = null;
        this.dexk = null;
        this.dexc = z;
        this.dexl = z2;
        this.dexa = str2;
        this.dexb = str;
        this.dexj = context;
        if (context != null) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(str2, 0);
            this.dexf = sharedPreferences2;
            j = sharedPreferences2.getLong("t", 0L);
        } else {
            j = 0;
        }
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (lc.dexb(externalStorageState)) {
            this.dexe = false;
            this.dexd = false;
        } else if (externalStorageState.equals("mounted")) {
            this.dexe = true;
            this.dexd = true;
        } else if (externalStorageState.equals("mounted_ro")) {
            this.dexd = true;
            this.dexe = false;
        } else {
            this.dexe = false;
            this.dexd = false;
        }
        if ((!this.dexd && !this.dexe) || context == null || lc.dexb(str)) {
            jDexa = 0;
        } else {
            pc pcVarDexd = dexd(str);
            this.dexk = pcVarDexd;
            if (pcVarDexd != null) {
                try {
                    nc ncVarDexa = pcVarDexd.dexa(str2, 0);
                    this.dexg = ncVarDexa;
                    jDexa = ncVarDexa.dexa("t", 0L);
                    try {
                        if (z2) {
                            j = this.dexf.getLong("t2", 0L);
                            jDexa = this.dexg.dexa("t2", 0L);
                            if (j >= jDexa || j <= 0) {
                                if (j > jDexa && jDexa > 0) {
                                    ncVar2 = this.dexg;
                                } else if (j == 0 && jDexa > 0) {
                                    ncVar2 = this.dexg;
                                } else if ((jDexa == 0 && j > 0) || j == jDexa) {
                                    sharedPreferences = this.dexf;
                                    ncVar = this.dexg;
                                }
                                dexa(ncVar2, this.dexf);
                                this.dexf = context.getSharedPreferences(str2, 0);
                            } else {
                                sharedPreferences = this.dexf;
                                ncVar = this.dexg;
                            }
                            dexa(sharedPreferences, ncVar);
                            this.dexg = this.dexk.dexa(str2, 0);
                        } else {
                            if (j > jDexa) {
                                sharedPreferences = this.dexf;
                                ncVar = this.dexg;
                            } else if (j < jDexa) {
                                ncVar2 = this.dexg;
                                dexa(ncVar2, this.dexf);
                                this.dexf = context.getSharedPreferences(str2, 0);
                            } else if (j == jDexa) {
                                sharedPreferences = this.dexf;
                                ncVar = this.dexg;
                            }
                            dexa(sharedPreferences, ncVar);
                            this.dexg = this.dexk.dexa(str2, 0);
                        }
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    jDexa = 0;
                }
            } else {
                jDexa = 0;
            }
        }
        if (j != jDexa || (j == 0 && jDexa == 0)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z3 = this.dexl;
            if (!z3 || (z3 && j == 0 && jDexa == 0)) {
                SharedPreferences sharedPreferences3 = this.dexf;
                if (sharedPreferences3 != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences3.edit();
                    editorEdit.putLong("t2", jCurrentTimeMillis);
                    editorEdit.commit();
                }
                try {
                    nc ncVar3 = this.dexg;
                    if (ncVar3 != null) {
                        nc.dexa dexaVarB = ncVar3.b();
                        dexaVarB.dexa("t2", jCurrentTimeMillis);
                        dexaVarB.a();
                    }
                } catch (Exception unused3) {
                }
            }
        }
    }

    private void dexa(SharedPreferences sharedPreferences, nc ncVar) {
        nc.dexa dexaVarB;
        if (sharedPreferences == null || ncVar == null || (dexaVarB = ncVar.b()) == null) {
            return;
        }
        dexaVarB.clear();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                dexaVarB.a(key, (String) value);
            } else if (value instanceof Integer) {
                dexaVarB.dexa(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                dexaVarB.dexa(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                dexaVarB.dexa(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                dexaVarB.dexa(key, ((Boolean) value).booleanValue());
            }
        }
        dexaVarB.a();
    }

    private void dexa(nc ncVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit;
        if (ncVar == null || sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.clear();
        for (Map.Entry<String, ?> entry : ncVar.c().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                editorEdit.putString(key, (String) value);
            } else if (value instanceof Integer) {
                editorEdit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                editorEdit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                editorEdit.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        editorEdit.commit();
    }

    private boolean dexb() throws Throwable {
        nc ncVar = this.dexg;
        if (ncVar == null) {
            return false;
        }
        boolean zA = ncVar.a();
        if (!zA) {
            dexa();
        }
        return zA;
    }

    private File dexc(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private void dexc() throws Throwable {
        nc ncVar;
        SharedPreferences sharedPreferences;
        if (this.dexh == null && (sharedPreferences = this.dexf) != null) {
            this.dexh = sharedPreferences.edit();
        }
        if (this.dexe && this.dexi == null && (ncVar = this.dexg) != null) {
            this.dexi = ncVar.b();
        }
        dexb();
    }

    private pc dexd(String str) {
        File fileDexc = dexc(str);
        if (fileDexc == null) {
            return null;
        }
        pc pcVar = new pc(fileDexc.getAbsolutePath());
        this.dexk = pcVar;
        return pcVar;
    }

    public String dexa(String str) throws Throwable {
        dexb();
        SharedPreferences sharedPreferences = this.dexf;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!lc.dexb(string)) {
                return string;
            }
        }
        nc ncVar = this.dexg;
        return ncVar != null ? ncVar.a(str, "") : "";
    }

    public void dexa(String str, String str2) throws Throwable {
        if (lc.dexb(str) || str.equals("t")) {
            return;
        }
        dexc();
        SharedPreferences.Editor editor = this.dexh;
        if (editor != null) {
            editor.putString(str, str2);
        }
        nc.dexa dexaVar = this.dexi;
        if (dexaVar != null) {
            dexaVar.a(str, str2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    public boolean dexa() throws Throwable {
        boolean z;
        String externalStorageState;
        Context context;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.dexh;
        if (editor == null) {
            z = true;
        } else {
            if (!this.dexl && this.dexf != null) {
                editor.putLong("t", jCurrentTimeMillis);
            }
            if (this.dexh.commit()) {
                z = true;
            } else {
                z = false;
            }
        }
        if (this.dexf != null && (context = this.dexj) != null) {
            this.dexf = context.getSharedPreferences(this.dexa, 0);
        }
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
            externalStorageState = null;
        }
        if (!lc.dexb(externalStorageState)) {
            if (externalStorageState.equals("mounted")) {
                if (this.dexg == null) {
                    pc pcVarDexd = dexd(this.dexb);
                    if (pcVarDexd != null) {
                        nc ncVarDexa = pcVarDexd.dexa(this.dexa, 0);
                        this.dexg = ncVarDexa;
                        if (this.dexl) {
                            dexa(ncVarDexa, this.dexf);
                        } else {
                            dexa(this.dexf, ncVarDexa);
                        }
                        this.dexi = this.dexg.b();
                    }
                } else {
                    nc.dexa dexaVar = this.dexi;
                    if (dexaVar != null && !dexaVar.a()) {
                        z = false;
                    }
                }
            }
            if (externalStorageState.equals("mounted") || (externalStorageState.equals("mounted_ro") && this.dexg != null)) {
                try {
                    pc pcVar = this.dexk;
                    if (pcVar != null) {
                        this.dexg = pcVar.dexa(this.dexa, 0);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return z;
    }

    public void dexb(String str) throws Throwable {
        if (lc.dexb(str) || str.equals("t")) {
            return;
        }
        dexc();
        SharedPreferences.Editor editor = this.dexh;
        if (editor != null) {
            editor.remove(str);
        }
        nc.dexa dexaVar = this.dexi;
        if (dexaVar != null) {
            dexaVar.a(str);
        }
    }
}
