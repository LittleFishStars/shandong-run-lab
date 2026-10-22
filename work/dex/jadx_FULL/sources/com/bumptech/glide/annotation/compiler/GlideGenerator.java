package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.repackaged.com.google.common.base.Function;
import com.bumptech.glide.repackaged.com.google.common.base.Preconditions;
import com.bumptech.glide.repackaged.com.google.common.collect.Lists;
import com.bumptech.glide.repackaged.com.squareup.javapoet.AnnotationSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ClassName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.MethodSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ParameterSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class GlideGenerator {
    private final TypeElement glideType;
    private final ProcessingEnvironment processingEnv;
    private final ProcessorUtil processorUtil;
    private final TypeElement requestManagerType;

    public GlideGenerator(ProcessingEnvironment processingEnvironment, ProcessorUtil processorUtil) {
        this.processingEnv = processingEnvironment;
        this.processorUtil = processorUtil;
        Elements elementUtils = processingEnvironment.getElementUtils();
        this.requestManagerType = elementUtils.getTypeElement("com.bumptech.glide.RequestManager");
        this.glideType = elementUtils.getTypeElement("com.bumptech.glide.Glide");
    }

    private MethodSpec.Builder addReturnAnnotations(MethodSpec.Builder builder, ExecutableElement executableElement) {
        String string = this.processingEnv.getElementUtils().getTypeElement(this.processorUtil.visibleForTesting().reflectionName()).toString();
        for (AnnotationMirror annotationMirror : executableElement.getAnnotationMirrors()) {
            builder.addAnnotation(AnnotationSpec.get(annotationMirror));
            if (annotationMirror.getAnnotationType().toString().equals(string)) {
                builder.addAnnotation(AnnotationSpec.builder(ClassName.get("android.annotation", "SuppressLint", new String[0])).addMember("value", "$S", "VisibleForTests").build());
            }
        }
        return builder;
    }

    private List<ExecutableElement> discoverGlideMethodsToOverride() {
        return this.processorUtil.findStaticMethods(this.glideType);
    }

    private List<MethodSpec> generateOverridesForGlideMethods(final String str, final TypeSpec typeSpec) {
        return Lists.transform(discoverGlideMethodsToOverride(), new Function<ExecutableElement, MethodSpec>() { // from class: com.bumptech.glide.annotation.compiler.GlideGenerator.1
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Function
            public MethodSpec apply(ExecutableElement executableElement) {
                return GlideGenerator.this.isGlideWithMethod(executableElement) ? GlideGenerator.this.overrideGlideWithMethod(str, typeSpec, executableElement) : GlideGenerator.this.overrideGlideStaticMethod(executableElement);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isGlideWithMethod(ExecutableElement executableElement) {
        return this.processorUtil.isReturnValueTypeMatching(executableElement, this.requestManagerType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MethodSpec overrideGlideStaticMethod(ExecutableElement executableElement) {
        List<ParameterSpec> parameters = this.processorUtil.getParameters(executableElement);
        TypeElement typeElementAsElement = this.processingEnv.getTypeUtils().asElement(executableElement.getReturnType());
        MethodSpec.Builder builderAddParameters = MethodSpec.methodBuilder(executableElement.getSimpleName().toString()).addModifiers(Modifier.PUBLIC, Modifier.STATIC).addJavadoc(this.processorUtil.generateSeeMethodJavadoc(executableElement)).addParameters(parameters);
        addReturnAnnotations(builderAddParameters, executableElement);
        boolean z = typeElementAsElement != null;
        if (z) {
            builderAddParameters.returns(ClassName.get(typeElementAsElement));
        }
        StringBuilder sb = new StringBuilder(z ? "return " : "");
        sb.append("$T.$N(");
        ArrayList arrayList = new ArrayList();
        arrayList.add(ClassName.get(this.glideType));
        arrayList.add(executableElement.getSimpleName());
        if (!parameters.isEmpty()) {
            for (ParameterSpec parameterSpec : parameters) {
                sb.append("$L, ");
                arrayList.add(parameterSpec.name);
            }
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        }
        sb.append(")");
        builderAddParameters.addStatement(sb.toString(), arrayList.toArray(new Object[0]));
        return builderAddParameters.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MethodSpec overrideGlideWithMethod(String str, TypeSpec typeSpec, ExecutableElement executableElement) {
        ClassName className = ClassName.get(str, typeSpec.name, new String[0]);
        List<ParameterSpec> parameters = this.processorUtil.getParameters(executableElement);
        Preconditions.checkArgument(parameters.size() == 1, "Expected size of 1, but got %s", executableElement);
        return addReturnAnnotations(MethodSpec.methodBuilder(executableElement.getSimpleName().toString()).addModifiers(Modifier.PUBLIC, Modifier.STATIC).addJavadoc(this.processorUtil.generateSeeMethodJavadoc(executableElement)).addParameters(parameters).returns(className).addStatement("return ($T) $T.$N($L)", className, this.glideType, executableElement.getSimpleName().toString(), parameters.iterator().next().name), executableElement).build();
    }

    public TypeSpec generate(String str, String str2, TypeSpec typeSpec) {
        return TypeSpec.classBuilder(str2).addJavadoc("The entry point for interacting with Glide for Applications\n\n<p>Includes all generated APIs from all\n{@link $T}s in source and dependent libraries.\n\n<p>This class is generated and should not be modified\n@see $T\n", GlideExtension.class, this.glideType).addModifiers(Modifier.PUBLIC, Modifier.FINAL).addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE).build()).addMethods(generateOverridesForGlideMethods(str, typeSpec)).build();
    }
}
