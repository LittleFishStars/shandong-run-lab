package com.hp.hpl.sparta;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.hp.hpl.sparta.xpath.XPathException;
import com.zj.adlib.e13;
import com.zj.adlib.fr8;
import com.zj.adlib.k5a;
import com.zj.adlib.q5a;
import com.zj.adlib.vy2;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class Document extends Node {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer f32690a = new Integer(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Enumeration f6832a = new e13();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f6833a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Sparta.Cache f6834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f6835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Hashtable f6836a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Vector f6837a;
    public vy2 b;

    public interface Observer {
        void update(Document document);
    }

    public class a implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public transient Sparta.Cache f6838a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final k5a f6839a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f6840a;

        public a(k5a k5aVar) throws XPathException {
            this.f6840a = k5aVar.d();
            this.f6839a = k5aVar;
            Document.this.v(this);
        }

        public synchronized Enumeration a(String str) throws ParseException {
            Vector vector;
            if (this.f6838a == null) {
                b();
            }
            vector = (Vector) this.f6838a.get(str);
            return vector == null ? Document.f6832a : vector.elements();
        }

        public final void b() throws ParseException {
            try {
                this.f6838a = Sparta.b();
                Enumeration enumerationW = Document.this.C(this.f6839a, false).w();
                while (enumerationW.hasMoreElements()) {
                    vy2 vy2Var = (vy2) enumerationW.nextElement();
                    String strB = vy2Var.B(this.f6840a);
                    Vector vector = (Vector) this.f6838a.get(strB);
                    if (vector == null) {
                        vector = new Vector(1);
                        this.f6838a.put(strB, vector);
                    }
                    vector.addElement(vy2Var);
                }
            } catch (XPathException e) {
                throw new ParseException("XPath problem", e);
            }
        }

        public synchronized int c() throws ParseException {
            if (this.f6838a == null) {
                b();
            }
            return this.f6838a.size();
        }

        @Override // com.hp.hpl.sparta.Document.Observer
        public synchronized void update(Document document) {
            this.f6838a = null;
        }
    }

    public Document(String str) {
        this.b = null;
        this.f6834a = Sparta.b();
        this.f6837a = new Vector();
        this.f6836a = null;
        this.f6835a = str;
    }

    public void A(vy2 vy2Var) {
        this.b = vy2Var;
        vy2Var.l(this);
        h();
    }

    public void B(String str) {
        this.f6835a = str;
        h();
    }

    public q5a C(k5a k5aVar, boolean z) throws XPathException {
        if (k5aVar.h() == z) {
            return new q5a(this, k5aVar);
        }
        throw new XPathException(k5aVar, "\"" + k5aVar + "\" evaluates to " + (z ? "evaluates to element not string" : "evaluates to string not element"));
    }

    public final q5a D(String str, boolean z) throws XPathException {
        if (str.charAt(0) != '/') {
            str = WVNativeCallbackUtil.SEPERATER + str;
        }
        return C(k5a.b(str), z);
    }

    public boolean E(String str) throws ParseException {
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
            Enumeration enumerationF2 = k5aVarB.f();
            fr8 fr8Var = (fr8) enumerationF2.nextElement();
            int i2 = i - 1;
            fr8[] fr8VarArr = new fr8[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                fr8VarArr[i3] = (fr8) enumerationF2.nextElement();
            }
            if (this.b == null) {
                A(g(null, fr8Var, str));
            } else {
                if (q(WVNativeCallbackUtil.SEPERATER + fr8Var) == null) {
                    throw new ParseException("Existing root element <" + this.b.F() + "...> does not match first step \"" + fr8Var + "\" of \"" + str);
                }
            }
            if (i2 == 0) {
                return true;
            }
            return this.b.P(k5a.c(false, fr8VarArr).toString());
        } catch (XPathException e) {
            throw new ParseException(str, e);
        }
    }

    public a F(String str) throws ParseException {
        try {
            a aVar = (a) this.f6834a.get(str);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a(k5a.b(str));
            this.f6834a.put(str, aVar2);
            return aVar2;
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    public boolean G(String str) {
        return this.f6834a.get(str) != null;
    }

    @Override // com.hp.hpl.sparta.Node
    public Object clone() {
        Document document = new Document(this.f6835a);
        document.b = (vy2) this.b.clone();
        return document;
    }

    @Override // com.hp.hpl.sparta.Node
    public int computeHashCode() {
        return this.b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Document) {
            return this.b.equals(((Document) obj).b);
        }
        return false;
    }

    @Override // com.hp.hpl.sparta.Node
    public void h() {
        Enumeration enumerationElements = this.f6837a.elements();
        while (enumerationElements.hasMoreElements()) {
            ((Observer) enumerationElements.nextElement()).update(this);
        }
    }

    @Override // com.hp.hpl.sparta.Node
    public void n(Writer writer) throws IOException {
        this.b.n(writer);
    }

    @Override // com.hp.hpl.sparta.Node
    public void p(Writer writer) throws IOException {
        writer.write("<?xml version=\"1.0\" ?>\n");
        this.b.p(writer);
    }

    @Override // com.hp.hpl.sparta.Node
    public vy2 q(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = WVNativeCallbackUtil.SEPERATER + str;
            }
            k5a k5aVarB = k5a.b(str);
            z(k5aVarB);
            return C(k5aVarB, false).u();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.Node
    public Enumeration r(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = WVNativeCallbackUtil.SEPERATER + str;
            }
            k5a k5aVarB = k5a.b(str);
            z(k5aVarB);
            return C(k5aVarB, false).w();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.Node
    public String s(String str) throws ParseException {
        try {
            return D(str, true).v();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.Node
    public Enumeration t(String str) throws ParseException {
        try {
            return D(str, true).w();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.Node
    public String toString() {
        return this.f6835a;
    }

    public void v(Observer observer) {
        this.f6837a.addElement(observer);
    }

    public void w(Observer observer) {
        this.f6837a.removeElement(observer);
    }

    public vy2 x() {
        return this.b;
    }

    public String y() {
        return this.f6835a;
    }

    public void z(k5a k5aVar) throws XPathException {
    }

    public Document() {
        this.b = null;
        this.f6834a = Sparta.b();
        this.f6837a = new Vector();
        this.f6836a = null;
        this.f6835a = "MEMORY";
    }
}
