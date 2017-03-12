package su.ogorodov.models.pojo;

public class Level {
    private Integer id = null;
    private String access;

    public Integer getId() {
        return id;
    }

    public String getAccess(){
        return access;
    }

    public void setId(int id){
        this.id = id;
    }


    public void setAccess(String access){
        this.access = access;
    }

}
