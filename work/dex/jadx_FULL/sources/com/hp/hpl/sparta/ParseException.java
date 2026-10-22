package com.hp.hpl.sparta;

import com.zj.adlib.rm6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ParseException extends Exception {
    private Throwable cause_;
    private int lineNumber_;

    public ParseException(String str) {
        super(str);
        this.lineNumber_ = -1;
        this.cause_ = null;
    }

    public static String charRepr(int i) {
        if (i == -1) {
            return "EOF";
        }
        return "" + ((char) i);
    }

    private static String toMessage(String str, int i, int i2, String str2, String str3) {
        return str + "(" + i + "): \n" + str2 + "\nLast character read was '" + charRepr(i2) + "'\n" + str3;
    }

    private static String toString(char[] cArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cArr[0]);
        for (int i = 1; i < cArr.length; i++) {
            stringBuffer.append("or " + cArr[i]);
        }
        return stringBuffer.toString();
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause_;
    }

    public int getLineNumber() {
        return this.lineNumber_;
    }

    public ParseException(String str, Throwable th) {
        super(str + " " + th);
        this.lineNumber_ = -1;
        this.cause_ = th;
    }

    public ParseException(String str, int i, int i2, String str2, String str3) {
        super(toMessage(str, i, i2, str2, str3));
        this.cause_ = null;
        this.lineNumber_ = i;
    }

    public ParseException(ParseLog parseLog, String str, int i, int i2, String str2, String str3) {
        this(str, i, i2, str2, str3);
        parseLog.c(str3, str, i);
    }

    public ParseException(rm6 rm6Var, String str) {
        this(rm6Var.f(), rm6Var.getSystemId(), rm6Var.getLineNumber(), rm6Var.e(), rm6Var.d(), str);
    }

    public ParseException(rm6 rm6Var, char c, char c2) {
        this(rm6Var, "got '" + c + "' instead of expected '" + c2 + "'");
    }

    public ParseException(rm6 rm6Var, char c, char[] cArr) {
        this(rm6Var, "got '" + c + "' instead of " + toString(cArr));
    }

    public ParseException(rm6 rm6Var, char c, String str) {
        this(rm6Var, "got '" + c + "' instead of " + str + " as expected");
    }

    public ParseException(rm6 rm6Var, String str, String str2) {
        this(rm6Var, "got \"" + str + "\" instead of \"" + str2 + "\" as expected");
    }

    public ParseException(rm6 rm6Var, String str, char[] cArr) {
        this(rm6Var, str, new String(cArr));
    }
}
