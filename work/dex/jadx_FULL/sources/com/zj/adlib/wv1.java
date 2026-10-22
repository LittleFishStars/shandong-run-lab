package com.zj.adlib;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class wv1 {
    /* JADX WARN: Code duplicated, block: B:51:0x007c A[Catch: IOException -> 0x0078, TRY_LEAVE, TryCatch #2 {IOException -> 0x0078, blocks: (B:47:0x0074, B:51:0x007c), top: B:58:0x0074 }] */
    public static File a(Context context, String str) throws Throwable {
        InputStream inputStream;
        FileOutputStream fileOutputStream = null;
        inputStreamOpen = null;
        inputStreamOpen = null;
        InputStream inputStreamOpen = null;
        fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
                    try {
                        inputStreamOpen = context.getAssets().open(str);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamOpen.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            fileOutputStreamOpenFileOutput.write(bArr, 0, i);
                        }
                        if (fileOutputStreamOpenFileOutput != null) {
                            fileOutputStreamOpenFileOutput.close();
                        }
                        inputStreamOpen.close();
                    } catch (FileNotFoundException e) {
                        e = e;
                        inputStream = inputStreamOpen;
                        fileOutputStream = fileOutputStreamOpenFileOutput;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        inputStream = inputStreamOpen;
                        fileOutputStream = fileOutputStreamOpenFileOutput;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamOpen;
                        fileOutputStream = fileOutputStreamOpenFileOutput;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                throw th;
                            }
                        } else if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                inputStream = null;
            } catch (IOException e5) {
                e = e5;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        File fileStreamPath = context.getFileStreamPath(str);
        if (fileStreamPath.exists()) {
            return fileStreamPath;
        }
        throw new RuntimeException("video file has problem, are you sure you have welcome_video.mp4 in res/raw folder?");
    }
}
