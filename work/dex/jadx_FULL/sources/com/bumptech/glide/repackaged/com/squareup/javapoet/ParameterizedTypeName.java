package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.alibaba.android.arouter.utils.Consts;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ParameterizedTypeName extends TypeName {
    private final ParameterizedTypeName enclosingType;
    public final ClassName rawType;
    public final List<TypeName> typeArguments;

    public ParameterizedTypeName(ParameterizedTypeName parameterizedTypeName, ClassName className, List<TypeName> list) {
        this(parameterizedTypeName, className, list, new ArrayList());
    }

    public static ParameterizedTypeName get(ClassName className, TypeName... typeNameArr) {
        return new ParameterizedTypeName(null, className, Arrays.asList(typeNameArr));
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName
    public /* bridge */ /* synthetic */ TypeName annotated(List list) {
        return annotated((List<AnnotationSpec>) list);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName
    public CodeWriter emit(CodeWriter codeWriter) throws IOException {
        ParameterizedTypeName parameterizedTypeName = this.enclosingType;
        if (parameterizedTypeName != null) {
            parameterizedTypeName.emitAnnotations(codeWriter);
            this.enclosingType.emit(codeWriter);
            codeWriter.emit(Consts.DOT + this.rawType.simpleName());
        } else {
            this.rawType.emitAnnotations(codeWriter);
            this.rawType.emit(codeWriter);
        }
        if (!this.typeArguments.isEmpty()) {
            codeWriter.emitAndIndent("<");
            boolean z = true;
            for (TypeName typeName : this.typeArguments) {
                if (!z) {
                    codeWriter.emitAndIndent(", ");
                }
                typeName.emitAnnotations(codeWriter);
                typeName.emit(codeWriter);
                z = false;
            }
            codeWriter.emitAndIndent(">");
        }
        return codeWriter;
    }

    public ParameterizedTypeName nestedClass(String str, List<TypeName> list) {
        Util.checkNotNull(str, "name == null", new Object[0]);
        return new ParameterizedTypeName(this, this.rawType.nestedClass(str), list, new ArrayList());
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName
    public TypeName withoutAnnotations() {
        return new ParameterizedTypeName(this.enclosingType, this.rawType, this.typeArguments, new ArrayList());
    }

    private ParameterizedTypeName(ParameterizedTypeName parameterizedTypeName, ClassName className, List<TypeName> list, List<AnnotationSpec> list2) {
        super(list2);
        this.rawType = (ClassName) Util.checkNotNull(className, "rawType == null", new Object[0]);
        this.enclosingType = parameterizedTypeName;
        List<TypeName> listImmutableList = Util.immutableList(list);
        this.typeArguments = listImmutableList;
        Util.checkArgument((listImmutableList.isEmpty() && parameterizedTypeName == null) ? false : true, "no type arguments: %s", className);
        Iterator<TypeName> it = listImmutableList.iterator();
        while (it.hasNext()) {
            TypeName next = it.next();
            Util.checkArgument((next.isPrimitive() || next == TypeName.VOID) ? false : true, "invalid type parameter: %s", next);
        }
    }

    public static ParameterizedTypeName get(ParameterizedType parameterizedType, Map<Type, TypeVariableName> map) {
        ClassName className = ClassName.get((Class<?>) parameterizedType.getRawType());
        ParameterizedType parameterizedType2 = (!(parameterizedType.getOwnerType() instanceof ParameterizedType) || Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers())) ? null : (ParameterizedType) parameterizedType.getOwnerType();
        List<TypeName> list = TypeName.list(parameterizedType.getActualTypeArguments(), map);
        return parameterizedType2 != null ? get(parameterizedType2, map).nestedClass(className.simpleName(), list) : new ParameterizedTypeName(null, className, list);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName
    public ParameterizedTypeName annotated(List<AnnotationSpec> list) {
        return new ParameterizedTypeName(this.enclosingType, this.rawType, this.typeArguments, concatAnnotations(list));
    }
}
