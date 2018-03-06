package br.com.cemim.salesreport.layout;

public abstract class AbstractLayout<T> {
	
	public static final String LAYOUT_CODE = null;
	
	protected final String FIELD_DELIMITER = "ç";

	public abstract T read(String line);

}
