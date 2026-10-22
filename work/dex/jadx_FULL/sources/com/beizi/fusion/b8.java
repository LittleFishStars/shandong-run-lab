package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class b8 {
    public static void a(Context context, String str, String str2) throws Throwable {
        Throwable th;
        FileWriter fileWriter;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                File file = new File(j4.b(context).getPath() + "/BeiZi/config/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                fileWriter = new FileWriter(new File(file, str), false);
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                    try {
                        bufferedWriter2.write(str2);
                        bufferedWriter2.close();
                        fileWriter.close();
                    } catch (Exception unused) {
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException unused2) {
                                throw th;
                            }
                        }
                        if (fileWriter == null) {
                            throw th;
                        }
                        fileWriter.close();
                        throw th;
                    }
                } catch (Exception unused3) {
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException unused4) {
            }
        } catch (Exception unused5) {
            fileWriter = null;
        } catch (Throwable th4) {
            th = th4;
            fileWriter = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0071 A[Catch: IOException -> 0x0074, TRY_LEAVE, TryCatch #1 {IOException -> 0x0074, blocks: (B:32:0x006c, B:34:0x0071), top: B:47:0x006c }] */
    /* JADX WARN: Code duplicated, block: B:40:0x007e A[Catch: IOException -> 0x0081, TRY_LEAVE, TryCatch #3 {IOException -> 0x0081, blocks: (B:38:0x0079, B:40:0x007e), top: B:49:0x0079 }] */
    public static String a(Context context, String str) throws Throwable {
        Throwable th;
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file = new File(j4.b(context).getPath() + "/BeiZi/config/", str);
            if (!file.exists()) {
                return null;
            }
            fileReader = new FileReader(file);
            try {
                if (!fileReader.ready()) {
                    try {
                        fileReader.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
                bufferedReader = new BufferedReader(fileReader);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    String string = sb.toString();
                    try {
                        bufferedReader.close();
                        fileReader.close();
                    } catch (IOException unused2) {
                    }
                    return string;
                } catch (Exception unused3) {
                } catch (Throwable th2) {
                    bufferedReader2 = bufferedReader;
                    th = th2;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        } catch (IOException unused4) {
                            throw th;
                        }
                    } else if (fileReader != null) {
                        fileReader.close();
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused6) {
            fileReader = null;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException unused7) {
            }
        } else if (fileReader != null) {
            fileReader.close();
        }
        return null;
    }
}
