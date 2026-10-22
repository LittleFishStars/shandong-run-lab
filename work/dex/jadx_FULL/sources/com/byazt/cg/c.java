package com.byazt.cg;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.byazt.dna.or;
import com.byazt.nr.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 549, 20})
public class c implements or {
    @SuppressLint({"[ByDesign12.1]UsingRuntimeExec"})
    private String c(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
                try {
                    String line = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        m.ve("SystemPropAdb", "Exception while closing InputStream", e);
                    }
                    try {
                        processExec.destroy();
                    } catch (Throwable unused) {
                    }
                    return line;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        m.ve("SystemPropAdb", "Unable to read sysprop ".concat(String.valueOf(str)), th);
                        if (processExec == null) {
                            return "";
                        }
                        try {
                            return "";
                        } catch (Throwable unused2) {
                            return "";
                        }
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                m.ve("SystemPropAdb", "Exception while closing InputStream", e2);
                            }
                        }
                        if (processExec != null) {
                            try {
                                processExec.destroy();
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            processExec = null;
        }
    }

    @Override // com.byazt.dna.or
    public String get(String str) {
        return c(str);
    }

    @Override // com.byazt.dna.or
    public boolean getBoolean(String str) {
        String strC = c(str);
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        try {
            return Boolean.parseBoolean(strC);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.byazt.dna.or
    public int getInt(String str) {
        String strC = c(str);
        if (TextUtils.isEmpty(strC)) {
            return 0;
        }
        try {
            return Integer.parseInt(strC);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.byazt.dna.or
    public long getLong(String str) {
        String strC = c(str);
        if (TextUtils.isEmpty(strC)) {
            return 0L;
        }
        try {
            return Long.parseLong(strC);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.byazt.dna.or
    public void set(String str, String str2) {
    }
}
