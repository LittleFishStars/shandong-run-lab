package cj.mobile.wm.okhttp.callback;

import cj.mobile.wm.okhttp.convert.FileConvert;
import java.io.File;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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

    @Override // cj.mobile.wm.okhttp.convert.Converter
    public File convertResponse(Response response) throws Throwable {
        File fileConvertResponse = this.convert.convertResponse(response);
        response.close();
        return fileConvertResponse;
    }
}
