package fr.mikrethor.cardroom.ws.mapping;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class MapperSingleton extends DozerBeanMapper {
	/**
	 * Instance.
	 */
	private static MapperSingleton instance;
	/**
	 * Mapping file.
	 */
	private static String DOZER_MAPPING_FILE = "mappingDozer.xml";

	/**
	 * Private constructor.
	 */
	private MapperSingleton() {
		super();
		final List<String> mappingDozerFiles = new ArrayList<String>();
		mappingDozerFiles.add(DOZER_MAPPING_FILE);
		this.setMappingFiles(mappingDozerFiles);
	}

	/**
	 * Return instance.
	 * 
	 * @return MapperSingleton instance.
	 */
	public static MapperSingleton getInstance() {
		if (instance == null) {
			instance = new MapperSingleton();
		}
		return instance;
	}

}
