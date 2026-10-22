package com.zj.adlib;

import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.XPathException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class q39 extends BooleanExpr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q39 f44118a = new q39();

    @Override // com.hp.hpl.sparta.xpath.BooleanExpr
    public void a(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.h(this);
    }

    public String toString() {
        return "[text()]";
    }
}
