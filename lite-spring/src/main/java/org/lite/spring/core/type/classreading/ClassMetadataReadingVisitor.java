package org.lite.spring.core.type.classreading;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.lite.spring.util.ClassUtils;

/**
 * Created by bfq on 2020/2/29
 */
public class ClassMetadataReadingVisitor extends ClassVisitor {
    private String className;

    private boolean isInterface;

    private boolean isAbstract;

    private boolean isFinal;

    private String superClassName;

    private String[] interfaces;

    //此处采用的有spring，所以再次设置一个常量
    public static final int ASM_VERSION = 327680;

    public ClassMetadataReadingVisitor() {
        super(ASM_VERSION);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String supername, String[] interfaces) {
        this.className = ClassUtils.convertResourcePathToClassName(name);
        this.isInterface = ((access & Opcodes.ACC_INTERFACE) != 0);
        this.isAbstract = ((access & Opcodes.ACC_ABSTRACT) != 0);
        this.isFinal = ((access & Opcodes.ACC_FINAL) != 0);
        if (supername != null) {
            this.superClassName = ClassUtils.convertResourcePathToClassName(supername);
        }
        this.interfaces = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            this.interfaces[i] = ClassUtils.convertResourcePathToClassName(interfaces[i]);
        }
    }

    public String getClassName() {
        return this.className;
    }

    public boolean isInterface() {
        return this.isInterface;
    }

    public boolean isAbstract() {
        return this.isAbstract;
    }

    public boolean isConcrete() {
        return !(this.isInterface || this.isAbstract);
    }

    public boolean isFinal() {
        return this.isFinal;
    }


    public boolean hasSuperClass() {
        return (this.superClassName != null);
    }

    public String getSuperClassName() {
        return this.superClassName;
    }

    public String[] getInterfaceNames() {
        return this.interfaces;
    }
}
