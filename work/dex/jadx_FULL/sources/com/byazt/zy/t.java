package com.byazt.zy;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 66})
@TargetApi(19)
public class t implements da, u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.jx.i f29262a;
    public final String uj;
    public final Path c = new Path();
    public final Path tt = new Path();
    public final Path ve = new Path();
    public final List<u> n = new ArrayList();

    /* JADX INFO: renamed from: com.byazt.zy.t$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 167})
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.jx.i.c.values().length];
            c = iArr;
            try {
                iArr[com.byazt.jx.i.c.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.jx.i.c.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[com.byazt.jx.i.c.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[com.byazt.jx.i.c.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[com.byazt.jx.i.c.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public t(com.byazt.jx.i iVar) {
        this.uj = iVar.c();
        this.f29262a = iVar;
    }

    @Override // com.byazt.zy.da
    public void c(ListIterator<ve> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            ve veVarPrevious = listIterator.previous();
            if (veVarPrevious instanceof u) {
                this.n.add((u) veVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.byazt.zy.u
    public Path uj() {
        this.ve.reset();
        if (this.f29262a.ve()) {
            return this.ve;
        }
        int i = AnonymousClass1.c[this.f29262a.tt().ordinal()];
        if (i == 1) {
            c();
        } else if (i == 2) {
            c(Path.Op.UNION);
        } else if (i == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            c(Path.Op.INTERSECT);
        } else if (i == 5) {
            c(Path.Op.XOR);
        }
        return this.ve;
    }

    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
        for (int i = 0; i < this.n.size(); i++) {
            this.n.get(i).c(list, list2);
        }
    }

    private void c() {
        for (int i = 0; i < this.n.size(); i++) {
            this.ve.addPath(this.n.get(i).uj());
        }
    }

    @TargetApi(19)
    private void c(Path.Op op) {
        this.tt.reset();
        this.c.reset();
        for (int size = this.n.size() - 1; size > 0; size--) {
            u uVar = this.n.get(size);
            if (uVar instanceof uj) {
                uj ujVar = (uj) uVar;
                List<u> listTt = ujVar.tt();
                for (int size2 = listTt.size() - 1; size2 >= 0; size2--) {
                    Path pathUj = listTt.get(size2).uj();
                    pathUj.transform(ujVar.ve());
                    this.tt.addPath(pathUj);
                }
            } else {
                this.tt.addPath(uVar.uj());
            }
        }
        u uVar2 = this.n.get(0);
        if (uVar2 instanceof uj) {
            uj ujVar2 = (uj) uVar2;
            List<u> listTt2 = ujVar2.tt();
            for (int i = 0; i < listTt2.size(); i++) {
                Path pathUj2 = listTt2.get(i).uj();
                pathUj2.transform(ujVar2.ve());
                this.c.addPath(pathUj2);
            }
        } else {
            this.c.set(uVar2.uj());
        }
        this.ve.op(this.c, this.tt, op);
    }
}
