package cj.mobile.wm.okhttp.convert;

import android.os.Environment;
import android.text.TextUtils;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.callback.Callback;
import cj.mobile.wm.okhttp.model.Progress;
import cj.mobile.wm.okhttp.utils.HttpUtils;
import cj.mobile.wm.okhttp.utils.IOUtils;
import cj.mobile.wm.okhttp.utils.ThreadUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FileConvert implements Converter<File> {
    public static final int BUFFER_SIZE = 4096;
    public static final String DM_TARGET_FOLDER;
    public static final String TAG = dexc.dexa("XN`GjmfDpowfsu");
    public Callback<File> callback;
    public String fileName;
    public String folder;

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append(dexc.dexa("epxompbe"));
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
    public void onProgress(final Progress progress) {
        runOnUiThread(new Runnable() { // from class: cj.mobile.wm.okhttp.convert.FileConvert.2
            @Override // java.lang.Runnable
            public void run() {
                FileConvert.this.callback.downloadProgress(progress);
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cj.mobile.wm.okhttp.convert.Converter
    public File convertResponse(Response response) throws Throwable {
        Throwable th;
        InputStream inputStreamByteStream;
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
        FileOutputStream fileOutputStream = null;
        try {
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null) {
                IOUtils.closeQuietly(null);
                IOUtils.closeQuietly(null);
                return null;
            }
            inputStreamByteStream = responseBodyBody.byteStream();
            try {
                Progress progress = new Progress();
                progress.totalSize = responseBodyBody.contentLength();
                progress.fileName = this.fileName;
                progress.filePath = file2.getAbsolutePath();
                progress.status = 2;
                progress.url = string;
                progress.tag = string;
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    IOUtils.setFileReadOnly(file2);
                    while (true) {
                        int i = inputStreamByteStream.read(bArr);
                        if (i == -1) {
                            fileOutputStream2.flush();
                            IOUtils.closeQuietly(inputStreamByteStream);
                            IOUtils.closeQuietly(fileOutputStream2);
                            return file2;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                        if (this.callback != null) {
                            Progress.changeProgress(progress, i, new Progress.Action() { // from class: cj.mobile.wm.okhttp.convert.FileConvert.1
                                @Override // cj.mobile.wm.okhttp.model.Progress.Action
                                public void call(Progress progress2) {
                                    FileConvert.this.onProgress(progress2);
                                }
                            });
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamByteStream = null;
        }
        IOUtils.closeQuietly(inputStreamByteStream);
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
