package com.google.common.reflect;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.StandardSystemProperty;
import com.google.common.base.i;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.r;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f6446a = ".class";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableSet<d> f6448a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f6447a = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Splitter f32268a = Splitter.k(" ").g();

    /* JADX INFO: renamed from: com.google.common.reflect.a$a, reason: collision with other inner class name */
    public class C0754a implements Predicate<b> {
        public C0754a(a aVar) {
        }

        @Override // com.google.common.base.Predicate
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(b bVar) {
            return bVar.j();
        }
    }

    @Beta
    public static final class b extends d {
        public final String b;

        public b(File file, String str, ClassLoader classLoader) {
            super(file, str, classLoader);
            this.b = a.e(str);
        }

        public String g() {
            return this.b;
        }

        public String h() {
            return com.google.common.reflect.c.b(this.b);
        }

        public String i() {
            int iLastIndexOf = this.b.lastIndexOf(36);
            if (iLastIndexOf != -1) {
                return CharMatcher.m('0', '9').V(this.b.substring(iLastIndexOf + 1));
            }
            String strH = h();
            return strH.isEmpty() ? this.b : this.b.substring(strH.length() + 1);
        }

        public boolean j() {
            return this.b.indexOf(36) == -1;
        }

        public Class<?> k() {
            try {
                return ((d) this).f6450a.loadClass(this.b);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.reflect.a.d
        public String toString() {
            return this.b;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f32269a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ClassLoader f6449a;

        public c(File file, ClassLoader classLoader) {
            this.f32269a = (File) i.E(file);
            this.f6449a = (ClassLoader) i.E(classLoader);
        }

        public final File a() {
            return this.f32269a;
        }

        public final void b(File file, Set<File> set, ImmutableSet.a<d> aVar) throws IOException {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        c(file, aVar);
                    } else {
                        e(file, set, aVar);
                    }
                }
            } catch (SecurityException e) {
                Logger logger = a.f6447a;
                String strValueOf = String.valueOf(file);
                String strValueOf2 = String.valueOf(e);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 16 + strValueOf2.length());
                sb.append("Cannot access ");
                sb.append(strValueOf);
                sb.append(": ");
                sb.append(strValueOf2);
                logger.warning(sb.toString());
            }
        }

        public final void c(File file, ImmutableSet.a<d> aVar) throws IOException {
            HashSet hashSet = new HashSet();
            hashSet.add(file.getCanonicalFile());
            d(file, "", hashSet, aVar);
        }

        public final void d(File file, String str, Set<File> set, ImmutableSet.a<d> aVar) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                Logger logger = a.f6447a;
                String strValueOf = String.valueOf(file);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
                sb.append("Cannot read directory ");
                sb.append(strValueOf);
                logger.warning(sb.toString());
                return;
            }
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                if (file2.isDirectory()) {
                    File canonicalFile = file2.getCanonicalFile();
                    if (set.add(canonicalFile)) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(name).length());
                        sb2.append(str);
                        sb2.append(name);
                        sb2.append(WVNativeCallbackUtil.SEPERATER);
                        d(canonicalFile, sb2.toString(), set, aVar);
                        set.remove(canonicalFile);
                    }
                } else {
                    String strValueOf2 = String.valueOf(str);
                    String strValueOf3 = String.valueOf(name);
                    String strConcat = strValueOf3.length() != 0 ? strValueOf2.concat(strValueOf3) : new String(strValueOf2);
                    if (!strConcat.equals("META-INF/MANIFEST.MF")) {
                        aVar.g(d.e(file2, strConcat, this.f6449a));
                    }
                }
            }
        }

        public final void e(File file, Set<File> set, ImmutableSet.a<d> aVar) throws IOException {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    UnmodifiableIterator<File> it = a.h(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        File next = it.next();
                        if (set.add(next.getCanonicalFile())) {
                            b(next, set, aVar);
                        }
                    }
                    f(jarFile, aVar);
                } finally {
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f32269a.equals(cVar.f32269a) && this.f6449a.equals(cVar.f6449a);
        }

        public final void f(JarFile jarFile, ImmutableSet.a<d> aVar) {
            Enumeration<JarEntry> enumerationEntries = jarFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                if (!jarEntryNextElement.isDirectory() && !jarEntryNextElement.getName().equals("META-INF/MANIFEST.MF")) {
                    aVar.g(d.e(new File(jarFile.getName()), jarEntryNextElement.getName(), this.f6449a));
                }
            }
        }

        public ImmutableSet<d> g() throws IOException {
            return h(new HashSet());
        }

        public ImmutableSet<d> h(Set<File> set) throws IOException {
            ImmutableSet.a<d> aVarBuilder = ImmutableSet.builder();
            set.add(this.f32269a);
            b(this.f32269a, set, aVarBuilder);
            return aVarBuilder.e();
        }

        public int hashCode() {
            return this.f32269a.hashCode();
        }

        public String toString() {
            return this.f32269a.toString();
        }
    }

    @Beta
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f32270a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ClassLoader f6450a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f6451a;

        public d(File file, String str, ClassLoader classLoader) {
            this.f32270a = (File) i.E(file);
            this.f6451a = (String) i.E(str);
            this.f6450a = (ClassLoader) i.E(classLoader);
        }

        public static d e(File file, String str, ClassLoader classLoader) {
            return str.endsWith(a.f6446a) ? new b(file, str, classLoader) : new d(file, str, classLoader);
        }

        public final ByteSource a() {
            return r.a(f());
        }

        public final CharSource b(Charset charset) {
            return r.b(f(), charset);
        }

        public final File c() {
            return this.f32270a;
        }

        public final String d() {
            return this.f6451a;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f6451a.equals(dVar.f6451a) && this.f6450a == dVar.f6450a;
        }

        public final URL f() {
            URL resource = this.f6450a.getResource(this.f6451a);
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException(this.f6451a);
        }

        public int hashCode() {
            return this.f6451a.hashCode();
        }

        public String toString() {
            return this.f6451a;
        }
    }

    public a(ImmutableSet<d> immutableSet) {
        this.f6448a = immutableSet;
    }

    public static a b(ClassLoader classLoader) throws IOException {
        ImmutableSet<c> immutableSetL = l(classLoader);
        HashSet hashSet = new HashSet();
        UnmodifiableIterator<c> it = immutableSetL.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().a());
        }
        ImmutableSet.a aVarBuilder = ImmutableSet.builder();
        UnmodifiableIterator<c> it2 = immutableSetL.iterator();
        while (it2.hasNext()) {
            aVarBuilder.c(it2.next().h(hashSet));
        }
        return new a(aVarBuilder.e());
    }

    public static ImmutableList<URL> d(ClassLoader classLoader) {
        if (classLoader instanceof URLClassLoader) {
            return ImmutableList.copyOf(((URLClassLoader) classLoader).getURLs());
        }
        return classLoader.equals(ClassLoader.getSystemClassLoader()) ? m() : ImmutableList.of();
    }

    @VisibleForTesting
    public static String e(String str) {
        return str.substring(0, str.length() - 6).replace('/', '.');
    }

    @VisibleForTesting
    public static ImmutableMap<File, ClassLoader> f(ClassLoader classLoader) {
        LinkedHashMap linkedHashMapC0 = Maps.c0();
        ClassLoader parent = classLoader.getParent();
        if (parent != null) {
            linkedHashMapC0.putAll(f(parent));
        }
        UnmodifiableIterator<URL> it = d(classLoader).iterator();
        while (it.hasNext()) {
            URL next = it.next();
            if (next.getProtocol().equals("file")) {
                File fileN = n(next);
                if (!linkedHashMapC0.containsKey(fileN)) {
                    linkedHashMapC0.put(fileN, classLoader);
                }
            }
        }
        return ImmutableMap.copyOf((Map) linkedHashMapC0);
    }

    @VisibleForTesting
    public static URL g(File file, String str) throws MalformedURLException {
        return new URL(file.toURI().toURL(), str);
    }

    @VisibleForTesting
    public static ImmutableSet<File> h(File file, @CheckForNull Manifest manifest) {
        if (manifest == null) {
            return ImmutableSet.of();
        }
        ImmutableSet.a aVarBuilder = ImmutableSet.builder();
        String value = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
        if (value != null) {
            for (String str : f32268a.n(value)) {
                try {
                    URL urlG = g(file, str);
                    if (urlG.getProtocol().equals("file")) {
                        aVarBuilder.g(n(urlG));
                    }
                } catch (MalformedURLException unused) {
                    Logger logger = f6447a;
                    String strValueOf = String.valueOf(str);
                    logger.warning(strValueOf.length() != 0 ? "Invalid Class-Path entry: ".concat(strValueOf) : new String("Invalid Class-Path entry: "));
                }
            }
        }
        return aVarBuilder.e();
    }

    public static ImmutableSet<c> l(ClassLoader classLoader) {
        ImmutableSet.a aVarBuilder = ImmutableSet.builder();
        UnmodifiableIterator<Map.Entry<File, ClassLoader>> it = f(classLoader).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<File, ClassLoader> next = it.next();
            aVarBuilder.g(new c(next.getKey(), next.getValue()));
        }
        return aVarBuilder.e();
    }

    @VisibleForTesting
    public static ImmutableList<URL> m() {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (String str : Splitter.k(StandardSystemProperty.PATH_SEPARATOR.value()).n(StandardSystemProperty.JAVA_CLASS_PATH.value())) {
            try {
                try {
                    aVarBuilder.a(new File(str).toURI().toURL());
                } catch (SecurityException unused) {
                    aVarBuilder.a(new URL("file", (String) null, new File(str).getAbsolutePath()));
                }
            } catch (MalformedURLException e) {
                Logger logger = f6447a;
                Level level = Level.WARNING;
                String strValueOf = String.valueOf(str);
                logger.log(level, strValueOf.length() != 0 ? "malformed classpath entry: ".concat(strValueOf) : new String("malformed classpath entry: "), (Throwable) e);
            }
        }
        return aVarBuilder.e();
    }

    @VisibleForTesting
    public static File n(URL url) {
        i.d(url.getProtocol().equals("file"));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }

    public ImmutableSet<b> c() {
        return FluentIterable.x(this.f6448a).q(b.class).O();
    }

    public ImmutableSet<d> getResources() {
        return this.f6448a;
    }

    public ImmutableSet<b> i() {
        return FluentIterable.x(this.f6448a).q(b.class).o(new C0754a(this)).O();
    }

    public ImmutableSet<b> j(String str) {
        i.E(str);
        ImmutableSet.a aVarBuilder = ImmutableSet.builder();
        UnmodifiableIterator<b> it = i().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.h().equals(str)) {
                aVarBuilder.g(next);
            }
        }
        return aVarBuilder.e();
    }

    public ImmutableSet<b> k(String str) {
        i.E(str);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1);
        sb.append(str);
        sb.append('.');
        String string = sb.toString();
        ImmutableSet.a aVarBuilder = ImmutableSet.builder();
        UnmodifiableIterator<b> it = i().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.g().startsWith(string)) {
                aVarBuilder.g(next);
            }
        }
        return aVarBuilder.e();
    }
}
