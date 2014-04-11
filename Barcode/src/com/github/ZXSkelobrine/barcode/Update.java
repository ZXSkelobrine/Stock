package com.github.ZXSkelobrine.barcode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Update {
	public static void updateCheck(double currentVersion) throws MalformedURLException, IOException {
		String paste = saveUrl("http://pastebin.com/raw.php?i=xshXJRCL");
		String[] split = paste.split("\\s+");
		String version = split[0];
		String address = split[1];
		double d_version = Double.parseDouble(version);
		if (d_version > currentVersion) {
			new UpdateWindow(version, address);
		}
	}

	public static String saveUrl(final String urlString) throws MalformedURLException, IOException {
		BufferedInputStream in = null;
		StringBuilder sb = new StringBuilder();
		try {
			in = new BufferedInputStream(new URL(urlString).openStream());
			final byte data[] = new byte[1024];
			@SuppressWarnings("unused")
			int count;
			while ((count = in.read(data, 0, 1024)) != -1) {
				sb.append(new String(data));
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return sb.toString();
	}
}
