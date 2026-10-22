package cj.mobile.wm;

import com.zj.adlib.dv9;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class mc implements XmlSerializer {
    public static final String[] dexh = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};
    public int dexb;
    public Writer dexc;
    public OutputStream dexd;
    public CharsetEncoder dexe;
    public boolean dexg;
    public final char[] dexa = new char[8192];
    public ByteBuffer dexf = ByteBuffer.allocate(8192);

    private void dexa() throws IOException {
        int iPosition = this.dexf.position();
        if (iPosition > 0) {
            this.dexf.flip();
            this.dexd.write(this.dexf.array(), 0, iPosition);
            this.dexf.clear();
        }
    }

    private void dexa(char c) throws IOException {
        int i = this.dexb;
        if (i >= 8191) {
            flush();
            i = this.dexb;
        }
        this.dexa[i] = c;
        this.dexb = i + 1;
    }

    private void dexa(String str) throws IOException {
        dexa(str, 0, str.length());
    }

    private void dexa(String str, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                dexa(str, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.dexb;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.dexb;
        }
        str.getChars(i, i + i2, this.dexa, i5);
        this.dexb = i5 + i2;
    }

    private void dexa(char[] cArr, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                dexa(cArr, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.dexb;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.dexb;
        }
        System.arraycopy(cArr, i, this.dexa, i5, i2);
        this.dexb = i5 + i2;
    }

    private void dexb(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = dexh;
        char length2 = (char) strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt < length2 && (str2 = strArr[cCharAt]) != null) {
                if (i2 < i) {
                    dexa(str, i2, i - i2);
                }
                i2 = i + 1;
                dexa(str2);
            }
            i++;
        }
        if (i2 < i) {
            dexa(str, i2, i - i2);
        }
    }

    private void dexb(char[] cArr, int i, int i2) throws IOException {
        String str;
        String[] strArr = dexh;
        char length = (char) strArr.length;
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c < length && (str = strArr[c]) != null) {
                if (i4 < i) {
                    dexa(cArr, i4, i - i4);
                }
                i4 = i + 1;
                dexa(str);
            }
            i++;
        }
        if (i4 < i) {
            dexa(cArr, i4, i - i4);
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        dexa(' ');
        if (str != null) {
            dexa(str);
            dexa(com.google.common.net.c.b);
        }
        dexa(str2);
        dexa("=\"");
        dexb(str3);
        dexa('\"');
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException {
        flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException {
        String str3;
        if (this.dexg) {
            str3 = " />\n";
        } else {
            dexa("</");
            if (str != null) {
                dexa(str);
                dexa(com.google.common.net.c.b);
            }
            dexa(str2);
            str3 = ">\n";
        }
        dexa(str3);
        this.dexg = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        int i = this.dexb;
        if (i > 0) {
            if (this.dexd != null) {
                CharBuffer charBufferWrap = CharBuffer.wrap(this.dexa, 0, i);
                CharsetEncoder charsetEncoder = this.dexe;
                ByteBuffer byteBuffer = this.dexf;
                while (true) {
                    CoderResult coderResultEncode = charsetEncoder.encode(charBufferWrap, byteBuffer, true);
                    if (coderResultEncode.isError()) {
                        throw new IOException(coderResultEncode.toString());
                    }
                    boolean zIsOverflow = coderResultEncode.isOverflow();
                    dexa();
                    if (zIsOverflow) {
                        charsetEncoder = this.dexe;
                        byteBuffer = this.dexf;
                    } else {
                        this.dexd.flush();
                    }
                }
            } else {
                this.dexc.write(this.dexa, 0, i);
                this.dexc.flush();
            }
            this.dexb = 0;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z) {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.dexe = Charset.forName(str).newEncoder();
            this.dexd = outputStream;
        } catch (IllegalCharsetNameException e) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
        } catch (UnsupportedCharsetException e2) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) {
        this.dexc = writer;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='utf-8' standalone='");
        sb.append(bool.booleanValue() ? "yes" : "no");
        sb.append("' ?>\n");
        dexa(sb.toString());
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException {
        if (this.dexg) {
            dexa(">\n");
        }
        dexa(dv9.f41283a);
        if (str != null) {
            dexa(str);
            dexa(com.google.common.net.c.b);
        }
        dexa(str2);
        this.dexg = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException {
        if (this.dexg) {
            dexa(">");
            this.dexg = false;
        }
        dexb(str);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException {
        if (this.dexg) {
            dexa(">");
            this.dexg = false;
        }
        dexb(cArr, i, i2);
        return this;
    }
}
