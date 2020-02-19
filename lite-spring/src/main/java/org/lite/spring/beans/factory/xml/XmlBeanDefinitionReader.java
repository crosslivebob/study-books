package org.lite.spring.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.lite.spring.beans.BeanDefinition;
import org.lite.spring.core.io.Resource;
import org.lite.spring.beans.factory.BeanDefinitionStoreException;
import org.lite.spring.beans.factory.support.BeanDefinitionRegistry;
import org.lite.spring.beans.factory.support.GenericBeanDefinition;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bfq on 2020/2/15
 */
public class XmlBeanDefinitionReader {

    public static final String ID_ATTRIBUTE = "id";

    public static final String CLASS_ATTRIBUTE = "class";

    public static final String SCOPE_ATTRIBUTE = "scope";

    BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void loadBeanDefinition(Resource resource) {
        InputStream is = null;
        try {
            is = resource.getInputStream();
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element root = doc.getRootElement();
            for (Object object : root.elements()) {
                Element e = (Element) object;
                String id = e.attributeValue(ID_ATTRIBUTE);
                String beanClassName = e.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                if (e.attribute(SCOPE_ATTRIBUTE) != null) {
                    ((GenericBeanDefinition) bd).setScope(e.attributeValue(SCOPE_ATTRIBUTE));
                }
                this.registry.registerBeanDefinition(id, bd);
            }

        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from " + resource.getDescription(),e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
