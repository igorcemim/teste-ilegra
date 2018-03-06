package br.com.cemim.salesreport.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRepository<T, K> {

	protected Map<K, T> map;
	
	public AbstractRepository() {
		map = new HashMap<>();
	}
	
	public T find(K key) {
		return map.get(key);
	}
	
	public boolean containsKey(K key) {
		return map.containsKey(key);
	}

	public Collection<T> getCollection() {
		return map.values();
	}

	public abstract void add(T entry);

}
