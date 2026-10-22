package com.hp.hpl.sparta;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class EncodingMismatchException extends ParseException {
    private String declaredEncoding_;

    public EncodingMismatchException(String str, String str2, String str3) {
        super(str, 0, str2.charAt(str2.length() - 1), str2, "encoding '" + str2 + "' declared instead of of " + str3 + " as expected");
        this.declaredEncoding_ = str2;
    }

    public String getDeclaredEncoding() {
        return this.declaredEncoding_;
    }
}
