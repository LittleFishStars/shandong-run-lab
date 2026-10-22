package com.acse.ottn;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class n extends j {
    public ArrayList<j> b = new ArrayList<>();
    public HashMap<j, f> c = new HashMap<>();
    public ArrayList<f> d = new ArrayList<>();
    public ArrayList<f> e = new ArrayList<>();
    public boolean f = true;
    public b g = null;
    public boolean h = false;
    public boolean i = false;
    public long j = 0;
    public t4 k = null;
    public long l = -1;

    public class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f23086a = false;
        public final /* synthetic */ ArrayList b;

        public a(ArrayList arrayList) {
            this.b = arrayList;
        }

        @Override // com.acse.ottn.l, com.acse.ottn.j.a
        public void b(j jVar) {
            if (this.f23086a) {
                return;
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.b.get(i);
                fVar.f23091a.k();
                n.this.b.add(fVar.f23091a);
            }
        }

        @Override // com.acse.ottn.l, com.acse.ottn.j.a
        public void d(j jVar) {
            this.f23086a = true;
        }
    }

    public class b implements j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f23087a;

        public b(n nVar) {
            this.f23087a = nVar;
        }

        @Override // com.acse.ottn.j.a
        public void a(j jVar) {
        }

        @Override // com.acse.ottn.j.a
        public void b(j jVar) {
            jVar.b(this);
            n.this.b.remove(jVar);
            boolean z = true;
            ((f) this.f23087a.c.get(jVar)).f = true;
            if (n.this.h) {
                return;
            }
            ArrayList arrayList = this.f23087a.e;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (!((f) arrayList.get(i)).f) {
                    z = false;
                    break;
                }
            }
            if (z) {
                ArrayList<j.a> arrayList2 = n.this.f23063a;
                if (arrayList2 != null) {
                    ArrayList arrayList3 = (ArrayList) arrayList2.clone();
                    int size2 = arrayList3.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((j.a) arrayList3.get(i2)).b(this.f23087a);
                    }
                }
                this.f23087a.i = false;
            }
        }

        @Override // com.acse.ottn.j.a
        public void c(j jVar) {
        }

        @Override // com.acse.ottn.j.a
        public void d(j jVar) {
            ArrayList<j.a> arrayList;
            n nVar = n.this;
            if (nVar.h || nVar.b.size() != 0 || (arrayList = n.this.f23063a) == null) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                n.this.f23063a.get(i).d(this.f23087a);
            }
        }
    }

    public static class d {
        public static final int c = 0;
        public static final int d = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f23089a;
        public int b;

        public d(f fVar, int i) {
            this.f23089a = fVar;
            this.b = i;
        }
    }

    public static class e implements j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f23090a;
        public f b;
        public int c;

        public e(n nVar, f fVar, int i) {
            this.f23090a = nVar;
            this.b = fVar;
            this.c = i;
        }

        @Override // com.acse.ottn.j.a
        public void a(j jVar) {
            if (this.c == 0) {
                e(jVar);
            }
        }

        @Override // com.acse.ottn.j.a
        public void b(j jVar) {
            if (this.c == 1) {
                e(jVar);
            }
        }

        @Override // com.acse.ottn.j.a
        public void c(j jVar) {
        }

        @Override // com.acse.ottn.j.a
        public void d(j jVar) {
        }

        public final void e(j jVar) {
            d dVar;
            if (this.f23090a.h) {
                return;
            }
            int size = this.b.c.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    dVar = null;
                    break;
                }
                dVar = this.b.c.get(i);
                if (dVar.b == this.c && dVar.f23089a.f23091a == jVar) {
                    jVar.b(this);
                    break;
                }
                i++;
            }
            this.b.c.remove(dVar);
            if (this.b.c.size() == 0) {
                this.b.f23091a.k();
                this.f23090a.b.add(this.b.f23091a);
            }
        }
    }

    @Override // com.acse.ottn.j
    public void cancel() {
        ArrayList arrayList;
        this.h = true;
        if (g()) {
            ArrayList<j.a> arrayList2 = this.f23063a;
            if (arrayList2 != null) {
                arrayList = (ArrayList) arrayList2.clone();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((j.a) it.next()).d(this);
                }
            } else {
                arrayList = null;
            }
            t4 t4Var = this.k;
            if (t4Var != null && t4Var.f()) {
                this.k.cancel();
            } else if (this.e.size() > 0) {
                Iterator<f> it2 = this.e.iterator();
                while (it2.hasNext()) {
                    it2.next().f23091a.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((j.a) it3.next()).b(this);
                }
            }
            this.i = false;
        }
    }

    @Override // com.acse.ottn.j
    public long e() {
        return this.j;
    }

    @Override // com.acse.ottn.j
    public boolean f() {
        Iterator<f> it = this.d.iterator();
        while (it.hasNext()) {
            if (it.next().f23091a.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.acse.ottn.j
    public boolean g() {
        return this.i;
    }

    @Override // com.acse.ottn.j
    public void i() {
        Iterator<f> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().f23091a.i();
        }
    }

    @Override // com.acse.ottn.j
    public void j() {
        Iterator<f> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().f23091a.j();
        }
    }

    @Override // com.acse.ottn.j
    public void k() {
        this.h = false;
        this.i = true;
        n();
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.e.get(i);
            ArrayList<j.a> arrayListD = fVar.f23091a.d();
            if (arrayListD != null && arrayListD.size() > 0) {
                for (j.a aVar : new ArrayList(arrayListD)) {
                    if ((aVar instanceof e) || (aVar instanceof b)) {
                        fVar.f23091a.b(aVar);
                    }
                }
            }
        }
        ArrayList<f> arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar2 = this.e.get(i2);
            if (this.g == null) {
                this.g = new b(this);
            }
            ArrayList<d> arrayList2 = fVar2.b;
            if (arrayList2 == null || arrayList2.size() == 0) {
                arrayList.add(fVar2);
            } else {
                int size2 = fVar2.b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar = fVar2.b.get(i3);
                    dVar.f23089a.f23091a.a((j.a) new e(this, fVar2, dVar.b));
                }
                fVar2.c = (ArrayList) fVar2.b.clone();
            }
            fVar2.f23091a.a((j.a) this.g);
        }
        if (this.j <= 0) {
            for (f fVar3 : arrayList) {
                fVar3.f23091a.k();
                this.b.add(fVar3.f23091a);
            }
        } else {
            t4 t4VarA = t4.a(0.0f, 1.0f);
            this.k = t4VarA;
            t4VarA.a(this.j);
            this.k.a((j.a) new a(arrayList));
            this.k.k();
        }
        ArrayList<j.a> arrayList3 = this.f23063a;
        if (arrayList3 != null) {
            ArrayList arrayList4 = (ArrayList) arrayList3.clone();
            int size3 = arrayList4.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ((j.a) arrayList4.get(i4)).a(this);
            }
        }
        if (this.d.size() == 0 && this.j == 0) {
            this.i = false;
            ArrayList<j.a> arrayList5 = this.f23063a;
            if (arrayList5 != null) {
                ArrayList arrayList6 = (ArrayList) arrayList5.clone();
                int size4 = arrayList6.size();
                for (int i5 = 0; i5 < size4; i5++) {
                    ((j.a) arrayList6.get(i5)).b(this);
                }
            }
        }
    }

    @Override // com.acse.ottn.j
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public n clone() {
        n nVar = (n) super.clone();
        nVar.f = true;
        nVar.h = false;
        nVar.i = false;
        nVar.b = new ArrayList<>();
        nVar.c = new HashMap<>();
        nVar.d = new ArrayList<>();
        nVar.e = new ArrayList<>();
        HashMap map = new HashMap();
        for (f fVar : this.d) {
            f fVarClone = fVar.clone();
            map.put(fVar, fVarClone);
            nVar.d.add(fVarClone);
            nVar.c.put(fVarClone.f23091a, fVarClone);
            ArrayList arrayList = null;
            fVarClone.b = null;
            fVarClone.c = null;
            fVarClone.e = null;
            fVarClone.d = null;
            ArrayList<j.a> arrayListD = fVarClone.f23091a.d();
            if (arrayListD != null) {
                for (j.a aVar : arrayListD) {
                    if (aVar instanceof b) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(aVar);
                    }
                }
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayListD.remove((j.a) it.next());
                    }
                }
            }
        }
        for (f fVar2 : this.d) {
            f fVar3 = (f) map.get(fVar2);
            ArrayList<d> arrayList2 = fVar2.b;
            if (arrayList2 != null) {
                for (d dVar : arrayList2) {
                    fVar3.a(new d((f) map.get(dVar.f23089a), dVar.b));
                }
            }
        }
        return nVar;
    }

    public ArrayList<j> m() {
        ArrayList<j> arrayList = new ArrayList<>();
        Iterator<f> it = this.d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f23091a);
        }
        return arrayList;
    }

    public final void n() {
        if (!this.f) {
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.d.get(i);
                ArrayList<d> arrayList = fVar.b;
                if (arrayList != null && arrayList.size() > 0) {
                    int size2 = fVar.b.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        d dVar = fVar.b.get(i2);
                        if (fVar.d == null) {
                            fVar.d = new ArrayList<>();
                        }
                        if (!fVar.d.contains(dVar.f23089a)) {
                            fVar.d.add(dVar.f23089a);
                        }
                    }
                }
                fVar.f = false;
            }
            return;
        }
        this.e.clear();
        ArrayList arrayList2 = new ArrayList();
        int size3 = this.d.size();
        for (int i3 = 0; i3 < size3; i3++) {
            f fVar2 = this.d.get(i3);
            ArrayList<d> arrayList3 = fVar2.b;
            if (arrayList3 == null || arrayList3.size() == 0) {
                arrayList2.add(fVar2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        while (arrayList2.size() > 0) {
            int size4 = arrayList2.size();
            for (int i4 = 0; i4 < size4; i4++) {
                f fVar3 = (f) arrayList2.get(i4);
                this.e.add(fVar3);
                ArrayList<f> arrayList5 = fVar3.e;
                if (arrayList5 != null) {
                    int size5 = arrayList5.size();
                    for (int i5 = 0; i5 < size5; i5++) {
                        f fVar4 = fVar3.e.get(i5);
                        fVar4.d.remove(fVar3);
                        if (fVar4.d.size() == 0) {
                            arrayList4.add(fVar4);
                        }
                    }
                }
            }
            arrayList2.clear();
            arrayList2.addAll(arrayList4);
            arrayList4.clear();
        }
        this.f = false;
        if (this.e.size() != this.d.size()) {
            throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
        }
    }

    public void b(j... jVarArr) {
        if (jVarArr != null) {
            this.f = true;
            c cVarA = a(jVarArr[0]);
            for (int i = 1; i < jVarArr.length; i++) {
                cVarA.c(jVarArr[i]);
            }
        }
    }

    @Override // com.acse.ottn.j
    public long c() {
        return this.l;
    }

    @Override // com.acse.ottn.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n a(long j) {
        if (j >= 0) {
            Iterator<f> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().f23091a.a(j);
            }
            this.l = j;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    public void a(Collection<j> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.f = true;
        c cVarA = null;
        for (j jVar : collection) {
            if (cVarA == null) {
                cVarA = a(jVar);
            } else {
                cVarA.c(jVar);
            }
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f23088a;

        public c(j jVar) {
            f fVar = (f) n.this.c.get(jVar);
            this.f23088a = fVar;
            if (fVar == null) {
                this.f23088a = new f(jVar);
                n.this.c.put(jVar, this.f23088a);
                n.this.d.add(this.f23088a);
            }
        }

        public c a(j jVar) {
            f fVar = (f) n.this.c.get(jVar);
            if (fVar == null) {
                fVar = new f(jVar);
                n.this.c.put(jVar, fVar);
                n.this.d.add(fVar);
            }
            this.f23088a.a(new d(fVar, 1));
            return this;
        }

        public c b(j jVar) {
            f fVar = (f) n.this.c.get(jVar);
            if (fVar == null) {
                fVar = new f(jVar);
                n.this.c.put(jVar, fVar);
                n.this.d.add(fVar);
            }
            fVar.a(new d(this.f23088a, 1));
            return this;
        }

        public c c(j jVar) {
            f fVar = (f) n.this.c.get(jVar);
            if (fVar == null) {
                fVar = new f(jVar);
                n.this.c.put(jVar, fVar);
                n.this.d.add(fVar);
            }
            fVar.a(new d(this.f23088a, 0));
            return this;
        }

        public c a(long j) {
            t4 t4VarA = t4.a(0.0f, 1.0f);
            t4VarA.a(j);
            a(t4VarA);
            return this;
        }
    }

    @Override // com.acse.ottn.j
    public void b() {
        this.h = true;
        if (g()) {
            if (this.e.size() != this.d.size()) {
                n();
                for (f fVar : this.e) {
                    if (this.g == null) {
                        this.g = new b(this);
                    }
                    fVar.f23091a.a((j.a) this.g);
                }
            }
            t4 t4Var = this.k;
            if (t4Var != null) {
                t4Var.cancel();
            }
            if (this.e.size() > 0) {
                Iterator<f> it = this.e.iterator();
                while (it.hasNext()) {
                    it.next().f23091a.b();
                }
            }
            ArrayList<j.a> arrayList = this.f23063a;
            if (arrayList != null) {
                Iterator it2 = ((ArrayList) arrayList.clone()).iterator();
                while (it2.hasNext()) {
                    ((j.a) it2.next()).b(this);
                }
            }
            this.i = false;
        }
    }

    public static class f implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f23091a;
        public ArrayList<d> b = null;
        public ArrayList<d> c = null;
        public ArrayList<f> d = null;
        public ArrayList<f> e = null;
        public boolean f = false;

        public f(j jVar) {
            this.f23091a = jVar;
        }

        public void a(d dVar) {
            if (this.b == null) {
                this.b = new ArrayList<>();
                this.d = new ArrayList<>();
            }
            this.b.add(dVar);
            if (!this.d.contains(dVar.f23089a)) {
                this.d.add(dVar.f23089a);
            }
            f fVar = dVar.f23089a;
            if (fVar.e == null) {
                fVar.e = new ArrayList<>();
            }
            fVar.e.add(this);
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f clone() {
            try {
                f fVar = (f) super.clone();
                fVar.f23091a = this.f23091a.clone();
                return fVar;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    public void a(j... jVarArr) {
        if (jVarArr != null) {
            this.f = true;
            int i = 0;
            if (jVarArr.length == 1) {
                a(jVarArr[0]);
                return;
            }
            while (i < jVarArr.length - 1) {
                c cVarA = a(jVarArr[i]);
                i++;
                cVarA.b(jVarArr[i]);
            }
        }
    }

    public void a(List<j> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f = true;
        int i = 0;
        if (list.size() == 1) {
            a(list.get(0));
            return;
        }
        while (i < list.size() - 1) {
            c cVarA = a(list.get(i));
            i++;
            cVarA.b(list.get(i));
        }
    }

    @Override // com.acse.ottn.j
    public void a(Object obj) {
        Iterator<f> it = this.d.iterator();
        while (it.hasNext()) {
            j jVar = it.next().f23091a;
            if (jVar instanceof n) {
                ((n) jVar).a(obj);
            } else if (jVar instanceof z2) {
                ((z2) jVar).a(obj);
            }
        }
    }

    @Override // com.acse.ottn.j
    public void b(long j) {
        this.j = j;
    }

    @Override // com.acse.ottn.j
    public void a(Interpolator interpolator) {
        Iterator<f> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().f23091a.a(interpolator);
        }
    }

    public c a(j jVar) {
        if (jVar == null) {
            return null;
        }
        this.f = true;
        return new c(jVar);
    }
}
