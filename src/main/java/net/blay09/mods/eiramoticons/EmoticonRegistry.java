// Copyright (c) 2015, Christopher "blay09" Baker
// Some rights reserved.

package net.blay09.mods.eiramoticons;

import net.blay09.mods.eiramoticons.api.IEmoticon;
import net.blay09.mods.eiramoticons.api.IEmoticonLoader;
import net.minecraft.util.IntHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EmoticonRegistry {

	private static final AtomicInteger idCounter = new AtomicInteger();
	private static final IntHashMap emoticonMap = new IntHashMap();
	private static final Map<String, Emoticon> namedMap = new HashMap<String, Emoticon>();

	public static IEmoticon registerEmoticon(String name, IEmoticonLoader loader) {
		Emoticon emoticon = new Emoticon(idCounter.incrementAndGet(), name, loader);
		emoticonMap.addKey(emoticon.id, emoticon);
		namedMap.put(emoticon.name, emoticon);
		return emoticon;
	}

	public static Emoticon fromName(String name) {
		return namedMap.get(name);
	}

	public static Emoticon fromId(int id) {
		return (Emoticon) emoticonMap.lookup(id);
	}
}
