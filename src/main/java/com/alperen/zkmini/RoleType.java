package com.alperen.zkmini;

public enum RoleType {
    ARASTIRMACI("Araştırmacı"),
    BURSIYER("Bursiyer");

    private final String label;

    RoleType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
