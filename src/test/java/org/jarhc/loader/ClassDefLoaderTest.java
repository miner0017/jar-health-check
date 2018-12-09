package org.jarhc.loader;

import org.jarhc.TestUtils;
import org.jarhc.model.ClassDef;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.TempDirectory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junitpioneer.jupiter.TempDirectory.TempDir;

@ExtendWith(TempDirectory.class)
class ClassDefLoaderTest {

	private final ClassDefLoader classDefLoader = new ClassDefLoader();

	@Test
	void test_load_java8() throws IOException {

		String resource = "/test/java8/Main.class";
		ClassDef classDef = loadClass(resource);

		assertNotNull(classDef);
		assertEquals("Main", classDef.getClassName());
		assertEquals(52, classDef.getMajorClassVersion());
		assertEquals("Java 8", classDef.getJavaVersion());
	}

	@Test
	void test_load_java7() throws IOException {

		String resource = "/test/java7/Main.class";
		ClassDef classDef = loadClass(resource);

		assertNotNull(classDef);
		assertEquals("Main", classDef.getClassName());
		assertEquals(51, classDef.getMajorClassVersion());
		assertEquals("Java 7", classDef.getJavaVersion());
	}

	@Test
	void test_load_java6() throws IOException {

		String resource = "/test/java6/Main.class";
		ClassDef classDef = loadClass(resource);

		assertNotNull(classDef);
		assertEquals("Main", classDef.getClassName());
		assertEquals(50, classDef.getMajorClassVersion());
		assertEquals("Java 6", classDef.getJavaVersion());
	}

	@Test
	void test_load_file(@TempDir Path tempDir) throws IOException {

		String resource = "/test/java8/Main.class";
		File file = TestUtils.getResourceAsFile(resource, tempDir);
		ClassDef classDef = classDefLoader.load(file);

		assertNotNull(classDef);
		assertEquals("Main", classDef.getClassName());
		assertEquals(52, classDef.getMajorClassVersion());
		assertEquals("Java 8", classDef.getJavaVersion());
	}

	private ClassDef loadClass(String resource) throws IOException {
		try (InputStream stream = TestUtils.getResourceAsStream(resource)) {
			return classDefLoader.load(stream);
		}
	}

}
