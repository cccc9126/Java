public class Main {
    public static void main(String[] args) {

        GameCharacter[] characters = new GameCharacter[3];

        characters[0] = new Warrior("Thor", 120, 25, 5);
        characters[1] = new Mage("Merlin", 80, 20, 60);

        // Anonymous Class Goblin
        characters[2] = new GameCharacter("Goblin", 50, 0) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("Goblin cắn trộm gây 10 sát thương");
                target.takeDamage(10);
            }
        };

        System.out.println("=== BẮT ĐẦU TRẬN ĐẤU ===");

        // Cho từng nhân vật tấn công người bên cạnh
        for (int i = 0; i < characters.length; i++) {

            if (characters[i] != null && characters[i].isAlive()) {

                int next = (i + 1) % characters.length;

                if (characters[next] != null && characters[next].isAlive()) {
                    characters[i].attack(characters[next]);
                }
            }
        }

        System.out.println("\n=== DÙNG CHIÊU CUỐI ===");

        ((ISkill) characters[0]).useUltimate(characters[2]);
        ((ISkill) characters[1]).useUltimate(characters[0]);

        System.out.println("\n=== TRẠNG THÁI CUỐI ===");

        System.out.println("Tổng nhân vật: " + GameCharacter.count);

        for (int i = 0; i < characters.length; i++) {
            System.out.println("------");
            characters[i].showStatus();
        }
    }
}