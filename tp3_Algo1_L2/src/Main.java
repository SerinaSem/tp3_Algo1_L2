import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Spécifié le sac a utiliser (sac0 pour la partie1 et les autres pour la partie2)
        Instance instance = LectureInstance.lireFichier("instances/sac1.txt");

        // Pour test : afficher capacité et objets
        /*System.out.println("Capacite : " + instance.capacite);
        for (Objet o : instance.objets) {
            System.out.println("Poids: " + o.poids + ", Valeur: " + o.valeur);
        }*/

        //Partie 1 : Backtracking
        /*int valeurMax = SacADosExhaustif.resoudre(instance);
        System.out.println("Valeur maximale (exhaustif) : " + valeurMax);*/

        //Partie 2 : Programmation Dynamique 
        /*int valeurMaxDyn = SacADosDynamique.resoudre(instance);
        System.out.println("Valeur maximale (dynamique) : " + valeurMaxDyn);*/

        //+++: version optimisée du dynamique avec tableau 1D 
        long start = System.currentTimeMillis();
        int valeurOpt = SacADosDynamiqueOpt.resoudre(instance);
        long end = System.currentTimeMillis();

        System.out.println("Valeur maximale (dynamique optimisee) : " + valeurOpt);
        System.out.println("Temps d'execution : " + (end - start) + " ms");


    }
}
