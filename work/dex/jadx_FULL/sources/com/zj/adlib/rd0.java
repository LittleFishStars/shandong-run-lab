package com.zj.adlib;

import com.hp.hpl.sparta.xpath.AttrRelationalExpr;
import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.XPathException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class rd0 extends AttrRelationalExpr {
    public rd0(String str, int i) {
        super(str, i);
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExpr
    public void a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.c(this);
    }

    @Override // com.hp.hpl.sparta.xpath.AttrExpr
    public String toString() {
        return toString("<");
    }
}
