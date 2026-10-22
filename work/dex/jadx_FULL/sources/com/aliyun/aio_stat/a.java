package com.aliyun.aio_stat;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f25552a;
    private int b;

    /* JADX INFO: renamed from: com.aliyun.aio_stat.a$a, reason: collision with other inner class name */
    public class RunnableC0213a implements Runnable {
        public RunnableC0213a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a.this.f();
        }
    }

    public class b implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25554a = -1;

        public c() {
        }

        @Override // com.aliyun.aio_stat.a.f
        public void a(String str) {
            LinkedList linkedListB;
            if (!str.contains(Process.myPid() + "") || (linkedListB = a.b(str.split(" "))) == null) {
                return;
            }
            if (this.f25554a < 0) {
                for (int i = 0; i < linkedListB.size(); i++) {
                    if (((String) linkedListB.get(i)).contains("%")) {
                        this.f25554a = i;
                        break;
                    }
                }
            }
            int i2 = this.f25554a;
            if (i2 >= 0) {
                String strSubstring = (String) linkedListB.get(i2);
                if (strSubstring.contains("%")) {
                    strSubstring = strSubstring.substring(0, strSubstring.indexOf("%"));
                }
                try {
                    a.this.f25552a = Float.parseFloat(strSubstring);
                } catch (Exception unused) {
                }
            }
        }
    }

    public class d implements f {
        public d() {
        }

        @Override // com.aliyun.aio_stat.a.f
        public void a(String str) {
            try {
                float f = Float.parseFloat(str);
                if (a.this.b <= 0) {
                    a.this.b = a.a();
                }
                a aVar = a.this;
                aVar.f25552a = (f * 1.0f) / aVar.b;
            } catch (Exception unused) {
            }
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f25556a = new a(null);
    }

    public interface f {
        void a(String str);
    }

    private a() {
        this.b = 0;
        new Thread(new RunnableC0213a()).start();
    }

    public /* synthetic */ a(RunnableC0213a runnableC0213a) {
        this();
    }

    public static int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new b()).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x003e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0040 A[Catch: all -> 0x0048, TryCatch #5 {all -> 0x0048, blocks: (B:26:0x003b, B:28:0x0040, B:30:0x0045), top: B:45:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0045 A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #5 {all -> 0x0048, blocks: (B:26:0x003b, B:28:0x0040, B:30:0x0045), top: B:45:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:35:0x004d A[Catch: all -> 0x005a, TRY_ENTER, TryCatch #6 {all -> 0x005a, blocks: (B:11:0x0023, B:39:0x0057, B:35:0x004d, B:37:0x0052), top: B:47:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0052 A[Catch: all -> 0x005a, TryCatch #6 {all -> 0x005a, blocks: (B:11:0x0023, B:39:0x0057, B:35:0x004d, B:37:0x0052), top: B:47:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    private void a(String str, f fVar) throws Throwable {
        Throwable th;
        Process processExec;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader = null;
        try {
            try {
                processExec = Runtime.getRuntime().exec(str);
                try {
                    InputStreamReader inputStreamReader2 = new InputStreamReader(processExec.getInputStream());
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader2);
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                } else if (fVar != null) {
                                    fVar.a(line);
                                }
                            } catch (Exception unused) {
                                inputStreamReader = inputStreamReader2;
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (processExec == null) {
                                    return;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStreamReader = inputStreamReader2;
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (processExec != null) {
                                            processExec.destroy();
                                        }
                                    } catch (Throwable unused2) {
                                        throw th;
                                    }
                                } else {
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    if (processExec != null) {
                                        processExec.destroy();
                                    }
                                }
                                throw th;
                            }
                        }
                        inputStreamReader2.close();
                        bufferedReader.close();
                    } catch (Exception unused3) {
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (Exception unused4) {
                    bufferedReader = null;
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (processExec == null) {
                        return;
                    }
                    processExec.destroy();
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (processExec != null) {
                            processExec.destroy();
                        }
                    } else {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (processExec != null) {
                            processExec.destroy();
                        }
                    }
                    throw th;
                }
            } catch (Throwable unused5) {
                return;
            }
        } catch (Exception unused6) {
            processExec = null;
        } catch (Throwable th5) {
            th = th5;
            processExec = null;
        }
        processExec.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedList<String> b(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (!strArr[i].trim().equals("")) {
                linkedList.add(strArr[i]);
            }
        }
        return linkedList;
    }

    private void b() throws Throwable {
        a("top -p " + Process.myPid() + " -o %CPU", new d());
    }

    private void c() throws Throwable {
        a(com.ipd.dsp.internal.e1.f.l, new c());
    }

    public static a d() {
        return e.f25556a;
    }

    public float e() {
        return this.f25552a;
    }

    public void f() throws Throwable {
        b();
    }
}
