package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.alibaba.android.arouter.utils.Consts;
import com.ipd.dsp.internal.i.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class CodeWriter {
    private static final String NO_PACKAGE = new String();
    private boolean comment;
    private final Map<String, ClassName> importableTypes;
    private final Map<String, ClassName> importedTypes;
    private final String indent;
    private int indentLevel;
    private boolean javadoc;
    private final LineWrapper out;
    private String packageName;
    private final Set<String> referencedNames;
    int statementLine;
    private final Set<String> staticImportClassNames;
    private final Set<String> staticImports;
    private boolean trailingNewline;
    private final List<TypeSpec> typeSpecStack;

    public CodeWriter(Appendable appendable) {
        this(appendable, q.a.i, Collections.emptySet());
    }

    private void emitIndentation() throws IOException {
        for (int i = 0; i < this.indentLevel; i++) {
            this.out.append(this.indent);
        }
    }

    private void emitLiteral(Object obj) throws IOException {
        if (obj instanceof TypeSpec) {
            ((TypeSpec) obj).emit(this, null, Collections.emptySet());
            return;
        }
        if (obj instanceof AnnotationSpec) {
            ((AnnotationSpec) obj).emit(this, true);
        } else if (obj instanceof CodeBlock) {
            emit((CodeBlock) obj);
        } else {
            emitAndIndent(String.valueOf(obj));
        }
    }

    private boolean emitStaticImportMember(String str, String str2) throws IOException {
        String strSubstring = str2.substring(1);
        if (strSubstring.isEmpty() || !Character.isJavaIdentifierStart(strSubstring.charAt(0))) {
            return false;
        }
        String str3 = str + Consts.DOT + extractMemberName(strSubstring);
        String str4 = str + ".*";
        if (!this.staticImports.contains(str3) && !this.staticImports.contains(str4)) {
            return false;
        }
        emitAndIndent(strSubstring);
        return true;
    }

    private static String extractMemberName(String str) {
        Util.checkArgument(Character.isJavaIdentifierStart(str.charAt(0)), "not an identifier: %s", str);
        for (int i = 1; i <= str.length(); i++) {
            if (!SourceVersion.isIdentifier(str.substring(0, i))) {
                return str.substring(0, i - 1);
            }
        }
        return str;
    }

    private void importableType(ClassName className) {
        ClassName className2;
        String strSimpleName;
        ClassName classNamePut;
        if (className.packageName().isEmpty() || (classNamePut = this.importableTypes.put((strSimpleName = (className2 = className.topLevelClassName()).simpleName()), className2)) == null) {
            return;
        }
        this.importableTypes.put(strSimpleName, classNamePut);
    }

    private ClassName resolve(String str) {
        for (int size = this.typeSpecStack.size() - 1; size >= 0; size--) {
            Iterator<TypeSpec> it = this.typeSpecStack.get(size).typeSpecs.iterator();
            while (it.hasNext()) {
                if (Objects.equals(it.next().name, str)) {
                    return stackClassName(size, str);
                }
            }
        }
        if (this.typeSpecStack.size() > 0 && Objects.equals(this.typeSpecStack.get(0).name, str)) {
            return ClassName.get(this.packageName, str, new String[0]);
        }
        ClassName className = this.importedTypes.get(str);
        if (className != null) {
            return className;
        }
        return null;
    }

    private ClassName stackClassName(int i, String str) {
        ClassName classNameNestedClass = ClassName.get(this.packageName, this.typeSpecStack.get(0).name, new String[0]);
        for (int i2 = 1; i2 <= i; i2++) {
            classNameNestedClass = classNameNestedClass.nestedClass(this.typeSpecStack.get(i2).name);
        }
        return classNameNestedClass.nestedClass(str);
    }

    public CodeWriter emit(String str) throws IOException {
        return emitAndIndent(str);
    }

    public CodeWriter emitAndIndent(String str) throws IOException {
        String[] strArrSplit = str.split("\n", -1);
        int length = strArrSplit.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            String str2 = strArrSplit[i];
            if (!z) {
                if ((this.javadoc || this.comment) && this.trailingNewline) {
                    emitIndentation();
                    this.out.append(this.javadoc ? " *" : "//");
                }
                this.out.append("\n");
                this.trailingNewline = true;
                int i2 = this.statementLine;
                if (i2 != -1) {
                    if (i2 == 0) {
                        indent(2);
                    }
                    this.statementLine++;
                }
            }
            if (!str2.isEmpty()) {
                if (this.trailingNewline) {
                    emitIndentation();
                    if (this.javadoc) {
                        this.out.append(" * ");
                    } else if (this.comment) {
                        this.out.append("// ");
                    }
                }
                this.out.append(str2);
                this.trailingNewline = false;
            }
            i++;
            z = false;
        }
        return this;
    }

    public void emitAnnotations(List<AnnotationSpec> list, boolean z) throws IOException {
        Iterator<AnnotationSpec> it = list.iterator();
        while (it.hasNext()) {
            it.next().emit(this, z);
            emit(z ? " " : "\n");
        }
    }

    public void emitComment(CodeBlock codeBlock) throws IOException {
        this.trailingNewline = true;
        this.comment = true;
        try {
            emit(codeBlock);
            emit("\n");
        } finally {
            this.comment = false;
        }
    }

    public void emitJavadoc(CodeBlock codeBlock) throws IOException {
        if (codeBlock.isEmpty()) {
            return;
        }
        emit("/**\n");
        this.javadoc = true;
        try {
            emit(codeBlock);
            this.javadoc = false;
            emit(" */\n");
        } catch (Throwable th) {
            this.javadoc = false;
            throw th;
        }
    }

    public void emitModifiers(Set<Modifier> set, Set<Modifier> set2) throws IOException {
        if (set.isEmpty()) {
            return;
        }
        for (Modifier modifier : EnumSet.copyOf((Collection) set)) {
            if (!set2.contains(modifier)) {
                emitAndIndent(modifier.name().toLowerCase(Locale.US));
                emitAndIndent(" ");
            }
        }
    }

    public void emitTypeVariables(List<TypeVariableName> list) throws IOException {
        if (list.isEmpty()) {
            return;
        }
        emit("<");
        boolean z = true;
        for (TypeVariableName typeVariableName : list) {
            if (!z) {
                emit(", ");
            }
            emit("$L", typeVariableName.name);
            Iterator<TypeName> it = typeVariableName.bounds.iterator();
            boolean z2 = true;
            while (it.hasNext()) {
                emit(z2 ? " extends $T" : " & $T", it.next());
                z2 = false;
            }
            z = false;
        }
        emit(">");
    }

    public CodeWriter emitWrappingSpace() throws IOException {
        this.out.wrappingSpace(this.indentLevel + 2);
        return this;
    }

    public Map<String, ClassName> importedTypes() {
        return this.importedTypes;
    }

    public CodeWriter indent() {
        return indent(1);
    }

    public String lookupName(ClassName className) {
        ClassName classNameEnclosingClassName = className;
        boolean z = false;
        while (classNameEnclosingClassName != null) {
            ClassName classNameResolve = resolve(classNameEnclosingClassName.simpleName());
            boolean z2 = classNameResolve != null;
            if (Objects.equals(classNameResolve, classNameEnclosingClassName)) {
                return Util.join(Consts.DOT, className.simpleNames().subList(classNameEnclosingClassName.simpleNames().size() - 1, className.simpleNames().size()));
            }
            classNameEnclosingClassName = classNameEnclosingClassName.enclosingClassName();
            z = z2;
        }
        if (z) {
            return className.canonicalName;
        }
        if (Objects.equals(this.packageName, className.packageName())) {
            this.referencedNames.add(className.topLevelClassName().simpleName());
            return Util.join(Consts.DOT, className.simpleNames());
        }
        if (!this.javadoc) {
            importableType(className);
        }
        return className.canonicalName;
    }

    public CodeWriter popPackage() {
        String str = this.packageName;
        String str2 = NO_PACKAGE;
        Util.checkState(str != str2, "package already set: %s", str);
        this.packageName = str2;
        return this;
    }

    public CodeWriter popType() {
        List<TypeSpec> list = this.typeSpecStack;
        list.remove(list.size() - 1);
        return this;
    }

    public CodeWriter pushPackage(String str) {
        String str2 = this.packageName;
        Util.checkState(str2 == NO_PACKAGE, "package already set: %s", str2);
        this.packageName = (String) Util.checkNotNull(str, "packageName == null", new Object[0]);
        return this;
    }

    public CodeWriter pushType(TypeSpec typeSpec) {
        this.typeSpecStack.add(typeSpec);
        return this;
    }

    public Map<String, ClassName> suggestedImports() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.importableTypes);
        linkedHashMap.keySet().removeAll(this.referencedNames);
        return linkedHashMap;
    }

    public CodeWriter unindent() {
        return unindent(1);
    }

    public CodeWriter(Appendable appendable, String str, Set<String> set) {
        this(appendable, str, Collections.emptyMap(), set);
    }

    public CodeWriter emit(String str, Object... objArr) throws IOException {
        return emit(CodeBlock.of(str, objArr));
    }

    public CodeWriter indent(int i) {
        this.indentLevel += i;
        return this;
    }

    public CodeWriter unindent(int i) {
        Util.checkArgument(this.indentLevel - i >= 0, "cannot unindent %s from %s", Integer.valueOf(i), Integer.valueOf(this.indentLevel));
        this.indentLevel -= i;
        return this;
    }

    public CodeWriter(Appendable appendable, String str, Map<String, ClassName> map, Set<String> set) {
        this.javadoc = false;
        this.comment = false;
        this.packageName = NO_PACKAGE;
        this.typeSpecStack = new ArrayList();
        this.importableTypes = new LinkedHashMap();
        this.referencedNames = new LinkedHashSet();
        this.statementLine = -1;
        this.out = new LineWrapper(appendable, str, 100);
        this.indent = (String) Util.checkNotNull(str, "indent == null", new Object[0]);
        this.importedTypes = (Map) Util.checkNotNull(map, "importedTypes == null", new Object[0]);
        this.staticImports = (Set) Util.checkNotNull(set, "staticImports == null", new Object[0]);
        this.staticImportClassNames = new LinkedHashSet();
        for (String str2 : set) {
            this.staticImportClassNames.add(str2.substring(0, str2.lastIndexOf(46)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x013d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x0156 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x009c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:12:0x002f  */
    /* JADX WARN: Code duplicated, block: B:130:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x0033  */
    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:0x0049  */
    /* JADX WARN: Code duplicated, block: B:21:0x004b  */
    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    /* JADX WARN: Code duplicated, block: B:25:0x0056  */
    /* JADX WARN: Code duplicated, block: B:28:0x005f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x006a  */
    /* JADX WARN: Code duplicated, block: B:33:0x006c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:37:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x0080  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082  */
    /* JADX WARN: Code duplicated, block: B:44:0x008b  */
    /* JADX WARN: Code duplicated, block: B:45:0x008d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0096  */
    /* JADX WARN: Code duplicated, block: B:52:0x009e  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00be  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:6:0x0010  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:78:0x0107  */
    /* JADX WARN: Code duplicated, block: B:88:0x0139  */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    /* JADX WARN: Code duplicated, block: B:91:0x0149  */
    /* JADX WARN: Code duplicated, block: B:92:0x0150  */
    /* JADX WARN: Code duplicated, block: B:9:0x0026  */
    /* JADX WARN: Failed to find 'out' block for switch in B:50:0x0099. Please report as an issue. */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:106:0x00ec
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.CodeWriter emit(com.bumptech.glide.repackaged.com.squareup.javapoet.CodeBlock r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.repackaged.com.squareup.javapoet.CodeWriter.emit(com.bumptech.glide.repackaged.com.squareup.javapoet.CodeBlock):com.bumptech.glide.repackaged.com.squareup.javapoet.CodeWriter");
    }

    public void emitModifiers(Set<Modifier> set) throws IOException {
        emitModifiers(set, Collections.emptySet());
    }
}
