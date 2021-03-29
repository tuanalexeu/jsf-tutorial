package book.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class TreeNodeBean {

    private GenericTreeNode root = new GenericTreeNode("Players",
            new GenericTreeNode("Rafael Nadal",
            new GenericTreeNode("2013", new GenericTreeNode("Roland Garros", new GenericTreeNode("Winner")), new GenericTreeNode("Wimbledon", new GenericTreeNode("First round"))),
            new GenericTreeNode("2014", new GenericTreeNode("..."))),
            new GenericTreeNode("Roger Federer",
            new GenericTreeNode("2013"), new GenericTreeNode("...")));

    public GenericTreeNode getRoot() {
        return root;
    }
}
