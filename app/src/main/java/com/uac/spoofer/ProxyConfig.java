package com.uac.spoofer;

import org.json.JSONObject;

public class ProxyConfig {

    public String id;
    public String name;
    public String address;
    public String fallbackAddress;
    public int port;
    public String sni;
    public String method;
    public String sourceUri;
    public String protocol;
    public String configHost;
    public int configPort;
    public boolean lastPingOk;
    public double lastPingMs;
    public String origin;

    public ProxyConfig() {}

    public static ProxyConfig fromJson(JSONObject json) {
        ProxyConfig c = new ProxyConfig();
        c.id = json.optString("id");
        c.name = json.optString("name");
        c.address = json.optString("address");
        c.fallbackAddress = json.optString("fallbackAddress");
        c.port = json.optInt("port");
        c.sni = json.optString("sni");
        c.method = json.optString("method");
        c.sourceUri = json.optString("sourceUri");
        c.protocol = json.optString("protocol");
        c.configHost = json.optString("configHost");
        c.configPort = json.optInt("configPort");
        c.origin = json.optString("origin");
        return c;
    }
}
