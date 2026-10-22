package com.alibaba.ariver.resource.parser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ParseFailedException extends RuntimeException {
    public static final int CERT_PATH_NOT_EXIST = 4;
    public static final int EMPTY_RES = 8;
    public static final int INVALID_PARAM = 1;
    public static final int OFFLINE_PATH_NOT_EXIST = 2;
    public static final int TAR_PATH_NOT_EXIST = 3;
    public static final int TAR_SIGNATURE_IS_EMPTY = 5;
    public static final int UN_KNOW_EXCEPTION = 7;
    public static final int VERIFY_FAIL = 6;
    private int code;
    private ParseContext parseContext;

    public ParseFailedException(int i, String str) {
        super(str);
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    public ParseContext getParseContext() {
        return this.parseContext;
    }

    public void setParseContext(ParseContext parseContext) {
        this.parseContext = parseContext;
    }
}
