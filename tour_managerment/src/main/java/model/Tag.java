package model;

public class Tag {
    private int tag_id;
    private String name;

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag(int tag_id, String name) {
        this.tag_id = tag_id;
        this.name = name;
    }
}
