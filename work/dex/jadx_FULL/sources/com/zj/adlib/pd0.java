package com.zj.adlib;

import com.hp.hpl.sparta.xpath.AttrExpr;
import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.XPathException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class pd0 extends AttrExpr {
    public pd0(String str) {
        super(str);
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExpr
    public void a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.p(this);
    }

    @Override // com.hp.hpl.sparta.xpath.AttrExpr
    public String toString() {
        return "[" + super.toString() + "]";
    }
}
