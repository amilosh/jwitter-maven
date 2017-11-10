package by.it.milosh.enumeration;

public enum RoleEnum {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String name;

    private RoleEnum(String type) {
        this.name = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
