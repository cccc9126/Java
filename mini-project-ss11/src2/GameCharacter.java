public abstract class GameCharacter {

    protected String name;
    protected int hp;
    protected int attackPower;

    public static int count = 0;

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count++;
    }

    // Phương thức tấn công (bắt buộc lớp con phải định nghĩa)
    public abstract void attack(GameCharacter target);

    // Nhận sát thương
    public void takeDamage(int damage) {
        hp = hp - damage;

        if (hp <= 0) {
            hp = 0;
            System.out.println(name + " đã bị hạ gục!");
        }
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void showStatus() {
        System.out.println("Tên: " + name);
        System.out.println("HP: " + hp);
    }
}