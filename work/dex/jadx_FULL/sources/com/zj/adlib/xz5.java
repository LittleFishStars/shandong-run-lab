package com.zj.adlib;

import com.hp.hpl.sparta.Node;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class xz5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer f45926a = new Integer(1);
    public static final Integer b = new Integer(2);
    public static final Integer c = new Integer(3);
    public static final Integer d = new Integer(4);
    public static final Integer e = new Integer(5);
    public static final Integer f = new Integer(6);
    public static final Integer g = new Integer(7);
    public static final Integer h = new Integer(8);
    public static final Integer i = new Integer(9);
    public static final Integer j = new Integer(10);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Vector f20756a = new Vector();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Hashtable f20755a = new Hashtable();

    public static Integer c(Node node) {
        return new Integer(System.identityHashCode(node));
    }

    public void a(Node node, int i2) {
        Integer num;
        this.f20756a.addElement(node);
        switch (i2) {
            case 1:
                num = f45926a;
                break;
            case 2:
                num = b;
                break;
            case 3:
                num = c;
                break;
            case 4:
                num = d;
                break;
            case 5:
                num = e;
                break;
            case 6:
                num = f;
                break;
            case 7:
                num = g;
                break;
            case 8:
                num = h;
                break;
            case 9:
                num = i;
                break;
            case 10:
                num = j;
                break;
            default:
                num = new Integer(i2);
                break;
        }
        this.f20755a.put(c(node), num);
    }

    public void b(String str) {
        this.f20756a.addElement(str);
    }

    public Enumeration d() {
        return this.f20756a.elements();
    }

    public int e(Node node) {
        return ((Integer) this.f20755a.get(c(node))).intValue();
    }

    public void f() {
        this.f20756a.removeAllElements();
        this.f20755a.clear();
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{ ");
            Enumeration enumerationElements = this.f20756a.elements();
            while (enumerationElements.hasMoreElements()) {
                Object objNextElement = enumerationElements.nextElement();
                if (objNextElement instanceof String) {
                    stringBuffer.append("String(" + objNextElement + ") ");
                } else {
                    Node node = (Node) objNextElement;
                    stringBuffer.append("Node(" + node.o() + ")[" + this.f20755a.get(c(node)) + "] ");
                }
            }
            stringBuffer.append("}");
            return stringBuffer.toString();
        } catch (IOException e2) {
            return e2.toString();
        }
    }
}
