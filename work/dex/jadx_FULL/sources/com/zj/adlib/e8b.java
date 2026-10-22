package com.zj.adlib;

import android.text.TextUtils;
import cn.hzjizhun.admin.base.g;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class e8b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cqb f41372a;
    public final /* synthetic */ String f;

    public e8b(mib mibVar, String str, cqb cqbVar) {
        this.f = str;
        this.f41372a = cqbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InputStream inputStream;
        BufferedReader bufferedReader;
        Throwable th;
        HttpURLConnection httpURLConnection;
        String string;
        try {
            httpURLConnection = (HttpURLConnection) new URL(this.f).openConnection();
            try {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (TextUtils.isEmpty(line)) {
                                break;
                            } else {
                                sb.append(line);
                            }
                        }
                        string = sb.toString();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                th2.getMessage();
                            }
                        }
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th3.getMessage();
                        }
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable th4) {
                            th4.getMessage();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            th.getMessage();
                            string = "";
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th6) {
                                    th6.getMessage();
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th7) {
                                    th7.getMessage();
                                }
                            }
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable th8) {
                                    th8.getMessage();
                                }
                            }
                        } catch (Throwable th9) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th10) {
                                    th10.getMessage();
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th11) {
                                    th11.getMessage();
                                }
                            }
                            if (httpURLConnection == null) {
                                throw th9;
                            }
                            try {
                                httpURLConnection.disconnect();
                                throw th9;
                            } catch (Throwable th12) {
                                th12.getMessage();
                                throw th9;
                            }
                        }
                    }
                } catch (Throwable th13) {
                    bufferedReader = null;
                    th = th13;
                }
            } catch (Throwable th14) {
                bufferedReader = null;
                th = th14;
                inputStream = null;
            }
        } catch (Throwable th15) {
            inputStream = null;
            bufferedReader = null;
            th = th15;
            httpURLConnection = null;
        }
        if (TextUtils.isEmpty(string)) {
            blb blbVar = this.f41372a.f41027a;
            blbVar.f40777a.f46116a.post(new wjb(blbVar));
        } else {
            cqb cqbVar = this.f41372a;
            cqbVar.f41027a.a(string);
            ytb.a(cqbVar.f15874a, g.c(string), cqbVar.f15875a, cqbVar.b);
        }
    }
}
