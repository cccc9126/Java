public class Mage extends GameCharacter implements ISkill {

    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {

        if (mana >= 5) {
            System.out.println(name + " tung phép gây " + attackPower + " sát thương");
            target.takeDamage(attackPower);
            mana = mana - 5;
        } else {
            int damage = attackPower / 2;
            System.out.println(name + " hết mana, gây " + damage + " sát thương");
            target.takeDamage(damage);
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {

        if (mana >= 50) {
            int damage = attackPower * 3;
            System.out.println(name + " dùng Hỏa cầu gây " + damage + " sát thương!");
            target.takeDamage(damage);
            mana = mana - 50;
        } else {
            System.out.println("Không đủ mana!");
        }
    }

    public void showStatus() {
        super.showStatus();
        System.out.println("Mana: " + mana);
    }
}