package observer_design_pattern;

public interface NodeStatusObserver {

    boolean update(NodeModificationCommand nodeModificationCommand);
}
