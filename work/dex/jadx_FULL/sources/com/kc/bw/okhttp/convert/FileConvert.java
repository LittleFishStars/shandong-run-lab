package com.kc.bw.okhttp.convert;

import android.os.Environment;
import android.text.TextUtils;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.callback.Callback;
import com.kc.bw.okhttp.model.Progress;
import com.kc.bw.okhttp.utils.HttpUtils;
import com.kc.bw.okhttp.utils.IOUtils;
import com.kc.bw.okhttp.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class FileConvert implements Converter<File> {
    public static final int BUFFER_SIZE = 4096;
    public static final String DM_TARGET_FOLDER;
    public static final String TAG = dexg.dexa("XN`GjmfDpowfsu");
    public Callback<File> callback;
    public String fileName;
    public String folder;

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append(dexg.dexa("epxompbe"));
        sb.append(str);
        DM_TARGET_FOLDER = sb.toString();
    }

    public FileConvert() {
        this(null);
    }

    public FileConvert(String str) {
        this(Environment.getExternalStorageDirectory() + DM_TARGET_FOLDER, str);
    }

    public FileConvert(String str, String str2) {
        this.folder = str;
        this.fileName = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(Progress progress) {
        runOnUiThread(new Runnable(this, progress) { // from class: com.kc.bw.okhttp.convert.FileConvert.2
            public final FileConvert this$0;
            public final Progress val$progress;

            {
                this.this$0 = this;
                this.val$progress = progress;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.callback.downloadProgress(this.val$progress);
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kc.bw.okhttp.convert.Converter
    public File convertResponse(Response response) throws Throwable {
        Throwable th;
        FileOutputStream fileOutputStream;
        String string = response.request().url().toString();
        if (TextUtils.isEmpty(this.folder)) {
            this.folder = Environment.getExternalStorageDirectory() + DM_TARGET_FOLDER;
        }
        if (TextUtils.isEmpty(this.fileName)) {
            this.fileName = HttpUtils.getNetFileName(response, string);
        }
        File file = new File(this.folder);
        IOUtils.createFolder(file);
        File file2 = new File(file, this.fileName);
        IOUtils.delFileOrFolder(file2);
        byte[] bArr = new byte[4096];
        InputStream inputStream = null;
        try {
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null) {
                IOUtils.closeQuietly(null);
                IOUtils.closeQuietly(null);
                return null;
            }
            InputStream inputStreamByteStream = responseBodyBody.byteStream();
            try {
                Progress progress = new Progress();
                progress.totalSize = responseBodyBody.contentLength();
                progress.fileName = this.fileName;
                progress.filePath = file2.getAbsolutePath();
                progress.status = 2;
                progress.url = string;
                progress.tag = string;
                fileOutputStream = new FileOutputStream(file2);
                try {
                    IOUtils.setFileReadOnly(file2);
                    while (true) {
                        int i = inputStreamByteStream.read(bArr);
                        if (i == -1) {
                            fileOutputStream.flush();
                            IOUtils.closeQuietly(inputStreamByteStream);
                            IOUtils.closeQuietly(fileOutputStream);
                            return file2;
                        }
                        fileOutputStream.write(bArr, 0, i);
                        if (this.callback != null) {
                            Progress.changeProgress(progress, i, new Progress.Action(this) { // from class: com.kc.bw.okhttp.convert.FileConvert.1
                                public final FileConvert this$0;

                                {
                                    this.this$0 = this;
                                }

                                @Override // com.kc.bw.okhttp.model.Progress.Action
                                public void call(Progress progress2) {
                                    this.this$0.onProgress(progress2);
                                }
                            });
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStreamByteStream;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(fileOutputStream);
        throw th;
    }

    public void runOnUiThread(Runnable runnable) {
        ThreadUtils.runOnUIThread(runnable);
    }

    public void setCallback(Callback<File> callback) {
        this.callback = callback;
    }
}
