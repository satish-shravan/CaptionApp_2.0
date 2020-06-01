package shayari.world.allinonecaptionapp;

public class upload {
    String url;

    upload()
    {

    }

    public upload(String url) {
        this.url = url;
    }

    // Getter is always public , otherwise it won't allow user to call it.
    public String getUrl()
    {
        return url;
    }



}
