package ra.dto.response;

public class ResponseMassage {
    private String massage;

    public ResponseMassage() {
    }

    public ResponseMassage(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
