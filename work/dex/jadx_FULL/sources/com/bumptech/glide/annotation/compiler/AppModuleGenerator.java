package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.Excludes;
import com.bumptech.glide.repackaged.com.squareup.javapoet.AnnotationSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ClassName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.MethodSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ParameterSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ParameterizedTypeName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.WildcardTypeName;
import com.ipd.dsp.internal.h1.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class AppModuleGenerator {
    private final ProcessingEnvironment processingEnv;
    private final ProcessorUtil processorUtil;

    public AppModuleGenerator(ProcessingEnvironment processingEnvironment, ProcessorUtil processorUtil) {
        this.processingEnv = processingEnvironment;
        this.processorUtil = processorUtil;
    }

    private boolean doesAppGlideModuleConstructorAcceptContext(ClassName className) {
        for (ExecutableElement executableElement : this.processingEnv.getElementUtils().getTypeElement(className.reflectionName()).getEnclosedElements()) {
            if (executableElement.getKind() == ElementKind.CONSTRUCTOR) {
                List parameters = executableElement.getParameters();
                if (parameters.isEmpty()) {
                    return false;
                }
                if (parameters.size() > 1) {
                    throw new IllegalStateException("Constructor for " + className + " accepts too many parameters, it should accept no parameters, or a single Context");
                }
                TypeMirror typeMirrorAsType = ((VariableElement) parameters.get(0)).asType();
                if (this.processingEnv.getTypeUtils().isSameType(typeMirrorAsType, this.processingEnv.getElementUtils().getTypeElement("android.content.Context").asType())) {
                    return true;
                }
                throw new IllegalStateException("Unrecognized type: " + typeMirrorAsType);
            }
        }
        return false;
    }

    private MethodSpec generateConstructor(ClassName className, Collection<String> collection, Collection<String> collection2) {
        MethodSpec.Builder builderAddParameter = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).addParameter(ParameterSpec.builder(ClassName.get("android.content", "Context", new String[0]), "context", new Modifier[0]).build());
        if (doesAppGlideModuleConstructorAcceptContext(className)) {
            builderAddParameter.addStatement("appGlideModule = new $T(context)", className);
        } else {
            builderAddParameter.addStatement("appGlideModule = new $T()", className);
        }
        ClassName className2 = ClassName.get("android.util", a.f38319a, new String[0]);
        builderAddParameter.beginControlFlow("if ($T.isLoggable($S, $T.DEBUG))", className2, "Glide", className2);
        builderAddParameter.addStatement("$T.d($S, $S)", className2, "Glide", "Discovered AppGlideModule from annotation: " + className);
        for (String str : collection) {
            if (collection2.contains(str)) {
                builderAddParameter.addStatement("$T.d($S, $S)", className2, "Glide", "AppGlideModule excludes LibraryGlideModule from annotation: " + str);
            } else {
                builderAddParameter.addStatement("$T.d($S, $S)", className2, "Glide", "Discovered LibraryGlideModule from annotation: " + str);
            }
        }
        builderAddParameter.endControlFlow();
        return builderAddParameter.build();
    }

    private MethodSpec generateGetExcludedModuleClasses(Collection<String> collection) {
        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.get(ClassName.get((Class<?>) Class.class), WildcardTypeName.subtypeOf(Object.class));
        ParameterizedTypeName parameterizedTypeName2 = ParameterizedTypeName.get(ClassName.get((Class<?>) Set.class), parameterizedTypeName);
        ParameterizedTypeName parameterizedTypeName3 = ParameterizedTypeName.get(ClassName.get((Class<?>) HashSet.class), parameterizedTypeName);
        MethodSpec.Builder builderReturns = MethodSpec.methodBuilder("getExcludedModuleClasses").addModifiers(Modifier.PUBLIC).addAnnotation(Override.class).addAnnotation(this.processorUtil.nonNull()).returns(parameterizedTypeName2);
        if (collection.isEmpty()) {
            builderReturns.addStatement("return $T.emptySet()", Collections.class);
        } else {
            builderReturns.addStatement("$T excludedClasses = new $T()", parameterizedTypeName2, parameterizedTypeName3);
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                builderReturns.addStatement("excludedClasses.add($L.class)", it.next());
            }
            builderReturns.addStatement("return excludedClasses", new Object[0]);
        }
        return builderReturns.build();
    }

    private MethodSpec generateRegisterComponents(Collection<String> collection, Collection<String> collection2) {
        MethodSpec.Builder builderAddParameter = MethodSpec.methodBuilder("registerComponents").addModifiers(Modifier.PUBLIC).addAnnotation(Override.class).addParameter(ParameterSpec.builder(ClassName.get("android.content", "Context", new String[0]), "context", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(ClassName.get("com.bumptech.glide", "Glide", new String[0]), "glide", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(ClassName.get("com.bumptech.glide", "Registry", new String[0]), "registry", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build());
        for (String str : collection) {
            if (!collection2.contains(str)) {
                builderAddParameter.addStatement("new $T().registerComponents(context, glide, registry)", ClassName.bestGuess(str));
            }
        }
        builderAddParameter.addStatement("appGlideModule.registerComponents(context, glide, registry)", new Object[0]);
        return builderAddParameter.build();
    }

    private List<String> getExcludedGlideModuleClassNames(TypeElement typeElement) {
        ArrayList arrayList = new ArrayList(this.processorUtil.findClassValuesFromAnnotationOnClassAsNames(typeElement, Excludes.class));
        Collections.sort(arrayList);
        return arrayList;
    }

    public TypeSpec generate(TypeElement typeElement, Set<String> set) {
        ClassName className = ClassName.get(typeElement);
        List<String> excludedGlideModuleClassNames = getExcludedGlideModuleClassNames(typeElement);
        ArrayList arrayList = new ArrayList(set);
        Collections.sort(arrayList);
        MethodSpec methodSpecGenerateConstructor = generateConstructor(className, arrayList, excludedGlideModuleClassNames);
        TypeSpec.Builder builderAddMethod = TypeSpec.classBuilder("GeneratedAppGlideModuleImpl").addModifiers(Modifier.FINAL).addAnnotation(AnnotationSpec.builder((Class<?>) SuppressWarnings.class).addMember("value", "$S", "deprecation").build()).superclass(ClassName.get("com.bumptech.glide", "GeneratedAppGlideModule", new String[0])).addField(className, "appGlideModule", Modifier.PRIVATE, Modifier.FINAL).addMethod(methodSpecGenerateConstructor).addMethod(MethodSpec.methodBuilder("applyOptions").addModifiers(Modifier.PUBLIC).addAnnotation(Override.class).addParameter(ParameterSpec.builder(ClassName.get("android.content", "Context", new String[0]), "context", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(ClassName.get("com.bumptech.glide", "GlideBuilder", new String[0]), "builder", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addStatement("appGlideModule.applyOptions(context, builder)", typeElement).build()).addMethod(generateRegisterComponents(arrayList, excludedGlideModuleClassNames)).addMethod(MethodSpec.methodBuilder("isManifestParsingEnabled").addModifiers(Modifier.PUBLIC).addAnnotation(Override.class).returns(Boolean.TYPE).addStatement("return appGlideModule.isManifestParsingEnabled()", typeElement).build()).addMethod(generateGetExcludedModuleClasses(excludedGlideModuleClassNames));
        ClassName className2 = ClassName.get("com.bumptech.glide", "GeneratedRequestManagerFactory", new String[0]);
        builderAddMethod.addMethod(MethodSpec.methodBuilder("getRequestManagerFactory").addAnnotation(Override.class).addAnnotation(this.processorUtil.nonNull()).returns(className2).addStatement("return new $T()", className2).build());
        return builderAddMethod.build();
    }
}
