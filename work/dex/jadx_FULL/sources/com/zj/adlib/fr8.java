package com.zj.adlib;

import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class fr8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static fr8 f41742a = new fr8(c59.f40906a, zc9.f46233a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BooleanExpr f16605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NodeTest f16606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16607a;

    public fr8(NodeTest nodeTest, BooleanExpr booleanExpr) {
        this.f16606a = nodeTest;
        this.f16605a = booleanExpr;
        this.f16607a = false;
    }

    public NodeTest a() {
        return this.f16606a;
    }

    public BooleanExpr b() {
        return this.f16605a;
    }

    public boolean c() {
        return this.f16607a;
    }

    public boolean d() {
        return this.f16606a.b();
    }

    public String toString() {
        return this.f16606a.toString() + this.f16605a.toString();
    }

    public fr8(k5a k5aVar, boolean z, tg8 tg8Var) throws XPathException, IOException {
        this.f16607a = z;
        int i = tg8Var.f19804a;
        if (i != -3) {
            if (i == 42) {
                this.f16606a = o40.f43662a;
            } else if (i != 46) {
                if (i == 64) {
                    if (tg8Var.a() == -3) {
                        this.f16606a = new ud0(tg8Var.f19806a);
                    } else {
                        throw new XPathException(k5aVar, "after @ in node test", tg8Var, "name");
                    }
                } else {
                    throw new XPathException(k5aVar, "at begininning of step", tg8Var, "'.' or '*' or name");
                }
            } else if (tg8Var.a() == 46) {
                this.f16606a = mm6.f43334a;
            } else {
                tg8Var.c();
                this.f16606a = c59.f40906a;
            }
        } else if (tg8Var.f19806a.equals("text")) {
            if (tg8Var.a() == 40 && tg8Var.a() == 41) {
                this.f16606a = e49.f41345a;
            } else {
                throw new XPathException(k5aVar, "after text", tg8Var, "()");
            }
        } else {
            this.f16606a = new zy2(tg8Var.f19806a);
        }
        if (tg8Var.a() == 91) {
            tg8Var.a();
            this.f16605a = sb3.a(k5aVar, tg8Var);
            if (tg8Var.f19804a == 93) {
                tg8Var.a();
                return;
            }
            throw new XPathException(k5aVar, "after predicate expression", tg8Var, "]");
        }
        this.f16605a = zc9.f46233a;
    }
}
