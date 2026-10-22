package com.blankj.utilcode.util;

import androidx.annotation.NonNull;
import cn.hzjizhun.admin.util.ShellUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28228a = System.getProperty("line.separator");

    public class a extends Utils.Task<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f28229a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Utils.Consumer consumer, String[] strArr, boolean z, boolean z2) {
            super(consumer);
            this.f28229a = strArr;
            this.b = z;
            this.c = z2;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public b f() {
            return g.j(this.f28229a, this.b, this.c);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28230a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1450a;
        public String b;

        public b(int i, String str, String str2) {
            this.f28230a = i;
            this.f1450a = str;
            this.b = str2;
        }

        public String toString() {
            return "result: " + this.f28230a + "\nsuccessMsg: " + this.f1450a + "\nerrorMsg: " + this.b;
        }
    }

    public g() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static b a(String str, List<String> list, boolean z) {
        return k(new String[]{str}, list == null ? null : (String[]) list.toArray(new String[0]), z, true);
    }

    public static b b(String str, List<String> list, boolean z, boolean z2) {
        return k(new String[]{str}, list == null ? null : (String[]) list.toArray(new String[0]), z, z2);
    }

    public static b c(String str, boolean z) {
        return j(new String[]{str}, z, true);
    }

    public static b d(String str, boolean z, boolean z2) {
        return j(new String[]{str}, z, z2);
    }

    public static b e(String str, String[] strArr, boolean z, boolean z2) {
        return k(new String[]{str}, strArr, z, z2);
    }

    public static b f(List<String> list, List<String> list2, boolean z) {
        return k(list == null ? null : (String[]) list.toArray(new String[0]), list2 != null ? (String[]) list2.toArray(new String[0]) : null, z, true);
    }

    public static b g(List<String> list, boolean z) {
        return j(list == null ? null : (String[]) list.toArray(new String[0]), z, true);
    }

    public static b h(List<String> list, boolean z, boolean z2) {
        return j(list == null ? null : (String[]) list.toArray(new String[0]), z, z2);
    }

    public static b i(String[] strArr, boolean z) {
        return j(strArr, z, true);
    }

    public static b j(String[] strArr, boolean z, boolean z2) {
        return k(strArr, null, z, z2);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0137  */
    /* JADX WARN: Code duplicated, block: B:106:0x013f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0141  */
    /* JADX WARN: Code duplicated, block: B:110:0x0148  */
    /* JADX WARN: Code duplicated, block: B:130:0x0171  */
    /* JADX WARN: Code duplicated, block: B:136:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static b k(String[] strArr, String[] strArr2, boolean z, boolean z2) throws Throwable {
        Process processExec;
        ?? bufferedReader;
        StringBuilder sb;
        ?? bufferedReader2;
        StringBuilder sb2;
        StringBuilder sb3;
        String string;
        ?? r5;
        int iWaitFor = -1;
        if (strArr == null || strArr.length == 0) {
            return new b(-1, "", "");
        }
        DataOutputStream dataOutputStream = null;
        ?? r3 = 0;
        dataOutputStream = null;
        try {
            processExec = Runtime.getRuntime().exec(z ? "su" : ShellUtils.COMMAND_SH, strArr2, (File) null);
            try {
                DataOutputStream dataOutputStream2 = new DataOutputStream(processExec.getOutputStream());
                try {
                    try {
                        for (String str : strArr) {
                            if (str != null) {
                                dataOutputStream2.write(str.getBytes());
                                dataOutputStream2.writeBytes(f28228a);
                                dataOutputStream2.flush();
                            }
                        }
                        dataOutputStream2.writeBytes(com.alipay.sdk.m.c0.d.A + f28228a);
                        dataOutputStream2.flush();
                        iWaitFor = processExec.waitFor();
                        if (z2) {
                            sb3 = new StringBuilder();
                            try {
                                sb2 = new StringBuilder();
                                try {
                                    bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream(), "UTF-8"));
                                    try {
                                        bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getErrorStream(), "UTF-8"));
                                        try {
                                            String line = bufferedReader.readLine();
                                            if (line != null) {
                                                sb3.append(line);
                                                while (true) {
                                                    String line2 = bufferedReader.readLine();
                                                    if (line2 == null) {
                                                        break;
                                                    }
                                                    sb3.append(f28228a);
                                                    sb3.append(line2);
                                                }
                                            }
                                            String line3 = bufferedReader2.readLine();
                                            if (line3 != null) {
                                                sb2.append(line3);
                                                while (true) {
                                                    String line4 = bufferedReader2.readLine();
                                                    if (line4 == null) {
                                                        break;
                                                    }
                                                    sb2.append(f28228a);
                                                    sb2.append(line4);
                                                }
                                            }
                                            r3 = bufferedReader;
                                            r5 = bufferedReader2;
                                        } catch (Exception e) {
                                            e = e;
                                            dataOutputStream = dataOutputStream2;
                                            sb = sb3;
                                            e = e;
                                            bufferedReader = bufferedReader;
                                            bufferedReader2 = bufferedReader2;
                                            try {
                                                e.printStackTrace();
                                                if (dataOutputStream != null) {
                                                    try {
                                                        dataOutputStream.close();
                                                    } catch (IOException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                                if (bufferedReader != 0) {
                                                    try {
                                                        bufferedReader.close();
                                                    } catch (IOException e3) {
                                                        e3.printStackTrace();
                                                    }
                                                }
                                                if (bufferedReader2 != 0) {
                                                    try {
                                                        bufferedReader2.close();
                                                    } catch (IOException e4) {
                                                        e4.printStackTrace();
                                                    }
                                                }
                                                if (processExec != null) {
                                                    processExec.destroy();
                                                }
                                                sb3 = sb;
                                            } catch (Throwable th) {
                                                th = th;
                                                if (dataOutputStream != null) {
                                                    try {
                                                        dataOutputStream.close();
                                                    } catch (IOException e5) {
                                                        e5.printStackTrace();
                                                    }
                                                }
                                                if (bufferedReader != 0) {
                                                    try {
                                                        bufferedReader.close();
                                                    } catch (IOException e6) {
                                                        e6.printStackTrace();
                                                    }
                                                }
                                                if (bufferedReader2 != 0) {
                                                    try {
                                                        bufferedReader2.close();
                                                    } catch (IOException e7) {
                                                        e7.printStackTrace();
                                                    }
                                                }
                                                if (processExec == null) {
                                                    throw th;
                                                }
                                                processExec.destroy();
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            dataOutputStream = dataOutputStream2;
                                            if (dataOutputStream != null) {
                                                dataOutputStream.close();
                                            }
                                            if (bufferedReader != 0) {
                                                bufferedReader.close();
                                            }
                                            if (bufferedReader2 != 0) {
                                                bufferedReader2.close();
                                            }
                                            if (processExec == null) {
                                                throw th;
                                            }
                                            processExec.destroy();
                                            throw th;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        bufferedReader2 = 0;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        bufferedReader2 = 0;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                    bufferedReader = 0;
                                    bufferedReader2 = 0;
                                }
                            } catch (Exception e10) {
                                bufferedReader = 0;
                                bufferedReader2 = 0;
                                dataOutputStream = dataOutputStream2;
                                sb = sb3;
                                e = e10;
                                sb2 = null;
                            }
                        } else {
                            sb3 = null;
                            sb2 = null;
                            r5 = 0;
                        }
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                        if (r3 != 0) {
                            try {
                                r3.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        if (r5 != 0) {
                            try {
                                r5.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        processExec.destroy();
                    } catch (Exception e14) {
                        e = e14;
                        sb2 = null;
                        bufferedReader = 0;
                        bufferedReader2 = 0;
                        dataOutputStream = dataOutputStream2;
                        sb = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = 0;
                    bufferedReader2 = 0;
                }
            } catch (Exception e15) {
                e = e15;
                sb = null;
                sb2 = sb;
                StringBuilder sb4 = sb2;
                bufferedReader2 = sb4;
                bufferedReader = sb4;
                e.printStackTrace();
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (bufferedReader != 0) {
                    bufferedReader.close();
                }
                if (bufferedReader2 != 0) {
                    bufferedReader2.close();
                }
                if (processExec != null) {
                    processExec.destroy();
                }
                sb3 = sb;
                if (sb3 == null) {
                    string = "";
                } else {
                    string = sb3.toString();
                }
                return new b(iWaitFor, string, sb2 != null ? sb2.toString() : "");
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = 0;
                bufferedReader2 = bufferedReader;
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (bufferedReader != 0) {
                    bufferedReader.close();
                }
                if (bufferedReader2 != 0) {
                    bufferedReader2.close();
                }
                if (processExec == null) {
                    throw th;
                }
                processExec.destroy();
                throw th;
            }
        } catch (Exception e16) {
            e = e16;
            processExec = null;
            sb = null;
        } catch (Throwable th6) {
            th = th6;
            processExec = null;
            bufferedReader = 0;
        }
        if (sb3 == null) {
            string = "";
        } else {
            string = sb3.toString();
        }
        return new b(iWaitFor, string, sb2 != null ? sb2.toString() : "");
    }

    public static Utils.Task<b> l(String str, boolean z, Utils.Consumer<b> consumer) {
        return q(new String[]{str}, z, true, consumer);
    }

    public static Utils.Task<b> m(String str, boolean z, boolean z2, Utils.Consumer<b> consumer) {
        return q(new String[]{str}, z, z2, consumer);
    }

    public static Utils.Task<b> n(List<String> list, boolean z, Utils.Consumer<b> consumer) {
        return q(list == null ? null : (String[]) list.toArray(new String[0]), z, true, consumer);
    }

    public static Utils.Task<b> o(List<String> list, boolean z, boolean z2, Utils.Consumer<b> consumer) {
        return q(list == null ? null : (String[]) list.toArray(new String[0]), z, z2, consumer);
    }

    public static Utils.Task<b> p(String[] strArr, boolean z, Utils.Consumer<b> consumer) {
        return q(strArr, z, true, consumer);
    }

    public static Utils.Task<b> q(String[] strArr, boolean z, boolean z2, @NonNull Utils.Consumer<b> consumer) {
        return i.u(new a(consumer, strArr, z, z2));
    }
}
