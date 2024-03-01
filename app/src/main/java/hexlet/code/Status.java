package hexlet.code;

public final class Status {
    private final Object oldValue;
    private final Object newValue;
    private final String statusKey;

    public Status(Object oldValue, Object newValue, String status) {
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.statusKey = status;
    }
    public Object getOldValue() {
        return oldValue;
    }
    public Object getNewValue() {
        return newValue;
    }
    public String getStatusKey() {
        return statusKey;
    }

}
