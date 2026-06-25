package com.uac.spoofer;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ProfileStore {

    private static final String PREFS = "wirexnet_profile";
    private static final String KEY_PROFILES = "profiles";
    private static final String KEY_SELECTED = "selected";

    // کانفیگ ثابت
    private static final String FIXED_CONFIG =
            "vless://4d23d1cf-d2b8-6791-d748-3bf623f91561@127.0.0.1:40443?path=%2Fsub&security=tls&encryption=none&insecure=0&fp=chrome&type=ws&allowInsecure=0#🇺🇸USA";

    private final SharedPreferences prefs;

    public ProfileStore(Context context) {
        prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    // فقط یک پروفایل ثابت برمی‌گردد
    public List<ProxyConfig> loadProfiles() {
        List<ProxyConfig> list = new ArrayList<>();
        ProxyConfig cfg = VlessParser.parseOne(FIXED_CONFIG);

        if (cfg != null) {
            cfg.name = "WireXnet";
            cfg.origin = "builtin";
            list.add(cfg);
        }

        return list;
    }

    // ذخیره‌سازی غیر فعال می‌شود
    public void saveProfiles(List<ProxyConfig> profiles) {
        // هیچ کاری انجام نمی‌شود
    }

    public String getSelectedId(List<ProxyConfig> profiles) {
        if (profiles.isEmpty()) return "";
        return profiles.get(0).id;
    }

    public void setSelectedId(String id) {
        prefs.edit().putString(KEY_SELECTED, id).apply();
    }
}
