package kmitl.lab07.benjarat58070079.mylazyinstagram.model;


import java.util.List;

//4.create class for get object
public class Userprofile {

    public List<ListPosts> posts;
    private String user;
    private String urlProfile;
    private String bio;
    private int follower;
    private int following;
    private int post;

    public List<ListPosts> getPosts() {
        return posts;
    }

    public void setPosts(List<ListPosts> posts) {
        this.posts = posts;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUrlProfile() {
        return urlProfile;
    }

    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }
}
