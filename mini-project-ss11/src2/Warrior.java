public class Warrior extends GameCharacter implements ISkill {

    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " tấn công gây " + attackPower + " sát thương");
        target.takeDamage(attackPower);
    }

    @Override
    public void takeDamage(int damage) {
        int realDamage = damage - armor;

        if (realDamage < 0) {
            realDamage = 0;
        }

        hp = hp - realDamage;

        if (hp <= 0) {
            hp = 0;
            System.out.println(name + " đã bị hạ gục!");
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {
        int damage = attackPower * 2;
        System.out.println(name + " dùng Đấm ngàn cân gây " + damage + " sát thương!");
        target.takeDamage(damage);

        hp = hp - (hp / 10); // mất 10% HP
    }

    public void showStatus() {
        super.showStatus();
        System.out.println("Armor: " + armor);
    }
}