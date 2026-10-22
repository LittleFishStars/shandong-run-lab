package com.hp.hpl.sparta.xpath;

import com.zj.adlib.k5a;
import com.zj.adlib.tg8;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class XPathException extends Exception {
    private Throwable cause_;

    public XPathException(k5a k5aVar, String str) {
        super(k5aVar + " " + str);
        this.cause_ = null;
    }

    private static String toString(tg8 tg8Var) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(tokenToString(tg8Var));
            if (tg8Var.f19804a != -1) {
                tg8Var.a();
                stringBuffer.append(tokenToString(tg8Var));
                tg8Var.c();
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            return "(cannot get  info: " + e + ")";
        }
    }

    private static String tokenToString(tg8 tg8Var) {
        int i = tg8Var.f19804a;
        if (i == -3) {
            return tg8Var.f19806a;
        }
        if (i == -2) {
            return tg8Var.b + "";
        }
        if (i == -1) {
            return "<end of expression>";
        }
        return ((char) tg8Var.f19804a) + "";
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause_;
    }

    public XPathException(k5a k5aVar, String str, tg8 tg8Var, String str2) {
        this(k5aVar, str + " got \"" + toString(tg8Var) + "\" instead of expected " + str2);
    }

    public XPathException(k5a k5aVar, Exception exc) {
        super(k5aVar + " " + exc);
        this.cause_ = exc;
    }
}
