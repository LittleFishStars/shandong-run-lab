package com.aliyun.vod.qupaiokhttp;

import android.os.AsyncTask;
import com.aliyun.vod.common.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class FileDownloadTask extends AsyncTask<Void, Long, Boolean> {
    private FileDownloadCallback callback;
    private OkHttpClient okHttpClient = OkHttpFinal.getInstance().getOkHttpClientBuilder().build();
    private long previousTime;
    private File target;
    private String url;

    public FileDownloadTask(String str, File file, FileDownloadCallback fileDownloadCallback) {
        this.url = str;
        this.callback = fileDownloadCallback;
        this.target = file;
        FileUtils.mkdirs(file.getParentFile());
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.previousTime = System.currentTimeMillis();
        FileDownloadCallback fileDownloadCallback = this.callback;
        if (fileDownloadCallback != null) {
            fileDownloadCallback.onStart();
        }
    }

    public String saveFile(Response response) throws Throwable {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[2048];
        InputStream inputStream = null;
        try {
            InputStream inputStreamByteStream = response.body().byteStream();
            try {
                long jContentLength = response.body().contentLength();
                FileUtils.mkdirs(this.target.getParentFile());
                fileOutputStream = new FileOutputStream(this.target);
                long j = 0;
                while (true) {
                    try {
                        int i = inputStreamByteStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        j += (long) i;
                        fileOutputStream.write(bArr, 0, i);
                        if (this.callback != null) {
                            publishProgress(Long.valueOf(j), Long.valueOf(jContentLength));
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamByteStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (fileOutputStream == null) {
                            throw th;
                        }
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException unused2) {
                            throw th;
                        }
                    }
                }
                fileOutputStream.flush();
                String absolutePath = this.target.getAbsolutePath();
                try {
                    inputStreamByteStream.close();
                } catch (IOException unused3) {
                }
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                }
                return absolutePath;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    @Override // android.os.AsyncTask
    public Boolean doInBackground(Void... voidArr) throws Throwable {
        boolean z = false;
        try {
            Response responseExecute = this.okHttpClient.newCall(new Request.Builder().url(this.url).build()).execute();
            long jContentLength = responseExecute.body().contentLength();
            saveFile(responseExecute);
            if (jContentLength == this.target.length()) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.valueOf(z);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            FileDownloadCallback fileDownloadCallback = this.callback;
            if (fileDownloadCallback != null) {
                fileDownloadCallback.onDone();
                return;
            }
            return;
        }
        FileDownloadCallback fileDownloadCallback2 = this.callback;
        if (fileDownloadCallback2 != null) {
            fileDownloadCallback2.onFailure();
        }
    }

    @Override // android.os.AsyncTask
    public void onProgressUpdate(Long... lArr) {
        super.onProgressUpdate((Object[]) lArr);
        if (this.callback == null || lArr == null || lArr.length < 2) {
            return;
        }
        long jLongValue = lArr[0].longValue();
        int iLongValue = (int) ((jLongValue * 100.0f) / lArr[1].longValue());
        long jCurrentTimeMillis = (System.currentTimeMillis() - this.previousTime) / 1000;
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis++;
        }
        this.callback.onProgress(iLongValue, jLongValue / jCurrentTimeMillis);
    }
}
