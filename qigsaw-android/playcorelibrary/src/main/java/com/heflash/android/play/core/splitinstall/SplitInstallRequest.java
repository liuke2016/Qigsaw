package com.heflash.android.play.core.splitinstall;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SplitInstallRequest {

    private final List<String> moduleNames;
    private final List<Locale> languages;


    public static SplitInstallRequest.Builder newBuilder() {
        return new SplitInstallRequest.Builder();
    }

    private SplitInstallRequest(Builder builder) {
        this.moduleNames = new ArrayList<>(builder.moduleNames);
        this.languages = new ArrayList<>(builder.languages);
    }

    /**
     * Get requested modules.
     */
    public List<String> getModuleNames() {
        return moduleNames;
    }

    /**
     * Get requested languages.
     */
    public List<String> getLanguages() {
        List<String> languages = new ArrayList<>();
        for(Locale locale:this.languages){
            languages.add(locale.getLanguage());
        }
        return languages;
    }

    public String toString() {
        String var1 = String.valueOf(this.moduleNames);
        return (new StringBuilder(34 + String.valueOf(var1).length())).append("SplitInstallRequest{modulesNames=").append(var1).append("}").toString();
    }

    /**
     * A builder for a request to install some splits.
     */
    public static class Builder {

        private final List<String> moduleNames;
        private final List<Locale> languages;

        private Builder() {
            this.moduleNames = new ArrayList<>();
            this.languages = new ArrayList<>();
        }

        public Builder addModule(String moduleName) {
            this.moduleNames.add(moduleName);
            return this;
        }

        public Builder addLanguage(Locale language) {
            this.languages.add(language);
            return this;
        }

        public SplitInstallRequest build() {
            return new SplitInstallRequest(this);
        }
    }
}
