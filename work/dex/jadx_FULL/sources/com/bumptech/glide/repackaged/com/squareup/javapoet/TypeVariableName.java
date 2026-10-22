package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class TypeVariableName extends TypeName {
    public final List<TypeName> bounds;
    public final String name;

    private TypeVariableName(String str, List<TypeName> list) {
        this(str, list, new ArrayList());
    }

    public static TypeVariableName get(String str) {
        return of(str, Collections.emptyList());
    }

    private static TypeVariableName of(String str, List<TypeName> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.remove(TypeName.OBJECT);
        return new TypeVariableName(str, Collections.unmodifiableList(arrayList));
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName
    public /* bridge */ /* synthetic */ TypeName annotated(List list) {
        return annotated((List<AnnotationSpec>) list);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName
    public CodeWriter emit(CodeWriter codeWriter) throws IOException {
        return codeWriter.emitAndIndent(this.name);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName
    public TypeName withoutAnnotations() {
        return new TypeVariableName(this.name, this.bounds);
    }

    private TypeVariableName(String str, List<TypeName> list, List<AnnotationSpec> list2) {
        super(list2);
        this.name = (String) Util.checkNotNull(str, "name == null", new Object[0]);
        this.bounds = list;
        Iterator<TypeName> it = list.iterator();
        while (it.hasNext()) {
            TypeName next = it.next();
            Util.checkArgument((next.isPrimitive() || next == TypeName.VOID) ? false : true, "invalid bound: %s", next);
        }
    }

    public static TypeVariableName get(TypeVariable typeVariable) {
        return get(typeVariable.asElement());
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName
    public TypeVariableName annotated(List<AnnotationSpec> list) {
        return new TypeVariableName(this.name, this.bounds, list);
    }

    public static TypeVariableName get(TypeVariable typeVariable, Map<TypeParameterElement, TypeVariableName> map) {
        TypeParameterElement typeParameterElement = (TypeParameterElement) typeVariable.asElement();
        TypeVariableName typeVariableName = map.get(typeParameterElement);
        if (typeVariableName != null) {
            return typeVariableName;
        }
        ArrayList arrayList = new ArrayList();
        TypeVariableName typeVariableName2 = new TypeVariableName(typeParameterElement.getSimpleName().toString(), Collections.unmodifiableList(arrayList));
        map.put(typeParameterElement, typeVariableName2);
        Iterator it = typeParameterElement.getBounds().iterator();
        while (it.hasNext()) {
            arrayList.add(TypeName.get((TypeMirror) it.next(), map));
        }
        arrayList.remove(TypeName.OBJECT);
        return typeVariableName2;
    }

    public static TypeVariableName get(TypeParameterElement typeParameterElement) {
        String string = typeParameterElement.getSimpleName().toString();
        List bounds = typeParameterElement.getBounds();
        ArrayList arrayList = new ArrayList();
        Iterator it = bounds.iterator();
        while (it.hasNext()) {
            arrayList.add(TypeName.get((TypeMirror) it.next()));
        }
        return of(string, arrayList);
    }

    public static TypeVariableName get(java.lang.reflect.TypeVariable<?> typeVariable, Map<Type, TypeVariableName> map) {
        TypeVariableName typeVariableName = map.get(typeVariable);
        if (typeVariableName != null) {
            return typeVariableName;
        }
        ArrayList arrayList = new ArrayList();
        TypeVariableName typeVariableName2 = new TypeVariableName(typeVariable.getName(), Collections.unmodifiableList(arrayList));
        map.put(typeVariable, typeVariableName2);
        for (Type type : typeVariable.getBounds()) {
            arrayList.add(TypeName.get(type, map));
        }
        arrayList.remove(TypeName.OBJECT);
        return typeVariableName2;
    }
}
