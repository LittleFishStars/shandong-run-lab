package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.MathContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class JSONReaderScanner extends JSONLexerBase {
    private static final ThreadLocal<char[]> BUF_LOCAL = new ThreadLocal<>();
    private char[] buf;
    private int bufLength;
    private Reader reader;

    public JSONReaderScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.buf, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        System.arraycopy(this.buf, i, cArr, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token != 26) {
            return IOUtils.decodeBase64(this.buf, this.np + 1, this.sp);
        }
        throw new JSONException("TODO");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        for (int i = 0; i < cArr.length; i++) {
            if (charAt(this.bp + i) != cArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        int i2 = this.bufLength;
        if (i >= i2) {
            if (i2 == -1) {
                if (i < this.sp) {
                    return this.buf[i];
                }
                return (char) 26;
            }
            int i3 = this.bp;
            if (i3 == 0) {
                char[] cArr = this.buf;
                int length = (cArr.length * 3) / 2;
                char[] cArr2 = new char[length];
                System.arraycopy(cArr, i3, cArr2, 0, i2);
                int i4 = this.bufLength;
                try {
                    this.bufLength += this.reader.read(cArr2, i4, length - i4);
                    this.buf = cArr2;
                } catch (IOException e) {
                    throw new JSONException(e.getMessage(), e);
                }
            } else {
                int i5 = i2 - i3;
                if (i5 > 0) {
                    char[] cArr3 = this.buf;
                    System.arraycopy(cArr3, i3, cArr3, 0, i5);
                }
                try {
                    Reader reader = this.reader;
                    char[] cArr4 = this.buf;
                    int i6 = reader.read(cArr4, i5, cArr4.length - i5);
                    this.bufLength = i6;
                    if (i6 == 0) {
                        throw new JSONException("illegal state, textLength is zero");
                    }
                    if (i6 == -1) {
                        return (char) 26;
                    }
                    this.bufLength = i6 + i5;
                    int i7 = this.bp;
                    i -= i7;
                    this.np -= i7;
                    this.bp = 0;
                } catch (IOException e2) {
                    throw new JSONException(e2.getMessage(), e2);
                }
            }
        }
        return this.buf[i];
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        char[] cArr = this.buf;
        if (cArr.length <= 65536) {
            BUF_LOCAL.set(cArr);
        }
        this.buf = null;
        IOUtils.close(this.reader);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int i, int i2, char[] cArr) {
        System.arraycopy(this.buf, i, cArr, 0, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        int i = this.np;
        if (i == -1) {
            i = 0;
        }
        char cCharAt = charAt((this.sp + i) - 1);
        int i2 = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i2--;
        }
        if (i2 <= 65535) {
            return new BigDecimal(this.buf, i, i2, MathContext.UNLIMITED);
        }
        throw new JSONException("decimal overflow");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        int i2 = i - this.bp;
        while (true) {
            char cCharAt = charAt(this.bp + i2);
            if (c == cCharAt) {
                return i2 + this.bp;
            }
            if (cCharAt == 26) {
                return -1;
            }
            i2++;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            char c = this.buf[i];
            if (c == 26) {
                this.token = 20;
                return true;
            }
            if (!JSONLexerBase.isWhitespace(c)) {
                return false;
            }
            i++;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        if (this.bufLength == -1) {
            return true;
        }
        int i = this.bp;
        char[] cArr = this.buf;
        if (i != cArr.length) {
            return this.ch == 26 && i + 1 >= cArr.length;
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.bp + 1;
        this.bp = i;
        int i2 = this.bufLength;
        if (i >= i2) {
            if (i2 == -1) {
                return (char) 26;
            }
            int i3 = this.sp;
            if (i3 > 0) {
                int i4 = i2 - i3;
                if (this.ch == '\"' && i4 > 0) {
                    i4--;
                }
                char[] cArr = this.buf;
                System.arraycopy(cArr, i4, cArr, 0, i3);
            }
            this.np = -1;
            int i5 = this.sp;
            this.bp = i5;
            try {
                char[] cArr2 = this.buf;
                int length = cArr2.length - i5;
                if (length == 0) {
                    char[] cArr3 = new char[cArr2.length * 2];
                    System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
                    this.buf = cArr3;
                    length = cArr3.length - i5;
                }
                int i6 = this.reader.read(this.buf, this.bp, length);
                this.bufLength = i6;
                if (i6 == 0) {
                    throw new JSONException("illegal stat, textLength is zero");
                }
                if (i6 == -1) {
                    this.ch = (char) 26;
                    return (char) 26;
                }
                this.bufLength = i6 + this.bp;
                i = i5;
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
        char c = this.buf[i];
        this.ch = c;
        return c;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        int i = this.np;
        if (i == -1) {
            i = 0;
        }
        char cCharAt = charAt((this.sp + i) - 1);
        int i2 = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i2--;
        }
        return new String(this.buf, i, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (this.hasSpecial) {
            return new String(this.sbuf, 0, this.sp);
        }
        int i = this.np + 1;
        if (i < 0) {
            throw new IllegalStateException();
        }
        char[] cArr = this.buf;
        int length = cArr.length;
        int i2 = this.sp;
        if (i <= length - i2) {
            return new String(cArr, i, i2);
        }
        throw new IllegalStateException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (i2 >= 0) {
            return new String(this.buf, i, i2);
        }
        throw new StringIndexOutOfBoundsException(i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i, int i2) {
        if (i2 < 0) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        if (i == 0) {
            return this.buf;
        }
        char[] cArr = new char[i2];
        System.arraycopy(this.buf, i, cArr, 0, i2);
        return cArr;
    }

    public JSONReaderScanner(String str, int i) {
        this(new StringReader(str), i);
    }

    public JSONReaderScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader) {
        this(reader, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader, int i) {
        super(i);
        this.reader = reader;
        ThreadLocal<char[]> threadLocal = BUF_LOCAL;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[16384];
        }
        try {
            this.bufLength = reader.read(this.buf);
            this.bp = -1;
            next();
            if (this.ch == 65279) {
                next();
            }
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public JSONReaderScanner(char[] cArr, int i, int i2) {
        this(new CharArrayReader(cArr, 0, i), i2);
    }
}
