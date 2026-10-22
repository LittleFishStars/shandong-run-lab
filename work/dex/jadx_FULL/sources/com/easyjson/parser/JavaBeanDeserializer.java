package com.easyjson.parser;

import com.acse.ottn.p3;
import com.easyjson.JSONException;
import com.easyjson.JSONObject;
import com.easyjson.annotation.JSONType;
import com.easyjson.parser.deserializer.ExtraProcessable;
import com.easyjson.parser.deserializer.ExtraProcessor;
import com.easyjson.parser.deserializer.ExtraTypeProvider;
import com.easyjson.parser.deserializer.FieldDeserializer;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.util.FieldInfo;
import com.easyjson.util.TypeUtils;
import com.google.common.net.c;
import com.zj.adlib.dhb;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    public final dhb beanInfo;
    private final Class<?> clazz;
    private final FieldDeserializer[] fieldDeserializers;
    private final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, cls, type, dhb.a(cls, cls.getModifiers(), type, false, true, true, true));
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type, dhb dhbVar) {
        this.clazz = cls;
        this.beanInfo = dhbVar;
        FieldInfo[] fieldInfoArr = dhbVar.f15998b;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        for (int i = 0; i < length; i++) {
            this.sortedFieldDeserializers[i] = parserConfig.createFieldDeserializer(parserConfig, cls, dhbVar.f15998b[i]);
        }
        FieldInfo[] fieldInfoArr2 = dhbVar.f15996a;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(dhbVar.f15996a[i2].name);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v82 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v60 */
    /* JADX WARN: Type inference failed for: r12v61 */
    /* JADX WARN: Type inference failed for: r12v62 */
    /* JADX WARN: Type inference failed for: r12v63 */
    /* JADX WARN: Type inference failed for: r12v64 */
    /* JADX WARN: Type inference failed for: r12v65 */
    /* JADX WARN: Type inference failed for: r12v66 */
    /* JADX WARN: Type inference failed for: r12v67 */
    /* JADX WARN: Type inference failed for: r12v68 */
    /* JADX WARN: Type inference failed for: r12v69 */
    /* JADX WARN: Type inference failed for: r12v70 */
    /* JADX WARN: Type inference failed for: r12v71 */
    /* JADX WARN: Type inference failed for: r12v72 */
    /* JADX WARN: Type inference failed for: r12v73 */
    /* JADX WARN: Type inference failed for: r12v74 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v17, types: [com.easyjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r13v18, types: [com.easyjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v39, types: [com.easyjson.parser.ParserConfig] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v53 */
    /* JADX WARN: Type inference failed for: r13v54 */
    /* JADX WARN: Type inference failed for: r13v55 */
    /* JADX WARN: Type inference failed for: r13v56 */
    /* JADX WARN: Type inference failed for: r13v57 */
    /* JADX WARN: Type inference failed for: r13v58 */
    /* JADX WARN: Type inference failed for: r13v59 */
    /* JADX WARN: Type inference failed for: r13v60 */
    /* JADX WARN: Type inference failed for: r13v61 */
    /* JADX WARN: Type inference failed for: r13v64 */
    /* JADX WARN: Type inference failed for: r13v65 */
    /* JADX WARN: Type inference failed for: r13v66 */
    /* JADX WARN: Type inference failed for: r13v67 */
    /* JADX WARN: Type inference failed for: r13v68 */
    /* JADX WARN: Type inference failed for: r13v69 */
    /* JADX WARN: Type inference failed for: r13v70 */
    /* JADX WARN: Type inference failed for: r13v71 */
    /* JADX WARN: Type inference failed for: r13v72 */
    /* JADX WARN: Type inference failed for: r13v78 */
    /* JADX WARN: Type inference failed for: r13v79 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v24, types: [com.easyjson.parser.deserializer.FieldDeserializer] */
    /* JADX WARN: Type inference failed for: r1v36, types: [com.easyjson.parser.deserializer.FieldDeserializer] */
    /* JADX WARN: Type inference failed for: r1v37, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v66, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v88 */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v11 */
    /* JADX WARN: Type inference failed for: r25v12 */
    /* JADX WARN: Type inference failed for: r25v13 */
    /* JADX WARN: Type inference failed for: r25v14 */
    /* JADX WARN: Type inference failed for: r25v15 */
    /* JADX WARN: Type inference failed for: r25v16 */
    /* JADX WARN: Type inference failed for: r25v17 */
    /* JADX WARN: Type inference failed for: r25v18 */
    /* JADX WARN: Type inference failed for: r25v19 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v20 */
    /* JADX WARN: Type inference failed for: r25v21 */
    /* JADX WARN: Type inference failed for: r25v22 */
    /* JADX WARN: Type inference failed for: r25v23 */
    /* JADX WARN: Type inference failed for: r25v24 */
    /* JADX WARN: Type inference failed for: r25v25 */
    /* JADX WARN: Type inference failed for: r25v26 */
    /* JADX WARN: Type inference failed for: r25v27 */
    /* JADX WARN: Type inference failed for: r25v28 */
    /* JADX WARN: Type inference failed for: r25v29 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v30 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v4 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r29v6 */
    /* JADX WARN: Type inference failed for: r29v7 */
    /* JADX WARN: Type inference failed for: r2v30, types: [double] */
    /* JADX WARN: Type inference failed for: r2v56, types: [com.easyjson.parser.deserializer.ObjectDeserializer] */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r32v0, types: [com.easyjson.parser.JavaBeanDeserializer] */
    /* JADX WARN: Type inference failed for: r32v1, types: [com.easyjson.parser.JavaBeanDeserializer] */
    /* JADX WARN: Type inference failed for: r33v1, types: [com.easyjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r36v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.easyjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24, types: [com.easyjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27, types: [com.easyjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r4v28, types: [com.easyjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Class, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.easyjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20, types: [com.easyjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.easyjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.easyjson.parser.JavaBeanDeserializer] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.easyjson.parser.JavaBeanDeserializer] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [double] */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.easyjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to ?? for r36v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:139)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:212)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:73)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:48)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:39)
        */
    private <T> T deserialze(com.easyjson.parser.DefaultJSONParser r33, java.lang.reflect.Type r34, java.lang.Object r35, java.lang.Object r36) {
        /*
            Method dump skipped, instruction units count: 1474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easyjson.parser.JavaBeanDeserializer.deserialze(com.easyjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:142:0x0270 A[Catch: IllegalAccessException -> 0x02dd, TryCatch #0 {IllegalAccessException -> 0x02dd, blocks: (B:10:0x0025, B:12:0x0029, B:14:0x0032, B:16:0x0040, B:18:0x0044, B:22:0x0057, B:136:0x0254, B:21:0x0051, B:24:0x005f, B:28:0x0072, B:27:0x006c, B:142:0x0270, B:15:0x0038, B:33:0x0084, B:35:0x0088, B:47:0x00b3, B:49:0x00b7, B:51:0x00c0, B:53:0x00c4, B:56:0x00d1, B:58:0x00db, B:61:0x00e8, B:50:0x00bd, B:38:0x0091, B:40:0x0095, B:42:0x009d, B:46:0x00b0, B:45:0x00aa, B:62:0x00ef, B:63:0x0107, B:64:0x0108, B:66:0x010e, B:68:0x0116, B:70:0x0124, B:72:0x0128, B:76:0x013b, B:75:0x0135, B:78:0x0141, B:82:0x0154, B:81:0x014e, B:69:0x011c, B:83:0x0158, B:85:0x015c, B:87:0x0164, B:89:0x0171, B:91:0x0175, B:94:0x0182, B:96:0x018b, B:99:0x0198, B:88:0x016a, B:100:0x019f, B:102:0x01a5, B:104:0x01a9, B:113:0x01d4, B:115:0x01db, B:118:0x01e9, B:120:0x01f3, B:123:0x0201, B:107:0x01b3, B:112:0x01c0, B:124:0x0209, B:125:0x0223, B:128:0x0228, B:130:0x022e, B:132:0x023e, B:135:0x024c, B:138:0x025a, B:141:0x0268, B:143:0x0274, B:145:0x027a, B:149:0x028d, B:158:0x02b5, B:161:0x02bf, B:164:0x02c6, B:165:0x02cb, B:167:0x02ce, B:170:0x02d3, B:171:0x02d8, B:148:0x0287, B:152:0x0298, B:156:0x02ab, B:155:0x02a5, B:157:0x02b2), top: B:185:0x0025 }] */
    private <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        char cCharAt;
        char cCharAt2;
        Enum enumValueOf;
        String strScanStringValue;
        char cCharAt3;
        char cCharAt4;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        T t = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i = 0;
        while (true) {
            int i2 = 16;
            if (i >= length) {
                if (jSONLexer.ch == ',') {
                    int i3 = jSONLexer.bp + 1;
                    jSONLexer.bp = i3;
                    jSONLexer.ch = i3 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i3);
                    jSONLexer.token = 16;
                } else {
                    jSONLexer.nextToken();
                }
                return t;
            }
            char c = i == length + (-1) ? ']' : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
            FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
            Class<?> cls = fieldInfo.fieldClass;
            try {
                if (cls == Integer.TYPE) {
                    int iScanLongValue = (int) jSONLexer.scanLongValue();
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.setInt(t, iScanLongValue);
                    } else {
                        fieldDeserializer.setValue(t, new Integer(iScanLongValue));
                    }
                    char c2 = jSONLexer.ch;
                    if (c2 == ',') {
                        int i4 = jSONLexer.bp + 1;
                        jSONLexer.bp = i4;
                        cCharAt4 = i4 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i4);
                        jSONLexer.ch = cCharAt4;
                        jSONLexer.token = i2;
                    } else {
                        if (c2 == ']') {
                            int i5 = jSONLexer.bp + 1;
                            jSONLexer.bp = i5;
                            cCharAt3 = i5 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i5);
                            jSONLexer.ch = cCharAt3;
                            i2 = 15;
                            jSONLexer.token = i2;
                        }
                        jSONLexer.nextToken();
                    }
                } else if (cls == String.class) {
                    char c3 = jSONLexer.ch;
                    if (c3 != '\"') {
                        if (c3 == 'n') {
                            if (jSONLexer.text.startsWith("null", jSONLexer.bp)) {
                                int i6 = jSONLexer.bp + 4;
                                jSONLexer.bp = i6;
                                jSONLexer.ch = i6 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i6);
                                strScanStringValue = null;
                            }
                        }
                        throw new JSONException("not match string. feild : " + obj);
                    }
                    strScanStringValue = jSONLexer.scanStringValue('\"');
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.set(t, strScanStringValue);
                    } else {
                        fieldDeserializer.setValue(t, strScanStringValue);
                    }
                    char c4 = jSONLexer.ch;
                    if (c4 == ',') {
                        int i7 = jSONLexer.bp + 1;
                        jSONLexer.bp = i7;
                        cCharAt4 = i7 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i7);
                        jSONLexer.ch = cCharAt4;
                        jSONLexer.token = i2;
                    } else {
                        if (c4 == ']') {
                            int i8 = jSONLexer.bp + 1;
                            jSONLexer.bp = i8;
                            cCharAt3 = i8 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i8);
                            jSONLexer.ch = cCharAt3;
                            i2 = 15;
                            jSONLexer.token = i2;
                        }
                        jSONLexer.nextToken();
                    }
                } else if (cls == Long.TYPE) {
                    long jScanLongValue = jSONLexer.scanLongValue();
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.setLong(t, jScanLongValue);
                    } else {
                        fieldDeserializer.setValue(t, new Long(jScanLongValue));
                    }
                    char c5 = jSONLexer.ch;
                    if (c5 == ',') {
                        int i9 = jSONLexer.bp + 1;
                        jSONLexer.bp = i9;
                        cCharAt2 = i9 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i9);
                        jSONLexer.ch = cCharAt2;
                        jSONLexer.token = i2;
                    } else if (c5 == ']') {
                        int i10 = jSONLexer.bp + 1;
                        jSONLexer.bp = i10;
                        cCharAt = i10 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i10);
                        jSONLexer.ch = cCharAt;
                        i2 = 15;
                        jSONLexer.token = i2;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else if (cls == Boolean.TYPE) {
                    boolean zScanBoolean = jSONLexer.scanBoolean();
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.setBoolean(t, zScanBoolean);
                    } else {
                        fieldDeserializer.setValue(t, Boolean.valueOf(zScanBoolean));
                    }
                    char c6 = jSONLexer.ch;
                    if (c6 == ',') {
                        int i11 = jSONLexer.bp + 1;
                        jSONLexer.bp = i11;
                        cCharAt2 = i11 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i11);
                        jSONLexer.ch = cCharAt2;
                        jSONLexer.token = i2;
                    } else if (c6 == ']') {
                        int i12 = jSONLexer.bp + 1;
                        jSONLexer.bp = i12;
                        cCharAt = i12 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i12);
                        jSONLexer.ch = cCharAt;
                        i2 = 15;
                        jSONLexer.token = i2;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else if (cls.isEnum()) {
                    char c7 = jSONLexer.ch;
                    if (c7 == '\"') {
                        String strScanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
                        enumValueOf = strScanSymbol == null ? null : Enum.valueOf(cls, strScanSymbol);
                    } else {
                        if (c7 < '0' || c7 > '9') {
                            throw new JSONException("illegal enum." + jSONLexer.info());
                        }
                        enumValueOf = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.config)).values[(int) jSONLexer.scanLongValue()];
                    }
                    fieldDeserializer.setValue(t, enumValueOf);
                    char c8 = jSONLexer.ch;
                    if (c8 == ',') {
                        int i13 = jSONLexer.bp + 1;
                        jSONLexer.bp = i13;
                        cCharAt2 = i13 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i13);
                        jSONLexer.ch = cCharAt2;
                        jSONLexer.token = i2;
                    } else if (c8 == ']') {
                        int i14 = jSONLexer.bp + 1;
                        jSONLexer.bp = i14;
                        cCharAt = i14 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i14);
                        jSONLexer.ch = cCharAt;
                        i2 = 15;
                        jSONLexer.token = i2;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else if (cls == Date.class && jSONLexer.ch == '1') {
                    fieldDeserializer.setValue(t, new Date(jSONLexer.scanLongValue()));
                    char c9 = jSONLexer.ch;
                    if (c9 == ',') {
                        int i15 = jSONLexer.bp + 1;
                        jSONLexer.bp = i15;
                        cCharAt2 = i15 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i15);
                        jSONLexer.ch = cCharAt2;
                        jSONLexer.token = i2;
                    } else if (c9 == ']') {
                        int i16 = jSONLexer.bp + 1;
                        jSONLexer.bp = i16;
                        cCharAt = i16 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i16);
                        jSONLexer.ch = cCharAt;
                        i2 = 15;
                        jSONLexer.token = i2;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else {
                    char c10 = jSONLexer.ch;
                    if (c10 == '[') {
                        int i17 = jSONLexer.bp + 1;
                        jSONLexer.bp = i17;
                        jSONLexer.ch = i17 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i17);
                        jSONLexer.token = 14;
                    } else if (c10 == '{') {
                        int i18 = jSONLexer.bp + 1;
                        jSONLexer.bp = i18;
                        jSONLexer.ch = i18 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i18);
                        jSONLexer.token = 12;
                    } else {
                        jSONLexer.nextToken();
                    }
                    fieldDeserializer.parseField(defaultJSONParser, t, fieldInfo.fieldType, null);
                    if (c == ']') {
                        if (jSONLexer.token != 15) {
                            throw new JSONException("syntax error");
                        }
                    } else if (c == ',' && jSONLexer.token != 16) {
                        throw new JSONException("syntax error");
                    }
                }
                i++;
            } catch (IllegalAccessException e) {
                throw new JSONException("set " + fieldInfo.name + "error", e);
            }
        }
    }

    private boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str);
        if (fieldDeserializer == null) {
            boolean zStartsWith = str.startsWith(p3.g);
            for (FieldDeserializer fieldDeserializer2 : this.sortedFieldDeserializers) {
                FieldInfo fieldInfo = fieldDeserializer2.fieldInfo;
                Class<?> cls = fieldInfo.fieldClass;
                String str2 = fieldInfo.name;
                if (str2.equalsIgnoreCase(str) || (zStartsWith && ((cls == Boolean.TYPE || cls == Boolean.class) && str2.equalsIgnoreCase(str.substring(2))))) {
                    fieldDeserializer = fieldDeserializer2;
                    break;
                }
            }
        }
        if (fieldDeserializer == null) {
            parseExtra(defaultJSONParser, obj, str);
            return false;
        }
        jSONLexer.nextTokenWithChar(c.b);
        fieldDeserializer.parseField(defaultJSONParser, obj, type, map);
        return true;
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject((defaultJSONParser.lexer.features & Feature.OrderedField.mask) != 0));
        }
        dhb dhbVar = this.beanInfo;
        Constructor<?> constructor = dhbVar.f15993a;
        if (constructor == null) {
            return null;
        }
        try {
            Object objNewInstance = dhbVar.f41184a == 0 ? constructor.newInstance(new Object[0]) : constructor.newInstance(defaultJSONParser.contex.object);
            if (defaultJSONParser != null && (defaultJSONParser.lexer.features & Feature.InitStringFieldAsEmpty.mask) != 0) {
                for (FieldInfo fieldInfo : this.beanInfo.f15996a) {
                    if (fieldInfo.fieldClass == String.class) {
                        fieldInfo.set(objNewInstance, "");
                    }
                }
            }
            return objNewInstance;
        } catch (Exception e) {
            throw new JSONException("create instance error, class " + this.clazz.getName(), e);
        }
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalAccessException, InvocationTargetException {
        dhb dhbVar = this.beanInfo;
        if (dhbVar.b == null) {
            Object objCreateInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                FieldDeserializer fieldDeserializer = getFieldDeserializer(entry.getKey());
                if (fieldDeserializer != null) {
                    Object value = entry.getValue();
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    Method method = fieldInfo.method;
                    if (method != null) {
                        method.invoke(objCreateInstance, TypeUtils.cast(value, method.getGenericParameterTypes()[0], parserConfig));
                    } else {
                        fieldInfo.field.set(objCreateInstance, TypeUtils.cast(value, fieldInfo.fieldType, parserConfig));
                    }
                }
            }
            return objCreateInstance;
        }
        FieldInfo[] fieldInfoArr = dhbVar.f15996a;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr[i] = map.get(fieldInfoArr[i].name);
        }
        Constructor<?> constructor = this.beanInfo.b;
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            throw new JSONException("create instance error, " + this.beanInfo.b.toGenericString(), e);
        }
    }

    @Override // com.easyjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        if (!this.beanInfo.f15995a) {
            int length = this.sortedFieldDeserializers.length - 1;
            while (i <= length) {
                int i2 = (i + length) >>> 1;
                int iCompareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
                if (iCompareTo < 0) {
                    i = i2 + 1;
                } else {
                    if (iCompareTo <= 0) {
                        return this.sortedFieldDeserializers[i2];
                    }
                    length = i2 - 1;
                }
            }
            return null;
        }
        while (true) {
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            if (i >= fieldDeserializerArr.length) {
                return null;
            }
            if (fieldDeserializerArr[i].fieldInfo.name.equalsIgnoreCase(str)) {
                return this.sortedFieldDeserializers[i];
            }
            i++;
        }
    }

    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, dhb dhbVar, String str) {
        JSONType jSONType = dhbVar.f15991a;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                dhb dhbVar2 = javaBeanDeserializer.beanInfo;
                if (dhbVar2.f15992a.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, dhbVar2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public void parseExtra(DefaultJSONParser defaultJSONParser, Object obj, String str) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if ((jSONLexer.features & Feature.IgnoreNotMatch.mask) == 0) {
            throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
        }
        jSONLexer.nextTokenWithChar(c.b);
        List<ExtraTypeProvider> list = defaultJSONParser.extraTypeProviders;
        Type extraType = null;
        if (list != null) {
            Iterator<ExtraTypeProvider> it = list.iterator();
            while (it.hasNext()) {
                extraType = it.next().getExtraType(obj, str);
            }
        }
        Object object = extraType == null ? defaultJSONParser.parse() : defaultJSONParser.parseObject(extraType);
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, object);
            return;
        }
        List<ExtraProcessor> list2 = defaultJSONParser.extraProcessors;
        if (list2 != null) {
            Iterator<ExtraProcessor> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().processExtra(obj, str, object);
            }
        }
    }
}
