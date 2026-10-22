package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class q extends Exception {
    public static final long l = 1;
    public static final StackTraceElement[] m = new StackTraceElement[0];
    public final List<Throwable> f;
    public com.ipd.dsp.internal.f.f g;
    public com.ipd.dsp.internal.f.a h;
    public Class<?> i;
    public String j;

    @Nullable
    public Exception k;

    public q(String str) {
        this(str, (List<Throwable>) Collections.EMPTY_LIST);
    }

    public void a(com.ipd.dsp.internal.f.f fVar, com.ipd.dsp.internal.f.a aVar) {
        a(fVar, aVar, null);
    }

    @Nullable
    public Exception b() {
        return this.k;
    }

    public List<Throwable> c() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.j);
        sb.append(this.i != null ? ", " + this.i : "");
        sb.append(this.h != null ? ", " + this.h : "");
        sb.append(this.g != null ? ", " + this.g : "");
        List<Throwable> listC = c();
        if (listC.isEmpty()) {
            return sb.toString();
        }
        if (listC.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(listC.size());
            sb.append(" root causes:");
        }
        for (Throwable th : listC) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public q(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    public static void b(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof q) {
                ((q) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i = i2;
        }
    }

    public void a(com.ipd.dsp.internal.f.f fVar, com.ipd.dsp.internal.f.a aVar, Class<?> cls) {
        this.g = fVar;
        this.h = aVar;
        this.i = cls;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(printStream);
    }

    public q(String str, List<Throwable> list) {
        this.j = str;
        setStackTrace(m);
        this.f = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(printWriter);
    }

    public static final class a implements Appendable {
        public static final String h = "";
        public static final String i = "  ";
        public final Appendable f;
        public boolean g = true;

        public a(Appendable appendable) {
            this.f = appendable;
        }

        @NonNull
        public final CharSequence a(@Nullable CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            if (this.g) {
                this.g = false;
                this.f.append(i);
            }
            this.g = c == '\n';
            this.f.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            return append(charSequenceA, 0, charSequenceA.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence, int i2, int i3) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            boolean z = false;
            if (this.g) {
                this.g = false;
                this.f.append(i);
            }
            if (charSequenceA.length() > 0 && charSequenceA.charAt(i3 - 1) == '\n') {
                z = true;
            }
            this.g = z;
            this.f.append(charSequenceA, i2, i3);
            return this;
        }
    }

    public void a(@Nullable Exception exc) {
        this.k = exc;
    }

    public List<Throwable> a() {
        return this.f;
    }

    public void a(String str) {
        List<Throwable> listC = c();
        int size = listC.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            com.ipd.dsp.internal.c2.k.c(str, sb.toString(), listC.get(i));
            i = i2;
        }
    }

    public final void a(Throwable th, List<Throwable> list) {
        if (th instanceof q) {
            Iterator<Throwable> it = ((q) th).a().iterator();
            while (it.hasNext()) {
                a(it.next(), list);
            }
            return;
        }
        list.add(th);
    }

    public final void a(Appendable appendable) {
        a(this, appendable);
        a(a(), new a(appendable));
    }

    public static void a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public static void a(List<Throwable> list, Appendable appendable) {
        try {
            b(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
