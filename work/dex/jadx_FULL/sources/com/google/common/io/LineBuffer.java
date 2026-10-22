package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.zj.adlib.b85;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
abstract class LineBuffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StringBuilder f32177a = new StringBuilder();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6344a;

    @CanIgnoreReturnValue
    public final boolean a(boolean z) throws IOException {
        String str;
        if (this.f6344a) {
            str = z ? "\r\n" : b85.b;
        } else {
            str = z ? "\n" : "";
        }
        handleLine(this.f32177a.toString(), str);
        this.f32177a = new StringBuilder();
        this.f6344a = false;
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    public void add(char[] cArr, int i, int i2) throws IOException {
        int i3;
        if (!this.f6344a || i2 <= 0) {
            i3 = i;
        } else {
            if (a(cArr[i] == '\n')) {
                i3 = i + 1;
            } else {
                i3 = i;
            }
        }
        int i4 = i + i2;
        int i5 = i3;
        while (i3 < i4) {
            char c = cArr[i3];
            if (c != '\n') {
                if (c == '\r') {
                    this.f32177a.append(cArr, i5, i3 - i5);
                    this.f6344a = true;
                    int i6 = i3 + 1;
                    if (i6 < i4) {
                        if (a(cArr[i6] == '\n')) {
                            i3 = i6;
                        }
                    }
                }
                i3++;
            } else {
                this.f32177a.append(cArr, i5, i3 - i5);
                a(true);
            }
            i5 = i3 + 1;
            i3++;
        }
        this.f32177a.append(cArr, i5, i4 - i5);
    }

    public void finish() throws IOException {
        if (this.f6344a || this.f32177a.length() > 0) {
            a(false);
        }
    }

    public abstract void handleLine(String str, String str2) throws IOException;
}
