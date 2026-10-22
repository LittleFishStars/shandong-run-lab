package com.zj.adlib;

import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.XPathException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class gv6 extends BooleanExpr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41993a;

    public gv6(int i) {
        this.f41993a = i;
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExpr
    public void a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.a(this);
    }

    public int b() {
        return this.f41993a;
    }

    public String toString() {
        return "[" + this.f41993a + "]";
    }
}
