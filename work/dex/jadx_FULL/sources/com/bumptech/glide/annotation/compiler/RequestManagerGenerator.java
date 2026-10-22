package com.bumptech.glide.annotation.compiler;

import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.repackaged.com.google.common.base.Function;
import com.bumptech.glide.repackaged.com.google.common.base.Predicate;
import com.bumptech.glide.repackaged.com.google.common.base.Predicates;
import com.bumptech.glide.repackaged.com.google.common.collect.FluentIterable;
import com.bumptech.glide.repackaged.com.google.common.collect.Lists;
import com.bumptech.glide.repackaged.com.squareup.javapoet.AnnotationSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ClassName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.MethodSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ParameterSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ParameterizedTypeName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeVariableName;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class RequestManagerGenerator {
    private static final ClassName CONTEXT_CLASS_NAME = ClassName.get("android.content", "Context", new String[0]);
    private ClassName generatedRequestBuilderClassName;
    private final TypeElement glideType;
    private final TypeElement lifecycleType;
    private ProcessingEnvironment processingEnv;
    private final ProcessorUtil processorUtil;
    private final TypeElement requestBuilderType;
    private final ClassName requestManagerClassName;
    private final TypeElement requestManagerTreeNodeType;
    private final TypeElement requestManagerType;

    public RequestManagerGenerator(ProcessingEnvironment processingEnvironment, ProcessorUtil processorUtil) {
        this.processingEnv = processingEnvironment;
        this.processorUtil = processorUtil;
        Elements elementUtils = processingEnvironment.getElementUtils();
        TypeElement typeElement = elementUtils.getTypeElement("com.bumptech.glide.RequestManager");
        this.requestManagerType = typeElement;
        this.requestManagerClassName = ClassName.get(typeElement);
        this.lifecycleType = elementUtils.getTypeElement("com.bumptech.glide.manager.Lifecycle");
        this.requestManagerTreeNodeType = elementUtils.getTypeElement("com.bumptech.glide.manager.RequestManagerTreeNode");
        this.requestBuilderType = elementUtils.getTypeElement("com.bumptech.glide.RequestBuilder");
        this.glideType = elementUtils.getTypeElement("com.bumptech.glide.Glide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MethodSpec generateAdditionalRequestManagerMethod(ExecutableElement executableElement) {
        return executableElement.getReturnType().getKind() == TypeKind.VOID ? generateAdditionalRequestManagerMethodLegacy(executableElement) : generateAdditionalRequestManagerMethodNew(executableElement);
    }

    private MethodSpec generateAdditionalRequestManagerMethodLegacy(ExecutableElement executableElement) {
        ClassName classNameBestGuess = ClassName.bestGuess(this.processorUtil.findClassValuesFromAnnotationOnClassAsNames(executableElement, GlideType.class).iterator().next());
        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.get(this.generatedRequestBuilderClassName, classNameBestGuess);
        return MethodSpec.methodBuilder(executableElement.getSimpleName().toString()).addModifiers(Modifier.PUBLIC).returns(parameterizedTypeName).addJavadoc(this.processorUtil.generateSeeMethodJavadoc(executableElement)).addAnnotation(this.processorUtil.nonNull()).addAnnotation(this.processorUtil.checkResult()).addStatement("$T requestBuilder = this.as($T.class)", parameterizedTypeName, classNameBestGuess).addStatement("$T.$N(requestBuilder)", executableElement.getEnclosingElement(), executableElement.getSimpleName()).addStatement("return requestBuilder", new Object[0]).build();
    }

    private MethodSpec generateAdditionalRequestManagerMethodNew(ExecutableElement executableElement) {
        ClassName classNameBestGuess = ClassName.bestGuess(this.processorUtil.findClassValuesFromAnnotationOnClassAsNames(executableElement, GlideType.class).iterator().next());
        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.get(this.generatedRequestBuilderClassName, classNameBestGuess);
        return MethodSpec.methodBuilder(executableElement.getSimpleName().toString()).addModifiers(Modifier.PUBLIC).returns(parameterizedTypeName).addJavadoc(this.processorUtil.generateSeeMethodJavadoc(executableElement)).addAnnotation(this.processorUtil.nonNull()).addAnnotation(this.processorUtil.checkResult()).addStatement("return ($T) $T.$N(this.as($T.class))", parameterizedTypeName, executableElement.getEnclosingElement(), executableElement.getSimpleName(), classNameBestGuess).build();
    }

    private MethodSpec generateAsMethod(String str, TypeSpec typeSpec) {
        TypeVariableName typeVariableName = TypeVariableName.get("ResourceType");
        return MethodSpec.methodBuilder("as").addModifiers(Modifier.PUBLIC).addAnnotation(Override.class).addAnnotation(this.processorUtil.checkResult()).addAnnotation(this.processorUtil.nonNull()).addTypeVariable(TypeVariableName.get("ResourceType")).returns(ParameterizedTypeName.get(ClassName.get(str, typeSpec.name, new String[0]), typeVariableName)).addParameter(ParameterizedTypeName.get(ClassName.get((Class<?>) Class.class), typeVariableName).annotated(AnnotationSpec.builder(this.processorUtil.nonNull()).build()), "resourceClass", new Modifier[0]).addStatement("return new $T<>(glide, this, resourceClass, context)", this.generatedRequestBuilderClassName).build();
    }

    private MethodSpec generateCallSuperConstructor() {
        return MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).addParameter(ParameterSpec.builder(ClassName.get(this.glideType), "glide", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(ClassName.get(this.lifecycleType), RequestParameters.SUBRESOURCE_LIFECYCLE, new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(ClassName.get(this.requestManagerTreeNodeType), "treeNode", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(CONTEXT_CLASS_NAME, "context", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addStatement("super(glide, lifecycle, treeNode, context)", new Object[0]).build();
    }

    private List<MethodSpec> generateExtensionRequestManagerMethods(Set<String> set) {
        return Lists.transform(this.processorUtil.findAnnotatedElementsInClasses(set, GlideType.class), new Function<ExecutableElement, MethodSpec>() { // from class: com.bumptech.glide.annotation.compiler.RequestManagerGenerator.4
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Function
            public MethodSpec apply(ExecutableElement executableElement) {
                return RequestManagerGenerator.this.generateAdditionalRequestManagerMethod(executableElement);
            }
        });
    }

    private MethodSpec generateOverrideSetRequestOptions(String str, TypeSpec typeSpec) {
        if (typeSpec == null) {
            return null;
        }
        TypeElement typeElement = this.processingEnv.getElementUtils().getTypeElement("com.bumptech.glide.request.RequestOptions");
        String str2 = str + Consts.DOT + typeSpec.name;
        return MethodSpec.methodBuilder("setRequestOptions").addAnnotation(Override.class).addModifiers(Modifier.PROTECTED).addParameter(ParameterSpec.builder(ClassName.get(typeElement), "toSet", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).beginControlFlow("if ($N instanceof $L)", "toSet", str2).addStatement("super.$N($N)", "setRequestOptions", "toSet").nextControlFlow("else", new Object[0]).addStatement("super.setRequestOptions(new $L().apply($N))", str2, "toSet").endControlFlow().build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MethodSpec generateRequestManagerRequestBuilderMethodOverride(ExecutableElement executableElement) {
        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.get(this.generatedRequestBuilderClassName, TypeName.get((TypeMirror) executableElement.getReturnType().getTypeArguments().get(0)));
        MethodSpec.Builder builderReturns = this.processorUtil.overriding(executableElement).returns(parameterizedTypeName);
        builderReturns.addCode(ProcessorUtil.generateCastingSuperCall(parameterizedTypeName, builderReturns.build()));
        Iterator it = executableElement.getAnnotationMirrors().iterator();
        while (it.hasNext()) {
            builderReturns.addAnnotation(AnnotationSpec.get((AnnotationMirror) it.next()));
        }
        return builderReturns.build();
    }

    private List<MethodSpec> generateRequestManagerRequestBuilderMethodOverrides() {
        return FluentIterable.from(this.processorUtil.findInstanceMethodsReturning(this.requestManagerType, this.processingEnv.getTypeUtils().erasure(this.requestBuilderType.asType()))).filter(new Predicate<ExecutableElement>() { // from class: com.bumptech.glide.annotation.compiler.RequestManagerGenerator.3
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Predicate
            public boolean apply(ExecutableElement executableElement) {
                return !executableElement.getSimpleName().toString().equals("as");
            }
        }).transform(new Function<ExecutableElement, MethodSpec>() { // from class: com.bumptech.glide.annotation.compiler.RequestManagerGenerator.2
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Function
            public MethodSpec apply(ExecutableElement executableElement) {
                return RequestManagerGenerator.this.generateRequestManagerRequestBuilderMethodOverride(executableElement);
            }
        }).toList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MethodSpec generateRequestManagerRequestManagerMethodOverride(String str, ExecutableElement executableElement) {
        ClassName className = ClassName.get(str, "GlideRequests", new String[0]);
        MethodSpec.Builder builderReturns = this.processorUtil.overriding(executableElement).addAnnotation(this.processorUtil.nonNull()).returns(className);
        return builderReturns.addCode(ProcessorUtil.generateCastingSuperCall(className, builderReturns.build())).build();
    }

    private List<MethodSpec> generateRequestManagerRequestManagerMethodOverrides(final String str) {
        ProcessorUtil processorUtil = this.processorUtil;
        TypeElement typeElement = this.requestManagerType;
        return FluentIterable.from(processorUtil.findInstanceMethodsReturning(typeElement, typeElement)).transform(new Function<ExecutableElement, MethodSpec>() { // from class: com.bumptech.glide.annotation.compiler.RequestManagerGenerator.1
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Function
            public MethodSpec apply(ExecutableElement executableElement) {
                return RequestManagerGenerator.this.generateRequestManagerRequestManagerMethodOverride(str, executableElement);
            }
        }).toList();
    }

    public TypeSpec generate(String str, TypeSpec typeSpec, TypeSpec typeSpec2, Set<String> set) {
        this.generatedRequestBuilderClassName = ClassName.get(str, typeSpec2.name, new String[0]);
        return TypeSpec.classBuilder("GlideRequests").superclass(this.requestManagerClassName).addJavadoc("Includes all additions from methods in {@link $T}s\nannotated with {@link $T}\n\n<p>Generated code, do not modify\n", GlideExtension.class, GlideType.class).addAnnotation(AnnotationSpec.builder((Class<?>) SuppressWarnings.class).addMember("value", "$S", "deprecation").build()).addModifiers(Modifier.PUBLIC).addMethod(generateAsMethod(str, typeSpec2)).addMethod(generateCallSuperConstructor()).addMethods(generateExtensionRequestManagerMethods(set)).addMethods(generateRequestManagerRequestManagerMethodOverrides(str)).addMethods(generateRequestManagerRequestBuilderMethodOverrides()).addMethods(FluentIterable.from(Collections.singletonList(generateOverrideSetRequestOptions(str, typeSpec))).filter(Predicates.notNull())).build();
    }
}
