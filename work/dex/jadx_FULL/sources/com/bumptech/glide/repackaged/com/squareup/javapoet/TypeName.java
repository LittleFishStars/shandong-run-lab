package com.bumptech.glide.repackaged.com.squareup.javapoet;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TypeName {
    public final List<AnnotationSpec> annotations;
    private String cachedString;
    private final String keyword;
    public static final TypeName VOID = new TypeName("void");
    public static final TypeName BOOLEAN = new TypeName(TypedValues.Custom.S_BOOLEAN);
    public static final TypeName BYTE = new TypeName("byte");
    public static final TypeName SHORT = new TypeName("short");
    public static final TypeName INT = new TypeName("int");
    public static final TypeName LONG = new TypeName("long");
    public static final TypeName CHAR = new TypeName("char");
    public static final TypeName FLOAT = new TypeName(TypedValues.Custom.S_FLOAT);
    public static final TypeName DOUBLE = new TypeName("double");
    public static final ClassName OBJECT = ClassName.get("java.lang", "Object", new String[0]);
    private static final ClassName BOXED_VOID = ClassName.get("java.lang", "Void", new String[0]);
    private static final ClassName BOXED_BOOLEAN = ClassName.get("java.lang", "Boolean", new String[0]);
    private static final ClassName BOXED_BYTE = ClassName.get("java.lang", "Byte", new String[0]);
    private static final ClassName BOXED_SHORT = ClassName.get("java.lang", "Short", new String[0]);
    private static final ClassName BOXED_INT = ClassName.get("java.lang", "Integer", new String[0]);
    private static final ClassName BOXED_LONG = ClassName.get("java.lang", "Long", new String[0]);
    private static final ClassName BOXED_CHAR = ClassName.get("java.lang", "Character", new String[0]);
    private static final ClassName BOXED_FLOAT = ClassName.get("java.lang", "Float", new String[0]);
    private static final ClassName BOXED_DOUBLE = ClassName.get("java.lang", "Double", new String[0]);

    /* JADX INFO: renamed from: com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$javax$lang$model$type$TypeKind;

        static {
            int[] iArr = new int[TypeKind.values().length];
            $SwitchMap$javax$lang$model$type$TypeKind = iArr;
            try {
                iArr[TypeKind.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.CHAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private TypeName(String str) {
        this(str, new ArrayList());
    }

    public static TypeName arrayComponent(TypeName typeName) {
        if (typeName instanceof ArrayTypeName) {
            return ((ArrayTypeName) typeName).componentType;
        }
        return null;
    }

    public static TypeName get(TypeMirror typeMirror) {
        return get(typeMirror, new LinkedHashMap());
    }

    public static List<TypeName> list(Type[] typeArr, Map<Type, TypeVariableName> map) {
        ArrayList arrayList = new ArrayList(typeArr.length);
        for (Type type : typeArr) {
            arrayList.add(get(type, map));
        }
        return arrayList;
    }

    public final TypeName annotated(AnnotationSpec... annotationSpecArr) {
        return annotated(Arrays.asList(annotationSpecArr));
    }

    public final List<AnnotationSpec> concatAnnotations(List<AnnotationSpec> list) {
        ArrayList arrayList = new ArrayList(this.annotations);
        arrayList.addAll(list);
        return arrayList;
    }

    public CodeWriter emit(CodeWriter codeWriter) throws IOException {
        String str = this.keyword;
        if (str != null) {
            return codeWriter.emitAndIndent(str);
        }
        throw new AssertionError();
    }

    public CodeWriter emitAnnotations(CodeWriter codeWriter) throws IOException {
        Iterator<AnnotationSpec> it = this.annotations.iterator();
        while (it.hasNext()) {
            it.next().emit(codeWriter, true);
            codeWriter.emit(" ");
        }
        return codeWriter;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public boolean isAnnotated() {
        return !this.annotations.isEmpty();
    }

    public boolean isBoxedPrimitive() {
        return equals(BOXED_BOOLEAN) || equals(BOXED_BYTE) || equals(BOXED_SHORT) || equals(BOXED_INT) || equals(BOXED_LONG) || equals(BOXED_CHAR) || equals(BOXED_FLOAT) || equals(BOXED_DOUBLE);
    }

    public boolean isPrimitive() {
        return (this.keyword == null || this == VOID) ? false : true;
    }

    public final String toString() {
        String str = this.cachedString;
        if (str != null) {
            return str;
        }
        try {
            StringBuilder sb = new StringBuilder();
            CodeWriter codeWriter = new CodeWriter(sb);
            emitAnnotations(codeWriter);
            emit(codeWriter);
            String string = sb.toString();
            this.cachedString = string;
            return string;
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public TypeName withoutAnnotations() {
        return new TypeName(this.keyword);
    }

    private TypeName(String str, List<AnnotationSpec> list) {
        this.keyword = str;
        this.annotations = Util.immutableList(list);
    }

    public static TypeName get(TypeMirror typeMirror, final Map<TypeParameterElement, TypeVariableName> map) {
        return (TypeName) typeMirror.accept(new SimpleTypeVisitor7<TypeName, Void>() { // from class: com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName.1
            public TypeName defaultAction(TypeMirror typeMirror2, Void r4) {
                throw new IllegalArgumentException("Unexpected type mirror: " + typeMirror2);
            }

            public ArrayTypeName visitArray(ArrayType arrayType, Void r2) {
                return ArrayTypeName.get(arrayType, (Map<TypeParameterElement, TypeVariableName>) map);
            }

            public TypeName visitDeclared(DeclaredType declaredType, Void r7) {
                ClassName className = ClassName.get(declaredType.asElement());
                TypeMirror enclosingType = declaredType.getEnclosingType();
                TypeName typeName = (enclosingType.getKind() == TypeKind.NONE || declaredType.asElement().getModifiers().contains(Modifier.STATIC)) ? null : (TypeName) enclosingType.accept(this, (Object) null);
                if (declaredType.getTypeArguments().isEmpty() && !(typeName instanceof ParameterizedTypeName)) {
                    return className;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = declaredType.getTypeArguments().iterator();
                while (it.hasNext()) {
                    arrayList.add(TypeName.get((TypeMirror) it.next(), (Map<TypeParameterElement, TypeVariableName>) map));
                }
                return typeName instanceof ParameterizedTypeName ? ((ParameterizedTypeName) typeName).nestedClass(className.simpleName(), arrayList) : new ParameterizedTypeName(null, className, arrayList);
            }

            public TypeName visitError(ErrorType errorType, Void r2) {
                return visitDeclared((DeclaredType) errorType, r2);
            }

            public TypeName visitNoType(NoType noType, Void r4) {
                return noType.getKind() == TypeKind.VOID ? TypeName.VOID : (TypeName) super.visitUnknown(noType, r4);
            }

            public TypeName visitPrimitive(PrimitiveType primitiveType, Void r2) {
                switch (AnonymousClass2.$SwitchMap$javax$lang$model$type$TypeKind[primitiveType.getKind().ordinal()]) {
                    case 1:
                        return TypeName.BOOLEAN;
                    case 2:
                        return TypeName.BYTE;
                    case 3:
                        return TypeName.SHORT;
                    case 4:
                        return TypeName.INT;
                    case 5:
                        return TypeName.LONG;
                    case 6:
                        return TypeName.CHAR;
                    case 7:
                        return TypeName.FLOAT;
                    case 8:
                        return TypeName.DOUBLE;
                    default:
                        throw new AssertionError();
                }
            }

            public TypeName visitTypeVariable(TypeVariable typeVariable, Void r2) {
                return TypeVariableName.get(typeVariable, (Map<TypeParameterElement, TypeVariableName>) map);
            }

            public TypeName visitWildcard(WildcardType wildcardType, Void r2) {
                return WildcardTypeName.get(wildcardType, (Map<TypeParameterElement, TypeVariableName>) map);
            }
        }, (Object) null);
    }

    public TypeName annotated(List<AnnotationSpec> list) {
        Util.checkNotNull(list, "annotations == null", new Object[0]);
        return new TypeName(this.keyword, concatAnnotations(list));
    }

    public static TypeName get(Type type) {
        return get(type, new LinkedHashMap());
    }

    public static TypeName get(Type type, Map<Type, TypeVariableName> map) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (type == Void.TYPE) {
                return VOID;
            }
            if (type == Boolean.TYPE) {
                return BOOLEAN;
            }
            if (type == Byte.TYPE) {
                return BYTE;
            }
            if (type == Short.TYPE) {
                return SHORT;
            }
            if (type == Integer.TYPE) {
                return INT;
            }
            if (type == Long.TYPE) {
                return LONG;
            }
            if (type == Character.TYPE) {
                return CHAR;
            }
            if (type == Float.TYPE) {
                return FLOAT;
            }
            if (type == Double.TYPE) {
                return DOUBLE;
            }
            return cls.isArray() ? ArrayTypeName.of(get(cls.getComponentType(), map)) : ClassName.get((Class<?>) cls);
        }
        if (type instanceof ParameterizedType) {
            return ParameterizedTypeName.get((ParameterizedType) type, map);
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            return WildcardTypeName.get((java.lang.reflect.WildcardType) type, map);
        }
        if (type instanceof java.lang.reflect.TypeVariable) {
            return TypeVariableName.get((java.lang.reflect.TypeVariable<?>) type, map);
        }
        if (type instanceof GenericArrayType) {
            return ArrayTypeName.get((GenericArrayType) type, map);
        }
        throw new IllegalArgumentException("unexpected type: " + type);
    }

    public TypeName(List<AnnotationSpec> list) {
        this(null, list);
    }
}
