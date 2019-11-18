class Employee {

    // write fields
    protected String name;
    protected String email;
    protected int experience;

    public Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }
    // write constructor

    // write getters
}

class Developer extends Employee {

    // write fields
    private String mainLanguage;
    private String[] skills;

    public Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public String[] getSkills() {
        return skills;
    }
    // write constructor

    // write getters
}

class DataAnalyst extends Employee {

    // write fields
    private boolean isPhD;
    private String[] mlMethods;

    public DataAnalyst(String name, String email, int experience, boolean isPhD, String[] mlMethods) {
        super(name, email, experience);
        this.isPhD = isPhD;
        this.mlMethods = mlMethods;
    }

    public boolean isPhD() {
        return isPhD;
    }

    public String[] getMethods() {
        return mlMethods;
    }
    // write constructor

    // write getters
}