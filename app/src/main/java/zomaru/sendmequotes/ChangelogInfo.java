package zomaru.sendmequotes;

/**
 * Created by root on 4/2/18.
 */

public class ChangelogInfo {
    private CharSequence Title;
    private CharSequence Subtitle;

    public ChangelogInfo(CharSequence Title, CharSequence Subtitle) {
        this.Title = Title;
        this.Subtitle = Subtitle;
    }

    public CharSequence getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public CharSequence getSubtitle() {
        return Subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.Subtitle = subtitle;
    }
}

