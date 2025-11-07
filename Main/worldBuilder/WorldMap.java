package Main.worldBuilder;

import Main.character.enemy.Enemy;
import Main.character.player.Player;
import Main.character.Character;
import Main.character.enemy.subclasses.*;

public class WorldMap {

    public static Town buildWestPath() {
        Town lucban = new Town("Lucban", "A vibrant town famous for the Pahiyas Festival.",
                new Enemy[]{new TanimGuardian(), new HabhabBandit()}, null);

        Town lucena = new Town("Lucena", "Bustling trade center by the coast.",
                new Enemy[]{new PortRat(), new LucenaPirate()}, new HarborSentinel());
                player.setMp(player.getMaxMp());

        Town sariaya = new Town("Sariaya", "A prosperous heritage town under siege by a fearsome foe.",
                new Enemy[]{new BakeryGremlin(), new HeritageWraith()}, null);
                player.setMp(player.getMaxMp());

        Town candelaria = new Town("Candelaria", "A peaceful town where traders rest.",
                new Enemy[]{new BibingkaElemental(), new SweetVendor()}, null);
                player.setMp(player.getMaxMp());

        Town tiaong = new Town("Tiaong", "A green, fertile area full of mystery.",
                new Enemy[]{new PugonPhantom(), new TiaongKnight()}, new DonMariano());
                player.setMp(player.getMaxMp());

        // Link sequence
        lucban.setNextTown(lucena);
        lucena.setNextTown(sariaya);
        sariaya.setNextTown(candelaria);
        candelaria.setNextTown(tiaong);

        return lucban;
    }

    public static Town buildEastPath() {
        Town gumaca = new Town("Gumaca", "A riverside town known for its fishing guild.",
                new Enemy[]{new FestivalMask(), new KipingGolem()}, null);

        Town lopez = new Town("Lopez", "A quiet farming town with lush fields.",
                new Enemy[]{new SumanMimic(), new LopezWolf()}, new OldTrainSpirit());

        Town calauag = new Town("Calauag", "A historic town ruled by a fierce warlord.",
                new Enemy[]{new FisherRogue(), new SeaWidow()}, null);

        Town infanta = new Town("Infanta", "A coastal area battered by storms.",
                new Enemy[]{new ForestNymph(), new HoneyGuardian()}, null);

        Town real = new Town("Real", "The edge of the eastern world. Few return from here.",
                new Enemy[]{new WaveFiend(), new RealSpecter()}, new QueenAmihan());

        // Link sequence
        gumaca.setNextTown(lopez);
        lopez.setNextTown(calauag);
        calauag.setNextTown(infanta);
        infanta.setNextTown(real);

        return gumaca;
    }
}
