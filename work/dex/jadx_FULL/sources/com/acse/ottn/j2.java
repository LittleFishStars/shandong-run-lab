package com.acse.ottn;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.zj.adlib.c25;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j2 {
    public static j2 c;
    public static String d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f23064a = null;
    public int b;

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Process f23065a;
        public BufferedReader b = null;
        public boolean c = true;
        public String d;
        public String e;
        public FileOutputStream f;

        public a(String str, String str2) {
            this.d = null;
            this.f = null;
            this.e = str;
            try {
                this.f = new FileOutputStream(new File(str2, "log-" + j2.this.a() + c25.n));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.d = "logcat | grep \"(" + this.e + ")\"";
        }

        public void a() {
            this.c = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String line;
            try {
                try {
                    try {
                        this.f23065a = Runtime.getRuntime().exec(this.d);
                        this.b = new BufferedReader(new InputStreamReader(this.f23065a.getInputStream()), 1024);
                        while (this.c && (line = this.b.readLine()) != null && this.c) {
                            if (line.length() != 0 && this.f != null && line.contains(this.e)) {
                                this.f.write((line + "\n").getBytes());
                            }
                        }
                        Process process = this.f23065a;
                        if (process != null) {
                            process.destroy();
                            this.f23065a = null;
                        }
                        BufferedReader bufferedReader = this.b;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                this.b = null;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        FileOutputStream fileOutputStream = this.f;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            this.f = null;
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        Process process2 = this.f23065a;
                        if (process2 != null) {
                            process2.destroy();
                            this.f23065a = null;
                        }
                        BufferedReader bufferedReader2 = this.b;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                                this.b = null;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        FileOutputStream fileOutputStream2 = this.f;
                        if (fileOutputStream2 == null) {
                        } else {
                            fileOutputStream2.close();
                        }
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Throwable th) {
                Process process3 = this.f23065a;
                if (process3 != null) {
                    process3.destroy();
                    this.f23065a = null;
                }
                BufferedReader bufferedReader3 = this.b;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        this.b = null;
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                FileOutputStream fileOutputStream3 = this.f;
                if (fileOutputStream3 == null) {
                    throw th;
                }
                try {
                    fileOutputStream3.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                this.f = null;
                throw th;
            }
        }
    }

    public j2(Context context) {
        b(context);
        this.b = Process.myPid();
    }

    public static j2 a(Context context) {
        if (c == null) {
            c = new j2(context);
        }
        return c;
    }

    public void b(Context context) {
        d = context.getExternalFilesDir("log").getAbsoluteFile().getPath() + "/log";
        File file = new File(d);
        Log.i("codedzh", "存储位置：" + d);
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.i("codedzh", "文件是否存在：" + new File(d).exists());
    }

    public void c() {
        a aVar = this.f23064a;
        if (aVar != null) {
            aVar.a();
            this.f23064a = null;
        }
    }

    public String a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public void b() {
        if (this.f23064a == null) {
            this.f23064a = new a(String.valueOf(this.b), d);
        }
        this.f23064a.start();
    }
}
