package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LineBuffer f32193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public final Reader f6352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Readable f6353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharBuffer f6354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Queue<String> f6355a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final char[] f6356a;

    public class a extends LineBuffer {
        public a() {
        }

        @Override // com.google.common.io.LineBuffer
        public void handleLine(String str, String str2) {
            k.this.f6355a.add(str);
        }
    }

    public k(Readable readable) {
        CharBuffer charBufferE = d.e();
        this.f6354a = charBufferE;
        this.f6356a = charBufferE.array();
        this.f6355a = new ArrayDeque();
        this.f32193a = new a();
        this.f6353a = (Readable) com.google.common.base.i.E(readable);
        this.f6352a = readable instanceof Reader ? (Reader) readable : null;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public String b() throws IOException {
        int i;
        while (this.f6355a.peek() == null) {
            j.a(this.f6354a);
            Reader reader = this.f6352a;
            if (reader != null) {
                char[] cArr = this.f6356a;
                i = reader.read(cArr, 0, cArr.length);
            } else {
                i = this.f6353a.read(this.f6354a);
            }
            if (i == -1) {
                this.f32193a.finish();
                break;
            }
            this.f32193a.add(this.f6356a, 0, i);
        }
        return this.f6355a.poll();
    }
}
