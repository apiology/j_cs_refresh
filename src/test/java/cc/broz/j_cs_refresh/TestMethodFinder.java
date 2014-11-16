package cc.broz.j_cs_refresh;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import java.util.function.Function;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestMethodFinder {
    public static Collection<String> getTestMethods(Class theClass) {
        String fName = theClass.getName();
        Class<?> superClass = theClass;
        List<String> names = new ArrayList<String>();
        while (junit.framework.Test.class.isAssignableFrom(superClass)) {
            for (Method each : superClass.getDeclaredMethods()) {
                addTestMethod(each, names, theClass);
            }
            superClass = superClass.getSuperclass();
        }
        if (names.size() == 0) {
            throw new IllegalStateException("No tests found in " + theClass.getName());
        }
        return names;
    }

    public static void addTestMethod(Method m, List<String> names, Class<?> theClass) {
        String name = m.getName();
        if (names.contains(name)) {
            return;
        }
        if (!isPublicTestMethod(m)) {
            if (isTestMethod(m)) {
                throw new IllegalStateException("Test method isn't public: " +
                                                m.getName() + "(" +
                                                theClass.getCanonicalName() + ")");
            }
            return;
        }
        names.add(name);
    }

    public static boolean isPublicTestMethod(Method m) {
        return isTestMethod(m) && Modifier.isPublic(m.getModifiers());
    }

    public static boolean isTestMethod(Method m) {
        return m.getParameterTypes().length == 0 &&
            m.getName().startsWith("test") &&
            m.getReturnType().equals(Void.TYPE);
    }

    public static void addToSuite(junit.framework.TestSuite suite,
                                  Class clazz,
                                  Function<String, junit.framework.Test> testCreator) {
        Collection<String> methods = TestMethodFinder.getTestMethods(clazz);
        for (String methodName: methods) {
            suite.addTest(testCreator.apply(methodName));
        }
    }
}
