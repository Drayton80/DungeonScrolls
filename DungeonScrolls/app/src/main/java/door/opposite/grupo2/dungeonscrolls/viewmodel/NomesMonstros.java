package door.opposite.grupo2.dungeonscrolls.viewmodel;

import java.util.ArrayList;

public class NomesMonstros {

    private String nome;
    private String nd;

    public NomesMonstros(String nome, String nd) {
        this.nome = nome;
        this.nd = nd;
    }

    public String[] retornaMonstros(){
        String nomes = "Manticore\n" +
                "Aboleth\n" +
                "Abyssal Greater Basilisk\n" +
                "Athach\n" +
                "Androsphinx\n" +
                "Annis\n" +
                "Air Elemental(Large)\n" +
                "Air Elemental(Medium)\n" +
                "Air Elemental(Small)\n" +
                "Achaierai\n" +
                "Tojanida(Adult)\n" +
                "Air Mephit\n" +
                "Arrowhawk(Juvenile)\n" +
                "Arrowhawk(Adult)\n" +
                "Arrowhawk(Elder)\n" +
                "Astral Deva\n" +
                "Water Elemental(Large)\n" +
                "Water Elemental(Medium)\n" +
                "Water Elemental(Small)\n" +
                "Fire Elemental(Large)\n" +
                "Fire Elemental(Medium)\n" +
                "Fire Elemental(Small)\n" +
                "Earth Elemental(Large)\n" +
                "Earth Elemental(Medium)\n" +
                "Earth Elemental(Small)\n" +
                "Invisible Stalker\n" +
                "Magmin\n" +
                "Belker\n" +
                "Thoqqua\n" +
                "Crysmal\n" +
                "Ankheg\n" +
                "Average Salamander\n" +
                "Aranea\n" +
                "Black Pudding\n" +
                "Assassin Vine\n" +
                "Avoral\n" +
                "Azer\n" +
                "Babau\n" +
                "Balor\n" +
                "Barbed Devil(Hamatula)\n" +
                "Barghest\n" +
                "Bearded Devil(Barbazu)\n" +
                "Bebilith\n" +
                "Cloud Giant\n" +
                "Ettin\n" +
                "Fire Giant\n" +
                "Frost Giant\n" +
                "Half-Giant\n" +
                "Hill Giant\n" +
                "Merrow\n" +
                "Ogre Mage\n" +
                "Ogre\n" +
                "Scrag\n" +
                "Stone Giant\n" +
                "Storm Giant\n" +
                "Troll\n" +
                "Behemoth Eagle\n" +
                "Behemoth Gorilla\n" +
                "Bone Devil(Osyluth)\n" +
                "Bralani\n" +
                "Cauchemar Nightmare\n" +
                "Cerebrilith\n" +
                "Chain Devil(Kyton)\n" +
                "Chaos Beast\n" +
                "Chichimec\n" +
                "Couatl\n" +
                " Monstrous Centipede(Medium)\n" +
                " Monstrous Centipede(Large)\n" +
                "Dryad\n" +
                "Grig\n" +
                "Hoary Hunter\n" +
                "Hoary Steed\n" +
                "Leshay\n" +
                "Nixie\n" +
                "Nymph\n" +
                "Pixie\n" +
                "Satyr\n" +
                " Monstrous Centipede(Colossal)\n" +
                "Centaur\n" +
                "Elder Black Pudding\n" +
                "Gelatinous Cube\n" +
                "Phantom Fungus\n" +
                "Shambling Mound\n" +
                "Basilisk\n" +
                "Behir\n" +
                "Bugbear\n" +
                "Gnoll\n" +
                "Locathah\n" +
                "Lizardfolk\n" +
                "Ooze Mephit\n" +
                "Phaethon\n" +
                "Phane\n" +
                "Pit Fiend\n" +
                "Planetar\n" +
                "Troglodyte\n" +
                "Bullywug\n" +
                "Orc[Warrior lvl1]\n" +
                "Goblin[Warrior lvl1]\n" +
                "Kobold[Warrior lvl1]\n" +
                "Hobgoblin[Warrior lvl1]\n" +
                "Giant Bee\n" +
                "Mohrg\n" +
                "Wraith\n" +
                "Giant Ant(Worker)\n" +
                "Allip\n" +
                "Atropal\n" +
                "Giant Ant(Soldier)\n" +
                "Giant Ant(Queen)\n" +
                "Bodak\n" +
                "Derro\n" +
                "Caller In Darkness\n" +
                "Demilich\n" +
                "Devourer\n" +
                "Dread Wraith\n" +
                "Ghast\n" +
                "Ghoul\n" +
                "Hunefer\n" +
                "Lacedon\n" +
                "Lavawight\n" +
                "Mummy\n" +
                "Nightcrawler\n" +
                "Nightwalker\n" +
                "Cloaker\n" +
                "Choker\n" +
                "Dark Naga\n" +
                "Destrachan\n" +
                "Ettercap\n" +
                "Ethereal Filcher\n" +
                "Gibbering Mouther\n" +
                "Grick\n" +
                "Guardian Naga\n" +
                "Mimic\n" +
                "Phasm\n" +
                "Spirit Naga\n" +
                "Water Naga\n" +
                "Ape\n" +
                "Black Bear\n" +
                "Brown Bear\n" +
                "Boar\n" +
                "Crocodile\n" +
                "Donkey\n" +
                "Eagle\n" +
                "Elephant\n" +
                "Giant Crocodile\n" +
                "Giant Octopus\n" +
                "Hawk\n" +
                "Heavy Warhorse\n" +
                "Leopard\n" +
                "Lion\n" +
                "Megaraptor\n" +
                "Nightwing\n" +
                "Shadow\n" +
                "Greater Shadow\n" +
                "Shadow of the Void\n" +
                "Shape of Fire\n" +
                "Spectre\n" +
                "Vampire Spawn\n" +
                "Wight\n" +
                "Winterwight\n" +
                "Pseudonatural Troll\n" +
                "Couatl(Psionic)\n" +
                "Quasit\n" +
                "Rakhasa\n" +
                "Rast\n" +
                "Ravid\n" +
                "Bat\n" +
                "Deinonychus\n" +
                "Monkey\n" +
                "Mule\n" +
                "Hyena\n" +
                "Octopus\n" +
                "Owl\n" +
                "Rat\n" +
                "Raven\n" +
                "Rhinoceros\n" +
                "Roc\n" +
                "Tiger\n" +
                "Triceratops\n" +
                "Tyrannosaurus\n" +
                "Badger\n" +
                "Monitor Lizard\n" +
                "Weasel\n" +
                "Orca\n" +
                "Wolf\n" +
                "Wolverine\n" +
                "Lizard\n" +
                "Clay Golem\n" +
                "Flesh Golem\n" +
                "Homunculus\n" +
                "Iron Golem\n" +
                "Kolyarut\n" +
                "Marut\n" +
                "Retriever\n" +
                "Shield Guardian\n" +
                "Stone Golem\n" +
                "Zelekhut\n" +
                "Uvuudaum\n" +
                "Vargouille\n" +
                "Vrock\n" +
                "Water Mephit\n" +
                "Xill\n" +
                "Blink Dog\n" +
                "Brachyurus\n" +
                "Brain Mole\n" +
                "Bulette\n" +
                "Celestial Charger[Cleric lvl7]\n" +
                "Xixecal\n" +
                "Xorn(Minor)\n" +
                "Xorn(Average)\n" +
                "Xorn(Elder)\n" +
                "Yeth Hound\n" +
                "Doppelganger\n" +
                "Dromite\n" +
                "Gargoyle\n" +
                "Gloom\n" +
                "Green Hag\n" +
                "Grimlock\n" +
                "Mu Spore\n" +
                "Tendriculos\n" +
                "Treant\n" +
                "Shrieker\n" +
                "Udoroot\n" +
                "Violet Fungus\n" +
                "Red Dragon(Wyrmling)\n" +
                "Red Dragon(Very young)\n" +
                "Red Dragon(Young)\n" +
                "Red Dragon(Juvenile)\n" +
                "Red Dragon(Young adult )\n" +
                "Red Dragon(Adult)\n" +
                "Red Dragon(Mature adult)\n" +
                "Red Dragon(Old)\n" +
                "Red Dragon(Very old)\n" +
                "Red Dragon(Ancient)\n" +
                "Red Dragon(Wyrm)\n" +
                "Red Dragon(Great wyrm)\n" +
                "Black Dragon(Wyrmling)\n" +
                "Black Dragon(Very young)\n" +
                "Black Dragon(Young)\n" +
                "Black Dragon(Juvenile)\n" +
                "Black Dragon(Young adult )\n" +
                "Black Dragon(Adult)\n" +
                "Black Dragon(Mature adult)\n" +
                "Black Dragon(Old)\n" +
                "Black Dragon(Very old)\n" +
                "Black Dragon(Ancient)\n" +
                "Black Dragon(Wyrm)\n" +
                "Black Dragon(Great wyrm)\n" +
                "Brass Dragon(Wyrmling)\n" +
                "Brass Dragon(Very young)\n" +
                "Brass Dragon(Young)\n" +
                "Brass Dragon(Juvenile)\n" +
                "Brass Dragon(Young adult )\n" +
                "Brass Dragon(Adult)\n" +
                "Brass Dragon(Mature adult)\n" +
                "Brass Dragon(Old)\n" +
                "Brass Dragon(Very old)\n" +
                "Brass Dragon(Ancient)\n" +
                "Brass Dragon(Wyrm)\n" +
                "Brass Dragon(Great wyrm)\n" +
                "Gold Dragon(Wyrmling)\n" +
                "Gold Dragon(Very young)\n" +
                "Gold Dragon(Young)\n" +
                "Gold Dragon(Juvenile)\n" +
                "Gold Dragon(Young adult )\n" +
                "Gold Dragon(Adult)\n" +
                "Gold Dragon(Mature adult)\n" +
                "Gold Dragon(Old)\n" +
                "Gold Dragon(Very old)\n" +
                "Gold Dragon(Ancient)\n" +
                "Gold Dragon(Wyrm)\n" +
                "Gold Dragon(Great wyrm)";

        String[] nomesArray = nomes.split("\n");
        return nomesArray;    }



        public String[] retornaNdMonstros(){
            String nds = "5\n" +
                    "7\n" +
                    "12\n" +
                    "8\n" +
                    "9\n" +
                    "6\n" +
                    "5\n" +
                    "3\n" +
                    "1\n" +
                    "5\n" +
                    "5\n" +
                    "3\n" +
                    "3\n" +
                    "5\n" +
                    "8\n" +
                    "14\n" +
                    "5\n" +
                    "3\n" +
                    "1\n" +
                    "5\n" +
                    "3\n" +
                    "1\n" +
                    "5\n" +
                    "3\n" +
                    "1\n" +
                    "7\n" +
                    "3\n" +
                    "6\n" +
                    "2\n" +
                    "3\n" +
                    "3\n" +
                    "6\n" +
                    "4\n" +
                    "7\n" +
                    "3\n" +
                    "9\n" +
                    "2\n" +
                    "6\n" +
                    "20\n" +
                    "11\n" +
                    "4\n" +
                    "5\n" +
                    "10\n" +
                    "12\n" +
                    "6\n" +
                    "10\n" +
                    "9\n" +
                    "1\n" +
                    "7\n" +
                    "3\n" +
                    "8\n" +
                    "3\n" +
                    "5\n" +
                    "8\n" +
                    "13\n" +
                    "5\n" +
                    "18\n" +
                    "19\n" +
                    "9\n" +
                    "6\n" +
                    "11\n" +
                    "10\n" +
                    "6\n" +
                    "7\n" +
                    "21\n" +
                    "10\n" +
                    "0.5\n" +
                    "1\n" +
                    "3\n" +
                    "1\n" +
                    "25\n" +
                    "9\n" +
                    "28\n" +
                    "1\n" +
                    "7\n" +
                    "4\n" +
                    "2\n" +
                    "9\n" +
                    "3\n" +
                    "12\n" +
                    "3\n" +
                    "3\n" +
                    "6\n" +
                    "5\n" +
                    "8\n" +
                    "2\n" +
                    "1\n" +
                    "0.5\n" +
                    "1\n" +
                    "3\n" +
                    "34\n" +
                    "25\n" +
                    "20\n" +
                    "16\n" +
                    "1\n" +
                    "1\n" +
                    "0.5\n" +
                    "0.33\n" +
                    "0.25\n" +
                    "0.50\n" +
                    "1\n" +
                    "8\n" +
                    "5\n" +
                    "1\n" +
                    "3\n" +
                    "30\n" +
                    "2\n" +
                    "2\n" +
                    "8\n" +
                    "3\n" +
                    "9\n" +
                    "29\n" +
                    "11\n" +
                    "11\n" +
                    "3\n" +
                    "1\n" +
                    "25\n" +
                    "1\n" +
                    "23\n" +
                    "5\n" +
                    "18\n" +
                    "16\n" +
                    "5\n" +
                    "2\n" +
                    "8\n" +
                    "8\n" +
                    "3\n" +
                    "3\n" +
                    "5\n" +
                    "3\n" +
                    "10\n" +
                    "4\n" +
                    "7\n" +
                    "9\n" +
                    "7\n" +
                    "2\n" +
                    "2\n" +
                    "4\n" +
                    "2\n" +
                    "2\n" +
                    "0.17\n" +
                    "0.5\n" +
                    "7\n" +
                    "4\n" +
                    "8\n" +
                    "0.34\n" +
                    "2\n" +
                    "2\n" +
                    "3\n" +
                    "6\n" +
                    "14\n" +
                    "3\n" +
                    "8\n" +
                    "26\n" +
                    "26\n" +
                    "7\n" +
                    "4\n" +
                    "3\n" +
                    "23\n" +
                    "21\n" +
                    "10\n" +
                    "2\n" +
                    "10\n" +
                    "5\n" +
                    "5\n" +
                    "0.1\n" +
                    "3\n" +
                    "0.17\n" +
                    "1\n" +
                    "1\n" +
                    "1\n" +
                    "0.25\n" +
                    "0.12\n" +
                    "0.17\n" +
                    "4\n" +
                    "9\n" +
                    "4\n" +
                    "9\n" +
                    "8\n" +
                    "0.5\n" +
                    "2\n" +
                    "0.25\n" +
                    "5\n" +
                    "1\n" +
                    "2\n" +
                    "0.17\n" +
                    "10\n" +
                    "7\n" +
                    "1\n" +
                    "13\n" +
                    "12\n" +
                    "15\n" +
                    "11\n" +
                    "8\n" +
                    "11\n" +
                    "9\n" +
                    "27\n" +
                    "2\n" +
                    "9\n" +
                    "3\n" +
                    "6\n" +
                    "2\n" +
                    "23\n" +
                    "8\n" +
                    "7\n" +
                    "13\n" +
                    "36\n" +
                    "3\n" +
                    "6\n" +
                    "8\n" +
                    "3\n" +
                    "3\n" +
                    "0.5\n" +
                    "4\n" +
                    "25\n" +
                    "5\n" +
                    "1\n" +
                    "21\n" +
                    "6\n" +
                    "8\n" +
                    "1\n" +
                    "5\n" +
                    "3\n" +
                    "4\n" +
                    "5\n" +
                    "7\n" +
                    "10\n" +
                    "13\n" +
                    "15\n" +
                    "18\n" +
                    "20\n" +
                    "21\n" +
                    "23\n" +
                    "24\n" +
                    "26\n" +
                    "3\n" +
                    "4\n" +
                    "5\n" +
                    "7\n" +
                    "9\n" +
                    "11\n" +
                    "14\n" +
                    "16\n" +
                    "18\n" +
                    "19\n" +
                    "20\n" +
                    "22\n" +
                    "3\n" +
                    "4\n" +
                    "6\n" +
                    "8\n" +
                    "10\n" +
                    "12\n" +
                    "15\n" +
                    "17\n" +
                    "19\n" +
                    "20\n" +
                    "21\n" +
                    "23\n" +
                    "5\n" +
                    "7\n" +
                    "9\n" +
                    "11\n" +
                    "14\n" +
                    "16\n" +
                    "19\n" +
                    "21\n" +
                    "22\n" +
                    "24\n" +
                    "25\n" +
                    "27";

            String[] ndsArray = nds.split("\n");
            return ndsArray;
        }

        public ArrayList<NomesMonstros> objetosMonstros(){
            ArrayList<NomesMonstros> nomesMonstros = new ArrayList<NomesMonstros>();

            String[] nomesArray = retornaMonstros();
            String[] ndsArray = retornaNdMonstros();
            for(int i = 0;i < nomesArray.length; i++){
                nomesMonstros.add(new NomesMonstros(nomesArray[i], ndsArray[i]));
            }

            return nomesMonstros;
        }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }
}
