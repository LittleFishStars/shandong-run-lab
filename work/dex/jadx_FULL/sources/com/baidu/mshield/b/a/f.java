package com.baidu.mshield.b.a;

import cn.hzjizhun.admin.util.ShellUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26700a;
        public String b;
        public String c;

        public a(int i, String str, String str2) {
            this.f26700a = i;
            this.b = str;
            this.c = str2;
        }

        public String toString() {
            return "CommandResult{result=" + this.f26700a + ", successMsg='" + this.b + "', errorMsg='" + this.c + "'}";
        }
    }

    public static a a(String str, boolean z) {
        return a(new String[]{str}, z, true);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0142 A[Catch: IOException -> 0x0139, TRY_LEAVE, TryCatch #0 {IOException -> 0x0139, blocks: (B:95:0x0135, B:99:0x013d, B:101:0x0142), top: B:125:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0165 A[Catch: IOException -> 0x0161, TryCatch #12 {IOException -> 0x0161, blocks: (B:111:0x015d, B:115:0x0165, B:117:0x016a), top: B:131:0x015d }] */
    /* JADX WARN: Code duplicated, block: B:117:0x016a A[Catch: IOException -> 0x0161, TRY_LEAVE, TryCatch #12 {IOException -> 0x0161, blocks: (B:111:0x015d, B:115:0x0165, B:117:0x016a), top: B:131:0x015d }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0173  */
    /* JADX WARN: Code duplicated, block: B:125:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0118 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x011a A[Catch: IOException -> 0x0116, TryCatch #4 {IOException -> 0x0116, blocks: (B:78:0x0112, B:82:0x011a, B:84:0x011f), top: B:127:0x0112 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x011f A[Catch: IOException -> 0x0116, TRY_LEAVE, TryCatch #4 {IOException -> 0x0116, blocks: (B:78:0x0112, B:82:0x011a, B:84:0x011f), top: B:127:0x0112 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x013b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x013d A[Catch: IOException -> 0x0139, TryCatch #0 {IOException -> 0x0139, blocks: (B:95:0x0135, B:99:0x013d, B:101:0x0142), top: B:125:0x0135 }] */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0149, code lost:
    
        if (r10 != 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x014b, code lost:
    
        r9 = r11;
        r11 = r1;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0126, code lost:
    
        if (r10 != 0) goto L105;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(String[] strArr, boolean z, boolean z2) {
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        ?? r10;
        int i;
        ?? r1;
        ?? r11;
        String string;
        ?? r12;
        Object obj;
        Object obj2;
        DataOutputStream dataOutputStream = null;
        String str2 = null;
        String str3 = null;
        BufferedReader bufferedReader3 = null;
        dataOutputStream = null;
        dataOutputStream = null;
        int iWaitFor = -1;
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    try {
                        z = Runtime.getRuntime().exec(z != 0 ? "su" : ShellUtils.COMMAND_SH);
                        try {
                            DataOutputStream dataOutputStream2 = new DataOutputStream(z.getOutputStream());
                            try {
                                for (String str4 : strArr) {
                                    if (str4 != null) {
                                        dataOutputStream2.write(str4.getBytes());
                                        dataOutputStream2.writeBytes("\n");
                                        dataOutputStream2.flush();
                                    }
                                }
                                dataOutputStream2.writeBytes(ShellUtils.COMMAND_EXIT);
                                dataOutputStream2.flush();
                                iWaitFor = z.waitFor();
                                if (z2) {
                                    StringBuilder sb = new StringBuilder();
                                    StringBuilder sb2 = new StringBuilder();
                                    bufferedReader = new BufferedReader(new InputStreamReader(z.getInputStream()));
                                    try {
                                        bufferedReader2 = new BufferedReader(new InputStreamReader(z.getErrorStream()));
                                        while (true) {
                                            try {
                                                String line = bufferedReader.readLine();
                                                if (line == null) {
                                                    break;
                                                }
                                                sb.append(line);
                                                sb.append("|");
                                            } catch (IOException e) {
                                                e = e;
                                                obj2 = null;
                                            } catch (Throwable th) {
                                                th = th;
                                                obj = null;
                                            }
                                            r1 = obj2;
                                            str = str2;
                                            dataOutputStream = dataOutputStream2;
                                            i = iWaitFor;
                                            z = z;
                                            com.baidu.mshield.b.c.a.a(e);
                                            if (dataOutputStream != null) {
                                                try {
                                                    dataOutputStream.close();
                                                    if (bufferedReader != null) {
                                                        bufferedReader.close();
                                                    }
                                                    if (bufferedReader2 != null) {
                                                        bufferedReader2.close();
                                                    }
                                                } catch (IOException e2) {
                                                    com.baidu.mshield.b.c.a.a(e2);
                                                }
                                            } else {
                                                if (bufferedReader != null) {
                                                    bufferedReader.close();
                                                }
                                                if (bufferedReader2 != null) {
                                                    bufferedReader2.close();
                                                }
                                            }
                                        }
                                        string = sb.toString();
                                        try {
                                            if (string.length() > 0) {
                                                string = string.substring(0, string.length() - 1);
                                            }
                                            while (true) {
                                                String line2 = bufferedReader2.readLine();
                                                if (line2 == null) {
                                                    break;
                                                }
                                                sb2.append(line2);
                                                sb2.append("|");
                                            }
                                            String string2 = sb2.toString();
                                            if (string2.length() > 0) {
                                                string2 = string2.substring(0, string2.length() - 1);
                                            }
                                            r12 = string2;
                                            bufferedReader3 = bufferedReader;
                                        } catch (IOException e3) {
                                            str2 = string;
                                            e = e3;
                                            obj2 = null;
                                            r1 = obj2;
                                            str = str2;
                                            dataOutputStream = dataOutputStream2;
                                            i = iWaitFor;
                                            z = z;
                                            com.baidu.mshield.b.c.a.a(e);
                                            if (dataOutputStream != null) {
                                                dataOutputStream.close();
                                                if (bufferedReader != null) {
                                                    bufferedReader.close();
                                                }
                                                if (bufferedReader2 != null) {
                                                    bufferedReader2.close();
                                                }
                                            } else {
                                                if (bufferedReader != null) {
                                                    bufferedReader.close();
                                                }
                                                if (bufferedReader2 != null) {
                                                    bufferedReader2.close();
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            str3 = string;
                                            th = th2;
                                            obj = null;
                                            r1 = obj;
                                            str = str3;
                                            dataOutputStream = dataOutputStream2;
                                            i = iWaitFor;
                                            z = z;
                                            com.baidu.mshield.b.c.a.a(th);
                                            if (dataOutputStream != null) {
                                                try {
                                                    dataOutputStream.close();
                                                    if (bufferedReader != null) {
                                                        bufferedReader.close();
                                                    }
                                                    if (bufferedReader2 != null) {
                                                        bufferedReader2.close();
                                                    }
                                                } catch (IOException e4) {
                                                    com.baidu.mshield.b.c.a.a(e4);
                                                }
                                            } else {
                                                if (bufferedReader != null) {
                                                    bufferedReader.close();
                                                }
                                                if (bufferedReader2 != null) {
                                                    bufferedReader2.close();
                                                }
                                            }
                                        }
                                    } catch (IOException e5) {
                                        e = e5;
                                        str = null;
                                        bufferedReader2 = null;
                                        dataOutputStream = dataOutputStream2;
                                        r11 = z;
                                        i = iWaitFor;
                                        r1 = bufferedReader2;
                                        z = r11;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        str = null;
                                        bufferedReader2 = null;
                                        dataOutputStream = dataOutputStream2;
                                        r10 = z;
                                        i = iWaitFor;
                                        r1 = bufferedReader2;
                                        z = r10;
                                        com.baidu.mshield.b.c.a.a(th);
                                        if (dataOutputStream != null) {
                                            dataOutputStream.close();
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                            if (bufferedReader2 != null) {
                                                bufferedReader2.close();
                                            }
                                        } else {
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                            if (bufferedReader2 != null) {
                                                bufferedReader2.close();
                                            }
                                        }
                                    }
                                } else {
                                    string = null;
                                    r12 = 0;
                                    bufferedReader2 = null;
                                }
                                try {
                                    dataOutputStream2.close();
                                    if (bufferedReader3 != null) {
                                        bufferedReader3.close();
                                    }
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
                                } catch (IOException e6) {
                                    com.baidu.mshield.b.c.a.a(e6);
                                }
                            } catch (IOException e7) {
                                e = e7;
                                str = null;
                                bufferedReader = null;
                                bufferedReader2 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                str = null;
                                bufferedReader = null;
                                bufferedReader2 = null;
                            }
                        } catch (IOException e8) {
                            e = e8;
                            str = null;
                            bufferedReader = null;
                            bufferedReader2 = null;
                            r11 = z;
                            i = iWaitFor;
                            r1 = bufferedReader2;
                            z = r11;
                            com.baidu.mshield.b.c.a.a(e);
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                            } else {
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str = null;
                            bufferedReader = null;
                            bufferedReader2 = null;
                            r10 = z;
                            i = iWaitFor;
                            r1 = bufferedReader2;
                            z = r10;
                            com.baidu.mshield.b.c.a.a(th);
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                            } else {
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                            }
                        }
                    } catch (IOException e9) {
                        e = e9;
                        z = 0;
                    } catch (Throwable th6) {
                        th = th6;
                        z = 0;
                    }
                    z.destroy();
                    i = iWaitFor;
                    r1 = r12;
                    str = string;
                    return new a(i, str, r1);
                }
            } catch (Throwable th7) {
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                    } catch (IOException e10) {
                        com.baidu.mshield.b.c.a.a(e10);
                        if (z != 0) {
                            throw th7;
                        }
                        z.destroy();
                        throw th7;
                    }
                } else {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                }
                if (z != 0) {
                    throw th7;
                }
                z.destroy();
                throw th7;
            }
        }
        return new a(-1, null, null);
    }
}
