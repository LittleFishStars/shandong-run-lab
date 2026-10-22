package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.repackaged.com.google.common.base.Function;
import com.bumptech.glide.repackaged.com.google.common.base.Joiner;
import com.bumptech.glide.repackaged.com.google.common.base.Predicate;
import com.bumptech.glide.repackaged.com.google.common.collect.FluentIterable;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet;
import com.bumptech.glide.repackaged.com.google.common.collect.Lists;
import com.bumptech.glide.repackaged.com.squareup.javapoet.AnnotationSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ClassName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.CodeBlock;
import com.bumptech.glide.repackaged.com.squareup.javapoet.MethodSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ParameterSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ParameterizedTypeName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeVariableName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.WildcardTypeName;
import com.ipd.dsp.internal.z.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class RequestBuilderGenerator {
    private static final ImmutableSet<String> EXCLUDED_METHODS_FROM_BASE_REQUEST_OPTIONS = ImmutableSet.of("clone", "apply");
    private ClassName generatedRequestBuilderClassName;
    private ParameterizedTypeName generatedRequestBuilderOfTranscodeType;
    private final ProcessingEnvironment processingEnv;
    private final ProcessorUtil processorUtil;
    private final TypeElement requestBuilderType;
    private ClassName requestOptionsClassName;
    private final TypeElement requestOptionsType;
    private final TypeVariableName transcodeTypeName = TypeVariableName.get("TranscodeType");

    public RequestBuilderGenerator(ProcessingEnvironment processingEnvironment, ProcessorUtil processorUtil) {
        this.processingEnv = processingEnvironment;
        this.processorUtil = processorUtil;
        this.requestBuilderType = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.RequestBuilder");
        this.requestOptionsType = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.request.RequestOptions");
    }

    private AnnotationSpec buildSuppressWarnings(MethodSpec methodSpec) {
        HashSet hashSet = new HashSet();
        if (methodSpec.annotations.contains(AnnotationSpec.builder((Class<?>) SuppressWarnings.class).build())) {
            for (AnnotationSpec annotationSpec : methodSpec.annotations) {
                if (annotationSpec.type.equals(TypeName.get(SuppressWarnings.class))) {
                    hashSet.addAll(FluentIterable.from(annotationSpec.members.get("value")).transform(new Function<CodeBlock, String>() { // from class: com.bumptech.glide.annotation.compiler.RequestBuilderGenerator.6
                        @Override // com.bumptech.glide.repackaged.com.google.common.base.Function
                        public String apply(CodeBlock codeBlock) {
                            return codeBlock.toString();
                        }
                    }).toSet());
                }
            }
        }
        if (methodSpec.annotations.contains(AnnotationSpec.builder((Class<?>) SafeVarargs.class).build())) {
            hashSet.add("unchecked");
            hashSet.add("varargs");
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        AnnotationSpec.Builder builder = AnnotationSpec.builder((Class<?>) SuppressWarnings.class);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            builder.addMember("value", "$S", (String) it.next());
        }
        return builder.build();
    }

    private List<MethodSpec> generateConstructors() {
        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.get(ClassName.get((Class<?>) Class.class), this.transcodeTypeName);
        return ImmutableList.of(MethodSpec.constructorBuilder().addParameter(ParameterSpec.builder(parameterizedTypeName, "transcodeClass", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(ParameterizedTypeName.get(ClassName.get(this.requestBuilderType), WildcardTypeName.subtypeOf(Object.class)), "other", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addStatement("super($N, $N)", "transcodeClass", "other").build(), MethodSpec.constructorBuilder().addParameter(ParameterSpec.builder(ClassName.get("com.bumptech.glide", "Glide", new String[0]), "glide", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(ClassName.get("com.bumptech.glide", "RequestManager", new String[0]), "requestManager", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(parameterizedTypeName, "transcodeClass", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addParameter(ParameterSpec.builder(ClassName.get("android.content", "Context", new String[0]), "context", new Modifier[0]).addAnnotation(this.processorUtil.nonNull()).build()).addStatement("super($N, $N ,$N, $N)", "glide", "requestManager", "transcodeClass", "context").build());
    }

    private MethodSpec generateDownloadOnlyRequestMethod() {
        return MethodSpec.methodBuilder("getDownloadOnlyRequest").addAnnotation(Override.class).addAnnotation(this.processorUtil.checkResult()).addAnnotation(this.processorUtil.nonNull()).returns(ParameterizedTypeName.get(this.generatedRequestBuilderClassName, ClassName.get((Class<?>) File.class))).addModifiers(Modifier.PROTECTED).addStatement("return new $T<>($T.class, $N).apply($N)", this.generatedRequestBuilderClassName, File.class, "this", "DOWNLOAD_ONLY_OPTIONS").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MethodSpec generateGeneratedRequestOptionEquivalent(MethodSpec methodSpec) {
        MethodSpec.Builder builderAddCode = MethodSpec.methodBuilder(methodSpec.name).addJavadoc(this.processorUtil.generateSeeMethodJavadoc(this.requestOptionsClassName, methodSpec)).addModifiers(Modifier.PUBLIC).varargs(methodSpec.varargs).addAnnotations(FluentIterable.from(methodSpec.annotations).filter(new Predicate<AnnotationSpec>() { // from class: com.bumptech.glide.annotation.compiler.RequestBuilderGenerator.5
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Predicate
            public boolean apply(AnnotationSpec annotationSpec) {
                return (annotationSpec.type.equals(TypeName.get(Override.class)) || annotationSpec.type.equals(TypeName.get(SafeVarargs.class)) || annotationSpec.type.equals(TypeName.get(SuppressWarnings.class))) ? false : true;
            }
        }).toList()).addTypeVariables(methodSpec.typeVariables).addParameters(methodSpec.parameters).returns(this.generatedRequestBuilderOfTranscodeType).addCode("return ($T) super", this.generatedRequestBuilderOfTranscodeType).addCode(CodeBlock.builder().add(".$N(", methodSpec.name).add(FluentIterable.from(methodSpec.parameters).transform(new Function<ParameterSpec, String>() { // from class: com.bumptech.glide.annotation.compiler.RequestBuilderGenerator.4
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Function
            public String apply(ParameterSpec parameterSpec) {
                return parameterSpec.name;
            }
        }).join(Joiner.on(", ")), new Object[0]).add(");\n", new Object[0]).build());
        AnnotationSpec annotationSpecBuildSuppressWarnings = buildSuppressWarnings(methodSpec);
        if (annotationSpecBuildSuppressWarnings != null) {
            builderAddCode.addAnnotation(annotationSpecBuildSuppressWarnings);
        }
        return builderAddCode.build();
    }

    private List<MethodSpec> generateGeneratedRequestOptionsEquivalents(final List<MethodSpec> list, TypeSpec typeSpec) {
        return typeSpec == null ? Collections.emptyList() : FluentIterable.from(typeSpec.methodSpecs).filter(new Predicate<MethodSpec>() { // from class: com.bumptech.glide.annotation.compiler.RequestBuilderGenerator.2
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Predicate
            public boolean apply(MethodSpec methodSpec) {
                return RequestBuilderGenerator.this.isUsefulGeneratedRequestOption(list, methodSpec);
            }
        }).transform(new Function<MethodSpec, MethodSpec>() { // from class: com.bumptech.glide.annotation.compiler.RequestBuilderGenerator.1
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Function
            public MethodSpec apply(MethodSpec methodSpec) {
                return RequestBuilderGenerator.this.generateGeneratedRequestOptionEquivalent(methodSpec);
            }
        }).toList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MethodSpec generateRequestBuilderOverride(ExecutableElement executableElement) {
        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.get(this.generatedRequestBuilderClassName, TypeName.get((TypeMirror) executableElement.getReturnType().getTypeArguments().get(0)));
        MethodSpec.Builder builderReturns = this.processorUtil.overriding(executableElement).returns(parameterizedTypeName);
        builderReturns.addCode(CodeBlock.builder().add("return ($T) super.$N(", parameterizedTypeName, executableElement.getSimpleName()).add(FluentIterable.from(builderReturns.build().parameters).transform(new Function<ParameterSpec, String>() { // from class: com.bumptech.glide.annotation.compiler.RequestBuilderGenerator.8
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Function
            public String apply(ParameterSpec parameterSpec) {
                return parameterSpec.name;
            }
        }).join(Joiner.on(", ")), new Object[0]).add(");\n", new Object[0]).build());
        Iterator it = executableElement.getAnnotationMirrors().iterator();
        while (it.hasNext()) {
            builderReturns = builderReturns.addAnnotation(AnnotationSpec.get((AnnotationMirror) it.next()));
        }
        if (executableElement.isVarArgs()) {
            builderReturns = builderReturns.addModifiers(Modifier.FINAL).addAnnotation(SafeVarargs.class).addAnnotation(AnnotationSpec.builder((Class<?>) SuppressWarnings.class).addMember("value", "$S", "varargs").build());
        }
        return builderReturns.build();
    }

    private List<MethodSpec> generateRequestBuilderOverrides() {
        return Lists.transform(this.processorUtil.findInstanceMethodsReturning(this.requestBuilderType, this.processingEnv.getTypeUtils().erasure(this.requestBuilderType.asType())), new Function<ExecutableElement, MethodSpec>() { // from class: com.bumptech.glide.annotation.compiler.RequestBuilderGenerator.7
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Function
            public MethodSpec apply(ExecutableElement executableElement) {
                return RequestBuilderGenerator.this.generateRequestBuilderOverride(executableElement);
            }
        });
    }

    private boolean isExtensionMethod(List<MethodSpec> list, final MethodSpec methodSpec) {
        return FluentIterable.from(list).anyMatch(new Predicate<MethodSpec>() { // from class: com.bumptech.glide.annotation.compiler.RequestBuilderGenerator.3
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Predicate
            public boolean apply(MethodSpec methodSpec2) {
                return methodSpec2.name.equals(methodSpec.name) && methodSpec2.parameters.equals(methodSpec.parameters);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUsefulGeneratedRequestOption(List<MethodSpec> list, MethodSpec methodSpec) {
        return (EXCLUDED_METHODS_FROM_BASE_REQUEST_OPTIONS.contains(methodSpec.name) || !methodSpec.hasModifier(Modifier.PUBLIC) || methodSpec.hasModifier(Modifier.STATIC) || !methodSpec.returnType.toString().equals(this.requestOptionsClassName.toString()) || isExtensionMethod(list, methodSpec)) ? false : true;
    }

    public TypeSpec generate(String str, Set<String> set, TypeSpec typeSpec) {
        if (typeSpec != null) {
            this.requestOptionsClassName = ClassName.get(str, typeSpec.name, new String[0]);
        } else {
            this.requestOptionsClassName = ClassName.get("com.bumptech.glide.request", "BaseRequestOptions", new String[0]);
        }
        ClassName className = ClassName.get(str, k.E, new String[0]);
        this.generatedRequestBuilderClassName = className;
        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.get(className, this.transcodeTypeName);
        this.generatedRequestBuilderOfTranscodeType = parameterizedTypeName;
        RequestOptionsExtensionGenerator requestOptionsExtensionGenerator = new RequestOptionsExtensionGenerator(parameterizedTypeName, this.processorUtil);
        ParameterizedTypeName parameterizedTypeName2 = ParameterizedTypeName.get(ClassName.get("com.bumptech.glide", "RequestBuilder", new String[0]), this.transcodeTypeName);
        List<MethodSpec> listGenerateInstanceMethodsForExtensions = requestOptionsExtensionGenerator.generateInstanceMethodsForExtensions(set);
        return TypeSpec.classBuilder(k.E).addJavadoc("Contains all public methods from {@link $T}, all options from\n", this.requestBuilderType).addJavadoc("{@link $T} and all generated options from\n", this.requestOptionsType).addJavadoc("{@link $T} in annotated methods in\n", GlideOption.class).addJavadoc("{@link $T} annotated classes.\n", GlideExtension.class).addJavadoc("\n", new Object[0]).addJavadoc("<p>Generated code, do not modify.\n", new Object[0]).addJavadoc("\n", new Object[0]).addJavadoc("@see $T\n", this.requestBuilderType).addJavadoc("@see $T\n", this.requestOptionsType).addAnnotation(AnnotationSpec.builder((Class<?>) SuppressWarnings.class).addMember("value", "$S", "unused").addMember("value", "$S", "deprecation").build()).addModifiers(Modifier.PUBLIC).addTypeVariable(this.transcodeTypeName).superclass(parameterizedTypeName2).addSuperinterface(Cloneable.class).addMethods(generateConstructors()).addMethod(generateDownloadOnlyRequestMethod()).addMethods(generateGeneratedRequestOptionsEquivalents(listGenerateInstanceMethodsForExtensions, typeSpec)).addMethods(generateRequestBuilderOverrides()).addMethods(listGenerateInstanceMethodsForExtensions).build();
    }
}
