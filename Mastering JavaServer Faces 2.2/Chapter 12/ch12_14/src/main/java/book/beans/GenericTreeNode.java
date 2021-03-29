package book.beans;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Leonard
 */
public class GenericTreeNode {

    private final List<GenericTreeNode> descendants;
    private final String label;

    public GenericTreeNode(String label, GenericTreeNode... descendants) {
        this.label = label;
        this.descendants = Arrays.asList(descendants);
    }

    public boolean isHasDescendants() {
        return !descendants.isEmpty();
    }

    public List<GenericTreeNode> getDescendants() {
        return descendants;
    }

    public String getLabel() {
        return label;
    }
}
