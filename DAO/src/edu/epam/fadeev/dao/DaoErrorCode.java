package edu.epam.fadeev.dao;

public enum DaoErrorCode {
    EXC_DAO_000("Can not get by id=%s"),
    EXC_DAO_001("Can not get all list"),
    EXC_DAO_002("Can not save object %s"),
    EXC_DAO_003("Can not update object %s"),
    EXC_DAO_004("Can not delete object %s");
    private final String value;

    private DaoErrorCode(String s) {
        value = s;
    }

    public boolean equalsValue(String value2) {
        return (value2 == null) ? false : value.equals(value2);
    }

    public String toString() {
        return value;
    }
}
