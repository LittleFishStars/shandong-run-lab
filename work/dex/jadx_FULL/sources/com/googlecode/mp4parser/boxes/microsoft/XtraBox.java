package com.googlecode.mp4parser.boxes.microsoft;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.alipay.sdk.m.y.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.ipd.dsp.internal.i.q;
import com.zj.adlib.nv1;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Vector;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.runtime.reflect.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class XtraBox extends AbstractBox {
    private static final long FILETIME_EPOCH_DIFF = 11644473600000L;
    private static final long FILETIME_ONE_MILLISECOND = 10000;
    public static final int MP4_XTRA_BT_FILETIME = 21;
    public static final int MP4_XTRA_BT_GUID = 72;
    public static final int MP4_XTRA_BT_INT64 = 19;
    public static final int MP4_XTRA_BT_UNICODE = 8;
    public static final String TYPE = "Xtra";
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_10 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    ByteBuffer data;
    private boolean successfulParse;
    Vector<XtraTag> tags;

    public static class XtraValue {
        public Date fileTimeValue;
        public long longValue;
        public byte[] nonParsedValue;
        public String stringValue;
        public int type;

        private XtraValue() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getContent(ByteBuffer byteBuffer) {
            try {
                byteBuffer.putInt(getContentSize());
                byteBuffer.putShort((short) this.type);
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                int i = this.type;
                if (i == 8) {
                    XtraBox.writeUtf16String(byteBuffer, this.stringValue);
                } else if (i == 19) {
                    byteBuffer.putLong(this.longValue);
                } else if (i != 21) {
                    byteBuffer.put(this.nonParsedValue);
                } else {
                    byteBuffer.putLong(XtraBox.millisToFiletime(this.fileTimeValue.getTime()));
                }
            } finally {
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getContentSize() {
            int length;
            int i = this.type;
            if (i == 8) {
                length = (this.stringValue.length() * 2) + 2;
            } else {
                if (i == 19 || i == 21) {
                    return 14;
                }
                length = this.nonParsedValue.length;
            }
            return length + 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object getValueAsObject() {
            int i = this.type;
            if (i == 8) {
                return this.stringValue;
            }
            if (i != 19) {
                return i != 21 ? this.nonParsedValue : this.fileTimeValue;
            }
            return new Long(this.longValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void parse(ByteBuffer byteBuffer) {
            int i = byteBuffer.getInt() - 6;
            this.type = byteBuffer.getShort();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            int i2 = this.type;
            if (i2 == 8) {
                this.stringValue = XtraBox.readUtf16String(byteBuffer, i);
            } else if (i2 == 19) {
                this.longValue = byteBuffer.getLong();
            } else if (i2 != 21) {
                byte[] bArr = new byte[i];
                this.nonParsedValue = bArr;
                byteBuffer.get(bArr);
            } else {
                this.fileTimeValue = new Date(XtraBox.filetimeToMillis(byteBuffer.getLong()));
            }
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public String toString() {
            int i = this.type;
            if (i == 8) {
                return "[string]" + this.stringValue;
            }
            if (i == 19) {
                return "[long]" + String.valueOf(this.longValue);
            }
            if (i != 21) {
                return "[GUID](nonParsed)";
            }
            return "[filetime]" + this.fileTimeValue.toString();
        }

        public /* synthetic */ XtraValue(XtraValue xtraValue) {
            this();
        }

        private XtraValue(String str) {
            this.type = 8;
            this.stringValue = str;
        }

        public /* synthetic */ XtraValue(String str, XtraValue xtraValue) {
            this(str);
        }

        private XtraValue(long j) {
            this.type = 19;
            this.longValue = j;
        }

        public /* synthetic */ XtraValue(long j, XtraValue xtraValue) {
            this(j);
        }

        private XtraValue(Date date) {
            this.type = 21;
            this.fileTimeValue = date;
        }

        public /* synthetic */ XtraValue(Date date, XtraValue xtraValue) {
            this(date);
        }
    }

    static {
        ajc$preClinit();
    }

    public XtraBox() {
        super(TYPE);
        this.successfulParse = false;
        this.tags = new Vector<>();
    }

    private static /* synthetic */ void ajc$preClinit() {
        d dVar = new d("XtraBox.java", XtraBox.class);
        ajc$tjp_0 = dVar.H("method-execution", dVar.E("1", "toString", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "", "", "", "java.lang.String"), 88);
        ajc$tjp_1 = dVar.H("method-execution", dVar.E("1", "getAllTagNames", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "", "", "", "[Ljava.lang.String;"), 151);
        ajc$tjp_10 = dVar.H("method-execution", dVar.E("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:long", "name:value", "", "void"), MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE);
        ajc$tjp_2 = dVar.H("method-execution", dVar.E("1", "getFirstStringValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.lang.String"), 166);
        ajc$tjp_3 = dVar.H("method-execution", dVar.E("1", "getFirstDateValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.util.Date"), 183);
        ajc$tjp_4 = dVar.H("method-execution", dVar.E("1", "getFirstLongValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.lang.Long"), 200);
        ajc$tjp_5 = dVar.H("method-execution", dVar.E("1", "getValues", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "[Ljava.lang.Object;"), 216);
        ajc$tjp_6 = dVar.H("method-execution", dVar.E("1", "removeTag", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "void"), 236);
        ajc$tjp_7 = dVar.H("method-execution", dVar.E("1", "setTagValues", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:[Ljava.lang.String;", "name:values", "", "void"), 249);
        ajc$tjp_8 = dVar.H("method-execution", dVar.E("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.lang.String", "name:value", "", "void"), MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME);
        ajc$tjp_9 = dVar.H("method-execution", dVar.E("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.util.Date", "name:date", "", "void"), 276);
    }

    private int detailSize() {
        int contentSize = 0;
        for (int i = 0; i < this.tags.size(); i++) {
            contentSize += this.tags.elementAt(i).getContentSize();
        }
        return contentSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long filetimeToMillis(long j) {
        return (j / 10000) - FILETIME_EPOCH_DIFF;
    }

    private XtraTag getTagByName(String str) {
        for (XtraTag xtraTag : this.tags) {
            if (xtraTag.tagName.equals(str)) {
                return xtraTag;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long millisToFiletime(long j) {
        return (j + FILETIME_EPOCH_DIFF) * 10000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String readAsciiString(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Shouldn't happen", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String readUtf16String(ByteBuffer byteBuffer, int i) {
        int i2 = (i / 2) - 1;
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = byteBuffer.getChar();
        }
        byteBuffer.getChar();
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeAsciiString(ByteBuffer byteBuffer, String str) {
        try {
            byteBuffer.put(str.getBytes("US-ASCII"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Shouldn't happen", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeUtf16String(ByteBuffer byteBuffer, String str) {
        for (char c : str.toCharArray()) {
            byteBuffer.putChar(c);
        }
        byteBuffer.putChar((char) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        this.data = byteBuffer.slice();
        this.successfulParse = false;
        try {
            try {
                this.tags.clear();
                while (byteBuffer.remaining() > 0) {
                    XtraTag xtraTag = new XtraTag((XtraTag) null);
                    xtraTag.parse(byteBuffer);
                    this.tags.addElement(xtraTag);
                }
                int iDetailSize = detailSize();
                if (iRemaining == iDetailSize) {
                    this.successfulParse = true;
                    byteBuffer.order(ByteOrder.BIG_ENDIAN);
                    return;
                }
                throw new RuntimeException("Improperly handled Xtra tag: Calculated sizes don't match ( " + iRemaining + WVNativeCallbackUtil.SEPERATER + iDetailSize + ")");
            } catch (Exception e) {
                this.successfulParse = false;
                System.err.println("Malformed Xtra Tag detected: " + e.toString());
                e.printStackTrace();
                byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
            }
        } catch (Throwable th) {
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
            throw th;
        }
    }

    public String[] getAllTagNames() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_1, this, this));
        String[] strArr = new String[this.tags.size()];
        for (int i = 0; i < this.tags.size(); i++) {
            strArr[i] = this.tags.elementAt(i).tagName;
        }
        return strArr;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        if (!this.successfulParse) {
            this.data.rewind();
            byteBuffer.put(this.data);
        } else {
            for (int i = 0; i < this.tags.size(); i++) {
                this.tags.elementAt(i).getContent(byteBuffer);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return this.successfulParse ? detailSize() : this.data.limit();
    }

    public Date getFirstDateValue(String str) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_3, this, this, str));
        for (Object obj : getValues(str)) {
            if (obj instanceof Date) {
                return (Date) obj;
            }
        }
        return null;
    }

    public Long getFirstLongValue(String str) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_4, this, this, str));
        for (Object obj : getValues(str)) {
            if (obj instanceof Long) {
                return (Long) obj;
            }
        }
        return null;
    }

    public String getFirstStringValue(String str) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_2, this, this, str));
        for (Object obj : getValues(str)) {
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    public Object[] getValues(String str) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_5, this, this, str));
        XtraTag tagByName = getTagByName(str);
        if (tagByName == null) {
            return new Object[0];
        }
        Object[] objArr = new Object[tagByName.values.size()];
        for (int i = 0; i < tagByName.values.size(); i++) {
            objArr[i] = ((XtraValue) tagByName.values.elementAt(i)).getValueAsObject();
        }
        return objArr;
    }

    public void removeTag(String str) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_6, this, this, str));
        XtraTag tagByName = getTagByName(str);
        if (tagByName != null) {
            this.tags.remove(tagByName);
        }
    }

    public void setTagValue(String str, String str2) {
        RequiresParseDetailAspect.aspectOf().before(d.x(ajc$tjp_8, this, this, str, str2));
        setTagValues(str, new String[]{str2});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTagValues(String str, String[] strArr) {
        RequiresParseDetailAspect.aspectOf().before(d.x(ajc$tjp_7, this, this, str, strArr));
        removeTag(str);
        Object[] objArr = 0;
        XtraTag xtraTag = new XtraTag(str, null);
        for (String str2 : strArr) {
            xtraTag.values.addElement(new XtraValue(str2, (XtraValue) (objArr == true ? 1 : 0)));
        }
        this.tags.addElement(xtraTag);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_0, this, this));
        if (!isParsed()) {
            parseDetails();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("XtraBox[");
        for (XtraTag xtraTag : this.tags) {
            for (XtraValue xtraValue : xtraTag.values) {
                stringBuffer.append(xtraTag.tagName);
                stringBuffer.append("=");
                stringBuffer.append(xtraValue.toString());
                stringBuffer.append(l.b);
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static class XtraTag {
        private int inputSize;
        private String tagName;
        private Vector<XtraValue> values;

        private XtraTag() {
            this.values = new Vector<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getContent(ByteBuffer byteBuffer) {
            byteBuffer.putInt(getContentSize());
            byteBuffer.putInt(this.tagName.length());
            XtraBox.writeAsciiString(byteBuffer, this.tagName);
            byteBuffer.putInt(this.values.size());
            for (int i = 0; i < this.values.size(); i++) {
                this.values.elementAt(i).getContent(byteBuffer);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getContentSize() {
            int length = this.tagName.length() + 12;
            for (int i = 0; i < this.values.size(); i++) {
                length += this.values.elementAt(i).getContentSize();
            }
            return length;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void parse(ByteBuffer byteBuffer) {
            this.inputSize = byteBuffer.getInt();
            this.tagName = XtraBox.readAsciiString(byteBuffer, byteBuffer.getInt());
            int i = byteBuffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                XtraValue xtraValue = new XtraValue((XtraValue) null);
                xtraValue.parse(byteBuffer);
                this.values.addElement(xtraValue);
            }
            if (this.inputSize == getContentSize()) {
                return;
            }
            throw new RuntimeException("Improperly handled Xtra tag: Sizes don't match ( " + this.inputSize + WVNativeCallbackUtil.SEPERATER + getContentSize() + ") on " + this.tagName);
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.tagName);
            stringBuffer.append(" [");
            stringBuffer.append(this.inputSize);
            stringBuffer.append(WVNativeCallbackUtil.SEPERATER);
            stringBuffer.append(this.values.size());
            stringBuffer.append("]:\n");
            for (int i = 0; i < this.values.size(); i++) {
                stringBuffer.append(q.a.i);
                stringBuffer.append(this.values.elementAt(i).toString());
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        }

        public /* synthetic */ XtraTag(XtraTag xtraTag) {
            this();
        }

        public /* synthetic */ XtraTag(String str, XtraTag xtraTag) {
            this(str);
        }

        private XtraTag(String str) {
            this();
            this.tagName = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTagValue(String str, Date date) {
        RequiresParseDetailAspect.aspectOf().before(d.x(ajc$tjp_9, this, this, str, date));
        removeTag(str);
        XtraTag xtraTag = new XtraTag(str, null);
        xtraTag.values.addElement(new XtraValue(date, (XtraValue) (0 == true ? 1 : 0)));
        this.tags.addElement(xtraTag);
    }

    public XtraBox(String str) {
        super(str);
        this.successfulParse = false;
        this.tags = new Vector<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTagValue(String str, long j) {
        RequiresParseDetailAspect.aspectOf().before(d.x(ajc$tjp_10, this, this, str, nv1.m(j)));
        removeTag(str);
        XtraTag xtraTag = new XtraTag(str, null);
        xtraTag.values.addElement(new XtraValue(j, (XtraValue) (0 == true ? 1 : 0)));
        this.tags.addElement(xtraTag);
    }
}
