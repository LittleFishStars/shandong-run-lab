package com.zj.adlib;

import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.TextCompareExpr;
import com.hp.hpl.sparta.xpath.XPathException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class p39 extends TextCompareExpr {
    public p39(String str) {
        super(str);
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExpr
    public void a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.k(this);
    }

    public String toString() {
        return toString("=");
    }
}
