
class NameTag {
    private final String firstName;
    private final String lastName;

    NameTag(String fullName) {
        String[] name = fullName.split(" ");
        firstName = name[0];
        lastName = name[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");

        System.out.println(tag.getNickname());
    }
}
