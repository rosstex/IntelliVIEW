import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.Arrays;

import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import javassist.ClassPool;
import javassist.bytecode.ClassFile;
import javassist.convert.Transformer;

/**
 * Created by rteixeira on 6/30/16.
 */
public class AgentLauncher {
    public static void premain(String agentArgs, Instrumentation inst) {

        ClassFileTransformer transformer = new Transform();
        inst.addTransformer(transformer);

    }


    public static class Transform implements ClassFileTransformer {
        public boolean modified = false;
        public String code = "StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace(); StackTraceElement e = stackTraceElements[2]; if (e.toString().contains(\"Runner\")) {Drawer.watch(this);} ";
//        public String code = "Drawer.watch(this);";
//        public String code = "for (StackTraceElement e : Thread.currentThread().getStackTrace()) {System.out.println(e.getClassName());} ";

//        public static void main(String[] args) {
//            "for (StackTraceElement e : Thread.currentThread().getStackTrace()) {System.out.println(e.getClassName());}"
//        }

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            if (!modified) {
                try {
                    String[] structures = {"java.util.LinkedList", "java.util.ArrayList", "java.util.HashMap", "java.util.HashSet", "java.util.Stack", "java.util.TreeMap", "java.util.ArrayDeque"};


                    ClassPool pool = ClassPool.getDefault();

                    for (String structure : structures) {
                        System.out.println(structure);
                        CtClass cls = pool.get(structure);
                        CtConstructor method = cls.getConstructor("()V");
                        method.insertAfter(code);
//                        method.insertAfter("Drawer.watch(this);");
                        cls.writeFile("/Users/rteixeira/purehack_intellij");

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else { }
            modified = true;
            return new byte[0];
        }
    }

    public static void main(String[] args) {

    }
}
