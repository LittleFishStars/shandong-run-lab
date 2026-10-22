package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class MethodSpec {
    public final List<AnnotationSpec> annotations;
    public final CodeBlock code;
    public final CodeBlock defaultValue;
    public final List<TypeName> exceptions;
    public final CodeBlock javadoc;
    public final Set<Modifier> modifiers;
    public final String name;
    public final List<ParameterSpec> parameters;
    public final TypeName returnType;
    public final List<TypeVariableName> typeVariables;
    public final boolean varargs;

    public static final class Builder {
        private final List<AnnotationSpec> annotations;
        private final CodeBlock.Builder code;
        private CodeBlock defaultValue;
        private final Set<TypeName> exceptions;
        private final CodeBlock.Builder javadoc;
        private final List<Modifier> modifiers;
        private final String name;
        private final List<ParameterSpec> parameters;
        private TypeName returnType;
        private List<TypeVariableName> typeVariables;
        private boolean varargs;

        public Builder addAnnotation(AnnotationSpec annotationSpec) {
            this.annotations.add(annotationSpec);
            return this;
        }

        public Builder addAnnotations(Iterable<AnnotationSpec> iterable) {
            Util.checkArgument(iterable != null, "annotationSpecs == null", new Object[0]);
            Iterator<AnnotationSpec> it = iterable.iterator();
            while (it.hasNext()) {
                this.annotations.add(it.next());
            }
            return this;
        }

        public Builder addCode(String str, Object... objArr) {
            this.code.add(str, objArr);
            return this;
        }

        public Builder addException(TypeName typeName) {
            this.exceptions.add(typeName);
            return this;
        }

        public Builder addJavadoc(CodeBlock codeBlock) {
            this.javadoc.add(codeBlock);
            return this;
        }

        public Builder addModifiers(Modifier... modifierArr) {
            Util.checkNotNull(modifierArr, "modifiers == null", new Object[0]);
            Collections.addAll(this.modifiers, modifierArr);
            return this;
        }

        public Builder addParameter(ParameterSpec parameterSpec) {
            this.parameters.add(parameterSpec);
            return this;
        }

        public Builder addParameters(Iterable<ParameterSpec> iterable) {
            Util.checkArgument(iterable != null, "parameterSpecs == null", new Object[0]);
            Iterator<ParameterSpec> it = iterable.iterator();
            while (it.hasNext()) {
                this.parameters.add(it.next());
            }
            return this;
        }

        public Builder addStatement(String str, Object... objArr) {
            this.code.addStatement(str, objArr);
            return this;
        }

        public Builder addTypeVariable(TypeVariableName typeVariableName) {
            this.typeVariables.add(typeVariableName);
            return this;
        }

        public Builder addTypeVariables(Iterable<TypeVariableName> iterable) {
            Util.checkArgument(iterable != null, "typeVariables == null", new Object[0]);
            Iterator<TypeVariableName> it = iterable.iterator();
            while (it.hasNext()) {
                this.typeVariables.add(it.next());
            }
            return this;
        }

        public Builder beginControlFlow(String str, Object... objArr) {
            this.code.beginControlFlow(str, objArr);
            return this;
        }

        public MethodSpec build() {
            return new MethodSpec(this);
        }

        public Builder endControlFlow() {
            this.code.endControlFlow();
            return this;
        }

        public Builder nextControlFlow(String str, Object... objArr) {
            this.code.nextControlFlow(str, objArr);
            return this;
        }

        public Builder returns(TypeName typeName) {
            Util.checkState(!this.name.equals("<init>"), "constructor cannot have return type.", new Object[0]);
            this.returnType = typeName;
            return this;
        }

        public Builder varargs(boolean z) {
            this.varargs = z;
            return this;
        }

        private Builder(String str) {
            this.javadoc = CodeBlock.builder();
            this.annotations = new ArrayList();
            this.modifiers = new ArrayList();
            this.typeVariables = new ArrayList();
            this.parameters = new ArrayList();
            this.exceptions = new LinkedHashSet();
            this.code = CodeBlock.builder();
            Util.checkNotNull(str, "name == null", new Object[0]);
            Util.checkArgument(str.equals("<init>") || SourceVersion.isName(str), "not a valid name: %s", str);
            this.name = str;
            this.returnType = str.equals("<init>") ? null : TypeName.VOID;
        }

        public Builder addAnnotation(ClassName className) {
            this.annotations.add(AnnotationSpec.builder(className).build());
            return this;
        }

        public Builder addCode(CodeBlock codeBlock) {
            this.code.add(codeBlock);
            return this;
        }

        public Builder addParameter(TypeName typeName, String str, Modifier... modifierArr) {
            return addParameter(ParameterSpec.builder(typeName, str, modifierArr).build());
        }

        public Builder addAnnotation(Class<?> cls) {
            return addAnnotation(ClassName.get(cls));
        }

        public Builder addModifiers(Iterable<Modifier> iterable) {
            Util.checkNotNull(iterable, "modifiers == null", new Object[0]);
            Iterator<Modifier> it = iterable.iterator();
            while (it.hasNext()) {
                this.modifiers.add(it.next());
            }
            return this;
        }

        public Builder returns(Type type) {
            return returns(TypeName.get(type));
        }
    }

    public static Builder constructorBuilder() {
        return new Builder("<init>");
    }

    private boolean lastParameterIsArray(List<ParameterSpec> list) {
        return (list.isEmpty() || TypeName.arrayComponent(list.get(list.size() - 1).type) == null) ? false : true;
    }

    public static Builder methodBuilder(String str) {
        return new Builder(str);
    }

    public void emit(CodeWriter codeWriter, String str, Set<Modifier> set) throws IOException {
        codeWriter.emitJavadoc(this.javadoc);
        codeWriter.emitAnnotations(this.annotations, false);
        codeWriter.emitModifiers(this.modifiers, set);
        if (!this.typeVariables.isEmpty()) {
            codeWriter.emitTypeVariables(this.typeVariables);
            codeWriter.emit(" ");
        }
        if (isConstructor()) {
            codeWriter.emit("$L(", str);
        } else {
            codeWriter.emit("$T $L(", this.returnType, this.name);
        }
        Iterator<ParameterSpec> it = this.parameters.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ParameterSpec next = it.next();
            if (!z) {
                codeWriter.emit(",").emitWrappingSpace();
            }
            next.emit(codeWriter, !it.hasNext() && this.varargs);
            z = false;
        }
        codeWriter.emit(")");
        CodeBlock codeBlock = this.defaultValue;
        if (codeBlock != null && !codeBlock.isEmpty()) {
            codeWriter.emit(" default ");
            codeWriter.emit(this.defaultValue);
        }
        if (!this.exceptions.isEmpty()) {
            codeWriter.emitWrappingSpace().emit("throws");
            boolean z2 = true;
            for (TypeName typeName : this.exceptions) {
                if (!z2) {
                    codeWriter.emit(",");
                }
                codeWriter.emitWrappingSpace().emit("$T", typeName);
                z2 = false;
            }
        }
        if (hasModifier(Modifier.ABSTRACT)) {
            codeWriter.emit(";\n");
            return;
        }
        if (hasModifier(Modifier.NATIVE)) {
            codeWriter.emit(this.code);
            codeWriter.emit(";\n");
            return;
        }
        codeWriter.emit(" {\n");
        codeWriter.indent();
        codeWriter.emit(this.code);
        codeWriter.unindent();
        codeWriter.emit("}\n");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MethodSpec.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public boolean hasModifier(Modifier modifier) {
        return this.modifiers.contains(modifier);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isConstructor() {
        return this.name.equals("<init>");
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            emit(new CodeWriter(stringWriter), "Constructor", Collections.emptySet());
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private MethodSpec(Builder builder) {
        CodeBlock codeBlockBuild = builder.code.build();
        Util.checkArgument(codeBlockBuild.isEmpty() || !builder.modifiers.contains(Modifier.ABSTRACT), "abstract method %s cannot have code", builder.name);
        Util.checkArgument(!builder.varargs || lastParameterIsArray(builder.parameters), "last parameter of varargs method %s must be an array", builder.name);
        this.name = (String) Util.checkNotNull(builder.name, "name == null", new Object[0]);
        this.javadoc = builder.javadoc.build();
        this.annotations = Util.immutableList(builder.annotations);
        this.modifiers = Util.immutableSet(builder.modifiers);
        this.typeVariables = Util.immutableList(builder.typeVariables);
        this.returnType = builder.returnType;
        this.parameters = Util.immutableList(builder.parameters);
        this.varargs = builder.varargs;
        this.exceptions = Util.immutableList(builder.exceptions);
        this.defaultValue = builder.defaultValue;
        this.code = codeBlockBuild;
    }
}
