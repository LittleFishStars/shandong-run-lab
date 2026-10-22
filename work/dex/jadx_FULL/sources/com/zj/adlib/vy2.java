package com.zj.adlib;

import com.hp.hpl.sparta.DOMException;
import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.Node;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.Sparta;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class vy2 extends Node {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f45485a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f20344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Hashtable f20345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Vector f20346a;
    public Node c;
    public Node d;

    public vy2(String str) {
        this.c = null;
        this.d = null;
        this.f20345a = null;
        this.f20346a = null;
        this.f20344a = null;
        this.f20344a = Sparta.a(str);
    }

    public vy2 A() {
        return z(false);
    }

    public String B(String str) {
        Hashtable hashtable = this.f20345a;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str);
    }

    public Enumeration C() {
        Vector vector = this.f20346a;
        return vector == null ? Document.f6832a : vector.elements();
    }

    public Node D() {
        return this.c;
    }

    public Node E() {
        return this.d;
    }

    public String F() {
        return this.f20344a;
    }

    public void G(String str) {
        Hashtable hashtable = this.f20345a;
        if (hashtable == null) {
            return;
        }
        hashtable.remove(str);
        this.f20346a.removeElement(str);
        h();
    }

    public void H(Node node) throws DOMException {
        if (I(node)) {
            h();
            return;
        }
        throw new DOMException((short) 8, "Cannot find " + node + " in " + this);
    }

    public final boolean I(Node node) {
        for (Node nodeB = this.c; nodeB != null; nodeB = nodeB.b()) {
            if (nodeB.equals(node)) {
                if (this.c == nodeB) {
                    this.c = nodeB.b();
                }
                if (this.d == nodeB) {
                    this.d = nodeB.e();
                }
                nodeB.i();
                nodeB.m(null);
                nodeB.l(null);
                return true;
            }
        }
        return false;
    }

    public void J(vy2 vy2Var, Node node) throws DOMException {
        L(vy2Var, node);
        h();
    }

    public void K(l39 l39Var, Node node) throws DOMException {
        L(l39Var, node);
        h();
    }

    public final void L(Node node, Node node2) throws DOMException {
        for (Node nodeB = this.c; nodeB != null; nodeB = nodeB.b()) {
            if (nodeB == node2) {
                if (this.c == node2) {
                    this.c = node;
                }
                if (this.d == node2) {
                    this.d = node;
                }
                node2.j(node);
                node.m(this);
                node2.m(null);
                return;
            }
        }
        throw new DOMException((short) 8, "Cannot find " + node2 + " in " + this);
    }

    public void M(String str, String str2) {
        if (this.f20345a == null) {
            this.f20345a = new Hashtable();
            this.f20346a = new Vector();
        }
        if (this.f20345a.get(str) == null) {
            this.f20346a.addElement(str);
        }
        this.f20345a.put(str, str2);
        h();
    }

    public void N(String str) {
        this.f20344a = Sparta.a(str);
        h();
    }

    public final q5a O(String str, boolean z) throws XPathException {
        k5a k5aVarB = k5a.b(str);
        if (k5aVarB.h() == z) {
            return new q5a(this, k5aVarB);
        }
        throw new XPathException(k5aVarB, "\"" + k5aVarB + "\" evaluates to " + (z ? "evaluates to element not string" : "evaluates to string not element"));
    }

    public boolean P(String str) throws ParseException {
        vy2 vy2VarQ;
        try {
            if (q(str) != null) {
                return false;
            }
            k5a k5aVarB = k5a.b(str);
            Enumeration enumerationF = k5aVarB.f();
            int i = 0;
            while (enumerationF.hasMoreElements()) {
                enumerationF.nextElement();
                i++;
            }
            int i2 = i - 1;
            fr8[] fr8VarArr = new fr8[i2];
            Enumeration enumerationF2 = k5aVarB.f();
            for (int i3 = 0; i3 < i2; i3++) {
                fr8VarArr[i3] = (fr8) enumerationF2.nextElement();
            }
            fr8 fr8Var = (fr8) enumerationF2.nextElement();
            if (i2 == 0) {
                vy2VarQ = this;
            } else {
                String string = k5a.c(k5aVarB.g(), fr8VarArr).toString();
                P(string.toString());
                vy2VarQ = q(string);
            }
            vy2VarQ.w(g(vy2VarQ, fr8Var, str));
            return true;
        } catch (XPathException e) {
            throw new ParseException(str, e);
        }
    }

    @Override // com.hp.hpl.sparta.Node
    public Object clone() {
        return z(true);
    }

    @Override // com.hp.hpl.sparta.Node
    public int computeHashCode() {
        int iHashCode = this.f20344a.hashCode();
        Hashtable hashtable = this.f20345a;
        if (hashtable != null) {
            Enumeration enumerationKeys = hashtable.keys();
            while (enumerationKeys.hasMoreElements()) {
                String str = (String) enumerationKeys.nextElement();
                iHashCode = (((iHashCode * 31) + str.hashCode()) * 31) + ((String) this.f20345a.get(str)).hashCode();
            }
        }
        for (Node nodeB = this.c; nodeB != null; nodeB = nodeB.b()) {
            iHashCode = (iHashCode * 31) + nodeB.hashCode();
        }
        return iHashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vy2)) {
            return false;
        }
        vy2 vy2Var = (vy2) obj;
        if (!this.f20344a.equals(vy2Var.f20344a)) {
            return false;
        }
        Hashtable hashtable = this.f20345a;
        int size = hashtable == null ? 0 : hashtable.size();
        Hashtable hashtable2 = vy2Var.f20345a;
        if (size != (hashtable2 == null ? 0 : hashtable2.size())) {
            return false;
        }
        Hashtable hashtable3 = this.f20345a;
        if (hashtable3 != null) {
            Enumeration enumerationKeys = hashtable3.keys();
            while (enumerationKeys.hasMoreElements()) {
                String str = (String) enumerationKeys.nextElement();
                if (!((String) this.f20345a.get(str)).equals((String) vy2Var.f20345a.get(str))) {
                    return false;
                }
            }
        }
        Node nodeB = this.c;
        Node nodeB2 = vy2Var.c;
        while (nodeB != null) {
            if (!nodeB.equals(nodeB2)) {
                return false;
            }
            nodeB = nodeB.b();
            nodeB2 = nodeB2.b();
        }
        return true;
    }

    @Override // com.hp.hpl.sparta.Node
    public void n(Writer writer) throws IOException {
        for (Node nodeB = this.c; nodeB != null; nodeB = nodeB.b()) {
            nodeB.n(writer);
        }
    }

    @Override // com.hp.hpl.sparta.Node
    public void p(Writer writer) throws IOException {
        writer.write("<" + this.f20344a);
        Vector vector = this.f20346a;
        if (vector != null) {
            Enumeration enumerationElements = vector.elements();
            while (enumerationElements.hasMoreElements()) {
                String str = (String) enumerationElements.nextElement();
                String str2 = (String) this.f20345a.get(str);
                writer.write(" " + str + "=\"");
                Node.htmlEncode(writer, str2);
                writer.write("\"");
            }
        }
        if (this.c == null) {
            writer.write("/>");
            return;
        }
        writer.write(">");
        for (Node nodeB = this.c; nodeB != null; nodeB = nodeB.b()) {
            nodeB.p(writer);
        }
        writer.write("</" + this.f20344a + ">");
    }

    @Override // com.hp.hpl.sparta.Node
    public vy2 q(String str) throws ParseException {
        try {
            return O(str, false).u();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.Node
    public Enumeration r(String str) throws ParseException {
        try {
            return O(str, false).w();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.Node
    public String s(String str) throws ParseException {
        try {
            return O(str, true).v();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.Node
    public Enumeration t(String str) throws ParseException {
        try {
            return O(str, true).w();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    public void v(Node node) {
        if (!x(node)) {
            node = (vy2) node.clone();
        }
        w(node);
        h();
    }

    public void w(Node node) {
        vy2 vy2VarD = node.d();
        if (vy2VarD != null) {
            vy2VarD.I(node);
        }
        node.f(this.d);
        if (this.c == null) {
            this.c = node;
        }
        node.m(this);
        this.d = node;
        node.l(c());
    }

    public boolean x(Node node) {
        if (node == this) {
            return false;
        }
        vy2 vy2VarD = d();
        if (vy2VarD == null) {
            return true;
        }
        return vy2VarD.x(node);
    }

    public final void y() {
    }

    public vy2 z(boolean z) {
        vy2 vy2Var = new vy2(this.f20344a);
        Vector vector = this.f20346a;
        if (vector != null) {
            Enumeration enumerationElements = vector.elements();
            while (enumerationElements.hasMoreElements()) {
                String str = (String) enumerationElements.nextElement();
                vy2Var.M(str, (String) this.f20345a.get(str));
            }
        }
        if (z) {
            for (Node nodeB = this.c; nodeB != null; nodeB = nodeB.b()) {
                vy2Var.v((Node) nodeB.clone());
            }
        }
        return vy2Var;
    }

    public vy2() {
        this.c = null;
        this.d = null;
        this.f20345a = null;
        this.f20346a = null;
        this.f20344a = null;
    }
}
