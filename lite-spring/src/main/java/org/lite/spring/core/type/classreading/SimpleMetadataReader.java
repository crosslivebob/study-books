package org.lite.spring.core.type.classreading;

import jdk.internal.org.objectweb.asm.ClassReader;
import org.lite.spring.core.io.ClassPathResource;
import org.lite.spring.core.io.Resource;
import org.lite.spring.core.type.AnnotationMetadata;
import org.lite.spring.core.type.ClassMetadata;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bfq on 2020/3/13
 */
public class SimpleMetadataReader implements MetadataReader {

    private final Resource resource;

    private final ClassMetadata classMetadata;

    private final AnnotationMetadata annotationMetadata;


    public SimpleMetadataReader(Resource resource) throws IOException {
        InputStream is = new BufferedInputStream(resource.getInputStream());
        ClassReader classReader;

        try {
            classReader = new ClassReader(is);
        }
        finally {
            is.close();
        }

        AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor();
        classReader.accept(visitor, ClassReader.SKIP_DEBUG);

        this.annotationMetadata = visitor;
        this.classMetadata = visitor;
        this.resource = resource;
    }


    @Override
    public Resource getResource() {
        return this.resource;
    }

    @Override
    public ClassMetadata getClassMetadata() {
        return this.classMetadata;
    }

    @Override
    public AnnotationMetadata getAnnotationMetadata() {
        return this.annotationMetadata;
    }

}