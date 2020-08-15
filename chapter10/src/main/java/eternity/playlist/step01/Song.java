package eternity.playlist.step01;

/**
 * 부모 클래스와 자식 클래스의 동시 수정 문제
 */
public class Song {
    private String singer;
    private String title;

    public Song(String singer, String title) {
        this.singer = singer;
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public String getTitle() {
        return title;
    }
}
