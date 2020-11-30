package com.test.zoom;

public interface AuthConstants {

	// TODO Change it to your web domain
	public final static String WEB_DOMAIN = "zoom.us";

	public final static String API_KEY = "vm8Ri0Vrqc8nkS13fqp0DADJRGgwM6lKt5lp";
	public final static String API_SECRET = "AcHoLsZwikUuXJTCjSJP8VwcsALEJ43GrhF6";

	/**
	 * We recommend that, you can generate jwttoken on your own server instead of hardcore in the code.
	 * We hardcore it here, just to run the demo.
	 *
	 * You can generate a jwttoken on the https://jwt.io/
	 * with this payload:
	 * {
	 *
	 *     "appKey": "string", // app key
	 *     "iat": long, // access token issue timestamp
	 *     "exp": long, // access token expire time
	 *     "tokenExp": long // token expire time
	 * }
	 */
//	public final static String SDK_JWTTOKEN = JWT_TOKEN;

}
