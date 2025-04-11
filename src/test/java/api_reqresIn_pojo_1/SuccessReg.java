package api_reqresIn_pojo_1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



public class SuccessReg {
    private Integer id;
    private String token;

    public SuccessReg() {
    }

    @JsonCreator
    public SuccessReg(@JsonProperty("id") int id, @JsonProperty("token") String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
