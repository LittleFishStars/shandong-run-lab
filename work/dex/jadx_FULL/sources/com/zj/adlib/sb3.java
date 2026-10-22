package com.zj.adlib;

import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class sb3 {
    public static BooleanExpr a(k5a k5aVar, tg8 tg8Var) throws XPathException, IOException {
        int i;
        int i2;
        int i3 = tg8Var.f19804a;
        if (i3 == -3) {
            if (!tg8Var.f19806a.equals("text")) {
                throw new XPathException(k5aVar, "at beginning of expression", tg8Var, "text()");
            }
            if (tg8Var.a() != 40) {
                throw new XPathException(k5aVar, "after text", tg8Var, "(");
            }
            if (tg8Var.a() != 41) {
                throw new XPathException(k5aVar, "after text(", tg8Var, ")");
            }
            int iA = tg8Var.a();
            if (iA != 33) {
                if (iA != 61) {
                    return q39.f44118a;
                }
                tg8Var.a();
                int i4 = tg8Var.f19804a;
                if (i4 != 34 && i4 != 39) {
                    throw new XPathException(k5aVar, "right hand side of equals", tg8Var, "quoted string");
                }
                String str = tg8Var.f19806a;
                tg8Var.a();
                return new p39(str);
            }
            tg8Var.a();
            if (tg8Var.f19804a != 61) {
                throw new XPathException(k5aVar, "after !", tg8Var, "=");
            }
            tg8Var.a();
            int i5 = tg8Var.f19804a;
            if (i5 != 34 && i5 != 39) {
                throw new XPathException(k5aVar, "right hand side of !=", tg8Var, "quoted string");
            }
            String str2 = tg8Var.f19806a;
            tg8Var.a();
            return new x39(str2);
        }
        if (i3 == -2) {
            int i6 = tg8Var.b;
            tg8Var.a();
            return new gv6(i6);
        }
        if (i3 != 64) {
            throw new XPathException(k5aVar, "at beginning of expression", tg8Var, "@, number, or text()");
        }
        if (tg8Var.a() != -3) {
            throw new XPathException(k5aVar, "after @", tg8Var, "name");
        }
        String str3 = tg8Var.f19806a;
        int iA2 = tg8Var.a();
        if (iA2 == 33) {
            tg8Var.a();
            if (tg8Var.f19804a != 61) {
                throw new XPathException(k5aVar, "after !", tg8Var, "=");
            }
            tg8Var.a();
            int i7 = tg8Var.f19804a;
            if (i7 != 34 && i7 != 39) {
                throw new XPathException(k5aVar, "right hand side of !=", tg8Var, "quoted string");
            }
            String str4 = tg8Var.f19806a;
            tg8Var.a();
            return new sd0(str3, str4);
        }
        switch (iA2) {
            case 60:
                tg8Var.a();
                int i8 = tg8Var.f19804a;
                if (i8 == 34 || i8 == 39) {
                    i = Integer.parseInt(tg8Var.f19806a);
                } else {
                    if (i8 != -2) {
                        throw new XPathException(k5aVar, "right hand side of less-than", tg8Var, "quoted string or number");
                    }
                    i = tg8Var.b;
                }
                tg8Var.a();
                return new rd0(str3, i);
            case 61:
                tg8Var.a();
                int i9 = tg8Var.f19804a;
                if (i9 != 34 && i9 != 39) {
                    throw new XPathException(k5aVar, "right hand side of equals", tg8Var, "quoted string");
                }
                String str5 = tg8Var.f19806a;
                tg8Var.a();
                return new od0(str3, str5);
            case 62:
                tg8Var.a();
                int i10 = tg8Var.f19804a;
                if (i10 == 34 || i10 == 39) {
                    i2 = Integer.parseInt(tg8Var.f19806a);
                } else {
                    if (i10 != -2) {
                        throw new XPathException(k5aVar, "right hand side of greater-than", tg8Var, "quoted string or number");
                    }
                    i2 = tg8Var.b;
                }
                tg8Var.a();
                return new qd0(str3, i2);
            default:
                return new pd0(str3);
        }
    }
}
