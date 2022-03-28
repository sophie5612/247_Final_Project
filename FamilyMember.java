import java.util.UUID;

public class FamilyMember {
    
    private UUID uuid;
    private String name;
    private String DOB;

    public FamilyMember(UUID uuid, String name, String DOB) {
        this.uuid = uuid;
        this.name = name;
        this.DOB = DOB;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDOB() {
        return DOB;
    }

}
