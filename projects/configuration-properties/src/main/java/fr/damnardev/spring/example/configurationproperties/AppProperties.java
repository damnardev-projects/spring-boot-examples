package fr.damnardev.spring.example.configurationproperties;

import java.util.List;

public class AppProperties {

	private String name;

	private String version;

	private String environment;

	private int port;

	private boolean debug;

	private List<String> tags;

	public String name() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String version() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String environment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public int port() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean debug() {
		return this.debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public List<String> tags() {
		return this.tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
