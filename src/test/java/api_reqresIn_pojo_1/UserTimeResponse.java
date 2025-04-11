package api_reqresIn_pojo_1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // Исключает null-поля при сериализации
public class UserTimeResponse {

    private String name;
    private String job;
    private String updatedAt;

    public UserTimeResponse() {
    }

    @JsonCreator
    public UserTimeResponse(
            @JsonProperty("name") String name,
            @JsonProperty("job") String job,
            @JsonProperty("updatedAt") String updatedAt
    ) {
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("job")
    public String getJob() {
        return job;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
