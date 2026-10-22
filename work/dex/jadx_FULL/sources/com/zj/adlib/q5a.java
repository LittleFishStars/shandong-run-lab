package com.zj.adlib;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.Node;
import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.Visitor;
import com.hp.hpl.sparta.xpath.XPathException;
import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class q5a implements Visitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f44129a = new Boolean(true);
    public static final Boolean b = new Boolean(false);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Node f19004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k5a f19005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f19006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xz5 f19007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f19008a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Enumeration f19009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Vector f19010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19011a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f44130a;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f44131a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Boolean f19012a;

            public a(Boolean bool, a aVar) {
                this.f19012a = bool;
                this.f44131a = aVar;
            }
        }

        public b() {
            this.f44130a = null;
        }

        public Boolean a() {
            a aVar = this.f44130a;
            Boolean bool = aVar.f19012a;
            this.f44130a = aVar.f44131a;
            return bool;
        }

        public void b(Boolean bool) {
            this.f44130a = new a(bool, this.f44130a);
        }
    }

    public q5a(k5a k5aVar, Node node) throws XPathException {
        this.f19007a = new xz5();
        this.f19010a = new Vector();
        this.f19009a = null;
        this.f19008a = null;
        this.f19006a = new b();
        this.f19005a = k5aVar;
        this.f19004a = node;
        Vector vector = new Vector(1);
        this.f19010a = vector;
        vector.addElement(this.f19004a);
        Enumeration enumerationF = k5aVar.f();
        while (enumerationF.hasMoreElements()) {
            fr8 fr8Var = (fr8) enumerationF.nextElement();
            this.f19011a = fr8Var.c();
            this.f19009a = null;
            fr8Var.a().a(this);
            this.f19009a = this.f19007a.d();
            this.f19010a.removeAllElements();
            BooleanExpr booleanExprB = fr8Var.b();
            while (this.f19009a.hasMoreElements()) {
                this.f19008a = this.f19009a.nextElement();
                booleanExprB.a(this);
                if (this.f19006a.a().booleanValue()) {
                    this.f19010a.addElement(this.f19008a);
                }
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
    public void a(gv6 gv6Var) throws XPathException {
        Object obj = this.f19008a;
        if (!(obj instanceof vy2)) {
            throw new XPathException(this.f19005a, "Cannot test position of document");
        }
        this.f19006a.b(this.f19007a.e((vy2) obj) == gv6Var.b() ? f44129a : b);
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
    public void b(zc9 zc9Var) {
        this.f19006a.b(f44129a);
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
    public void c(rd0 rd0Var) throws XPathException {
        Object obj = this.f19008a;
        if (!(obj instanceof vy2)) {
            throw new XPathException(this.f19005a, "Cannot test attribute of document");
        }
        this.f19006a.b((((double) Long.parseLong(((vy2) obj).B(rd0Var.b()))) > rd0Var.c() ? 1 : (((double) Long.parseLong(((vy2) obj).B(rd0Var.b()))) == rd0Var.c() ? 0 : -1)) < 0 ? f44129a : b);
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTestVisitor
    public void d(c59 c59Var) {
        this.f19007a.f();
        this.f19007a.a(this.f19004a, 1);
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
    public void e(x39 x39Var) throws XPathException {
        Object obj = this.f19008a;
        if (!(obj instanceof vy2)) {
            throw new XPathException(this.f19005a, "Cannot test attribute of document");
        }
        for (Node nodeD = ((vy2) obj).D(); nodeD != null; nodeD = nodeD.b()) {
            if ((nodeD instanceof l39) && !((l39) nodeD).y().equals(x39Var.b())) {
                this.f19006a.b(f44129a);
                return;
            }
        }
        this.f19006a.b(b);
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
    public void f(od0 od0Var) throws XPathException {
        Object obj = this.f19008a;
        if (!(obj instanceof vy2)) {
            throw new XPathException(this.f19005a, "Cannot test attribute of document");
        }
        this.f19006a.b(od0Var.c().equals(((vy2) obj).B(od0Var.b())) ? f44129a : b);
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTestVisitor
    public void g(o40 o40Var) {
        Vector vector = this.f19010a;
        this.f19007a.f();
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            Object objNextElement = enumerationElements.nextElement();
            if (objNextElement instanceof vy2) {
                r((vy2) objNextElement);
            } else if (objNextElement instanceof Document) {
                q((Document) objNextElement);
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
    public void h(q39 q39Var) throws XPathException {
        Object obj = this.f19008a;
        if (!(obj instanceof vy2)) {
            throw new XPathException(this.f19005a, "Cannot test attribute of document");
        }
        for (Node nodeD = ((vy2) obj).D(); nodeD != null; nodeD = nodeD.b()) {
            if (nodeD instanceof l39) {
                this.f19006a.b(f44129a);
                return;
            }
        }
        this.f19006a.b(b);
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
    public void i(qd0 qd0Var) throws XPathException {
        Object obj = this.f19008a;
        if (!(obj instanceof vy2)) {
            throw new XPathException(this.f19005a, "Cannot test attribute of document");
        }
        this.f19006a.b((((double) Long.parseLong(((vy2) obj).B(qd0Var.b()))) > qd0Var.c() ? 1 : (((double) Long.parseLong(((vy2) obj).B(qd0Var.b()))) == qd0Var.c() ? 0 : -1)) > 0 ? f44129a : b);
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
    public void j(sd0 sd0Var) throws XPathException {
        Object obj = this.f19008a;
        if (!(obj instanceof vy2)) {
            throw new XPathException(this.f19005a, "Cannot test attribute of document");
        }
        this.f19006a.b(sd0Var.c().equals(((vy2) obj).B(sd0Var.b())) ^ true ? f44129a : b);
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
    public void k(p39 p39Var) throws XPathException {
        Object obj = this.f19008a;
        if (!(obj instanceof vy2)) {
            throw new XPathException(this.f19005a, "Cannot test attribute of document");
        }
        for (Node nodeD = ((vy2) obj).D(); nodeD != null; nodeD = nodeD.b()) {
            if ((nodeD instanceof l39) && ((l39) nodeD).y().equals(p39Var.b())) {
                this.f19006a.b(f44129a);
                return;
            }
        }
        this.f19006a.b(b);
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTestVisitor
    public void l(mm6 mm6Var) throws XPathException {
        this.f19007a.f();
        vy2 vy2VarD = this.f19004a.d();
        if (vy2VarD == null) {
            throw new XPathException(this.f19005a, "Illegal attempt to apply \"..\" to node with no parent.");
        }
        this.f19007a.a(vy2VarD, 1);
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTestVisitor
    public void m(ud0 ud0Var) {
        String strB;
        Vector vector = this.f19010a;
        this.f19007a.f();
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            Node node = (Node) enumerationElements.nextElement();
            if ((node instanceof vy2) && (strB = ((vy2) node).B(ud0Var.c())) != null) {
                this.f19007a.b(strB);
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTestVisitor
    public void n(e49 e49Var) {
        Vector vector = this.f19010a;
        this.f19007a.f();
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            Object objNextElement = enumerationElements.nextElement();
            if (objNextElement instanceof vy2) {
                for (Node nodeD = ((vy2) objNextElement).D(); nodeD != null; nodeD = nodeD.b()) {
                    if (nodeD instanceof l39) {
                        this.f19007a.b(((l39) nodeD).y());
                    }
                }
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTestVisitor
    public void o(zy2 zy2Var) {
        String strC = zy2Var.c();
        Vector vector = this.f19010a;
        int size = vector.size();
        this.f19007a.f();
        for (int i = 0; i < size; i++) {
            Object objElementAt = vector.elementAt(i);
            if (objElementAt instanceof vy2) {
                t((vy2) objElementAt, strC);
            } else if (objElementAt instanceof Document) {
                s((Document) objElementAt, strC);
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExprVisitor
    public void p(pd0 pd0Var) throws XPathException {
        Object obj = this.f19008a;
        if (!(obj instanceof vy2)) {
            throw new XPathException(this.f19005a, "Cannot test attribute of document");
        }
        String strB = ((vy2) obj).B(pd0Var.b());
        this.f19006a.b(strB != null && strB.length() > 0 ? f44129a : b);
    }

    public final void q(Document document) {
        vy2 vy2VarX = document.x();
        this.f19007a.a(vy2VarX, 1);
        if (this.f19011a) {
            r(vy2VarX);
        }
    }

    public final void r(vy2 vy2Var) {
        int i = 0;
        for (Node nodeD = vy2Var.D(); nodeD != null; nodeD = nodeD.b()) {
            if (nodeD instanceof vy2) {
                i++;
                this.f19007a.a(nodeD, i);
                if (this.f19011a) {
                    r((vy2) nodeD);
                }
            }
        }
    }

    public final void s(Document document, String str) {
        vy2 vy2VarX = document.x();
        if (vy2VarX == null) {
            return;
        }
        if (vy2VarX.F() == str) {
            this.f19007a.a(vy2VarX, 1);
        }
        if (this.f19011a) {
            t(vy2VarX, str);
        }
    }

    public final void t(vy2 vy2Var, String str) {
        int i = 0;
        for (Node nodeD = vy2Var.D(); nodeD != null; nodeD = nodeD.b()) {
            if (nodeD instanceof vy2) {
                vy2 vy2Var2 = (vy2) nodeD;
                if (vy2Var2.F() == str) {
                    i++;
                    this.f19007a.a(vy2Var2, i);
                }
                if (this.f19011a) {
                    t(vy2Var2, str);
                }
            }
        }
    }

    public vy2 u() {
        if (this.f19010a.size() == 0) {
            return null;
        }
        return (vy2) this.f19010a.elementAt(0);
    }

    public String v() {
        if (this.f19010a.size() == 0) {
            return null;
        }
        return this.f19010a.elementAt(0).toString();
    }

    public Enumeration w() {
        return this.f19010a.elements();
    }

    public q5a(vy2 vy2Var, k5a k5aVar) throws XPathException {
        this(k5aVar, vy2Var);
        if (k5aVar.g()) {
            throw new XPathException(k5aVar, "Cannot use element as context node for absolute xpath");
        }
    }

    public q5a(Document document, k5a k5aVar) throws XPathException {
        this(k5aVar, document);
    }
}
