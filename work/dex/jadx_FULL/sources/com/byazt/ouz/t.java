package com.byazt.ouz;

import com.byazt.ete.ic;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 66})
public class t implements sl {
    public WeakReference<sl> c;
    public Queue<Runnable> tt = new LinkedList();

    @Override // com.byazt.ouz.sl
    public void a() {
        WeakReference<sl> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.11
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).a();
                }
            });
        } else {
            this.c.get().a();
        }
    }

    @Override // com.byazt.ouz.sl
    public void da() {
        WeakReference<sl> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.16
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).da();
                }
            });
        } else {
            this.c.get().da();
        }
    }

    @Override // com.byazt.ouz.sl
    public void i() {
        WeakReference<sl> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.15
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).i();
                }
            });
        } else {
            this.c.get().i();
        }
    }

    @Override // com.byazt.ouz.sl
    public void n(final int i) {
        WeakReference<sl> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.17
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).n(i);
                }
            });
        } else {
            this.c.get().n(i);
        }
    }

    @Override // com.byazt.ouz.sl
    public void setPauseFromExpressView(final boolean z) {
        WeakReference<sl> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.6
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).setPauseFromExpressView(z);
                }
            });
        } else {
            this.c.get().setPauseFromExpressView(z);
        }
    }

    public sl sl() {
        WeakReference<sl> weakReference = this.c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.byazt.ouz.sl
    public void sp() {
        WeakReference<sl> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.12
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).sp();
                }
            });
        } else {
            this.c.get().sp();
        }
    }

    @Override // com.byazt.ouz.sl
    public int tt() {
        WeakReference<sl> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.c.get().tt();
    }

    @Override // com.byazt.ouz.sl
    public void uj() {
        WeakReference<sl> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.2
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).uj();
                }
            });
        } else {
            this.c.get().uj();
        }
    }

    @Override // com.byazt.ouz.sl
    public int ve() {
        WeakReference<sl> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.c.get().ve();
    }

    @Override // com.byazt.ouz.sl
    public void x() {
        WeakReference<sl> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.14
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).x();
                }
            });
        } else {
            this.c.get().x();
        }
    }

    public void c(sl slVar) {
        this.c = new WeakReference<>(slVar);
        while (!this.tt.isEmpty()) {
            try {
                Runnable runnablePoll = this.tt.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.byazt.ouz.sl
    public void tt(final int i) {
        WeakReference<sl> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            this.c.get().tt(i);
        } else {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.3
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).tt(i);
                }
            });
        }
    }

    @Override // com.byazt.ouz.sl
    public void ve(final int i) {
        WeakReference<sl> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            this.c.get().ve(i);
        } else {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.8
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).ve(i);
                }
            });
        }
    }

    @Override // com.byazt.ouz.sl
    public void n() {
        WeakReference<sl> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            this.c.get().n();
        } else {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.4
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).n();
                }
            });
        }
    }

    @Override // com.byazt.ouz.sl
    public void uj(final int i) {
        WeakReference<sl> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            this.c.get().uj(i);
        } else {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.9
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).uj(i);
                }
            });
        }
    }

    @Override // com.byazt.ouz.sl
    public void c(final boolean z) {
        WeakReference<sl> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            this.c.get().c(z);
        } else {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.1
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).c(z);
                }
            });
        }
    }

    @Override // com.byazt.ouz.sl
    public void c(final int i) {
        WeakReference<sl> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            this.c.get().c(i);
        } else {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.13
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).c(i);
                }
            });
        }
    }

    @Override // com.byazt.ouz.sl
    public long c() {
        WeakReference<sl> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.c.get().c();
    }

    @Override // com.byazt.ouz.sl
    public void c(final float f, final float f2, final float f3, final float f4, final int i) {
        WeakReference<sl> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            this.c.get().c(f, f2, f3, f4, i);
        } else {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.18
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).c(f, f2, f3, f4, i);
                }
            });
        }
    }

    @Override // com.byazt.ouz.sl
    public void c(final int i, final String str) {
        WeakReference<sl> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            this.c.get().c(i, str);
        } else {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.5
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).c(i, str);
                }
            });
        }
    }

    @Override // com.byazt.ouz.sl
    public void c(final float f) {
        WeakReference<sl> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            this.c.get().c(f);
        } else {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.7
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).c(f);
                }
            });
        }
    }

    @Override // com.byazt.ouz.sl
    public void c(final ic icVar) {
        WeakReference<sl> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            this.c.get().c(icVar);
        } else {
            this.tt.add(new Runnable() { // from class: com.byazt.ouz.t.10
                @Override // java.lang.Runnable
                public void run() {
                    if (t.this.c == null || t.this.c.get() == null) {
                        return;
                    }
                    ((sl) t.this.c.get()).c(icVar);
                }
            });
        }
    }
}
