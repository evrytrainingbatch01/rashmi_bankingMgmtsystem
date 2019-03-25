package com.evryindia.util;

import java.io.Serializable;

public class ApplicationBase implements Serializable
{
	private static final long serialVersionUID = -2969501861270511743L;
	private static String basePath = "http://localhost:8082/EvryBank";
//	private static String basePath = "http://172.21.0.105/exceptiontracker";
	
	public static String getBasePath() {
		return basePath;
	}
}
