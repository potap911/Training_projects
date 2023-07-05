package org.example;

import java.io.File;
import java.util.ArrayList;

public class Node {
    private File folder;
    private ArrayList<Node> children;
    private long sise;
    private long sizeLimit;
    private int level;
    public Node(File folder) {
        this.folder = folder;
        children = new ArrayList<>();
    }
    public Node(File folder, long sizeLimit) {
        this.folder = folder;
        children = new ArrayList<>();
    }
    public File getFolder() {
        return folder;
    }
    public void addChild(Node node) {
        node.setLevel(level + 1);
        node.setSizeLimit(sizeLimit);
        children.add(node);
    }
    public ArrayList<Node> getChildren() {
        return children;
    }

    public long getSise() {
        return sise;
    }

    public long getSizeLimit() {
        return sizeLimit;
    }

    public void setSise(long sise) {
        this.sise = sise;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public void setSizeLimit(long sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (sise > sizeLimit) {
            builder.append(folder.getName() + " - " + sise + "\n");
            for (Node child : children) {
                builder.append("  ".repeat(level) + child.toString());
            }
        }
            return builder.toString();
        }

}
