package dto;

public class Pageable {
    private String search;
    private int page;
    private int totalItems =5;
    private int totalPage;
    private String nameField;

    public String getNameField() {
        return nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    private String sortBy;

    public String getSearch() {
        return search;
    }

    public Pageable(String search, int page, int totalItems) {
        this.search = search;
        this.page = page;
        this.totalItems = totalItems;
    }

    public Pageable(String search, int page, int totalItems, String nameField, String sortBy) {
        this.search = search;
        this.page = page;
        this.totalItems = totalItems;
        this.nameField = nameField;
        this.sortBy = sortBy;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Pageable(String search, int page, int totalItems, int totalPage) {
        this.search = search;
        this.page = page;
        this.totalItems = totalItems;
        this.totalPage = totalPage;
    }
}
