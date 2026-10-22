package com.zj.adlib;

import com.alibaba.android.arouter.utils.Consts;
import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.Visitor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class c59 extends NodeTest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c59 f40906a = new c59();

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public void a(Visitor visitor) {
        visitor.d(this);
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public boolean b() {
        return false;
    }

    public String toString() {
        return Consts.DOT;
    }
}
