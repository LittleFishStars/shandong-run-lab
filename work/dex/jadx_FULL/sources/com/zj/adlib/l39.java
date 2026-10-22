package com.zj.adlib;

import com.hp.hpl.sparta.Node;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class l39 extends Node {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StringBuffer f42989a;

    public l39(String str) {
        this.f42989a = new StringBuffer(str);
    }

    @Override // com.hp.hpl.sparta.Node
    public Object clone() {
        return new l39(this.f42989a.toString());
    }

    @Override // com.hp.hpl.sparta.Node
    public int computeHashCode() {
        return this.f42989a.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l39) {
            return this.f42989a.toString().equals(((l39) obj).f42989a.toString());
        }
        return false;
    }

    @Override // com.hp.hpl.sparta.Node
    public void n(Writer writer) throws IOException {
        writer.write(this.f42989a.toString());
    }

    @Override // com.hp.hpl.sparta.Node
    public void p(Writer writer) throws IOException {
        String string = this.f42989a.toString();
        if (string.length() < 50) {
            Node.htmlEncode(writer, string);
            return;
        }
        writer.write("<![CDATA[");
        writer.write(string);
        writer.write("]]>");
    }

    @Override // com.hp.hpl.sparta.Node
    public vy2 q(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.Node
    public Enumeration r(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.Node
    public String s(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.Node
    public Enumeration t(String str) {
        throw new Error("Sorry, not implemented");
    }

    public void v(char c) {
        this.f42989a.append(c);
        h();
    }

    public void w(String str) {
        this.f42989a.append(str);
        h();
    }

    public void x(char[] cArr, int i, int i2) {
        this.f42989a.append(cArr, i, i2);
        h();
    }

    public String y() {
        return this.f42989a.toString();
    }

    public void z(String str) {
        this.f42989a = new StringBuffer(str);
        h();
    }

    public l39(char c) {
        StringBuffer stringBuffer = new StringBuffer();
        this.f42989a = stringBuffer;
        stringBuffer.append(c);
    }
}
