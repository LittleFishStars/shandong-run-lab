package com.hp.hpl.sparta;

import com.alipay.sdk.m.y.l;
import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.XPathException;
import com.zj.adlib.fr8;
import com.zj.adlib.gv6;
import com.zj.adlib.k5a;
import com.zj.adlib.l39;
import com.zj.adlib.od0;
import com.zj.adlib.p39;
import com.zj.adlib.pd0;
import com.zj.adlib.q39;
import com.zj.adlib.qd0;
import com.zj.adlib.rd0;
import com.zj.adlib.sd0;
import com.zj.adlib.vy2;
import com.zj.adlib.x39;
import com.zj.adlib.zc9;
import com.zj.adlib.zy2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class Node {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Document f6841a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public vy2 f6843a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Node f6842a = null;
    public Node b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f6844a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32692a = 0;

    public class a implements BooleanExprVisitor {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ vy2 f6845a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f6846a;
        public final /* synthetic */ vy2 b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ String f6847b;

        public a(vy2 vy2Var, vy2 vy2Var2, String str, String str2) {
            this.f6845a = vy2Var;
            this.b = vy2Var2;
            this.f6846a = str;
            this.f6847b = str2;
        }

        @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
        public void a(gv6 gv6Var) throws XPathException {
            int iB = gv6Var.b();
            if (this.b == null && iB != 1) {
                throw new XPathException(k5a.b(this.f6846a), "Position of root node must be 1");
            }
            for (int i = 1; i < iB; i++) {
                this.b.v(new vy2(this.f6847b));
            }
        }

        @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
        public void b(zc9 zc9Var) {
        }

        @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
        public void c(rd0 rd0Var) throws XPathException {
            this.f6845a.M(rd0Var.b(), Long.toString(Long.MIN_VALUE));
        }

        @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
        public void e(x39 x39Var) throws XPathException {
            this.f6845a.v(new l39("not " + x39Var.b()));
        }

        @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
        public void f(od0 od0Var) throws XPathException {
            this.f6845a.M(od0Var.b(), od0Var.c());
        }

        @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
        public void h(q39 q39Var) throws XPathException {
            this.f6845a.v(new l39("something"));
        }

        @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
        public void i(qd0 qd0Var) throws XPathException {
            this.f6845a.M(qd0Var.b(), Long.toString(Long.MAX_VALUE));
        }

        @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
        public void j(sd0 sd0Var) throws XPathException {
            this.f6845a.M(sd0Var.b(), "not " + sd0Var.c());
        }

        @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
        public void k(p39 p39Var) throws XPathException {
            this.f6845a.v(new l39(p39Var.b()));
        }

        @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
        public void p(pd0 pd0Var) throws XPathException {
            this.f6845a.M(pd0Var.b(), "something");
        }
    }

    public static void htmlEncode(Writer writer, String str) throws IOException {
        String str2;
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= 128) {
                str2 = "&#" + ((int) cCharAt) + l.b;
            } else if (cCharAt == '\"') {
                str2 = "&quot;";
            } else if (cCharAt == '<') {
                str2 = "&lt;";
            } else if (cCharAt == '>') {
                str2 = "&gt;";
            } else if (cCharAt != '&') {
                str2 = cCharAt != '\'' ? null : "&#39;";
            } else {
                str2 = "&amp;";
            }
            if (str2 != null) {
                writer.write(str, i, i2 - i);
                writer.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            writer.write(str, i, length - i);
        }
    }

    public Object a() {
        return this.f6844a;
    }

    public Node b() {
        return this.b;
    }

    public Document c() {
        return this.f6841a;
    }

    public abstract Object clone();

    public abstract int computeHashCode();

    public vy2 d() {
        return this.f6843a;
    }

    public Node e() {
        return this.f6842a;
    }

    public void f(Node node) {
        this.f6842a = node;
        if (node != null) {
            node.b = this;
        }
    }

    public vy2 g(vy2 vy2Var, fr8 fr8Var, String str) throws XPathException, ParseException {
        NodeTest nodeTestA = fr8Var.a();
        if (nodeTestA instanceof zy2) {
            String strC = ((zy2) nodeTestA).c();
            vy2 vy2Var2 = new vy2(strC);
            fr8Var.b().a(new a(vy2Var2, vy2Var, str, strC));
            return vy2Var2;
        }
        throw new ParseException("\"" + nodeTestA + "\" in \"" + str + "\" is not an element test");
    }

    public void h() {
        this.f32692a = 0;
        Document document = this.f6841a;
        if (document != null) {
            document.h();
        }
    }

    public int hashCode() {
        if (this.f32692a == 0) {
            this.f32692a = computeHashCode();
        }
        return this.f32692a;
    }

    public void i() {
        Node node = this.f6842a;
        if (node != null) {
            node.b = this.b;
        }
        Node node2 = this.b;
        if (node2 != null) {
            node2.f6842a = node;
        }
        this.b = null;
        this.f6842a = null;
    }

    public void j(Node node) {
        Node node2 = this.f6842a;
        if (node2 != null) {
            node2.b = node;
        }
        Node node3 = this.b;
        if (node3 != null) {
            node3.f6842a = node;
        }
        node.b = node3;
        node.f6842a = this.f6842a;
        this.b = null;
        this.f6842a = null;
    }

    public void k(Object obj) {
        this.f6844a = obj;
    }

    public void l(Document document) {
        this.f6841a = document;
    }

    public void m(vy2 vy2Var) {
        this.f6843a = vy2Var;
    }

    public abstract void n(Writer writer) throws IOException;

    public String o() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        p(outputStreamWriter);
        outputStreamWriter.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public abstract void p(Writer writer) throws IOException;

    public abstract vy2 q(String str) throws ParseException;

    public abstract Enumeration r(String str) throws ParseException;

    public abstract String s(String str) throws ParseException;

    public abstract Enumeration t(String str) throws ParseException;

    public String toString() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
            n(outputStreamWriter);
            outputStreamWriter.flush();
            return new String(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            return super.toString();
        }
    }

    public boolean u(String str, String str2) throws ParseException {
        try {
            int iLastIndexOf = str.lastIndexOf(47);
            int i = iLastIndexOf + 1;
            if (!str.substring(i).equals("text()") && str.charAt(i) != '@') {
                throw new ParseException("Last step of Xpath expression \"" + str + "\" is not \"text()\" and does not start with a '@'. It starts with a '" + str.charAt(i) + "'");
            }
            boolean z = false;
            String strSubstring = str.substring(0, iLastIndexOf);
            if (str.charAt(i) == '@') {
                String strSubstring2 = str.substring(iLastIndexOf + 2);
                if (strSubstring2.length() == 0) {
                    throw new ParseException("Xpath expression \"" + str + "\" specifies zero-length attribute name\"");
                }
                Enumeration enumerationR = r(strSubstring);
                while (enumerationR.hasMoreElements()) {
                    vy2 vy2Var = (vy2) enumerationR.nextElement();
                    if (!str2.equals(vy2Var.B(strSubstring2))) {
                        vy2Var.M(strSubstring2, str2);
                        z = true;
                    }
                }
                return z;
            }
            Enumeration enumerationR2 = r(strSubstring);
            boolean zHasMoreElements = enumerationR2.hasMoreElements();
            while (enumerationR2.hasMoreElements()) {
                vy2 vy2Var2 = (vy2) enumerationR2.nextElement();
                Vector vector = new Vector();
                for (Node nodeD = vy2Var2.D(); nodeD != null; nodeD = nodeD.b()) {
                    if (nodeD instanceof l39) {
                        vector.addElement((l39) nodeD);
                    }
                }
                if (vector.size() == 0) {
                    l39 l39Var = new l39(str2);
                    if (l39Var.y().length() > 0) {
                        vy2Var2.v(l39Var);
                        zHasMoreElements = true;
                    }
                } else {
                    l39 l39Var2 = (l39) vector.elementAt(0);
                    if (!l39Var2.y().equals(str2)) {
                        vector.removeElementAt(0);
                        l39Var2.z(str2);
                        zHasMoreElements = true;
                    }
                    int i2 = 0;
                    while (i2 < vector.size()) {
                        vy2Var2.H((l39) vector.elementAt(i2));
                        i2++;
                        zHasMoreElements = true;
                    }
                }
            }
            return zHasMoreElements;
        } catch (DOMException e) {
            throw new Error("Assertion failed " + e);
        } catch (IndexOutOfBoundsException unused) {
            throw new ParseException("Xpath expression \"" + str + "\" is not in the form \"xpathExpression/@attributeName\"");
        }
    }
}
