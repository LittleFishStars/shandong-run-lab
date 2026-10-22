package com.google.common.io;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.alibaba.android.arouter.utils.Consts;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.zj.adlib.c49;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class Files {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32173a = 10000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SuccessorsFunction<File> f6342a = new b();

    public enum FilePredicate implements Predicate<File> {
        IS_DIRECTORY { // from class: com.google.common.io.Files.FilePredicate.1
            @Override // java.lang.Enum
            public String toString() {
                return "Files.isDirectory()";
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(File file) {
                return file.isDirectory();
            }
        },
        IS_FILE { // from class: com.google.common.io.Files.FilePredicate.2
            @Override // java.lang.Enum
            public String toString() {
                return "Files.isFile()";
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(File file) {
                return file.isFile();
            }
        };

        /* synthetic */ FilePredicate(a aVar) {
            this();
        }
    }

    public class a implements LineProcessor<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f32174a = Lists.q();

        @Override // com.google.common.io.LineProcessor
        public boolean a(String str) {
            this.f32174a.add(str);
            return true;
        }

        @Override // com.google.common.io.LineProcessor
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<String> getResult() {
            return this.f32174a;
        }
    }

    public class b implements SuccessorsFunction<File> {
        @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
        public Iterable<File> b(File file) {
            File[] fileArrListFiles;
            return (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) ? ImmutableList.of() : Collections.unmodifiableList(Arrays.asList(fileArrListFiles));
        }
    }

    public static final class c extends ByteSink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableSet<FileWriteMode> f32175a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final File f6343a;

        public /* synthetic */ c(File file, FileWriteMode[] fileWriteModeArr, a aVar) {
            this(file, fileWriteModeArr);
        }

        @Override // com.google.common.io.ByteSink
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public FileOutputStream c() throws IOException {
            return new FileOutputStream(this.f6343a, this.f32175a.contains(FileWriteMode.APPEND));
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f6343a);
            String strValueOf2 = String.valueOf(this.f32175a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 20 + strValueOf2.length());
            sb.append("Files.asByteSink(");
            sb.append(strValueOf);
            sb.append(", ");
            sb.append(strValueOf2);
            sb.append(")");
            return sb.toString();
        }

        public c(File file, FileWriteMode... fileWriteModeArr) {
            this.f6343a = (File) com.google.common.base.i.E(file);
            this.f32175a = ImmutableSet.copyOf(fileWriteModeArr);
        }
    }

    public static final class d extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f32176a;

        public /* synthetic */ d(File file, a aVar) {
            this(file);
        }

        @Override // com.google.common.io.ByteSource
        public byte[] o() throws Throwable {
            Closer closerG = Closer.g();
            try {
                FileInputStream fileInputStream = (FileInputStream) closerG.h(m());
                byte[] bArrV = com.google.common.io.b.v(fileInputStream, fileInputStream.getChannel().size());
                closerG.close();
                return bArrV;
            } catch (Throwable th) {
                try {
                    throw closerG.j(th);
                } catch (Throwable th2) {
                    closerG.close();
                    throw th2;
                }
            }
        }

        @Override // com.google.common.io.ByteSource
        public long p() throws IOException {
            if (this.f32176a.isFile()) {
                return this.f32176a.length();
            }
            throw new FileNotFoundException(this.f32176a.toString());
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> q() {
            return this.f32176a.isFile() ? Optional.of(Long.valueOf(this.f32176a.length())) : Optional.absent();
        }

        @Override // com.google.common.io.ByteSource
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public FileInputStream m() throws IOException {
            return new FileInputStream(this.f32176a);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f32176a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 20);
            sb.append("Files.asByteSource(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }

        public d(File file) {
            this.f32176a = (File) com.google.common.base.i.E(file);
        }
    }

    @Beta
    @Deprecated
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <T> T A(File file, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return (T) e(file, charset).q(lineProcessor);
    }

    @Beta
    public static List<String> B(File file, Charset charset) throws IOException {
        return (List) e(file, charset).q(new a());
    }

    @Beta
    public static String C(String str) {
        com.google.common.base.i.E(str);
        if (str.length() == 0) {
            return Consts.DOT;
        }
        Iterable<String> iterableN = Splitter.h('/').g().n(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : iterableN) {
            str2.hashCode();
            if (!str2.equals(Consts.DOT)) {
                if (!str2.equals("..")) {
                    arrayList.add(str2);
                } else if (arrayList.size() <= 0 || ((String) arrayList.get(arrayList.size() - 1)).equals("..")) {
                    arrayList.add("..");
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        String strK = com.google.common.base.d.o('/').k(arrayList);
        if (str.charAt(0) == '/') {
            String strValueOf = String.valueOf(strK);
            strK = strValueOf.length() != 0 ? WVNativeCallbackUtil.SEPERATER.concat(strValueOf) : new String(WVNativeCallbackUtil.SEPERATER);
        }
        while (strK.startsWith("/../")) {
            strK = strK.substring(3);
        }
        if (strK.equals("/..")) {
            return WVNativeCallbackUtil.SEPERATER;
        }
        return "".equals(strK) ? Consts.DOT : strK;
    }

    @Beta
    public static byte[] D(File file) throws IOException {
        return c(file).o();
    }

    @Beta
    @Deprecated
    public static String E(File file, Charset charset) throws IOException {
        return e(file, charset).n();
    }

    @Beta
    public static void F(File file) throws IOException {
        com.google.common.base.i.E(file);
        if (file.createNewFile() || file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        String strValueOf = String.valueOf(file);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
        sb.append("Unable to update modification time of ");
        sb.append(strValueOf);
        throw new IOException(sb.toString());
    }

    @Beta
    @Deprecated
    public static void G(CharSequence charSequence, File file, Charset charset) throws Throwable {
        d(file, charset, new FileWriteMode[0]).c(charSequence);
    }

    @Beta
    public static void H(byte[] bArr, File file) throws Throwable {
        b(file, new FileWriteMode[0]).d(bArr);
    }

    @Beta
    @Deprecated
    public static void a(CharSequence charSequence, File file, Charset charset) throws Throwable {
        d(file, charset, FileWriteMode.APPEND).c(charSequence);
    }

    public static ByteSink b(File file, FileWriteMode... fileWriteModeArr) {
        return new c(file, fileWriteModeArr, null);
    }

    public static ByteSource c(File file) {
        return new d(file, null);
    }

    public static CharSink d(File file, Charset charset, FileWriteMode... fileWriteModeArr) {
        return b(file, fileWriteModeArr).a(charset);
    }

    public static CharSource e(File file, Charset charset) {
        return c(file).a(charset);
    }

    @Beta
    public static void f(File file, File file2) throws Throwable {
        com.google.common.base.i.y(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        c(file).f(b(file2, new FileWriteMode[0]));
    }

    @Beta
    public static void g(File file, OutputStream outputStream) throws Throwable {
        c(file).g(outputStream);
    }

    @Beta
    @Deprecated
    public static void h(File file, Charset charset, Appendable appendable) throws Throwable {
        e(file, charset).f(appendable);
    }

    @Beta
    public static void i(File file) throws IOException {
        com.google.common.base.i.E(file);
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            return;
        }
        String strValueOf = String.valueOf(file);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 39);
        sb.append("Unable to create parent directories of ");
        sb.append(strValueOf);
        throw new IOException(sb.toString());
    }

    @Beta
    @Deprecated
    public static File j() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(21);
        sb.append(jCurrentTimeMillis);
        sb.append(c49.f40900a);
        String string = sb.toString();
        for (int i = 0; i < 10000; i++) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 11);
            sb2.append(string);
            sb2.append(i);
            File file2 = new File(file, sb2.toString());
            if (file2.mkdir()) {
                return file2;
            }
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(string).length() + 66 + String.valueOf(string).length());
        sb3.append("Failed to create directory within 10000 attempts (tried ");
        sb3.append(string);
        sb3.append("0 to ");
        sb3.append(string);
        sb3.append(AVMDLDataLoader.KeyIsEnableEventInfo);
        sb3.append(')');
        throw new IllegalStateException(sb3.toString());
    }

    @Beta
    public static boolean k(File file, File file2) throws IOException {
        com.google.common.base.i.E(file);
        com.google.common.base.i.E(file2);
        if (file == file2 || file.equals(file2)) {
            return true;
        }
        long length = file.length();
        long length2 = file2.length();
        if (length == 0 || length2 == 0 || length == length2) {
            return c(file).e(c(file2));
        }
        return false;
    }

    @Beta
    public static Traverser<File> l() {
        return Traverser.h(f6342a);
    }

    @Beta
    public static String m(String str) {
        com.google.common.base.i.E(str);
        String name = new File(str).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf == -1 ? "" : name.substring(iLastIndexOf + 1);
    }

    @Beta
    public static String n(String str) {
        com.google.common.base.i.E(str);
        String name = new File(str).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf == -1 ? name : name.substring(0, iLastIndexOf);
    }

    @Beta
    @Deprecated
    public static HashCode o(File file, HashFunction hashFunction) throws IOException {
        return c(file).j(hashFunction);
    }

    @Beta
    public static Predicate<File> p() {
        return FilePredicate.IS_DIRECTORY;
    }

    @Beta
    public static Predicate<File> q() {
        return FilePredicate.IS_FILE;
    }

    @Beta
    public static MappedByteBuffer r(File file) throws IOException {
        com.google.common.base.i.E(file);
        return s(file, FileChannel.MapMode.READ_ONLY);
    }

    @Beta
    public static MappedByteBuffer s(File file, FileChannel.MapMode mapMode) throws IOException {
        return u(file, mapMode, -1L);
    }

    @Beta
    public static MappedByteBuffer t(File file, FileChannel.MapMode mapMode, long j) throws IOException {
        com.google.common.base.i.p(j >= 0, "size (%s) may not be negative", j);
        return u(file, mapMode, j);
    }

    public static MappedByteBuffer u(File file, FileChannel.MapMode mapMode, long j) throws Throwable {
        com.google.common.base.i.E(file);
        com.google.common.base.i.E(mapMode);
        Closer closerG = Closer.g();
        try {
            FileChannel fileChannel = (FileChannel) closerG.h(((RandomAccessFile) closerG.h(new RandomAccessFile(file, mapMode == FileChannel.MapMode.READ_ONLY ? "r" : "rw"))).getChannel());
            if (j == -1) {
                j = fileChannel.size();
            }
            MappedByteBuffer map = fileChannel.map(mapMode, 0L, j);
            closerG.close();
            return map;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    @Beta
    public static void v(File file, File file2) throws Throwable {
        com.google.common.base.i.E(file);
        com.google.common.base.i.E(file2);
        com.google.common.base.i.y(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (file.renameTo(file2)) {
            return;
        }
        f(file, file2);
        if (file.delete()) {
            return;
        }
        if (file2.delete()) {
            String strValueOf = String.valueOf(file);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 17);
            sb.append("Unable to delete ");
            sb.append(strValueOf);
            throw new IOException(sb.toString());
        }
        String strValueOf2 = String.valueOf(file2);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 17);
        sb2.append("Unable to delete ");
        sb2.append(strValueOf2);
        throw new IOException(sb2.toString());
    }

    @Beta
    public static BufferedReader w(File file, Charset charset) throws FileNotFoundException {
        com.google.common.base.i.E(file);
        com.google.common.base.i.E(charset);
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    }

    @Beta
    public static BufferedWriter x(File file, Charset charset) throws FileNotFoundException {
        com.google.common.base.i.E(file);
        com.google.common.base.i.E(charset);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
    }

    @Beta
    @Deprecated
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <T> T y(File file, ByteProcessor<T> byteProcessor) throws IOException {
        return (T) c(file).n(byteProcessor);
    }

    @Beta
    @CheckForNull
    @Deprecated
    public static String z(File file, Charset charset) throws IOException {
        return e(file, charset).o();
    }
}
