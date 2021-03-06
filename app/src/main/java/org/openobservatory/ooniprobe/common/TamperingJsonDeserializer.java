package org.openobservatory.ooniprobe.common;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.openobservatory.ooniprobe.model.jsonresult.TestKeys;

import java.lang.reflect.Type;

class TamperingJsonDeserializer implements JsonDeserializer<TestKeys.Tampering> {
	@Override public TestKeys.Tampering deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isBoolean())
			return new TestKeys.Tampering(json.getAsJsonPrimitive().getAsBoolean());
		else
			return new TestKeys.Tampering(new Gson().fromJson(json, TestKeys.Tampering.TamperingObj.class).isAnomaly());
	}
}
