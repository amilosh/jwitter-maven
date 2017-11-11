package by.it.milosh.RESTmodel;

/**
 * Created by USER on 11.11.2017.
 */
public class Response {
    private String message;

    public Response() {
    }

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
