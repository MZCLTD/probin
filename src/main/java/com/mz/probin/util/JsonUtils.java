package com.mz.probin.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

//TODO Create variants of these methods that can accept an ObjectMapper as a
//TODO parameter and use it for the serialization/deserialization
public abstract class JsonUtils {
	
	public static <T> T readValue(String jsonStr, Class<T> classType) throws Exception {
		return new ObjectMapper().readValue(jsonStr, classType);
	}
	
	public static <T> T readValue(InputStream in, Class<T> classType) throws Exception {
		return new ObjectMapper().readValue(in, classType);
	}

	public static <T> T readValue(InputStream in, TypeReference<T> typeReference) throws Exception {
		return new ObjectMapper().readValue(in, typeReference);
	}

	public static String writeValueAsString(Object obj) throws Exception {
		return new ObjectMapper().writeValueAsString(obj);
	}
}
