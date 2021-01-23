package de.munchkin.backend.networking;

public class IPValidator {
	
	private final static String ipv4 = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";
	
	public boolean validateIP(String ip) {
		return ip.matches(ipv4);
	}
	
}
