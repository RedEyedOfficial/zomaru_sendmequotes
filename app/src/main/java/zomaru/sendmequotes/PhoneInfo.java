package zomaru.sendmequotes;


public class PhoneInfo {
    private String Title;
    private String Subtitle;

    public PhoneInfo(String Title, String Subtitle) {
        this.Title = Title;
        this.Subtitle = Subtitle;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getSubtitle() {
        return Subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.Subtitle = subtitle;
    }
}
