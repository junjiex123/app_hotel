package android.app.hotel.model.more;

public class MoreLayout {
    private int icon;
    private String title;

    private boolean isGroupHeader = false;

    public MoreLayout() {
        isGroupHeader = true;
    }

    public MoreLayout(int icon, String title) {
        super();
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isGroupHeader() {
        return isGroupHeader;
    }

    public void setGroupHeader(boolean groupHeader) {
        isGroupHeader = groupHeader;
    }
}
