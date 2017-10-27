package utils;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by win7 on 11/16/2016.
 */
public class MultipleJSONObjectHelper implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private static ObjectMapper mapper = null;

	public MultipleJSONObjectHelper() {
	}

	public static ObjectMapper getObjectMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
			mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper;
		}
		return mapper;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getObject(String data, String key, Class<?> clazz) throws IOException {
		final ObjectMapper mapper = getObjectMapper();
		JsonNode node = mapper.readTree(data);
		if (key == null) {
			return (T) mapper.convertValue(node, clazz);
		} else {
			return (T) mapper.convertValue(node.get(key), clazz);
		}

	}

	public static List<?> getListOfObjects(String data, String key, Class<?> clazz) throws IOException {
		final ObjectMapper mapper = getObjectMapper();
		if (key != null) {
			JsonNode node = mapper.readTree(data);
			return mapper.readValue(node.get(key).toString(),
					mapper.getTypeFactory().constructCollectionType(List.class, clazz));
		} else {
			return mapper.readValue(data, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getObjectFromMap(Map<?, ?> map, Class<?> clazz) throws IOException {
		final ObjectMapper mapper = getObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return (T) mapper.convertValue(map, clazz);
	}

	/*
	 * @SuppressWarnings("unchecked") public static <T extends List<?>> T
	 * getListFromObject(Object obj) { return (T) obj; }
	 */

	public static <T> T getListFromMap(List<Map<String, Object>> map, Class<?> clazz) throws IOException {
		final ObjectMapper mapper = getObjectMapper();
		return mapper.readValue(map.toString(), mapper.getTypeFactory().constructCollectionType(List.class, clazz));
	}

}
