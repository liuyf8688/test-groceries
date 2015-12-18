package demo.liuyf.jackson.databind.introspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mongojack.internal.MongoAnnotationIntrospector;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;

import demo.liuyf.jackson.annotation.MongoJsonIgnore;

@SuppressWarnings("serial")
public class CustomMongoAnnotationIntrospector extends MongoAnnotationIntrospector {

	private static final Log log = LogFactory.getLog(JacksonAnnotationIntrospector.class);
	
	public CustomMongoAnnotationIntrospector(TypeFactory typeFactory) {
		super(typeFactory);
	}

	@Override
	public boolean hasIgnoreMarker(AnnotatedMember m) {
		MongoJsonIgnore ann = m.getAnnotation(MongoJsonIgnore.class);
        if (log.isDebugEnabled() && (ann != null)) {
        	log.debug("=====================: " + m.getClass());
        	log.debug("=====================: " + m.getRawType());
        }
        return (ann != null && ann.value());
	}

}
