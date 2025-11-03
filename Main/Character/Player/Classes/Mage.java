public class Mage extends Player {
   
   Mage(String name) {
    setMaxHp(45);
    setHp(45);
    setMp(35);
    setDefense(4);
    setAttackPower(10);
    setSpeed(8);
   
  	setMoves(new String[] {"1. Fire Ball (Basic + no mana required)", 
   			"2. LambaShield (Creates a barrier that reduces incoming damage by 30% for 2 turns. 10 MP)", 
            "3. Mana Surge (Regenerates 10 MP instantly.)",
            "4. Pinagong Storm (Calls down hard pinagong breads on all enemies, dealy heavy damage. 18 MP)"});
   }
}
