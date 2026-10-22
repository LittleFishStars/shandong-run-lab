package com.kc.bw.okhttp.callback;

import com.kc.bw.okhttp.convert.FileConvert;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class FileCallback extends AbsCallback<File> {
    public FileConvert convert;

    public FileCallback() {
        this(null);
    }

    public FileCallback(String str) {
        this(null, str);
    }

    public FileCallback(String str, String str2) {
        FileConvert fileConvert = new FileConvert(str, str2);
        this.convert = fileConvert;
        fileConvert.setCallback(this);
    }

    @Override // com.kc.bw.okhttp.convert.Converter
    public File convertResponse(Response response) throws Throwable {
        File fileConvertResponse = this.convert.convertResponse(response);
        response.close();
        return fileConvertResponse;
    }
}
