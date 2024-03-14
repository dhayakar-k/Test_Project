package observer_design_pattern;

public enum NodeModificationCommand {

    ADD_OPERATION(0),
    DELETE_OPERATION(1),
    EDIT_OPERATION(2),
    NODE_CONNECTIVITY_LOST(3),
    NODE_CONNECTIVITY_RECOVERED(4);

    NodeModificationCommand(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

}
