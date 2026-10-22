package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class LineWrapper {
    private boolean closed;
    private final int columnLimit;
    private final String indent;
    private final Appendable out;
    private final StringBuilder buffer = new StringBuilder();
    private int column = 0;
    private int indentLevel = -1;

    public LineWrapper(Appendable appendable, String str, int i) {
        Util.checkNotNull(appendable, "out == null", new Object[0]);
        this.out = appendable;
        this.indent = str;
        this.columnLimit = i;
    }

    private void flush(boolean z) throws IOException {
        int i;
        if (z) {
            this.out.append('\n');
            int i2 = 0;
            while (true) {
                i = this.indentLevel;
                if (i2 >= i) {
                    break;
                }
                this.out.append(this.indent);
                i2++;
            }
            int length = i * this.indent.length();
            this.column = length;
            this.column = length + this.buffer.length();
        } else {
            this.out.append(' ');
        }
        this.out.append(this.buffer);
        StringBuilder sb = this.buffer;
        sb.delete(0, sb.length());
        this.indentLevel = -1;
    }

    public void append(String str) throws IOException {
        int length;
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.indentLevel != -1) {
            int iIndexOf = str.indexOf(10);
            if (iIndexOf == -1 && this.column + str.length() <= this.columnLimit) {
                this.buffer.append(str);
                this.column += str.length();
                return;
            }
            flush(iIndexOf == -1 || this.column + iIndexOf > this.columnLimit);
        }
        this.out.append(str);
        int iLastIndexOf = str.lastIndexOf(10);
        if (iLastIndexOf != -1) {
            length = (str.length() - iLastIndexOf) - 1;
        } else {
            length = str.length() + this.column;
        }
        this.column = length;
    }

    public void wrappingSpace(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.indentLevel != -1) {
            flush(false);
        }
        this.column++;
        this.indentLevel = i;
    }
}
