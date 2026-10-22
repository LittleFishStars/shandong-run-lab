package com.zj.adlib;

import com.google.common.net.c;
import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class k5a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42746a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Hashtable f17586a = new Hashtable();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f17587a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Stack f17588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17589a;

    public k5a(boolean z, fr8[] fr8VarArr) {
        this.f17588a = new Stack();
        for (fr8 fr8Var : fr8VarArr) {
            this.f17588a.addElement(fr8Var);
        }
        this.f17589a = z;
        this.f17587a = null;
    }

    public static k5a b(String str) throws XPathException {
        k5a k5aVar;
        synchronized (f17586a) {
            k5aVar = (k5a) f17586a.get(str);
            if (k5aVar == null) {
                k5aVar = new k5a(str);
                f17586a.put(str, k5aVar);
            }
        }
        return k5aVar;
    }

    public static k5a c(boolean z, fr8[] fr8VarArr) {
        k5a k5aVar = new k5a(z, fr8VarArr);
        String string = k5aVar.toString();
        synchronized (f17586a) {
            k5a k5aVar2 = (k5a) f17586a.get(string);
            if (k5aVar2 != null) {
                return k5aVar2;
            }
            f17586a.put(string, k5aVar);
            return k5aVar;
        }
    }

    public static boolean i(String str) throws XPathException, IOException {
        return b(str).h();
    }

    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration enumerationElements = this.f17588a.elements();
        boolean z = true;
        while (enumerationElements.hasMoreElements()) {
            fr8 fr8Var = (fr8) enumerationElements.nextElement();
            if (!z || this.f17589a) {
                stringBuffer.append('/');
                if (fr8Var.c()) {
                    stringBuffer.append('/');
                }
            }
            stringBuffer.append(fr8Var.toString());
            z = false;
        }
        return stringBuffer.toString();
    }

    public Object clone() {
        int size = this.f17588a.size();
        fr8[] fr8VarArr = new fr8[size];
        Enumeration enumerationElements = this.f17588a.elements();
        for (int i = 0; i < size; i++) {
            fr8VarArr[i] = (fr8) enumerationElements.nextElement();
        }
        return new k5a(this.f17589a, fr8VarArr);
    }

    public String d() throws XPathException {
        BooleanExpr booleanExprB = ((fr8) this.f17588a.peek()).b();
        if (booleanExprB instanceof pd0) {
            return ((pd0) booleanExprB).b();
        }
        throw new XPathException(this, "has no indexing attribute name (must end with predicate of the form [@attrName]");
    }

    public String e() throws XPathException {
        BooleanExpr booleanExprB = ((fr8) this.f17588a.peek()).b();
        if (booleanExprB instanceof od0) {
            return ((od0) booleanExprB).b();
        }
        return null;
    }

    public Enumeration f() {
        return this.f17588a.elements();
    }

    public boolean g() {
        return this.f17589a;
    }

    public boolean h() {
        return ((fr8) this.f17588a.peek()).d();
    }

    public String toString() {
        if (this.f17587a == null) {
            this.f17587a = a();
        }
        return this.f17587a;
    }

    public k5a(String str) throws XPathException {
        this(str, new InputStreamReader(new ByteArrayInputStream(str.getBytes())));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004b A[Catch: IOException -> 0x0070, TryCatch #0 {IOException -> 0x0070, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:10:0x003d, B:11:0x0047, B:13:0x004b, B:15:0x0051, B:17:0x0057, B:21:0x0066, B:22:0x006f, B:8:0x003a), top: B:26:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0051 A[Catch: IOException -> 0x0070, TryCatch #0 {IOException -> 0x0070, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:10:0x003d, B:11:0x0047, B:13:0x004b, B:15:0x0051, B:17:0x0057, B:21:0x0066, B:22:0x006f, B:8:0x003a), top: B:26:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0056  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0066 A[Catch: IOException -> 0x0070, TryCatch #0 {IOException -> 0x0070, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:10:0x003d, B:11:0x0047, B:13:0x004b, B:15:0x0051, B:17:0x0057, B:21:0x0066, B:22:0x006f, B:8:0x003a), top: B:26:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0062 A[EDGE_INSN: B:28:0x0062->B:18:0x0062 BREAK  A[LOOP:0: B:11:0x0047->B:17:0x0057], SYNTHETIC] */
    public k5a(String str, Reader reader) throws XPathException {
        boolean z;
        int i;
        boolean z2;
        this.f17588a = new Stack();
        try {
            this.f17587a = str;
            tg8 tg8Var = new tg8(reader);
            tg8Var.b('/');
            tg8Var.b('.');
            tg8Var.d(c.b, c.b);
            tg8Var.d('_', '_');
            if (tg8Var.a() == 47) {
                this.f17589a = true;
                if (tg8Var.a() == 47) {
                    tg8Var.a();
                    z = true;
                }
                this.f17588a.push(new fr8(this, z, tg8Var));
                while (true) {
                    i = tg8Var.f19804a;
                    if (i == 47) {
                        break;
                    }
                    if (tg8Var.a() == 47) {
                        tg8Var.a();
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f17588a.push(new fr8(this, z2, tg8Var));
                }
                if (i == -1) {
                } else {
                    throw new XPathException(this, "at end of XPATH expression", tg8Var, "end of expression");
                }
            }
            this.f17589a = false;
            z = false;
            this.f17588a.push(new fr8(this, z, tg8Var));
            while (true) {
                i = tg8Var.f19804a;
                if (i == 47) {
                    break;
                    break;
                }
                if (tg8Var.a() == 47) {
                    tg8Var.a();
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f17588a.push(new fr8(this, z2, tg8Var));
            }
            if (i == -1) {
            } else {
                throw new XPathException(this, "at end of XPATH expression", tg8Var, "end of expression");
            }
        } catch (IOException e) {
            throw new XPathException(this, e);
        }
    }
}
