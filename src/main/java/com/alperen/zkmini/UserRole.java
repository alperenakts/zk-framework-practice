package com.alperen.zkmini;

public class UserRole {

    private String name;
    private RoleType role;

    public UserRole(String name, RoleType role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public RoleType getRole() {
        return role;
    }

    // Aynı kişi + aynı rol kontrolü için
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole that = (UserRole) o;

        return name.equalsIgnoreCase(that.name)
                && role == that.role;
    }

    @Override
    public int hashCode() {
        return (name.toLowerCase() + role.name()).hashCode();

    }
}
