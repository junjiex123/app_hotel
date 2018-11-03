package android.app.hotel.model.introduce;

public class IntroduceLayout {
    private String title;

    private boolean isGroupHeader = false;

    public IntroduceLayout() {
        isGroupHeader = true;
    }

    public IntroduceLayout(String title) {
        super();
        this.title = title;
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
