package cn.hzjizhun.admin.http.net.error;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EasyHTTPException extends Throwable implements Serializable {
    private static final long serialVersionUID = -492948457991527824L;
    public final String code;
    public final String message;

    public static final class Error {
        public static final String CANCEL_REQUEST = "1004";
    }

    public EasyHTTPException(String str, String str2) {
        this.message = str;
        this.code = str2;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "EasyHTTPException{message='" + this.message + "', code='" + this.code + "'}";
    }
}
