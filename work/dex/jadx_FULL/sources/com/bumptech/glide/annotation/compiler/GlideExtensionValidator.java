package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.repackaged.com.google.common.base.Function;
import com.bumptech.glide.repackaged.com.google.common.collect.FluentIterable;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ClassName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class GlideExtensionValidator {
    private final ProcessingEnvironment processingEnvironment;
    private final ProcessorUtil processorUtil;

    public GlideExtensionValidator(ProcessingEnvironment processingEnvironment, ProcessorUtil processorUtil) {
        this.processingEnvironment = processingEnvironment;
        this.processorUtil = processorUtil;
    }

    private static List<String> getComparableParameterNames(ExecutableElement executableElement, boolean z) {
        List parameters = executableElement.getParameters();
        if (z) {
            parameters = parameters.subList(1, parameters.size());
        }
        ArrayList arrayList = new ArrayList(parameters.size());
        Iterator it = parameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((VariableElement) it.next()).asType().toString());
        }
        return arrayList;
    }

    private static String getEnclosingClassName(Element element) {
        return element.getEnclosingElement().toString();
    }

    private String getGlideTypeValue(ExecutableElement executableElement) {
        return this.processorUtil.findClassValuesFromAnnotationOnClassAsNames(executableElement, GlideType.class).iterator().next();
    }

    private static String getName(Element element) {
        return element.toString();
    }

    private static String getQualifiedMethodName(ExecutableElement executableElement) {
        return getEnclosingClassName(executableElement) + "#" + getName(executableElement);
    }

    private static boolean isBaseRequestOptions(TypeMirror typeMirror) {
        return typeMirror.toString().equals("com.bumptech.glide.request.BaseRequestOptions<?>");
    }

    private boolean isMethodInBaseRequestOptions(ExecutableElement executableElement) {
        TypeElement typeElement = this.processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.request.BaseRequestOptions");
        List<String> comparableParameterNames = getComparableParameterNames(executableElement, true);
        String string = executableElement.getSimpleName().toString();
        for (ExecutableElement executableElement2 : typeElement.getEnclosedElements()) {
            if (executableElement2.getKind() == ElementKind.METHOD) {
                ExecutableElement executableElement3 = executableElement2;
                if (string.equals(executableElement3.getSimpleName().toString()) && getComparableParameterNames(executableElement3, false).equals(comparableParameterNames)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isRequestBuilder(TypeMirror typeMirror) {
        return this.processingEnvironment.getTypeUtils().erasure(typeMirror).toString().equals("com.bumptech.glide.RequestBuilder");
    }

    private boolean typeMatchesExpected(TypeMirror typeMirror, ExecutableElement executableElement) {
        if (!(typeMirror instanceof DeclaredType)) {
            return false;
        }
        List typeArguments = ((DeclaredType) typeMirror).getTypeArguments();
        if (typeArguments.size() != 1) {
            return false;
        }
        TypeMirror typeMirror2 = (TypeMirror) typeArguments.get(0);
        return typeMirror2.toString().equals(getGlideTypeValue(executableElement));
    }

    private void validateAnnotatedNonNull(ExecutableElement executableElement) {
        boolean z;
        ImmutableSet set = FluentIterable.from(executableElement.getAnnotationMirrors()).transform(new Function<AnnotationMirror, String>() { // from class: com.bumptech.glide.annotation.compiler.GlideExtensionValidator.1
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Function
            public String apply(AnnotationMirror annotationMirror) {
                return annotationMirror.getAnnotationType().asElement().toString();
            }
        }).toSet();
        Iterator<ClassName> it = ProcessorUtil.nonNulls().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (set.contains(it.next().reflectionName())) {
                z = false;
                break;
            }
        }
        if (z) {
            this.processingEnvironment.getMessager().printMessage(Diagnostic.Kind.WARNING, getQualifiedMethodName(executableElement) + " is missing the " + this.processorUtil.nonNull().reflectionName() + " annotation, please add it to ensure that your extension methods are always returning non-null values");
        }
    }

    private static void validateExtensionConstructor(Element element) {
        if (!element.getModifiers().contains(Modifier.PRIVATE)) {
            throw new IllegalArgumentException("RequestOptionsExtensions must be public, with private constructors and only static methods. Found a non-private constructor in: " + getEnclosingClassName(element));
        }
        if (((ExecutableElement) element).getParameters().isEmpty()) {
            return;
        }
        throw new IllegalArgumentException("RequestOptionsExtensions must be public, with private constructors and only static methods. Found parameters in the constructor of: " + getEnclosingClassName(element));
    }

    private void validateGlideOption(ExecutableElement executableElement) {
        validateGlideOptionAnnotations(executableElement);
        validateGlideOptionParameters(executableElement);
        TypeMirror returnType = executableElement.getReturnType();
        if (isBaseRequestOptions(returnType)) {
            validateGlideOptionOverride(executableElement);
            return;
        }
        throw new IllegalArgumentException("@GlideOption methods should return a BaseRequestOptions<?> object, but " + getQualifiedMethodName(executableElement) + " returns " + returnType + ". If you're using old style @GlideOption methods, your method may have a void return type, but doing so is deprecated and support will be removed in a future version");
    }

    private void validateGlideOptionAnnotations(ExecutableElement executableElement) {
        validateAnnotatedNonNull(executableElement);
    }

    private void validateGlideOptionOverride(ExecutableElement executableElement) {
        int overrideType = this.processorUtil.getOverrideType(executableElement);
        boolean zIsMethodInBaseRequestOptions = isMethodInBaseRequestOptions(executableElement);
        if (zIsMethodInBaseRequestOptions && overrideType == 0) {
            throw new IllegalArgumentException("Accidentally attempting to override a method in BaseRequestOptions. Add an 'override' value in the @GlideOption annotation if this is intentional. Offending method: " + getQualifiedMethodName(executableElement));
        }
        if (zIsMethodInBaseRequestOptions || overrideType == 0) {
            return;
        }
        throw new IllegalArgumentException("Requested to override an existing method in BaseRequestOptions, but no such method was found. Offending method: " + getQualifiedMethodName(executableElement));
    }

    private static void validateGlideOptionParameters(ExecutableElement executableElement) {
        if (executableElement.getParameters().isEmpty()) {
            throw new IllegalArgumentException("@GlideOption methods must take a BaseRequestOptions<?> object as their first parameter, but " + getQualifiedMethodName(executableElement) + " has none");
        }
        TypeMirror typeMirrorAsType = ((VariableElement) executableElement.getParameters().get(0)).asType();
        if (isBaseRequestOptions(typeMirrorAsType)) {
            return;
        }
        throw new IllegalArgumentException("@GlideOption methods must take a BaseRequestOptions<?> object as their first parameter, but the first parameter in " + getQualifiedMethodName(executableElement) + " is " + typeMirrorAsType);
    }

    private void validateGlideType(ExecutableElement executableElement) {
        TypeMirror returnType = executableElement.getReturnType();
        validateGlideTypeAnnotations(executableElement);
        if (isRequestBuilder(returnType) && typeMatchesExpected(returnType, executableElement)) {
            validateGlideTypeParameters(executableElement);
            return;
        }
        throw new IllegalArgumentException("@GlideType methods should return a RequestBuilder<" + getGlideTypeValue(executableElement) + "> object, but " + getQualifiedMethodName(executableElement) + " returns: " + returnType + ". If you're using old style @GlideType methods, your method may have a void return type, but doing so is deprecated and support will be removed in a future version");
    }

    private void validateGlideTypeAnnotations(ExecutableElement executableElement) {
        validateAnnotatedNonNull(executableElement);
    }

    private static void validateGlideTypeParameters(ExecutableElement executableElement) {
        if (executableElement.getParameters().size() != 1) {
            throw new IllegalArgumentException("@GlideType methods must take a RequestBuilder object as their first and only parameter, but given multiple for: " + getQualifiedMethodName(executableElement));
        }
        TypeMirror typeMirrorAsType = ((VariableElement) executableElement.getParameters().get(0)).asType();
        if (typeMirrorAsType.toString().startsWith("com.bumptech.glide.RequestBuilder")) {
            return;
        }
        throw new IllegalArgumentException("@GlideType methods must take a RequestBuilder object as their first and only parameter, but given: " + typeMirrorAsType + " for: " + getQualifiedMethodName(executableElement));
    }

    public void validateExtension(TypeElement typeElement) {
        if (!typeElement.getModifiers().contains(Modifier.PUBLIC)) {
            throw new IllegalArgumentException("RequestOptionsExtensions must be public, including: " + getName(typeElement));
        }
        for (Element element : typeElement.getEnclosedElements()) {
            if (element.getKind() == ElementKind.CONSTRUCTOR) {
                validateExtensionConstructor(element);
            } else if (element.getKind() == ElementKind.METHOD) {
                ExecutableElement executableElement = (ExecutableElement) element;
                if (executableElement.getAnnotation(GlideOption.class) != null) {
                    validateGlideOption(executableElement);
                } else if (executableElement.getAnnotation(GlideType.class) != null) {
                    validateGlideType(executableElement);
                }
            }
        }
    }
}
