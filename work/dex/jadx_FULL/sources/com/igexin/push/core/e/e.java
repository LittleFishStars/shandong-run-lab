package com.igexin.push.core.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.core.b.n;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e implements a {
    private static final String b = "RALDataManager";
    private static final int c = 318;
    private static final int d = 300;
    private static volatile e e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n> f38007a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: com.igexin.push.core.e.e$3, reason: invalid class name */
    public class AnonymousClass3 extends com.igexin.push.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f38010a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ContentValues contentValues, long j) {
            super(contentValues);
            this.f38010a = j;
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            this.d.update(com.igexin.push.core.b.ab, this.h, "id=?", new String[]{String.valueOf(this.f38010a)});
        }
    }

    private e() {
    }

    private int a(byte b2) {
        Iterator<n> it = this.f38007a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().c == b2) {
                i++;
            }
        }
        return i;
    }

    public static ContentValues a(n nVar) {
        if (nVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(nVar.f37966a));
        contentValues.put("data", com.igexin.c.b.a.b(nVar.b.getBytes()));
        contentValues.put("type", Byte.valueOf(nVar.c));
        contentValues.put("time", Long.valueOf(nVar.d));
        contentValues.put("send_times", Integer.valueOf(nVar.e));
        return contentValues;
    }

    public static e a() {
        if (e == null) {
            synchronized (e.class) {
                if (e == null) {
                    e = new e();
                }
            }
        }
        return e;
    }

    private boolean a(long j, long j2) {
        n nVarA = a(j);
        if (nVarA == null) {
            return false;
        }
        nVarA.d = j2;
        nVarA.e++;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass3(a(nVarA), j), true, true);
        return true;
    }

    private List<n> b() {
        return this.f38007a;
    }

    private void b(byte b2) {
        n next;
        try {
            Iterator<n> it = this.f38007a.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (next.c != b2);
            if (next != null) {
                a(next.f37966a, true);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final n a(long j) {
        for (n nVar : this.f38007a) {
            if (nVar.f37966a == j) {
                return nVar;
            }
        }
        return null;
    }

    public final void a(final long j, boolean z) {
        n nVarA = a(j);
        if (nVarA != null) {
            this.f38007a.remove(nVarA);
        }
        com.igexin.c.a.b.e.a().a(new com.igexin.push.b.d(a(nVarA)) { // from class: com.igexin.push.core.e.e.2
            @Override // com.igexin.push.b.d
            public final void a_() throws Exception {
                this.d.delete(com.igexin.push.core.b.ab, "id=?", new String[]{String.valueOf(j)});
            }
        }, z, !z);
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query(com.igexin.push.core.b.ab, new String[]{"id", "data", "type", "time", "send_times"}, null, null, null, null, null);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(0);
                        byte b2 = (byte) cursorQuery.getInt(2);
                        long j2 = cursorQuery.getLong(3);
                        int i = cursorQuery.getInt(4);
                        if ((j2 == 0 || jCurrentTimeMillis - j2 <= 259200000) && i < com.igexin.push.config.d.N - 1) {
                            List<n> list = this.f38007a;
                            n nVar = new n(j, new String(com.igexin.c.b.a.c(cursorQuery.getBlob(1))), b2, j2);
                            nVar.e = i;
                            list.add(nVar);
                        } else {
                            a(j, true);
                        }
                    }
                }
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0047  */
    public final void b(final n nVar) {
        byte b2;
        if (this.f38007a.size() < 318 || (b2 = nVar.c) == 2 || b2 == 7) {
            byte b3 = nVar.c;
            if (b3 == 2) {
                b(b3);
            } else if (b3 != 3) {
                if (b3 != 5) {
                    if (b3 != 6) {
                        if (b3 == 7) {
                            b(b3);
                        } else if (b3 == 8 && a((byte) 8) >= 3) {
                            return;
                        }
                    } else if (a((byte) 6) >= 10) {
                        return;
                    }
                } else if (a((byte) 5) >= 3) {
                    return;
                }
            } else if (a((byte) 3) >= 300) {
                return;
            }
            this.f38007a.add(nVar);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d(a(nVar)) { // from class: com.igexin.push.core.e.e.1
                @Override // com.igexin.push.b.d
                public final void a_() throws Exception {
                    this.d.replace(com.igexin.push.core.b.ab, null, this.h);
                }
            }, false, true);
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
    }
}
